# Exercise 0001: inspect layers

Companion to [lesson 1](../lessons/0001-containers-images-layers.html).

1. Run `docker pull eclipse-temurin:21-jre` then `docker history eclipse-temurin:21-jre`. How many layers? Which is largest?
2. Start `docker run --rm -it eclipse-temurin:21-jre bash`, create a file, exit. Start it again. Is the file there? Explain using "immutable image" and "container".
3. Compare `uname -r` on your host and inside the container. What does it tell you about kernels?
