USE shopdb;

CREATE TABLE kyjTBL(
id INT);

CREATE DATABASE kyjdb;

CREATE USER ceo@'localhost' IDENTIFIED BY '1234';
CREATE USER ceo@'%' IDENTIFIED BY '1234';
USE mySQL;
INSERT INTO user(HOST, user, PASSWORD) VALUES('%','tt','ttpw');

DROP user ceo@'localhost';
DROP user ceo@'%';

GRANT all PRIVILEGES ON shoddb TO tmp@'%';
shopdb


CREATE DATABASE tmpex1;

CREATE USER ex1@'%' IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON tmpex1.* TO ex1@'%';


USE tmpex1;

CREATE TABLE test(
id VARCHAR(10),
pw VARCHAR(10)
);

INSERT INTO test VALUES('ididid','pwpwpw');
SELECT * FROM test;

show GRANTS;

USE orally;

SELECT * FROM my_contacts LIMIT 15,5;
SELECT last_name, last_name, first_name FROM my_contacts;
SELECT * FROM my_contacts WHERE first_name='leo';
SELECT * FROM my_contacts WHERE first_name='anne' AND profession='artist';
SELECT * FROM my_contacts WHERE first_name='anne' AND profession='artist' OR first_name='joe';

CREATE DATABASE hanbit;
USE hanbit;

-------------------------------------------------
DROP DATABASE IF EXISTS sqldb; -- 만약 sqldb가 존재하면 우선 삭제한다.
CREATE DATABASE sqldb;

USE sqldb;
CREATE TABLE usertbl -- 회원 테이블
( userID     CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  name       VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr        CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1   CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2   CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height       SMALLINT,  -- 키
  mDate       DATE  -- 회원 가입일
);
CREATE TABLE buytbl -- 회원 구매 테이블(Buy Table의 약자)
(  num       INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID     CHAR(8) NOT NULL, -- 아이디(FK)
   prodName    CHAR(6) NOT NULL, --  물품명
   groupName    CHAR(4)  , -- 분류
   price        INT  NOT NULL, -- 단가
   amount       SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);

SELECT * FROM usertbl;
SELECT * FROM buytbl;

USE sqldb;

SELECT * FROM userTbl WHERE NAME ='김경호';
SELECT * FROM USERtbl WHERE birthYear>=1970 and height>=182;
SELECT * FROM USERtbl WHERE height>=170 and height<=182;
SELECT * FROM usertbl WHERE height BETWEEN 170 AND 182;
SELECT * FROM usertbl WHERE addr IN('서울','경기');
SELECT * FROM usertbl WHERE userID LIKE 'j%';
SELECT * FROM usertbl WHERE height LIKE '%8%';
SELECT * FROM usertbl;
SELECT * FROM buytbl;

--서브쿼리
SELECT NAME FROM usertbl WHERE userid in (SELECT userID FROM buytbl WHERE prodName='모니터');
SELECT height FROM usertbl WHERE addr='경남';
SELECT NAME, height FROM USERtbl WHERE height >= all (SELECT height FROM usertbl WHERE addr='경남');
SELECT NAME, height FROM USERtbl WHERE height >= any (SELECT height FROM usertbl WHERE addr='경남');
SELECT NAME, height FROM USERtbl WHERE height >= some (SELECT height FROM usertbl WHERE addr='경남');

SELECT * FROM usertbl ORDER BY mdate DESC;
SELECT * FROM usertbl ORDER BY mdate ASC;
SELECT * FROM usertbl ORDER BY birthyear ASC;
SELECT * FROM usertbl ORDER BY birthyear ASC, NAME DESC;

SELECT DISTINCT addr FROM usertbl;

--------------------------------------
USE orally;
SELECT * FROM my_contacts;
SELECT * FROM my_contacts WHERE gender='F' AND first_name='anne' AND location LIKE 'San Fran%';
SELECT * FROM my_contacts WHERE birthday>='1960-1-1' AND birthday<'1970-1-1';
SELECT * FROM my_contacts ORDER BY birthday LIMIT 10;
SELECT * FROM my_contacts WHERE status='married' AND location LIKE '%ca%';
SELECT * FROM my_contacts WHERE seeking='new job' AND gender='f';
SELECT * FROM my_contacts WHERE STATUS='divorced' AND gender='m';
SELECT * FROM my_contacts WHERE gender='m' ORDER BY birthday desc;
SELECT * FROM my_contacts WHERE gender='f' ORDER BY first_name;
SELECT * FROM my_contacts WHERE interests NOT like '%rpg%' AND gender!='f';
SELECT * FROM my_contacts WHERE location LIKE '%ny%' ORDER BY birthday;
SELECT * FROM my_contacts WHERE email NOT LIKE '%.com';
SELECT * FROM my_contacts WHERE STATUS='married' AND location LIKE '%ca%' AND seeking LIKE '%friends%';
SELECT * FROM my_contacts WHERE birthday LIKE '_____04___' ORDER BY birthday DESC, gender ASC;
SELECT * FROM my_contacts WHERE interests LIKE '%ing' AND STATUS = 'married';
SELECT * FROM my_contacts WHERE last_name LIKE '%m%' AND gender='f' AND location LIKE '%ca%';

USE sqldb;
CREATE TABLE buytbl2 (SELECT * FROM buytbl);
CREATE TABLE my_con (SELECT last_name,first_name FROM my_contacts);
SELECT * FROM my_con;

