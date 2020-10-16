CREATE DATABASE climbing_website_db;

CREATE USER 'admin'@'localhost' IDENTIFIED BY 'lesamisdelescalade';
ALTER USER 'admin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'lesamisdelescalade';

REVOKE ALL PRIVILEGES, GRANT OPTION FROM 'admin'@'localhost';
GRANT ALL PRIVILEGES ON climbing_website_db.*  TO 'admin'@'localhost';