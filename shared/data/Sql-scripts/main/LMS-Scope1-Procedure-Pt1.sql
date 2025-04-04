DELIMITER //

-- ================================
-- Admin Procedures
-- ================================

CREATE PROCEDURE AddAdmin(
    IN p_id VARCHAR(10),
    IN p_first_name VARCHAR(255),
    IN p_last_name VARCHAR(255),
    IN p_created_at TIMESTAMP,
    IN p_password VARCHAR(255),
    IN p_phone_number VARCHAR(20),
    IN p_gender VARCHAR(10),
    IN p_dob DATE,
    IN p_email VARCHAR(255),
    IN p_status VARCHAR(20)
)
BEGIN
    INSERT INTO admin (id, first_name, last_name, created_at, last_login, password, phone_number, gender, dob, email, status)
    VALUES (p_id, p_first_name, p_last_name, p_created_at, NULL, p_password, p_phone_number, p_gender, p_dob, p_email, p_status);
END //

CREATE PROCEDURE DeleteAdmin(IN p_id VARCHAR(10))
BEGIN
    UPDATE admin SET status = 'inactive' WHERE id = p_id;
END //

-- ================================
-- Classroom Procedures
-- ================================

CREATE PROCEDURE AddClassroom(
    IN p_id VARCHAR(255),
    IN p_teacher_id VARCHAR(255),
    IN p_course_id VARCHAR(255),
    IN p_group_id VARCHAR(255),
    IN p_status VARCHAR(50)
)
BEGIN
    INSERT INTO classroom (id, teacher_id, course_id, group_id, status)
    VALUES (p_id, p_teacher_id, p_course_id, p_group_id, p_status);

    INSERT INTO progress (id, student_id, classroom_id)
    SELECT UUID(), s.id, p_id
    FROM student s
    WHERE s.group_id = p_group_id;
END //

CREATE PROCEDURE DeleteClassroom(
    IN p_id VARCHAR(255)
)
BEGIN
    UPDATE classroom
    SET status = 'inactive'
    WHERE id = p_id;
END //

-- ================================
-- Course Procedures
-- ================================

CREATE PROCEDURE AddCourse(
    IN p_id VARCHAR(50),
    IN p_name VARCHAR(255),
    IN p_credit VARCHAR(50),
    IN p_level VARCHAR(50),
    IN p_description TEXT,
    IN p_status VARCHAR(50)
)
BEGIN
    INSERT INTO course (id, name, credit, level, description, status)
    VALUES (p_id, p_name, p_credit, p_level, p_description, p_status);
END //

CREATE PROCEDURE DeleteCourse(
    IN p_id VARCHAR(50)
)
BEGIN
    UPDATE course
    SET status = 'inactive'
    WHERE id = p_id;
END //

-- ================================
-- Generation Procedures
-- ================================

CREATE PROCEDURE AddGeneration(
    IN p_id VARCHAR(50),
    IN p_name VARCHAR(255),
    IN p_status VARCHAR(50)
)
BEGIN
    INSERT INTO generation (id, name, status)
    VALUES (p_id, p_name, p_status);
END //

CREATE PROCEDURE DeleteGeneration(
    IN p_id VARCHAR(50)
)
BEGIN
    UPDATE generation
    SET status = 'inactive'
    WHERE id = p_id;
END //

-- ================================
-- Group Procedures
-- ================================

CREATE PROCEDURE AddGroup(
    IN p_group_id VARCHAR(50),
    IN p_generation_id VARCHAR(50),
    IN p_specialization_id VARCHAR(50),
    IN p_group_status VARCHAR(50)
)
BEGIN
    INSERT INTO student_group (id, generation_id, specialization_id, status)
    VALUES (p_group_id, p_generation_id, p_specialization_id, p_group_status);
END //

CREATE PROCEDURE DeleteGroup(
    IN p_id VARCHAR(50)
)
BEGIN
    UPDATE student_group
    SET status = 'inactive'
    WHERE id = p_id;
END //

-- ================================
-- Specialization Procedures
-- ================================

CREATE PROCEDURE AddSpecialization(
    IN p_specialization_id VARCHAR(50),
    IN p_department_id VARCHAR(50),
    IN p_specialization_name VARCHAR(255),
    IN p_specialization_status VARCHAR(50)
)
BEGIN
    INSERT INTO specialization (id, department_id, name, status)
    VALUES (p_specialization_id, p_department_id, p_specialization_name, p_specialization_status);
END //

