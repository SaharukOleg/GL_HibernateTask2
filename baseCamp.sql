CREATE DATABASE IF NOT EXISTS GLTask;
USE GLTask;

CREATE TABLE IF NOT EXISTS  department(
    id INT NOT NULL AUTO_INCREMENT,
    department_name VARCHAR(30) NOT NULL,
    status BIT(1) NOT NULL,
	  PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS  worker (
    id INT NOT NULL AUTO_INCREMENT,
    age INT(10) NOT NULL,
    availability  ENUM('FULL_TIME' , 'PART_TIME') NOT NULL,
    full_name VARCHAR(30) NOT NULL,
    department_id INT ,
    FOREIGN KEY(department_id) REFERENCES department(id),
	  PRIMARY KEY (id)
);


