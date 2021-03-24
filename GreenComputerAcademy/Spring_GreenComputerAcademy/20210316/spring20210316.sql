USE jspdb;
CREATE TABLE dummy(
	num INT PRIMARY KEY AUTO_INCREMENT,
	id VARCHAR(20) NOT null,
	pw VARCHAR(50) NOT NULL,
	content TEXT NOT null
	);
DROP TABLE dummy;
ALTER TABLE dummy ADD COLUMN savedfile VARCHAR(100);
ALTER TABLE dummy ADD COLUMN originfile VARCHAR(100);
ALTER TABLE dummy CHANGE COLUMN originfile ofile VARCHAR(100);

SELECT * FROM dummy;

INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');
INSERT INTO dummy VALUES(NULL,'joo333','3333','content111');




CREATE TABLE spmember(
   idx INT PRIMARY KEY AUTO_INCREMENT,
   id VARCHAR(20) NOT NULL UNIQUE,
   pw varchar(50) NOT NULL,
   NAME VARCHAR(50) NOT NULL
);

INSERT INTO spmember VALUES (NULL,'asdf','pwpw','김똘똘');
CREATE TABLE spboard(
   idx INT PRIMARY KEY AUTO_INCREMENT,
   title VARCHAR(50) NOT NULL,
   writer VARCHAR(50) NOT NULL,
   regDate DATE NOT null,
   content TEXT NOT NULL,
   hit INT DEFAULT 0
);
