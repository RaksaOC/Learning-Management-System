DELIMITER //

CREATE TRIGGER generate_new_student_id_before_insert
    BEFORE INSERT ON student
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'S';

    SELECT COUNT(id) INTO new_id FROM student;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('S'), '0'));

END //

CREATE TRIGGER generate_new_teacher_id_before_insert
    BEFORE INSERT ON teacher
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'T';

    SELECT COUNT(id) INTO new_id FROM teacher;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('T'), '0'));

END //

CREATE TRIGGER generate_new_admin_id_before_insert
    BEFORE INSERT ON admin
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'A';

    SELECT COUNT(id) INTO new_id FROM admin;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('A'), '0'));

END //

CREATE TRIGGER generate_new_assignment_id_before_insert
    BEFORE INSERT ON assignment
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'A';

    SELECT COUNT(id) INTO new_id FROM assignment;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('A'), '0'));

END //

CREATE TRIGGER generate_new_material_id_before_insert
    BEFORE INSERT ON material
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'R';

    SELECT COUNT(id) INTO new_id FROM material;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('R'), '0'));

END //

CREATE TRIGGER generate_new_quiz_id_before_insert
    BEFORE INSERT ON quiz
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'Q';

    SELECT COUNT(id) INTO new_id FROM quiz;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('Q'), '0'));

END //

CREATE TRIGGER generate_new_question_id_before_insert
    BEFORE INSERT ON question
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'QU';

    SELECT COUNT(id) INTO new_id FROM question;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('QU'), '0'));

END //

CREATE TRIGGER generate_new_choice_id_before_insert
    BEFORE INSERT ON choice
    FOR EACH ROW
BEGIN
    DECLARE new_id INT;
    DECLARE new_id_string VARCHAR(255);
    DECLARE base_id VARCHAR(255);

    SET base_id = 'C';

    SELECT COUNT(id) INTO new_id FROM choice;

    SET new_id = new_id + 1;

    SET new_id_string = CAST(new_id AS CHAR);

    SET NEW.id = CONCAT(base_id, LPAD(new_id_string, LENGTH(base_id) - LENGTH('C'), '0'));

END //

DELIMITER ;
