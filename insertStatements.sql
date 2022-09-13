insert into radiologyLab (rLabName, headOfDept, clinicId) values ("My Radiology lab", "Aditya", 1);
insert into radiologyLab (rLabName, headOfDept, clinicId) values ("My Radiology lab", "Gaurav", 2);

select * from radiologyLab;

insert into pathologyLab (pLabName, headOfDept, clinicId) values ("My Radiology lab", "Aditya", 1);



insert into clinic (clinic_name, clinic_address, clinic_phone, morning_time, afternoon_time, evening_time)
values ("My clinic", "Pune","5452569863", "9am to 1pm", "2pm to 5pm", "6pm to 9pm"),
	   ("MyEye Care", "Nagpur","6593215875", "9am to 1pm", "2pm to 5pm", "6pm to 9pm");

/*
department_id, pathology_lab_id, radiology_lab_id
*/


/*
Only run below statement to test the employee
*/
insert into employee(emp_first_name, emp_last_name, mobile, email, dob, address, salary, 
hiring_date, designation, department_name,clinic_id)
values ("Yogesh", "Kakde", "1234567891", "yogesh.kakde@gmail.com", '1991-01-31', "Nagpur", 80000,
'21-02-25', "Manager", "Sales",2);

insert into employee(emp_first_name, emp_last_name, mobile, email, dob, address, salary, 
hiring_date, designation, department_name, clinic_id)
values ("Vaibhav", "Deshmukh", "4563298752", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD", "Mechanical", 1);


insert into employee(emp_first_name, emp_last_name, mobile, email, dob, address, salary, 
hiring_date, designation, department_name, clinic_id)
values ("Sarita", "Hatwar", "4563298752", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD", "Mechanical", 1);

/*
Only run below statement to test the clinic
*/

insert into clinic(clinic_name, clinic_address, clinic_phone, clinic_time, registration_date)
values ("Joshi eye clinic", "Amravati", "1235698654", "12:22:36", "2022-08-16");