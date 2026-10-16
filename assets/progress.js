// Progress tracker. Per-viewer convenience only: state lives in this browser's localStorage and can be lost.
// Stack index pages: <ol class="steps" data-stack="java"> with <li data-id="0001-slug"> items get a checkbox each.
// Home page: <div class="card" data-stack="java" data-total="27"> shows "n / total done" and a bar.
(function () {
  const KEY = "learning-progress-v1";
  const load = () => { try { return JSON.parse(localStorage.getItem(KEY) || "{}"); } catch (e) { return {}; } };
  const save = (s) => { try { localStorage.setItem(KEY, JSON.stringify(s)); } catch (e) {} };
  const state = load();
  const vi = document.documentElement.lang === "vi"; // labels follow <html lang>
  const count = (stack) => Object.keys(state).filter((k) => k.startsWith(stack + "/") && state[k]).length;

  document.querySelectorAll("ol.steps").forEach((ol) => {
    const stack = ol.dataset.stack;
    ol.querySelectorAll("li[data-id]").forEach((li) => {
      const id = stack + "/" + li.dataset.id;
      const box = document.createElement("input");
      box.type = "checkbox"; box.title = vi ? "Đánh dấu đã học" : "Mark as done"; box.checked = !!state[id];
      li.classList.toggle("done", box.checked);
      box.addEventListener("change", () => { state[id] = box.checked; save(state); li.classList.toggle("done", box.checked); summary(); });
      li.insertBefore(box, li.firstChild);
    });
  });
  function summary() {
    document.querySelectorAll("[data-progress-for]").forEach((el) => {
      const stack = el.dataset.progressFor, total = +el.dataset.total || 0;
      el.textContent = vi ? "Đã học " + count(stack) + " / " + total + " bài" : count(stack) + " of " + total + " lessons marked done";
    });
  }
  summary();

  document.querySelectorAll(".card[data-stack]").forEach((card) => {
    const stack = card.dataset.stack, total = +card.dataset.total || 1, n = count(stack);
    const label = card.querySelector(".prog"); if (label) label.textContent = n + " / " + total + (vi ? " đã học" : " done");
    const bar = card.querySelector(".bar > i"); if (bar) bar.style.width = Math.round((100 * n) / total) + "%";
  });
})();
