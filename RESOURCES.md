# Senior Java Backend Resources

## Knowledge

Verified this session (fetched and read):

- [Dev.java Learn (Oracle)](https://dev.java/learn/)
  Official Java tutorials: language, collections, streams, virtual threads, JVM, GC, monitoring. Use for: any core Java or JVM topic.
- [Java SE 25 API docs, `java.util.HashMap`](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/HashMap.html)
  Authoritative behaviour of HashMap. Use for: collections internals questions.
- [Java SE 25 API docs, `java.lang.Object`](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/lang/Object.html)
  The `equals` / `hashCode` contracts. Use for: object identity and equality.
- [Oracle Java SE Support Roadmap](https://www.oracle.com/java/technologies/java-se-support-roadmap.html)
  LTS releases are 8, 11, 17, 21, 25; next planned LTS is 29 (Sept 2027). Use for: "which Java version should we run?"
- [Docker Docs: What is a container?](https://docs.docker.com/get-started/docker-concepts/the-basics/what-is-a-container/)
  Official Docker concepts series. Use for: containers, images, registries, Dockerfile basics.
- [Kubernetes Docs: Overview](https://kubernetes.io/docs/concepts/overview/)
  Official concepts: components, objects, labels, namespaces. Use for: all Kubernetes fundamentals.
- [PostgreSQL 18 Docs: Tutorial](https://www.postgresql.org/docs/current/tutorial.html)
  SQL, views, foreign keys, transactions, window functions. Use for: Postgres fundamentals; then read the "Performance Tips" and "Concurrency Control" chapters.
- [Use The Index, Luke](https://use-the-index-luke.com/)
  Free web edition of *SQL Performance Explained* by Markus Winand; covers PostgreSQL. Use for: indexing and query performance.

- [Kubernetes Docs: Components, Pods, Deployments, Service, Probes, Resource management](https://kubernetes.io/docs/concepts/overview/components/)
  Official pages read for the Kubernetes ladder. Use for: every Kubernetes lesson; cite the specific page.
- [Docker Docs: Build cache, Multi-stage builds, Best practices, Resource constraints, Compose model](https://docs.docker.com/build/building/best-practices/)
  Official pages read for the Docker ladder. Use for: Dockerfile review and container limits.
- [Java SE 25 Docs: Virtual Threads, GC Tuning Guide, java command, JLS chapter 17](https://docs.oracle.com/en/java/javase/25/core/virtual-threads.html)
  Primary sources for concurrency and JVM memory lessons. Use for: memory model, GC defaults, JVM flags.
- [Spring Framework Reference](https://docs.spring.io/spring-framework/reference/) and [Spring Boot Reference](https://docs.spring.io/spring-boot/reference/)
  Official reference read for IoC, DI, transactions, MVC and auto-configuration. Use for: all Spring Boot lessons.
- [Azure Architecture Center: Cache-Aside](https://learn.microsoft.com/en-us/azure/architecture/patterns/cache-aside) and [Retry](https://learn.microsoft.com/en-us/azure/architecture/patterns/retry)
  Vendor-neutral resilience patterns with trade-offs. Use for: system-design lessons on caching and retries.

- [Apache Kafka Documentation 4.3: introduction, design, producer and consumer configs, KafkaConsumer Javadoc](https://kafka.apache.org/43/getting-started/introduction/)
  Official Kafka docs (per-section pages; the single-page `#anchor` links do not load in fetch tools). Use for: every Kafka lesson.
- [RabbitMQ Docs: AMQP model, consumer acks and publisher confirms, quorum queues, dead letter exchanges](https://www.rabbitmq.com/tutorials/amqp-concepts)
  Official RabbitMQ docs. Use for: every RabbitMQ lesson.
- [Elastic Docs: Elasticsearch indices, shards, near real-time search, query DSL; Logstash pipeline, grok, persistent queues; Filebeat; Kibana Discover](https://www.elastic.co/docs/)
  Official Elastic docs; older `/guide/en/...` URLs still work for some pages. Use for: every ELK lesson.
- [OpenJDK JEPs used for JDK 8/17/21 lessons: 286, 361, 378, 394, 409, 431, 439, 440, 441](https://openjdk.org/jeps/)
  Primary source for what each Java release finalized. Use for: "which JDK added X" questions.
- [Oracle Java Tutorials: Lambda Expressions, Default Methods, Date-Time](https://docs.oracle.com/javase/tutorial/)
  Official JDK 8-era tutorials. Use for: JDK 8 feature lessons.

- [Java Tutorials: Exceptions, Generics, Concurrency (deadlock)](https://docs.oracle.com/javase/tutorial/)
  Official Oracle tutorials read for exceptions, generics (subtyping, wildcards, erasure) and deadlock. Use for: Java fundamentals lessons.
- [Java SE 25 API docs: String, Collectors, ThreadPoolExecutor, ConcurrentHashMap, atomic package, ReentrantLock](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/concurrent/package-summary.html)
  Javadocs used for the newer Java lessons. Use for: concurrency and collections detail.
- [Docker Docs: volumes, bind mounts, networking, bridge driver, CLI run, restart policies, Dockerfile reference](https://docs.docker.com/reference/dockerfile/)
  Official pages for the added Docker lessons. Use for: runtime flags, storage, networks.
- [PostgreSQL Docs: aggregates, transactions, WITH queries, index types, multicolumn/partial indexes, explicit locking, routine vacuuming](https://www.postgresql.org/docs/current/)
  Official pages for the added PostgreSQL lessons.
- [Kubernetes Docs: Namespaces, ConfigMaps, Secrets, Jobs, CronJob, Persistent Volumes, StatefulSets, Ingress, HPA](https://kubernetes.io/docs/concepts/)
  Official pages for the added Kubernetes lessons; manifests were applied on a kind cluster.
- [Spring Boot Reference: externalized configuration, profiles, actuator, testing, Testcontainers; Spring Framework: scopes, Bean Validation](https://docs.spring.io/spring-boot/reference/)
  Official references for the added Spring lessons; demo project in `spring-boot/examples/demo-app`.
- [Kafka 4.3 docs: topic configs, log compaction (design), Streams core concepts, Connect user guide](https://kafka.apache.org/43/)
  Official Kafka pages for the added lessons.
- [RabbitMQ Docs: TTL, streams, clustering](https://www.rabbitmq.com/docs/clustering)
  Official RabbitMQ pages for the added lessons.
- [Elastic Docs: text analysis, bulk API, aggregations, ingest pipelines, data streams, ILM, KQL, Discover](https://www.elastic.co/docs/)
  Official Elastic pages for the added ELK lessons.
- [Azure Architecture Center patterns: Circuit Breaker, Bulkhead, Rate Limiting, Queue-Based Load Leveling, Competing Consumers, Saga, Sharding, Transactional Outbox](https://learn.microsoft.com/en-us/azure/architecture/patterns/)
  Vendor-neutral design patterns; some pages fetch as very long dumps. Use for: system-design lessons.

- [Java Tutorials: OOP concepts (object, class, inheritance, interface), polymorphism, overriding, abstract classes, nested classes, enums, class members, access control, initialization](https://docs.oracle.com/javase/tutorial/java/concepts/)
  Official Oracle tutorial pages read for the OOP ladder. Use for: the definitions and rules of Java OOP.
- [Refactoring.Guru: Design patterns catalog and each pattern page](https://refactoring.guru/design-patterns/catalog)
  Widely used, well-structured pattern reference (intent, applicability, pros/cons, relations). A secondary source rather than the original GoF book; use for: all Design Patterns lessons.
- [Wikipedia: SOLID, Liskov substitution principle, Composition over inheritance, Law of Demeter, Coupling, God object, Anti-pattern](https://en.wikipedia.org/wiki/SOLID)
  Tertiary source used for principle definitions because primary sources could not be fetched (Robert C. Martin's own site refused the connection and Baeldung returned 403). Use for: SOLID and design-principle lessons; check Martin's original writing when you can.

- [Kafka 4.3 docs, deep-dive pages: consumer rebalance protocol (KIP-848), KRaft, monitoring, tiered storage, geo-replication, security overview, ACLs, group configs, Streams DSL; KafkaProducer / KafkaShareConsumer Javadoc](https://kafka.apache.org/43/operations/)
  Read for Kafka lessons 0011-0023. Use for: rebalancing, KRaft, operations, share groups, security, multi-cluster.
- [Apache Kafka 4.2.0 release announcement (17 Feb 2026)](https://kafka.apache.org/blog/2026/02/17/apache-kafka-4.2.0-release-announcement/)
  Share groups production-ready, Streams DLQ and server-side Streams rebalance. Use for: "what's new in Kafka" questions.
- [Spring for Apache Kafka reference 4.1: quick tour, listener containers (AckMode), handling exceptions (DefaultErrorHandler, DLT)](https://docs.spring.io/spring-kafka/reference/)
  Use for: Spring Kafka lessons 0013 and 0016.
- [Confluent Docs: Schema Registry schema evolution and serializer formats](https://docs.confluent.io/platform/current/schema-registry/fundamentals/schema-evolution.html)
  Vendor docs (Schema Registry is a Confluent product, not Apache Kafka). Use for: Kafka lesson 0017.

- [Java SE 21 API docs (java.util): List, Map, HashMap, HashSet, LinkedHashMap, TreeMap, PriorityQueue, EnumMap/EnumSet, IdentityHashMap, WeakHashMap, Collections, Arrays, ConcurrentModificationException, CopyOnWriteArrayList, BlockingQueue, ConcurrentSkipListMap; java.lang.Comparable](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/package-summary.html)
  Read for the Java collections deep dive (lessons 0028-0039). JDK 21 pages are used because the course scope is 8/17/21.
- [OpenJDK jdk21u source: HashMap.java and ArrayList.java](https://github.com/openjdk/jdk21u/tree/master/src/java.base/share/classes/java/util)
  Implementation details the Javadoc does not promise (treeify thresholds, hash spreading, 1.5x growth). Say "in OpenJDK" when quoting them in an interview.
- [Java SE 21 Core Libraries guide: Java Collections Framework](https://docs.oracle.com/en/java/javase/21/core/java-collections-framework.html) and [JLS 21 §5.1.7 boxing](https://docs.oracle.com/javase/specs/jls/se21/html/jls-5.html#jls-5.1.7)
 (not yet verified this session, check editions before relying on them):

- *Effective Java* (Joshua Bloch): idioms and pitfalls, staple of Senior interviews.
- *Java Concurrency in Practice* (Goetz et al.): memory model and concurrency.
- *Design Patterns: Elements of Reusable Object-Oriented Software* (Gamma, Helm, Johnson, Vlissides): the original pattern catalog; not read for this course, which uses Refactoring.Guru.
- *Designing Data-Intensive Applications* (Martin Kleppmann): system-design and transactions.

## Wisdom (Communities)

Not yet vetted. For Kafka (verified on the official contact page, https://kafka.apache.org/community/contact/): the users mailing list (subscribe via users-subscribe@kafka.apache.org, plain-text email) and the `apache-kafka` tag on Stack Overflow. Good places to test answers to the lesson 0015/0016/0021 design questions. Candidates to check next session: r/java, r/kubernetes, r/PostgreSQL, the PostgreSQL mailing lists, CNCF Slack. The learner has not opted out of communities.

## Gaps

- Primary sources for SOLID (Martin's papers) and for the GoF book itself: not fetched; the OOP and pattern lessons use Oracle tutorials, Refactoring.Guru and Wikipedia.
- Domain-driven design, concurrency patterns and enterprise patterns: no sources gathered yet.

- A high-trust source for mock Senior interview questions. The interview pages are written from the same official docs used in the lessons; questions were chosen by me, not sourced from a vetted question bank.
- Kibana dashboards and Lens, hot/warm sizing, RabbitMQ monitoring, Spring Security, RBAC/NetworkPolicy/Helm: not yet read; listed as planned.
- Java 8 to 17 migration breaking changes: not yet sourced.
- Spring Data JPA / Hibernate depth (N+1, lazy loading): only the derived-query page was read; fetch more before the planned lesson.
- A source for capacity estimation and consistency models (CAP, quorum) for the planned system-design lesson. The AWS Builders' Library page on retries could not be fetched (redirect returned no content).
- The kind setup itself: I used it (kubectl v1.37.1, kind v0.34) but did not read its docs; verify before recommending.
- Kafka Streams and Testcontainers were only partly exercised: Streams ran the bundled WordCount demo, Testcontainers was not run.
