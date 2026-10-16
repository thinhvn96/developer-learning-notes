"""Java ladder reading order, plus helpers to rebuild prev/next navigation. Run scripts from the repo root."""
import html, os, re

# (lesson id, English title, level). Titles of lessons not listed come from their own <h1>.
ORDER = [
 ("0018-strings-immutability-and-stringbuilder", None, "Foundation"),
 ("0019-exceptions-checked-unchecked-try-with-resources", None, "Foundation"),
 ("0020-generics-basics-and-invariance", None, "Core"),
 ("0021-wildcards-and-type-erasure", None, "Advanced"),
 ("0040-review-fundamentals", None, "Review"),
 ("0028-collections-framework-map", None, "Foundation"),
 ("0002-choosing-a-list", None, "Foundation"),
 ("0029-iterators-and-fail-fast", None, "Foundation"),
 ("0001-hashmap-equals-hashcode", None, "Foundation"),
 ("0041-review-collections-basics", None, "Review"),
 ("0030-hashmap-internals", None, "Core"),
 ("0031-comparable-comparator-and-ordering", None, "Core"),
 ("0032-unmodifiable-vs-immutable", None, "Core"),
 ("0033-hashset-linkedhashmap-and-lru", None, "Core"),
 ("0042-review-collections-core", None, "Review"),
 ("0034-treemap-and-navigable-maps", None, "Advanced"),
 ("0035-priorityqueue-and-top-k", None, "Advanced"),
 ("0036-enummap-identity-and-weak-maps", None, "Advanced"),
 ("0037-map-default-methods", None, "Advanced"),
 ("0038-capacity-boxing-and-memory", None, "Senior"),
 ("0039-concurrent-collections", None, "Senior"),
 ("0043-review-collections-advanced", None, "Review"),
 ("0008-lambdas-and-functional-interfaces", None, None),
 ("0009-default-methods-and-conflicts", None, None),
 ("0004-streams-and-optional", None, None),
 ("0022-collectors-groupingby-tomap", None, None),
 ("0011-java-time", None, None),
 ("0010-completablefuture", None, None),
 ("0044-review-jdk8", None, "Review"),
 ("0005-visibility-and-happens-before", None, None),
 ("0024-atomics-and-locks", None, None),
 ("0025-concurrenthashmap", None, None),
 ("0023-thread-pools-executors", None, None),
 ("0026-deadlock-and-lock-ordering", None, None),
 ("0007-heap-and-garbage-collection", None, None),
 ("0045-review-concurrency-jvm", None, "Review"),
 ("0012-var-and-text-blocks", None, None),
 ("0013-switch-expressions-and-instanceof-patterns", None, None),
 ("0003-records-and-immutability", None, None),
 ("0014-sealed-classes", None, None),
 ("0027-helpful-nullpointerexceptions", None, None),
 ("0015-pattern-matching-switch-and-record-patterns", None, None),
 ("0016-sequenced-collections", None, None),
 ("0006-virtual-threads", None, None),
 ("0017-generational-zgc", None, None),
 ("0046-review-jdk17-21", None, "Review"),
]
N = len(ORDER)
POS = {lid: i for i, (lid, _, _) in enumerate(ORDER)}


def title_of(lid, lang="en"):
    path = f"java/lessons/{lid}{'.vi' if lang == 'vi' else ''}.html"
    m = re.search(r"<h1>(.*?)</h1>", open(path).read(), re.S)
    return re.sub(r"<[^>]+>", "", html.unescape(m.group(1).strip()))


def nav(lid, lang="en"):
    i = POS[lid]
    ext = ".vi.html" if lang == "vi" else ".html"
    prev = f'<a href="{ORDER[i-1][0]}{ext}">← {html.escape(title_of(ORDER[i-1][0], lang))}</a>' if i > 0 else ""
    if i < N - 1:
        nxt = f'<a href="{ORDER[i+1][0]}{ext}">{html.escape(title_of(ORDER[i+1][0], lang))} →</a>'
    else:
        nxt = f'<a href="../interview{ext}">{"Hỏi đáp phỏng vấn Java →" if lang == "vi" else "Java interview Q&amp;A →"}</a>'
    return f"<p>{prev} &nbsp;|&nbsp; {nxt}</p>"
