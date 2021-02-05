USE sqldb;
DROP DATABASE IF EXISTS testdb;

-- 기본키 유니크키(대체키) 외래키-----------------------------------------
CREATE TABLE testtbl5 (
idx INT,
id VARCHAR(20),
pw VARCHAR(20)
);

INSERT INTO testtbl5 VALUES(null,'id12','pw1');
SELECT * FROM testtbl5;
DROP TABLE testtbl5;
CREATE TABLE testtbl5 (
idx INT AUTO_INCREMENT PRIMARY key,
id VARCHAR(20) NOT NULL UNIQUE,
pw VARCHAR(20) NOT NULL
);

SELECT * FROM buytbl;
SELECT * FROM usertbl;

SHOW INDEX FROM testtbl5;

CREATE TABLE testtbl6(
idx INT PRIMARY KEY AUTO_INCREMENT,
id VARCHAR(20) NOT NULL,
prod VARCHAR(50) NOT NULL,
constraint fk_testtbl5_testtbl6 FOREIGN KEY(id) REFERENCES TESTTBL5(id)
);
INSERT INTO testtbl6 VALUES(NULL, 'id1','세탁기');
SELECT * FROM testtbl6;
DROP TABLE testtbl6;
SHOW INDEX FROM 
-- 주석에는 -- 뒤에 스페이스 한칸 필요
testtbl6;
DROP TABLE testtbl5 CASCADE;

-- 디폴트-------------------------------------

CREATE TABLE testtbl7(
idx INT AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(20) UNIQUE NOt NULL,
pw VARCHAR(20) NOT NULL,
age INT CHECK (age>10)
);
INSERT INTO testtbl7 values(NULL,'id1', 'pw1', 20);
INSERT INTO testtbl7 values(NULL,'id1', 'pw1', 10);
CREATE TABLE testtbl8 (
id INT AUTO_INCREMENT PRIMARY key,
lv INT DEFAULT 1
);
DROP TABLE testtbl8;
INSERT INTO testtbl8(id) VALUES(NULL);
INSERT INTO testtbl8 VALUES(NULL,default);
SELECT * FROM testtbl8;

-- 임시테이블---------------------------------------

CREATE TEMPORARY TABLE ttt1(
id VARCHAR(20)
);
SELECT * FROM ttt1;
INSERT INTO ttt1  VALUES(10);
DROP TABLE ttt1;
-- 뷰 ---------------------------------------

CREATE VIEW v_userbuytbl
AS
	SELECT u.userid AS 'user id' , u.name AS 'user name' , b.prodname AS 'product name' , u.addr , CONCAT(u.mobile1, u.mobile2) AS 'mobile phone' 
	FROM usertbl u
	INNER JOIN buytbl b
	ON u.userID = b.userid;
SELECT * FROM v_userbuytbl;
DESC v_userbuytbl;

DESC usertbl;
DESC buytbl;
INSERT INTO usertbl
VALUES ('CHS','최홍석','1990','부산','010','58784885',175,'2021-02-05');

-- 테이블 수정---------------------------------------------

DESC buytbl;
SHOW INDEX FROM buytbl;

CREATE TABLE testtbl9(
idx INT,
NAME VARCHAR(20)
);
ALTER TABLE testtbl9
	ADD unique(NAME);
SHOW INDEX FROM testtbl9;
ALTER TABLE testtbl9
	DROP INDEX NAME;
DESC testtbl9;
ALTER TABLE testtbl9
	ADD id VARCHAR(20) UNIQUE;
ALTER TABLE testtbl9
	CHANGE COLUMN id id VARCHAR(20) NOT NULL UNIQUE ;
ALTER TABLE testtbl9
	drop INDEX id_3;
CREATE INDEX idunique
	ON testtbl9(id);
DROP INDEX idunique
	ON testtbl9;
CREATE UNIQUE INDEX id
	ON testtbl9(id);
	
-- 테이블 수정 연습---------------------------------------------------
CREATE database tabledb default CHARACTER SET utf8 collate UTF8_GENERAL_ci;
DROP TABLE if EXISTS buytbl, usertbl;
USE tabledb;

