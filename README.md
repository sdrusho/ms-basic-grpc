**ms-basic-auth**

Added spring boot micro service for grpc request server and client

Build: mvn clean install

Run: mvn spring-boot:run 


Client running on port: 8080

grpc server running on port: 9090

Api for client request
[GET] http://localhost:8080/basic/user?name=rusho


Response:
Hello, rusho!
