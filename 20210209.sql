USE sqldb;

CREATE TABLE users(
	user_no INT PRIMARY KEY AUTO_INCREMENT,
	user_name VARCHAR(50)
);

INSERT INTO users VALUES(NULL, 'ddd');
SELECT * FROM users;
CREATE TABLE comments(
	comment_no INT PRIMARY KEY AUTO_INCREMENT,
	user_no INT NOT NULL,
	COMMENT_text TEXT,
	FOREIGN KEY (user_no) REFERENCES users(user_no)
	ON DELETE CASCADE
	ON UPDATE CASCADE
);
DROP TABLE comments;

DESC comments;
SHOW INDEX FROM comments;
INSERT INTO comments VALUES(NULL,1,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa');
SELECT * FROM comments;
SELECT * FROM users;
UPDATE users SET user_no=5 WHERE user_no =2;
DELETE FROM users WHERE user_no = 5;

---------------------------------------------------
USE sqldb;
CREATE TABLE if NOT EXISTS testtbl11 (
	id INT,
	txt VARCHAR(10)
);
INSERT INTO testtbl11 VALUES(1, '이엑스아이디');
INSERT INTO testtbl11 VALUES(2, '애프터스쿨');
INSERT INTO testtbl11 VALUES(3, '에이오에이');

DROP TRIGGER if EXISTS testTrg;
delimiter $$
CREATE TRIGGER testTrg
	AFTER delete
	ON testtbl11
	FOR EACH ROW
BEGIN
	SET @msg = concat(OLD.txt,' 가수 그룹이 삭제됨');
END $$
delimiter ;

DELETE from testtbl11 WHERE id=1;
SELECT @msg;

-------------------------------------------------
DROP TABLE buytbl;
CREATE TABLE backup_userTBl(
	userId CHAR(8) NOT NULL PRIMARY KEY,
	NAME VARCHAR(10) NOT NULL,
	birthYear INT NOT NULL,
	addr CHAR(2) NOT NULL,
	mobile1 CHAR(3),
	mobile2 CHAR(8),
	height SMALLINT,
	mdate DATE,
	modType CHAR(2),
	modDate DATE,
	modUser VARCHAR(256)
);

DROP TRIGGER if EXISTS backUserTbl_UpdateTrg
delimiter $$
CREATE TRIGGER backUserTbl_UpdateTrg
	AFTER update
	ON usertbl
	FOR EACH row
BEGIN
	INSERT INTO backup_usertbl VALUES( OLD.userid ,OLD.name, OLD.birthYear, OLD.addr, OLD.mobile1, OLD.mobile2, OLD.height, OLD.mdate, '수정',CURDATE(), CURRENT_USER());
END $$
delimiter ;


DROP TRIGGER if EXISTS backUserTbl_DeleteTrg
delimiter $$
CREATE TRIGGER backUserTbl_DeleteTrg
	AFTER delete
	ON usertbl
	FOR EACH row
BEGIN
	INSERT INTO backup_usertbl VALUES( OLD.userid ,OLD.name, OLD.birthYear, OLD.addr, OLD.mobile1, OLD.mobile2, OLD.height, OLD.mdate, '삭제',CURDATE(), CURRENT_USER());
END $$
delimiter ;

UPDATE usertbl SET addr='몽고' WHERE userid='jkw';

DELETE FROM usertbl WHERE height >=177;

SELECT * FROM backup_usertbl;

DROP TRIGGER if EXISTS usertbl_InsertTrg;
delimiter $$
CREATE TRIGGER usertbl_InsertTrg
	AFTER INSERT
	ON usertbl
	FOR EACH row
BEGIN
	SIGNAL SQLSTATE '45000'
	 SET MESSAGE_TEXT = '데이터 입력을 시도했습니다. 귀하의 정보가 서버에 기록되었습니다.';
END $$
delimiter ;

INSERT INTO usertbl VALUES('ABC' ,'에비씨',1977,'서울' , '011','11111111',181,'2019-12-25');

------------------------------------------------------
DROP TRIGGER if EXISTS usertbl_BeforeInsertTrg;
delimiter $$
CREATE TRIGGER usertbl_BeforeInsertTrg
	BEFORE insert
	ON usertbl
	FOR EACH ROW
BEGIN
	if NEW.birthYear < 1900 then
		SET NEW.birthYear := 0;
	ELSEIF NEW.birthYear > YEAR(CURDATE()) then
		SET NEW.birthYear := YEAR(CURDATE());
	END if;
END $$
delimiter ;

INSERT INTO usertbl VALUES( 'AAA', '에이',1877 ,'서울','011', '1112222' , 181 ,'2019-12-25');
INSERT INTO usertbl VALUES( 'BBB', '비이',2977 ,'경기','011', '1113333' , 171 ,'2011-3-25');
SELECT * FROM usertbl;
DROP TRIGGER usertbl_InsertTrg;

---------------------------------------------------------
CREATE TABLE noticetbl(
	idx INT PRIMARY KEY AUTO_INCREMENT,
	txt TEXT
);

----------------------------------------------------------
CREATE DATABASE if NOT EXISTS triggerdb default CHARACTER SET UTF8 COLLATE UTF8_GENERAL_CI ;
USE triggerdb;

CREATE TABLE ordertbl(
	orderNo INT AUTO_INCREMENT PRIMARY KEY,
	userId VARCHAR(5),
	prodName VARCHAR(5),
	orderamount INT
);
CREATE TABLE prodTbl(
	prodName VARCHAR(5),
	ACCOUNT INT
);
CREATE TABLE delivertbl(
	deliverNo INT AUTO_INCREMENT PRIMARY KEY,
	prodName VARCHAR(5),
	ACCOUNT INT UNIQUE
);

INSERT INTO prodtbl VALUES('사과',100),('배',100),('귤',100);

DROP TRIGGER if EXISTS orderTrg;
delimiter $$
CREATE TRIGGER orderTrg
	AFTER insert
	ON ordertbl
	FOR EACH row
BEGIN
	UPDATE prodtbl SET ACCOUNT = ACCOUNT- NEW.orderamount WHERE prodName= NEW.prodname;
END$$
delimiter ;

DROP TRIGGER if EXISTS prodTrg;
delimiter $$
CREATE TRIGGER prodTrg
	AFTER update
	ON prodtbl
	FOR EACH row
BEGIN
	DECLARE orderAmount INT;
	SET orderAmount := OLD.account - NEW.account;
	INSERT INTO delivertbl(prodname, ACCOUNT) VALUES(NEW.prodname, orderamount);
END $$
delimiter ;

INSERT INTO ordertbl VALUES(NULL,'john','배', 5);
SELECT * FROM ordertbl;
SELECT * FROM prodtbl;
SELECT * FROM delivertbl;
ALTER TABLE delivertbl CHANGE prodname productName VARCHAR(5);
INSERT INTO ordertbl VALUES(NULL,'dang','사과', 9);
-------------------------------------------------------
-- 회원 테이블 / 게시판 테이블 / 탈퇴한맴버
-- 게시판에 글은 회원만 가능 - 기본키/외래키
-- 
-- 회원이 삭제되면
-- 게시글의 회원이 쓴글은 탈퇴한 회원입다로 바뀜
-- 탈퇴한 맴버에 회원 아이디 추가

CREATE TABLE membertbl(
	id VARCHAR(10) PRIMARY key,
	pw VARCHAR(10) NOT null
);
CREATE TABLE withdraw_membertbl(
	id VARCHAR(10) PRIMARY KEY,
	pw VARCHAR(10) NOT null,
	wDate DATE NOT NULL
);
CREATE TABLE noticetbl(
	idx INT PRIMARY KEY AUTO_INCREMENT,
	id VARCHAR(10),
	title VARCHAR(30) NOT NULL,
	content TEXT NOT NULL,
	FOREIGN KEY (id) REFERENCES membertbl(id)
	ON DELETE SET null
	ON UPDATE CASCADE
);

INSERT INTO membertbl VALUES('id1','pw1'),('id2','pw2'),('id3','pw3');
INSERT INTO membertbl VALUES('id4','pw4');
INSERT INTO noticetbl VALUES(NULL,'id1','title1','content11111111111111111111111'),(NULL,'id2','title2','content22222222222222222222222');
INSERT INTO noticetbl VALUES(NULL,'id4','title4','content44444444444444444444444444');
DROP TRIGGER if EXISTS withdraw_backupTrg;
delimiter $$
CREATE TRIGGER withdraw_backupTrg
	AFTER delete
	ON membertbl
	FOR EACH row
BEGIN
	INSERT INTO withdraw_membertbl VALUES(OLD.id, OLD.pw, CURDATE());
	UPDATE noticetbl SET content = '탈퇴한 회원이 쓴 글입니다' WHERE id IS NULL;
END $$
delimiter ;

-- DROP TRIGGER if EXISTS withdraw_revise_noticeTrg;
-- delimiter $$
-- CREATE TRIGGER withdraw_revise_noticeTrg
-- 	AFTER insert
-- 	ON withdraw_membertbl
-- 	FOR EACH row
-- BEGIN
-- 	UPDATE noticetbl SET content = '탈퇴한 회원이 쓴 글입니다' WHERE id IS NULL;	
-- END $$
-- delimiter ;

DELETE FROM membertbl WHERE id='id4';
SELECT * FROM noticetbl;
SELECT * FROM membertbl;
SELECT * FROM withdraw_membertbl;
-----------------------------------------------------
-- 회원 테이블 / olleh 테이블 / 삼성카드 테이블 - 주민등록번호 잡으면 편함
-- 
-- 회원테이블의 주소가 바뀌면
-- olleh / 삼성카드의 주소가 같이 바뀜.

CREATE TABLE membertbl2 (
	residentNum INT PRIMARY KEY,
	NAME VARCHAR(5) NOT NULL,
	addr VARCHAR(30) NOT NULL
);





-- 정규화 연습 ---------------------------------------------------
USE orally;

ALTER TABLE my_contacts ADD COLUMN idx int PRIMARY KEY AUTO_INCREMENT FIRST;
-- gender 열 -----------------------------------------------------
CREATE TABLE gendertbl(
	idx INT(1) NOT NULL PRIMARY KEY,
	gender VARCHAR(5) NOT NULL UNIQUE
);
INSERT INTO gendertbl VALUES(1,'Man'),(2,'Woman');
SELECT * FROM gendertbl;

UPDATE my_contacts m INNER JOIN gendertbl g ON m.gender = g.gender SET m.gender = g.idx;
ALTER TABLE my_contacts CHANGE gender gender INT(1);
ALTER TABLE my_contacts ADD FOREIGN KEY(gender) REFERENCES gendertbl(idx) ON UPDATE cascade;

SELECT m.idx, m.last_name , m.first_name, m.email, g.gender, m.birthday,m.occupation,m.`status`,m.states,m.city from my_contacts m INNER JOIN gendertbl g ON m.gender = g.idx;
-- states, city 열을 별도 테이블로 분리 --------------------------------------------------------------
CREATE TABLE locationTbl (
	idx INT PRIMARY KEY AUTO_INCREMENT,
	states CHAR(2) NOT null,
	city VARCHAR(20) NOT NULL
);	
insert into locationtbl SELECT DISTINCT NULL AS n, states,city FROM my_contacts WHERE city !='San Fran' ORDER BY states, city;
SELECT * FROM locationtbl;
ALTER TABLE my_contacts ADD COLUMN location INT;
ALTER TABLE my_contacts ADD FOREIGN KEY (location) REFERENCES locationtbl(idx) ON UPDATE cascade;
UPDATE my_contacts m INNER JOIN locationtbl l ON (m.city = l.city AND m.states = l.states) OR (m.states = l.states AND m.city = 'san fran' AND m.city = SUBSTRING(l.city FROM 1 FOR 8)) SET m.location =l.idx;

SELECT m.idx, m.last_name , m.first_name, m.email, g.gender, m.birthday,m.occupation,m.`status`,l.states,l.city from my_contacts m 
	INNER JOIN gendertbl g ON m.gender = g.idx 
	INNER JOIN locationtbl l ON m.location = l.idx;


ALTER TABLE my_contacts drop COLUMN states;
ALTER TABLE my_contacts drop COLUMN city;
-- status 열 -------------------------------------------------------
CREATE TABLE statustbl(
	idx INT PRIMARY KEY AUTO_INCREMENT,
	STATUS VARCHAR(25) NOT NULL UNIQUE
);
insert into statustbl SELECT DISTINCT null AS n,case when STATUS IS NULL then 'no comment' when STATUS = 'committed relationsh' then 'committed relationship' ELSE STATUS END AS status  FROM my_contacts ORDER BY STATUS;
SELECT m.STATUS ,s.idx FROM my_contacts m INNER JOIN STATUStbl s ON m.`status` = s.status;
UPDATE my_contacts m INNER JOIN STATUStbl s ON m.`status` = s.status SET m.status = s.idx;
UPDATE my_contacts m INNER JOIN STATUStbl s ON m.`status` = 'committed relationsh' AND s.status = 'committed relationship' SET m.status = s.idx;
UPDATE my_contacts m INNER JOIN STATUStbl s ON m.`status` IS NULL AND s.status = 'no comment' SET m.status = s.idx;
ALTER TABLE my_contacts CHANGE STATUS STATUS INT;
ALTER TABLE my_contacts ADD FOREIGN KEY (STATUS) REFERENCES statustbl(idx) ON UPDATE cascade;

SELECT m.idx, m.last_name , m.first_name, m.email, g.gender, m.birthday,m.occupation,s.`status`,l.states,l.city from my_contacts m 
	INNER JOIN gendertbl g ON m.gender = g.idx 
	INNER JOIN locationtbl l ON m.location = l.idx
	INNER JOIN statustbl s ON m.`STATUS` = s.idx;
-- occupation 열 ----------------------------------------------------------



CREATE TABLE occupationtbl(
	idx INT PRIMARY KEY AUTO_INCREMENT,
	occupation VARCHAR(20) NOT NULL
);
insert into occupationtbl SELECT DISTINCT NULL AS n, occupation FROM my_contacts ORDER BY occupation;
SELECT * FROM occupationtbl;
SELECT * FROM my_contacts;

UPDATE my_contacts m INNER JOIN occupationtbl o ON m.occupation = o.occupation SET m.occupation = o.idx;

ALTER TABLE my_contacts CHANGE occupation occupation INT;
ALTER TABLE my_contacts ADD FOREIGN KEY(occupation) REFERENCES occupationtbl(idx) ON UPDATE cascade;

DESC my_contacts;
SELECT * FROM my_contacts;
SELECT m.idx, m.last_name , m.first_name, m.email, g.gender, m.birthday,o.occupation,s.`status`,l.states,l.city from my_contacts m 
	INNER JOIN gendertbl g ON m.gender = g.idx 
	INNER JOIN locationtbl l ON m.location = l.idx
	INNER JOIN statustbl s ON m.`STATUS` = s.idx
	INNER JOIN occupationtbl o ON m.occupation = o.idx;