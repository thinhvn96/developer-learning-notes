# Exercise 0003: break the selector

[Tiếng Việt](0003-break-the-selector.vi.md)

Companion to [lesson 3](../lessons/0003-deployments-and-labels.html).

Change `selector.matchLabels` in `examples/deployment.yaml` to `app: web` but leave the template labels as `app: nginx`. Predict what `kubectl apply` says, then run it. Fix it, then scale to 5 replicas with `kubectl scale`. Which object's `replicas` did you change?
