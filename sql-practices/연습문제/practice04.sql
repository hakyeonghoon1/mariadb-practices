-- 문제1.현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
select count(*)
from employees a, salaries b
where a.emp_no = b.emp_no
and b.to_date='9999-01-01'
and b.salary > (
					select avg(salary)
					from salaries
					where to_date = '9999-01-01'
				);
                
-- 문제2.현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 
-- 단, 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select a.emp_no, a.first_name, c.dept_name, d.salary
from employees a, dept_emp b, departments c, salaries d
where a.emp_no=b.emp_no
and b.dept_no = c.dept_no
and a.emp_no = d.emp_no
and d.to_date='9999-01-01'
and b.to_date='9999-01-01'
and (a.emp_no, d.salary) in (
								select b.dept_no, max(a.salary)
								from salaries a, dept_emp b
								where a.emp_no = b.emp_no
								and a.to_date='9999-01-01'
								and b.to_date='9999-01-01'
								group by b.dept_no
							)
order by d.salary desc;

select c.emp_no, c.first_name, d.dept_name, b.salary
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
							)
order by b.salary desc;                           

select dept_no, max(a.salary) as max_salary
from salaries a, dept_emp b
where a.emp_no = b.emp_no
and a.to_date='9999-01-01'
and b.to_date='9999-01-01'
group by b.dept_no;

-- 문제3.현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
select a.emp_no, a.first_name, b.salary-- , c.avg_salary, d.dept_no
from employees a, salaries b,
(
	select a.dept_no, avg(b.salary) as avg_salary
	from dept_emp a, salaries b
	where a.emp_no = b.emp_no
	and a.to_date='9999-01-01'
	and b.to_date='9999-01-01'
	group by a.dept_no
) c, dept_emp d
where a.emp_no = b.emp_no
and d.emp_no =a.emp_no
and c.dept_no =d.dept_no
and d.to_date='9999-01-01'
and b.to_date='9999-01-01'
and b.salary > c.avg_salary;

-- 문제4.현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
select a.emp_no, a.first_name, e.first_name as manager, d.dept_name
from employees a, dept_emp b,
	(
		select *
		from dept_manager
		where to_date='9999-01-01'	
    ) c,
    departments d,
    employees e
where a.emp_no = b.emp_no
and b.dept_no = c.dept_no
and c.dept_no = d.dept_no
and c.emp_no = e.emp_no
and b.to_date='9999-01-01'
order by a.emp_no;

-- 문제5.현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
select a.emp_no, a.first_name, b.title, c.salary , d.dept_no
from employees a, titles b, salaries c, dept_emp d
where a.emp_no = b.emp_no
and a.emp_no= c.emp_no
and a.emp_no=d.emp_no
and b.to_date='9999-01-01'
and c.to_date='9999-01-01'
and d.dept_no =(
				select dept_no
				from(
				select b.dept_no, avg(a.salary) as avg_salary
				from salaries a, dept_emp b
				where a.emp_no = b.emp_no
                and a.to_date='9999-01-01'
                and b.to_date='9999-01-01'
				group by b.dept_no) y
				where y.avg_salary = (
						select max(avg_salary)
						from
						(
							select b.dept_no, avg(a.salary) as avg_salary
							from salaries a, dept_emp b
							where a.emp_no = b.emp_no
                            and b.to_date='9999-01-01'
                            and a.to_date='9999-01-01'
							group by b.dept_no
						) z
					)
			)
order by c.salary desc;

-- 문제6.평균 연봉이 가장 높은 부서는? 
select dept_no
from(
select b.dept_no, avg(a.salary) as avg_salary
from salaries a, dept_emp b
where a.emp_no = b.emp_no
-- and a.to_date='9999-01-01'
-- and b.to_date='9999-01-01'
group by b.dept_no) y
where y.avg_salary = (
		select max(avg_salary)
		from
		(
			select b.dept_no, avg(a.salary) as avg_salary
			from salaries a, dept_emp b
			where a.emp_no = b.emp_no
			-- and b.to_date='9999-01-01'
			-- and a.to_date='9999-01-01'
			group by b.dept_no
		) z
);
-- 문제7.평균 연봉이 가장 높은 직책?
select x.title
from
(
	select a.title, avg(b.salary) as avg_salary1
	from titles a, salaries b
	where a.emp_no = b.emp_no
	group by a.title
) x
where x.avg_salary1 =(
	select max(avg_salary)
	from(
		select a.title, avg(b.salary) as avg_salary
		from titles a, salaries b
		where a.emp_no = b.emp_no
		group by a.title
	) a
);
-- 문제8. 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
select *
from employees a, salaries b, dept_emp c, departments d
where a.emp_no = b.emp_no
and a.emp_no = c.emp_no
and c.dept_no = d.dept_no
and b.to_date='9999-01-01'
and c.to_date='9999-01-01'
;
select *
from dept_manager
where to_date='9999-01-01';
