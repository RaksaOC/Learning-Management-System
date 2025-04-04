DELIMITER //

-- =====================================
-- Admin Editing Procedures
-- =====================================

-- Edit Date of Birth
CREATE PROCEDURE EditAdminDOB(
    IN admin_id VARCHAR(50),
    IN new_dob DATE
)
BEGIN
    UPDATE admin
    SET dob = new_dob
    WHERE id = admin_id;
END //

-- Edit First and Last Name
CREATE PROCEDURE EditAdminName(
    IN admin_id VARCHAR(50),
    IN new_first_name VARCHAR(255),
    IN new_last_name VARCHAR(255)
)
BEGIN
    UPDATE admin
    SET first_name = new_first_name,
        last_name  = new_last_name
    WHERE id = admin_id;
END //

-- Edit Email
CREATE PROCEDURE EditAdminEmail(
    IN admin_id VARCHAR(50),
    IN new_email VARCHAR(255)
)
BEGIN
    UPDATE admin
    SET email = new_email
    WHERE id = admin_id;
END //

-- Edit Gender
CREATE PROCEDURE EditAdminGender(
    IN admin_id VARCHAR(50),
    IN new_gender VARCHAR(50)
)
BEGIN
    UPDATE admin
    SET gender = new_gender
    WHERE id = admin_id;
END //

-- Edit Phone Number
CREATE PROCEDURE EditAdminPhone(
    IN admin_id VARCHAR(50),
    IN new_phone_number VARCHAR(20)
)
BEGIN
    UPDATE admin
    SET phone_number = new_phone_number
    WHERE id = admin_id;
END //

-- Edit Password
CREATE PROCEDURE EditAdminPassword(
    IN admin_id VARCHAR(50),
    IN new_password VARCHAR(255)
)
BEGIN
    UPDATE admin
    SET password = new_password
    WHERE id = admin_id;
END //

-- =====================================
-- Classroom Editing Procedures
-- =====================================

-- Edit Classroom ID
CREATE PROCEDURE EditClassroomId(
    IN old_classroom_id VARCHAR(50),
    IN new_classroom_id VARCHAR(50)
)
BEGIN
    UPDATE classroom
    SET id = new_classroom_id
    WHERE id = old_classroom_id;
END //

-- =====================================
-- Course Editing Procedures
-- =====================================

-- Edit Course ID
CREATE PROCEDURE EditCourseId(
    IN old_course_id VARCHAR(50),
    IN new_course_id VARCHAR(50)
)
BEGIN
    UPDATE course
    SET id = new_course_id
    WHERE id = old_course_id;
END //

-- Edit Course Name
CREATE PROCEDURE EditCourseName(
    IN course_id VARCHAR(50),
    IN new_course_name VARCHAR(255)
)
BEGIN
    UPDATE course
    SET name = new_course_name
    WHERE id = course_id;
END //

-- =====================================
-- Department Editing Procedures
-- =====================================

-- Edit Department ID
CREATE PROCEDURE EditDepartmentId(
    IN old_department_id VARCHAR(50),
    IN new_department_id VARCHAR(50)
)
BEGIN
    UPDATE department
    SET id = new_department_id
    WHERE id = old_department_id;
END //

-- Edit Department Name
CREATE PROCEDURE EditDepartmentName(
    IN department_id VARCHAR(50),
    IN new_department_name VARCHAR(255)
)
BEGIN
    UPDATE department
    SET name = new_department_name
    WHERE id = department_id;
END //

-- =====================================
-- Generation Editing Procedures
-- =====================================

-- Edit Generation ID
CREATE PROCEDURE EditGenerationId(
    IN old_generation_id VARCHAR(50),
    IN new_generation_id VARCHAR(50)
)
BEGIN
    UPDATE generation
    SET id = new_generation_id
    WHERE id = old_generation_id;
END //

-- Edit Generation Name
CREATE PROCEDURE EditGenerationName(
    IN generation_id VARCHAR(50),
    IN new_generation_name VARCHAR(255)
)
BEGIN
    UPDATE generation
    SET name = new_generation_name
    WHERE id = generation_id;
