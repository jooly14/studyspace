USE sqldb;

CREATE TABLE EMP(
    EMPNO INT NOT NULL PRIMARY KEY,
    ENAME VARCHAR(20) NOT NULL,
    JOB VARCHAR(20) NOT NULL,
    MGR INT,
    HIREDATE DATE NOT NULL,
    SAL INT NOT NULL,
    COMM INT,
    DEPTNO INT NOT NULL
);
INSERT INTO EMP VALUES(7369, 'SMITH', 'CLERK', 7902, '80/12/17',800, NULL, 20);
INSERT INTO EMP VALUES(7499, 'ALLEN', 'SALESMAN', 7698, '81/02/20',1600, 300, 30);
INSERT INTO EMP VALUES(7521, 'WARD', 'SALESMAN', 7698, '81/02/22',1250, 500, 30);
INSERT INTO EMP VALUES(7566, 'JONES', 'MANAGER', 7839, '81/04/02',2975, NULL, 20);
INSERT INTO EMP VALUES(7654, 'MARTIN', 'SALESMAN', 7698, '81/09/28',1250, 1400, 30);
INSERT INTO EMP VALUES(7698, 'BLAKE', 'MANAGER', 7839, '81/05/01',2850, NULL, 30);
INSERT INTO EMP VALUES(7782, 'CLARK', 'MANAGER', 7839, '81/06/09',2450, NULL, 10);
INSERT INTO EMP VALUES(7788, 'SCOTT', 'ANALYST', 7566, '87/04/19',3000, NULL, 20);
INSERT INTO EMP VALUES(7839, 'KING', 'PRESIDENT', NULL, '81/11/17',5000, NULL, 10);
INSERT INTO EMP VALUES(7844, 'TURNER', 'SALESMAN', 7698, '81/09/08',1500, 0, 30);
INSERT INTO EMP VALUES(7876, 'ADAMS', 'CLERK', 7788, '87/05/23',1100, NULL, 20);
INSERT INTO EMP VALUES(7900, 'JAMES', 'CLERK', 7698, '81/12/03',950, NULL, 30);
INSERT INTO EMP VALUES(7902, 'FORD', 'ANALYST', 7566, '81/12/03',3000, NULL, 20);
INSERT INTO EMP VALUES(7934, 'MILLER', 'CLERK', 7782, '82/01/23',1300, NULL, 10);

SELECT * FROM EMP;




---------------------------------------------

CREATE TABLE DEPT(
    DEPTNO INT NOT NULL PRIMARY KEY,
    DNAME VARCHAR(20) NOT NULL,
    LOC VARCHAR(20) NOT NULL
);

INSERT INTO DEPT VALUES (10, 'ACCOUNTING','NEW YORK');
INSERT INTO DEPT VALUES (20, 'RESEARCH','DALLAS');
INSERT INTO DEPT VALUES (30, 'SALES','CHICAGO');
INSERT INTO DEPT VALUES (40, 'OPERATIONS','BOSTON');

-----------------------------------------------------
CREATE TABLE SALGRADE(
    GRADE INT NOT NULL PRIMARY KEY,
    LOSAL INT NOT NULL,
    HISAL INT NOT NULL
);

INSERT INTO SALGRADE VALUES (1,700, 1200);
INSERT INTO SALGRADE VALUES (2,1201, 1400);
INSERT INTO SALGRADE VALUES (3,1401, 2000);
INSERT INTO SALGRADE VALUES (4,2001, 3000);
INSERT INTO SALGRADE VALUES (5,3001, 9999);

---------------------------------------------------
-- 1. 사원 이름이 SCOTT인 사원의 EMPNO, ENAME, DNAME을 출력하세요.
SELECT e.empno, e.ename, d.dname FROM emp e INNER JOIN dept d ON e.deptno = d.deptno where e.ename = 'scott';
-- 2. 사원이름과 SAL과 GRADE를 출력하세요.
SELECT ename , sal, grade FROM emp e INNER JOIN salgrade s ON e.sal >=s.losal AND e.sal <=s.hisal;

-- 3. 위 문제에서 부서명을 추가시켜 출력
SELECT ename , sal, grade, dname FROM emp e INNER JOIN salgrade s ON e.sal >=s.losal AND e.sal <=s.hisal INNER JOIN dept d ON e.deptno = d.deptno;

-- 4. 부서번호가 30번인 사원들의 이름,JOB, DEPTNO, LOC를 출력하세요.
SELECT ename, job, e.deptno, loc FROM emp e INNER JOIN dept d ON e.deptno = d.deptno where e.deptno = 30;

