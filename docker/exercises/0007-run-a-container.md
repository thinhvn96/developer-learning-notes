# Exercise 0007

[Tiếng Việt](0007-run-a-container.vi.md)

Run `nginx:alpine` with `-d -p 127.0.0.1::80 --name web`, find the published port with `docker port`, `curl` it, view `docker logs web`, `docker exec -it web sh`, then stop and remove it. Which of those steps deleted the container's data?
