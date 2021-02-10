USE SQLdb;
SELECT * FROM usertbl;
-- 인덱스 연습 --------------------------------------------
ALTER TABLE usertbl DROP PRIMARY KEY;
ALTER TABLE usertbl ADD PRIMARY KEY (NAME);

CREATE TABLE tbl1(
	a INT PRIMARY KEY,
	b INT ,
	c INT 
);
SHOW INDEX FROM tbl1;

CREATE TABLE tbl2 (
	a INT PRIMARY KEY,
	b INT UNIQUE,
	c INT UNIQUE,
	d INT
);
SHOW INDEX FROM tbl2;

CREATE TABLE tbl3(
	a INT UNIQUE,
	b INT UNIQUE,
	c INT UNIQUE,
	d int
);
SHOW INDEX FROM tbl3;

CREATE TABLE tbl4(
	a INT UNIQUE NOT NULL ,shopdb
	b INT UNIQUE,
	c INT UNIQUE,
	d int
);
SHOW INDEX FROM tbl4;
INSERT INTO tbl4 VALUES(5,0,0,3),(4,1,1,4),(3,2,2,2);


CREATE TABLE tbl5(
	a INT UNIQUE NOT NULL ,
	b INT UNIQUE,
	c INT UNIQUE,
	d INT PRIMARY key
);
INSERT INTO tbl5 VALUES(5,0,0,3),(4,1,1,4),(3,2,2,2);
SELECT * FROM tbl4;
SELECT * FROM tbl5;
SHOW INDEX FROM tbl5;
------------------------------------------------

SHOW VARIABLES LIKE 'innodb_ft_min_token_size';