-- 5. COMM을 받은사원의 이름, 보너스, 부서명, 부서위치를 출력하세요.
SELECT ename, comm, dname, loc FROM emp e INNER JOIN dept d ON e.deptno = d.deptno where e.comm IS NOT NULL AND e.comm !=0;

-- 6. DALLAS에서 근무하는 사원들의 이름, 직급, 부서번호, 부서명을 출력하세요.
SELECT ename, job, e.deptno , dname FROM emp e INNER JOIN dept d ON d.deptno = e.deptno where loc = 'dallas';

-- 7. 이름에 'A'가 들어가는 사원들의 이름과 부서명을 출력하세요.
SELECT ename, dname FROM emp e INNER JOIN dept d ON e.deptno = d.deptno where ename LIKE '%a%';

-- 8. SMITH의 사원이름, 부서번호와 SMITH과 같은 부서에 있는 사원을 출력하세요.
-- (해당사원과 같은부서에 있는 사원의 CLUMN을 '동료'라고 설정해주세요)
SELECT e1.ename , e1.deptno , e2.ename AS '동료'  FROM emp e1 inner JOIN emp e2 ON e1.deptno= e2.deptno 
WHERE e1.ename = 'smith' AND e2.deptno = 20 AND e2.ename !='smith';

-- 9. 각 직원의 이름과 그 매니저 이름을 출력하세요(매니저 = MGR)
SELECT e1.ename AS '직원' , e2.ename AS '매니저' FROM emp e1 INNER JOIN emp e2 ON e1.mgr = e2.empno;

-- 프로시저 : 일종의 함수같은 것 ------------------------------------------------------------------------

DROP PROCEDURE if EXISTS ifProc;
delimiter $$
CREATE PROCEDURE ifProc()
BEGIN
	DECLARE var1 INT;
	SET var1 := 100;
	
	if var1 = 100 then
		SELECT '100입니다';
	ELSE
		SELECT '100이 아닙니다';
	END if;
END $$
delimiter ;
CALL ifProc();


DROP PROCEDURE if EXISTS ifProc2;
USE employees;
delimiter $$
CREATE PROCEDURE ifProc2()
BEGIN
	DECLARE hireDate DATE;
	DECLARE CURDATE DATE;
	DECLARE days INT;
	SELECT hire_date INTO hireDate FROM employees.employees WHERE emp_no = 10007;
	
	SET CURDATE := CURRENT_DATE();
	SET days := DATEDIFF(curdate,hireDate);
	if(days/365 >=5 ) then
		SELECT CONCAT('입사한 지 ' , days , '일이 지났습니다. 축하합니다');
	else
		SELECT '입사한 지 ' +days +'일 되었네요. 열심히 일하세요';
	END if;
END $$
delimiter ;
CALL ifProc2();

----------------------------------------------------------
DROP PROCEDURE if EXISTS ifProc3;
delimiter $$
CREATE PROCEDURE ifProc3()
BEGIN
	DECLARE POINT INT;
	DECLARE credit CHAR(1);
	SET POINT := 77;
	
	if POINT >=90 then
		SET credit :='A';
	ELSEIF POINT >=80 then
		SET credit :='B';
	elseif point >=70 then
		SET credit :='C';	
	elseif POINT >=60 then
		SET credit :='D';
	else
		SET credit :='F';	
	END if;
	select credit;
END$$
delimiter ;
CALL ifProc3();

USE sqldb;

DROP PROCEDURE if EXISTS proc4;
delimiter $$
CREATE PROCEDURE proc4(IN id VARCHAR(20))
BEGIN
-- 	DECLARE id VARCHAR(20);
-- 	SET id := 'bbk';
	
	SELECT * FROM usertbl WHERE userid = id;
	
END $$
delimiter ;
CALL proc4('bbk');

DROP PROCEDURE if EXISTS proc5;
delimiter $$
CREATE PROCEDURE proc5(IN id VARCHAR(20), OUT result INT, OUT result2 int)
BEGIN
	
	SELECT COUNT(*) INTO result FROM buytbl WHERE userid = id;
	SET result2 :=10;
END $$
delimiter ;
CALL proc5('kbs',@result,@result2);
SELECT @result;
SELECT @result2;
SELECT * FROM buytbl;

-------------------------------------------
USE sqldb;
-- 간단한 문제1
DROP PROCEDURE if exists proc1_1;
delimiter $$
CREATE PROCEDURE proc1_1(
	IN n1 INT, IN n2 INT , OUT result int
)
BEGIN
	SET result := n1 + n2;
