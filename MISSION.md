# Mission: Senior Java Backend Engineer (Java, OOP, Design Patterns, Docker, Kubernetes, PostgreSQL, Kafka, RabbitMQ, ELK)

## Why
The learner is a Java developer who wants to pass Senior-level interviews. That means explaining *why* things work (JVM, concurrency, query plans, scheduling) and not just using them.

## Success looks like
- Answer Senior-level Java questions out loud, with reasoning, scoped to JDK 8, 17 and 21 (collections internals, concurrency, JVM memory/GC, what each version added).
- Explain OOP fundamentals and SOLID, and recognize and apply the 22 classic design patterns, with trade-offs and modern-Java alternatives.
- Containerise a Java service with a sound Dockerfile and explain the layers, image size and JVM-in-container trade-offs.
- Deploy and debug a service on Kubernetes (Deployments, Services, probes, resource limits, rollouts).
- Design a PostgreSQL schema, read `EXPLAIN` output, choose indexes and reason about transactions and isolation.
- Explain Kafka, RabbitMQ and the ELK stack from basics to reliability guarantees, and choose between a queue and a log.
- Talk through a system-design question that combines all of the above.
- Answer each stack's interview questions (see each stack's `interview.html`) with detail and cite the source.

## Constraints
- Learns over multiple sessions; one short lesson at a time.
- Wants one dedicated folder per tech stack, each holding lessons, exercises and examples.
- Local tools present: JDK 21, Docker, psql. `kubectl` and `kind` are not installed system-wide (I ran them from a temporary directory during authoring).
- Time budget per week and interview date: not yet stated (ask next session).
- Docker is installed locally, so examples for Docker, PostgreSQL, Kafka, RabbitMQ and ELK run in throwaway containers; Kubernetes examples need a local cluster (kind or minikube).

## Out of scope
- Java versions other than 8, 17 and 21 (for example 11, and 25 beyond the LTS calendar).
- JavaFX / desktop UI.
- Non-Java backend stacks.
- Certifications (unless the learner asks later).
