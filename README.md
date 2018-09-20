
# Spring Cloud demo

* A demo of a simple User service through Spring cloud suite

## Running the application

**1. Run Zipkin Server**

java -jar zipkin-server-1.28.0-exec.jar

*UI available at http://localhost:9411/zipkin/*

**2. Start the config server**

**set environment variables for Windows** 

set GITHUB_USER=<your_username>  
set GITHUB_PASS=<your_password>

**set environment variables for Linux**

export GITHUB_USER=<your_username>  
export GITHUB_PASS=<your_password>

**Start the server**  
java -jar config-server-0.0.1-SNAPSHOT.jar

**3. Run Eureka Server**

java -jar service-registry-0.0.1-SNAPSHOT.jar

*Note : Eureka dashboard available at - http://localhost:8761*

**4. Run Zuul Proxy Server**

java -jar api-gateway-0.0.1-SNAPSHOT.jar --server.port=8081

**5. Run two instances of the user service**

java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8181  
java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8182

#### API Documentation with Swagger

http://localhost:8181/swagger-ui.html  
http://localhost:8182/swagger-ui.html

## Hystrix Dashboard 

http://localhost:8181/hystrix  
http://localhost:8182/hystrix

## Testing

Hit the micro service through a proxy :

Format : http://<zuul_host>:<zuul_port>/<name_of_microservice_in_eureka>/<url>

Ex- http://localhost:8081/api/user-app/user/getbyid/1

Note : 

* Here we have done a url prefixing with : zuul.prefix=/api/ 