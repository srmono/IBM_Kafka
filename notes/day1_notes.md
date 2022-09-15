#IBM Kafka Training September 2022 

#System Requirement

- System with 8 GB
- Hypervisor Support to test with docker
- abount 50 GB free space
- Operating System Mac / Windows / Linux
- Open internet access

Java: Done 
Docker?
------------------------------------------
Install Docker:

# Step 1: enable Hyper V ?
Controlpanel -> 
  Programs and features -> 
    (left side ) windows features on and off

Select below options from pop up: 
  Hyper-V 
  Windows Subsystem for linux 

Ok  and then follow the steps and restart 

# Step 2: Install WSL manually 
Download and Install 

  https://wslstorestorage.blob.core.windows.net/wslblob/wsl_update_x64.msi

Step 3: Download Docker Desktop for windows

https://docs.docker.com/desktop/install/windows-install/

https://desktop.docker.com/win/main/amd64/Docker%20Desktop%20Installer.exe 


-----------------------------------------------
Install Kafka

# Step 1
- Download and install jdk 11 for your respective OS(Mac/Win/Linux) - 
https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html

# Step 2
- Download Kafka from - 
https://dlcdn.apache.org/kafka/3.1.0/kafka_2.13-3.1.0.tgz 

Extract with softwares like 7 zip / win zip etc

Create a "kafka" directory  inside  C drive and keep all kafka files in it  

Note Windows Users: install wsl2 first - https://docs.microsoft.com/en-us/windows/wsl/install
-------------------------------------


Start Kafka 

Configure: C:/kafka/config/
server.properties:
  log.dirs=C:/kafka/kafka-logs

zookeeper.properties:
  dataDir=C:/kafka/zookeeper-data


Launch: 
 cd C:\kafka

 Start zookeeper:
     .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

 Start Kafka:
    .\bin\windows\kafka-server-start.bat .\config\server.properties

------------------------------
CLI: 
From: C:\kafka

# Create topic:

   .\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic ibmdemotopic
   .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 2 --partitions 1 --topic ibmdemotopic
   .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ibmdemotopictwo

   .\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic ibmapptopic

   .\bin\windows\kafka-topics.bat 
      --create 
      --zookeeper localhost:2181 
      --replication-factor 2 
      --partitions 1 
      --topic ibmdemotopic

# List topics:
  .\bin\windows\kafka-topics.bat --list --zookeeper localhost:2181


# Producer CLI:
  .\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic ibmdemotopictwo

  .\bin\windows\kafka-console-producer.bat 
      --broker-list localhost:9092 
      --topic ibmdemotopictwo

Read messages from consumer:
  .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic ibmdemotopictwo --from-beginning

  .\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic ibmapptopic --from-beginning 


  .\bin\windows\kafka-console-consumer.bat 
      --bootstrap-server localhost:9092 
      --topic ibmdemotopictwo
      --from-beginning 

--------------------------------------------------------
Why we need ESB
real time stream of data
send message async / sync
any kind of streaming / event based system

# Monolithic
  view
  BL
  DB
  Service

# Microserivce
  login
  SSO
  Stock
  Product
  video
  comments
  likes
  dislikes....
  
# ESB Service Providers
  Open MQ
  Rabbit MQ
  Tibco
  Mule soft
  Kafka ...
  
# Kafka
  JVM - Platform Independent
  Scala
  Groovy, ruby,R etc...
  java upto 8 - did not support functional feature ->
  3.x - with Scala + Java
  -> it becomes by default asycn / support reactive / sync
  
In DB you can query, in kafka cluster you cannot query
  to send message you need kafka producer
  to receive message you need kafka consumer - Have to listen to Topic

- by default every message is kept for 1 week
- when you create a topic by default there shall be 1 partition
- kafka 2.x - zookeeper is mandatory
- kafka 3.x - zookeeper is not mandatory - there is another tool called raft for kafka which is called kraft
- kafka 4.x - zookeeper shall be removed

----------------------------------------------------- 

# Step to start kafka

  zookeeper-server-start.sh /Volumes/Kanchan/Softwares/kafka/kafka-3.1.0/config/zookeeper.properties

  kafka-server-start.sh /Volumes/Kanchan/Softwares/kafka/kafka-3.1.0/config/server.properties

  kafka-server-start.sh ../../config/server.properties

  kafka-topics.sh --bootstrap-server localhost:9092 --list

  kafka-topics.sh --bootstrap-server localhost:9092 --create --topic first-topic

  kafka-topics.sh --bootstrap-server localhost:9092 --describe (describe all the topics)

  kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic ibm-first-topic (describe specific topic)

  kafka-console-producer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic --from-beginning
---------------------------------------------------
# producer sending messages with key

  kafka-console-producer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic --property parse.key=true --property key.separator=:

      somekey:somevalue
      orderno:12345

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic --property parse.key=true --property key.separator=: (this consumer shall not print the key values FYI)

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic --property parse.key=true --property key.separator=: --property print.key=true --property print.timestamp=true --formatter kafka.tools.DefaultMessageFormatter

----------------------------------------------

# working with partitions
  kafka-topics.sh --bootstrap-server localhost:9092 --create --topic ibm-second-topic --partitions 3

  kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic ibm-second-topic

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-first-topic --group my-first-group

  kafka-topics.sh --bootstrap-server localhost:9092 --topic ibm-second-topic --describe

  kafka-console-producer.sh --bootstrap-server localhost:9092 --topic ibm-second-topic

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-second-topic

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-second-topic --group p-first-group

  kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic ibm-second-topic --group p-second-group


---------------------------------------------
logging.pattern.console: value

logging:
  pattern:
    console: "[Kafka Core Consumer] %clr(%d{HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:%5p}) %clr(---){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:%wEx}"

logging:
  pattern:
    console: "[Kafka Core Producer] %clr(%d{HH:mm:ss.SSS}){faint} %clr(${LOG_LEVEL_PATTERN:%5p}) %clr(---){faint} %clr(%-40.40logger{39}){cyan} %clr(:){faint} %m%n${LOG_EXCEPTION_CONVERSION_WORD:%wEx}"

