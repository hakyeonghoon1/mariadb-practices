-- 문제1. 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력 하시오.

select t1.emp_no, t1.first_name, max(t2.salary)
from employees t1, salaries t2
where t1.emp_no = t2.emp_no; 

-- 문제2. 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력하세요.

select t1.emp_no, concat(t1.first_name,' ',t1.last_name) as fullname, t2.title
from employees t1, titles t2
where t1.emp_no = t2.emp_no
and t2.to_date = '9999-01-01'
order by concat(t1.first_name,' ',t1.last_name) asc;

-- 문제3. 전체 사원의 사번, 이름, 현재 부서를 이름 순서로 출력하세요.

select t1.emp_no, concat(t1.first_name,' ',t1.last_name) as 'full name', t3.dept_name
from employees t1, dept_emp t2, departments t3
where t1.emp_no = t2.emp_no
and t2.dept_no = t3.dept_no
and t2.to_date = '9999-01-01'
order by concat(t1.first_name,' ',t1.last_name) asc;

-- 문제4. 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력합니다.

select t1.emp_no,  concat(t1.first_name,' ',t1.last_name) as fullname, t2.salary, t3.title, t5.dept_name
from employees t1, salaries t2, titles t3, dept_emp t4, departments t5
where t1.emp_no=t2.emp_no
and t1.emp_no = t3.emp_no
and t4.emp_no = t1.emp_no
and t4.dept_no = t5. dept_no
and t2.to_date = '9999-01-01'
and t3.to_date = '9999-01-01'
and t4.to_date = '9999-01-01'
order by concat(t1.first_name,' ',t1.last_name) asc;

-- 문제5. ‘Technique Leader’의 직책으로 과거에 근무한 적이 있는 모든 사원의 사번과 이름을 출력하세요. 
-- (현재 ‘Technique Leader’의 직책(으로 근무하는 사원은 고려하지 않습니다.) 
-- 이름은 first_name과 last_name을 합쳐 출력 합니다.

select t1.emp_no , concat(t1.first_name,' ',t1.last_name)-- , t2.title, t2.to_date
from employees t1, titles t2
where t1.emp_no = t2.emp_no
and t2.to_date != '9999-01-01'
and t2.title = 'Technique Leader'
;

-- 문제6. 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회하세요.

select t1.last_name, t3.dept_name, t4.title
from employees t1, dept_emp t2, departments t3, titles t4
where t1.emp_no = t2.emp_no
and  t2.dept_no = t3.dept_no
and t1.emp_no = t4.emp_no
and t1.last_name like 'S%'
;

-- 문제7. 현재, 직책이 Engineer인 사원 중에서 현재 급여가 40000 이상인 사원을 급여가 큰 순서대로 출력하세요.

select t1.emp_no, concat(t1.first_name,' ',t1.last_name) fullname, t2.title, t3.salary
from employees t1, titles t2, salaries t3
where t1.emp_no = t2.emp_no 
and t1.emp_no = t3.emp_no
and t2.title = 'Engineer'
and t2.to_date ='9999-01-01'
and t3.to_date ='9999-01-01'
and t3.salary >= 40000
order by t3.salary;

-- 문제8. 현재 급여가 50000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력하시오

select t1.emp_no, t2.title, t1.salary
from salaries t1, titles t2
where t1.emp_no = t2.emp_no
and t1.to_date = '9999-01-01'
and t2.to_date = '9999-01-01'
and t1.salary > 50000
order by t1.salary desc;

-- 문제9. 현재, 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력하세요.

select t1.dept_name, avg(t3.salary)
from departments t1, dept_emp t2, salaries t3
where t1.dept_no= t2.dept_no
and t2.emp_no = t3.emp_no
and t2.to_date = '9999-01-01'
and t3.to_date = '9999-01-01'
group by t1.dept_name
order by avg(t3.salary) desc
;

-- 문제10. 현재, 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력하세요.

select t1.title, avg(t2.salary)
from titles t1, salaries t2
where t1.emp_no = t2.emp_no
and t1.to_date = '9999-01-01'
and t2.to_date = '9999-01-01'
group by t1.title
order by avg(t2.salary)  desc;