USE sqldb;

CREATE TABLE testtbl1 (
id INT,
userName CHAR(3),
age INT);
DROP TABLE testtbl1;

INSERT INTO testtbl1 VALUES(1,'홍길동', 25);

INSERT INTO testtbl1(id, userName) VALUES(2,'설현');
INSERT INTO testtbl1(userName, age, id) VALUES('초아', 26, 3);
SELECT * FROM testtbl1;
------------------------------------------
CREATE TABLE testtbl2(
id int AUTO_INCREMENT PRIMARY KEY,
userName CHAR(3),
age INT);
INSERT INTO testtbl2 VALUES(NULL, '지민', 25);
INSERT INTO testtbl2 VALUES(NULL, '유나', 22);
INSERT INTO testtbl2 VALUES(NULL, '유경', 21);
SELECT * from testtbl2;

SELECT LAST_INSERT_ID();
ALTER TABLE testtbl2 AUTO_INCREMENT = 100;
INSERT INTO testtbl2 VALUES(NULL,'찬미', 23);
SELECT * FROM testtbl2;

-------------------------------------------
CREATE TABLE testtbl0 (
id INT NOT NULL,
userName CHAR(3),
age INT);
INSERT INTO testtbl0(age, userName) VALUES(24,'설현');	--id값이 null이면 안됨
DELETE FROM testtbl1 WHERE id IS NULL;
SELECT * FROM testtbl1;

-------------------------------------------

CREATE TABLE testtbl3(
id INT AUTO_INCREMENT PRIMARY KEY,
useName CHAR(3),
age INT);
ALTER TABLE testtbl3 AUTO_INCREMENT = 100;
SET @@AUTO_INCREMENT_INCREMENT = 3;
INSERT INTO testtbl3 VALUES (NULL,'나연',20);
INSERT INTO testtbl3 VALUES (NULL,'정연',18);
INSERT INTO testtbl3 VALUES (NULL,'모모',19);
SELECT * FROM testtbl3;
DELETE FROM testtbl3;
INSERT INTO testtbl3 VALUES (NULL,'나연',20),(NULL,'정연',18),(NULL,'모모',19);

--------------------------------------------

CREATE TABLE testtbl2_2(
idx INT AUTO_INCREMENT PRIMARY KEY,
id VARCHAR(8),
NAME VARCHAR(20),
age INT);

INSERT INTO testtbl2_2 VALUES(NULL,'idid','pwpw',30);
SELECT * FROM testtbl2_2;
ALTER TABLE testtbl2_2 AUTO_INCREMENT=1;
DELETE FROM testtbl2_2;
SET @@AUTO_INCREMENT_increment = 1;
SELECT LAST_INSERT_ID();
DROP TABLE testtbl2_2;

--------------------------------------------
USE orally;
CREATE TABLE testtbl1(

 fname VARCHAR(20),
 lname VARCHAR(20));
CREATE TABLE testtbl2(

fname VARCHAR(20),
lname VARCHAR(20));
CREATE TABLE testtbl3(

fname VARCHAR(20),
lname VARCHAR(20));
 
DROP TABLE testtbl1;
 
insert into testtbl1 SELECT first_name,LAST_name FROM my_contacts;
insert into testtbl2 SELECT first_name,LAST_name FROM my_contacts;
insert into testtbl3 SELECT first_name,LAST_name FROM my_contacts;
SELECT * FROM testtbl1;
SELECT * FROM testtbl2;
SELECT * FROM testtbl3;

UPDATE testtbl1 SET fname ='reo' WHERE fname='leo';

DELETE from testtbl1 WHERE fname = 'joe';

DELETE FROM testtbl1;
DROP TABLE testtbl2;
TRUNCATE TABLE testtbl3;

USE sqldb;
SET @myVar1 := 5;
SET @myVar2 := 3;
SET @myVar3 := 4.25;
SET @myvar4 := '가수 이름==> ';

SELECT @myvar1;
SELECT @myVar2 + @myVar3;
SELECT @myVar4 , NAME FROM userTBL WHERE height >180;

SET @cnt :=0;
SELECT @cnt:= @cnt+1 AS NO, usertbl.* FROM usertbl;


SELECT if(100>200, '참이다','거짓이다') orallymy_contactsAS '결과';
SELECT IFNULL(NULL,'널이군요'), IFNULL(100,'널이군');

