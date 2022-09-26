 
 insert into user (username, password, role) 
 values("ajinkya123", "$2a$10$SXSjk1G9N8eIFNaVNiHtP.SvhKiKfXZ6V4ZiJhfX9YZ86YsOn8IJu", "ADMIN");
											
-- select * from user;
 
 insert into clinic (clinic_name, clinic_email, clinic_address, clinic_phone, morning_time,
					afternoon_time, evening_time, image, user_username)
values ("My clinic", "myclinic@gmail.com", "Pune","5452569863", "9am to 1pm", "2pm to 5pm", "6pm to 9pm", null, "ajinkya123"),
	   ("MyEye Care", "myeyeclinic@gmail.com", "Nagpur","6593215875", "9am to 1pm", "2pm to 5pm", "6pm to 9pm", null);
 
 insert into department (dept_name, clinic_id)
values ("Oncology", 1),
	   ("Dentist", 1),
       ("Ophthalmology", 1),
       ("Oncology", 2),
	   ("Dentist", 2),
       ("Gynecology", 2);

 
 insert into employee(emp_first_name, emp_last_name, mobile, gender, email, dob, address, salary, 
hiring_date, designation, image, dept_id)
values ("Yogesh", "Kakde", "1234567891","male", "yogesh.kakde@gmail.com", '1991-01-31', "Nagpur", 80000,
'21-02-25', "Manager", null, 2);

insert into employee(emp_first_name, emp_last_name, mobile, gender, email, dob, address, salary, 
hiring_date, designation, image, dept_id)
values ("Vaibhav", "Deshmukh", "4563298752", "male", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD", null, 3);

insert into employee(emp_first_name, emp_last_name, mobile, gender, email, dob, address, salary, 
hiring_date, designation, image, dept_id)
values ("Sarita", "Hatwar", "4563298752", "female", "vaibhav.deshmukh@gmail.com", '1980-01-31', "Pune", 30000,
'21-02-15', "HOD", null, 6);
 
 insert into doc_qualification(graduation, graduation_completion_year, post_grad, post_grad_completion_year,
 medical_registration_no, additional_qualification, additional_qualification_completion_year, experience, employee_id)
 values("Mbbs", 1994, "MD", 1998, 5451215412, "MS", 2001, 10, 2);
 
 
 insert into doc_qualification(graduation, graduation_completion_year, post_grad, post_grad_completion_year,
 medical_registration_no, additional_qualification, additional_qualification_completion_year, experience, employee_id)
 values("BHMS", 1994, "MD", 1998, 5451215412, "MS", 2001, 10, 1);
 
insert into patient(first_name, last_name, age, mobile, email, address, gender, image, dept_id, employee_id)
 values ("Aditya", "Hatwar", 27, "2563269854", "aditya@gmail.com", "Nagpur", "Male", null, 1, 1),
		("Prasad", "Bandawar", 26, "5563269854", "prasad@gmail.com", "Chandrapur", "Male", null, 2,2);
        

 insert into prescription(prescription_date, diagnosis, weight, bp, patient_id)
 values("2001-12-21", "A year in four-digit format", 80, "80/120", 1),
	   ("2003-04-10", "What is the name of first product", 73, "91/135", 2);
    
    insert into product(product_name, product_manufacturer_name, 
						quantity, duration, frequency, remarks, prescription_id)
		    values ("Dolo", "ABC Company", 30, 5, "2-2-2", "Before lunch", 1),
				   ("MedZ", "Globle Care", 20, 10, "1-1", "After lunch", 2);            
 

-- insert into appointment(patient_name, age, gender, clinic_id)
-- 				 values("ajinkya", 24, "male", 1),("aditya", 27, "male", 1),("punam", 24, "female", 2);

-- insert into appointment_slot(appointment_date, appointment_id)
-- 					values("2022-09-22", 1),
-- 						  ("2022-09-23", 2),
-- 						  ("2022-09-21", 3);
 