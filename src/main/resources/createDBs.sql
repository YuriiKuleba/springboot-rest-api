--MySQL:

CREATE DATABASE  data_base_1;
USE data_base_1;

CREATE TABLE data_base_1.users (
  id int NOT NULL AUTO_INCREMENT,
  username varchar(255),
  name varchar(255),
  surname varchar(255),
  PRIMARY KEY (id)
);

INSERT INTO users(username, name, surname)
VALUES
	('db1_user_1', 'Spring', 'Bootko'),
	('db1_user_2', 'Despatcher', 'Servletoff'),
	('db1_user_3', 'User', 'Userenko');
	
########################################################

--Postgres:

CREATE DATABASE  data_base_2;

CREATE TABLE data_base_2.users
(
id serial primary key,
username VARCHAR(255),
name VARCHAR(255),
surname VARCHAR(255)
);

INSERT INTO users(username, name, surname)
VALUES
	('db2_user_1', 'Aws', 'Cloudko'),
	('db2_user_2', 'Google', 'Platformich'),
	('db2_user_3', 'Azure', 'Microsoftoff');
	




