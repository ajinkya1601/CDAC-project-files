 insert into clinic (clinic_name, clinic_address, clinic_phone, morning_time, afternoon_time, evening_time)
values ("My clinic", "Pune","5452569863", "9am to 1pm", "2pm to 5pm", "6pm to 9pm"),
	   ("MyEye Care", "Nagpur","6593215875", "9am to 1pm", "2pm to 5pm", "6pm to 9pm");
 
 insert into department (dept_name, clinic_id)
values ("Oncology", 1),
	   ("Dentist", 1),
       ("Ophthalmology", 1),
       ("Oncology", 2),
	   ("Dentist", 2),
       ("Gynecology", 2);

 
 insert into employee(emp_first_name, emp_last_name, mobile, gender, email, dob, address, salary, 
hiring_date, designation, dept_id)
values ("Yogesh", "Kakde", "1234567891","male", "yogesh.kakde@gmail.com", '1991-01-31', "Nagpur", 80000,
'21-02-25', "Manager",2);

insert into employee(emp_first_name, emp_last_name, mobile, gender, email, dob, address, salary, 
hiring_date, designation, dept_id)
values ("Vaibhav", "Deshmukh", "4563298752", "male", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD", 3);

insert into employee(emp_first_name, emp_last_name, mobile, gender, email, dob, address, salary, 
hiring_date, designation, dept_id)
values ("Sarita", "Hatwar", "4563298752", "female", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD", 6);
 
 insert into doc_qualification(graduation, graduation_completion_year, post_grad, post_grad_completion_year,
 medical_registration_no, additional_qualification, additional_qualification_completion_year, experience, employee_id)
 values("Mbbs", 1994, "MD", 1998, 5451215412, "MS", 2001, 10, 2);
 
 
 insert into doc_qualification(graduation, graduation_completion_year, post_grad, post_grad_completion_year,
 medical_registration_no, additional_qualification, additional_qualification_completion_year, experience, employee_id)
 values("BHMS", 1994, "MD", 1998, 5451215412, "MS", 2001, 10, 1);
 
insert into patient(first_name, last_name, age, mobile, email, address, dept_id, employee_id)
 values ("Aditya", "Hatwar", 27, "2563269854", "aditya@gmail.com", "Nagpur",1,1),
		("Prasad", "Bandawar", 26, "5563269854", "prasad@gmail.com", "Chandrapur",2,2);
        

 insert into prescription(prescription_date, diagnosis, quantity, duration, frequency, remarks, patient_id)
 values("2001-12-21", "A year in four-digit format", 30, 5, "2-2-2", "Before lunch", 1),
	   ("2003-04-10", "What is the name of first product", 20, 10, "1-1", "After lunch", 2);
    
    insert into product(product_name, product_manufacturer_name, prescription_id)
		    values ("Dolo", "ABC Company", 1),
				   ("MedZ", "Globle Care", 2);            
 