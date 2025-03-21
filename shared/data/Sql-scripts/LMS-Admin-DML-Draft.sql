USE LMS;

-- ========================================
-- ========== Manage Admin Actions ========
-- ========================================

select * from admin;
select * from student;
select * from teacher;
select * from course;
select * from specialization;

-- 🟢 Add  

INSERT INTO admin (
    id, first_name, last_name, created_at, last_login, password, 
    phone_number, gender, dob, email, status
) VALUES (
    "admin_id", "First", "Last", "2025-03-14 00:18:55", NULL, "hashed_pass", 
    "012345678", "Male", "2000-01-01", "email@example.com", "active"
);

-- 🟡 Edit  

-- Edit name  
UPDATE admin 
SET first_name = "NewFirst", last_name = "NewLast" 
WHERE id = "admin_id";

-- Edit phone  
UPDATE admin 
SET phone_number = "098765432" 
WHERE id = "admin_id";

-- Edit email  
UPDATE admin 
SET email = "new_email@example.com" 
WHERE id = "admin_id";

-- ...

-- 🔴 Delete  
UPDATE admin 
SET status = "inactive" 
WHERE id = "admin_id";

-- 🟣 View  
SELECT * FROM admin;  
SELECT * FROM admin WHERE status = "active";  
SELECT * FROM admin WHERE status = "inactive";  
SELECT * FROM admin WHERE id = "admin_id";
SELECT * FROM admin WHERE id = "admin_id" and status = "active";
SELECT * FROM admin WHERE id = "admin_id" and status = "inactive";

-- ========================================
-- ========== Manage Student Actions ======
-- ========================================

-- 🟢 Add  

INSERT INTO student (
    id, first_name, last_name, gender, dob, phone_number, 
    email, password, commune, district, province, status, created_at, last_login, department_id, 
    specialization_id, generation_id, group_id, guardian_first_name, 
    guardian_last_name, guardian_phone_number, guardian_gender
) VALUES (
    "student_id", "First", "Last", "Male", "2003-01-01", "012345678", 
    "email@example.com", "hashed_pass", "a", "b", "c", "active", "2025-03-14 00:18:55", NULL, "dep_id", 
    "spe_id", "gen_id", NULL, "GuardianFirst", 
    "GuardianLast", "098765432", "Male"
);

-- 🟡 Edit  

-- Edit name  

UPDATE student 
SET first_name = "NewFirst", last_name = "NewLast" 
WHERE id = "student_id";

-- Edit phone  
UPDATE student 
SET phone_number = "098765432" 
WHERE id = "student_id";

-- Edit email  
UPDATE student 
SET email = "new_email@example.com" 
WHERE id = "student_id";

-- Edit guardian name  
UPDATE student 
SET guardian_first_name = "NewGuardianFirst", guardian_last_name = "NewGuardianLast" 
WHERE id = "student_id";

-- Edit guardian phone  
UPDATE student 
SET guardian_phone_number = "087654321" 
WHERE id = "student_id";

-- ...

-- 🔴 Delete  

UPDATE student 
SET status = "inactive" 
WHERE id = "student_id";

-- 🟣 View  

SELECT * FROM student;  
SELECT * FROM student WHERE status = "active";  
SELECT * FROM student WHERE status = "inactive";  
SELECT * FROM student WHERE id = "S0001" and status = "active";
SELECT * FROM student WHERE id = "S0001" and status = "inactive";

-- ========================================
-- ======= Manage Teacher Actions =========
-- ========================================

-- 🟢 Add  

INSERT INTO teacher (
    id, first_name, last_name, gender, dob, phone_number, 
    email, status, created_at, last_login, password
) VALUES (
    "teacher_id", "first", "last", "Male", "1985-09-10", "015678432", 
    "example@university.edu", "active", "2025-03-14 00:18:55", NULL, "hashed_pass"
);

-- 🟡 Edit  

-- Edit name  

UPDATE teacher 
SET first_name = "NewFirst", last_name = "NewLast" 
WHERE id = "teacher_id";

-- ...

-- 🔴 Delete  

UPDATE teacher 
SET status = "inactive" 
WHERE id = "teacher_id";

-- 🟣 View  

SELECT * FROM teacher;  
SELECT * FROM teacher WHERE status = "active";  
SELECT * FROM teacher WHERE status = "inactive"; 
SELECT * FROM teacher WHERE id = "teacher_id";
SELECT * FROM teacher WHERE id = "teacher_id" and status = "active";
SELECT * FROM teacher WHERE id = "teacher_id" and status = "inactive";

-- ========================================
-- ====== Manage Department Actions =======
-- ========================================

-- 🟢 Add  

INSERT INTO department (id, name, status)
VALUES ("dep_id", "dep_name", "active");

-- 🟡 Edit  

-- Edit id  

UPDATE department
SET id = "new_id" 
WHERE id = "dep_id";

-- Edit Name

UPDATE department
SET name = "new_name" 
WHERE id = "dep_id";

-- 🔴 Delete  

UPDATE department
SET status = "inactive" 
WHERE id = "dep_id";

-- 🟣 View  

SELECT * from department;
SELECT * from department where status = "active";
SELECT * from department where status = "inactive";
SELECT * from department where id = "dep_id";
SELECT * from department where id = "dep_id" and status = "active";
SELECT * from department where id = "dep_id" and status = "inactive";


-- ========================================
-- ==== Manage Specialization Actions =====
-- ========================================

-- 🟢 Add  

INSERT INTO specialization (id, name, department_id, status)
VALUES ("spe_id", "spe_name", "dep_id", "active");

