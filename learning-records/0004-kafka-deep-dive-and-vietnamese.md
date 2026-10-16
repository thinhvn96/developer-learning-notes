# Kafka deep dive and a Vietnamese version of the whole course

The learner asked to go deep on Kafka, from simple to advanced, and to have every document in Vietnamese as well as English. Kafka was extended from 10 to 23 lessons in one reading order (Foundation → Senior), built on the Kafka 4.3 docs plus Spring Kafka and Confluent Schema Registry docs. Most new lessons embed output from scripts run against `apache/kafka:4.3.1`.

Notable 4.x facts the course now relies on, worth re-checking when Kafka 5.0 ships: ZooKeeper is gone (KRaft only); the KIP-848 consumer protocol is GA but opt-in (`group.protocol=consumer`) until 5.0; share groups (queues) are production-ready since 4.2; `linger.ms` default is 5 since 4.0.

**Implications:** Kafka is the stack the learner is actively studying now, so the next sessions should give spaced retrieval on Kafka 0001-0010 while they move into 0011+. No exercise answers have been received yet, so the learner's actual level is still unknown; ask them to attempt the Kafka exercises, starting with 0011, and record what they get wrong. Every future page needs both languages (see `TRANSLATION.md`).