END //

-- =====================================
-- Edit Group Procedure
-- =====================================

CREATE PROCEDURE EditGroupId(
    IN old_group_id VARCHAR(50),
    IN new_group_id VARCHAR(50)
)
BEGIN
    UPDATE student_group
    SET id = new_group_id
    WHERE id = old_group_id;
END //

-- =====================================
-- Specialization Editing Procedures
-- =====================================

-- Edit Specialization ID
CREATE PROCEDURE EditSpecializationId(
    IN old_specialization_id VARCHAR(50),
    IN new_specialization_id VARCHAR(50)
)
BEGIN
    UPDATE specialization
    SET id = new_specialization_id
    WHERE id = old_specialization_id;
END //

-- Edit Specialization Name
CREATE PROCEDURE EditSpecializationName(
    IN specialization_id VARCHAR(50),
    IN new_specialization_name VARCHAR(255)
)
BEGIN
    UPDATE specialization
    SET name = new_specialization_name
    WHERE id = specialization_id;
END //

-- =====================================
-- Student Editing Procedures
-- =====================================

-- Edit Student Name
CREATE PROCEDURE EditStudentName(
    IN student_id VARCHAR(50),
    IN new_first_name VARCHAR(255),
    IN new_last_name VARCHAR(255)
)
BEGIN
    UPDATE student
    SET first_name = new_first_name,
        last_name  = new_last_name
    WHERE id = student_id;
END //

-- Edit Student Address
CREATE PROCEDURE EditStudentAddress(
    IN student_id VARCHAR(50),
    IN new_commune VARCHAR(255),
    IN new_district VARCHAR(255),
    IN new_province VARCHAR(255)
)
BEGIN
    UPDATE student
    SET commune  = new_commune,
        district = new_district,
        province = new_province
    WHERE id = student_id;
END //

-- Edit Student Gender
CREATE PROCEDURE EditStudentGender(
    IN student_id VARCHAR(50),
    IN new_gender VARCHAR(10)
)
BEGIN
    UPDATE student
    SET gender = new_gender
    WHERE id = student_id;
END //

-- Edit Student Date of Birth
CREATE PROCEDURE EditStudentDOB(
    IN student_id VARCHAR(50),
    IN new_dob DATE
)
BEGIN
    UPDATE student
    SET dob = new_dob
    WHERE id = student_id;
END //

-- Edit Student Phone Number
CREATE PROCEDURE EditStudentPhone(
    IN student_id VARCHAR(50),
    IN new_phone_number VARCHAR(50)
)
BEGIN
    UPDATE student
    SET phone_number = new_phone_number
    WHERE id = student_id;
END //

-- Edit Student Password
CREATE PROCEDURE EditStudentPassword(
    IN student_id VARCHAR(50),
    IN new_password VARCHAR(255)
)
BEGIN
    UPDATE student
    SET password = new_password
    WHERE id = student_id;
END //

-- Edit Student Guardian Information
CREATE PROCEDURE EditStudentGuardian(
    IN student_id VARCHAR(50),
    IN new_guardian_first_name VARCHAR(255),
    IN new_guardian_last_name VARCHAR(255),
    IN new_guardian_gender VARCHAR(10),
    IN new_guardian_phone_number VARCHAR(50)
)
BEGIN
    UPDATE student
    SET guardian_first_name   = new_guardian_first_name,
        guardian_last_name    = new_guardian_last_name,
        guardian_gender       = new_guardian_gender,
        guardian_phone_number = new_guardian_phone_number
    WHERE id = student_id;
END //

-- Edit Student Department
CREATE PROCEDURE EditStudentDepartment(
    IN student_id VARCHAR(50),
    IN new_department_id VARCHAR(50)
)
BEGIN
    UPDATE student
    SET department_id = new_department_id
    WHERE id = student_id;
END //