SELECT * FROM buytbl;
SELECT userID, amount FROM buytbl;
SELECT userID, sum(amount) total FROM buytbl GROUP BY userid HAVING userid='bbk';
SELECT userid, SUM(price*amount) AS total FROM buytbl GROUP BY userid;
SELECT userid, AVG(amount) average FROM buytbl GROUP BY userid;
SELECT userid, min(amount) min_value FROM buytbl GROUP BY userid;
SELECT userid, max(amount) max_value FROM buytbl GROUP BY userid;
SELECT userid, count(amount), count(distinct amount) cnt_dis FROM buytbl GROUP BY userid;


USE ORALLY;
SELECT * FROM my_contacts;
SELECT COUNT(status) FROM my_contacts; --null값 때문에 차이가 있다
SELECT COUNT(*) FROM my_contacts;

USE sqldb;
SELECT userid 아이디 ,SUM(price) 총계  FROM buytbl GROUP BY userid;

SELECT userid 아이디 ,SUM(price) 총계  FROM buytbl GROUP BY userid;
SELECT t.* FROM (SELECT userid 아이디 ,SUM(price) 총계  FROM buytbl GROUP BY userid) t WHERE t.총계>=300;
SELECT userid 아이디 ,SUM(price) 총계  FROM buytbl GROUP BY userid HAVING SUM(price)>300;

SELECT num, groupname, SUM(price*amount) AS '비용' FROM buytbl GROUP BY groupname, num WITH ROLLUP;


-----------------------------------------------------


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
VALUES(20009, 1, 'BNBG01', 250, 2.49);orally
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 2, 'BNBG02', 250, 2.49);
INSERT INTO OrderItems(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 3, 'BNBG03', 250, 2.49);

DELETE FROM orderitems;

select * from orderitems;

-----------------------------------------------------------------------

SELECT MAX(quantity) 최대, MIN(quantity) 최소, AVG(quantity) 평균, SUM(quantity) 합계 FROM orderitems;
SELECT DISTINCT order_num FROM orderitems;
SELECT order_num, count(quantity), sum(quantity) FROM orderitems GROUP BY order_num;
SELECT order_num,prod_id,SUM(idx) FROM orderitems GROUP BY order_num,prod_id;
SELECT ORDER_num, sum(quantity) FROM orderitems GROUP BY order_num;
SELECT prod_id, sum(item_price) FROM orderitems GROUP BY prod_id;
SELECT DISTINCT order_num, item_price FROM orderitems;
SELECT prod_id, avg(quantity) FROM orderitems GROUP BY prod_id;
SELECT prod_id, SUM(quantity*item_price) FROM orderitems GROUP BY prod_id ORDER by SUM(quantity*item_price);


---------------------------------------------------------------------------

CREATE TABLE cookie_sales (
  ID int(11) NOT NULL auto_increment,
  first_name varchar(20) NOT NULL,
  sales decimal(4,2) NOT NULL,
  sale_date date NOT NULL,
  PRIMARY KEY  (ID)
);

INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('1','Lindsey',32.02,'2007-03-12');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('2','Nicole',26.53,'2007-03-12');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('3','Britney',11.25,'2007-03-12');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('4','Ashley',18.96,'2007-03-12');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('5','Lindsey',9.16,'2007-03-11');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('6','Nicole',1.52,'2007-03-11');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('7','Britney',43.21,'2007-03-11');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('8','Ashley',8.05,'2007-03-11');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('9','Lindsey',17.62,'2007-03-10');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('10','Nicole',24.19,'2007-03-10');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('11','Britney',3.40,'2007-03-10');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('12','Ashley',15.21,'2007-03-10');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('13','Lindsey',0.00,'2007-03-09');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('14','Nicole',31.99,'2007-03-09');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('15','Britney',2.58,'2007-03-09');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('16','Ashley',0.00,'2007-03-09');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('17','Lindsey',2.34,'2007-03-08');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('18','Nicole',13.44,'2007-03-08');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('19','Britney',8.78,'2007-03-08');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('20','Ashley',26.82,'2007-03-08');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('21','Lindsey',3.71,'2007-03-07');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('22','Nicole',0.56,'2007-03-07');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('23','Britney',34.19,'2007-03-07');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('24','Ashley',7.77,'2007-03-07');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('25','Lindsey',16.23,'2007-03-06');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('26','Nicole',0.00,'2007-03-06');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('27','Britney',4.50,'2007-03-06');
INSERT INTO `cookie_sales` (`ID`,`first_name`,`sales`,`sale_date`) VALUES ('28','Ashley',19.22,'2007-03-06');

SELECT * FROM cookie_sales;


SELECT sales FROM cookie_sales ORDER BY sales DESC LIMIT 10,10 ;
SELECT sales, sales*0.1 FROM cookie_sales;
SELECT sale_date, round(sales) FROM cookie_sales ORDER BY sale_date;
SELECT * FROM cookie_sales WHERE sales>=10 ORDER BY first_name;
SELECT SUBSTRING_INDEX(sale_date, '-', -2) FROM cookie_sales;
SELECT SUBSTRING(first_name,1,3) FROM cookie_sales;
SELECT LOWER(first_name) FROM cookie_sales;
SELECT SUM(sales) FROM cookie_sales;
SELECT sales FROM cookie_sales ORDER BY sales DESC LIMIT 1;


















SET @qry = CONCAT('SELECT ', (SELECT REPLACE(GROUP_CONCAT(COLUMN_NAME), 'sales,', '') FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME = 'cookie_sales' AND TABLE_SCHEMA = 'orally'), ' FROM cookie_sales');
-- Prepared statement 생성 (예제는 result 라는 이름으로 생성)
PREPARE result FROM @qry;
-- Prepared statement 실행
EXECUTE result;
-- 생성한 Prepared stetement 해제 (클라이언트 세션이 종료되어도 자동으로 해제 됩니다.)
DROP PREPARE result;
