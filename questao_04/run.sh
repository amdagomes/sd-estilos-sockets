docker build -t sd/postgres ./postgres
docker run -p 5433:5432 --name bdpostgres -d sd/postgres 

docker build -t sd/mysql ./mysql
docker run -p 3306:3306 --name bdmysql  sd/mysql 
