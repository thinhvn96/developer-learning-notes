# Lesson style: beginner-detailed, with diagrams

The learner is **new to Java** and preparing for Senior interviews. Each lesson must teach from zero, in plain words, with at least one diagram, and still end at an interview-ready answer.

- **Gold template:** `java/lessons/0001-hashmap-equals-hashcode.html`. Copy its structure, classes and tone.
- **Original reference from the learner:** `examples/0001-hashmap-equals-hashcode.html`.
- **Components:** `assets/style.css` (beginner lesson section) and `assets/quiz.js`.

## Page skeleton (in this order)

1. `<h1>` = a question or plain statement ("How HashMap finds your value"), then `<p class="subtitle">` with a one-line hook.
2. `<p class="meta">` exactly like the template: `Java (JDK 8, 17, 21) · Lesson NNNN · step X of Y · Level · ~N minutes · Home · ladder · Roadmap · Tiếng Việt`. Step numbers are rewritten by script later, so copy whatever is there.
3. `<div class="mission">`: **Why this lesson?** One or two sentences tying it to real work and to the interview question it answers.
4. `<div class="win">`: **Today's win:** one concrete, checkable outcome.
5. `<dl class="words">`: 4–8 terms the lesson uses, each explained in one plain sentence (no jargon inside definitions). Define Java basics the first time a lesson relies on them (class, interface, generic `<T>`, thread, …).
6. `<h2>Before you start</h2>`: one pre-test question to answer out loud before reading.
7. **Numbered `<h2>` sections (3–6)**, each one idea:
   - Start from an **everyday analogy** (mailboxes, a queue at the bank, a library card index), then map it to Java.
   - Show **small code** first, then explain line by line. Use `<span class="c">` for annotation lines and `<span class="hl">` for the result to notice, inside `<pre><code>`.
   - **Trace step by step** what Java does (`Step 1 … Step 2 …`), like section 2 of the template.
   - Show the **real output** of the runnable example (`$ java java/examples/...`). Run it and paste the exact output; never invent output.
   - Call out **JDK 8 vs 17 vs 21** differences when there are any.
   - Common **mistake / trap** subsection with the fix.
8. **At least one diagram, usually two** (see Diagrams).
9. `<h2>Practice</h2>`, then `<p class="muted">` "Answer from memory…", `<p class="score"></p>`, and **5–7 quizzes** in the new markup:
   ```html
   <div class="quiz">
     <p class="q">Question as a full sentence?</p>
     <div class="options">
       <button class="opt" data-correct>Correct option</button>
       <button class="opt">Wrong option</button> …
     </div>
     <div class="why">Why, in one or two sentences.</div>
   </div>
   ```
   Options are shuffled at runtime, so writing the correct one first is fine. All options of one question must have **similar length and style**, so the length gives nothing away. Mix question types: "why", "what does this code print", "which is the rule", "what is the bug".
10. `<h2>The final test: say it in 60 seconds</h2>` with `<div class="recall">`: the interview question, the `reveal` button, a 5–7 point `ul.checklist`, `<p class="checklist-score">`, and `<h3>Example answer</h3>` in first person, as spoken in an interview.
11. `<h2>Now do the exercise</h2>`: keep the existing exercise link and the runnable example links.
12. `<h2>What's next</h2>`: what a Senior interviewer would ask next, with links. Then **Read more:** the best primary source.
13. `<div class="ask">`: the teacher box (copy from the template).
14. The navigation line, **exactly** `<p><a href="PREV.html">← Title</a> &nbsp;|&nbsp; <a href="NEXT.html">Title →</a></p>` (copy it from the old lesson; a script rewrites it).
15. `<footer>`: "Facts checked against …" plus the reference links.

Length: about 2.5–4× the old lesson. Short paragraphs (2–4 sentences), short sentences, active voice, "you".

## Facts and citations

- **Keep every fact and citation of the old lesson** (it was checked against official docs). You may add facts, but only after checking them in the JDK 21 Javadoc, the JLS, dev.java, the Oracle tutorials or the OpenJDK 21 source. Fetch the page; do not rely on memory.
- Cite inline with `<a class="src" href="URL">short label</a>` right after the claim. Direct quotes use "quotation marks".
- Implementation details that the Javadoc does not promise (thresholds, growth factors) must say "in OpenJDK" or "in the source".
- Examples: run them with `java java/examples/<File>.java` (JDK 21 is installed) and paste the real output. If you add a new example program, put it in `java/examples/` (or a subfolder), keep it single-file, and run it.

## Diagrams (inline SVG)

- One `<figure>` with `<svg viewBox="0 0 680 H" role="img" aria-label="what it shows">` plus a `<figcaption>` sentence.
- Colors: `currentColor` for normal strokes and text, `var(--accent)` for the thing to notice, and `fill="var(--accent-soft)"` for highlighted boxes. **Never hard-code colors**: the page has a dark mode.
- Font: `font-family="ui-monospace, Menlo, Consolas, monospace"`, size 11–13. Keep text inside its boxes; leave ≥ 20px margins; width 680.
- Good diagram types: memory layout (array slots, nodes and pointers, buckets), before/after of an operation, a timeline of two threads, a flow (input → step → step → result), a decision tree ("which collection?"), a class or interface hierarchy.
- Browsers collapse leading and repeated spaces inside SVG `<text>` (`xml:space` and `white-space:pre` do not help in Chrome). For indented code in a diagram use `&#160;` for each extra space, or position each token with its own `x`.
- The diagram must show the **mechanism**, not decoration. Label arrows with the operation (`hashCode()`, `resize`, `lock`).

## Review lessons

A review lesson closes each section. It brings **no new facts**; it only revisits the section's lessons.
- Use the same skeleton, with `Level = Review`.
- 10–14 **interleaved** quizzes mixing the lessons, each `.why` linking back to the lesson ("see lesson 0030").
- Two or three "say it in 60 seconds" recalls, each with a checklist and an example answer.
- One small mixed task: read some code, find 3 bugs from different lessons.
- A table: "If you missed questions on X → re-read lesson NNNN".

## Vietnamese twin

Follow `TRANSLATION.md`. Same HTML, translated text, `lang="vi"`, links to `.vi.html`. Fixed strings for the new sections:

| English | Tiếng Việt |
|---|---|
| Why this lesson? | Vì sao có bài này? |
| Words (box title, automatic via CSS) | Từ vựng |
| Before you start | Trước khi bắt đầu |
| Practice | Luyện tập |
| Answer from memory, don't scroll up. The options are in a different order every time you open the page. | Trả lời theo trí nhớ, đừng cuộn lên. Thứ tự đáp án thay đổi mỗi lần bạn mở trang. |
| The final test: say it in 60 seconds | Bài kiểm tra cuối: nói trong 60 giây |
| I've said it. Show the checklist. | Mình đã nói xong. Hiện checklist. |
| Tick only the points you really said: | Chỉ tick những ý bạn thật sự đã nói: |
| Example answer | Câu trả lời mẫu |
| What's next | Tiếp theo là gì |
| Read more | Đọc thêm |
| Have a question? | Có câu hỏi? |
| Facts checked against … | Thông tin đã được kiểm tra với … |

The example answer stays in natural spoken Vietnamese, with English technical terms, as a Vietnamese candidate would say it.