END $$
delimiter ;
CALL proc1_1(1,4,@res);
SELECT @res;

-- 간단한 문제2
DROP PROCEDURE if exists proc1_2;
delimiter $$
CREATE PROCEDURE proc1_2(
	IN str VARCHAR(20) , OUT result int
)
BEGIN
	SET result := CHARACTER_LENGTH(str);
END $$
delimiter ;
CALL proc1_2('하이헬로',@res);
SELECT @res;

-- 문제1 이름 2개 입력 , 두명 연봉 사이의 모든 사람과 grade 출력
DROP PROCEDURE if exists proc2_1;
delimiter $$
CREATE PROCEDURE proc2_1(
	IN NAME1 VARCHAR(10), IN NAME2 VARCHAR(10)
)
BEGIN
	DECLARE sal1 INT;
	DECLARE sal2 INT;
	
	SELECT sal INTO sal1 FROM emp WHERE ename=NAME1;
	SELECT sal INTO sal2 FROM emp WHERE ename=NAME2;
	if(sal1>sal2) then
		SELECT e.ename, e.sal, s.grade FROM emp e INNER JOIN salgrade s ON e.SAL >=s.LOSAL AND e.sal <= s.HISAL WHERE e.sal >sal2 AND e.sal <sal1;
	ELSE 
		SELECT e.ename, e.sal, s.grade FROM emp e INNER JOIN salgrade s ON e.SAL >=s.LOSAL AND e.sal <= s.HISAL WHERE e.sal >sal1 AND e.sal <sal2;		 
	END if;
END $$
delimiter ;
CALL proc2_1('smith','ward');

-- 문제2 이름 입력, 매니저의 이름과 매니저의 job 출력
DROP PROCEDURE if exists proc2_2;
delimiter $$
CREATE PROCEDURE proc2_2(
	IN NAME1 VARCHAR(10)
)
BEGIN
	SELECT e1.ename AS '직원' , e2.ename AS '매니저' , e2.job AS '매니저의 job' FROM emp e1 INNER JOIN emp e2 ON e1.MGR = e2.EMPNO WHERE e1.ename = NAME1;

END $$
delimiter ;
CALL proc2_2('smith');

-- 문제3 empno 입력후 deptno값을 변수담기. 결과 변수를 이용해 dname 출력
DROP PROCEDURE if exists proc2_3;
delimiter $$
CREATE PROCEDURE proc2_3(
	IN empno_in int , OUT dname_out VARCHAR(20)
)
BEGIN
	DECLARE deptno_val INT;
	
	SELECT deptno INTO deptno_val FROM emp WHERE empno = empno_in;
	SELECT dname INTO dname_out FROM dept WHERE deptno = deptno_val;

END $$
delimiter ;
CALL proc2_3(7369,@NAME);
SELECT @NAME;

---------------------------------------------------------------
DROP PROCEDURE if EXISTS whileProc;
delimiter $$
CREATE PROCEDURE whileProc()
BEGIN
	DECLARE i INT;
	DECLARE hap INT;
	SET i :=1;
	SET hap :=0;
	while(i<=100) do
		SET hap := hap +i;
		SET i := i+1;
	END while;
	SELECT hap;
END $$
delimiter ;
CALL whileProc();
--------------------------------------------------------------
USE sqldb;
SELECT * FROM usertbl;
DROP PROCEDURE if EXISTS userProc1;
delimiter $$
CREATE PROCEDURE userProc1(IN userName VARCHAR(10))
BEGIN
	SELECT * FROM usertbl WHERE NAME = userName;
END $$
delimiter ;
CALL userProc1('조관우');
-----------------------------------------------
DROP PROCEDURE if EXISTS userProc2;
delimiter $$
CREATE PROCEDURE userProc2(IN userBirth INT, IN userHeight int)
BEGIN
	SELECT * FROM usertbl WHERE birthYear > userBirth  AND height >userHeight;
END $$
delimiter ;
CALL userProc2(1970,178);

DROP PROCEDURE if EXISTS userProc3;
delimiter $$
CREATE PROCEDURE userProc3(IN txtValue CHAR(10), out outValue int)
BEGIN
	INSERT INTO testtbl10 VALUES(NULL, txtValue);
	SELECT MAX(id) INTO outValue FROM testtbl10;
