# Exercise 0012

[Tiếng Việt](0012-avoid-the-deadlock.vi.md)

Change the two sessions in `11-locking.sh` so they update rows in the same order and confirm no deadlock. Then keep the opposite order and add `SELECT ... FOR UPDATE` on both rows up front, sorted by id. Which is more robust?
