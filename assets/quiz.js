// Reusable practice components. Labels follow <html lang>: "vi" pages get Vietnamese text.
//
// 1. Quiz. Two markups are supported:
//    new: <div class="quiz"><p class="q">Q</p><div class="options"><button class="opt" data-correct>..</button>..</div><div class="why">..</div></div>
//    old: <div class="quiz"><p class="prompt">Q</p><button data-correct>..</button>..<p class="explain">..</p></div>
//    Options are shuffled on every page load, so position never gives the answer away.
//    Answers lock after the first click (one attempt = real retrieval). <span|p class="score"> shows the running score.
// 2. Recall: <div class="recall"> ... <button class="reveal"> <div class="answer"> <ul class="checklist"><li><label><input type="checkbox">..
//    The answer and checklist stay hidden until the learner has said their answer out loud. <p class="checklist-score"> counts ticks.
(function () {
  const vi = document.documentElement.lang === "vi";

  // --- quizzes ---
  const quizzes = [...document.querySelectorAll(".quiz")];
  let right = 0, answered = 0;
  const score = document.querySelector(".score");
  const show = () => { if (score) score.textContent = vi
    ? `Điểm: ${right} / ${quizzes.length} (đã trả lời ${answered})`
    : `Score: ${right} / ${quizzes.length} (${answered} answered)`; };
  quizzes.forEach((q) => {
    const box = q.querySelector(".options") || q;
    const buttons = [...box.querySelectorAll(":scope > button")];
    for (let i = buttons.length - 1; i > 0; i--) {          // Fisher-Yates shuffle, then re-append in new order
      const j = Math.floor(Math.random() * (i + 1));
      [buttons[i], buttons[j]] = [buttons[j], buttons[i]];
    }
    const after = q.querySelector(".options") ? null : q.querySelector(".explain, .why");
    buttons.forEach((b) => (after ? box.insertBefore(b, after) : box.appendChild(b)));
    buttons.forEach((b) => b.addEventListener("click", () => {
      if (q.classList.contains("done")) return;
      q.classList.add("done");
      answered++;
      if (b.hasAttribute("data-correct")) { b.classList.add("right"); right++; }
      else { b.classList.add("wrong"); box.querySelector("[data-correct]").classList.add("right"); }
      buttons.forEach((x) => (x.disabled = true));
      show();
    }));
  });
  show();

  // --- recall checklists ---
  document.querySelectorAll(".recall").forEach((r) => {
    const btn = r.querySelector(".reveal");
    if (btn) btn.addEventListener("click", () => r.classList.add("open"));
    const boxes = [...r.querySelectorAll(".checklist input[type=checkbox]")];
    const out = r.querySelector(".checklist-score");
    const update = () => {
      if (!out) return;
      const n = boxes.filter((b) => b.checked).length;
      out.textContent = vi ? `Bạn đã nói được ${n} / ${boxes.length} ý.` : `You covered ${n} of ${boxes.length} points.`;
    };
    boxes.forEach((b) => b.addEventListener("change", update));
    update();
  });
})();
