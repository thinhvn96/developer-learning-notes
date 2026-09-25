// Expand / collapse all Q&A blocks on an interview page. Markup: <details class="qa">...</details>
(function () {
  const all = () => [...document.querySelectorAll("details.qa")];
  const open = document.getElementById("open-all"), close = document.getElementById("close-all");
  if (open) open.addEventListener("click", () => all().forEach((d) => (d.open = true)));
  if (close) close.addEventListener("click", () => all().forEach((d) => (d.open = false)));
})();
