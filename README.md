# Requirements

1. Java 8 installed [link](https://adoptopenjdk.net/?variant=openjdk8&jvmVariant=hotspot)
2. Docker installed [link](https://www.docker.com/get-started)
3. Maven installed (optional) [link](https://maven.apache.org/download.cgi)

# Rest tests

1. Clone github project ([full instructions](https://microservices-demo.github.io/deployment/docker-compose.html))
    ```shell
    git clone git@github.com:microservices-demo/microservices-demo.git
    ```
2. Run docker compose
   ```shell
   docker-compose -f deploy/docker-compose/docker-compose.yml up -d
   ```
3. Run tests
   ```shell
   ./mvnw test
   ```

# Info

Tests configuration can be defined in [config.properties](./src/test/resources/config.properties). Tests itself is
in [directory](./src/test/java/some/kind/of/tests). In general, tests are orchestrated
through [ApiHandler](./src/test/java/some/kind/of/framework/api/ApiHandler.java), it is easily extendable. API
definitions and POJOs is in [api directory](src/test/java/some/kind/of/framework/api).