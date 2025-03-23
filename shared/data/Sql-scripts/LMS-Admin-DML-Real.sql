CREATE DATABASE LMS;
USE LMS;

SET FOREIGN_KEY_CHECKS=1;

SELECT * FROM admin;
------------------------------------
-- Admin Table Inserts
------------------------------------
INSERT INTO admin (id, first_name, last_name, created_at, last_login, password, phone_number, gender, dob, email, status) VALUES 
('A001', 'Sophal', 'Chann', '2025-03-21 09:00:00', '2025-03-21 09:30:00', 'password123', '012345678', 'male', '1985-04-10', 'sophal.chann@example.com', 'active'),
('A002', 'Dara', 'Srey', '2025-03-21 09:05:00', '2025-03-21 09:45:00', 'password456', '098765432', 'female', '1990-08-15', 'dara.srey@example.com', 'active'),
('A003', 'Chan', 'Raksa', '2025-03-21 09:05:00', '2025-03-21 09:45:00', '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', '098765432', 'female', '1990-08-15', 'me', 'active');

SELECT * FROM department;
------------------------------------
-- Department Table Inserts
------------------------------------
INSERT INTO department (id, name, status) VALUES 
('CS', 'Computer Science', 'active'),
('TN', 'Telecommunication and Networking', 'active'),
('DB', 'Digital Business', 'active');

SELECT * FROM specialization;
------------------------------------
-- Specialization Table Inserts
------------------------------------
INSERT INTO specialization (id, name, department_id, status) VALUES 
('CS-SE', 'Software Engineering', 'CS', 'active'),
('CS-DS', 'Data Science', 'CS', 'active'),
('TN-TN', 'Telecom & Networking', 'TN', 'active'),
('TN-CB', 'Cybersecurity', 'TN', 'active'),
('DB-EC', 'E-Commerce', 'DB', 'active');

SELECT * FROM generation;
------------------------------------
-- Generation Table Inserts
------------------------------------
INSERT INTO generation (id, name, status) VALUES 
('GEN10', 'Generation 10', 'active'),
('GEN11', 'Generation 11', 'active');

SELECT * FROM student_group;
------------------------------------
-- Student Group Table Inserts
------------------------------------
-- For GEN10: two groups (one for CS-SE and one for CS-DS)
INSERT INTO student_group (id, generation_id, specialization_id, status) VALUES 
('GEN10-CS-SE-G1', 'GEN10', 'CS-SE', 'active'),
('GEN10-CS-DS-G1', 'GEN10', 'CS-DS', 'active');

-- For GEN11: two groups (one for TN-TN and one for DB-EC)
INSERT INTO student_group (id, generation_id, specialization_id, status) VALUES 
('GEN11-TN-TN-G1', 'GEN11', 'TN-TN', 'active'),
('GEN11-DB-EC-G1', 'GEN11', 'DB-EC', 'active');

SELECT * FROM teacher;
------------------------------------
-- Teacher Table Inserts
------------------------------------

INSERT INTO teacher (id, first_name, last_name, gender, dob, phone_number, email, status, created_at, last_login, password) VALUES 
('T0001', 'Sokha', 'Phan', 'male', '1980-01-15', '012345601', 'sokha.phan@example.com', 'active', '2025-03-21 08:00:00', '2025-03-21 08:30:00', 'teachpass1'),
('T0002', 'Rithy', 'Chheng', 'male', '1982-05-20', '012345602', 'rithy.chheng@example.com', 'active', '2025-03-21 08:05:00', '2025-03-21 08:35:00', 'teachpass2'),
('T0003', 'Chenda', 'Sok', 'female', '1979-09-10', '012345603', 'chenda.sok@example.com', 'active', '2025-03-21 08:10:00', '2025-03-21 08:40:00', 'teachpass3'),
('T0004', 'Vannak', 'Kim', 'male', '1985-11-25', '012345604', 'vannak.kim@example.com', 'active', '2025-03-21 08:15:00', '2025-03-21 08:45:00', 'teachpass4'),
('T0005', 'Sopheap', 'Chhuon', 'male', '1983-03-30', '012345605', 'sopheap.chhuon@example.com', 'active', '2025-03-21 08:20:00', '2025-03-21 08:50:00', 'teachpass5'),
('T0006', 'Maly', 'Phirum', 'female', '1987-07-05', '012345606', 'maly.phirum@example.com', 'active', '2025-03-21 08:25:00', '2025-03-21 08:55:00', 'teachpass6'),
('T0007', 'Chan', 'Raksa', 'female', '1987-07-05', '012345606', 'me', 'active', '2025-03-21 08:25:00', '2025-03-21 08:55:00', '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0');

