-- select 연습
select * from departments;
select dept_no, dept_name from departments;

-- alias(as 생략가능)
-- 예제1: employees 테이블에서 직원의 이름, 성별, 입사일을 출력
select first_name as '이름', gender as '성별', hire_date as '입사일'
from employees;

-- 예제2: employees 테이블에서 직원의 이름, 성별, 입사일을 출력 + concat 함수
select concat(first_name,' ',last_name) as '전체 이름', gender as '성별', hire_date as '입사일'
from employees;

-- distinct
-- 예제 : title 테이블에서 모든 직급의 이름을 출력
select title from titles limit 0,3;
select distinct title from titles;

-- 정리
-- where 절 #1
-- 예제 : 1991년 이전에 입사한 직원의 이름, 성별, 입사일을 출력
select first_name as '이름', gender as '성별', hire_date as '입사일'
from employees
where hire_date < '1991-01-01'
order by hire_date desc;

-- where 절 #2 : 논리 연산자
-- 예제 : 1989년 이전에 입사한 여직원의 이름, 성별, 입사일을 출력
select first_name, gender, hire_date
from employees
where hire_date <'1989-01-01'
and gender ='F';

-- where 절 #3 : in 연산자
-- 예제 : dept_emp 테이블에서 부서 번호가 d005나 d009에 속한 사원의 사번, 부서번호 출력
select emp_no, dept_no
from dept_emp
where dept_no ='d005' 
or dept_no = 'd009';

select emp_no, dept_no
from dept_emp
where dept_no in ('d005','d009');

select emp_no, dept_no
from dept_emp
where dept_no in (select 'd005'); -- 서브쿼리

-- where 절 #4: LIKE 검색
-- 예제 : 1989년에 입사한 직원의 이름, 입사일을 출력
select first_name, hire_date
from employees
where '1989-01-01' <= hire_date
and hire_date <= '1989-12-31';
-- order by hire_date desc;
-- order by hire_date asc;

select first_name, hire_date
from employees
where hire_date like '1989%';
-- order by hire_date desc;
-- order by hire_date asc;

-- between A and B   A, B 포함됨
select first_name, hire_date
from employees
where hire_date between '1989-01-01' and '1989-12-31'
order by hire_date desc;


-- order by 메모리에 올리는거, 맨 마지막에 작성
-- 예제 1: 남자 직원의 전체 이름, 성별, 입사일을 입사일 순 (선임순)으로 출력
select first_name, gender, hire_date
from employees
where gender = 'M'
order by hire_date asc;

-- 예제 2: 직원들의 사번, 월급을 사번, 월급순으로 출력하세요 
select emp_no, salary
from salaries
order by emp_no asc, salary desc;