# Vietnamese versions: conventions

Lesson content and layout rules are in `LESSON-STYLE.md`; its last section has the Vietnamese strings for the beginner lesson sections.

Every English page has a Vietnamese twin **next to it**, same folder, `.vi` before the extension:

| English | Vietnamese |
|---|---|
| `kafka/lessons/0003-consumers-groups-and-offsets.html` | `kafka/lessons/0003-consumers-groups-and-offsets.vi.html` |
| `kafka/exercises/0003-scale-a-consumer-group.md` | `kafka/exercises/0003-scale-a-consumer-group.vi.md` |
| `kafka/index.html`, `kafka/interview.html` | `kafka/index.vi.html`, `kafka/interview.vi.html` |
| `index.html`, `reference/roadmap.html` | `index.vi.html`, `reference/roadmap.vi.html` |

Same folder means every relative path (`../../assets/style.css`, `../examples/x.sh`) stays valid. Examples (`.java`, `.sh`, `.sql`, `.yaml`) are **not** translated; both languages link the same files.

## Rules for a `.vi.html` page

1. `<html lang="vi">`. Translate `<title>`. The shared scripts switch their labels on `lang="vi"`.
2. Internal links to other course pages point at the `.vi.html` / `.vi.md` twin (lessons, exercises, index, interview, home, roadmap, reference pages). Links to `examples/`, `assets/`, `RESOURCES.md` and external URLs stay unchanged.
3. Add the language switch as the **last item of the `.meta` line**: on the Vietnamese page `· <a class="lang" href="<english file>" hreflang="en" lang="en">English</a>`; on the English page `· <a class="lang" href="<vi file>" hreflang="vi" lang="vi">Tiếng Việt</a>`. Pages without a `.meta` line (exercises) get the switch on the first line under the title.
4. Keep the HTML structure identical: same classes, ids, `data-*` attributes, `data-correct` positions, citation numbers and URLs. `data-id` / `data-stack` values are **not** translated (progress ticks are shared between languages).
5. Do not translate: code, `<pre>`/`<code>` content, command output, config keys, class/method names, CLI flags, product names. Code comments inside `<pre>` may stay English.
6. Direct quotations from docs (text in "quotes" with a citation) are translated, and the sentence keeps its citation. Write: `theo tài liệu, "..."` is fine.
7. Quiz answers within one question must stay roughly the same length in Vietnamese too (no length clues).
8. Tone: natural Vietnamese for Vietnamese developers, as a senior engineer would explain it to a colleague. Use "bạn". Not word-for-word.
9. Exercise `.vi.md`: translate prose; first line under the H1 links to the lesson's `.vi.html`; add `[English](<file>.md)` switch.

## Fixed UI strings

| English | Tiếng Việt |
|---|---|
| Home | Trang chủ |
| Kafka ladder (Stack ladder / Stack index) | Lộ trình Kafka |
| Roadmap | Lộ trình tổng |
| Interview Q&A | Hỏi đáp phỏng vấn |
| Lesson 0003 · step 4 of 10 · Core · ~10 minutes | Bài 0003 · bước 4/10 · Core · ~10 phút |
| Today's win | Thành quả hôm nay |
| Retrieval practice | Luyện truy hồi |
| Answer from memory. One attempt each. | Trả lời theo trí nhớ. Mỗi câu chỉ một lần chọn. |
| Now do the exercise | Bây giờ làm bài tập |
| Runnable example | Ví dụ chạy được |
| Read next | Đọc tiếp |
| Primary source | Nguồn chính |
| Ask your teacher | Hỏi giáo viên |
| References | Tài liệu tham khảo |
| All resources | Tất cả tài nguyên |
| Short answer | Trả lời ngắn |
| Likely follow-up | Câu hỏi nối tiếp thường gặp |
| Learn it | Học bài |
| Expand all / Collapse all | Mở tất cả / Thu gọn tất cả |
| Start learning → | Bắt đầu học → |
| Planned | Dự kiến |
| Exercise | Bài tập |

Level tags **Foundation / Core / Advanced / Senior stay in English** (they are labels the learner already uses).

## Glossary: keep these terms in English

Vietnamese backend engineers use the English term in speech and in interviews; translating them makes the text harder to read. On **first use in a page** you may add a short Vietnamese gloss in parentheses, e.g. "partition (phân vùng)".

- General: backend, service, microservice, API, endpoint, request, response, client, server, deploy, build, cache, queue, log, thread, lock, deadlock, race condition, timeout, retry, backoff, throughput, latency, benchmark, interview, trade-off, pattern, framework, library, runtime, heap, stack, garbage collection (GC), bytecode.
- Java/OOP: class, object, interface, abstract class, record, enum, generic, lambda, stream, collection, override, overload, constructor, getter/setter, bean, dependency injection, singleton, factory, proxy, annotation.
- Data: database, schema, table, index, query, transaction, isolation level, commit, rollback, join, primary key, foreign key, constraint, MVCC, vacuum, shard, replica.
- Kafka/messaging: broker, cluster, topic, partition, offset, producer, consumer, consumer group, rebalance, leader, follower, replica, ISR, acks, retention, compaction, tombstone, idempotent, exactly-once, at-least-once, at-most-once, lag, KRaft, controller, exchange, binding, routing key, dead letter, ack/nack, prefetch.
- Infra: container, image, layer, volume, network, pod, node, deployment, service (K8s), ingress, namespace, probe, liveness, readiness, rolling update, autoscaler, manifest.
- ELK: index, document, mapping, shard, analyzer, token, pipeline, ingest, data stream, lifecycle policy.

Common Vietnamese renderings to use consistently: durability = độ bền dữ liệu; ordering = thứ tự; guarantee = đảm bảo; throughput = thông lượng (or keep English); failure = sự cố; fault tolerance = khả năng chịu lỗi; scale = mở rộng; replication = sao chép (replication); consistency = tính nhất quán; availability = tính sẵn sàng; trade-off = đánh đổi (trade-off).