SELECT NULLIF(100,100) , NULLIF(200,100);

SELECT case 10
		 when 1 then 'one'
		 when 5 then 'five'
		 when 10 then 'ten'
		 ELSE 'idontknow'
END;

-------------------------------------------

USE orally;
SELECT * FROM cookie_sales;

SELECT 
		case
		when first_name='Lindsey' then '린지'
		ELSE null
		END
		FROM cookie_sales;
		
------------------------------
cookie_sales
책 236페이지에 문자열 합치기 함수 있음.

1. 이름을 전 부 한글로 바꾸기
2. sales 컬럼을 "판매"로 바꾸고 모든 금액 앞에 $ 붙이기
3. 날짜를 년을 빼고 월은 영문으로
4. 판매금액이 10 미만 일경우 이름 뒤에
[미달] 붙이기
5. 판매일자가 3월 10일 인것중 제일 많이 판매한 행만 출력
SELECT * FROM cookie_sales;
SELECT substring(sale_date,6,2) FROM cookie_sales;

SELECT 
	case
	when first_name='ashley' then '애슐리'
	when first_name='lindsey' then '린지'
	when first_name='nicole' then '니콜'
	when first_name='britney' then '브리트니'
	ELSE null
	END
FROM cookie_sales;
	
SELECT CONCAT('$',sales) AS '판매' FROM cookie_sales;

SELECT 
	case
	when substring(sale_date,6,2) = '03' then  CONCAT('March', SUBSTRING(sale_date,8,3))
	ELSE null
	END
FROM cookie_sales;
SELECT DATE_FORMAT(sale_date, "%M-%d") FROM cookie_sales;

SELECT if(sales<10, CONCAT(first_name ,' [미달]'),first_name) ,sales FROM cookie_sales;
SELECT case
			when sales<10 then CONCAT(first_name ,' [미달]')
			ELSE first_name
			END 
			FROM cookie_sales;
			
SELECT MAX(sales) FROM cookie_sales WHERE sale_date LIKE '%-03-10';

SELECT * FROM testtbl1;
INSERT INTO testtbl1 VALUES('이름','name',111);
SELECT concat(id,'안') FROM testtbl1;
ALTER TABLE testtbl1 ADD COLUMN id INT;
alter table testtbl1 default character set utf8 collate UTF8_GENERAL_CI; -- 안됨
alter table testtbl1 convert to character set UTF8;							-- 됨

USE employees;
SHOW TABLES;
DESC employees;

SET @myVal := 3;
PREPARE mysql1 from 'select * from cookie_sales limit ?';
EXECUTE mysql1 USING @myVal;

-- -----------------------------------------------

USE sqldb;
CREATE TABLE pivotTest (
uName CHAR(3),
season CHAR(2),
amount INT);


SELECT * FROM buytbl INNER JOIN usertbl ON buytbl.userID = usertbl.userID WHERE buytbl.userID = 'jyp';

SELECT distinct buytbl.prodName from buytbl INNER JOIN usertbl ON buytbl.userid = usertbl.userid where usertbl.name = '은지원';

-- ---------------------------------------------------
USE sqldb;
CREATE TABLE stdtbl(
stdName VARCHAR(10) NOT NULL PRIMARY KEY,
addr CHAR(4) NOT NULL
);

CREATE TABLE clubtbl(
clubName VARCHAR(10) NOT NULL PRIMARY KEY,
roomNo CHAR(4) NOT NULL
);
CREATE TABLE stdclubtbl(
num INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
stdName VARCHAR(10) NOT NULL,
clubName VARCHAR(10) NOT NULL,
FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);

INSERT INTO stdtbl VALUES(n'김범수',n'경남'),(n'성시경',n'서울'),(n'조용필',n'경기'),(n'은지원',n'경북'),(n'바비킴',n'서울');
INSERT INTO clubtbl VALUES(n'수영',n'101호'),(n'바둑',n'102호'),(n'축구',n'103호'),(n'봉사',n'104호');
INSERT INTO stdclubtbl VALUES(null,n'김범수',n'바둑'),(null,n'김범수',n'축구'),(null,n'조용필',n'축구'),(null,n'은지원',n'축구'),(null,n'은지원',n'봉사'),(null,n'바비킴',n'봉사');

