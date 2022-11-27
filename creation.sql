CREATE DATABASE db_eyang_beauty CHARACTER SET 'utf8mb4';
USE db_eyang_beauty;

# Table user
CREATE TABLE user(
    id_user VARCHAR(8) PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15)
)ENGINE = InnoDB;

# Table customer
CREATE TABLE customer(
    id_customer VARCHAR(8) PRIMARY KEY,
    full_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    phone VARCHAR(15)
)ENGINE = InnoDB;

# Table reservation
CREATE TABLE reservation(
    id_reservation VARCHAR(8) PRIMARY KEY,
    date_time DATETIME NOT NULL UNIQUE,
    id_customer VARCHAR(8) NOT NULL,
    message VARCHAR(255),
    CONSTRAINT fk_reservation_customer
                        FOREIGN KEY (id_customer)
                        REFERENCES customer(id_customer)
)ENGINE = InnoDB;

# Table service
CREATE TABLE service(
    id_service VARCHAR(8) PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
)ENGINE = InnoDB;

# Table reservation_service
CREATE TABLE reservation_service(
    id_service VARCHAR(8) NOT NULL,
    id_reservation VARCHAR(8) NOT NULL,
    CONSTRAINT pk_reservation_service
                                PRIMARY KEY (id_reservation, id_service),
    CONSTRAINT fk_service
                                FOREIGN KEY (id_service)
                                REFERENCES service(id_service),
     CONSTRAINT fk_reservation
                                FOREIGN KEY (id_reservation)
                                REFERENCES reservation(id_reservation)
)ENGINE = InnoDB;
