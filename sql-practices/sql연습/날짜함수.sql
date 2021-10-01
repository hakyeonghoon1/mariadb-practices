-- 함수 : 날짜 함수

-- CURDATE(), CURRENT_DATE
select curdate(), current_date;

-- CURTIME(), CURRENT_TIME
select curtime(), current_time;

-- now(), sysdate()
select now(), sysdate();
select now(), sleep(2), now(); -- 쿼리가 시작되는 시간
select sysdate(), sleep(2), sysdate(); -- 실행될때

-- date_format(date, format)
select date_format(now(),'%Y년 %m월 %d일 %h:%i:%s');
select date_format(now(),'%Y년 %c월 %d일 %h:%i:%s');

-- period_diff 날짜 사이의 차이 출력 month로 나옴
-- YYMM, YYYYMM
-- 예제) 근무 개월 수를 출력
select first_name, 
	   period_diff(date_format(curdate(),'%Y%m'),date_format(hire_date,'%Y%m')) as 'month'
from employees
order by month desc;

-- date_add (= adddate), date_sub(= subdate)
-- 날짜를 date에 type(day, month, year) 형식의 표현식(expr) 더하거나 뺀다.
-- 예제) 각 사원들의 근무 년수가 5년이 되는 날은 언제인가
select first_name,
	   hire_date,
       date_add(hire_date, interval 5 year)
from employees;

-- cast
select '12345'+10 ,cast('12345' as int) +10;
select date_format(cast('2021-10-01' as date),'%Y %m %d');
select cast(1-2 as unsigned);

-- mysql type
-- varchar, char, text, CLOB(Character Large OBject)-무한대
-- signed(unsigned), int(integer), medium int, big int, int(11)
-- float, double
-- time, date, datetime
-- LOB: CLOB, BLOB(multi media database 만들 때 좋다)