SELECT s.stdname, s.addr, c.clubname, c.roomno FROM stdtbl s INNER JOIN stdclubtbl sc ON s.stdname = sc.stdname INNER JOIN clubtbl c ON sc.clubname = c.clubname ORDER BY s.stdname;
SELECT s.addr AS '축구동아리에 가입한 사람의 지역' FROM stdtbl s INNER JOIN stdclubtbl sc ON s.stdname = sc.stdname WHERE sc.clubname = '축구' ORDER BY s.stdname;

SELECT c.clubname, c.roomno, s.stdname, s.addr FROM clubtbl c INNER JOIN stdclubtbl sc ON sc.clubname = c.clubname INNER JOIN stdtbl s on sc.stdname = s.stdname ORDER BY c.clubname;
SELECT s.addr , sc.clubname FROM stdtbl s INNER JOIN stdclubtbl sc ON s.stdname = sc.stdname WHERE sc.clubname = '축구';
SELECT sc.stdName, c.clubName, c.roomNo FROM clubtbl c INNER JOIN stdclubtbl sc ON sc.clubname = c.clubname WHERE c.roomno = '102호';
SELECT s.stdname, s.addr, roomno FROM stdtbl s INNER JOIN stdclubtbl sc ON s.stdname = sc.stdname INNER JOIN clubtbl c ON c.clubname = sc.clubname WHERE c.roomno='104호';


-- --------------------------------------------------
USE orally;
DROP TABLE orderitems;
CREATE TABLE OrderItems
(
  idx        int   auto_increment primary key,
  order_num  int          NOT NULL ,
  order_item int          NOT NULL ,
  prod_id    char(10)     NOT NULL ,
  quantity   int          NOT NULL ,
  item_price decimal(8,2) NOT NULL,
  item_total decimal(8,2),
  order_date date,
  isrefund   varchar(10)
);

INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20005, 1, 'BR01', 100, 5.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20005, 2, 'BR03', 100, 10.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 1, 'BR01', 20, 5.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 2, 'BR02', 10, 8.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 3, 'BR03', 10, 11.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 1, 'BR03', 50, 11.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 2, 'BNBG01', 100, 2.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 3, 'BNBG02', 100, 2.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 4, 'BNBG03', 100, 2.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 5, 'RGAN01', 50, 4.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 1, 'RGAN01', 5, 4.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 2, 'BR03', 5, 11.99);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 3, 'BNBG01', 10, 3.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 4, 'BNBG02', 10, 3.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 5, 'BNBG03', 10, 3.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 1, 'BNBG01', 250, 2.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 2, 'BNBG02', 250, 2.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 3, 'BNBG03', 250, 2.49);



-- 1. item_total 에 가격과 양을 계산한 값
UPDATE orderitems SET item_total = quantity*item_price;
-- 2. order_num을 참조 2016-01-01 부터 추가(20005라면2016-01-01,20006이라면 2016-02-01)
UPDATE orderitems SET order_date =ADDDATE('2016-01-01',INTERVAL SUBSTRING(order_num,5,1)-5 MONTH);
-- 3. br01,02,03 은 isrefund=> t 아니면 f
update orderitems set isrefund = (
        case prod_id
                when 'BR01' then 't'
                when 'BR02' then 't'
                when 'BR03' then 't'
        else 'f'
END);
-- 4. 전체 금액이 50.00 이하 또는 order_item이 4이상인것 삭제
DELETE FROM orderitems where item_total<=50 OR order_item>=4;
-- 5. isrefund t를 '환불' f를 '결제'로
UPDATE orderitems SET isrefund =  case
			when isrefund='t' then '환불'
			when isrefund='f' then '결제'
		END;
-- 6. date를 년월일 -> 일월년 으로 출력
SELECT DATE(DATE_FORMAT(order_date,'%d-%m-%Y')) from orderitems;
-- 7. prod_id 의 값 모두 앞에 'id_'를붙이고, quantity에 모두 10 추가
UPDATE orderitems SET prod_id = CONCAT('id_',prod_id), quantity = quantity+10; 
-- 8. total에 세금 10%추가 100 이상이면 15%
UPDATE orderitems SET item_total = if(item_total>=100,item_total*1.15,item_total*1.1); 


SELECT if(item_total>=100,item_total*1.15,item_total*1.1) from orderitems;
