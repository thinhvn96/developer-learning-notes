"""Course-wide check: every page has a .vi twin, structure matches, local links resolve.
Usage (repo root): python3 tools/verify_all.py"""
import os, re, glob
from urllib.parse import urlparse
from collections import Counter
SKIP = ("examples/", "tools/")
en = [f for f in glob.glob("**/*.html", recursive=True) + glob.glob("*/exercises/*.md")
      if ".vi." not in f and "/examples/" not in f and not f.startswith(SKIP)]
probs = []
for f in sorted(en):
    t = re.sub(r"\.(html|md)$", r".vi.\1", f)
    if not os.path.exists(t): probs.append(("MISSING", t)); continue
    a, b = open(f).read(), open(t).read()
    if f.endswith(".html"):
        if '<html lang="vi">' not in b: probs.append(("NOLANG", t))
        for pat in ['class="quiz"', 'data-correct', 'class="qa"', 'class="recall"', '<figure', '<svg', 'data-id=']:
            if a.count(pat) != b.count(pat): probs.append(("COUNT " + pat, t, a.count(pat), b.count(pat)))
    if "Tiếng Việt" not in a: probs.append(("NOSWITCH", f))
for f in glob.glob("**/*.html", recursive=True) + glob.glob("**/*.md", recursive=True):
    if "/examples/" in f or f.startswith(SKIP) or f in ("TRANSLATION.md", "LESSON-STYLE.md"): continue
    s = open(f).read()
    for l in re.findall(r'href="([^"#]+)', s) + re.findall(r'\]\(([^)#\s]+)\)', s):
        if urlparse(l).scheme or l.startswith("mailto"): continue
        if not os.path.exists(os.path.normpath(os.path.join(os.path.dirname(f), l))): probs.append(("BROKEN", f, l))
print(Counter(p[0] for p in probs))
for p in probs[:40]: print(p)
