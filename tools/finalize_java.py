"""After Java lessons change: add review lessons to the ladders and roadmap, renumber steps, rebuild prev/next.
Usage (repo root): python3 tools/finalize_java.py"""
import sys, re, html, os
sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from java_order import ORDER, N, POS, nav, title_of

miss = [f"java/lessons/{l}{e}" for l, _, _ in ORDER for e in (".html", ".vi.html") if not os.path.exists(f"java/lessons/{l}{e}")]
if miss: sys.exit("missing: " + ", ".join(miss))
REVIEWS = [o[0] for o in ORDER if o[2] == "Review"]

for lang, ext in (("en", ".html"), ("vi", ".vi.html")):
    p = f"java/index{ext}"; s = open(p).read()
    for lid in REVIEWS:
        if f'data-id="{lid}"' in s: continue
        prev = ORDER[POS[lid] - 1][0]
        m = re.search(rf'<li data-id="{prev}">.*?</li>\n', s)
        tag = "Review" if lang == "en" else "Ôn tập"
        s = s[:m.end()] + f'<li data-id="{lid}"><a href="lessons/{lid}{ext}">{html.escape(title_of(lid, lang))}</a> <span class="meta">{tag}</span></li>\n' + s[m.end():]
    s = re.sub(r'data-total="\d+">\d+', f'data-total="{N}">{N}', s)
    s = re.sub(r"\b\d+ (lessons in reading order|bài theo thứ tự)", rf"{N} \1", s)
    open(p, "w").write(s)
    print(p, "order ok:", re.findall(r'data-id="([^"]+)"', s) == [o[0] for o in ORDER])

for lid, _, _ in ORDER:
    for lang, ext, pat, rep in (("en", ".html", r"step \d+ of \d+", f"step {POS[lid]+1} of {N}"),
                                ("vi", ".vi.html", r"bước \d+/\d+", f"bước {POS[lid]+1}/{N}")):
        f = f"java/lessons/{lid}{ext}"; t = open(f).read()
        t, n1 = re.subn(pat, rep, t, count=1)
        t, n2 = re.subn(r'<p>(<a href="[^"]+">← [^<]*</a>)? ?&nbsp;\|&nbsp; ?(<a href="[^"]+">[^<]*</a>)?</p>', lambda m: nav(lid, lang), t, count=1)
        if n1 != 1 or n2 != 1: print("CHECK", f, "step", n1, "nav", n2)
        open(f, "w").write(t)

for p, ext, lang in (("reference/roadmap.html", ".html", "en"), ("reference/roadmap.vi.html", ".vi.html", "vi")):
    s = open(p).read()
    for lid in REVIEWS:
        if f"../java/lessons/{lid}" in s: continue
        prev = ORDER[POS[lid] - 1][0]
        m = re.search(rf'<li><a href="\.\./java/lessons/{prev}{re.escape(ext)}">.*?</a></li>', s)
        s = s[:m.end()] + f'<li><a href="../java/lessons/{lid}{ext}">{html.escape(title_of(lid, lang))}</a></li>' + s[m.end():]
    open(p, "w").write(s)
print("done:", N, "Java lessons")
