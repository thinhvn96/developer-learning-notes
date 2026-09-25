# Exercise 0004: add a table on startup

Companion to [lesson 4](../lessons/0004-compose-app-and-database.html).

1. Run the Compose example, then change the client command to `create table t(id int); insert into t values (1); select * from t;` (use a `psql -c` per statement or `-f`).
2. Remove `depends_on`. Run several times: does the client ever fail? What does that tell you about container start versus readiness?
3. Run `docker compose down` (without `-v`) then `up` again with a table in the database. Is the data still there? Then use `down -v` and check again. Explain the difference in terms of volumes.
