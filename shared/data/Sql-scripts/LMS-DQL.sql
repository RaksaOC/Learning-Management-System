SELECT * FROM admin;
SELECT * FROM student;
SELECT * FROM teacher;
SELECT * FROM teacher_history;
SELECT * FROM student_history;
SELECT * FROM progress;
SELECT * FROM progress_assignment;
SELECT * FROM progress_material;
SELECT * FROM progress_quiz;
SELECT * FROM course;
SELECT * FROM department;
SELECT * FROM specialization;
SELECT * FROM generation;
SELECT * FROM student_group;
SELECT * FROM classroom;
SELECT * FROM assignment;
SELECT * FROM material;
SELECT * FROM quiz;
SELECT * FROM question;
SELECT * FROM choice;
SELECT * FROM classroom_assignment;
SELECT * FROM classroom_quiz;
SELECT * FROM classroom_material;
SELECT * FROM administrative;

-- ================================================
-- Viewing Data
-- ================================================

-- -------------------------
-- Student's Data
-- -------------------------

-- Viewing student's enrolled classrooms (classroom_id + course_name)

SELECT CONCAT(p.classroom_id, ' - ', c.name)
FROM progress p
JOIN classroom cl
ON cl.id = p.classroom_id
JOIN course c
ON cl.course_id = c.id
WHERE p.student_id = 'student_id';

-- Viewing student's assignments in a classroom

SELECT CONCAT(a.id, ' - ', a.title) AS id_name
FROM progress_assignment pa
JOIN progress p
ON pa.progress_id = p.id
JOIN assignment a
ON pa.assignment_id = a.id
WHERE p.classroom_id = 'classroom_id' AND p.student_id = 'student_id';

-- Viewing student's materials in a classroom

SELECT CONCAT(m.id, ' - ', m.title) AS id_name
FROM progress_material pm
JOIN progress p
ON pm.progress_id = p.id
JOIN material m
ON pm.material_id = m.id
WHERE p.classroom_id = 'classroom_id' AND p.student_id = 'student_id';

-- Viewing student's quizzes in a classroom

SELECT CONCAT(q.id, ' - ', q.title) AS id_name
FROM progress_quiz pq
JOIN progress p
ON pq.progress_id = p.id
JOIN quiz q
ON pq.quiz_id = q.id
WHERE p.classroom_id = 'classroom_id' AND p.student_id = 'student_id';

-- Viewing all student's assignments

SELECT CONCAT(a.id, ' - ', a.title) AS id_name, p.classroom_id AS class_id
FROM progress_assignment pa
JOIN progress p
ON pa.progress_id = p.id
JOIN assignment a
ON pa.assignment_id = a.id
WHERE p.student_id = 'student_id';

-- Viewing all student's materials

SELECT CONCAT(m.id, ' - ', m.title) AS id_name, p.classroom_id AS class_id
FROM progress_material pm
JOIN progress p
ON pm.progress_id = p.id
JOIN material m
ON pm.material_id = m.id
WHERE p.student_id = 'student_id';

-- Viewing all student's quizzes

SELECT CONCAT(q.id, ' - ', q.title) AS id_name, p.classroom_id AS class_id
FROM progress_quiz pq
JOIN progress p
ON pq.progress_id = p.id
JOIN quiz q
ON pq.quiz_id = q.id
WHERE p.student_id = 'student_id';

-- -------------------------
-- Teacher's Data
-- -------------------------

-- Viewing all teacher's assigned classrooms

SELECT id FROM classroom WHERE teacher_id = 'teacher_id';

-- Viewing teacher's assignments in a classroom

SELECT CONCAT(a.id, ' - ', a.title) AS id_name
FROM progress_assignment AS pa
JOIN progress AS p 
ON pa.progress_id = p.id
JOIN assignment AS a 
ON pa.assignment_id = a.id
JOIN classroom AS c 
ON p.classroom_id = c.id
WHERE p.classroom_id = 'classroom_id' AND c.teacher_id = 'teacher_id';

-- Viewing teacher's materials in a classroom

SELECT CONCAT(m.id, ' - ', m.title) AS id_name
FROM progress_material AS pm
JOIN progress AS p 
ON pm.progress_id = p.id
JOIN material AS m 
ON pm.material_id = m.id
JOIN classroom AS c 
ON p.classroom_id = c.id
WHERE p.classroom_id = 'class_id' AND c.teacher_id = 'teacher_id';

-- Viewing teacher's quizzes in a classroom

SELECT CONCAT(q.id, ' - ', q.title) AS id_name
FROM progress_quiz AS pq
JOIN progress AS p 
ON pq.progress_id = p.id
JOIN quiz AS q 
ON pq.quiz_id = q.id
JOIN classroom AS c 
ON p.classroom_id = c.id
WHERE p.classroom_id = 'class_id' AND c.teacher_id = 'teacher_id';

-- ================================================
-- Getting Counts
-- ================================================

-- -------------------------
-- Student's Data
-- -------------------------

-- Get number of classrooms/courses completed by the student

SELECT COUNT(*)  
FROM progress p
JOIN classroom c
ON p.classroom_id = c.id
WHERE p.student_id = 'student_id' AND c.status = 'inactive';

-- Get number of assignments completed by the student

SELECT COUNT(*)  
FROM assignment a
JOIN progress_assignment pa
ON a.id = pa.assignment_id AND pa.status = 'inactive'
JOIN progress p
ON pa.progress_id = p.id
WHERE p.student_id = 'student_id';

-- Get number of quizzes completed by the student

SELECT COUNT(*)  
FROM quiz a
JOIN progress_quiz pq
ON a.id = pq.quiz_id AND pq.status = 'inactive'
JOIN progress p
ON pq.progress_id = p.id
WHERE p.student_id = 'sample_student_id';

-- Get number of students

SELECT COUNT(*) FROM students;

-- -------------------------
-- Teacher's Data
-- -------------------------

-- Get number of assignments created by the teacher

SELECT COUNT(*)  
FROM classroom_assignment ca
JOIN classroom c
ON ca.class_id = c.id
WHERE c.teacher_id = 'sample_teacher_id';

-- Get number of quizzes created by the teacher

SELECT COUNT(*) 
FROM classroom_quiz cq
JOIN classroom c
ON cq.class_id = c.id
WHERE c.teacher_id = 'sample_teacher_id';

-- Get number of classrooms the teacher is teaching

SELECT COUNT(*) 
FROM classroom
WHERE teacher_id = 'teacher_id';

-- Get number of assignments graded by the teacher

SELECT COUNT(*) 
FROM progress_assignment pa
JOIN progress p
ON pa.progress_id = p.id
JOIN classroom c
ON p.classroom_id = c.id
JOIN teacher t
ON c.teacher_id = t.id
WHERE pa.status = 'inactive' AND c.teacher_id = 'sample_teacher_id';

-- Get number of teachers

SELECT COUNT(*) FROM teacher;









