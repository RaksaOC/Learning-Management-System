CREATE DATABASE LMS;

USE LMS;

-- HELPERS
SHOW DATABASES;
SET FOREIGN_KEY_CHECKS=1; -- make sure to switch between after use

-- Admin Table
CREATE TABLE admin (
    id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    created_at DATETIME NOT NULL,
    last_login DATETIME,
    password VARCHAR(255) NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob DATE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL, 
    status ENUM('active', 'inactive') NOT NULL
);

-- Student Table
CREATE TABLE student (
    id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob DATE NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE, 
    password VARCHAR(255) NOT NULL,
    commune VARCHAR(100) NOT NULL,
    district VARCHAR(100) NOT NULL,
    province VARCHAR(100) NOT NULL,
    status ENUM('active', 'inactive') NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_login TIMESTAMP,
    department_id VARCHAR(10) NOT NULL,
    specialization_id VARCHAR(10) NOT NULL,
    generation_id VARCHAR(10) NOT NULL,
    group_id varchar(20), -- can be null because need to assign later
    
    guardian_first_name VARCHAR(50),
    guardian_last_name VARCHAR(50),
    guardian_phone_number VARCHAR(15),
    guardian_gender VARCHAR(10),
	
    FOREIGN KEY (group_id) REFERENCES student_group(id) ON DELETE CASCADE,
    FOREIGN KEY (department_id) REFERENCES department(id) ON DELETE CASCADE,
    FOREIGN KEY (specialization_id) REFERENCES specialization(id) ON DELETE CASCADE,
    FOREIGN KEY (generation_id) REFERENCES generation(id) ON DELETE CASCADE
);

-- Teacher Table
CREATE TABLE teacher (
    id VARCHAR(10) PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    gender VARCHAR(10) NOT NULL,
    dob DATE NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE, 
    status ENUM('active', 'inactive') NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_login TIMESTAMP,
    password VARCHAR(255) NOT NULL
);

-- Teacher Login History
CREATE TABLE teacher_history (
    teacher_id VARCHAR(10) NOT NULL,
    last_action ENUM('login', 'logout') NOT NULL,
    time TIMESTAMP NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES teacher(id) ON DELETE CASCADE
);

-- Student Login History
CREATE TABLE student_history (
    student_id VARCHAR(10) NOT NULL,
    last_action ENUM('login', 'logout') NOT NULL,
    time TIMESTAMP NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE
);

-- Progress Tracking
CREATE TABLE progress (
    id VARCHAR(10) PRIMARY KEY,
    student_id VARCHAR(10) NOT NULL,
    classroom_id VARCHAR(50) NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id) ON DELETE CASCADE,
    FOREIGN KEY (classroom_id) REFERENCES classroom(id) ON DELETE CASCADE
);


CREATE TABLE progress_assignment (
    progress_id VARCHAR(10),
    assignment_id VARCHAR(10),
    score DECIMAL CHECK (score >= 0 AND score <= 100),
    sub_attachment VARCHAR(500),
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (progress_id) REFERENCES progress(id) ON UPDATE CASCADE,
    FOREIGN KEY (assignment_id) REFERENCES assignment(id) ON UPDATE CASCADE
);

CREATE TABLE progress_material (
    progress_id VARCHAR(10),
    material_id VARCHAR(10),
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (progress_id) REFERENCES progress(id) ON UPDATE CASCADE,
    FOREIGN KEY (material_id) REFERENCES material(id) ON UPDATE CASCADE
);

CREATE TABLE progress_quiz (
    progress_id VARCHAR(10),
    quiz_id VARCHAR(10),
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (progress_id) REFERENCES progress(id) ON UPDATE CASCADE,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON UPDATE CASCADE
);

-- Course Table
CREATE TABLE course (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    level VARCHAR(50),
    credit VARCHAR(50),
    status ENUM('active', 'inactive') NOT NULL
);

-- Department Table
CREATE TABLE department (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    status ENUM('active', 'inactive') NOT NULL
);

-- Specialization Table
CREATE TABLE specialization (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    department_id VARCHAR(10) NOT NULL,
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department(id) ON UPDATE CASCADE 
);

