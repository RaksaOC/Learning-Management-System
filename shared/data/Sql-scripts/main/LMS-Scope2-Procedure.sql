DELIMITER //

-- ==============================================================================================================
-- LMS-Teacher Procedures
-- ==============================================================================================================

-- =====================================
-- Edit Assignment Procedure
-- =====================================

CREATE PROCEDURE EditAssignment(
    IN p_new_title VARCHAR(255),
    IN p_new_description TEXT,
    IN p_new_deadline DATE,
    IN p_new_ref_attachment VARCHAR(255),
    IN p_assignment_id VARCHAR(50)
)
BEGIN
    -- Update the assignment table with the new values
    UPDATE assignment
    SET title = p_new_title, description = p_new_description, deadline = p_new_deadline, ref_attachment = p_new_ref_attachment
    WHERE id = p_assignment_id;
END //

-- =====================================
-- Add Assignment Procedure
-- =====================================

DELIMITER //

CREATE PROCEDURE AddAssignment(
    IN p_id VARCHAR(50),
    IN p_title VARCHAR(255),
    IN p_description TEXT,
    IN p_deadline DATE,
    IN p_ref_attachment VARCHAR(255),
    IN p_classroom_id VARCHAR(50)
)
BEGIN
    -- Insert into Assignment table
    INSERT INTO assignment (id, title, description, deadline, status, ref_attachment)
    VALUES (p_id, p_title, p_description, p_deadline, 'active', p_ref_attachment);

    -- Insert into Classroom_Assignment table
    INSERT INTO classroom_assignment (class_id, assignment_id)
    VALUES (p_classroom_id, p_id);

    -- Insert into Progress_Assignment table
    INSERT INTO progress_assignment (progress_id, assignment_id, score, sub_attachment, status)
    SELECT id, p_id, NULL, NULL, 'active'
    FROM progress WHERE classroom_id = p_classroom_id;
END //

-- =====================================
-- Delete Assignment Procedure
-- =====================================

CREATE PROCEDURE DeleteAssignment(
    IN p_assignment_id VARCHAR(50)
)
BEGIN
    -- Update status to 'inactive' in the assignment table
    UPDATE assignment
    SET status = 'inactive'
    WHERE id = p_assignment_id;

    -- Delete from classroom_assignment table
    DELETE FROM classroom_assignment ca
    WHERE ca.assignment_id = p_assignment_id;

    -- Delete from progress_assignment table
    DELETE FROM progress_assignment pa
    WHERE pa.assignment_id = p_assignment_id;
END //

-- =====================================
-- Grade Assignment Procedure
-- =====================================

CREATE PROCEDURE GradeAssignment(
    IN p_score DECIMAL(5,2),
    IN p_student_id VARCHAR(50),
    IN p_classroom_id VARCHAR(50),
    IN p_assignment_id VARCHAR(50)
)
BEGIN
    DECLARE p_progress_id VARCHAR(50);

    -- Get student's progress id
    SELECT p.id
    INTO p_progress_id
    FROM progress p
    WHERE p.student_id = p_student_id AND p.classroom_id = p_classroom_id;

    -- Update the grade for the assignment
    UPDATE progress_assignment
    SET score = p_score, status = 'inactive'
    WHERE progress_id = p_progress_id AND assignment_id = p_assignment_id;
END //

-- =====================================
-- Add Material Procedure
-- =====================================

CREATE PROCEDURE AddMaterial(
    IN p_id VARCHAR(50),
    IN p_title VARCHAR(255),
    IN p_description TEXT,
    IN p_ref_attachment VARCHAR(255),
    IN p_classroom_id VARCHAR(50)
)
BEGIN
    -- Insert into material table
    INSERT INTO material (id, title, description, status, ref_attachment)
    VALUES (p_id, p_title, p_description, 'active', p_ref_attachment);

    -- Insert into classroom_material (associating material with a classroom)
    INSERT INTO classroom_material (class_id, material_id)
    VALUES (p_classroom_id, p_id);

    -- Insert into progress_material for students in the selected classroom
    INSERT INTO progress_material (progress_id, material_id, status)
    SELECT id, p_id, 'active'
    FROM progress
    WHERE classroom_id = p_classroom_id;
END //

-- =====================================
-- Edit Material Procedure
-- =====================================

CREATE PROCEDURE EditMaterial(
    IN p_newTitle VARCHAR(255),
    IN p_newDescription TEXT,
    IN p_ref_attachment VARCHAR(255),
    IN p_material_id VARCHAR(50)
)
BEGIN
    -- Update material table with new details
    UPDATE material
    SET title = p_newTitle,
        description = p_newDescription,
        ref_attachment = p_ref_attachment
    WHERE id = p_material_id;
END //

-- =====================================
-- Delete Material Procedure
-- =====================================

