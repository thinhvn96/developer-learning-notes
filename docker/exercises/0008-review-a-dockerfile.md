# Exercise 0008

[Tiếng Việt](0008-review-a-dockerfile.vi.md)

Find three problems in: `FROM ubuntu` / `ADD app.jar /app.jar` / `ENV DB_PASSWORD=secret` / `RUN apt-get update` / `CMD java -jar /app.jar`. Fix them (COPY vs ADD, secret handling, layers, exec form).
