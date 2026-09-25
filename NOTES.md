# Teaching Notes

## Learner preferences
- Wants an "expert engineer" voice: detailed explanations, Senior-interview framing.
- Wants **one folder per tech stack** containing `lessons/`, `exercises/`, `examples/`. This overrides the default single `./lessons/` folder. Stacks: `java`, `docker`, `kubernetes`, `postgresql`, `spring-boot`, `system-design`.
- Wants a comprehensive roadmap: see `reference/roadmap.html`.

- Asked (session 2) for each stack to go **simple to advanced** with more lessons. Each stack has `index.html` with the ladder, tagged Foundation / Core / Advanced / Senior.

- Asked (session 3): (1) Java only for **JDK 8, 17, 21**; (2) add **Kafka, RabbitMQ, ELK** stacks; (3) learn basic to advanced for every stack; (4) **interview questions with detailed answers for each stack** (`<stack>/interview.html`). Mission updated in `MISSION.md` accordingly.

- Asked (session 4): "more lessons, basic to advanced" and "a page that can redirect to each tech stack". Done: root `index.html` (home with a card per stack, progress ticks in localStorage), per-stack ladders in reading order, 124 lessons total.

- Asked (session 5): learn **OOP** and **design patterns** "from basic to advance with as much as lesson". Added `oop/` (22 lessons) and `design-patterns/` (30 lessons, all 22 GoF patterns), each with runnable Java examples whose real output is embedded in the lessons.

## Conventions
- Lesson numbering is per stack: `java/lessons/0001-....html`.
- Lessons link `../../assets/style.css` and `../../assets/quiz.js`.
- Quiz answers within a question are kept the same length.
- Learning records are global in `learning-records/`.

## Open questions for next session
- Years of Java experience and which Java version they use at work.
- Interview date / weekly hours.
- Prior Docker / K8s / Postgres exposure (use the first lesson quizzes as a diagnostic).

## Status (session 5)
- 11 stacks, 176 lessons: java 27, oop 22, design-patterns 30, docker 12, postgresql 13, spring-boot 13, kafka 10, rabbitmq 9, elk 14, kubernetes 15, system-design 11. 157 interview Q&As in `<stack>/interview.html`. Home: `index.html`. References: `reference/roadmap.html`, `jdk-8-17-21.html`, `design-patterns.html`.
- OOP/pattern examples are single-file Java programs (`java oop/examples/X.java`), all run on JDK 21; lesson pages embed their actual output.
- Earlier verification notes still apply (Kubernetes on kind, Spring demo project with 17 tests, containers for Docker/Postgres/Kafka/RabbitMQ/ELK). Not verified: Testcontainers, Kibana/KQL, RabbitMQ stream replay.
- SOLID definitions come from Wikipedia (tertiary); flagged in RESOURCES.md. Pattern intents come from Refactoring.Guru.
- Planned lists are in each stack index. Generator scripts were in the session scratchpad and will not survive; edit the HTML directly.
- Nothing learned yet is recorded (no exercise answers received).
