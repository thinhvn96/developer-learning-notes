FROM alpine
# ARG: build-time only, not kept as a runtime variable
ARG BUILD_ID=none
# ENV: persists in the image and the running container
ENV APP_MODE=prod
# ENTRYPOINT: the executable (exec form)
ENTRYPOINT ["echo", "hello"]
# CMD: default arguments, easily overridden
CMD ["world"]
