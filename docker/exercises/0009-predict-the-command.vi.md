# Bài tập 0009

Đi kèm [bài 9](../lessons/0009-cmd-entrypoint-and-exec-form.vi.html) · [English](0009-predict-the-command.md)

Với mỗi đoạn cuối Dockerfile dưới đây, đoán xem `docker run img` và `docker run img X` sẽ in ra gì: (1) `CMD ["echo","a"]`, (2) `ENTRYPOINT ["echo","a"]`, (3) `ENTRYPOINT echo a` + `CMD ["b"]`, (4) `ENTRYPOINT ["echo"]` + `CMD ["b"]`. Sau đó chạy thử để kiểm chứng.