CREATE TABLE generation (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL, 
    status ENUM('active', 'inactive') NOT NULL
);

-- Group Table
CREATE TABLE student_group (
    id VARCHAR(50) PRIMARY KEY,
    generation_id VARCHAR(10) NOT NULL,
    specialization_id VARCHAR(10) NOT NULL,
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (generation_id) REFERENCES generation(id) ON UPDATE CASCADE,
    FOREIGN KEY (specialization_id) REFERENCES specialization(id) ON UPDATE CASCADE
);

-- Classroom Table
CREATE TABLE classroom (
    id VARCHAR(50) PRIMARY KEY,
    teacher_id VARCHAR(20) NOT NULL,
    course_id VARCHAR(20) NOT NULL,
    group_id VARCHAR(20) NOT NULL,
    status ENUM('active', 'inactive') NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES teacher(id) ON UPDATE CASCADE,
    FOREIGN KEY (course_id) REFERENCES course(id) ON UPDATE CASCADE,
    FOREIGN KEY (group_id) REFERENCES student_group(id) ON UPDATE CASCADE
);

-- Classroom_student table

CREATE TABLE classroom_student(
	class_id VARCHAR(20),
    student_id VARCHAR(10),
    
    FOREIGN KEY (class_id) REFERENCES classroom(id) ON UPDATE CASCADE,
    FOREIGN KEY (student_id) REFERENCES student(id) ON UPDATE CASCADE
);

-- Assignments Table
CREATE TABLE assignment (
    id VARCHAR(10) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    deadline DATETIME NOT NULL,
    status ENUM('active', 'inactive') NOT NULL,
    ref_attachment VARCHAR(500) DEFAULT NULL
);

-- Material Table
CREATE TABLE material (
    id VARCHAR(10) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status ENUM('active', 'inactive') NOT NULL,
    ref_attachment VARCHAR(500) DEFAULT NULL
);

-- Quizzes Table
CREATE TABLE quiz (
    id VARCHAR(10) PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    status ENUM('active', 'inactive') NOT NULL
);

-- Questions Table
CREATE TABLE question (
    id VARCHAR(10) PRIMARY KEY,
    quiz_id VARCHAR(10),
    title VARCHAR(100) NOT NULL,
    correct VARCHAR(100) NOT NULL,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON UPDATE CASCADE
);

-- Choices Table
CREATE TABLE choice (
    id VARCHAR(10) PRIMARY KEY,  -- good for changing a specific choice
    question_id VARCHAR(10) NOT NULL,
    choice_text VARCHAR(100) NOT NULL,
    FOREIGN KEY (question_id) REFERENCES question(id) ON DELETE CASCADE
);

-- Junction Tables for Classroom-Assignments, Quizzes, and Materials

CREATE TABLE classroom_assignment (
    class_id VARCHAR(50),
    assignment_id VARCHAR(10),
    FOREIGN KEY (class_id) REFERENCES classroom(id) ON UPDATE CASCADE,
    FOREIGN KEY (assignment_id) REFERENCES assignment(id) ON UPDATE CASCADE
);

CREATE TABLE classroom_quiz (
    class_id VARCHAR(50),
    quiz_id VARCHAR(10),
    FOREIGN KEY (class_id) REFERENCES classroom(id) ON UPDATE CASCADE,
    FOREIGN KEY (quiz_id) REFERENCES quiz(id) ON UPDATE CASCADE	
);

CREATE TABLE classroom_material (
    class_id VARCHAR(50),
    material_id VARCHAR(10),
    FOREIGN KEY (class_id) REFERENCES classroom(id) ON UPDATE CASCADE,
    FOREIGN KEY (material_id) REFERENCES material(id) ON UPDATE CASCADE
);

CREATE TABLE administrative(
	commune VARCHAR(100),
    commune_code VARCHAR(20),
    commune_ref VARCHAR(100),
    commune_alt VARCHAR(100),
    commune_alt2 VARCHAR(100),
    commune_sqm DECIMAL,
    
    district VARCHAR(100),
    district_code VARCHAR(15),
    
    province VARCHAR(100),
    province_code VARCHAR(10),
    
    country VARCHAR(100),
    country_code VARCHAR(5)
);

select * from administrative;
