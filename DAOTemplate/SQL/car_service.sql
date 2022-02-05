CREATE DATABASE car_service;

USE car_service;

DROP TABLE car;

CREATE TABLE car(
                    id INT NOT NULL AUTO_INCREMENT,
                    mark INT NOT NULL,
                    model VARCHAR(20),
                    price INT NOT NULL,
                    PRIMARY KEY(id),
                    FOREIGN KEY (mark) REFERENCES mark(id));

DROP TABLE mark;

CREATE TABLE mark(
                     id INT NOT NULL AUTO_INCREMENT UNIQUE,
                     mark_name VARCHAR(20));

ALTER TABLE mark ADD PRIMARY KEY (id);

CREATE TABLE owner(
                      id INT NOT NULL AUTO_INCREMENT,
                      name VARCHAR(20),
                      PRIMARY KEY(id));

CREATE TABLE car_owner(
                        id_car INT NOT NULL,
                        id_owner INT NOT NULL,
                        PRIMARY KEY(id_car, id_owner),
                        FOREIGN KEY (id_car) REFERENCES car(id),
                        FOREIGN KEY (id_owner) REFERENCES owner(id));