-- Edit Student Specialization
CREATE PROCEDURE EditStudentSpecialization(
    IN student_id VARCHAR(50),
    IN new_specialization_id VARCHAR(50)
)
BEGIN
    UPDATE student
    SET specialization_id = new_specialization_id
    WHERE id = student_id;
END //

-- =====================================
-- Teacher Editing Procedures
-- =====================================

-- Edit Teacher Name
CREATE PROCEDURE EditTeacherName(
    IN teacher_id VARCHAR(50),
    IN new_first_name VARCHAR(255),
    IN new_last_name VARCHAR(255)
)
BEGIN
    UPDATE teacher
    SET first_name = new_first_name,
        last_name  = new_last_name
    WHERE id = teacher_id;
END //

-- Edit Teacher Date of Birth
CREATE PROCEDURE EditTeacherDOB(
    IN teacher_id VARCHAR(50),
    IN new_dob DATE
)
BEGIN
    UPDATE teacher
    SET dob = new_dob
    WHERE id = teacher_id;
END //

-- Edit Teacher Email
CREATE PROCEDURE EditTeacherEmail(
    IN teacher_id VARCHAR(50),
    IN new_email VARCHAR(255)
)
BEGIN
    UPDATE teacher
    SET email = new_email
    WHERE id = teacher_id;
END //

-- Edit Teacher Gender
CREATE PROCEDURE EditTeacherGender(
    IN teacher_id VARCHAR(50),
    IN new_gender VARCHAR(10)
)
BEGIN
    UPDATE teacher
    SET gender = new_gender
    WHERE id = teacher_id;
END //

-- Edit Teacher Password
CREATE PROCEDURE EditTeacherPassword(
    IN teacher_id VARCHAR(50),
    IN new_password VARCHAR(255)
)
BEGIN
    UPDATE teacher
    SET password = new_password
    WHERE id = teacher_id;
END //

-- Edit Teacher Phone Number
CREATE PROCEDURE EditTeacherPhone(
    IN teacher_id VARCHAR(50),
    IN new_phone_number VARCHAR(50)
)
BEGIN
    UPDATE teacher
    SET phone_number = new_phone_number
    WHERE id = teacher_id;
END //

DELIMITER ;

-- TODO: -- ===========================================================================================================
-- TODO: -- CALLING Procedures
-- TODO: -- ===========================================================================================================

-- ================================
-- Admin Procedures
-- ================================

CALL EditAdminDOB('', '');
CALL EditAdminName('', '', '');
CALL EditAdminEmail('', '');
CALL EditAdminGender('', '');
CALL EditAdminPhone('', '');
CALL EditAdminPassword('', '');

-- ================================
-- Classroom Procedures
-- ================================

CALL EditClassroomId('', '');

-- ================================
-- Course Procedures
-- ================================

CALL EditCourseId('', '');
CALL EditCourseName('', '');

-- ================================
-- Department Procedures
-- ================================

CALL EditDepartmentId('', '');
CALL EditDepartmentName('', '');

-- ================================
-- Generation Procedures
-- ================================

CALL EditGenerationId('', '');
CALL EditGenerationName('', '');

-- ================================
-- Group Procedures
-- ================================

CALL EditGroupId('', '');

-- ================================
-- Specialization Procedures
-- ================================

CALL EditSpecializationId('', '');
CALL EditSpecializationName('', '');

-- ================================
-- Student Procedures
-- ================================

CALL EditStudentName('', '', '');
CALL EditStudentAddress('', '', '', '');
CALL EditStudentGender('', '');
CALL EditStudentDOB('', '');
CALL EditStudentPhone('', '');
CALL EditStudentPassword('', '');
CALL EditStudentGuardian('', '', '', '', '');
CALL EditStudentDepartment('', '');
CALL EditStudentSpecialization('', '');

-- ================================
-- Teacher Procedures
-- ================================

CALL EditTeacherName('', '', '');
CALL EditTeacherDOB('', '');
CALL EditTeacherEmail('', '');
CALL EditTeacherGender('', '');
CALL EditTeacherPassword('', '');
CALL EditTeacherPhone('', '');
