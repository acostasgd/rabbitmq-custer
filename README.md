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
