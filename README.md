docker run -p 3306:3306 --name=docker-mysql --env="MYSQL_ROOT_PASSWORD=secret" --env="MYSQL_PASSWORD=secret" --env="MYSQL_DATABASE=employee" mysql

docker run --name employee-mysql -e MYSQL_ROOT_PASSWORD=secret -d mysql:latest

docker run -it --rm mysql mysql -hlocalhost -uroot -p

./mvnw package
./mvnw spring-boot:run
./mvnw install dockerfile:build
docker-compose up -d