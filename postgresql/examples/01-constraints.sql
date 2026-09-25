CREATE TABLE products (
    product_no integer PRIMARY KEY,
    name text NOT NULL,
    price numeric NOT NULL CHECK (price > 0)
);
CREATE TABLE orders (
    order_id integer PRIMARY KEY,
    product_no integer REFERENCES products ON DELETE RESTRICT,
    quantity integer NOT NULL CHECK (quantity > 0)
);
INSERT INTO products VALUES (1, 'pen', 2.50);
INSERT INTO orders VALUES (10, 1, 3);

\echo '--- each of these must fail:'
INSERT INTO products VALUES (2, 'free pen', 0);          -- CHECK
INSERT INTO products VALUES (1, 'dup', 1);               -- PRIMARY KEY
INSERT INTO orders VALUES (11, 99, 1);                   -- FOREIGN KEY
DELETE FROM products WHERE product_no = 1;               -- ON DELETE RESTRICT
INSERT INTO products VALUES (3, NULL, 1);                -- NOT NULL
