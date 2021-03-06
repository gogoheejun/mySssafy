-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employee_id, first_name, salary, department_id
from employees
where employee_id = 100;

select department_name
from departments
where department_id = 90;

select employee_id, first_name, salary, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id = 100;

-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employee_id, first_name, salary, department_id, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id = 100;

select employee_id, first_name, salary, employees.department_id, department_name
from employees, departments
where employees.department_id = departments.department_id
and employee_id = 100;

-- alias 사용
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id
and e.employee_id = 100;

-- inner join
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where e.employee_id = 100;

-- using
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e join departments d
using (department_id)
where e.employee_id = 100;

-- natural join
select e.employee_id, e.first_name, e.salary, e.department_id, d.department_name
from employees e natural join departments d
where e.employee_id = 100;

-- 부서번호가 10인 부서의 부서번호, 부서이름, 도시
select d.department_id, d.department_name, l.city
from departments d natural join locations l
where d.department_id = 10;


-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 회사에 근무하는 사원수 
-- 107명
select count(employee_id)
from employees;

-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 106명 >> 문제 발생..
select e.employee_id, e.first_name, d.department_name
from employees e join departments d
using (department_id);

-- 부서가 없는(부서번호가 null) 사원 검색
select employee_id, first_name, department_id
from employees
where department_id is null;

-- 해결
select e.employee_id, e.first_name, d.department_name
from employees e left outer join departments d
using (department_id);


-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
-- 회사의 부서수 >> 27
select count(department_id)
from departments;

-- 사원이 근무하는 부서수 >> 11
select count(distinct department_id)
from employees;

-- 사원이 없는 부서의 정보는 출력이 않됨.
select d.department_name, e.employee_id, e.first_name
from employees e join departments d
using (department_id);

-- 해결
select d.department_name, e.employee_id, e.first_name
from employees e right outer join departments d
using (department_id);

-- self join
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름
select e.employee_id, e.first_name, m.employee_id, m.first_name
from employees e inner join employees m
on e.manager_id = m.employee_id;

-- None-Equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary >= s.losal
and e.salary <= s.hisal;

select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
where e.salary between s.losal
and s.hisal;


-- 사번이 101인 사원의 근무 이력.
-- 근무 당시의 정보를 아래를 참고하여 출력.
-- 출력 컬럼명 : 사번, 이름, 부서이름, 직급이름, 시작일, 종료일
-- 날짜의 형식은 00.00.00

-- 위의 정보를 출력 하였다면 위의 정보에 현재의 정보를 출력.
-- 현재 근무이력의 시작일은 이전 근무이력의 종료일 + 1일로 설정.
-- 종료일은 null로 설정.

select e.employee_id 사번, e.first_name 이름, d.department_name 부서이름, j.job_title 직급이름, 
		date_format(h.start_date, '%y.%m.%d') 시작일, date_format(h.end_date, '%y.%m.%d') 종료일
from employees e join job_history h
on e.employee_id = h.employee_id
join departments d
on h.department_id = d.department_id
join jobs j
on h.job_id = j.job_id
where e.employee_id = 101
union
select e.employee_id, e.first_name, d.department_name, j.job_title, 
		(select date_format(date_add(max(end_date), interval 1 day), '%y.%m.%d') from job_history where employee_id = 101), null
from employees e join departments d
using (department_id)
join jobs j
using (job_id)
where employee_id = 101;

select date_add(max(end_date), interval 1 day) from job_history where employee_id = 101;