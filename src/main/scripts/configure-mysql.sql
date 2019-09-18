# For Running in docker
#docker run --name mysqldb -p 3306:3306 -e MYSQL_ALLOW_EMPTY-PASSWORD=yes -d
# mysql
#localhost => %

CREATE database recipe_dev;
create database recipe_prod;

create user 'dev_user'@'localhost' identified by '1234';
create user 'prod_user'@'localhost' identified by '1234';

grant select on recipe_dev.* to 'dev_user'@'localhost';
grant insert on recipe_dev.* to 'dev_user'@'localhost';
grant delete on recipe_dev.* to 'dev_user'@'localhost';
grant update on recipe_dev.* to 'dev_user'@'localhost';

grant select on recipe_prod.* to 'prod_user'@'localhost';
grant insert on recipe_prod.* to 'prod_user'@'localhost';
grant delete on recipe_prod.* to 'prod_user'@'localhost';
grant update on recipe_prod.* to 'prod_user'@'localhost';