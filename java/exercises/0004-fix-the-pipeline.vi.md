# Bài tập 0004: sửa pipeline

Đi kèm [bài 4](../lessons/0004-streams-and-optional.vi.html). Đoạn code này có ba vấn đề. Hãy tìm ra chúng trước khi chạy bất cứ thứ gì. · [English](0004-fix-the-pipeline.md)

```java
List<String> names = List.of("ann", "bob", "cy");
List<String> out = new ArrayList<>();
Stream<String> s = names.stream().filter(n -> n.length() == 3);
s.forEach(n -> out.add(n.toUpperCase()));
System.out.println(s.count());
String first = out.stream().findFirst().orElse(loadDefaultFromDatabase());
```

Viết một phiên bản đã sửa và chỉ ra mỗi chỗ sửa dựa vào câu nào trong [tài liệu của package stream](https://docs.oracle.com/en/java/javase/25/docs/api/java.base/java/util/stream/package-summary.html).
