# Multi-stage: compile in the JDK stage, run on a JRE-only image as a non-root user.
FROM eclipse-temurin:21-jdk AS build
WORKDIR /src
COPY src/ src/
RUN mkdir out && javac -d out src/Hello.java

FROM eclipse-temurin:21-jre
RUN useradd --system --uid 10001 app
WORKDIR /app
COPY --from=build /src/out/ ./
USER app
# exec form so the JVM is PID 1 and receives signals
CMD ["java", "-cp", ".", "Hello"]
