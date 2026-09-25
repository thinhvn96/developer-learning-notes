-- Transactional outbox: the business row and its event are written in ONE transaction.
CREATE TABLE orders (id serial PRIMARY KEY, customer text NOT NULL, total numeric NOT NULL CHECK (total > 0));
CREATE TABLE outbox (id serial PRIMARY KEY, aggregate_id int NOT NULL, type text NOT NULL, payload jsonb NOT NULL, published boolean NOT NULL DEFAULT false);

\echo '--- success: order and event commit together'
BEGIN;
INSERT INTO orders (customer, total) VALUES ('ann', 50);
INSERT INTO outbox (aggregate_id, type, payload) VALUES (currval('orders_id_seq'), 'OrderCreated', '{"customer":"ann","total":50}');
COMMIT;

\echo '--- failure: the CHECK constraint fails, so NO event is written either'
BEGIN;
INSERT INTO orders (customer, total) VALUES ('bob', -5);
INSERT INTO outbox (aggregate_id, type, payload) VALUES (currval('orders_id_seq'), 'OrderCreated', '{"customer":"bob"}');
COMMIT;
SELECT (SELECT count(*) FROM orders) AS orders, (SELECT count(*) FROM outbox) AS outbox_rows;

\echo '--- the relay (a separate process) reads unpublished rows, sends them to the broker, then marks them published'
SELECT id, type, payload FROM outbox WHERE NOT published ORDER BY id;
-- ... publish to Kafka/RabbitMQ here; if the relay crashes before the UPDATE, the event is sent AGAIN (at-least-once) ...
UPDATE outbox SET published = true WHERE id = 1;
SELECT id, published FROM outbox ORDER BY id;
