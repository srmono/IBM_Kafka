1. Install Intellij community version
    https://www.jetbrains.com/idea/download/#section=windows 

2. Start kafka cluster with docker

3. Create project from Spring Initializer 
    https://start.spring.io/ 

4. 
https://stream.wikimedia.org/v2/stream/recentchange 

wikimedia_recentchange

kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic wikimedia_recentchange  --from-beginning



# Setup DB
 https://dev.mysql.com/downloads/mysql/ 

 mysql -u username -p password

 create database wikimedia;


# Steps to connect app with database

- Add dependencies to connect with database from springboot app
    - mysql conector
    - JPA
- add properties in application.properties

 












