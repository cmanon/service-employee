# REST Service Demo

In order to test the demo you need Docker installed.

Every time you start the service a .sql file (main/resources/mysql-data.sql) is loaded into the database, and all the previous data and schema is recreated. The test data was created using http://mockaroo.com.

For development purposes you can start a MySql docker instance with:

```
docker run -p 3306:3306 --name=employee-mysql --env="MYSQL_ROOT_PASSWORD=secret" --env="MYSQL_USER=employeeuser" --env="MYSQL_PASSWORD=secret" --env="MYSQL_DATABASE=employee" mysql
```

The solution uses Spring Boot to start the server once MySql is running:

```
./mvnw spring-boot:run
```

To build the Docker container:

```
./mvnw clean package dockerfile:build
```

In the solution is included also a docker-compose.yml file once the service Docker image is built, you can start the solution including MySql using:

```
docker-compose up -d
```

To delete (soft) a record using the API use basic authentication:

```
curl -i -X DELETE http://localhost:8080/api/employee/101 -u admin:admin
```