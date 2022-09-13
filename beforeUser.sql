drop database if exists `clin_app`;
create database clin_app;
use clin_app;
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


drop table if exists `employee`;
create table employee(
emp_id int auto_increment,
emp_first_name varchar(50),
emp_last_name varchar(50),
mobile varchar(10) not null,
email varchar (100),
dob date,
address varchar(300),
salary int,
hiring_date date,
designation varchar(50),
department_name varchar(100),
clinic_id int,
pathology_lab_id int,
radiology_lab_id int,
primary key (emp_id),
foreign key (clinic_id) references clinic (id),
foreign key (pathology_lab_id) references pathology_lab (pathology_lab_id),
foreign key (radiology_lab_id) references radiology_lab (radiology_lab_id)
);



drop table if exists `doc_qualification`;
create table doc_qualification(
doc_qualification_id int auto_increment,
graduation varchar(100),
graduation_complition_year year,
post_grad varchar(100),
post_grad_complition_year year,
medical_registration_no long,
additional_qualification varchar(100),
additional_qualification_complition_year year,
experience tinyint,
emp_id int unique,
primary key (doc_qualification_id),
foreign key (emp_id) references employee (emp_id)
);



drop table if exists `patient`;
create table patient(
patient_id int auto_increment,
first_name varchar (50) not null,
last_name varchar(50),
age tinyint,
mobile varchar(10) default 'NA',
email varchar (100),
address varchar(300),
pathology_lab_id int,
radiology_lab_id int,
primary key (patient_id),
foreign key (pathology_lab_id) references pathology_lab (pathology_lab_id),
foreign key (radiology_lab_id) references radiology_lab (radiology_lab_id)
);



drop table if exists `prescription`;
create table prescription(
prescription_id int auto_increment,
prescription_date date default (curdate()),
diagnosis longtext,
quantity tinyint,
duration tinyint,
frequency varchar (20),
remarks varchar (30),
patient_id int,
primary key (prescription_id),
foreign key (patient_id) references patient(patient_id)
);



drop table if exists `product`;
create table product(
product_id int auto_increment,
product_name varchar (100),
product_manufacturer_name varchar (100),
frequency varchar (20),
remarks varchar (30),
prescription_id int,
primary key (product_id),
foreign key (prescription_id) references prescription(prescription_id)
);




drop table if exists `pathology_lab`;
create table pathology_lab(
pathology_lab_id int auto_increment,
pathology_lab_name varchar (100),
head_of_dept varchar(100),
clinic_id int unique,
primary key (pathology_lab_id),
foreign key (clinic_id) references clinic (id)
);




drop table if exists `radiology_lab`;
create table radiology_lab(
radiology_lab_id int auto_increment,
radiology_lab_name varchar (100),
head_of_dept varchar(100),
clinic_id int unique,
primary key (radiology_lab_id),
foreign key (clinic_id) references clinic (id)
);





drop table if exists `tests_for_pathology`;
create table tests_for_pathology(
path_test_id int auto_increment,
test_name varchar(100),
primary key (path_test_id)
);



drop table if exists `tests_for_radiology`;
create table tests_for_radiology(
radio_test_id int auto_increment,
test_name varchar(100),
primary key (radio_test_id)
);


set foreign_key_checks=1;
use clin_app;















