# Exercise 0006: harden a Dockerfile

[Tiếng Việt](0006-harden-a-dockerfile.vi.md)

Companion to [lesson 6](../lessons/0006-pinning-nonroot-and-signals.html).

1. Look up the digest of `eclipse-temurin:21-jre` (`docker buildx imagetools inspect eclipse-temurin:21-jre`) and pin it in `hello-java/Dockerfile`.
2. Change `CMD ["java", ...]` to shell form (`CMD java -cp . Hello`). Change the app to sleep in a loop and print on `SIGTERM` via a shutdown hook; run it, then `docker stop`. Compare exec form and shell form. Write down what you observed, not what you expected.
3. Try writing a file to `/` inside the container as user `app`. What happens and why?
