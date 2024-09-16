1. build jar ```./mvnw package -DskipTests=true```
2. docker build image ```docker build --tag thread-test:0.0.1-SNAPSHOT .```
3. docker run ```docker-compose up -d```
4. run troops ```k6 run initial-test.js```
5. run knight ```k6 run main-test.js```