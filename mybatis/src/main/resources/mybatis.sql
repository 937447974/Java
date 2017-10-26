#建立库
DROP DATABASE mybatis;
CREATE DATABASE mybatis;
USE mybatis;

#建表
CREATE TABLE user (
  id       INT(32) PRIMARY KEY AUTO_INCREMENT,
  code     VARCHAR(32) NOT NULL,
  name     VARCHAR(50) NOT NULL,
  CONSTRAINT uk_code UNIQUE (code)
);