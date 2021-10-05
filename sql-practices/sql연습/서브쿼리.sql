-- subquery
-- 1)from 절의 서브쿼리
select now() as n, sysdate() as b, 3+1 as c;

select * 
from (
		select now() as n, sysdate() as b, 3+1 as c
	 ) s;

-- 2)where 절의 서브쿼리
-- 예제:현재 Fai Bale이 근무하는 부서에서 근무하는 직원의 사번, 전체 이름을 출력해보세요. 
select b.dept_no
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and concat(a.first_name,' ',a.last_name) = 'Fai Bale';

select a.emp_no, concat(a.first_name,' ',a.last_name)
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.dept_no = 'd004';

select a.emp_no, concat(a.first_name,' ',a.last_name)
from employees a, dept_emp b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and b.dept_no = (
					select b.dept_no
					from employees a, dept_emp b
					where a.emp_no = b.emp_no
					and b.to_date = '9999-01-01'
					and concat(a.first_name,' ',a.last_name) = 'Fai Bale'
				);
                
-- 2-1) 단일행 연산자: =, >, <, >=, <=, <>, !=
-- 실습문제1: 현재 전체 사원의 평균 연봉보다 적은 급여를 받는 사원의 이름, 급여를 출력하세요.
select avg(salary)
from salaries
where to_date ='9999-01-01';

select a.first_name, b.salary
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date='9999-01-01'
and b.salary < (
				select avg(salary)
				from salaries
				where to_date ='9999-01-01'
			   )
order by b.salary desc;

-- 실습 문제2: 현재 가장 적은 평균 급여의 직책과 평균급여를 출력하세요.
-- 1) 직책별 평균 급여
select a.title, avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no=b.emp_no
and a.to_date='9999-01-01'
and b.to_date='9999-01-01'
group by a.title
order by avg_salary asc;

-- 2) 가장 적은 평균 급여 sol1
select min(avg_salary)
from (
		select a.title, avg(b.salary) as avg_salary
		from titles a, salaries b
		where a.emp_no=b.emp_no
		and a.to_date='9999-01-01'
		and b.to_date='9999-01-01'
		group by a.title
		order by avg_salary asc
	  ) a;
      
-- 3) 가장 적은 평균 급여 sol2 : top-k
select a.title, avg(b.salary) as avg_salary
from titles a, salaries b
where a.emp_no=b.emp_no
and a.to_date='9999-01-01'
and b.to_date='9999-01-01'
group by a.title
order by avg_salary asc
limit 0,1;

-- 2-2) 복수행 연산자: in, not in, any, all
-- any 사용법
-- 1. =any : in(1,10,20)
-- 2. >any, >=any : 최솟값
-- 3. <any, <=any : 최댓값
-- 4. <>any : not in 과 동일

-- all 사용법
-- 1. =all(x)
-- 2. >all, >=all : 최댓값
-- 3. <all, <=all : 최솟값

-- 실습문제3: 현재 급여가 50000 이상인 직원의 이름을 출력하세요
-- sol1: join
select a.first_name, b.salary
from employees a, salaries b
where a.emp_no= b.emp_no
and b.to_date='9999-01-01'
and b.salary >= 50000
order by b.salary asc;

-- sol2: subquery(in)
select emp_no,salary
from salaries
where to_date='9999-01-01'
and salary > 50000;

select *
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and (a.emp_no, b.salary) in(
		select emp_no, salary
		from salaries
		where to_date='9999-01-01'
		and salary > 50000
		);
        
-- so3:subquery(=any)
select *
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date = '9999-01-01'
and (a.emp_no, b.salary) =any (
		select emp_no, salary
		from salaries
		where to_date='9999-01-01'
		and salary > 50000
		);
        
-- 실습 문제4: 현재 각 부서별로 최고 월급을 받는 직원의 이름과 월급 출력
select a.dept_no, max(b.salary)
from dept_emp a, salaries b
where a.emp_no = b.emp_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
group by a.dept_no;

-- sol1 : where subquery =any(in)
select c.first_name, d.dept_name, b.salary
from dept_emp a, salaries b, employees c, departments d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and a.dept_no = d.dept_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
and (a.dept_no, b.salary) in (
								select a.dept_no, max(b.salary)
								from dept_emp a, salaries b
								where a.emp_no = b.emp_no
								and a.to_date ='9999-01-01'
								and b.to_date ='9999-01-01'
								group by a.dept_no
							);
                            
-- sol2 : from subquery 
select c.first_name, b.salary
from dept_emp a, 
	 salaries b, 
     employees c,
     (
		select a.dept_no, max(b.salary) as max_salary
		from dept_emp a, salaries b
		where a.emp_no = b.emp_no
		and a.to_date ='9999-01-01'
		and b.to_date ='9999-01-01'
		group by a.dept_no
     ) d
where a.emp_no = b.emp_no
and b.emp_no = c.emp_no
and a.dept_no = d.dept_no
and a.to_date ='9999-01-01'
and b.to_date ='9999-01-01'
and b.salary = d.max_salary;