END $$
delimiter ;
CREATE TABLE if NOT EXISTS testtbl10(
	id INT AUTO_INCREMENT PRIMARY KEY,
	txt CHAR(10)
);
CALL userProc3('테스트값',@myValue);
SELECT CONCAT('현재 입력된 id 값 == > ',@myValue);
-------------------------------------------------
DROP PROCEDURE if EXISTS ifelseProc;
delimiter $$
CREATE PROCEDURE ifelseProc (
	IN userName VARCHAR(10)
)
BEGIN
	DECLARE bYear INT;
	SELECT birthYear INTO bYear FROM usertbl WHERE NAME = userName;
	
	if (bYear >=1980) then
		SELECT '아직 젊군요..';
	else
		SELECT '나이가 지긋하네요';
	END if;
END $$
delimiter ;

CALL ifelseProc('조용필');
----------------------------------------
DROP PROCEDURE if EXISTS caseProc;
delimiter $$
CREATE PROCEDURE caseProc (
	IN userName VARCHAR(10)
)
BEGIN
	DECLARE bYear INT;
	DECLARE tti char(3);
	SELECT birthYear INTO bYear FROM usertbl WHERE NAME = userName;
	
	case 
		when (bYear%12 = 0) then SET tti:='원숭이';
				when (bYear%12 = 1) then SET tti:='닭';
				when (bYear%12 = 2) then SET tti:='개';
				when (bYear%12 = 3) then SET tti:='돼지';
				when (bYear%12 = 4) then SET tti:='쥐';
				when (bYear%12 = 5) then SET tti:='소';
				when (bYear%12 = 6) then SET tti:='호랑이';
				when (bYear%12 = 7) then SET tti:='토끼';
				when (bYear%12 = 8) then SET tti:='용';
				when (bYear%12 = 9) then SET tti:='뱀';
				when (bYear%12 = 10) then SET tti:='말';
		ELSE SET tti := '양';
	END case;
	SELECT CONCAT(userName , '의 띠 ==> ',tti);
END $$
delimiter ;

CALL caseProc('김범수');
---------------------------------------------------------
DROP TABLE if EXISTS guguTbl;
CREATE TABLE gugutbl (
	txt VARCHAR(100));

DROP PROCEDURE if EXISTS whileProc;
delimiter $$
CREATE PROCEDURE whileProc()
BEGIN
	DECLARE str VARCHAR(100);
	DECLARE i INT;
	DECLARE k INT;
	SET i :=2;
	
	while(i<10) do
		SET str :='';
		SET k :=1;
		while(k<10) do
			SET str := CONCAT(str,' ',i,'x',k,'=',i*k);
			SET k := k+1;
		END while;
		SET i:= i+1;
		INSERT INTO gugutbl VALUES(str);
	END while;
END$$
delimiter ;
CALL whileProc();
SELECT * FROM gugutbl;

-----------------------------------------------
DROP PROCEDURE if EXISTS errorProc;
delimiter $$
CREATE PROCEDURE errorProc()
BEGIN
	DECLARE i INT;
	DECLARE hap INT;
	DECLARE saveHap INT;
	
	DECLARE exit handler FOR 1264
	BEGIN
		SELECT CONCAT('int 오버플로 직전의 합계 : ',saveHap);
		SELECT CONCAT('1+2+3+4+......+',i,'=오버플로');
	END;
	
	SET i := 1;
	SET hap :=0;
	while(TRUE) do
		SET saveHap := hap;
		SET hap := hap + i;
		SET i:= i+1;
	END while;
END $$
delimiter ;
CALL errorProc();
-------------------------------------------------------------------
SELECT routine_name, routine_definition FROM information_schema.ROUTINES WHERE routine_schema = 'sqldb' AND routine_type ='procedure';
SELECT param_list , body FROM mysql.proc WHERE db = 'sqldb' AND TYPE='procedure' AND NAME = 'userProc3'
SHOW CREATE PROCEDURE sqldb.userProc3;

------------------------------------------------------
USE sqldb;
DROP PROCEDURE if EXISTS nameProc;
delimiter $$
CREATE PROCEDURE nameProc(
	IN tblName VARCHAR(20)	
)
BEGIN
	SET @sqlQuery = CONCAT('select * from ' , tblName);
	PREPARE myQuery FROM	@sqlquery;
	EXECUTE myquery;
	DEALLOCATE PREPARE myquery;
END $$
delimiter ;
CALL nameProc('userTbl');

--------------------------------
DROP FUNCTION if EXISTS userFunc;
delimiter $$
CREATE FUNCTION userFunc(val1 INT, val2 INT)
	RETURNS int
BEGIN
	RETURN val1 + val2;
END$$
delimiter ;
SELECT userFunc(1,3);
------------------------------------

DROP FUNCTION if EXISTS getAgeFunc;
delimiter $$
CREATE FUNCTION getAgeFunc(bYear INT)
	RETURNS int