CREATE TABLE usertbl(
userID CHAR(8),
name nvarchar(10),
birthYear INT,
addr nchar(2),
mobile1 CHAR(3),
mobile2 CHAR(8),
height SMALLINT,
mDate DATE
);
CREATE TABLE buytbl (
num INT AUTO_INCREMENT PRIMARY KEY,
userid CHAR(8),
prodName nchar(6),
groupName nchar(4),
price INT,
amount SMALLINT
);

INSERT INTO usertbl VALUES('LSG',N'이승기',1987,N'서울','011','11111111', 182,'2008-8-8'),('KBS','김범수', NULL, N'경남','011','22222222',173,'2012-4-4');
INSERT INTO usertbl VALUES('KKH',N'김경호',1871,N'전남','019','33333333', 177,'2007-7-7'),('JYP','조용필', 1950, N'경기','011','44444444',166,'2009-4-4');
INSERT INTO buytbl VALUES(NULL,'KBS',N'운동화',NULL,30, 2),(NULL,'KBS',N'노트북',n'전자',1000, 1);
INSERT INTO buytbl VALUES(NULL,'JYP',N'모니터',n'전자',200, 1),(NULL,'BBK',N'모니터',n'전자',200, 5);

ALTER TABLE usertbl
	ADD CONSTRAINT pk_usertbl_userid
	PRIMARY KEY (userid);
SHOW INDEX from usertbl;

ALTER TABLE buytbl
	ADD CONSTRAINT fk_usertbl_buytbl
	FOREIGN KEY (userid)
	REFERENCES usertbl(userid);
DELETE FROM buytbl WHERE USERid = 'bbk';

SET foreign_key_checks = 0;
INSERT INTO buytbl VALUES(NULL,'BBK',n'모니터',n'전자',200,5);
INSERT INTO buytbl VALUES(NULL,'KBS',n'청바지',n'의류',50,3);
INSERT INTO buytbl VALUES(NULL,'BBK',n'메모리',n'전자',80,10);
INSERT INTO buytbl VALUES(NULL,'SSK',n'책',n'서적',15,5);
INSERT INTO buytbl VALUES(NULL,'EJW',n'책',n'서적',15,2);
INSERT INTO buytbl VALUES(NULL,'EJW',n'청바지',n'의류',50,1);
INSERT INTO buytbl VALUES(NULL,'BBK',n'운동화',NULL,30,2);
INSERT INTO buytbl VALUES(NULL,'EJW',n'책',n'서적',15,1);
INSERT INTO buytbl VALUES(NULL,'BBK',n'운동화',NULL,30,2);
SELECT * FROM BUYTBL;
SET FOREIGN_KEY_CHECKS = 1;

SET check_constraint_checks = 0;
ALTER TABLE usertbl
	ADD CONSTRAINT ck_birthyear
	CHECK ( (birthyear >=1900) AND (birthYear <=2020) AND (birthYear IS NOT NULL));
SET check_constraint_checks = 1;
DESC usertbl;
SELECT * FROM Information_schema.table_constraints WHERE TABLE_NAME='buytbl' AND table_schema = 'tabledb';

