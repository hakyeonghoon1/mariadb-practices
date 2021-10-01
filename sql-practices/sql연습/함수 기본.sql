-- 함수 : 문자열 함수

-- upper (대문자로 변환)
select upper('busan'),upper('buSan'),upper('Douzone');
select upper(first_name) from employees;

-- lower (소문자로 변환)
select lower('buSan'), lower('busan'), lower('Douzone');
select lower(first_name) from employees;

-- substring( 문자열 , indxe, length )	db는 1부터 시작
select substring('Hello World',3,2);
-- 예제) 1989년에 입사한 사원들의 이름, 입사일 출력
select first_name, hire_date
from employees
where substring(hire_date , 1,4) = '1989';

-- lpad (오른쪽정렬), rpad(왼쪽정렬)
select lpad('1234', 10, '-');
select rpad('1234', 10, '-');
-- 예제) 직원들의 월급을 오른쪽 정렬로 (빈 공간은 *)
select lpad(salary, 10, '*') from salaries;

-- trim, ltrm, rtrim
select concat('--',ltrim('    hello     '),'--'),
	   concat('--',rtrim('    hello     '),'--'),
       concat('--',trim(both 'x' from 'xxxhexxlloxxx'),'--'); -- 중간에 있는건 안됨