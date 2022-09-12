insert into radiologyLab (rLabName, headOfDept, clinicId) values ("My Radiology lab", "Aditya", 1);
insert into radiologyLab (rLabName, headOfDept, clinicId) values ("My Radiology lab", "Gaurav", 2);

select * from radiologyLab;

insert into pathologyLab (pLabName, headOfDept, clinicId) values ("My Radiology lab", "Aditya", 1);

insert into clinic (clinicName, clinicAddress, clinicPhone, clinicTime)
values ("My clinic", "Address","5452569863", "23:00:00");

/*
department_id, pathology_lab_id, radiology_lab_id
*/


/*
Only run below statement to test the employee
*/
insert into employee(emp_first_name, emp_last_name, mobile, email, dob, address, salary, 
hiring_date, designation)
values ("Yogesh", "Kakde", "1234567891", "yogesh.kakde@gmail.com", '1991-01-31', "Nagpur", 80000,
'21-02-25', "Manager");

insert into employee(emp_first_name, emp_last_name, mobile, email, dob, address, salary, 
hiring_date, designation)
values ("Vaibhav", "Deshmukh", "4563298752", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD");
