
CREATE TABLE Products
(
  prod_id    char(10)      NOT NULL ,
  vend_id    char(10)      NOT NULL ,
  prod_name  char(255)     NOT NULL ,
  prod_price decimal(8,2)  NOT NULL ,
  prod_desc  text          NULL
);

CREATE TABLE OrderItems2
(
  order_num  int          NOT NULL ,
  order_item int          NOT NULL ,
  prod_id    char(10)     NOT NULL ,
  quantity   int          NOT NULL ,
  item_price decimal(8,2) NOT NULL
);

INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BR01', 'BRS01', '8 inch teddy bear', 6.99, '8 inch teddy bear, comes with cap and jacket');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BR02', 'BRS02', '12 inch teddy bear', 8.99, '12 inch teddy bear, comes with cap and jacket');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BR03', 'BRS03', '18 inch teddy bear', 11.99, '18 inch teddy bear, comes with cap and jacket');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BNBG01', 'DLL01', 'Fish bean bag toy', 3.49, 'Fish bean bag toy, complete with bean bag worms with which to feed it');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BNBG02', 'DLL02', 'Bird bean bag toy', 3.49, 'Bird bean bag toy, eggs are not included');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('BNBG03', 'DLL03', 'Rabbit bean bag toy', 3.49, 'Rabbit bean bag toy, comes with bean bag carrots');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('RGAN01', 'DLL04', 'Raggedy Ann', 4.99, '18 inch Raggedy Ann doll');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('RYL01', 'FNG01', 'King doll', 9.49, '12 inch king doll with royal garments and crown');
INSERT INTO Products(prod_id, vend_id, prod_name, prod_price, prod_desc)
VALUES('RYL02', 'FNG01', 'Queen doll', 9.49, '12 inch queen doll with royal garments and crown');


INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20005, 1, 'BR01', 100, 5.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20005, 2, 'BR03', 100, 10.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 1, 'BR01', 20, 5.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 2, 'BR02', 10, 8.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20006, 3, 'BR03', 10, 11.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 1, 'BR03', 50, 11.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 2, 'BNBG01', 100, 2.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 3, 'BNBG02', 100, 2.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 4, 'BNBG03', 100, 2.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20007, 5, 'RGAN01', 50, 4.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 1, 'RGAN01', 5, 4.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 2, 'BR03', 5, 11.99);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 3, 'BNBG01', 10, 3.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 4, 'BNBG02', 10, 3.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20008, 5, 'BNBG03', 10, 3.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 1, 'BNBG01', 250, 2.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 2, 'BNBG02', 250, 2.49);
INSERT INTO OrderItems2(order_num, order_item, prod_id, quantity, item_price)
VALUES(20009, 3, 'BNBG03', 250, 2.49);

select * from products;

select * from orderItems2;

-- ---------------------------------------------------------

-- 1. vend_id dll01 인 사람이 주문한 quantity
select quantity from orderitems2 where prod_id=(select prod_id from products where vend_id='Dll01')
-- 2. br01을 구매한 vend_id
SELECT vend_id FROM products WHERE prod_id = 'br01';
-- 3. br01의 가격이  products 테이블에서 변경되었다. 이를 참조하여 orderitems2의 br01의 가격을 업데이트
UPDATE orderitems2 SET item_price = (SELECT prod_price FROM products WHERE prod_id = 'br01') WHERE prod_id ='br01';
UPDATE orderitems2 o INNER JOIN products p ON o.prod_id = p.prod_id SET o.item_price = p.prod_price * o.quantity WHERE o.prod_id = 'br01';
-- 4. vender_id가 brs01인 사람이 구매한 아이템의 총 가격
SELECT SUM(item_price) FROM orderitems2 where prod_id = (select prod_id from products WHERE vend_id = 'brs01');
-- 5. vender_id가 dll01인사람 구매한 모든 품목중 제일 작은 quantity
SELECT MIN(quantity) FROM orderitems2 WHERE prod_id  = (SELECT prod_id FROM products WHERE vend_id = 'dll01');


-- ------------------------------------------------------


