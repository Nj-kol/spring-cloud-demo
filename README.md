
# Spring Cloud demo

* A demo of a simple User service through Spring cloud suite

## Running the application

1. Run Eureka 

java -jar service-registry-0.0.1-SNAPSHOT.jar

Note : Eureka dashboard available at - http://localhost:8761

2. Run Zuul

java -jar api-gateway-0.0.1-SNAPSHOT.jar --server.port=8081

3. Run two instances of the service

java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8181
java -jar user-service-0.0.1-SNAPSHOT.jar --server.port=8182

#### API Documentation with Swagger

http://localhost:8181/swagger-ui.html
http://localhost:8182/swagger-ui.html

## Testing

Hit the micro service through a proxy :

Format : http://<zuul_host>:<zuul_port>/<name_of_microservice_in_eureka>/<url>

Ex- http://localhost:8081/api/user-app/user/getbyid/1

Note : 

* Here we have done a url prefixing with : zuul.prefix=/api/ 