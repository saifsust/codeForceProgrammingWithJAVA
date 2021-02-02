#company table
create table company(company_code varchar(50), founder varchar(50));
insert into company values('C1', 'Monika');
insert into company values('C2', 'Samantha');

#lead_manager table
create table lead_manager(lead_manager_code varchar(50), company_code varchar(50));
insert into lead_manager values('LM1', 'C1');
insert into lead_manager values('LM2', 'C2');
#senior_manager
create table senior_manager(senior_manager_code varchar(50), lead_manager_code varchar(50), company_code varchar(50));
insert into senior_manager values('SM1', 'LM1', 'C1');
insert into senior_manager values('SM2', 'LM1', 'C1');
insert into senior_manager values('SM3', 'LM2', 'C2');
#manager table
create table manager(manager_code varchar(50), senior_manager_code varchar(50), lead_manager_code varchar(50), company_code varchar(50));
insert into manager values('M1', 'SM1', 'LM1', 'C1');
insert into manager values('M2', 'SM3', 'LM2', 'C2');
insert into manager values('M3', 'SM3', 'LM2', 'C2');
#employee
create table employee(employee_code varchar(50), manager_code varchar(50), senior_manager_code varchar(50), lead_manager_code varchar(50), company_code varchar(50));
insert into employee values('E1','M1','SM1','LM1','C1');
insert into employee values('E2','M1','SM1','LM1','C1');
insert into employee values('E3','M2','SM3','LM2','C2');
insert into employee values('E4','M3','SM3','LM2','C2');


#Query to solve the problem

select company.company_code, company.founder, 
 count(distinct(lead_manager.lead_manager_code)), 
 count(distinct(senior_manager.senior_manager_code)), 
 count(distinct(manager.manager_code)), 
 count(distinct(employee.employee_code))
 from company
 join lead_manager on company.company_code = lead_manager.company_code
 join senior_manager on senior_manager.lead_manager_code = lead_manager.lead_manager_code
 join manager on manager.senior_manager_code =  senior_manager.senior_manager_code
 join employee on employee.manager_code = manager.manager_code
 group by company.company_code, company.founder
 order by company.company_code asc
