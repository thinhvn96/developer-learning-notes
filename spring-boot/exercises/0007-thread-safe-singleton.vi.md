# Bài tập 0007

Đi kèm [bài 7](../lessons/0007-bean-scopes.vi.html) · [English](0007-thread-safe-singleton.md)

Một singleton service giữ một field `List<String> lastRequests`. Vì sao đó là bug khi chịu tải? Sửa theo ba cách (làm nó stateless, dùng concurrent collection, hoặc dùng bean request-scoped/prototype) và nêu trade-off của từng cách.
