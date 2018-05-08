# Simple Kafka Consumer-Producer example

## Steps to run the project

1. Download the Kafka 0.10.0.0 binary  
	`cd kafka_2.11-0.10.0.0`

2. Run the zookeeper & kafka server  
	`bin/zookeeper-server-start.sh config/zookeeper.properties`  
	`bin/kafka-server-start.sh config/server.properties`  

3. Create the topics manually using the kafka cli  
	`bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic odd`  
	`bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic even`  

	Check if the topics are created  
	`bin/kafka-topics.sh --list --zookeeper localhost:2181`

4. Clone this repo  
	`git clone https://github.com/thejasbabu/kafka-example.git`

5. Compile and package the project  
	`mvn clean compile package`

6. Run the Consumer,Producer and Stream program  
	`java -jar ./target/1-1.0-SNAPSHOT-jar-with-dependencies.jar "consumer"`  
	`java -jar ./target/1-1.0-SNAPSHOT-jar-with-dependencies.jar "producer"`  
	`java -jar ./target/1-1.0-SNAPSHOT-jar-with-dependencies.jar "stream"`

 