CREATE PROCEDURE DeleteSpecialization(
    IN p_id VARCHAR(50)
)
BEGIN
    UPDATE specialization
    SET status = 'inactive'
    WHERE id = p_id;
END //

-- ================================
-- Student Procedures
-- ================================

CREATE PROCEDURE AddStudent(
    IN p_id VARCHAR(10),
    IN p_first_name VARCHAR(255),
    IN p_last_name VARCHAR(255),
    IN p_gender VARCHAR(50),
    IN p_dob DATE,
    IN p_phone_number VARCHAR(20),
    IN p_email VARCHAR(255),
    IN p_password VARCHAR(255),
    IN p_commune VARCHAR(255),
    IN p_district VARCHAR(255),
    IN p_province VARCHAR(255),
    IN p_status VARCHAR(50),
    IN p_created_at TIMESTAMP,
    IN p_last_login TIMESTAMP,
    IN p_department_id VARCHAR(50),
    IN p_specialization_id VARCHAR(50),
    IN p_generation_id VARCHAR(50),
    IN p_guardian_first_name VARCHAR(255),
    IN p_guardian_last_name VARCHAR(255),
    IN p_guardian_phone_number VARCHAR(20),
    IN p_guardian_gender VARCHAR(50)
)
BEGIN
    INSERT INTO student (
        id, first_name, last_name, gender, dob, phone_number, email, password, commune, district, province, status,
        created_at, last_login, department_id, specialization_id, generation_id,
        guardian_first_name, guardian_last_name, guardian_phone_number, guardian_gender
    )
    VALUES (
               p_id, p_first_name, p_last_name, p_gender, p_dob, p_phone_number, p_email, p_password, p_commune, p_district, p_province, p_status,
               p_created_at, p_last_login, p_department_id, p_specialization_id, p_generation_id,
               p_guardian_first_name, p_guardian_last_name, p_guardian_phone_number, p_guardian_gender
           );
END //

CREATE PROCEDURE DeleteStudent(
    IN p_id VARCHAR(50)
)
BEGIN
    UPDATE student
    SET status = 'inactive'
    WHERE id = p_id;
END //

-- ================================
-- Teacher Procedures
-- ================================

CREATE PROCEDURE AddTeacher(
    IN p_id VARCHAR (10),
    IN p_first_name VARCHAR(255),
    IN p_last_name VARCHAR(255),
    IN p_gender VARCHAR(50),
    IN p_dob DATE,
    IN p_phone_number VARCHAR(20),
    IN p_email VARCHAR(255),
    IN p_status VARCHAR(50),
    IN p_created_at TIMESTAMP,
    IN p_last_login TIMESTAMP,
    IN p_password VARCHAR(255)
)
BEGIN
    INSERT INTO teacher (id, first_name, last_name, gender, dob, phone_number, email, status, created_at, last_login, password)
    VALUES (p_id, p_first_name, p_last_name, p_gender, p_dob, p_phone_number, p_email, p_status,
            p_created_at, p_last_login, p_password);
END //

CREATE PROCEDURE DeleteTeacher(
    IN p_id VARCHAR(50)
)
BEGIN
    UPDATE teacher
    SET status = 'inactive'
    WHERE id = p_id;
END //

DELIMITER ;

-- TODO: -- ===========================================================================================================
-- TODO: -- CALLING Procedures
-- TODO: -- ===========================================================================================================


-- ================================
-- Admin Procedures
-- ================================

CALL AddAdmin('', '', '', '', '', '', '', '', '', '');
CALL DeleteAdmin('');

-- ================================
-- Classroom Procedures
-- ================================

CALL AddClassroom('', '', '', '', '');
CALL DeleteClassroom('');

-- ================================
-- Course Procedures
-- ================================

CALL AddCourse('', '', '', '', '', '');
CALL DeleteCourse('');

-- ================================
-- Generation Procedures
-- ================================

CALL AddGeneration('', '', '');
CALL DeleteGeneration('');

-- ================================
-- Group Procedures
-- ================================

CALL AddGroup('', '', '', '');
CALL DeleteGroup('');

-- ================================
-- Specialization Procedures
-- ================================

CALL AddSpecialization('', '', '', '');
CALL DeleteSpecialization('');

-- ================================
-- Student Procedures
-- ================================

CALL AddStudent('', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');
CALL DeleteStudent('');

-- ================================
-- Teacher Procedures
-- ================================

CALL AddTeacher('', '', '', '', '', '', '', '', '', '', '');
CALL DeleteTeacher('');