------------------------------------
-- Course Table Inserts
------------------------------------
INSERT INTO course (id, name, description, level, credit, status, created_at) VALUES 
('OOP', 'Object Oriented Programming', 'Object Oriented Programming course', 'Intermediate', 3, 'active', NOW()),
('DSA', 'Data Structures', 'Data Structures fundamentals', 'Intermediate', 3, 'active', NOW()),
('DBMS', 'Database Systems', 'Introduction to Databases', 'Intermediate', 3, 'active', NOW()),
('NET', 'Networks', 'Computer Networks course', 'Intermediate', 3, 'active', NOW()),
('CYB', 'Cybersecurity Fundamentals', 'Basics of Cybersecurity', 'Intermediate', 3, 'active', NOW()),
('EBIZ', 'E-Business', 'Digital business strategies', 'Intermediate', 3, 'active', NOW());

SELECT * FROM classroom;
------------------------------------
-- Classroom Table Inserts
------------------------------------
-- For GEN10, using the first 3 courses:
INSERT INTO classroom (id, teacher_id, course_id, group_id, status) VALUES 
('GEN10-CS-SE-G1-OOP', 'T0001', 'OOP', 'GEN10-CS-SE-G1', 'active'),
('GEN10-CS-DS-G1-DSA', 'T0002', 'DSA', 'GEN10-CS-DS-G1', 'active'),
('GEN10-CS-SE-G1-DBMS', 'T0003', 'DBMS', 'GEN10-CS-SE-G1', 'active');

-- For GEN11, using the next 3 courses:
INSERT INTO classroom (id, teacher_id, course_id, group_id, status) VALUES 
('GEN11-TN-TN-G1-NET', 'T0004', 'NET', 'GEN11-TN-TN-G1', 'active'),
('GEN11-DB-EC-G1-CYB', 'T0005', 'CYB', 'GEN11-DB-EC-G1', 'active'),
('GEN11-TN-TN-G1-EBIZ', 'T0006', 'EBIZ', 'GEN11-TN-TN-G1', 'active');

SELECT * FROM student;
------------------------------------
-- Student Table Inserts
------------------------------------
-- For GEN10: 10 students split equally into 2 groups.
-- Group GEN10-CS-SE-G1 (5 students)
-- For GEN10: 10 students split equally into 2 groups.

-- Group GEN10-CS-SE-G1 (5 students)

