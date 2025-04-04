DELIMITER $$

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
END $$

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
END $$

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
END $$

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
END $$

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
END $$

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
END $$

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
END $$

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
END $$

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
END $$

CREATE FUNCTION isAdminEmailTaken(f_email VARCHAR(255))
    RETURNS BOOLEAN
    DETERMINISTIC
BEGIN
    DECLARE email_count INT;

    SELECT COUNT(*)
    INTO email_count
    FROM admin
    WHERE f_email = email;

    RETURN email_count > 0;
END$$

CREATE FUNCTION isStudentEmailTaken(f_email VARCHAR(255))
    RETURNS BOOLEAN
    DETERMINISTIC
BEGIN
    DECLARE email_count INT;

    SELECT COUNT(*)
    INTO email_count
    FROM student
    WHERE f_email = email;

    RETURN email_count > 0;
END$$

CREATE FUNCTION isTeacherEmailTaken(f_email VARCHAR(255))
    RETURNS BOOLEAN
    DETERMINISTIC
BEGIN
    DECLARE email_count INT;

    SELECT COUNT(*)
    INTO email_count
    FROM teacher
    WHERE f_email = email;

    RETURN email_count > 0;
END$$

CREATE FUNCTION getOldAdminFirstName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE first_name VARCHAR(255);

    SELECT first_name INTO first_name
    FROM admin
    WHERE id = idToEdit;

    RETURN first_name;
END$$

CREATE FUNCTION getOldAdminLastName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE last_name VARCHAR(255);

    SELECT last_name INTO last_name
    FROM admin
    WHERE id = idToEdit;

    RETURN last_name;
END$$

CREATE FUNCTION getOldAdminDob(idToEdit VARCHAR(255))
    RETURNS DATE
    DETERMINISTIC
BEGIN
    DECLARE dob DATE;

    SELECT dob INTO dob
    FROM admin
    WHERE id = idToEdit;

    RETURN dob;
END$$


CREATE FUNCTION getOldAdminName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE full_name VARCHAR(255);

    SELECT CONCAT(first_name, ' ', last_name) INTO full_name
    FROM admin
    WHERE id = idToEdit;

    RETURN full_name;
END$$

