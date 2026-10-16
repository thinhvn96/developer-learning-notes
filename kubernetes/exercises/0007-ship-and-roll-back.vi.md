# Bài tập 0007: release và rollback

Đi kèm [bài 7](../lessons/0007-rolling-updates-and-rollbacks.vi.html) · [English](0007-ship-and-roll-back.md)

Trên cluster local: deploy `nginx:1.14.2` với 4 replica, đổi image sang `nginx:does-not-exist`, theo dõi `kubectl rollout status` và `kubectl get pods`. Vì sao service vẫn sống? Sau đó chạy `kubectl rollout undo`. Kể lại câu chuyện trong năm dòng.
