-- View to get the student's completed classrooms/courses
CREATE VIEW student_completed_classrooms AS
SELECT CONCAT(p.classroom_id, ' - ', c.name) AS classroom_name
FROM progress p
         JOIN classroom cl
              ON cl.id = p.classroom_id
         JOIN course c
              ON cl.course_id = c.id
WHERE p.student_id = 'student_id';

-- View to view student's assignments in a classroom
CREATE VIEW student_assignments_in_classroom AS
SELECT CONCAT(a.id, ' - ', a.title) AS assignment_id_name
FROM progress_assignment pa
         JOIN progress p
              ON pa.progress_id = p.id
         JOIN assignment a
              ON pa.assignment_id = a.id
WHERE p.classroom_id = 'classroom_id' AND p.student_id = 'student_id';

-- View to view student's materials in a classroom
CREATE VIEW student_materials_in_classroom AS
SELECT CONCAT(m.id, ' - ', m.title) AS material_id_name
FROM progress_material pm
         JOIN progress p
              ON pm.progress_id = p.id
         JOIN material m
              ON pm.material_id = m.id
WHERE p.classroom_id = 'classroom_id' AND p.student_id = 'student_id';

-- View to view student's quizzes in a classroom
CREATE VIEW student_quizzes_in_classroom AS
SELECT CONCAT(q.id, ' - ', q.title) AS quiz_id_name
FROM progress_quiz pq
         JOIN progress p
              ON pq.progress_id = p.id
         JOIN quiz q
              ON pq.quiz_id = q.id
WHERE p.classroom_id = 'classroom_id' AND p.student_id = 'student_id';

-- View to get all assignments of a student
CREATE VIEW student_all_assignments AS
SELECT CONCAT(a.id, ' - ', a.title) AS assignment_id_name, p.classroom_id AS class_id
FROM progress_assignment pa
         JOIN progress p
              ON pa.progress_id = p.id
         JOIN assignment a
              ON pa.assignment_id = a.id
WHERE p.student_id = 'student_id';

-- View to get all materials of a student
CREATE VIEW student_all_materials AS
SELECT CONCAT(m.id, ' - ', m.title) AS material_id_name, p.classroom_id AS class_id
FROM progress_material pm
         JOIN progress p
              ON pm.progress_id = p.id
         JOIN material m
              ON pm.material_id = m.id
WHERE p.student_id = 'student_id';

-- View to get all quizzes of a student
CREATE VIEW student_all_quizzes AS
SELECT CONCAT(q.id, ' - ', q.title) AS quiz_id_name, p.classroom_id AS class_id
FROM progress_quiz pq
         JOIN progress p
              ON pq.progress_id = p.id
         JOIN quiz q
              ON pq.quiz_id = q.id
WHERE p.student_id = 'student_id';

-- -------------------------
-- Teacher's Data
-- -------------------------

-- View to get all classrooms assigned to a teacher
CREATE VIEW teacher_assigned_classrooms AS
SELECT id
FROM classroom
WHERE teacher_id = 'teacher_id';

-- View to view teacher's assignments in a classroom
CREATE VIEW teacher_assignments_in_classroom AS
SELECT CONCAT(a.id, ' - ', a.title) AS assignment_id_name
FROM progress_assignment AS pa
         JOIN progress AS p
              ON pa.progress_id = p.id
         JOIN assignment AS a
              ON pa.assignment_id = a.id
         JOIN classroom AS c
              ON p.classroom_id = c.id
WHERE p.classroom_id = 'classroom_id' AND c.teacher_id = 'teacher_id';

-- View to view teacher's materials in a classroom
CREATE VIEW teacher_materials_in_classroom AS
SELECT CONCAT(m.id, ' - ', m.title) AS material_id_name
FROM progress_material AS pm
         JOIN progress AS p
              ON pm.progress_id = p.id
         JOIN material AS m
              ON pm.material_id = m.id
         JOIN classroom AS c
              ON p.classroom_id = c.id
WHERE p.classroom_id = 'class_id' AND c.teacher_id = 'teacher_id';

-- View to view teacher's quizzes in a classroom
CREATE VIEW teacher_quizzes_in_classroom AS
SELECT CONCAT(q.id, ' - ', q.title) AS quiz_id_name
FROM progress_quiz AS pq
         JOIN progress AS p
              ON pq.progress_id = p.id
         JOIN quiz AS q
              ON pq.quiz_id = q.id
         JOIN classroom AS c
              ON p.classroom_id = c.id
WHERE p.classroom_id = 'class_id' AND c.teacher_id = 'teacher_id';

-- -------------------------
-- Classroom
-- -------------------------

CREATE VIEW view_all_classrooms AS
SELECT id, teacher_id, course_id, group_id, status
FROM classroom;

-- -------------------------
-- Course
-- -------------------------

CREATE VIEW view_all_courses AS
SELECT id, name, credit, level, description, status
FROM course;

-- -------------------------
-- Department
-- -------------------------

