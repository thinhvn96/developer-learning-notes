# Exercise 0034: Price tiers and time windows

[Tiếng Việt](0034-price-tiers-and-windows.vi.md)

Companion to [lesson 34](../lessons/0034-treemap-and-navigable-maps.html).

1. Tax brackets: 0% up to 11M, 5% from 11M, 10% from 25M, 20% from 50M. Store them in a `TreeMap` and write `rateFor(long income)` in one line.
2. A meeting-room booking system stores bookings as `TreeMap<LocalTime, LocalTime>` (start to end). Using `floorEntry` and `ceilingEntry`, write `boolean canBook(LocalTime start, LocalTime end)`.
3. Return all log entries between 10:00 and 10:15 from a `TreeMap<Instant, String>`. Inclusive or exclusive end? What happens to your result when a new entry is added at 10:05?
4. When would you choose `ConcurrentSkipListMap` instead? What does it not allow that `TreeMap` with a comparator might?
