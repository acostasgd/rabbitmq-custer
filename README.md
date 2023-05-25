# Capstone project: task description

## Objective

Getting practical skills in setting up an HA RabbitMQ cluster using Docker and practice in integration with RabbitMQ from a Spring Boot application.

## Scope of the project

Get familiar with clustering in RabbitMQ https://www.rabbitmq.com/clustering.html

Setup a local dockerized RabbitMQ cluster of 3 nodes https://dzone.com/articles/rabbitmq-in-cluster

Create a durable eagerly synchronized mirrored queue with a direct exchange and a route between them https://www.rabbitmq.com/ha.html

Develop a Spring Boot application for publishing messages to the exchange at the given rate (i.e. 10 per second). https://github.com/piomin/sample-haclustered-rabbitmq-service/tree/master/sender

Develop a Spring Boot application for listening and logging received messages from the queue. https://github.com/piomin/sample-haclustered-rabbitmq-service/tree/master/listener

Run publishing and listening applications and use RabbitMQ UI to dynamically observe running cluster.

Shutdown the first RabbitMQ node and make sure the flow keeps working

Restart the first RabbitMQ node and make sure it joined the cluster

# RabbitMQ cluster deployment

## RabbitMQ node deployment

To deploy rabbitMQ cluster run docker-compose.yaml.

The docker-compose.yaml includes configuration to deploy three containers of rabbitMQ and link them to each other.

## RabbitMQ node clustering

Connect to container green-rabbitmq and run following commands:
```
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl start_app
```

Connect to container yellow-rabbitmq and run following commands:
```
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster --ram rabbit@green-rabbitmq
rabbitmqctl start_app
```

Connect to container red-rabbitmq and run following commands:
```
rabbitmqctl stop_app
rabbitmqctl reset
rabbitmqctl join_cluster --ram yellow@green-rabbitmq
rabbitmqctl start_app
```

Once all nodes are configured together, login to any node and rename the cluster to appropriate name.
