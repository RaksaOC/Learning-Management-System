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
