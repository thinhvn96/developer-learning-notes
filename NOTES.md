# Teaching Notes

## Learner preferences
- Wants an "expert engineer" voice: detailed explanations, Senior-interview framing.
- Wants **one folder per tech stack** containing `lessons/`, `exercises/`, `examples/`. This overrides the default single `./lessons/` folder. Stacks: `java`, `docker`, `kubernetes`, `postgresql`, `spring-boot`, `system-design`.
- Wants a comprehensive roadmap: see `reference/roadmap.html`.

- Asked (session 2) for each stack to go **simple to advanced** with more lessons. Each stack has `index.html` with the ladder, tagged Foundation / Core / Advanced / Senior.

- Asked (session 3): (1) Java only for **JDK 8, 17, 21**; (2) add **Kafka, RabbitMQ, ELK** stacks; (3) learn basic to advanced for every stack; (4) **interview questions with detailed answers for each stack** (`<stack>/interview.html`). Mission updated in `MISSION.md` accordingly.

- Asked (session 4): "more lessons, basic to advanced" and "a page that can redirect to each tech stack". Done: root `index.html` (home with a card per stack, progress ticks in localStorage), per-stack ladders in reading order, 124 lessons total.

- Asked (session 5): learn **OOP** and **design patterns** "from basic to advance with as much as lesson". Added `oop/` (22 lessons) and `design-patterns/` (30 lessons, all 22 GoF patterns), each with runnable Java examples whose real output is embedded in the lessons.

- Asked (session 6): "learn deep into Kafka from simple to advanced" and "a Vietnamese version for Kafka and all other documents". Done: Kafka grew from 10 to 23 lessons (Java clients, partitioning, Spring Kafka, throughput, rebalancing/KIP-848, DLTs, Schema Registry, Streams windows/joins/EOS, KRaft, monitoring, share groups, security, multi-cluster/tiered storage), 22 interview Q&As and `reference/kafka-cheatsheet.html`. Every page has a Vietnamese twin (`x.vi.html` / `x.vi.md`), conventions in `TRANSLATION.md`.

- Asked (session 6, later): "learn deeper about the collections, you give very less about it". Done: Java gained a 14-lesson "Collections deep dive" section (12 new lessons 0028-0039 plus 0001/0002 moved in), runnable examples in `java/examples/collections/`, 11 new interview Q&As (27-37), `reference/java-collections.html`. Java is now 39 lessons.
- Quiz options: generators must not put the correct answer first. `shuffle_quiz`-style deterministic shuffling was applied to Kafka 0011-0023 and Java 0028-0039 (EN and VI kept identical).

- Asked (session 6, later): "each lesson should explain more details because I'm new in Java, and also have diagrams", pointing at `examples/0001-hashmap-equals-hashcode.html` (their reference) and a screenshot of a lesson list with review lessons. **The learner is new to Java.** Every lesson now follows `LESSON-STYLE.md` (gold template: `java/lessons/0001-hashmap-equals-hashcode.html`): Words box, pre-test, analogy, step traces, inline SVG diagrams, shuffled full-sentence quizzes, a 60-second recall checklist, a teacher box, plus a review lesson closing each section. Java was rewritten first (39 lessons + 7 reviews, 0040-0046). **Next sessions: rewrite the other stacks one at a time in this style** (ask which one next; suggested order: OOP, Spring Boot, PostgreSQL, Kafka, Docker, Kubernetes, ...).

- Asked (session 7, 2026-10-16, in Vietnamese): too many tokens used; **one topic/lesson per day from now on**, finish unfinished work later. Done that day: the Java topic is complete in the new beginner style (46 lessons incl. 7 reviews 0040-0046, EN + VI, all with diagrams). Helper scripts now live in `tools/` (`java_order.py`, `finalize_java.py`, `verify_all.py`) because `/tmp` scratch files were wiped twice.
- **Still in the old short style (rewrite one per day):** oop, design-patterns, docker, postgresql, spring-boot, kafka, rabbitmq, elk, kubernetes, system-design. Java exercises (`java/exercises/`) were not rewritten.

## Conventions
- Lesson numbering is per stack: `java/lessons/0001-....html`.
- Lessons link `../../assets/style.css` and `../../assets/quiz.js`.
- Quiz answers within a question are kept the same length.
- Learning records are global in `learning-records/`.
- **Bilingual:** every new lesson, exercise, index, interview or reference page needs a Vietnamese twin written in the same session, following `TRANSLATION.md` (technical terms stay English). Shared scripts switch labels on `<html lang="vi">`.
- Kafka examples pin `apache/kafka:4.3.1` through `kafka/examples/kafka-common.sh`; Java client examples copy jars from the image (`kafka/examples/java-clients/run.sh`).

## Open questions for next session
- Years of Java experience and which Java version they use at work.
- Interview date / weekly hours.
- Prior Docker / K8s / Postgres exposure (use the first lesson quizzes as a diagnostic).

## Status (session 6)
- 11 stacks, 201 lessons (kafka 23, java 39), 179 interview Q&As, all bilingual EN/VI. Java collections examples ran on JDK 21.0.12 on 2026-10-15; outputs embedded in lessons 0028-0039 (timings/memory are single rough runs, labelled as such). New Kafka scripts 05-08 and java-clients were run on 2026-10-14 against Kafka 4.3.1; outputs are embedded in lessons 0011, 0012, 0014, 0015, 0019, 0021.
- Not verified by running: Spring Kafka error handling (0016), Schema Registry (0017), Streams windowing code (0018), ACLs/TLS (0022), MirrorMaker/tiered storage (0023). These cite docs only.

## Status (session 5)
- 11 stacks, 176 lessons: java 27, oop 22, design-patterns 30, docker 12, postgresql 13, spring-boot 13, kafka 10, rabbitmq 9, elk 14, kubernetes 15, system-design 11. 157 interview Q&As in `<stack>/interview.html`. Home: `index.html`. References: `reference/roadmap.html`, `jdk-8-17-21.html`, `design-patterns.html`.
- OOP/pattern examples are single-file Java programs (`java oop/examples/X.java`), all run on JDK 21; lesson pages embed their actual output.
- Earlier verification notes still apply (Kubernetes on kind, Spring demo project with 17 tests, containers for Docker/Postgres/Kafka/RabbitMQ/ELK). Not verified: Testcontainers, Kibana/KQL, RabbitMQ stream replay.
- SOLID definitions come from Wikipedia (tertiary); flagged in RESOURCES.md. Pattern intents come from Refactoring.Guru.
- Planned lists are in each stack index. Generator scripts were in the session scratchpad and will not survive; edit the HTML directly.
- Nothing learned yet is recorded (no exercise answers received).
