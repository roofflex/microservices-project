This project consists of 4 microservices:
- Spring Cloud config server
- Eureka naming server
- limits service
- currency exchange rates service
- currency conversion service
- API Gateway

To take a look at this you just need a docker on your machine. If you have one, clone this project, cd into it and run ```docker compose up -d```

This will start all the containers in a detached mode, wait a few minutes until they're up.

Links to explore:
- http://localhost:8761 - Eureka - monitor instances and their state
- http://localhost:9411 - Zipkin - trace requests
- http://localhost:8080/api/v1/limits - Limits service - get the limits
- http://localhost:8888/limits-service/dev - Cloud Config Service - get DEV properties for the Limits service
- http://localhost:8000/api/v1/currency-exchange-rate?from=USD&to=EUR - Currency exchange rates service - get rate USD -> EUR
- http://localhost:8100/api/v1/currency-conversion?from=USD&to=EUR&quantity=10.0 - Currency conversion service - convert 10 USD -> EUR 
- http://localhost:8765/currency-exchange-rates-service/api/v1/currency-exchange-rate?from=USD&to=EUR - Request to get rate USD -> EUR through API Gateway
- http://localhost:8765/currency-conversion-service/api/v1/currency-conversion?from=USD&to=EUR&quantity=15.0 - Request to convert 15 USD to EUR through API Gateway 
