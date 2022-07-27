
# Gateway Service

# General Infos

This Spring Service is configured and build to run inside a docker-compose environment.
Furthermore this Service depends on a Connection to the following Services:
1. [RabbitMQ-Service](https://github.com/HTW-KBE-G4/MessageBrokerService)
2. [Product-Service](https://github.com/HTW-KBE-G4/ProductService)
3. [Price-Service](https://github.com/HTW-KBE-G4/PriceService)
4. [Currency-Service](https://github.com/HTW-KBE-G4/CurrencyService)

This service also requires keycloak running at Port `8090`. Keycloak ist predefined in the docker-compose.yml [file](docker-compose.yml).

# How to run


First run the given Serices with given docker-compose configurations at given order above.

Then Start keycloak with
```shell
docker-compose up -d
```

Then execute the static [Java](src/main/java/de/tanukihardwarestore/GatewayService/GatewayServiceApplication.java) main method. 