CREATE FUNCTION getOldAdminEmail(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE email VARCHAR(255);

    SELECT email INTO email
    FROM admin
    WHERE id = idToEdit;

    RETURN email;
END$$

CREATE FUNCTION getOldAdminGender(idToEdit VARCHAR(255))
    RETURNS VARCHAR(50)
    DETERMINISTIC
BEGIN
    DECLARE gender VARCHAR(50);

    SELECT gender INTO gender
    FROM admin
    WHERE id = idToEdit;

    RETURN gender;
END$$

CREATE FUNCTION getOldAdminPhone(idToEdit VARCHAR(255))
    RETURNS VARCHAR(50)
    DETERMINISTIC
BEGIN
    DECLARE phone_number VARCHAR(50);

    SELECT phone_number INTO phone_number
    FROM admin
    WHERE id = idToEdit;

    RETURN phone_number;
END$$

CREATE FUNCTION isAdminOldPasswordMatched(idToEdit VARCHAR(255), oldPassword VARCHAR(255))
    RETURNS BOOLEAN
    DETERMINISTIC
BEGIN
    DECLARE password VARCHAR(255);

    SELECT password INTO password
    FROM admin
    WHERE id = idToEdit;

    RETURN password = oldPassword;
END$$

CREATE FUNCTION getOldClassroomId(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE classroom_id VARCHAR(255);

    SELECT id INTO classroom_id
    FROM classroom
    WHERE id = idToEdit;

    RETURN classroom_id;
END$$

CREATE FUNCTION getOldCourseId(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE course_id VARCHAR(255);

    SELECT id INTO course_id
    FROM course
    WHERE id = idToEdit;

    RETURN course_id;
END$$

CREATE FUNCTION getOldCourseName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE course_name VARCHAR(255);

    SELECT name INTO course_name
    FROM course
    WHERE id = idToEdit;

    RETURN course_name;
END$$

CREATE FUNCTION getOldDepartmentId(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE department_id VARCHAR(255);

    SELECT id INTO department_id
    FROM department
    WHERE id = idToEdit;

    RETURN department_id;
END$$

CREATE FUNCTION getOldDepartmentName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE department_name VARCHAR(255);

    SELECT name INTO department_name
    FROM department
    WHERE id = idToEdit;

    RETURN department_name;
END$$

CREATE FUNCTION getOldGenerationId(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE generation_id VARCHAR(255);

    SELECT id INTO generation_id
    FROM generation
    WHERE id = idToEdit;

    RETURN generation_id;
END$$

CREATE FUNCTION getOldGenerationName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE generation_name VARCHAR(255);

    SELECT name INTO generation_name
    FROM generation
    WHERE id = idToEdit;

    RETURN generation_name;
END$$

CREATE FUNCTION getOldStudentGroupId(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE student_group_id VARCHAR(255);

    SELECT id INTO student_group_id
    FROM student_group
    WHERE id = idToEdit;

    RETURN student_group_id;
END$$

CREATE FUNCTION getOldSpecializationId(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE specialization_id VARCHAR(255);

    SELECT id INTO specialization_id
    FROM specialization
    WHERE id = idToEdit;

    RETURN specialization_id;
END$$

CREATE FUNCTION getOldSpecializationName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE specialization_name VARCHAR(255);

    SELECT name INTO specialization_name
    FROM specialization
    WHERE id = idToEdit;

    RETURN specialization_name;
END$$

-- Get the old student's first name
CREATE FUNCTION getOldStudentFirstName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT first_name INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's last name
CREATE FUNCTION getOldStudentLastName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT last_name INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's guardian's first name
CREATE FUNCTION getOldStudentGuardianFirstName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT guardian_first_name INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's guardian's last name
CREATE FUNCTION getOldStudentGuardianLastName(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT guardian_last_name INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's guardian's gender
CREATE FUNCTION getOldStudentGuardianGender(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT guardian_gender INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's guardian's phone number
CREATE FUNCTION getOldStudentGuardianPhone(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT guardian_phone_number INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's phone number
CREATE FUNCTION getOldStudentPhone(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT phone_number INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's email
CREATE FUNCTION getOldStudentEmail(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT email INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's commune
CREATE FUNCTION getOldStudentCommune(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT commune INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's district
CREATE FUNCTION getOldStudentDistrict(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT district INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

-- Get the old student's province
CREATE FUNCTION getOldStudentProvince(idToEdit VARCHAR(255))
    RETURNS VARCHAR(255)
    DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(255);
    SELECT province INTO result FROM student WHERE id = idToEdit;
    RETURN result;
END $$

DELIMITER ;

SELECT getCompletedClassrooms('');
SELECT getCompletedAssignments('');
SELECT getCompletedQuizzes('');
SELECT getTotalStudents();
SELECT getAssignmentsCreatedByTeacher('');
SELECT getQuizzesCreatedByTeacher('');
SELECT getClassroomsTaughtByTeacher('');
SELECT getAssignmentsGradedByTeacher('');
SELECT getTotalTeachers();
SELECT isAdminEmailTaken('');
SELECT isStudentEmailTaken('');
SELECT isTeacherEmailTaken('');
SELECT getOldAdminFirstName('');
SELECT getOldAdminLastName('');
SELECT getOldAdminDob('');
SELECT getOldAdminName('');
SELECT getOldAdminEmail('');
SELECT getOldAdminGender('');
SELECT getOldAdminPhone('');
SELECT isAdminOldPasswordMatched('', '');
SELECT getOldClassroomId('');
SELECT getOldCourseId('');
SELECT getOldCourseName('');
SELECT getOldDepartmentId('');
SELECT getOldDepartmentName('');
SELECT getOldGenerationId('');
SELECT getOldGenerationName('');
SELECT getOldStudentGroupId('');
SELECT getOldSpecializationId('');
SELECT getOldSpecializationName('');
SELECT getOldStudentFirstName('');
SELECT getOldStudentLastName('');
SELECT getOldStudentGuardianFirstName('');
SELECT getOldStudentGuardianLastName('');
SELECT getOldStudentGuardianGender('');
SELECT getOldStudentGuardianPhone('');
SELECT getOldStudentPhone('');
SELECT getOldStudentEmail('');
SELECT getOldStudentCommune('');
SELECT getOldStudentDistrict('');
SELECT getOldStudentProvince('');