INSERT INTO usertbl VALUES('SSK',N'성시경',1979,N'서울',NULL,NULL,186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB',N'임재범',1963,N'서울','016','66666666',182,'2009-9-9');
INSERT INTO usertbl VALUES('YJS',N'윤종신',1969,N'경남',NULL,NULL,170,'2005-5-5');
INSERT INTO usertbl VALUES('EJW',N'은지원',1972,N'경북','011','88888888',174,'2014-3-3');
INSERT INTO usertbl VALUES('JKW',N'조관우',1965,N'경기','018','99999999',172,'2010-10-10');
INSERT INTO usertbl VALUES('BBK',N'바비킴',1973,N'서울','010','00000000',176,'2013-5-5');

SET FOREIGN_key_checks = 0;
UPDATE usertbl SET userid ='VVK' WHERE userid='bbk';
SET FOREIGN_key_checks = 1;

SELECT * FROM usertbl WHERE userid= 'vvk';	

SELECT b.userid , u.name, b.prodname , u.addr , CONCAT(u.mobile1, u.mobile2) AS '연락처' 
	FROM buytbl b
	INNER JOIN usertbl u
	ON b.userid = u.userid;
SELECT b.userid , u.name, b.prodname , u.addr , CONCAT(u.mobile1, u.mobile2) AS '연락처' 
	FROM buytbl b
	LEFT OUTER JOIN usertbl u
	ON b.userid = u.userid
	ORDER BY b.userid;
SET foreign_key_checks=1;
UPDATE usertbl set userid = 'BBK' WHERE userid = 'vvk';

ALTER TABLE buytbl
 DROP FOREIGN KEY fk_usertbl_buytbl;
ALTER TABLE buytbl
 ADD CONSTRAINT fk_usertbl_buytbl
 FOREIGN KEY (userid)
 REFERENCES usertbl (userid)
 ON UPDATE CASCADE
 ON DELETE CASCADE;
UPDATE usertbl SET userid= 'VVK' WHERE userid='bbk';
SELECT b.userid , u.name, b.prodname , u.addr , CONCAT(u.mobile1, u.mobile2) AS '연락처' 
	FROM buytbl b
	INNER JOIN usertbl u
	ON b.userid = u.userid
	ORDER BY b.userid;
DELETE FROM usertbl WHERE userid = 'vvk';
SELECT * FROM usertbl;
ALTER TABLE usertbl 
	DROP COLUMN birthYear;
	
-- ------------------------------------------------------
USE orally;

-- alter 문제 - my_contacts 사용

-- 1. location 컬럼의 값을 이용하여 states 와 city의 2개 컬럼 추가.
--    각각 값을 맞춰 넣기. 이후 location은 삭제
--    ex) Palo Alto, CA => CA는 states, Palo Alto는 city
ALTER TABLE my_contacts
	ADD COLUMN (states VARCHAR(2), city VARCHAR(20));
UPDATE my_contacts
	SET states = SUBSTRING_INDEX(location,', ',-1) ,city = SUBSTRING_INDEX(location,', ',1);
ALTER TABLE my_contacts
	DROP COLUMN location;
	
-- 2. interests 테이블 만들기.
--    만들어진 interests 테이블에 자동증가하는 idx 컬럼추가
--    interests 컬럼의 값들은 중복되지 않게 한 행에 하나의 값만 가질수 있게해서 넣기
--    이후 interests 컬럼 삭제.
CREATE TABLE interests (
	idx INT AUTO_INCREMENT PRIMARY KEY,
	interest VARCHAR(20) UNIQUE NOT NULL
); 

CREATE TEMPORARY TABLE tmptbl (
	interests VARCHAR(40)
);
INSERT INTO tmptbl SELECT interests FROM my_contacts WHERE interests IS NOT NULL;
ALTER TABLE tmptbl
	add COLUMN (i1 VARCHAR(20) , i2 VARCHAR(20) , i3 VARCHAR(20));
update tmptbl SET i1 = SUBSTRING_INDEX(interests,',',1);
UPDATE tmptbl SET interests = case
	when (SUBSTRING(interests,LENGTH(i1)+2) = "") = 0 then SUBSTRING(interests,LENGTH(i1)+2)
	when	(SUBSTRING(interests,LENGTH(i1)+2) = "") = 1 then NULL
	END;
update tmptbl SET i2 = SUBSTRING_INDEX(interests,',',1);
UPDATE tmptbl SET interests = case
	when (SUBSTRING(interests,LENGTH(i2)+2) = "") = 0 then SUBSTRING(interests,LENGTH(i2)+2)
	when	(SUBSTRING(interests,LENGTH(i2)+2) = "") = 1 then NULL
	ELSE null
	END;
update tmptbl SET i3 = interests;
UPDATE tmptbl SET i2 = TRIM(i2), i3 = TRIM(i3);
INSERT INTO interests
	SELECT NULL AS n,tmp.* FROM
	(
	SELECT i1 FROM tmptbl
	UNION
	SELECT i2 FROM tmptbl
	UNION
	SELECT i3 FROM tmptbl
	) AS tmp 
	WHERE tmp.i1 IS NOT NULL 
	ORDER BY tmp.i1;

