# Exercise 0004: wire a Service

Companion to [lesson 4](../lessons/0004-services.html).

Apply `deployment.yaml` and `service.yaml`. Run `kubectl get endpointslices` (or `kubectl get endpoints`). Delete a Pod and watch the addresses change. Change the Service selector to a wrong label and see the endpoints empty. What did each experiment show about how the Service finds Pods?