INSERT INTO student (id, first_name, last_name, gender, dob, phone_number, email, password, commune, district, province, status, created_at, last_login, department_id, specialization_id, generation_id, group_id, guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender) VALUES 
('S000001', 'Sreymuch', 'Chann', 'female', '2004-01-10', '012345001', 'sreymuch.chann@example.com', 'studpass1', 'Boeng Keng Kang', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-SE', 'GEN10', NULL, 'Vanna', 'Chann', '098701001', 'male'),
('S000002', 'Rattanak', 'Sokha', 'male', '2003-03-22', '012345002', 'rattanak.sokha@example.com', 'studpass2', 'Tonle Bassac', 'Chamkar Mon', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-SE', 'GEN10', NULL, 'Sophal', 'Sokha', '098701002', 'male'),
('S000003', 'Piseth', 'Phan', 'male', '2004-06-15', '012345003', 'piseth.phan@example.com', 'studpass3', 'Sen Sok', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-SE', 'GEN10', NULL, 'Rithy', 'Phan', '098701003', 'male'),
('S000004', 'Lina', 'Srey', 'female', '2003-09-05', '012345004', 'lina.srey@example.com', 'studpass4', 'Phsar Daeum Thkov', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-SE', 'GEN10', NULL, 'Dara', 'Srey', '098701004', 'female'),
('S000005', 'Malin', 'Chhuon', 'female', '2004-11-30', '012345005', 'malin.chhuon@example.com', 'studpass5', 'Toul Kork', 'Dangkao', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-SE', 'GEN10', NULL, 'Sokha', 'Chhuon', '098701005', 'female');

-- Group GEN10-CS-DS-G1 (5 students)
INSERT INTO student (id, first_name, last_name, gender, dob, phone_number, email, password, commune, district, province, status, created_at, last_login, department_id, specialization_id, generation_id, group_id, guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender) VALUES 
('S000006', 'Vutha', 'Kim', 'male', '2004-02-14', '012345006', 'vutha.kim@example.com', 'studpass6', 'Chroy Changvar', 'Mean Chey', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-DS', 'GEN10', NULL, 'Phalla', 'Kim', '098701006', 'male'),
('S000007', 'Sreypov', 'Men', 'male', '2003-04-18', '012345007', 'sreypov.men@example.com', 'studpass7', 'Russey Keo', 'Chamkar Mon', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-DS', 'GEN10', NULL, 'Narin', 'Men', '098701007', 'male'),
('S000008', 'Chanrith', 'Vong', 'male', '2004-07-25', '012345008', 'chanrith.vong@example.com', 'studpass8', 'Boeng Keng Kang', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-DS', 'GEN10', NULL, 'Sreypov', 'Vong', '098701008', 'male'),
('S000009', 'Davy', 'Sok', 'male', '2003-10-12', '012345009', 'davy.sok@example.com', 'studpass9', 'Phsar Thmei', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-DS', 'GEN10', NULL, 'Malin', 'Sok', '098701009', 'male'),
('S000010', 'Rachana', 'Chann', 'female', '2004-12-01', '012345010', 'rachana.chann@example.com', 'studpass10', 'Toul Svay Prey', 'Chroy Changvar', 'Phnom Penh', 'active', NOW(), NULL, 'CS', 'CS-DS', 'GEN10', NULL, 'Vutha', 'Chann', '098701010', 'female');

-- For GEN11: 10 students split equally into 2 groups.
-- Group GEN11-TN-TN-G1 (5 students)
INSERT INTO student (id, first_name, last_name, gender, dob, phone_number, email, password, commune, district, province, status, created_at, last_login, department_id, specialization_id, generation_id, group_id, guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender) VALUES 
('S000011', 'Bora', 'Chheng', 'male', '2004-03-11', '012345011', 'bora.chheng@example.com', 'studpass11', 'Boeng Keng Kang', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'TN', 'TN-TN', 'GEN11', NULL, 'Sokha', 'Chheng', '098701011', 'male'),
('S000012', 'Dara', 'Phirun', 'female', '2003-05-16', '012345012', 'dara.phirun@example.com', 'studpass12', 'Tonle Bassac', 'Chamkar Mon', 'Phnom Penh', 'active', NOW(), NULL, 'TN', 'TN-TN', 'GEN11', NULL, 'Rattanak', 'Phirun', '098701012', 'female'),
('S000013', 'Sovann', 'Kim', 'male', '2004-08-21', '012345013', 'sovann.kim@example.com', 'studpass13', 'Sen Sok', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'TN', 'TN-TN', 'GEN11', NULL, 'Piseth', 'Kim', '098701013', 'male'),
('S000014', 'Malis', 'Chann', 'female', '2003-11-30', '012345014', 'malis.chann@example.com', 'studpass14', 'Phsar Daeum Thkov', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'TN', 'TN-TN', 'GEN11', NULL, 'Lina', 'Chann', '098701014', 'female'),
('S000015', 'Kosal', 'Sok', 'male', '2004-01-28', '012345015', 'kosal.sok@example.com', 'studpass15', 'Toul Kork', 'Dangkao', 'Phnom Penh', 'active', NOW(), NULL, 'TN', 'TN-TN', 'GEN11', NULL, 'Davy', 'Sok', '098701015', 'male');

-- Group GEN11-DB-EC-G1 (5 students)
INSERT INTO student (id, first_name, last_name, gender, dob, phone_number, email, password, commune, district, province, status, created_at, last_login, department_id, specialization_id, generation_id, group_id, guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender) VALUES 
('S000016', 'Sovath', 'Phan', 'male', '2004-04-17', '012345016', 'sovath.phan@example.com', 'studpass16', 'Chroy Changvar', 'Mean Chey', 'Phnom Penh', 'active', NOW(), NULL, 'DB', 'DB-EC', 'GEN11', NULL, 'Vutha', 'Phan', '098701016', 'male'),
('S000017', 'Sreyleak', 'Men', 'female', '2003-06-20', '012345017', 'sreyleak.men@example.com', 'studpass17', 'Russey Keo', 'Chamkar Mon', 'Phnom Penh', 'active', NOW(), NULL, 'DB', 'DB-EC', 'GEN11', NULL, 'Sreypov', 'Men', '098701017', 'female'),
('S000018', 'Vannak', 'Vong', 'male', '2004-09-15', '012345018', 'vannak.vong@example.com', 'studpass18', 'Boeng Keng Kang', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'DB', 'DB-EC', 'GEN11', NULL, 'Chanrith', 'Vong', '098701018', 'male'),
('S000019', 'Sophal', 'Sok', 'male', '2003-12-22', '012345019', 'sophal.sok@example.com', 'studpass19', 'Phsar Thmei', 'Daun Penh', 'Phnom Penh', 'active', NOW(), NULL, 'DB', 'DB-EC', 'GEN11', NULL, 'Davy', 'Sok', '098701019', 'male'),
('S000020', 'Rachana', 'Chhuon', 'female', '2004-02-02', '012345020', 'rachana.chhuon@example.com', 'studpass20', 'Toul Svay Prey', 'Chroy Changvar', 'Phnom Penh', 'active', NOW(), NULL, 'DB', 'DB-EC', 'GEN11', NULL, 'Rachana', 'Chhuon', '098701020', 'female');

------------------------------------
-- Progress Table Inserts
------------------------------------
-- We'll create progress records linking each student to the classroom(s) that match their group.
-- For GEN10:
--   Group GEN10-CS-SE-G1 is assigned to two classrooms: 'GEN10-CS-SE-G1-OOP' and 'GEN10-CS-SE-G1-DB'
--   Group GEN10-CS-DS-G1 is assigned to one classroom: 'GEN10-CS-DS-G1-DS'
-- For GEN11:
--   Group GEN11-TN-TN-G1 is assigned to two classrooms: 'GEN11-TN-TN-G1-NET' and 'GEN11-TN-TN-G1-EB'
--   Group GEN11-DB-EC-G1 is assigned to one classroom: 'GEN11-DB-EC-G1-CYB'

SELECT * FROM progress;
------------------------------------
-- Progress Table Inserts
------------------------------------
-- For GEN10 - Group GEN10-CS-SE-G1 (students A000001 to A000005)

INSERT INTO progress (id, student_id, classroom_id) VALUES 
('P0001', 'S000001', 'GEN10-CS-SE-G1-OOP'),
('P0002', 'S000001', 'GEN10-CS-SE-G1-DBMS'),
('P0003', 'S000002', 'GEN10-CS-SE-G1-OOP'),
('P0004', 'S000002', 'GEN10-CS-SE-G1-DBMS'),
('P0005', 'S000003', 'GEN10-CS-SE-G1-OOP'),
('P0006', 'S000003', 'GEN10-CS-SE-G1-DBMS'),
('P0007', 'S000004', 'GEN10-CS-SE-G1-OOP'),
('P0008', 'S000004', 'GEN10-CS-SE-G1-DBMS'),
('P0009', 'S000005', 'GEN10-CS-SE-G1-OOP'),
('P0010', 'S000005', 'GEN10-CS-SE-G1-DBMS');

-- For GEN10 - Group GEN10-CS-DS-G1 (students A000006 to A000010)
INSERT INTO progress (id, student_id, classroom_id) VALUES 
('P0011', 'S000006', 'GEN10-CS-DS-G1-DSA'),
('P0012', 'S000007', 'GEN10-CS-DS-G1-DSA'),
('P0013', 'S000008', 'GEN10-CS-DS-G1-DSA'),
('P0014', 'S000009', 'GEN10-CS-DS-G1-DSA'),
('P0015', 'S000010', 'GEN10-CS-DS-G1-DSA');

-- For GEN11 - Group GEN11-TN-TN-G1 (students A000011 to A000015)
INSERT INTO progress (id, student_id, classroom_id) VALUES 
('P0016', 'S000011', 'GEN11-TN-TN-G1-NET'),
('P0017', 'S000011', 'GEN11-TN-TN-G1-EBIZ'),
('P0018', 'S000012', 'GEN11-TN-TN-G1-NET'),
('P0019', 'S000012', 'GEN11-TN-TN-G1-EBIZ'),
('P0020', 'S000013', 'GEN11-TN-TN-G1-NET'),
('P0021', 'S000013', 'GEN11-TN-TN-G1-EBIZ'),
('P0022', 'S000014', 'GEN11-TN-TN-G1-NET'),
('P0023', 'S000014', 'GEN11-TN-TN-G1-EBIZ'),
('P0024', 'S000015', 'GEN11-TN-TN-G1-NET'),
('P0025', 'S000015', 'GEN11-TN-TN-G1-EBIZ');

-- For GEN11 - Group GEN11-DB-EC-G1 (students A000016 to A000020)
INSERT INTO progress (id, student_id, classroom_id) VALUES 
('P0026', 'S000016', 'GEN11-DB-EC-G1-CYB'),
('P0027', 'S000017', 'GEN11-DB-EC-G1-CYB'),
('P0028', 'S000018', 'GEN11-DB-EC-G1-CYB'),
('P0029', 'S000019', 'GEN11-DB-EC-G1-CYB'),
('P0030', 'S000020', 'GEN11-DB-EC-G1-CYB');


