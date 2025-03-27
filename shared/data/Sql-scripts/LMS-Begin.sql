USE LMS2;

-- FIRST USER EVER

INSERT INTO admin (id, first_name, last_name, created_at, last_login, password, phone_number, gender, dob, email, status) VALUES 
('A001', 'Chanraksa', 'Ory', '2025-03-21 09:00:00', '2025-03-21 09:30:00', '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', '012554049', 'male', '2006-03-04', 'me', 'active');

select * from quiz;
select * from question;
select * from choice;
select * from progress_quiz;
select * from classroom_quiz;

