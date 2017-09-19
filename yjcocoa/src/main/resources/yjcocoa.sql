#建立库
CREATE DATABASE yjcocoa;
USE yjcocoa;

#建表
CREATE TABLE sys_user (
  id       INT(32) PRIMARY KEY AUTO_INCREMENT,
  code     VARCHAR(32),
  name     VARCHAR(50),
  password VARCHAR(32),
  state    VARCHAR(1)
);
CREATE TABLE customer (
  id         INT(32) PRIMARY KEY AUTO_INCREMENT,
  name       VARCHAR(50),
  user_id    INT(32),
  create_id  INT(32),
  source     VARCHAR(50),
  industry   VARCHAR(50),
  level      VARCHAR(32),
  linkman    VARCHAR(50),
  phone      VARCHAR(64),
  mobile     VARCHAR(16),
  zipcode    VARCHAR(10),
  address    VARCHAR(100),
  createtime DATETIME
);
CREATE TABLE base_dict (
  id        INT(32) PRIMARY KEY AUTO_INCREMENT,
  type_code VARCHAR(10),
  type_name VARCHAR(50),
  item_name VARCHAR(50),
  item_code VARCHAR(10),
  sort      INT(10),
  enable    CHAR(1),
  memo      VARCHAR(100)
);