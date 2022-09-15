# Start kafka with docker

- Find docker-compose.core.yml file in github inside "docker_files" dir
- rename to "docker-compose.yml"
- pull zookeeper and kafka images from docker hub
    docker pull docker.io/bitnami/zookeeper:3.8
    docker pull docker.io/bitnami/kafka:3
- run below command to start kafka & zookeeper containers
    docker-compose up -d
- List available docker images  in local system
    docker images

- List running containers
    docker ps

container_id    conatainer_name
5da6ee98018e    kafka
f7a6d65b2d64    zookeeper

# Access container terminal

docker exec -it 5da6ee98018e bash

# Create topics inside container:

- kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t-ibm-one --partitions 1 --replication-factor 1
- kafka-topics.sh --bootstrap-server localhost:9092 --list
- kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic t-ibm-one
- kafka-topics.sh --bootstrap-server localhost:9092 --alter --topic t-ibm-one --partitions 2

----------------------------
# Producing message with key

kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t-multi-paritions --partitions 3 --replication-factor 1

t-multi-paritions

kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic t-multi-paritions

---------------------------------

# Kafka Cluster Docker yaml [docker_cluster directory]



docker-compose -f zk-single-kafka-single.yml -p simple up -d






