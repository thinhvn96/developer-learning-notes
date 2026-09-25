# Exercise 0002: order the Dockerfile

Companion to [lesson 2](../lessons/0002-layer-cache-and-dockerfile-order.html).

1. In `docker/examples/hello-java`, run `docker build -t h1 .` twice. What does the second build print for each step?
2. Edit `src/Hello.java` (change the greeting) and build again. Which steps rerun, which are cached?
3. Rewrite a Dockerfile that starts with `COPY . .` so a dependency download step stays cached when only source changes. State which instruction you moved and why.
