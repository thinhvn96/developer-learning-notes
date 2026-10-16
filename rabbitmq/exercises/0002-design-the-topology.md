# Exercise 0002: design the topology

Companion to [lesson 2](../lessons/0002-exchange-types.html). · [Tiếng Việt](0002-design-the-topology.vi.md)

Design exchanges, queues and bindings for: (a) all order events go to an audit queue; (b) EU orders also go to an EU fulfilment queue; (c) only `payment.failed` events go to a support queue. State the exchange type for each and the binding keys. Modify the example script to build it and prove routing with `routed:true/false`.
