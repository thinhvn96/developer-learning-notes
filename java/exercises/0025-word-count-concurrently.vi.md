# Bài tập 0025

Đi kèm [bài 25](../lessons/0025-concurrenthashmap.vi.html). · [English](0025-word-count-concurrently.md)

Đếm từ bằng 4 thread vào một `ConcurrentHashMap<String, LongAdder>`. Sau đó viết phiên bản có bug `if (!map.containsKey(k)) map.put(k, 1)` với `ConcurrentHashMap<String,Integer>` và chỉ ra nó làm mất số đếm.

Nói dự đoán của bạn cho giáo viên trước khi chạy bất cứ thứ gì.
