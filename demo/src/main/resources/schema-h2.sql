DROP TABLE if exists STUDENT;
CREATE TABLE STUDENT (
  SNO VARCHAR2(3) NOT NULL primary key,
  SNAME VARCHAR2(9) NOT NULL ,
  SSEX CHAR(2) NOT NULL ,
  database VARCHAR2(10) NULL
);