CREATE PROCEDURE DeleteMaterial(
    IN p_material_id VARCHAR(50)
)
BEGIN
    UPDATE material
    SET status = 'inactive'
    WHERE id = p_material_id;

    DELETE FROM classroom_material cm
    WHERE cm.material_id = p_material_id;

    DELETE FROM progress_material pm
    WHERE pm.material_id = p_material_id;
END //

-- =====================================
-- Add Quiz Procedure
-- =====================================

-- TODO: missing add quiz

-- =====================================
-- Edit Quiz Procedure
-- =====================================

DELIMITER //

CREATE PROCEDURE EditQuiz(
    IN p_quiz_id VARCHAR(50),
    IN p_quiz_title VARCHAR(255),
    IN p_quiz_description TEXT,
    IN p_status VARCHAR(50),
    IN p_class_id VARCHAR(50),
    IN p_quiz_data JSON
)
BEGIN
    CALL DeleteQuiz(p_quiz_id);

    -- CALL AddQuiz(p_quiz_title, p_quiz_description, p_status, p_class_id, p_quiz_data); TODO: add add quiz procedure

END //

-- =====================================
-- Delete Quiz Procedure
-- =====================================

CREATE PROCEDURE DeleteQuiz(
    IN p_quiz_id VARCHAR(50)
)
BEGIN
    -- Delete from classroom_quiz (removing the quiz from classrooms)
    DELETE FROM classroom_quiz cq
    WHERE cq.quiz_id = p_quiz_id;

    -- Delete from progress_quiz (removing the quiz from student progress)
    DELETE FROM progress_quiz pq
    WHERE pq.quiz_id = p_quiz_id;

    -- Set the quiz status to inactive
    UPDATE quiz
    SET status = 'inactive'
    WHERE id = p_quiz_id;

    -- Delete associated questions and choices
    DELETE FROM choice
    WHERE question_id IN (SELECT id FROM question q WHERE q.id = p_quiz_id);

    DELETE FROM question q
    WHERE q.quiz_id = p_quiz_id;
END //

-- ==============================================================================================================
-- LMS-Student Procedures
-- ==============================================================================================================

-- =====================================
-- Assignment Submission Procedure
-- =====================================

CREATE PROCEDURE SubmitAssignment(
    IN p_student_id VARCHAR(50),
    IN p_assignment_id VARCHAR(50),
    IN p_sub_attachment VARCHAR(255)
)
BEGIN
    UPDATE progress_assignment pa
        JOIN progress p ON pa.progress_id = p.id
    SET pa.sub_attachment = p_sub_attachment
    WHERE p.student_id = p_student_id AND pa.assignment_id = p_assignment_id;
END //

-- =====================================
-- Quiz Submission Procedure
-- =====================================

CREATE PROCEDURE SubmitQuiz(
    IN p_student_id VARCHAR(50),
    IN p_quiz_id VARCHAR(50),
    IN p_score DECIMAL(5,2)
)
BEGIN
    UPDATE progress_quiz pq
        JOIN progress p ON pq.progress_id = p.id
    SET pq.score = p_score
    WHERE pq.quiz_id = p_quiz_id AND p.student_id = p_student_id;
END //

-- =====================================
-- Resource Submission Procedure
-- =====================================

CREATE PROCEDURE SubmitResource(
    IN p_student_id VARCHAR(50),
    IN p_material_id VARCHAR(50)
)
BEGIN
    UPDATE progress_material pr
        JOIN progress p ON pr.progress_id = p.id
    SET pr.status = 'inactive'
    WHERE p.student_id = p_student_id AND pr.material_id = p_material_id;
END //

DELIMITER ;



-- TODO: -- ===========================================================================================================
-- TODO: -- CALLING Procedures
-- TODO: -- ===========================================================================================================

-- =====================================
-- Submit Assignment
-- =====================================

CALL SubmitAssignment('', '', '');

-- =====================================
-- Submit Quiz
-- =====================================

CALL SubmitQuiz('', '', '');

-- =====================================
-- Submit Resource
-- =====================================

CALL SubmitResource('', '');

-- =====================================
-- Edit Assignment
-- =====================================

CALL EditAssignment('', '', '', '', '');

-- =====================================
-- Add Assignment
-- =====================================

CALL AddAssignment('', '', '', '', '', '');

-- =====================================
-- Delete Assignment
-- =====================================

CALL DeleteAssignment('');

-- =====================================
-- Grade Assignment
-- =====================================

CALL GradeAssignment('', '', '', '');

-- =====================================
-- Add Material
-- =====================================

CALL AddMaterial('', '', '', '', '');

-- =====================================
-- Edit Material
-- =====================================

CALL EditMaterial('', '', '', '');

-- =====================================
-- Delete Material
-- =====================================

CALL DeleteMaterial('');

-- =====================================
-- Edit Quiz
-- =====================================

CALL EditQuiz('', '', '', '', '', '');

-- =====================================
-- Delete Quiz
-- =====================================

CALL DeleteQuiz('');

