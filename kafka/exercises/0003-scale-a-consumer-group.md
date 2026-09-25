# Exercise 0003: scale a consumer group

Companion to [lesson 3](../lessons/0003-consumers-groups-and-offsets.html).

You have a topic with 6 partitions. What is the maximum useful number of consumers in one group? Predict what `kafka-consumer-groups.sh --describe` shows with 2, 6 and 8 consumers. Then start console consumers in separate terminals inside the throwaway container to confirm (hint: keep the container running by running the commands by hand).
