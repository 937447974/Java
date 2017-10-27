#建立库
DROP DATABASE mybatis;
CREATE DATABASE mybatis;
USE mybatis;

# 关系说明：一个开发人员主要只负责一种开发语言，但是他又同时掌握几种开发语言。


#建表
CREATE TABLE language (
  id   INT(32) PRIMARY KEY AUTO_INCREMENT,
  code VARCHAR(32) NOT NULL UNIQUE,
  name VARCHAR(50) NOT NULL
);
CREATE TABLE user (
  id            INT(32) PRIMARY KEY AUTO_INCREMENT,
  code          VARCHAR(32) NOT NULL UNIQUE,
  name          VARCHAR(50) NOT NULL,
  language_code VARCHAR(32),
  CONSTRAINT FOREIGN KEY (language_code) REFERENCES language (code)
);
CREATE TABLE user_language (
  id            INT(32) PRIMARY KEY AUTO_INCREMENT,
  user_code     VARCHAR(32) NOT NULL,
  language_code VARCHAR(32) NOT NULL,
  CONSTRAINT UNIQUE (user_code, language_code),
  CONSTRAINT FOREIGN KEY (user_code) REFERENCES user (code)
    ON DELETE CASCADE,
  CONSTRAINT FOREIGN KEY (language_code) REFERENCES language (code)
    ON DELETE CASCADE
);

# 查看表结构
DESCRIBE language;
DESCRIBE user;
DESCRIBE user_language;

# insert
INSERT language (code, name)
VALUES ('1', 'Java'), ('2', 'iOS'), ('3', 'JavasScript'), ('4', 'SQL');
INSERT user (code, name, language_code)
  VALUE ('937447974', '阳君', '1');
INSERT user_language (user_code, language_code)
VALUES ('937447974', '1'), ('937447974', '2');