SELECT * FROM interests;
ALTER TABLE my_contacts
	DROP COLUMN interests;
	
-- 3. gender 컬럼 수정. not null, varchar(70).
--    이후 값 변경. F는 Woman으로 M은 Man 으로
ALTER TABLE my_contacts
	CHANGE COLUMN gender gender VARCHAR(70);
UPDATE my_contacts SET gender = 
		case gender
		when 'f' then 'Woman'
		when 'm' then 'Man'
		END;
		
-- 4. seeking 테이블 만들기.
--    만들어진 seeking 테이블에 자동증가하는 idx 컬럼추가
--    seeking 컬럼의 값들은 중복되지 않게 한 행에 하나의 값만 가질수 있게해서 넣기
--    이후 seeking 컬럼 삭제.
CREATE TABLE seeking (
	idx INT AUTO_INCREMENT PRIMARY KEY,
	seeking VARCHAR(30) UNIQUE NOT NULL
); 
INSERT INTO seeking
	SELECT NULL AS 'n',tmp.* FROM (
		SELECT tmp.* FROM (
			SELECT distinct case
				when INSTR(seeking,',')= 0 then seeking
				when INSTR(seeking,',') IS NULL then null
				ELSE SUBSTRING_INDEX(seeking,',',1)
				END AS seeking
				FROM my_contacts) AS tmp WHERE tmp.seeking IS NOT NULL
		UNION
		SELECT tmp.* FROM (
			SELECT distinct case
				when INSTR(seeking,',')= 0 then null
				when INSTR(seeking,',') IS NULL then null
				ELSE TRIM(SUBSTRING_INDEX(seeking,',',-1))
				END AS seeking
				FROM my_contacts) AS tmp WHERE tmp.seeking IS NOT NULL
		)
	AS tmp ORDER BY seeking;
SELECT * FROM seeking;
ALTER TABLE my_contacts
	DROP COLUMN seeking;
	
-- 5. profession 컬름을 occupation 컬럼으로 변경. not null.
ALTER TABLE my_contacts
	CHANGE COLUMN profession occupation VARCHAR(20) NOT NULL;
	





SELECT * FROM my_contacts;
SELECT * FROM interests;
SELECT * FROM seeking;
-- 2번 처음 풀어본 방식
INSERT INTO interests
	SELECT NULL AS 'n',tmp.* FROM (
		SELECT tmp.* FROM (
			SELECT distinct case
				when INSTR(interests,',')= 0 then interests
				when INSTR(interests,',') IS NULL then null
				ELSE SUBSTRING_INDEX(interests,',',1)
				END AS interests
				FROM my_contacts) AS tmp WHERE tmp.interests IS NOT NULL
		UNION
		SELECT tmp.* FROM (
			SELECT distinct case
				when INSTR(interests,',')= 0 then null
				when INSTR(interests,',') IS NULL then null
				ELSE TRIM(SUBSTRING_INDEX(interests,',',-1))
				END AS interests
				FROM my_contacts) AS tmp WHERE tmp.interests IS NOT NULL
		)
	AS tmp ORDER BY interests;

-- 콤마 여러개 잘라내는 방법 --------------------------------------------------------------
SELECT substring_index(interests,',',1),
replace(substring_index(interests,',',2),substring_index(interests,',',1),''), 
replace(substring_index(interests,',',3),substring_index(interests,',',2),'') 
FROM my_contacts;

SELECT distinct trim(replace(DATA,', ','')) AS interest FROM (
SELECT substring_index(interests,',',1) AS data FROM my_contacts
UNION
SELECT replace(substring_index(interests,',',2),substring_index(interests,',',1),'') FROM my_contacts
UNION
SELECT replace(substring_index(interests,',',3),substring_index(interests,',',2),'') FROM my_contacts) foo
WHERE length(DATA) <> 0 and DATA IS NOT null;
