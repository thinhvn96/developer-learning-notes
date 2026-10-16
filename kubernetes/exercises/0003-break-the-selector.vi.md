# Bài tập 0003: làm hỏng selector

Đi kèm [bài 3](../lessons/0003-deployments-and-labels.vi.html) · [English](0003-break-the-selector.md)

Đổi `selector.matchLabels` trong `examples/deployment.yaml` thành `app: web` nhưng giữ label của template là `app: nginx`. Đoán xem `kubectl apply` sẽ báo gì, rồi chạy thử. Sửa lại, sau đó scale lên 5 replica bằng `kubectl scale`. Bạn vừa thay đổi `replicas` của object nào?
