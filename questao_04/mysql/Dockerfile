FROM mysql:5.6
ENV MYSQL_ROOT_PASSWORD secret
ENV MYSQL_DATABASE sd
ENV MYSQL_USER root
ENV MYSQL_PASSWORD secret

COPY create.sql /docker-entrypoint-initdb.d/