-- 🟡 Edit  

-- Edit id 

UPDATE specialization
SET id = "new_id" 
WHERE id = "spe_id";

-- Edit Name

UPDATE specialization
SET name = "new_name" 
WHERE id = "spe_id";

-- 🔴 Delete  

UPDATE specialization
SET status = "inactive" 
WHERE id = "spe_id";

-- ========================================
-- ====== Manage Group Actions ============
-- ========================================

-- 🟢 Add  

INSERT INTO student_group (id, generation_id, specialization_id, status)
VALUES ("group_id", "gen_id", "spe_id", "active");

-- 🟡 Edit  

-- Edit id

UPDATE student_group
SET id = "new_id" 
WHERE id = "group_id";

-- Edit Name

UPDATE student_group
SET name = "new_name" 
WHERE id = "group_id";

-- 🔴 Delete  

UPDATE student_group
SET status = "inactive" 
WHERE id = "group_id";

-- 🟣 View 

SELECT * from specialization;
SELECT * FROM specilization where status = "active";
SELECT * FROM specilization where status = "inactive";
SELECT * FROM specilization where id = "spe_id";
SELECT * FROM specilization where id = "spe_id" and status = "active";
SELECT * FROM specilization where id = "spe_id" and status = "inactive";

-- 🟤 Others

-- Add student to group

UPDATE student
SET group_id = "group_id"
WHERE id = "student_id";

-- ========================================
-- ====== Manage Generation Actions =======
-- ========================================

-- 🟢 Add  

INSERT INTO generation (id, name, status)
VALUES ("gen_id", "gen_name", "active");

-- 🟡 Edit  

-- Edit id  

UPDATE generation
SET id = "new_id" 
WHERE id = "gen_id";

-- Edit Name

UPDATE generation
SET name = "new_name" 
WHERE id = "gen_id";

-- 🔴 Delete  

UPDATE generation
SET status = "inactive" 
WHERE id = "gen_id";

-- 🟣 View 

SELECT * from generation;
SELECT * FROM generation where status = "active";
SELECT * FROM generation where status = "inactive";
SELECT * FROM generation where id = "gen_id";
SELECT * FROM generation where id = "gen_id" and status = "active";
SELECT * FROM generation where id = "gen_id" and status = "inactive";

-- ========================================
-- ======== Manage Course Actions =========
-- ========================================

-- 🟢 Add  

INSERT INTO course (id, name, description, level, credit, status)
VALUES ("VA", "Visual Art", "blah blah blah", "Undergraduate", "5", "active");

-- 🟡 Edit  

-- Edit id  

UPDATE course
SET id = "new_id" 
WHERE id = "VA";

-- Edit Name

UPDATE course
SET name = "new_name" 
WHERE id = "VA";

-- Edit description

UPDATE course
SET description = "new_desc" 
WHERE id = "VA";

-- Edit level

UPDATE course
SET level = "new_level" 
WHERE id = "VA";

-- Edit Credit

UPDATE course
SET credit = "new_credit" 
WHERE id = "VA";

-- 🔴 Delete  

UPDATE course
SET status = "inactive" 
WHERE id = "VA";

-- 🟣 View 

SELECT * from course;
SELECT * FROM course where status = "active";
SELECT * FROM course where status = "inactive";
SELECT * FROM course where id = "course_id";
SELECT * FROM course where id = "course_id" and status = "active";
SELECT * FROM course where id = "course_id" and status = "inactive";


-- ========================================
-- ======== Manage Classroom Actions ======
-- ========================================

-- 🟢 Add  

-- create the base classroom
INSERT INTO classroom (id, teacher_id, course_id, group_id, status)
VALUES ("class_id", NULL, NULL, "group_id", "active");

-- add all students from the group to the class
INSERT INTO classroom_student (class_id, student_id) 
VALUES("class_id", (SELECT id from student where group_id = "group_id"));

-- create progresses for all the students (maybe use loop in code)
INSERT INTO progress (id, student_id, class_id)
VALUES ("id", "student_id", "class_id");

-- TODO: Add other fields like score, feedback ................|
-- 															   |
-- create relation of progress_assignment					   |
INSERT INTO progress_assignment(progress_id, assignment_id) -- |
VALUES("progress_id", "assignment_id");
-- 															   |
-- create relation of progress_material                        |
INSERT INTO progress_material(progress_id, material_id)
VALUES("progress_id", "material_id");
-- 															   |
-- create relation of progress_quiz 						   |
INSERT INTO progress_quiz(progress_id, quiz_id)
VALUES("progress_id", "quiz_id");
-- 															   |
-- ------------------------------------------------------------|

-- 🟡 Edit

-- Edit id

UPDATE classroom
SET id = "new_id"
WHERE id = "class_id";

-- Edit Name

UPDATE course
SET name = "new_name" 
WHERE id = "class_id";

-- 🔴 Delete  

UPDATE classroom
SET status = "inactive" 
WHERE id = "class_id";

-- 🟣 View 

SELECT * from classroom;
SELECT * FROM classroom where status = "active";
SELECT * FROM classroom where status = "inactive";
SELECT * FROM classroom where id = "class_id";
SELECT * FROM classroom where id = "class_id" and status = "active";
SELECT * FROM classroom where id = "class_id" and status = "inactive";

-- 🟤 Others

-- Add teacher to classroom

UPDATE classroom 
SET teacher_id = "teacher_id"
where id = "class_id";

-- Add course to classroom

UPDATE classroom 
SET course_id = "course_id"
where id = "class_id"