CREATE TABLE `toys` (
  `toy_id` int(11) default NULL,
  `toy` varchar(20) default NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('1','hula hoop');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('2','balsa glider');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('3','toy soldiers');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('4','harmonica');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('5','baseball cards');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('6','tinker toys');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('7','etch-a-sketch');
INSERT INTO `toys` (`toy_id`,`toy`) VALUES ('8','slinky');


CREATE TABLE `store_info` (
  `store_id` int(11) NOT NULL auto_increment,
  `address` varchar(50) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `manager` varchar(50) NOT NULL,
  PRIMARY KEY  (`store_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

INSERT INTO `store_info` (`store_id`,`address`,`phone`,`manager`) VALUES ('1','23 Maple','555-6712','Joe');
INSERT INTO `store_info` (`store_id`,`address`,`phone`,`manager`) VALUES ('2','1902 Amber Ln','555-3478','Susan');
INSERT INTO `store_info` (`store_id`,`address`,`phone`,`manager`) VALUES ('3','100 E. North St.','555-0987','Tara');
INSERT INTO `store_info` (`store_id`,`address`,`phone`,`manager`) VALUES ('4','17 Engleside','555-6554','Gordon');


CREATE TABLE `store_inventory` (
  `toy_id` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  `inventory` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('5','1','34');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('5','3','12');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('5','1','5');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('6','2','10');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('6','4','24');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('9','1','50');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('9','2','2');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('9','2','18');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('12','4','28');
INSERT INTO `store_inventory` (`toy_id`,`store_id`,`inventory`) VALUES ('12','4','11');


CREATE TABLE `toy_info` (
  `toy_id` int(11) NOT NULL,
  `toy` varchar(30) default NULL,
  `color` varchar(30) NOT NULL,
  `cost` decimal(5,2) default NULL,
  `weight` decimal(5,2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('1','whiffleball','white','29.9','0.5');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('2','whiffleball','yellow','22.9','0.7');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('3','whiffleball','blue','23.9','0.2');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('4','frisbee','green','19.9','0.7');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('5','frisbee','yellow','27.8','0.3');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('6','kite','red','39.9','0.3');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('7','kite','blue','25.9','0.9');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('8','kite','green','23.9','0.89');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('9','yoyo','white','22.7','0.7');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('10','yoyo','yellow','24.6','0.9');

SELECT * FROM toy_info;
SELECT * FROM toys;
DELETE FROM toy_info WHERE toy_id =9 or toy_id=10;
DELETE FROM toy_info;

INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('1','hula hoop','white','29.9','0.5');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('2','balsa glider','yellow','22.9','0.7');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('3','toy soldiers','blue','23.9','0.2');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('4','harmonica','green','19.9','0.7');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('5','baseball cards','yellow','27.8','0.3');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('6','tinker toys','red','39.9','0.3');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('7','etch-a-sketch','blue','25.9','0.9');
INSERT INTO `toy_info` (`toy_id`,`toy`,`color`,`cost`,`weight`) VALUES ('8','slinky','green','23.9','0.89');


------------------------------------------------------------
USE orally;
SELECT distinct a.toy_id, a.toy, b.color , d.address FROM toys AS a INNER JOIN toy_info b ON a.toy_id = b.toy_id LEFT OUTER JOIN store_inventory c ON b.toy_id = c.toy_id LEFT OUTER JOIN store_info d ON c.store_id = d.store_id ORDER BY a.toy_id;

SELECT * FROM toys;
SELECT * FROM toy_info;
SELECT * FROM store_inventory;
SELECT * FROM store_info;

-- 1. toys 테이블 toy_id 제품의 색깔과 주소
SELECT distinct a.toy_id, b.color, d.address FROM toys AS a 
	INNER JOIN toy_info b ON a.toy_id = b.toy_id 
	LEFT OUTER JOIN store_inventory c ON b.toy_id = c.toy_id 
	LEFT OUTER JOIN store_info d ON d.store_id= c.store_id 
	ORDER BY a.toy_id;
-- 2. 1. toys 테이블 toy_id 의 제품 중 무제가 0.5 이하인것
SELECT a.toy_id,a.toy, b.weight FROM toys a 
	INNER JOIN toy_info b ON a.toy_id = b.toy_id AND b.weight<=0.5;
	
SELECT toy_id,toy FROM toys 
	WHERE toy_id in (SELECT toy_id FROM toy_info WHERE weight<=0.5);
-- 3. 각 스토어가 가지고 있는 제품과 그 수량, 매니저 이름
SELECT a.store_id, a.toy_id, c.toy , sum(a.inventory), b.manager FROM store_inventory a 
	LEFT OUTER JOIN store_info b ON a.store_id = b.store_id 
	LEFT OUTER JOIN toy_info c ON a.toy_id= c.toy_id 
	GROUP BY a.store_id, a.toy_id 
	ORDER BY a.store_id;
-- 4. 흰색 제품을 가지고 있는 가계의 주소
SELECT c.address , a.toy , a.color FROM toy_info a 
	LEFT OUTER JOIN store_inventory b ON a.toy_id = b.toy_id  
	LEFT OUTER JOIN store_info c ON b.store_id = c.store_id  
	WHERE color = 'yellow';
SELECT distinct a.store_id, a.address, c.color FROM store_info a INNER JOIN store_inventory b ON a.store_id = b.store_id INNER JOIN toy_info c ON b.toy_id = c.toy_id WHERE c.color= 'yellow';
-- 5. 각 toy_id의 이름과 총 무게
SELECT a.store_id, a.toy_id, b.toy, sum(a.inventory), b.weight, b.weight*SUM(a.inventory) FROM store_inventory a 
	inner JOIN toy_info b ON a.toy_id = b.toy_id 
	GROUP BY a.toy_id, a.store_id 
	ORDER BY a.store_id ,a.toy_id;
SELECT a.toy_id, b.toy, SUM(b.weight*a.inventory) FROM store_inventory a INNER JOIN toy_info b ON a.toy_id = b.toy_id;





SELECT * FROM toy_info;
SELECT * FROM store_inventory ORDER BY store_id;



-- 5. 각 toy_id의 이름과 총 무게
SELECT a.store_id, a.toy_id, b.toy, a.inven, b.weight, b.weight*a.inven FROM (SELECT toy_id, store_id, sum(inventory) inven FROM store_inventory GROUP BY toy_id, store_id ORDER BY store_id) a LEFT OUTER JOIN toy_info b ON a.toy_id = b.toy_id GROUP BY a.toy_id, a.store_id ORDER BY a.store_id ;



-- outer join 외부 조인  --------------------------------------------------

USE sqldb;
SELECT * FROM usertbl;
SELECT u.userid, u.name, b.prodname, u.addr, CONCAT(u.mobile1 , u.mobile2) AS '연락처' FROM usertbl u LEFT OUTER JOIN buytbl b ON u.userid = b.userid ORDER BY u.userid;
SELECT u.userid, u.name, b.prodname, u.addr, CONCAT(u.mobile1 , u.mobile2) AS '연락처' FROM usertbl u LEFT OUTER JOIN buytbl b ON u.userid = b.userid WHERE b.prodname IS NULL ORDER BY u.userid;

CREATE TABLE member(
idx INT,
mNAME VARCHAR(20)
);

CREATE TABLE prod(
idx INT,
pNAME VARCHAR(20)
);
INSERT INTO member VALUES(1,'최홍석'),(2,'이정연'),(3,'정지희');
INSERT INTO prod VALUES(1,'신발'),(1,'전화기'),(2,'커피'),(4,'빵');
DELETE FROM prod;
SELECT * FROM member;
SELECT * FROM prod;
SELECT member.idx ,mname , pname FROM member INNER JOIN prod ON member.idx = prod.idx;
SELECT member.idx ,mname , pname FROM member LEFT OUTER JOIN prod ON member.idx = prod.idx;
SELECT prod.idx ,mname , pname FROM member RIGHT OUTER JOIN prod ON member.idx = prod.idx;
select * FROM member UNION SELECT * FROM prod;
SELECT * FROM member cross JOIN prod;

-------------------------------------------------

USE sqldb;
SELECT s.stdname, s.addr, c.clubname, c.roomno FROM stdtbl s LEFT OUTER JOIN stdclubtbl sc ON s.stdname = sc.stdname LEFT OUTER JOIN clubtbl c ON sc.clubname = c.clubname ORDER BY s.stdname;
SELECT c.clubname, c.roomno, s.stdname, s.addr FROM stdtbl s LEFT OUTER JOIN stdclubtbl sc ON sc.stdName = s.stdName RIGHT OUTER JOIN clubtbl c ON sc.clubname = c.clubname ORDER BY c.clubname;

SELECT s.stdname, s.addr, c.clubname, c.roomno FROM stdtbl s LEFT OUTER JOIN stdclubtbl sc ON s.stdname = sc.stdname LEFT OUTER JOIN clubtbl c ON sc.clubname = c.clubname
UNION 
SELECT s.stdname, s.addr, c.clubname, c.roomno FROM stdtbl s LEFT OUTER JOIN stdclubtbl sc ON sc.stdName = s.stdName RIGHT OUTER JOIN clubtbl c ON sc.clubname = c.clubname;
SELECT * FROM buytbl CROSS JOIN usertbl;

USE employees;
SELECT COUNT(*) AS '데이터개수' FROM employees CROSS JOIN departments;
SELECT COUNT(*) AS '데이터개수' FROM employees;

USE sqldb;
CREATE TABLE emptbl ( emp CHAR(3), manager CHAR(3), emptel VARCHAR(8));
INSERT INTO emptbl VALUES(n'나사장',NULL, '0000')
,(n'김재무',n'나사장', '2222')
,(n'김부장',n'김재무', '2222-1')
,(n'이부장',n'김재무', '2222-2')
,(n'우대리',n'이부장', '2222-2-1')
,(n'지사원',n'이부장', '2222-2-2')
,(n'이영업',n'나사장', '1111')
,(n'한과장',n'이영업', '1111-1')
,(n'최정보',n'나사장', '3333')
,(n'윤차장',n'최정보', '3333-1')
,(n'이주임',n'윤차장', '3333-1-1');
SELECT a.emp AS '부하직원' , b.emp AS '직속상관' , b.emptel AS '직속상관연락처' FROM emptbl a INNER JOIN emptbl b ON a.manager = b.emp WHERE a.emp = '우대리';
