// Reusable quiz component. Markup:
// <div class="quiz"><p class="prompt">Q</p>
//   <button>Option</button> <button data-correct>Right option</button>
//   <p class="explain">Why.</p></div>
// Optional <p class="score"></p> anywhere on the page shows the running score.
// Answers are locked after the first click (one attempt = real retrieval).
(function () {
  const quizzes = [...document.querySelectorAll(".quiz")];
  let right = 0, answered = 0;
  const score = document.querySelector(".score");
  const show = () => { if (score) score.textContent = `Score: ${right} / ${quizzes.length} (${answered} answered)`; };
  quizzes.forEach((q) => {
    const buttons = [...q.querySelectorAll("button")];
    buttons.forEach((b) => b.addEventListener("click", () => {
      if (q.classList.contains("done")) return;
      q.classList.add("done");
      answered++;
      if (b.hasAttribute("data-correct")) { b.classList.add("right"); right++; }
      else { b.classList.add("wrong"); q.querySelector("[data-correct]").classList.add("right"); }
      buttons.forEach((x) => (x.disabled = true));
      show();
    }));
  });
  show();
})();