CREATE VIEW view_all_departments AS
SELECT id, name, status
FROM department;

-- -------------------------
-- Generation
-- -------------------------

CREATE VIEW view_all_generations AS
SELECT id, name, status
FROM generation;

-- -------------------------
-- Student Group
-- -------------------------

CREATE VIEW view_all_student_groups AS
SELECT id, generation_id, specialization_id, status
FROM student_group;

-- -------------------------
-- Specialization
-- -------------------------

CREATE VIEW view_all_specializations AS
SELECT id, department_id, name, status
FROM specialization;

-- -------------------------
-- Student
-- -------------------------

CREATE VIEW view_all_students AS
SELECT id, first_name, last_name, gender, dob, phone_number, email, password,
       commune, district, province, status, created_at, last_login,
       department_id, specialization_id, generation_id,
       guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender
FROM student;

-- -------------------------
-- Teacher
-- -------------------------

CREATE VIEW view_all_teachers AS
SELECT id, first_name, last_name, gender, dob, phone_number, email,
       status, created_at, last_login
FROM teacher;

-- -------------------------
-- Admin IDs and Names
-- -------------------------

CREATE VIEW view_admin_ids_and_names AS
SELECT id, CONCAT(first_name, ' ', last_name) AS name
FROM admin
ORDER BY name;

-- -------------------------
-- Classroom IDs View
-- -------------------------

CREATE VIEW view_classroom_id AS
SELECT id
FROM classroom
ORDER BY id;

-- -------------------------
-- Course IDs and Names View
-- -------------------------

CREATE VIEW view_course_ids_and_names AS
SELECT id, name
FROM course
ORDER BY name;

-- -------------------------
-- Department IDs and Names View
-- -------------------------

CREATE VIEW view_department_ids_and_names AS
SELECT id, name
FROM department
ORDER BY name;

-- -------------------------
-- Generation IDs and Names View
-- -------------------------

CREATE VIEW view_generation_ids_and_names AS
SELECT id, name
FROM generation
ORDER BY name;

-- -------------------------
-- Student Group IDs View
-- -------------------------

CREATE VIEW view_student_group_ids AS
SELECT id
FROM student_group;

-- -------------------------
-- Specialization ID and Name View
-- -------------------------

CREATE VIEW view_specialization_ids_and_names AS
SELECT id, name
FROM specialization;

-- -------------------------
-- Student ID and Name View
-- -------------------------

CREATE VIEW view_student_ids_and_names AS
SELECT id, CONCAT(first_name, ' ', last_name) as name
FROM student;

-- -------------------------
-- Teacher ID and Name View
-- -------------------------

CREATE VIEW view_teacher_ids_and_names AS
SELECT id, CONCAT(first_name, ' ', last_name) as name
FROM teacher;

-- -------------------------
-- Student History View
-- -------------------------

CREATE VIEW view_student_history AS
SELECT student_id AS id, time, last_action
FROM student_history
ORDER BY time;

-- -------------------------
-- Teacher History View
-- -------------------------

CREATE VIEW view_teacher_history AS
SELECT teacher_id AS id, time, last_action
FROM teacher_history
ORDER BY time;

-- -------------------------
-- Active Classrooms View
-- -------------------------

CREATE VIEW view_active_classrooms AS
SELECT id, teacher_id, course_id, group_id
FROM classroom
WHERE status = 'active'
ORDER BY id;




-- Calling views for student data
SELECT * FROM student_completed_classrooms;
SELECT * FROM student_assignments_in_classroom;
SELECT * FROM student_materials_in_classroom;
SELECT * FROM student_quizzes_in_classroom;
SELECT * FROM student_all_assignments;
SELECT * FROM student_all_materials;
SELECT * FROM student_all_quizzes;

-- Calling views for teacher data
SELECT * FROM teacher_assigned_classrooms;
SELECT * FROM teacher_assignments_in_classroom;
SELECT * FROM teacher_materials_in_classroom;
SELECT * FROM teacher_quizzes_in_classroom;

-- for only necessary data
SELECT * FROM view_all_classrooms;
SELECT * FROM view_all_courses;
SELECT * FROM view_all_departments;
SELECT * FROM view_all_generations;
SELECT * FROM view_all_specializations;
SELECT * FROM view_all_student_groups;
SELECT * FROM view_all_students;
SELECT * FROM view_all_teachers;

-- Viewing ids with names
SELECT * FROM view_admin_ids_and_names;
SELECT * FROM view_classroom_id;
SELECT * FROM view_course_ids_and_names;
SELECT * FROM view_department_ids_and_names;
SELECT * FROM view_generation_ids_and_names;
SELECT * FROM view_student_group_ids;
SELECT * FROM view_specialization_ids_and_names;
SELECT * FROM view_student_ids_and_names;
SELECT * FROM view_teacher_ids_and_names;

SELECT * FROM view_student_history;
SELECT * FROM view_teacher_history;
SELECT * FROM view_active_classrooms;


