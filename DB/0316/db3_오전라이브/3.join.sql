use ssafydb;

-- 사번이 100인 사원의 
-- 사번, 이름, 급여, 부서이름
select employee_id, first_name, salary, department_id
from employees
where employee_id = 100;

select department_name
from departments
where department_id = 90;

-- 사번이 100인 사원의 사번, 이름, 급여, 부서이름
select employees.employee_id, employees.first_name, employees.salary, departments.department_name
from employees, departments
where employees.department_id = departments.department_id
and employees.employee_id = 100;


select e.employee_id 사번, e.first_name, e.salary, d.department_name
from employees e, departments d
where e.department_id = d.department_id
and e.employee_id = 100;


select count(employee_id)
from employees;

select count(department_id)
from departments;

select 107*2, now()
from dual;


-- alias 사용


-- inner join
select e.employee_id 사번, e.first_name, e.salary, e.department_id, d.department_id, d.department_name
from employees e inner join departments d
on e.department_id = d.department_id
where e.employee_id = 100;

select e.employee_id, e.first_name, e.salary, d.department_name, l.city
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and e.employee_id = 100;

select e.employee_id, e.first_name, e.salary, d.department_name, l.city
from employees e inner join departments d inner join locations l
on e.department_id = d.department_id
and d.location_id = l.location_id
where e.employee_id = 100;

select e.employee_id, e.first_name, e.salary, d.department_name, l.city
from employees e inner join departments d 
on e.department_id = d.department_id
inner join locations l
on d.location_id = l.location_id
where e.employee_id = 100;

-- using
select e.employee_id 사번, e.first_name, e.salary, department_id, d.department_name
from employees e join departments d
using (department_id)
where e.employee_id = 100;

select * 
from employees
where department_id is null;

-- natural join
select e.employee_id 사번, e.first_name, e.salary, department_id, d.department_name
from employees e natural join departments d;
where e.employee_id = 100;

desc employees;

desc departments;

explain select * from employees where employee_id < 105;

explain select * from employees where salary between 5000 and 9000;

-- 부서번호가 10인 부서의 부서번호, 부서이름, 도시



-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 회사에 근무하는 사원수 
-- 107명
select e.employee_id, e.first_name, ifnull(d.department_name, '승진발령')
from employees e left outer join departments d
on e.department_id = d.department_id;


-- 회사에 근무하는 모든 사원의 사번, 이름, 부서이름
-- 106명 >> 문제 발생..


-- 부서가 없는(부서번호가 null) 사원 검색


-- 해결



-- 회사에 존재하는 모든 부서의 부서이름과 부서에서 근무하는 사원의 사번, 이름
-- 회사의 부서수 >> 27
select count(distinct department_id)
from departments;

-- 사원이 근무하는 부서수 >> 11
select count(distinct department_id)
from employees;

-- 사원이 없는 부서의 정보는 출력이 않됨.
select department_id, department_name, employee_id, first_name
from employees e right outer join departments dbtest
using (department_id);

select *
from departments;

-- 해결

select ifnull(d.department_name, '승진발령'), e.employee_id, e.first_name
from employees e left outer join departments d
on e.department_id = d.department_id
union
select department_name, employee_id, first_name
from employees e right outer join departments dbtest
using (department_id);

use ssafydb;

-- self join
-- 모든 사원의 사번, 이름, 매니저사번, 매니저이름
select e.employee_id, e.first_name, e.manager_id, m.employee_id, ifnull(m.first_name,'우리대장님')
from employees e left outer join employees m
on e.manager_id = m.employee_id;


-- None-Equi join
-- 모든 사원의 사번, 이름, 급여, 급여등급
select e.employee_id, e.first_name, e.salary, s.grade
from employees e join salgrades s
on e.salary between s.losal and s.hisal;

select *
from salgrades;


-- 사번이 101인 사원의 근무 이력.
-- 근무 당시의 정보를 아래를 참고하여 출력.
-- 출력 컬럼명 : 사번, 이름, 부서이름, 직급이름, 시작일, 종료일
-- 날짜의 형식은 00.00.00

-- 위의 정보를 출력 하였다면 위의 정보에 현재의 정보를 출력.
-- 현재 근무이력의 시작일은 이전 근무이력의 종료일 + 1일로 설정.
-- 종료일은 null로 설정.
