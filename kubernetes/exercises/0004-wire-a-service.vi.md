# Bài tập 0004: nối dây cho một Service

Đi kèm [bài 4](../lessons/0004-services.vi.html) · [English](0004-wire-a-service.md)

Apply `deployment.yaml` và `service.yaml`. Chạy `kubectl get endpointslices` (hoặc `kubectl get endpoints`). Xoá một Pod và quan sát địa chỉ thay đổi. Đổi selector của Service sang một label sai và xem endpoint trống trơn. Mỗi thí nghiệm cho thấy gì về cách Service tìm ra Pod?
