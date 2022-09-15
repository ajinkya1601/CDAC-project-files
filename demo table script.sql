drop database if exists `clin_app_demo1`;
create database clin_app_demo1;
use clin_app_demo1;
set foreign_key_checks=0;


drop table if exists `clinic`;
create table clinic(
id int auto_increment,
clinic_name varchar(100) not null,
clinic_address varchar(300) not null,
clinic_phone varchar(10) unique,
morning_time varchar(30),
afternoon_time varchar(30),
evening_time varchar(30),
registration_date date default (curdate()),
primary key (id)
);


drop table if exists `department`;
create table department(
id int auto_increment,
dept_name varchar(100) not null,
clinic_id int,
primary key (id),
foreign key (clinic_id) references clinic (id)
);


drop table if exists `employee`;
create table employee(
id int auto_increment,
emp_first_name varchar(50),
emp_last_name varchar(50),
mobile varchar(10) not null,
gender varchar(6) not null,
email varchar (100),
dob date,
address varchar(300),
salary int,
hiring_date date,
designation varchar(50),
department_name varchar(100),
dept_id int,
primary key (id),
foreign key (dept_id) references department (id)
);



drop table if exists `doc_qualification`;
create table doc_qualification(
id int auto_increment,
graduation varchar(100),
graduation_completion_year year,
post_grad varchar(100),
post_grad_completion_year year,
medical_registration_no long,
additional_qualification varchar(100),
additional_qualification_completion_year year,
experience tinyint,
employee_id int unique not null,
primary key (id),
foreign key (employee_id) references employee(id)
);



drop table if exists `patient`;
create table patient(
id int auto_increment,
first_name varchar (50) not null,
last_name varchar(50),
age tinyint,
mobile varchar(10) default 'NA',
email varchar (100),
address varchar(300),
dept_id int, 
employee_id int,
primary key (id),
foreign key (dept_id) references department (id),
foreign key(employee_id) references employee(id)
);



drop table if exists `prescription`;
create table prescription(
id int auto_increment,
prescription_date date default (curdate()),
diagnosis longtext,
quantity tinyint,
duration tinyint,
frequency varchar (20),
remarks varchar (30),
patient_id int,
primary key (id),
foreign key (patient_id) references patient(id)
);



drop table if exists `product`;
create table product(
id int auto_increment,
product_name varchar (100),
product_manufacturer_name varchar (100),
prescription_id int,
primary key (id),
foreign key (prescription_id) references prescription(id)
);


set foreign_key_checks=1;
use clin_app_demo1;

