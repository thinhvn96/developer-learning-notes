# Exercise 0007: ship and roll back

[Tiếng Việt](0007-ship-and-roll-back.vi.md)

Companion to [lesson 7](../lessons/0007-rolling-updates-and-rollbacks.html).

On a local cluster: deploy `nginx:1.14.2` with 4 replicas, update the image to `nginx:does-not-exist`, watch `kubectl rollout status` and `kubectl get pods`. Why does the service stay up? Then run `kubectl rollout undo`. Write the story in five lines.
