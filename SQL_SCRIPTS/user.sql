CREATE DATABASE IF NOT EXISTS users;
USE users;

CREATE TABLE user
(
  userId      INT AUTO_INCREMENT
    PRIMARY KEY,
  firstName   VARCHAR(128) NOT NULL,
  surnName    VARCHAR(45)  NOT NULL,
  user_name   VARCHAR(45)  NOT NULL,
  password    CHAR(255)    NULL,
  access_code INT          NULL,
  CONSTRAINT userId_UNIQUE
  UNIQUE (userId),
  CONSTRAINT user_name_UNIQUE
  UNIQUE (user_name)
)
  ENGINE = InnoDB;