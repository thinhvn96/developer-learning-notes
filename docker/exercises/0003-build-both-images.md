# Exercise 0003: build both images

Companion to [lesson 3](../lessons/0003-multi-stage-java-image.html).

1. In `docker/examples/hello-java` build `Dockerfile.naive` as `hello-naive` and `Dockerfile` as `hello-multi`.
2. Compare sizes with `docker images`. Record both numbers.
3. Use `docker build --target build -t hello-build .` and inspect the result. What is in it that the final image does not contain?
4. Stretch: find a smaller JRE base image and measure it. Cite where you found it.
