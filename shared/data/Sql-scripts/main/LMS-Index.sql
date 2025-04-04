-- ============================
-- Admin Table Indexes
-- ============================

CREATE INDEX idx_admin_email ON admin(email);
CREATE INDEX idx_admin_status ON admin(status);
CREATE INDEX idx_admin_last_login ON admin(last_login);

-- ============================
-- Student Table Indexes
-- ============================

CREATE INDEX idx_student_email ON student(email);
CREATE INDEX idx_student_status ON student(status);
CREATE INDEX idx_student_department_id ON student(department_id);
CREATE INDEX idx_student_specialization_id ON student(specialization_id);
CREATE INDEX idx_student_generation_id ON student(generation_id);
CREATE INDEX idx_student_group_id ON student(group_id);
CREATE INDEX idx_student_last_login ON student(last_login);

-- ============================
-- Teacher Table Indexes
-- ============================

CREATE INDEX idx_teacher_email ON teacher(email);
CREATE INDEX idx_teacher_status ON teacher(status);
CREATE INDEX idx_teacher_last_login ON teacher(last_login);

-- ============================
-- Teacher History Table Indexes
-- ============================

CREATE INDEX idx_teacher_history_teacher_id ON teacher_history(teacher_id);
CREATE INDEX idx_teacher_history_time ON teacher_history(time);

-- ============================
-- Student History Table Indexes
-- ============================

CREATE INDEX idx_student_history_student_id ON student_history(student_id);
CREATE INDEX idx_student_history_time ON student_history(time);

-- ============================
-- Progress Table Indexes
-- ============================

CREATE INDEX idx_progress_student_id ON progress(student_id);
CREATE INDEX idx_progress_classroom_id ON progress(classroom_id);

-- ============================
-- Progress Assignment Table Indexes
-- ============================

CREATE INDEX idx_progress_assignment_progress_id ON progress_assignment(progress_id);
CREATE INDEX idx_progress_assignment_assignment_id ON progress_assignment(assignment_id);
CREATE INDEX idx_progress_assignment_status ON progress_assignment(status);

-- ============================
-- Progress Material Table Indexes
-- ============================

CREATE INDEX idx_progress_material_progress_id ON progress_material(progress_id);
CREATE INDEX idx_progress_material_material_id ON progress_material(material_id);
CREATE INDEX idx_progress_material_status ON progress_material(status);

-- ============================
-- Progress Quiz Table Indexes
-- ============================

CREATE INDEX idx_progress_quiz_progress_id ON progress_quiz(progress_id);
CREATE INDEX idx_progress_quiz_quiz_id ON progress_quiz(quiz_id);
CREATE INDEX idx_progress_quiz_status ON progress_quiz(status);

-- ============================
-- Course Table Indexes
-- ============================

CREATE INDEX idx_course_status ON course(status);

-- ============================
-- Department Table Indexes
-- ============================

CREATE INDEX idx_department_status ON department(status);

-- ============================
-- Specialization Table Indexes
-- ============================

CREATE INDEX idx_specialization_status ON specialization(status);
CREATE INDEX idx_specialization_department_id ON specialization(department_id);

-- ============================
-- Generation Table Indexes
-- ============================

-- CREATE INDEX idx_generation_status ON generation(status); left out

-- ============================
-- Student Group Table Indexes
-- ============================

CREATE INDEX idx_student_group_status ON student_group(status);
CREATE INDEX idx_student_group_generation_id ON student_group(generation_id);
CREATE INDEX idx_student_group_specialization_id ON student_group(specialization_id);

-- ============================
-- Classroom Table Indexes
-- ============================

CREATE INDEX idx_classroom_status ON classroom(status);
CREATE INDEX idx_classroom_teacher_id ON classroom(teacher_id);
CREATE INDEX idx_classroom_course_id ON classroom(course_id);
CREATE INDEX idx_classroom_group_id ON classroom(group_id);

-- ============================
-- Question Table Indexes
-- ============================

CREATE INDEX idx_question_quiz_id ON question(quiz_id);

-- ============================
-- Choice Table Indexes
-- ============================

CREATE INDEX idx_choice_question_id ON choice(question_id);

-- ============================
-- Classroom Assignment Table Indexes
-- ============================

CREATE INDEX idx_classroom_assignment_class_id ON classroom_assignment(class_id);
CREATE INDEX idx_classroom_assignment_assignment_id ON classroom_assignment(assignment_id);

-- ============================
-- Classroom Quiz Table Indexes
-- ============================

CREATE INDEX idx_classroom_quiz_class_id ON classroom_quiz(class_id);
CREATE INDEX idx_classroom_quiz_quiz_id ON classroom_quiz(quiz_id);

-- ============================
-- Classroom Material Table Indexes
-- ============================

CREATE INDEX idx_classroom_material_class_id ON classroom_material(class_id);
CREATE INDEX idx_classroom_material_material_id ON classroom_material(material_id);

-- ============================
-- Administrative Table Indexes
-- ============================

CREATE INDEX idx_administrative_commune ON administrative(commune);
CREATE INDEX idx_administrative_district ON administrative(district);
CREATE INDEX idx_administrative_province ON administrative(province);