BEGIN
	DECLARE age INT;
	SET age := YEAR(CURDATE()) - bYear;
	RETURN age;
END$$
delimiter ;
SET @yval := (SELECT getAgeFunc(1979));
SELECT @yval;

SELECT userid, NAME, getAgeFunc(birthYear) AS '만 나이' FROM usertbl;
-------------------------------------------------


DROP FUNCTION if EXISTS getDayFunc;
delimiter $$
CREATE FUNCTION getDayFunc(bYear date)
	RETURNS int
BEGIN
-- 	RETURN TIMESTAMPDIFF(day,bYear,CURDATE());
	RETURN DATEDIFF(CURDATE(),bYear);
END $$
delimiter ;
SELECT getDayFunc('1990-12-22');

--------------------------------------------------
DROP FUNCTION if EXISTS gugu;
delimiter $$
CREATE FUNCTION gugu(dan INT)
	RETURNS VARCHAR(100)
BEGIN
	DECLARE i INT;
	DECLARE result VARCHAR(100);
	SET i:= 1;
	SET result := '';
	while (i<10) do
		set result := CONCAT(result,dan,'x',i,'=',dan*i,' ');
		SET i := i +1;
	END while;
	RETURN result;
END $$
delimiter ;

SELECT gugu(2);
----------------------------------------------------
USE orally;
SELECT * FROM cookie_sales;
DESC cookie_sales;

DROP FUNCTION if EXISTS getSales;
delimiter $$
CREATE FUNCTION getSales(firstName VARCHAR(10), saleDate date)
	RETURNS DECIMAL(5,2)
BEGIN
	RETURN (SELECT SUM(sales) FROM cookie_sales WHERE first_name = firstName AND sale_date = saledate);
END$$
delimiter ;
SELECT first_name, getSales(first_name, '2007-03-12') FROM cookie_sales GROUP BY first_name;


----------------------------------------------------
DROP PROCEDURE if EXISTS getSaleProc;
delimiter $$
CREATE PROCEDURE getSaleProc(IN saleDate DATE)
BEGIN
	SELECT first_name,SUM(sales) FROM cookie_sales WHERE sale_date= saledate GROUP BY first_name;
END $$
delimiter ;
CALL getSaleProc('2007-03-12');


----------------------------------------------------------
DROP TABLE testtbl1;
CREATE TABLE testtb1(
    id INT,
    pw VARCHAR(50),
    name VARCHAR(50)
);

INSERT INTO testtb1 VALUES(1,'pw1','조현영');
INSERT INTO testtb1 VALUES(2,'pw2','박초아');
INSERT INTO testtb1 VALUES(3,'pw3','김태연');
INSERT INTO testtb1 VALUES(4,'pw4','김지숙');
INSERT INTO testtb1 VALUES(5,'pw5','이상현');


SELECT * FROM testtb1;

DELIMITER $$
CREATE PROCEDURE test_proc1() 
BEGIN
  DECLARE done INT DEFAULT FALSE; -- 마지막임을 확인하기 위한 변수
  DECLARE v_count INT DEFAULT -1; -- count의 갯수
  DECLARE v_id varchar(20);
  DECLARE v_pw varchar(20);
  DECLARE v_name varchar(20);
    
  -- select한 결과를 cursor1로 정의 
  DECLARE cursor1 CURSOR FOR 
   SELECT id
         , pw
         , name
     FROM TESTTB1;
 
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
 
  OPEN cursor1;
 
  my_loop: LOOP
 
  -- loop 하며 cursor1의 데이터를 불러와 변수에 넣는다.
  FETCH cursor1 
   INTO v_id
        , v_pw
        , v_name;
    
   SET v_count = v_count +1 ; 
 
    -- cursor1 반복이 끝나면 loop 빠져나간다.
    IF done THEN
      LEAVE my_loop;
    END IF;
     
     IF(v_id = 1) THEN
         UPDATE TESTtb1
           SET name = '전효성'
         WHERE id = v_id;
 
    ELSEIF (v_id = 2) THEN
    INSERT INTO TESTTB1(id, pw, name)
         VALUES(6, '비밀번호', '최홍석');
         
    ELSE 
         UPDATE TESTTB1
           SET name = CONCAT(v_name, v_id)
         WHERE id = v_id;
         
     END IF;
     
  END LOOP;
 
  SELECT v_count; 
 
  -- 커서를 닫는다. 
  CLOSE cursor1;
 
END $$
 
DELIMITER ;


CALL test_proc1();

SELECT * FROM testtb1;testtbl1