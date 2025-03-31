-- Function to get the number of classrooms/courses completed by a student
CREATE FUNCTION getCompletedClassrooms(student_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE completed_classrooms INT;

    -- Count the number of classrooms that the student has completed (inactive status)
    SELECT COUNT(*)
    INTO completed_classrooms
    FROM progress p
             JOIN classroom c ON p.classroom_id = c.id
    WHERE p.student_id = student_id AND c.status = 'inactive';

    RETURN completed_classrooms;
END;

-- Function to get the number of assignments completed by a student
CREATE FUNCTION getCompletedAssignments(student_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE completed_assignments INT;

    -- Count the number of assignments that the student has completed (inactive status)
    SELECT COUNT(*)
    INTO completed_assignments
    FROM assignment a
             JOIN progress_assignment pa ON a.id = pa.assignment_id AND pa.status = 'inactive'
             JOIN progress p ON pa.progress_id = p.id
    WHERE p.student_id = student_id;

    RETURN completed_assignments;
END;

-- Function to get the number of quizzes completed by a student
CREATE FUNCTION getCompletedQuizzes(student_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE completed_quizzes INT;

    -- Count the number of quizzes that the student has completed (inactive status)
    SELECT COUNT(*)
    INTO completed_quizzes
    FROM quiz a
             JOIN progress_quiz pq ON a.id = pq.quiz_id AND pq.status = 'inactive'
             JOIN progress p ON pq.progress_id = p.id
    WHERE p.student_id = student_id;

    RETURN completed_quizzes;
END;

-- Function to get the total number of students in the system
CREATE FUNCTION getTotalStudents()
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE student_count INT;

    -- Count the total number of students
    SELECT COUNT(*)
    INTO student_count
    FROM student;

    RETURN student_count;
END;

-- Function to get the number of assignments created by a specific teacher
CREATE FUNCTION getAssignmentsCreatedByTeacher(teacher_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE created_assignments INT;

    -- Count the number of assignments created by the teacher
    SELECT COUNT(*)
    INTO created_assignments
    FROM classroom_assignment ca
             JOIN classroom c ON ca.class_id = c.id
    WHERE c.teacher_id = teacher_id;

    RETURN created_assignments;
END;

-- Function to get the number of quizzes created by a specific teacher
CREATE FUNCTION getQuizzesCreatedByTeacher(teacher_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE created_quizzes INT;

    -- Count the number of quizzes created by the teacher
    SELECT COUNT(*)
    INTO created_quizzes
    FROM classroom_quiz cq
             JOIN classroom c ON cq.class_id = c.id
    WHERE c.teacher_id = teacher_id;

    RETURN created_quizzes;
END;

-- Function to get the number of classrooms a teacher is teaching
CREATE FUNCTION getClassroomsTaughtByTeacher(teacher_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE classrooms_taught INT;

    -- Count the number of classrooms taught by the teacher
    SELECT COUNT(*)
    INTO classrooms_taught
    FROM classroom
    WHERE classroom.teacher_id = teacher_id;

    RETURN classrooms_taught;
END;

-- Function to get the number of assignments graded by a specific teacher
CREATE FUNCTION getAssignmentsGradedByTeacher(teacher_id INT)
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE graded_assignments INT;

    -- Count the number of assignments graded by the teacher (inactive assignments)
    SELECT COUNT(*)
    INTO graded_assignments
    FROM progress_assignment pa
             JOIN progress p ON pa.progress_id = p.id
             JOIN classroom c ON p.classroom_id = c.id
             JOIN teacher t ON c.teacher_id = t.id
    WHERE pa.status = 'inactive' AND c.teacher_id = teacher_id;

    RETURN graded_assignments;
END;

-- Function to get the total number of teachers in the system
CREATE FUNCTION getTotalTeachers()
    RETURNS INT
    DETERMINISTIC
BEGIN
    DECLARE teacher_count INT;

    -- Count the total number of teachers
    SELECT COUNT(*)
    INTO teacher_count
    FROM teacher;

    RETURN teacher_count;
END;

-- Call to get the number of classrooms/courses completed by the student
SELECT getCompletedClassrooms('student_id');

-- Call to get the number of assignments completed by the student
SELECT getCompletedAssignments('student_id');

-- Call to get the number of quizzes completed by the student
SELECT getCompletedQuizzes('sample_student_id');

-- Call to get the number of students
SELECT getNumberOfStudents();

-- Call to get the number of assignments created by the teacher
SELECT getCreatedAssignments('sample_teacher_id');

-- Call to get the number of quizzes created by the teacher
SELECT getCreatedQuizzes('sample_teacher_id');

-- Call to get the number of classrooms the teacher is teaching
SELECT getTeachingClassrooms('teacher_id');

-- Call to get the number of assignments graded by the teacher
SELECT getGradedAssignments('sample_teacher_id');

-- Call to get the number of teachers
SELECT getNumberOfTeachers();

