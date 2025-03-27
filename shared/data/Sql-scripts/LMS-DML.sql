
INSERT INTO admin
VALUES ('A001','Chanraksa','Ory','2025-03-21 09:00:00','2025-03-26 20:36:15','2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0','012554049','male','2006-03-04','me','active');

INSERT INTO `assignment` VALUES ('A0001','Who is Diddy?','Write an essay explaining his court charges.','2025-03-31 00:00:00','active','https://www.youtube.com/shorts/2RNjcaEKfMg');

-- MISSING: choice

INSERT INTO `classroom` VALUES ('GEN10-CS-DS-G1-AA','T0001','AA','GEN10-CS-DS-G1','active'),('GEN10-CS-DS-G1-DBMS','T0002','DBMS','GEN10-CS-DS-G1','active'),('GEN10-CS-DS-G1-FD','T0003','FD','GEN10-CS-DS-G1','active');

INSERT INTO `classroom_assignment` VALUES ('GEN10-CS-DS-G1-AA','A0001');

-- MISSING: classroom_material

-- MISSING: classroom_quiz

INSERT INTO `course` VALUES ('AA','Advanced Algorithm','Some description.','Undergraduate','5','active'),
('CPF','Computer Programming Fundamentals','This is the description of the Computer Programming Fundamentals course.','Undergraduate','5','active'),
('DBMS','Database Design & Analysis','Some description.','Undergraduate','5','active'),('FD','Front End Development','Some description.','Undergraduate','4','active'),
('LA','Linear Algebra','This is the description of the Linear Algebra course.','Undergraduate','5','active'),
('VA','Visual Art','This is the description for the visual art course.','Undergraduate','3','active');

INSERT INTO `department` 
VALUES 
  ('CS', 'Computer Science', 'active'), 
  ('DB', 'Digital Business', 'active'), 
  ('TN', 'Telecommunication & Networking', 'active');
  
INSERT INTO `generation` 
VALUES 
  ('GEN10', 'Generation 10', 'active'), 
  ('GEN11', 'Generation 11', 'active');
  
  
-- MISSING: material

INSERT INTO `progress` VALUES 
  ('P000001', 'S000011', 'GEN10-CS-DS-G1-AA'), 
  ('P000002', 'S000012', 'GEN10-CS-DS-G1-AA'), 
  ('P000003', 'S000013', 'GEN10-CS-DS-G1-AA'), 
  ('P000004', 'S000014', 'GEN10-CS-DS-G1-AA'), 
  ('P000005', 'S000015', 'GEN10-CS-DS-G1-AA'), 
  ('P000006', 'S000011', 'GEN10-CS-DS-G1-DBMS'), 
  ('P000007', 'S000012', 'GEN10-CS-DS-G1-DBMS'), 
  ('P000008', 'S000013', 'GEN10-CS-DS-G1-DBMS'), 
  ('P000009', 'S000014', 'GEN10-CS-DS-G1-DBMS'), 
  ('P000010', 'S000015', 'GEN10-CS-DS-G1-DBMS'), 
  ('P000011', 'S000011', 'GEN10-CS-DS-G1-FD'), 
  ('P000012', 'S000012', 'GEN10-CS-DS-G1-FD'), 
  ('P000013', 'S000013', 'GEN10-CS-DS-G1-FD'), 
  ('P000014', 'S000014', 'GEN10-CS-DS-G1-FD'), 
  ('P000015', 'S000015', 'GEN10-CS-DS-G1-FD');
  
INSERT INTO `progress_assignment` 
VALUES 
  ('P000001', 'A0001', NULL, 'asdfadsfadsfadsf', 'active'), 
  ('P000002', 'A0001', NULL, NULL, 'active'), 
  ('P000003', 'A0001', NULL, NULL, 'active'), 
  ('P000004', 'A0001', NULL, NULL, 'active'), 
  ('P000005', 'A0001', NULL, NULL, 'active');

-- MISSING: progress_material

-- MISSING: progress_quiz

-- MISSING: question

-- MISSING: quiz

INSERT INTO `specialization` 
VALUES 
  ('CS-DS', 'Data Science', 'CS', 'active'), 
  ('CS-SE', 'Software Engineering', 'CS', 'active'), 
  ('DB-EC', 'E-Commerce', 'DB', 'active'), 
  ('TN-CB', 'Cybersecurity', 'TN', 'active'), 
  ('TN-TN', 'Telecommunication & Networking', 'TN', 'active');
  
INSERT INTO `student` 
VALUES 
  (
    'S000001', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me1', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:35:42', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000002', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me2', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:19', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000003', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me3', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:27', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000004', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me4', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:31', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000005', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me5', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:36', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000006', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me6', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:41', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000007', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me7', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:46', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000008', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me8', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:51', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000009', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me9', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:36:56', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000010', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me10', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:37:01', 
    NULL, 'CS', 'CS-SE', 'GEN10', 'GEN10-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Female'
  ), 
  (
    'S000011', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me11', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:48:46', 
    '2025-03-27 14:35:24', 'CS', 'CS-DS', 
    'GEN10', 'GEN10-CS-DS-G1', 'Mom', 
    'Dad', '012585175', 'Male'
  ), 
  (
    'S000012', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me12', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:48:53', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000013', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me13', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:48:58', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000014', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me14', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:03', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000015', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me15', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:06', 
    '2025-03-27 14:35:06', 'CS', 'CS-DS', 
    'GEN10', 'GEN10-CS-DS-G1', 'Mom', 
    'Dad', '012585175', 'Male'
  ), 
  (
    'S000016', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me16', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:10', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000017', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me17', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:15', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000018', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me18', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:25', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000019', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me19', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:30', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000020', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me20', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:49:37', 
    NULL, 'CS', 'CS-DS', 'GEN10', 'GEN10-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000021', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me21', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:22', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000022', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me22', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:27', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000023', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me23', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:31', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000024', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me24', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:34', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000025', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me25', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:38', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000026', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me26', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:45', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000027', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me27', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:51', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000028', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me28', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:50:57', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000029', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me29', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:01', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000030', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me30', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:07', 
    NULL, 'TN', 'TN-CB', 'GEN10', 'GEN10-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000031', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me31', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:28', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000032', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me32', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:32', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000033', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me33', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:37', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000034', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me34', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:41', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000035', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me35', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:45', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000036', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me36', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:49', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000037', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me37', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:54', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000038', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me38', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:51:57', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000039', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me39', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:02', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000040', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me40', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:08', 
    NULL, 'TN', 'TN-TN', 'GEN10', 'GEN10-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000041', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me41', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:33', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000042', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me42', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:37', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000043', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me43', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:41', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000044', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me44', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:45', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000045', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me45', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:49', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000046', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me46', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:52:53', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000047', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me47', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:53:07', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000048', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me48', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:53:23', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000049', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me49', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:53:28', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000050', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me50', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:53:33', 
    NULL, 'DB', 'DB-EC', 'GEN10', 'GEN10-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000051', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me51', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:13', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000052', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me52', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:34', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000053', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me53', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:38', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000054', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me54', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:41', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000055', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me55', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:46', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000056', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me56', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:51', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000057', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me57', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:54', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000058', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me58', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:56:59', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000059', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me59', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:57:04', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000060', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me60', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:57:10', 
    NULL, 'CS', 'CS-SE', 'GEN11', 'GEN11-CS-SE-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000061', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me61', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:04', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000062', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me62', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:11', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000063', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me63', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:15', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000064', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me64', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:22', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000065', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me65', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:27', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000066', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me66', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:31', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000067', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me67', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:35', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000068', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me68', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:39', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000069', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me69', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:43', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000070', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me70', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:58:48', 
    NULL, 'CS', 'CS-DS', 'GEN11', 'GEN11-CS-DS-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000071', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me71', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:15', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000072', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me72', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:19', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000073', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me73', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:22', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000074', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me74', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:26', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000075', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me75', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:30', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000076', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me76', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:33', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000077', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me77', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:37', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000078', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me78', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:41', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000079', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me79', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:45', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000080', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me80', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 17:59:51', 
    NULL, 'TN', 'TN-CB', 'GEN11', 'GEN11-TN-CB-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000081', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me81', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:25', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000082', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me82', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:29', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000083', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me83', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:32', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000084', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me84', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:36', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000085', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me85', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:40', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000086', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me86', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:44', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000087', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me87', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:00:48', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000088', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me88', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:03', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000089', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me89', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:09', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000090', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me90', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:14', 
    NULL, 'TN', 'TN-TN', 'GEN11', 'GEN11-TN-TN-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000091', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me91', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:34', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000092', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me92', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:37', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000093', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me93', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:41', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000094', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me94', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:45', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000095', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me95', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:48', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G1', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000096', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me96', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:52', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000097', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me97', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:01:57', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000098', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me98', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:02:02', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000099', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me99', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:02:06', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  ), 
  (
    'S000100', 'Chanraksa', 'Ory', 'Male', 
    '2006-04-03', '012554049', 'me100', 
    '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0', 
    'Stueng Mean Chey', 'Mean Chey', 
    'Phnom Penh', 'active', '2025-03-26 18:02:12', 
    NULL, 'DB', 'DB-EC', 'GEN11', 'GEN11-DB-EC-G2', 
    'Mom', 'Dad', '012585175', 'Male'
  );

INSERT INTO `student_group` 
VALUES 
  (
    'GEN10-CS-DS-G1', 'GEN10', 'CS-DS', 
    'active'
  ), 
  (
    'GEN10-CS-DS-G2', 'GEN10', 'CS-DS', 
    'active'
  ), 
  (
    'GEN10-CS-SE-G1', 'GEN10', 'CS-SE', 
    'active'
  ), 
  (
    'GEN10-CS-SE-G2', 'GEN10', 'CS-SE', 
    'active'
  ), 
  (
    'GEN10-DB-EC-G1', 'GEN10', 'DB-EC', 
    'active'
  ), 
  (
    'GEN10-DB-EC-G2', 'GEN10', 'DB-EC', 
    'active'
  ), 
  (
    'GEN10-TN-CB-G1', 'GEN10', 'TN-CB', 
    'active'
  ), 
  (
    'GEN10-TN-CB-G2', 'GEN10', 'TN-CB', 
    'active'
  ), 
  (
    'GEN10-TN-TN-G1', 'GEN10', 'TN-TN', 
    'active'
  ), 
  (
    'GEN10-TN-TN-G2', 'GEN10', 'TN-TN', 
    'active'
  ), 
  (
    'GEN11-CS-DS-G1', 'GEN11', 'CS-DS', 
    'active'
  ), 
  (
    'GEN11-CS-DS-G2', 'GEN11', 'CS-DS', 
    'active'
  ), 
  (
    'GEN11-CS-SE-G1', 'GEN11', 'CS-SE', 
    'active'
  ), 
  (
    'GEN11-CS-SE-G2', 'GEN11', 'CS-SE', 
    'active'
  ), 
  (
    'GEN11-DB-EC-G1', 'GEN11', 'DB-EC', 
    'active'
  ), 
  (
    'GEN11-DB-EC-G2', 'GEN11', 'DB-EC', 
    'active'
  ), 
  (
    'GEN11-TN-CB-G1', 'GEN11', 'TN-CB', 
    'active'
  ), 
  (
    'GEN11-TN-CB-G2', 'GEN11', 'TN-CB', 
    'active'
  ), 
  (
    'GEN11-TN-TN-G1', 'GEN11', 'TN-TN', 
    'active'
  ), 
  (
    'GEN11-TN-TN-G2', 'GEN11', 'TN-TN', 
    'active'
  );


INSERT INTO `student_history` 
VALUES 
  (
    'S000011', 'login', '2025-03-26 21:10:51'
  ), 
  (
    'S000011', 'login', '2025-03-27 09:58:13'
  ), 
  (
    'S000011', 'login', '2025-03-27 10:36:47'
  ), 
  (
    'S000011', 'login', '2025-03-27 10:43:46'
  ), 
  (
    'S000011', 'login', '2025-03-27 10:58:48'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:06:14'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:07:51'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:13:49'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:16:37'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:18:47'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:26:05'
  ), 
  (
    'S000011', 'login', '2025-03-27 11:28:22'
  ), 
  (
    'S000011', 'login', '2025-03-27 14:21:26'
  ), 
  (
    'S000011', 'logout', '2025-03-27 14:23:40'
  ), 
  (
    'S000015', 'login', '2025-03-27 14:23:45'
  ), 
  (
    'S000015', 'login', '2025-03-27 14:35:06'
  ), 
  (
    'S000015', 'logout', '2025-03-27 14:35:18'
  ), 
  (
    'S000011', 'login', '2025-03-27 14:35:24'
  );

INSERT INTO `teacher` 
VALUES 
  (
    'T0001', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me1', 
    'active', '2025-03-26 20:37:43', 
    '2025-03-27 14:33:52', '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0002', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me2', 
    'active', '2025-03-26 20:38:03', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0003', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me3', 
    'active', '2025-03-26 20:38:08', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0004', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me4', 
    'active', '2025-03-26 20:38:12', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0005', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me5', 
    'active', '2025-03-26 20:38:15', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0006', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me6', 
    'active', '2025-03-26 20:38:20', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0007', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me7', 
    'active', '2025-03-26 20:38:24', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0008', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me8', 
    'active', '2025-03-26 20:38:28', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0009', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me9', 
    'active', '2025-03-26 20:38:32', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0010', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me10', 
    'active', '2025-03-26 20:38:36', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0011', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me11', 
    'active', '2025-03-26 20:38:40', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0012', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me12', 
    'active', '2025-03-26 20:38:48', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0013', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me13', 
    'active', '2025-03-26 20:38:52', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0014', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me14', 
    'active', '2025-03-26 20:38:57', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0015', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me15', 
    'active', '2025-03-26 20:39:02', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0016', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me16', 
    'active', '2025-03-26 20:39:06', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0017', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me17', 
    'active', '2025-03-26 20:39:10', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0018', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me18', 
    'active', '2025-03-26 20:39:13', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0019', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me19', 
    'active', '2025-03-26 20:39:18', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0020', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me20', 
    'active', '2025-03-26 20:39:22', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0021', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me21', 
    'active', '2025-03-26 20:39:26', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0022', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me22', 
    'active', '2025-03-26 20:39:29', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0023', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me23', 
    'active', '2025-03-26 20:39:34', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0024', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me24', 
    'active', '2025-03-26 20:39:38', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0025', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me25', 
    'active', '2025-03-26 20:39:43', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0026', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me26', 
    'active', '2025-03-26 20:39:46', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0027', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me27', 
    'active', '2025-03-26 20:39:50', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0028', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me28', 
    'active', '2025-03-26 20:39:54', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0029', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me29', 
    'active', '2025-03-26 20:39:58', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  ), 
  (
    'T0030', 'Chanraksa', 'Ory', 'Male', 
    '2025-03-01', '012554049', 'me30', 
    'active', '2025-03-26 20:40:03', 
    NULL, '2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0'
  );

  INSERT INTO `teacher_history` 
VALUES 
  (
    'T0001', 'login', '2025-03-27 09:01:05'
  ), 
  (
    'T0001', 'login', '2025-03-27 09:19:56'
  ), 
  (
    'T0001', 'login', '2025-03-27 09:23:09'
  ), 
  (
    'T0001', 'login', '2025-03-27 09:30:12'
  ), 
  (
    'T0001', 'login', '2025-03-27 09:32:25'
  ), 
  (
    'T0001', 'login', '2025-03-27 09:55:41'
  ), 
  (
    'T0001', 'login', '2025-03-27 12:40:28'
  ), 
  (
    'T0001', 'login', '2025-03-27 12:46:57'
  ), 
  (
    'T0001', 'login', '2025-03-27 12:52:29'
  ), 
  (
    'T0001', 'login', '2025-03-27 14:16:20'
  ), 
  (
    'T0001', 'login', '2025-03-27 14:20:46'
  ), 
  (
    'T0001', 'login', '2025-03-27 14:33:52'
  );

INSERT INTO `administrative` 
VALUES 
  (
    'A Buon Leu', 'KH110202', NULL, NULL, 
    NULL, 653, 'Kaoh Nheaek', 'KH1102', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Achar Leak', 'KH060309', NULL, NULL, 
    NULL, 6, 'Stueng Saen', 'KH0603', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Aekakpheap', 'KH160603', NULL, NULL, 
    NULL, 24, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Akphivoadth', 'KH040801', NULL, NULL, 
    NULL, 67, 'Tuek Phos', 'KH0408', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Akreiy Ksatr', 'KH080601', NULL, 
    NULL, NULL, 16, 'Lvea Aem', 'KH0806', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Amleang', 'KH050801', NULL, NULL, 
    NULL, 243, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Ampil', 'KH030601', NULL, NULL, NULL, 
    27, 'Kampong Siem', 'KH0306', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Ampil', 'KH171011', NULL, NULL, NULL, 
    56, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ampil', 'KH200401', NULL, NULL, NULL, 
    55, 'Romeas Haek', 'KH2004', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Ampil', 'KH220201', NULL, NULL, NULL, 
    365, 'Banteay Ampil', 'KH2202', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Ampil Krau', 'KH141201', NULL, NULL, 
    NULL, 37, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Ampil Pram Daeum', 'KH020405', NULL, 
    NULL, NULL, 163, 'Bavel', 'KH0204', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ampil Ta Pok', 'KH250401', NULL, 
    NULL, NULL, 27, 'Ou Reang Ov', 'KH2504', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Ampil Tuek', 'KH040501', NULL, NULL, 
    NULL, 109, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Ampov Prey', 'KH080101', NULL, NULL, 
    NULL, 14, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Andaeuk Haeb', 'KH020702', NULL, 
    NULL, NULL, 121, 'Rotonak Mondol', 
    'KH0207', 'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Andoung Khmer', 'KH070804', NULL, 
    NULL, NULL, 26, 'Kampot', 'KH0708', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Andoung Pou', 'KH060112', NULL, NULL, 
    NULL, 25, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Andoung Pou', 'KH200402', NULL, NULL, 
    NULL, 27, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Andoung Snay', 'KH040601', NULL, 
    NULL, NULL, 38, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Andoung Thma', 'KH180201', NULL, 
    NULL, NULL, 49, 'Prey Nob', 'KH1802', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Andoung Trabaek', 'KH200403', NULL, 
    NULL, NULL, 47, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Andoung Tuek', 'KH090101', NULL, 
    NULL, NULL, 409, 'Botum Sakor', 'KH0901', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Ang Sophy', 'KH070609', NULL, NULL, 
    NULL, 16, 'Kampong Trach', 'KH0706', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Angk Kaev', 'KH211006', NULL, NULL, 
    NULL, 33, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angk Khnor', 'KH211002', NULL, NULL, 
    NULL, 18, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angk Phnum Touch', 'KH070101', NULL, 
    NULL, NULL, 17, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Angk Popel', 'KH050301', NULL, NULL, 
    NULL, 19, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Angk Prasat', 'KH210401', NULL, NULL, 
    NULL, 59, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angk Prasrae', 'KH200404', NULL, 
    NULL, NULL, 30, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Angk Romeas', 'KH070509', NULL, NULL, 
    NULL, 19, 'Dang Tong', 'KH0705', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Angk Ta Saom', 'KH210901', NULL, 
    NULL, NULL, 32, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angk Ta Sou', 'KH200501', NULL, NULL, 
    NULL, 13, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Angkanh', 'KH210601', NULL, NULL, 
    NULL, 13, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angkanh', 'KH211001', NULL, NULL, 
    NULL, 16, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angkaol', 'KH230101', NULL, NULL, 
    NULL, 38, 'Damnak Chang\'aeur', 'KH2301', 
    'Kep', 'KH23', 'Cambodia', 'KH'
  ), 
  (
    'Angkor Angk', 'KH140601', NULL, NULL, 
    NULL, 35, 'Peam Chor', 'KH1406', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Angkor Ban', 'KH021002', NULL, NULL, 
    NULL, 66, 'Sampov Lun', 'KH0210', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Angkor Ban', 'KH030701', NULL, NULL, 
    NULL, 18, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Angkor Borei', 'KH210101', NULL, 
    NULL, NULL, 48, 'Angkor Borei', 'KH2101', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Angkor Reach', 'KH140901', NULL, 
    NULL, NULL, 42, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Angkor Sar', 'KH140501', NULL, NULL, 
    NULL, 31, 'Me Sang', 'KH1405', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Angkor Tret', 'KH141301', NULL, NULL, 
    NULL, 47, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Anhchaeum', 'KH250701', NULL, NULL, 
    NULL, 62, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Anhchanh Rung', 'KH040101', NULL, 
    NULL, NULL, 68, 'Baribour', 'KH0401', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Ankor Chey', 'KH070102', NULL, NULL, 
    NULL, 15, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Chrey', 'KH190505', NULL, 
    NULL, NULL, 622, 'Thala Barivat', 
    'KH1905', 'Stung Treng', 'KH19', 
    'Cambodia', 'KH'
  ), 
  (
    'Anlong Phe', 'KH190501', NULL, NULL, 
    NULL, 252, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Anlong Reab', 'KH150603', NULL, NULL, 
    NULL, 655, 'Veal Veaeng', 'KH1506', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Romiet', 'KH080102', NULL, 
    NULL, NULL, 6, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Run', 'KH020205', NULL, NULL, 
    NULL, 84, 'Thma Koul', 'KH0202', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Samnar', 'KH170401', NULL, 
    NULL, NULL, 277, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Tnaot', 'KH150301', NULL, 
    NULL, NULL, 83, 'Krakor', 'KH1503', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Veaeng', 'KH220101', NULL, 
    NULL, NULL, 392, 'Anlong Veaeng', 
    'KH2201', 'Oddar Meanchey', 'KH22', 
    'Cambodia', 'KH'
  ), 
  (
    'Anlong Vil', 'KH020801', NULL, NULL, 
    NULL, 40, 'Sangkae', 'KH0208', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Anlong Vil', 'KH150201', NULL, NULL, 
    NULL, 32, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ansa Chambak', 'KH150302', NULL, 
    NULL, NULL, 213, 'Krakor', 'KH1503', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ansaong', 'KH140301', NULL, NULL, 
    NULL, 29, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Areaks Tnot', 'KH031501', NULL, NULL, 
    NULL, 35, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'B\'er', 'KH040303', 'Ber', NULL, NULL, 
    2, 'Kampong Chhnang', 'KH0403', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Ba Baong', 'KH140701', NULL, NULL, 
    NULL, 51, 'Peam Ro', 'KH1407', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Ba Srae', 'KH210102', NULL, NULL, 
    NULL, 43, 'Angkor Borei', 'KH2101', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Ba Tang', 'KH160505', NULL, NULL, 
    NULL, 104, 'Lumphat', 'KH1605', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Baek Chan', 'KH080801', NULL, NULL, 
    NULL, 14, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Bak Anloung', 'KH220501', NULL, NULL, 
    NULL, 138, 'Trapeang Prasat', 'KH2205', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Bak Chenhchien', 'KH150401', NULL, 
    NULL, NULL, 42, 'Phnum Kravanh', 'KH1504', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Bak Dav', 'KH080301', NULL, NULL, 
    NULL, 9, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Bak Kaeng', 'KH121005', NULL, NULL, 
    NULL, 25, 'Chraoy Chongvar', 'KH1210', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Bak Sna', 'KH060101', NULL, NULL, 
    NULL, 45, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Bakong', 'KH170902', NULL, NULL, NULL, 
    25, 'Prasat Bakong', 'KH1709', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ballangk', 'KH060102', NULL, NULL, 
    NULL, 43, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Ballangk', 'KH170903', NULL, NULL, 
    NULL, 43, 'Prasat Bakong', 'KH1709', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ban Kam', 'KH210602', NULL, NULL, 
    NULL, 18, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Baniev', 'KH070301', NULL, NULL, NULL, 
    21, 'Chhuk', 'KH0703', 'Kampot', 'KH07', 
    'Cambodia', 'KH'
  ), 
  (
    'Banlich Prasat', 'KH140702', NULL, 
    NULL, NULL, 18, 'Peam Ro', 'KH1407', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Bansay Reak', 'KH220401', NULL, NULL, 
    NULL, 117, 'Samraong', 'KH2204', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Bansay Traeng', 'KH020209', NULL, 
    NULL, NULL, 59, 'Thma Koul', 'KH0202', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Chakrei', 'KH140902', NULL, 
    NULL, NULL, 84, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Chhmar', 'KH010701', NULL, 
    NULL, NULL, 461, 'Thma Puok', 'KH0107', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Daek', 'KH080201', NULL, 
    NULL, NULL, 55, 'Kien Svay', 'KH0802', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Banteay Dei', 'KH150508', NULL, NULL, 
    NULL, 15, 'Pursat', 'KH1505', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Banteay Krang', 'KH200201', NULL, 
    NULL, NULL, 29, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Meas Khang Kaeut', 'KH070201', 
    NULL, NULL, NULL, 35, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Meas Khang Lech', 'KH070202', 
    NULL, NULL, NULL, 34, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Neang', 'KH010201', NULL, 
    NULL, NULL, 52, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Preal', 'KH040602', NULL, 
    NULL, NULL, 51, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Banteay Stoung', 'KH060801', NULL, 
    NULL, NULL, 56, 'Stoung', 'KH0608', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Bar Kham', 'KH160701', NULL, NULL, 
    NULL, 321, 'Ou Ya Dav', 'KH1607', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Bar Yakha', 'KH240104', NULL, NULL, 
    NULL, 135, 'Pailin', 'KH2401', 'Pailin', 
    'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Barang Thleak', 'KH021104', NULL, 
    NULL, NULL, 68, 'Phnum Proek', 'KH0211', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Baray', 'KH031301', NULL, NULL, NULL, 
    30, 'Prey Chhor', 'KH0313', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Baray', 'KH031401', NULL, NULL, NULL, 
    57, 'Srei Santhor', 'KH0314', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Baray', 'KH060103', NULL, NULL, NULL, 
    142, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Baray', 'KH141001', NULL, NULL, NULL, 
    30, 'Prey Veng', 'KH1410', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Baray', 'KH210801', NULL, NULL, NULL, 
    44, 'Doun Kaev', 'KH2108', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Barku', 'KH080103', NULL, NULL, NULL, 
    7, 'Kandal Stueng', 'KH0801', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Barong', 'KH080602', NULL, NULL, NULL, 
    45, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Basak', 'KH021405', NULL, NULL, NULL, 
    98, 'Rukh Kiri', 'KH0214', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Basak', 'KH200502', NULL, NULL, NULL, 
    49, 'Svay Chrum', 'KH2005', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Basedth', 'KH050101', NULL, NULL, 
    NULL, 33, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Bat Trang', 'KH010202', NULL, NULL, 
    NULL, 40, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Batheay', 'KH030101', NULL, NULL, 
    NULL, 92, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Bati', 'KH200801', NULL, NULL, NULL, 
    42, 'Bavet', 'KH2008', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Bavel', 'KH020401', NULL, NULL, NULL, 
    60, 'Bavel', 'KH0204', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Bavet', 'KH200802', NULL, NULL, NULL, 
    48, 'Bavet', 'KH2008', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Bay Damram', 'KH020103', NULL, NULL, 
    NULL, 45, 'Banan', 'KH0201', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Bei', 'KH180103', NULL, NULL, NULL, 
    13, 'Preah Sihanouk', 'KH1801', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Beng', 'KH220202', NULL, NULL, NULL, 
    447, 'Banteay Ampil', 'KH2202', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Bet Trang', 'KH180203', NULL, NULL, 
    NULL, 75, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Boeng', 'KH060104', NULL, NULL, NULL, 
    28, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Bat Kandaol', 'KH150101', 
    NULL, NULL, NULL, 195, 'Bakan', 'KH1501', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Beng', 'KH010901', NULL, NULL, 
    NULL, 31, 'Malai', 'KH0109', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Char', 'KH100401', NULL, NULL, 
    NULL, 1155, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Daol', 'KH140903', NULL, NULL, 
    NULL, 51, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Kak Ti Muoy', 'KH120407', 
    NULL, NULL, NULL, 1, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Kak Ti Pir', 'KH120408', NULL, 
    NULL, NULL, 2, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Kansaeng', 'KH160204', NULL, 
    NULL, NULL, 7, 'Ban Lung', 'KH1602', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Kantuot', 'KH150303', NULL, 
    NULL, NULL, 47, 'Krakor', 'KH1503', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Keng Kang Ti Bei', 'KH120104', 
    NULL, NULL, NULL, 1, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Keng Kang Ti Muoy', 'KH120102', 
    NULL, NULL, NULL, 1, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Keng Kang Ti Pir', 'KH120103', 
    NULL, NULL, NULL, 0, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Khnar', 'KH150102', NULL, NULL, 
    NULL, 57, 'Bakan', 'KH1501', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Khyang', 'KH080104', NULL, 
    NULL, NULL, 18, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Kok', 'KH030501', NULL, NULL, 
    NULL, 4, 'Kampong Cham', 'KH0305', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Krum', 'KH080603', NULL, NULL, 
    NULL, 9, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Lvea', 'KH060701', NULL, NULL, 
    NULL, 867, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Mealea', 'KH171301', NULL, 
    NULL, NULL, 188, 'Svay Leu', 'KH1713', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Nay', 'KH031302', NULL, NULL, 
    NULL, 67, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Nimol', 'KH070303', NULL, NULL, 
    NULL, 32, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Preah', 'KH140101', NULL, NULL, 
    NULL, 41, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Preav', 'KH090601', NULL, NULL, 
    NULL, 90, 'Srae Ambel', 'KH0906', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Pring', 'KH020207', NULL, NULL, 
    NULL, 82, 'Thma Koul', 'KH0202', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Proluet', 'KH120308', NULL, 
    NULL, NULL, 0, 'Prampir Meakkakra', 
    'KH1203', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Pruol', 'KH250702', NULL, NULL, 
    NULL, 24, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Reang', 'KH021202', NULL, NULL, 
    NULL, 34, 'Kamrieng', 'KH0212', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Reang', 'KH120204', NULL, NULL, 
    NULL, 1, 'Doun Penh', 'KH1202', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Sala Khang Cheung', 'KH070601', 
    NULL, NULL, NULL, 25, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Sala Khang Tboung', 'KH070602', 
    NULL, NULL, NULL, 49, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Salang', 'KH120410', NULL, 
    NULL, NULL, 1, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Ta Prum', 'KH180202', NULL, 
    NULL, NULL, 31, 'Prey Nob', 'KH1802', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Thum', 'KH120908', NULL, NULL, 
    NULL, 16, 'Pur SenChey', 'KH1209', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Trabaek', 'KH120111', NULL, 
    NULL, NULL, 0, 'Chamkar Mon', 'KH1201', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeng Tranh Khang Cheung', 'KH210701', 
    NULL, NULL, NULL, 21, 'Samraong', 'KH2107', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Tranh Khang Tboung', 'KH210702', 
    NULL, NULL, NULL, 30, 'Samraong', 'KH2107', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Tuk', 'KH070701', NULL, NULL, 
    NULL, 42, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Boeng Tumpun', 'KH120602', NULL, 
    NULL, NULL, 5, 'Mean Chey', 'KH1206', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Boeung Pram', 'KH020408', NULL, NULL, 
    NULL, 70, 'Bavel', 'KH0204', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Borei Cholsar', 'KH210301', NULL, 
    NULL, NULL, 67, 'Borei Cholsar', 'KH2103', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Bos Khnor', 'KH030201', NULL, NULL, 
    NULL, 146, 'Chamkar Leu', 'KH0302', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Bos Leav', 'KH100601', NULL, NULL, 
    NULL, 69, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Bos Mon', 'KH200301', NULL, NULL, 
    NULL, 32, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Bos Sbov', 'KH010409', NULL, NULL, 
    NULL, 112, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Bos Sbov', 'KH220402', NULL, NULL, 
    NULL, 98, 'Samraong', 'KH2204', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Bour', 'KH021103', NULL, NULL, NULL, 
    46, 'Phnum Proek', 'KH0211', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Bu Sra', 'KH110404', NULL, NULL, NULL, 
    570, 'Pech Chreada', 'KH1104', 'Mondul Kiri', 
    'KH11', 'Cambodia', 'KH'
  ), 
  (
    'Buon', 'KH180104', NULL, NULL, NULL, 
    24, 'Preah Sihanouk', 'KH1801', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Cha Ung', 'KH160601', NULL, NULL, 
    NULL, 56, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Chaeng Mean Chey', 'KH020105', NULL, 
    NULL, NULL, 109, 'Banan', 'KH0201', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Chaeung Daeung', 'KH060105', NULL, 
    NULL, NULL, 72, 'Baray', 'KH0601', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Chak', 'KH040103', NULL, NULL, NULL, 
    16, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Chak', 'KH250402', NULL, NULL, NULL, 
    60, 'Ou Reang Ov', 'KH2504', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Chak Angrae Kraom', 'KH120607', 
    NULL, NULL, NULL, 10, 'Mean Chey', 
    'KH1206', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chak Angrae Leu', 'KH120606', NULL, 
    NULL, NULL, 3, 'Mean Chey', 'KH1206', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chakto Mukh', 'KH120207', NULL, NULL, 
    NULL, 2, 'Doun Penh', 'KH1202', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Cham', 'KH140302', NULL, NULL, NULL, 
    47, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Chamb├ók', 'KH100301', 'Chambok', 
    NULL, NULL, 107, 'Prek Prasab', 'KH1003', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Chambak', 'KH050601', NULL, NULL, 
    NULL, 83, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Chambak', 'KH200503', NULL, NULL, 
    NULL, 36, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Chambak', 'KH210201', NULL, NULL, 
    NULL, 23, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Chamkar Andoung', 'KH030202', NULL, 
    NULL, NULL, 108, 'Chamkar Leu', 'KH0302', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Chamkar Leu', 'KH190502', NULL, NULL, 
    NULL, 160, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Chamkar Luong', 'KH180401', NULL, 
    NULL, NULL, 111, 'Kampong Seila', 
    'KH1804', 'Preah Sihanouk', 'KH18', 
    'Cambodia', 'KH'
  ), 
  (
    'Chamna Kraom', 'KH060802', NULL, 
    NULL, NULL, 237, 'Stoung', 'KH0608', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Chamna Leu', 'KH060803', NULL, NULL, 
    NULL, 35, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chamnaom', 'KH010203', NULL, NULL, 
    NULL, 115, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Champa', 'KH210603', NULL, NULL, NULL, 
    16, 'Prey Kabbas', 'KH2106', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Champei', 'KH070103', NULL, NULL, 
    NULL, 33, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Champei', 'KH210202', NULL, NULL, 
    NULL, 23, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Chamraeun', 'KH130601', NULL, NULL, 
    NULL, 140, 'Sangkum Thmei', 'KH1306', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Chamraeun Phal', 'KH150501', NULL, 
    NULL, NULL, 59, 'Pursat', 'KH1505', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Chan Mul', 'KH250301', NULL, NULL, 
    NULL, 29, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Chan Sa', 'KH171101', NULL, NULL, 
    NULL, 93, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chan Saen', 'KH050501', NULL, NULL, 
    NULL, 33, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Changha', 'KH010501', NULL, NULL, 
    NULL, 66, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Changkrang', 'KH100602', NULL, NULL, 
    NULL, 245, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Chanleas Dai', 'KH170601', NULL, 
    NULL, NULL, 72, 'Kralanh', 'KH1706', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chantrea', 'KH200103', NULL, NULL, 
    NULL, 62, 'Chantrea', 'KH2001', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Chantrei', 'KH200405', NULL, NULL, 
    NULL, 28, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Chaom Chau', 'KH120904', NULL, NULL, 
    NULL, 27, 'Pur SenChey', 'KH1209', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chaong Maong', 'KH040803', NULL, 
    NULL, NULL, 65, 'Tuek Phos', 'KH0408', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Char', 'KH210604', NULL, NULL, NULL, 
    31, 'Prey Kabbas', 'KH2106', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Char Chhuk', 'KH170101', NULL, NULL, 
    NULL, 51, 'Angkor Chum', 'KH1701', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chbar Ampov', 'KH030102', NULL, NULL, 
    NULL, 42, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Chbar Ampov Ti Pir', 'KH121202', 
    NULL, NULL, NULL, 1, 'Chbar Ampov', 
    'KH1212', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chbar Mon', 'KH050201', NULL, NULL, 
    NULL, 33, 'Chbar Mon', 'KH0502', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Chea Khlang', 'KH141302', NULL, NULL, 
    NULL, 26, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Cheach', 'KH140201', NULL, NULL, NULL, 
    66, 'Kamchay Mear', 'KH1402', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Chealea', 'KH030103', NULL, NULL, 
    NULL, 43, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Cheang Daek', 'KH140303', NULL, NULL, 
    NULL, 71, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Cheang Tong', 'KH210902', NULL, NULL, 
    NULL, 32, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Chek', 'KH200605', NULL, NULL, NULL, 
    30, 'Svay Rieng', 'KH2006', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Aek', 'KH120515', NULL, NULL, 
    NULL, 13, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Kaeub', 'KH080105', NULL, 
    NULL, NULL, 16, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Kou', 'KH180204', NULL, NULL, 
    NULL, 222, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Kreav', 'KH040603', NULL, 
    NULL, NULL, 55, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Cheung Kuon', 'KH210703', NULL, NULL, 
    NULL, 22, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Phnum', 'KH140102', NULL, 
    NULL, NULL, 39, 'Ba Phnum', 'KH1401', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Cheung Prey', 'KH030104', NULL, NULL, 
    NULL, 18, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Roas', 'KH050502', NULL, NULL, 
    NULL, 36, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Tien', 'KH220301', NULL, NULL, 
    NULL, 94, 'Chong Kal', 'KH2203', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Cheung Tuek', 'KH141002', NULL, NULL, 
    NULL, 21, 'Prey Veng', 'KH1410', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Chey', 'KH060201', NULL, NULL, NULL, 
    56, 'Kampong Svay', 'KH0602', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chey Chouk', 'KH210302', NULL, NULL, 
    NULL, 34, 'Borei Cholsar', 'KH2103', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Chey Chummeah', 'KH120208', NULL, 
    NULL, NULL, 1, 'Doun Penh', 'KH1202', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chey Kampok', 'KH140904', NULL, NULL, 
    NULL, 34, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Chey Otdam', 'KH160501', NULL, NULL, 
    NULL, 669, 'Lumphat', 'KH1605', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Chey Thum', 'KH080302', NULL, NULL, 
    NULL, 31, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Cheyyou', 'KH030203', NULL, NULL, 
    NULL, 46, 'Chamkar Leu', 'KH0302', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Chhaeb Muoy', 'KH130201', NULL, NULL, 
    NULL, 381, 'Chhaeb', 'KH1302', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Chhaeb Pir', 'KH130202', NULL, NULL, 
    NULL, 523, 'Chhaeb', 'KH1302', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Chhak Chheu Neang', 'KH080803', 
    NULL, NULL, NULL, 8, 'Angk Snuol', 
    'KH0808', 'Kandal', 'KH08', 'Cambodia', 
    'KH'
  ), 
  (
    'Chhbar Ampov Ti Muoy', 'KH121201', 
    NULL, NULL, NULL, 0, 'Chbar Ampov', 
    'KH1212', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chhean Laeung', 'KH040701', NULL, 
    NULL, NULL, 54, 'Sameakki Mean Chey', 
    'KH0407', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Chhean Mukh', 'KH130703', NULL, NULL, 
    NULL, 142, 'Tbaeng Mean Chey', 'KH1307', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Chheu Kach', 'KH140103', NULL, NULL, 
    NULL, 35, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Chheu Kmau', 'KH080401', NULL, NULL, 
    NULL, 52, 'Kaoh Thum', 'KH0804', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Chheu Teal', 'KH020104', NULL, NULL, 
    NULL, 40, 'Banan', 'KH0201', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Chheu Teal', 'KH060601', NULL, NULL, 
    NULL, 117, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chheu Teal', 'KH080202', NULL, NULL, 
    NULL, 18, 'Kien Svay', 'KH0802', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Chheu Teal', 'KH200507', NULL, NULL, 
    NULL, 37, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Chheu Tom', 'KH150304', NULL, NULL, 
    NULL, 191, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Chhloung', 'KH100101', NULL, NULL, 
    NULL, 19, 'Chhloung', 'KH1001', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Chhnal Moan', 'KH021306', NULL, NULL, 
    NULL, 625, 'Koas Krala', 'KH0213', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Chhnok Tru', 'KH040102', NULL, NULL, 
    NULL, 42, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Chhuk', 'KH060501', NULL, NULL, NULL, 
    66, 'Prasat Sambour', 'KH0605', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chhuk', 'KH070304', NULL, NULL, NULL, 
    32, 'Chhuk', 'KH0703', 'Kampot', 'KH07', 
    'Cambodia', 'KH'
  ), 
  (
    'Chhuk', 'KH250201', NULL, NULL, NULL, 
    132, 'Krouch Chhmar', 'KH2502', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Chhuk Khsach', 'KH060107', NULL, 
    NULL, NULL, 53, 'Baray', 'KH0601', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Chhuk Sa', 'KH040502', NULL, NULL, 
    NULL, 67, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Chhveang', 'KH080901', NULL, NULL, 
    NULL, 28, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Chi Bal', 'KH031402', NULL, NULL, 
    NULL, 20, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Chi Kha Kraom', 'KH090602', NULL, 
    NULL, NULL, 71, 'Srae Ambel', 'KH0906', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Chi kha Leu', 'KH090603', NULL, NULL, 
    NULL, 596, 'Srae Ambel', 'KH0906', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Chi Khma', 'KH211003', NULL, NULL, 
    NULL, 17, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Chi Kraeng', 'KH170402', NULL, NULL, 
    NULL, 66, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chi Phat', 'KH090705', NULL, NULL, 
    NULL, 107, 'Thma Bang', 'KH0907', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Chi Phoch', 'KH140503', NULL, NULL, 
    NULL, 62, 'Me Sang', 'KH1405', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Chieb', 'KH040802', NULL, NULL, NULL, 
    350, 'Tuek Phos', 'KH0408', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Chikor', 'KH250703', NULL, NULL, NULL, 
    46, 'Tboung Khmum', 'KH2507', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Chirou Ti Muoy', 'KH250704', NULL, 
    NULL, NULL, 36, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Chirou Ti Pir', 'KH250705', NULL, 
    NULL, NULL, 63, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Chnuor Mean Chey', 'KH010401', NULL, 
    NULL, NULL, 49, 'Preah Netr Preah', 
    'KH0104', 'Banteay Meanchey', 'KH01', 
    'Cambodia', 'KH'
  ), 
  (
    'Choam', 'KH250302', NULL, NULL, NULL, 
    56, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Choam Kravien', 'KH250303', NULL, 
    NULL, NULL, 216, 'Memot', 'KH2503', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Choam Ksant', 'KH130301', NULL, NULL, 
    NULL, 353, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Choam Sangkae', 'KH050602', NULL, 
    NULL, NULL, 129, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Choam Ta Mau', 'KH250304', NULL, 
    NULL, NULL, 99, 'Memot', 'KH2503', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Chob', 'KH250706', NULL, NULL, NULL, 
    51, 'Tboung Khmum', 'KH2507', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Chob Ta Trav', 'KH170201', NULL, 
    NULL, NULL, 94, 'Angkor Thum', 'KH1702', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chob Vari', 'KH010402', NULL, NULL, 
    NULL, 84, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Chol Sar', 'KH040201', NULL, NULL, 
    NULL, 36, 'Chol Kiri', 'KH0402', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Chomkar Somraong', 'KH020304', NULL, 
    NULL, NULL, 9, 'Battambang', 'KH0203', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Chong Ampil', 'KH140401', NULL, NULL, 
    NULL, 36, 'Kanhchriech', 'KH1404', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Chong Cheach', 'KH250101', NULL, 
    NULL, NULL, 69, 'Dambae', 'KH2501', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Chong Doung', 'KH060108', NULL, NULL, 
    NULL, 127, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chong Kal', 'KH220302', NULL, NULL, 
    NULL, 291, 'Chong Kal', 'KH2203', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Chong Khnies', 'KH171007', NULL, 
    NULL, NULL, 28, 'Siem Reap', 'KH1710', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chong Phlah', 'KH110101', NULL, NULL, 
    NULL, 1157, 'Kaev Seima', 'KH1101', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Chongruk', 'KH050302', NULL, NULL, 
    NULL, 29, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrach', 'KH130104', NULL, NULL, NULL, 
    294, 'Chey Saen', 'KH1301', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Chrak Mtes', 'KH200803', NULL, NULL, 
    NULL, 65, 'Bavet', 'KH2008', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Chraneang', 'KH060106', NULL, NULL, 
    NULL, 23, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chrang Chamreh Ti Muoy', 'KH120711', 
    NULL, NULL, NULL, 2, 'Russey Keo', 
    'KH1207', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrang Chamreh Ti Pir', 'KH120712', 
    NULL, NULL, NULL, 4, 'Russey Keo', 
    'KH1207', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chranouk', 'KH040401', NULL, NULL, 
    NULL, 265, 'Kampong Leaeng', 'KH0404', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Chreav', 'KH171006', NULL, NULL, NULL, 
    66, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Chres', 'KH040503', NULL, NULL, NULL, 
    37, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Chres', 'KH070401', NULL, NULL, NULL, 
    24, 'Chum Kiri', 'KH0704', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Chres', 'KH140502', NULL, NULL, NULL, 
    44, 'Me Sang', 'KH1405', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Chres', 'KH200104', NULL, NULL, NULL, 
    52, 'Chantrea', 'KH2001', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Chrey', 'KH020204', NULL, NULL, NULL, 
    60, 'Thma Koul', 'KH0202', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Chrey', 'KH020605', NULL, NULL, NULL, 
    492, 'Moung Ruessei', 'KH0206', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Chrey', 'KH140304', NULL, NULL, NULL, 
    23, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrey', 'KH141303', NULL, NULL, NULL, 
    47, 'Svay Antor', 'KH1413', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Chrey Bak', 'KH040604', NULL, NULL, 
    NULL, 45, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrey Khmum', 'KH141202', NULL, NULL, 
    NULL, 37, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrey Loas', 'KH080902', NULL, NULL, 
    NULL, 38, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Chrey Seima', 'KH021006', NULL, NULL, 
    NULL, 67, 'Sampov Lun', 'KH0210', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrey Thum', 'KH200406', NULL, NULL, 
    NULL, 57, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrey Vien', 'KH031303', NULL, NULL, 
    NULL, 27, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Chroab', 'KH060702', NULL, NULL, NULL, 
    64, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chrolong', 'KH060109', NULL, NULL, 
    NULL, 38, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Chrouy Banteay', 'KH100302', NULL, 
    NULL, NULL, 508, 'Prek Prasab', 'KH1003', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Chrouy Changvar', 'KH121001', NULL, 
    NULL, NULL, 10, 'Chraoy Chongvar', 
    'KH1210', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrouy Neang Nguon', 'KH171201', 
    NULL, NULL, NULL, 77, 'Srei Snam', 
    'KH1712', 'Siemreap', 'KH17', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrouy Pras', 'KH090301', NULL, NULL, 
    NULL, 430, 'Kaoh Kong', 'KH0903', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Chrouy Sdau', 'KH020206', NULL, NULL, 
    NULL, 107, 'Thma Koul', 'KH0202', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Chrouy Svay', 'KH090604', NULL, NULL, 
    NULL, 169, 'Srae Ambel', 'KH0906', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Chrouy Ta Kaev', 'KH080402', NULL, 
    NULL, NULL, 35, 'Kaoh Thum', 'KH0804', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Chrung Popel', 'KH200304', NULL, 
    NULL, NULL, 25, 'Rumduol', 'KH2003', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Chum Kriel', 'KH070702', NULL, NULL, 
    NULL, 21, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Chumnik', 'KH250202', NULL, NULL, 
    NULL, 20, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Chumnoab', 'KH090703', NULL, NULL, 
    NULL, 65, 'Thma Bang', 'KH0907', 'Koh Kong', 
    'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Chumpu Proeks', 'KH050503', NULL, 
    NULL, NULL, 21, 'Odongk', 'KH0505', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Chumpu Voan', 'KH070402', NULL, NULL, 
    NULL, 57, 'Chum Kiri', 'KH0704', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Chumreah Pen', 'KH210704', NULL, 
    NULL, NULL, 33, 'Samraong', 'KH2107', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Daeum Doung', 'KH070106', NULL, NULL, 
    NULL, 18, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Daeum Rues', 'KH080106', NULL, NULL, 
    NULL, 24, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Dak Dam', 'KH110301', NULL, NULL, 
    NULL, 445, 'Ou Reang', 'KH1103', 'Mondul Kiri', 
    'KH11', 'Cambodia', 'KH'
  ), 
  (
    'Dam Daek', 'KH171102', NULL, NULL, 
    NULL, 26, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Dambae', 'KH250102', NULL, NULL, NULL, 
    86, 'Dambae', 'KH2501', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Dambouk Khpos', 'KH070104', NULL, 
    NULL, NULL, 61, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Dambouk Rung', 'KH050603', NULL, 
    NULL, NULL, 175, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Damnak Ampil', 'KH080804', NULL, 
    NULL, NULL, 8, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Damnak Kantuot Khang Cheung', 'KH070603', 
    NULL, NULL, NULL, 21, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Damnak Kantuot Khang Tboung', 'KH070604', 
    NULL, NULL, NULL, 27, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Damnak Reang', 'KH050513', NULL, 
    NULL, NULL, 33, 'Odongk', 'KH0505', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Damnak Sokram', 'KH070501', NULL, 
    NULL, NULL, 30, 'Dang Tong', 'KH0705', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Damrei Choan Khla', 'KH060301', 
    NULL, NULL, NULL, 10, 'Stueng Saen', 
    'KH0603', 'Kampong Thom', 'KH06', 
    'Cambodia', 'KH'
  ), 
  (
    'Damrei Phong', 'KH100102', NULL, 
    NULL, NULL, 263, 'Chhloung', 'KH1001', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Damrei Puon', 'KH141304', NULL, NULL, 
    NULL, 64, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Damrei Slab', 'KH060202', NULL, NULL, 
    NULL, 95, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Damril', 'KH250403', NULL, NULL, NULL, 
    45, 'Ou Reang Ov', 'KH2504', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Dan Koum', 'KH070105', NULL, NULL, 
    NULL, 30, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Dan Run', 'KH171103', NULL, NULL, 
    NULL, 121, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Dang Kambet', 'KH060602', NULL, NULL, 
    NULL, 451, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Dang Kdar', 'KH031503', NULL, NULL, 
    NULL, 198, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Dang Peaeng', 'KH090605', NULL, NULL, 
    NULL, 1283, 'Srae Ambel', 'KH0906', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Dang Tong', 'KH070502', NULL, NULL, 
    NULL, 43, 'Dang Tong', 'KH0705', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Dang Tong', 'KH090402', NULL, NULL, 
    NULL, 2, 'Khemara Phoumin', 'KH0904', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Dangkao', 'KH120501', NULL, NULL, 
    NULL, 14, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Dar', 'KH040402', NULL, NULL, NULL, 
    88, 'Kampong Leaeng', 'KH0404', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Dar', 'KH100603', NULL, NULL, NULL, 
    151, 'Chetr Borei', 'KH1006', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Dar', 'KH250305', NULL, NULL, NULL, 
    113, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Dechou Akphivoadth', 'KH070315', 
    NULL, NULL, NULL, 266, 'Chhuk', 'KH0703', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Dei Edth', 'KH080203', NULL, NULL, 
    NULL, 21, 'Kien Svay', 'KH0802', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Doeum Mien', 'KH081103', NULL, NULL, 
    NULL, 3, 'Ta Khmau', 'KH0811', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Doun Ba', 'KH021305', NULL, NULL, 
    NULL, 119, 'Koas Krala', 'KH0213', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Doun Kaev', 'KH170702', NULL, NULL, 
    NULL, 54, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Doun Koeng', 'KH140202', NULL, NULL, 
    NULL, 47, 'Kamchay Mear', 'KH1402', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Doun Peng', 'KH170102', NULL, NULL, 
    NULL, 64, 'Angkor Chum', 'KH1701', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Doun Sa', 'KH200508', NULL, NULL, 
    NULL, 27, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Doun Yay', 'KH070305', NULL, NULL, 
    NULL, 10, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Doung', 'KH060401', NULL, NULL, NULL, 
    91, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Doung', 'KH200407', NULL, NULL, NULL, 
    55, 'Romeas Haek', 'KH2004', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Doung', 'KH210203', NULL, NULL, NULL, 
    26, 'Bati', 'KH2102', 'Takeo', 'KH21', 
    'Cambodia', 'KH'
  ), 
  (
    'Doung Khpos', 'KH210303', NULL, NULL, 
    NULL, 28, 'Borei Cholsar', 'KH2103', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Dountei', 'KH250501', NULL, NULL, 
    NULL, 102, 'Ponhea Kraek', 'KH2505', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Hab', 'KH021303', NULL, NULL, NULL, 
    48, 'Koas Krala', 'KH0213', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Han Chey', 'KH100103', NULL, NULL, 
    NULL, 26, 'Chhloung', 'KH1001', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Hanchey', 'KH030602', NULL, NULL, 
    NULL, 28, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Haong Samnam', 'KH050401', NULL, 
    NULL, NULL, 97, 'Aoral', 'KH0504', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Hat Pak', 'KH160903', NULL, NULL, 
    NULL, 146, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'K\'am Samnar', 'KH080502', 'Kam Samnar', 
    NULL, NULL, 29, 'Leuk Daek', 'KH0805', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ka Choun', 'KH160904', NULL, NULL, 
    NULL, 82, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Ka Laeng', 'KH160502', NULL, NULL, 
    NULL, 520, 'Lumphat', 'KH1605', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Kachanh', 'KH160201', NULL, NULL, 
    NULL, 133, 'Ban Lung', 'KH1602', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Kaeb', 'KH230201', NULL, NULL, NULL, 
    22, 'Kaeb', 'KH2302', 'Kep', 'KH23', 
    'Cambodia', 'KH'
  ), 
  (
    'Kaev Phos', 'KH180304', NULL, NULL, 
    NULL, 131, 'Stueng Hav', 'KH1803', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaev Poar', 'KH170704', NULL, NULL, 
    NULL, 103, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kahaeng', 'KH050702', NULL, NULL, 
    NULL, 21, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Kak', 'KH050113', NULL, NULL, NULL, 
    24, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Kak', 'KH160301', NULL, NULL, NULL, 
    96, 'Bar Kaev', 'KH1603', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Kak', 'KH250502', NULL, NULL, NULL, 
    179, 'Ponhea Kraek', 'KH2505', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Kakab', 'KH120905', NULL, NULL, NULL, 
    13, 'Pur SenChey', 'KH1209', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Kakaoh', 'KH020607', NULL, NULL, NULL, 
    86, 'Moung Ruessei', 'KH0206', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Kakaoh', 'KH060704', NULL, NULL, NULL, 
    125, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Kalai', 'KH160604', NULL, NULL, NULL, 
    61, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Kamboul', 'KH120909', NULL, NULL, 
    NULL, 18, 'Pur SenChey', 'KH1209', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Kamnab', 'KH210403', NULL, NULL, NULL, 
    27, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kampeaeng', 'KH210404', NULL, NULL, 
    NULL, 48, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kampeaeng', 'KH210605', NULL, NULL, 
    NULL, 26, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kampenh', 'KH180301', NULL, NULL, 
    NULL, 6, 'Stueng Hav', 'KH1803', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Kamphun', 'KH190101', NULL, NULL, 
    NULL, 179, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Kampoan', 'KH250306', NULL, NULL, 
    NULL, 212, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Ampil', 'KH200305', NULL, 
    NULL, NULL, 24, 'Rumduol', 'KH2003', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Bay', 'KH070803', NULL, NULL, 
    NULL, 2, 'Kampot', 'KH0708', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Chak', 'KH200303', NULL, 
    NULL, NULL, 24, 'Rumduol', 'KH2003', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Cham', 'KH030502', NULL, 
    NULL, NULL, 1, 'Kampong Cham', 'KH0305', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Cham', 'KH100402', NULL, 
    NULL, NULL, 653, 'Sambour', 'KH1004', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Chamlang', 'KH080303', NULL, 
    NULL, NULL, 10, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Chamlang', 'KH200504', NULL, 
    NULL, NULL, 42, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Chen Cheung', 'KH060804', 
    NULL, NULL, NULL, 39, 'Stoung', 'KH0608', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Chen Tboung', 'KH060805', 
    NULL, NULL, NULL, 9, 'Stoung', 'KH0608', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Chhnang', 'KH040302', NULL, 
    NULL, NULL, 21, 'Kampong Chhnang', 
    'KH0403', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Kampong Damrei', 'KH100104', NULL, 
    NULL, NULL, 324, 'Chhloung', 'KH1001', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Hau', 'KH040403', NULL, NULL, 
    NULL, 50, 'Kampong Leaeng', 'KH0404', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Kandal', 'KH070801', NULL, 
    NULL, NULL, 2, 'Kampot', 'KH0708', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Kdei', 'KH170403', NULL, 
    NULL, NULL, 31, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Khleang', 'KH171104', NULL, 
    NULL, NULL, 210, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Kong', 'KH080403', NULL, 
    NULL, NULL, 40, 'Kaoh Thum', 'KH0804', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Kor', 'KH100303', NULL, NULL, 
    NULL, 54, 'Prek Prasab', 'KH1003', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Kou', 'KH060203', NULL, NULL, 
    NULL, 282, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Krabau', 'KH060306', NULL, 
    NULL, NULL, 6, 'Stueng Saen', 'KH0603', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Kraeng', 'KH070703', NULL, 
    NULL, NULL, 16, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Krasang', 'KH210304', NULL, 
    NULL, NULL, 69, 'Borei Cholsar', 'KH2103', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Leav', 'KH141003', NULL, 
    NULL, NULL, 18, 'Prey Veng', 'KH1410', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Lpov', 'KH020902', NULL, 
    NULL, NULL, 388, 'Samlout', 'KH0209', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Luong', 'KH080903', NULL, 
    NULL, NULL, 19, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Luong', 'KH150305', NULL, 
    NULL, NULL, 15, 'Krakor', 'KH1503', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Os', 'KH080904', NULL, NULL, 
    NULL, 69, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Ous', 'KH040203', NULL, NULL, 
    NULL, 40, 'Chol Kiri', 'KH0402', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Phluk', 'KH170904', NULL, 
    NULL, NULL, 105, 'Prasat Bakong', 
    'KH1709', 'Siemreap', 'KH17', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Phnum', 'KH080501', NULL, 
    NULL, NULL, 79, 'Leuk Daek', 'KH0805', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Popil', 'KH140801', NULL, 
    NULL, NULL, 35, 'Pea Reang', 'KH1408', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Pou', 'KH150306', NULL, NULL, 
    NULL, 75, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Pranak', 'KH130801', NULL, 
    NULL, NULL, 21, 'Preah Vihear', 'KH1308', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Prang', 'KH140803', NULL, 
    NULL, NULL, 36, 'Pea Reang', 'KH1408', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Prasat', 'KH140602', NULL, 
    NULL, NULL, 42, 'Peam Chor', 'KH1406', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Preah', 'KH020805', NULL, 
    NULL, NULL, 267, 'Sangkae', 'KH0208', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Preah Kokir', 'KH040105', 
    NULL, NULL, NULL, 60, 'Baribour', 'KH0401', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Prieng', 'KH020806', NULL, 
    NULL, NULL, 320, 'Sangkae', 'KH0208', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Reab', 'KH030801', NULL, 
    NULL, NULL, 25, 'Kaoh Soutin', 'KH0308', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Reab', 'KH210606', NULL, 
    NULL, NULL, 19, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Roteh', 'KH060303', NULL, 
    NULL, NULL, 1, 'Stueng Saen', 'KH0603', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Ruessei', 'KH141106', NULL, 
    NULL, NULL, 43, 'Pur Rieng', 'KH1411', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Samnanh', 'KH081106', NULL, 
    NULL, NULL, 3, 'Ta Khmau', 'KH0811', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Samraong', 'KH070704', NULL, 
    NULL, NULL, 7, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Seila', 'KH180402', NULL, 
    NULL, NULL, 331, 'Kampong Seila', 
    'KH1804', 'Preah Sihanouk', 'KH18', 
    'Cambodia', 'KH'
  ), 
  (
    'Kampong Soeng', 'KH140905', NULL, 
    NULL, NULL, 40, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Sralau Muoy', 'KH130207', 
    NULL, NULL, NULL, 623, 'Chhaeb', 'KH1302', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Sralau Pir', 'KH130208', 
    NULL, NULL, NULL, 199, 'Chhaeb', 'KH1302', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Svay', 'KH010602', NULL, 
    NULL, NULL, 43, 'Serei Saophoan', 
    'KH0106', 'Banteay Meanchey', 'KH01', 
    'Cambodia', 'KH'
  ), 
  (
    'Kampong Svay', 'KH060204', NULL, 
    NULL, NULL, 91, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Svay', 'KH080204', NULL, 
    NULL, NULL, 55, 'Kien Svay', 'KH0802', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Thkov', 'KH170602', NULL, 
    NULL, NULL, 15, 'Kralanh', 'KH1706', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kampong Thma', 'KH060703', NULL, 
    NULL, NULL, 53, 'Santuk', 'KH0607', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Thum', 'KH060302', NULL, 
    NULL, NULL, 7, 'Stueng Saen', 'KH0603', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Trabaek', 'KH140307', NULL, 
    NULL, NULL, 29, 'Kampong Trabaek', 
    'KH1403', 'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Trach', 'KH200408', NULL, 
    NULL, NULL, 51, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Trach Khang Kaeut', 'KH070605', 
    NULL, NULL, NULL, 16, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Trach Khang Lech', 'KH070606', 
    NULL, NULL, NULL, 78, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Kampong Tralach', 'KH040504', NULL, 
    NULL, NULL, 38, 'Kampong Tralach', 
    'KH0405', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Kampong Treas', 'KH250203', NULL, 
    NULL, NULL, 23, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Kamrieng', 'KH021201', NULL, NULL, 
    NULL, 74, 'Kamrieng', 'KH0212', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Kandaek', 'KH170906', NULL, NULL, 
    NULL, 75, 'Prasat Bakong', 'KH1709', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kandaok', 'KH080107', NULL, NULL, 
    NULL, 24, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kandaol', 'KH070705', NULL, NULL, 
    NULL, 81, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Kandaol', 'KH090102', NULL, NULL, 
    NULL, 156, 'Botum Sakor', 'KH0901', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Kandaol Chrum', 'KH250503', NULL, 
    NULL, NULL, 71, 'Ponhea Kraek', 'KH2505', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Kandaol Dom', 'KH050202', NULL, NULL, 
    NULL, 9, 'Chbar Mon', 'KH0502', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Kandieng', 'KH150203', NULL, NULL, 
    NULL, 28, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Kandieng Reay', 'KH200703', NULL, 
    NULL, NULL, 26, 'Svay Teab', 'KH2007', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Kandoeng', 'KH210204', NULL, NULL, 
    NULL, 28, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kang Cham', 'KH190503', NULL, NULL, 
    NULL, 206, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Kang Ta Noeng', 'KH030702', NULL, 
    NULL, NULL, 33, 'Kang Meas', 'KH0307', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kanhcham', 'KH140802', NULL, NULL, 
    NULL, 57, 'Pea Reang', 'KH1408', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Kanhchor', 'KH100105', NULL, NULL, 
    NULL, 94, 'Chhloung', 'KH1001', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kanhchor', 'KH150204', NULL, NULL, 
    NULL, 86, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Kanhchriech', 'KH140402', NULL, NULL, 
    NULL, 36, 'Kanhchriech', 'KH1404', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kansoam Ak', 'KH140305', NULL, NULL, 
    NULL, 41, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kantaok', 'KH120910', NULL, NULL, 
    NULL, 13, 'Pur SenChey', 'KH1209', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Kantreang', 'KH170905', NULL, NULL, 
    NULL, 28, 'Prasat Bakong', 'KH1709', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kantueu Muoy', 'KH020101', NULL, 
    NULL, NULL, 87, 'Banan', 'KH0201', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kantueu Pir', 'KH020102', NULL, NULL, 
    NULL, 33, 'Banan', 'KH0201', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Kantuot', 'KH100604', NULL, NULL, 
    NULL, 121, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kantuot', 'KH130306', NULL, NULL, 
    NULL, 332, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Kantuot', 'KH171302', NULL, NULL, 
    NULL, 853, 'Svay Leu', 'KH1713', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Andaet', 'KH031404', NULL, NULL, 
    NULL, 13, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Anlong Chen', 'KH081002', NULL, 
    NULL, NULL, 8, 'S\'ang', 'KH0810', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Chek', 'KH140603', NULL, NULL, 
    NULL, 37, 'Peam Chor', 'KH1406', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Chen', 'KH080905', NULL, NULL, 
    NULL, 35, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Chiveang', 'KH020507', NULL, 
    NULL, NULL, 447, 'Aek Phnum', 'KH0205', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Chouram', 'KH080304', NULL, 
    NULL, NULL, 17, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Chraeng', 'KH100606', NULL, 
    NULL, NULL, 16, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Chum', 'KH150210', NULL, NULL, 
    NULL, 28, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Dach', 'KH121004', NULL, NULL, 
    NULL, 22, 'Chraoy Chongvar', 'KH1210', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Kaev', 'KH080604', NULL, NULL, 
    NULL, 11, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Kapi', 'KH090302', NULL, NULL, 
    NULL, 61, 'Kaoh Kong', 'KH0903', 'Koh Kong', 
    'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Khael', 'KH081003', NULL, NULL, 
    NULL, 21, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Khnhaer', 'KH100404', NULL, 
    NULL, NULL, 217, 'Sambour', 'KH1004', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Khsach Tonlea', 'KH081004', 
    NULL, NULL, NULL, 9, 'S\'ang', 'KH0810', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Mitt', 'KH030605', NULL, NULL, 
    NULL, 19, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Oknha Tei', 'KH080305', NULL, 
    NULL, NULL, 6, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Pang', 'KH160905', NULL, NULL, 
    NULL, 368, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Peak', 'KH160906', NULL, NULL, 
    NULL, 156, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Pir', 'KH250204', NULL, NULL, 
    NULL, 10, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Pong Satv', 'KH010603', NULL, 
    NULL, NULL, 16, 'Serei Saophoan', 
    'KH0106', 'Banteay Meanchey', 'KH01', 
    'Cambodia', 'KH'
  ), 
  (
    'Kaoh Preah', 'KH190201', NULL, NULL, 
    NULL, 31, 'Siem Bouk', 'KH1902', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Reah', 'KH080605', NULL, NULL, 
    NULL, 8, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Roka', 'KH030606', NULL, NULL, 
    NULL, 19, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Roka', 'KH140604', NULL, NULL, 
    NULL, 44, 'Peam Chor', 'KH1406', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Rung', 'KH180105', NULL, NULL, 
    NULL, 102, 'Preah Sihanouk', 'KH1801', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Sampeay', 'KH190202', NULL, 
    NULL, NULL, 64, 'Siem Bouk', 'KH1902', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Sampov', 'KH140605', NULL, NULL, 
    NULL, 123, 'Peam Chor', 'KH1406', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Samraong', 'KH030607', NULL, 
    NULL, NULL, 32, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Sdach', 'KH090201', NULL, NULL, 
    NULL, 173, 'Kiri Sakor', 'KH0902', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Snaeng', 'KH190504', NULL, NULL, 
    NULL, 142, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Sotin', 'KH030802', NULL, NULL, 
    NULL, 26, 'Kaoh Soutin', 'KH0308', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Sralay', 'KH190203', NULL, NULL, 
    NULL, 87, 'Siem Bouk', 'KH1902', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Thkov', 'KH040202', NULL, NULL, 
    NULL, 113, 'Chol Kiri', 'KH0402', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Thum Ka', 'KH080404', NULL, 
    NULL, NULL, 8, 'Kaoh Thum', 'KH0804', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Thum Kha', 'KH080405', NULL, 
    NULL, NULL, 15, 'Kaoh Thum', 'KH0804', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Tontuem', 'KH030608', NULL, 
    NULL, NULL, 7, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaoh Touch', 'KH070707', NULL, NULL, 
    NULL, 837, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Kaoh Trong', 'KH100207', NULL, NULL, 
    NULL, 15, 'Kracheh', 'KH1002', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kaong Kang', 'KH250504', NULL, NULL, 
    NULL, 47, 'Ponhea Kraek', 'KH2505', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Kaos Krala', 'KH021302', NULL, NULL, 
    NULL, 27, 'Koas Krala', 'KH0213', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kat Phluk', 'KH050102', NULL, NULL, 
    NULL, 48, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Kbal Damrei', 'KH100403', NULL, NULL, 
    NULL, 623, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kbal Kaoh', 'KH121207', NULL, NULL, 
    NULL, 33, 'Chbar Ampov', 'KH1212', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Kbal Romeas', 'KH190102', NULL, NULL, 
    NULL, 738, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Kbal Trach', 'KH150307', NULL, NULL, 
    NULL, 172, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Kbal Tuek', 'KH040804', NULL, NULL, 
    NULL, 246, 'Tuek Phos', 'KH0408', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Kdanh', 'KH210607', NULL, NULL, NULL, 
    12, 'Prey Kabbas', 'KH2106', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kdei Doung', 'KH060210', NULL, NULL, 
    NULL, 20, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kdei Run', 'KH170703', NULL, NULL, 
    NULL, 35, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kdoeang Reay', 'KH140403', NULL, 
    NULL, NULL, 46, 'Kanhchriech', 'KH1404', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kdol Doun Teav', 'KH020306', NULL, 
    NULL, NULL, 9, 'Battambang', 'KH0203', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kdol Ta Haen', 'KH020406', NULL, 
    NULL, NULL, 209, 'Bavel', 'KH0204', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Kear', 'KH020602', NULL, NULL, NULL, 
    96, 'Moung Ruessei', 'KH0206', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Keh Chong', 'KH160302', NULL, NULL, 
    NULL, 105, 'Bar Kaev', 'KH1603', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Khchas', 'KH171106', NULL, NULL, NULL, 
    54, 'Soutr Nikom', 'KH1711', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khchau', 'KH030703', NULL, NULL, NULL, 
    26, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Khcheay Khang Cheung', 'KH070503', 
    NULL, NULL, NULL, 19, 'Dang Tong', 
    'KH0705', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Khcheay Khang Tboung', 'KH070504', 
    NULL, NULL, NULL, 18, 'Dang Tong', 
    'KH0705', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Khlaeng Meas', 'KH020407', NULL, 
    NULL, NULL, 175, 'Bavel', 'KH0204', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Khlong Popok', 'KH040805', NULL, 
    NULL, NULL, 109, 'Tuek Phos', 'KH0408', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Khmuonh', 'KH120803', NULL, NULL, 
    NULL, 20, 'Saensokh', 'KH1208', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Khnach Romeas', 'KH020402', NULL, 
    NULL, NULL, 75, 'Bavel', 'KH0204', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Khnang Phnum', 'KH171303', NULL, 
    NULL, NULL, 202, 'Svay Leu', 'KH1713', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khnar Chhmar', 'KH040702', NULL, 
    NULL, NULL, 28, 'Sameakki Mean Chey', 
    'KH0407', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Khnar Pou', 'KH171107', NULL, NULL, 
    NULL, 57, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khnar Sa', 'KH031403', NULL, NULL, 
    NULL, 15, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Khnar Sanday', 'KH170301', NULL, 
    NULL, NULL, 77, 'Banteay Srei', 'KH1703', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khnar Totueng', 'KH150103', NULL, 
    NULL, NULL, 54, 'Bakan', 'KH1501', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Khnat', 'KH170705', NULL, NULL, NULL, 
    24, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khnor Dambang', 'KH030301', NULL, 
    NULL, NULL, 38, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Khon Rang', 'KH040104', NULL, NULL, 
    NULL, 32, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Khpob', 'KH081001', NULL, NULL, NULL, 
    34, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Khpob Ateav', 'KH080503', NULL, NULL, 
    NULL, 39, 'Leuk Daek', 'KH0805', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Khpob Ta Nguon', 'KH031504', NULL, 
    NULL, NULL, 106, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Khsach Andeth', 'KH100106', NULL, 
    NULL, NULL, 27, 'Chhloung', 'KH1001', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Khsaetr', 'KH200203', NULL, NULL, 
    NULL, 59, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Khsam', 'KH040304', NULL, NULL, NULL, 
    13, 'Kampong Chhnang', 'KH0403', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Khsem Khsant', 'KH050504', NULL, 
    NULL, NULL, 41, 'Odongk', 'KH0505', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Khsuem', 'KH100501', NULL, NULL, NULL, 
    1001, 'Snuol', 'KH1005', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Khtum Krang', 'KH050703', NULL, NULL, 
    NULL, 72, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Khun Ream', 'KH170302', NULL, NULL, 
    NULL, 212, 'Banteay Srei', 'KH1703', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khvav', 'KH170404', NULL, NULL, NULL, 
    552, 'Chi Kraeng', 'KH1704', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Khvav', 'KH210705', NULL, NULL, NULL, 
    31, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Khvav', 'KH211004', NULL, NULL, NULL, 
    37, 'Treang', 'KH2110', 'Takeo', 'KH21', 
    'Cambodia', 'KH'
  ), 
  (
    'Khvet Thum', 'KH031304', NULL, NULL, 
    NULL, 15, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Khyang', 'KH130103', NULL, NULL, NULL, 
    103, 'Chey Saen', 'KH1301', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Kien Chrey', 'KH030603', NULL, NULL, 
    NULL, 24, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kien Sangkae', 'KH171105', NULL, 
    NULL, NULL, 35, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kilomaetr Lekh Prammuoy', 'KH120704', 
    NULL, NULL, NULL, 6, 'Russey Keo', 
    'KH1207', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Kiri Chong Kaoh', 'KH210405', NULL, 
    NULL, NULL, 28, 'Kiri Vong', 'KH2104', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kiri Voan', 'KH050604', NULL, NULL, 
    NULL, 27, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Klaeng', 'KH060603', NULL, NULL, NULL, 
    88, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Klang Hay', 'KH171202', NULL, NULL, 
    NULL, 33, 'Srei Snam', 'KH1712', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Koh Ta Suy', 'KH100304', NULL, NULL, 
    NULL, 25, 'Prek Prasab', 'KH1003', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kok Chak', 'KH171003', NULL, NULL, 
    NULL, 38, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kok Lak', 'KH160907', NULL, NULL, 
    NULL, 296, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Koki Saom', 'KH200702', NULL, NULL, 
    NULL, 63, 'Svay Teab', 'KH2007', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Kokir', 'KH080206', NULL, NULL, NULL, 
    16, 'Kien Svay', 'KH0802', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kokir', 'KH200409', NULL, NULL, NULL, 
    49, 'Romeas Haek', 'KH2004', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Kokir', 'KH250307', NULL, NULL, NULL, 
    63, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Kokir Thum', 'KH060110', NULL, NULL, 
    NULL, 164, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Kokir Thum', 'KH080207', NULL, NULL, 
    NULL, 41, 'Kien Svay', 'KH0802', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kokor', 'KH030604', NULL, NULL, NULL, 
    22, 'Kampong Siem', 'KH0306', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Komar Reachea', 'KH210205', NULL, 
    NULL, NULL, 27, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kong Chey', 'KH250404', NULL, NULL, 
    NULL, 34, 'Ou Reang Ov', 'KH2504', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Kong Noy', 'KH120516', NULL, NULL, 
    NULL, 3, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Kor', 'KH031305', NULL, NULL, NULL, 
    28, 'Prey Chhor', 'KH0313', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Kor', 'KH250707', NULL, NULL, NULL, 
    80, 'Tboung Khmum', 'KH2507', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Kou Khchak', 'KH140306', NULL, NULL, 
    NULL, 57, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kou Loab', 'KH100605', NULL, NULL, 
    NULL, 55, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Koub', 'KH010502', NULL, NULL, NULL, 
    78, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Ballangk', 'KH010204', NULL, 
    NULL, NULL, 55, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Banteay', 'KH040605', NULL, 
    NULL, NULL, 65, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Doung', 'KH170103', NULL, NULL, 
    NULL, 144, 'Angkor Chum', 'KH1701', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Kakthen', 'KH010705', NULL, 
    NULL, NULL, 132, 'Thma Puok', 'KH0107', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Khmum', 'KH020208', NULL, NULL, 
    NULL, 53, 'Thma Koul', 'KH0202', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Khpos', 'KH220203', NULL, NULL, 
    NULL, 271, 'Banteay Ampil', 'KH2202', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Kong Kaeut', 'KH140404', NULL, 
    NULL, NULL, 36, 'Kanhchriech', 'KH1404', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Kong Lech', 'KH140405', NULL, 
    NULL, NULL, 34, 'Kanhchriech', 'KH1404', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Mon', 'KH220204', NULL, NULL, 
    NULL, 270, 'Banteay Ampil', 'KH2202', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Pou', 'KH210305', NULL, NULL, 
    NULL, 45, 'Borei Cholsar', 'KH2103', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Prech', 'KH210406', NULL, NULL, 
    NULL, 80, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Pring', 'KH200509', NULL, NULL, 
    NULL, 28, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Roka', 'KH121104', NULL, NULL, 
    NULL, 33, 'Praek Pnov', 'KH1211', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Romiet', 'KH010702', NULL, NULL, 
    NULL, 226, 'Thma Puok', 'KH0107', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Rovieng', 'KH030302', NULL, 
    NULL, NULL, 26, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Kouk Srok', 'KH250103', NULL, NULL, 
    NULL, 76, 'Dambae', 'KH2501', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Thlok', 'KH210103', NULL, NULL, 
    NULL, 65, 'Angkor Borei', 'KH2101', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Thlok Kraom', 'KH170405', NULL, 
    NULL, NULL, 132, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Thlok Leu', 'KH170406', NULL, 
    NULL, NULL, 213, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kouk Trab', 'KH080109', NULL, NULL, 
    NULL, 7, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Koul', 'KH060502', NULL, NULL, NULL, 
    128, 'Prasat Sambour', 'KH0605', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Koul', 'KH170104', NULL, NULL, NULL, 
    13, 'Angkor Chum', 'KH1701', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Koun Kriel', 'KH220403', NULL, NULL, 
    NULL, 1088, 'Samraong', 'KH2204', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Koun Satv', 'KH070708', NULL, NULL, 
    NULL, 61, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Koy Maeng', 'KH010205', NULL, NULL, 
    NULL, 21, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Koy Trabaek', 'KH200603', NULL, NULL, 
    NULL, 9, 'Svay Rieng', 'KH2006', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Krabau', 'KH140204', NULL, NULL, NULL, 
    56, 'Kamchay Mear', 'KH1402', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Krabei Riel', 'KH171012', NULL, NULL, 
    NULL, 30, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kracheh', 'KH100209', NULL, NULL, 
    NULL, 4, 'Kracheh', 'KH1002', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Kraek', 'KH250505', NULL, NULL, NULL, 
    153, 'Ponhea Kraek', 'KH2505', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Krakor', 'KH100208', NULL, NULL, NULL, 
    14, 'Kracheh', 'KH1002', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Krala', 'KH030609', NULL, NULL, NULL, 
    29, 'Kampong Siem', 'KH0306', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Kralanh', 'KH170603', NULL, NULL, 
    NULL, 22, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Krang Ampil', 'KH050704', NULL, NULL, 
    NULL, 70, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Ampil', 'KH070802', NULL, NULL, 
    NULL, 2, 'Kampot', 'KH0708', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Krang Chek', 'KH050505', NULL, NULL, 
    NULL, 39, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Krang Dei Vay', 'KH050605', NULL, 
    NULL, NULL, 248, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Leav', 'KH040606', NULL, NULL, 
    NULL, 61, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Leav', 'KH210206', NULL, NULL, 
    NULL, 26, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Krang Lvea', 'KH040703', NULL, NULL, 
    NULL, 173, 'Sameakki Mean Chey', 
    'KH0407', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Krang Mkak', 'KH080807', NULL, NULL, 
    NULL, 13, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Krang Pongro', 'KH120512', NULL, 
    NULL, NULL, 7, 'Dangkao', 'KH1205', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Sbov', 'KH070306', NULL, NULL, 
    NULL, 19, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Krang Skear', 'KH040806', NULL, NULL, 
    NULL, 593, 'Tuek Phos', 'KH0408', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Snay', 'KH070307', NULL, NULL, 
    NULL, 25, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Krang Svay', 'KH140906', NULL, NULL, 
    NULL, 25, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Ta Yang', 'KH140606', NULL, 
    NULL, NULL, 32, 'Peam Chor', 'KH1406', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Teh', 'KH110401', NULL, NULL, 
    NULL, 794, 'Pech Chreada', 'KH1104', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Thnong', 'KH120807', NULL, 
    NULL, NULL, 6, 'Saensokh', 'KH1208', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Krang Thnong', 'KH210207', NULL, 
    NULL, NULL, 34, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Krang Yov', 'KH081005', NULL, NULL, 
    NULL, 51, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Kranhung', 'KH140203', NULL, NULL, 
    NULL, 67, 'Kamchay Mear', 'KH1402', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Kraol Kou', 'KH200510', NULL, NULL, 
    NULL, 43, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Krapeu Pir', 'KH150602', NULL, NULL, 
    NULL, 708, 'Veal Veaeng', 'KH1506', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Krapum Chhuk', 'KH210501', NULL, 
    NULL, NULL, 72, 'Kaoh Andaet', 'KH2105', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Krasang', 'KH200410', NULL, NULL, 
    NULL, 32, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Krasang', 'KH220303', NULL, NULL, 
    NULL, 163, 'Chong Kal', 'KH2203', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Krava', 'KH060111', NULL, NULL, NULL, 
    70, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Kraya', 'KH060402', NULL, NULL, NULL, 
    174, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Kraya', 'KH060705', NULL, NULL, NULL, 
    887, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Krouch', 'KH031306', NULL, NULL, NULL, 
    17, 'Prey Chhor', 'KH0313', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Krouch Chhmar', 'KH250205', NULL, 
    NULL, NULL, 35, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Krouch Kor', 'KH170604', NULL, NULL, 
    NULL, 31, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Kruos', 'KH200511', NULL, NULL, NULL, 
    49, 'Svay Chrum', 'KH2005', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Kuleaen Cheung', 'KH130402', NULL, 
    NULL, NULL, 342, 'Kuleaen', 'KH1304', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Kuleaen Tboung', 'KH130401', NULL, 
    NULL, NULL, 75, 'Kuleaen', 'KH1304', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Kumru', 'KH010706', NULL, NULL, NULL, 
    72, 'Thma Puok', 'KH0107', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Kus', 'KH210903', NULL, NULL, NULL, 
    49, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Kuttasat', 'KH010503', NULL, NULL, 
    NULL, 46, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'L\'ak', 'KH160607', 'Lak', NULL, NULL, 
    120, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'L\'ang', 'KH070510', 'Lang', NULL, 
    NULL, 56, 'Dang Tong', 'KH0705', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'La Minh', 'KH160303', NULL, NULL, 
    NULL, 54, 'Bar Kaev', 'KH1603', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Labansiek', 'KH160202', NULL, NULL, 
    NULL, 5, 'Ban Lung', 'KH1602', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Lbaeuk', 'KH070308', NULL, NULL, NULL, 
    106, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Lbang Muoy', 'KH160503', NULL, NULL, 
    NULL, 51, 'Lumphat', 'KH1605', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Lbang Pir', 'KH160504', NULL, NULL, 
    NULL, 34, 'Lumphat', 'KH1605', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Leach', 'KH150402', NULL, NULL, NULL, 
    21, 'Phnum Kravanh', 'KH1504', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Leang Dai', 'KH170202', NULL, NULL, 
    NULL, 89, 'Angkor Thum', 'KH1702', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Leay Bour', 'KH210904', NULL, NULL, 
    NULL, 62, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Lek Muoy', 'KH180101', NULL, NULL, 
    NULL, 46, 'Preah Sihanouk', 'KH1801', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Leuk Daek', 'KH080407', NULL, NULL, 
    NULL, 56, 'Kaoh Thum', 'KH0804', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Lngieng', 'KH250708', NULL, NULL, 
    NULL, 27, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Lolok Sa', 'KH150503', NULL, NULL, 
    NULL, 43, 'Pursat', 'KH1505', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Longveaek', 'KH040505', NULL, NULL, 
    NULL, 50, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Lum Choar', 'KH160702', NULL, NULL, 
    NULL, 78, 'Ou Ya Dav', 'KH1607', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Lumchang', 'KH210706', NULL, NULL, 
    NULL, 26, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Lumhach', 'KH080808', NULL, NULL, 
    NULL, 17, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Lumpong', 'KH210208', NULL, NULL, 
    NULL, 23, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Lumtong', 'KH220106', NULL, NULL, 
    NULL, 477, 'Anlong Veaeng', 'KH2201', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Lung Khung', 'KH160304', NULL, NULL, 
    NULL, 119, 'Bar Kaev', 'KH1603', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Lve', 'KH030803', NULL, NULL, NULL, 
    31, 'Kaoh Soutin', 'KH0308', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Lve', 'KH141203', NULL, NULL, NULL, 
    17, 'Sithor Kandal', 'KH1412', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Lvea', 'KH020403', NULL, NULL, NULL, 
    70, 'Bavel', 'KH0204', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Lvea', 'KH031307', NULL, NULL, NULL, 
    25, 'Prey Chhor', 'KH0313', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Lvea', 'KH140907', NULL, NULL, NULL, 
    29, 'Preah Sdach', 'KH1409', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Lvea', 'KH170707', NULL, NULL, NULL, 
    130, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Lvea Krang', 'KH171402', NULL, NULL, 
    NULL, 133, 'Varin', 'KH1714', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Lvea Leu', 'KH030204', NULL, NULL, 
    NULL, 29, 'Chamkar Leu', 'KH0302', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Lvea Sar', 'KH080606', NULL, NULL, 
    NULL, 10, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Lveaeng Ruessei', 'KH170407', NULL, 
    NULL, NULL, 190, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Makprang', 'KH070709', NULL, NULL, 
    NULL, 49, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Malai', 'KH010902', NULL, NULL, NULL, 
    33, 'Malai', 'KH0109', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Malik', 'KH160101', NULL, NULL, NULL, 
    131, 'Andoung Meas', 'KH1601', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Me Bon', 'KH141305', NULL, NULL, NULL, 
    23, 'Svay Antor', 'KH1413', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Me Pring', 'KH030105', NULL, NULL, 
    NULL, 41, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Me Sar Chrey', 'KH031505', NULL, 
    NULL, NULL, 38, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Me Sar Thngak', 'KH200105', NULL, 
    NULL, NULL, 27, 'Chantrea', 'KH2001', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Me Tuek', 'KH150104', NULL, NULL, 
    NULL, 265, 'Bakan', 'KH1501', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Mean Chey', 'KH020906', NULL, NULL, 
    NULL, 177, 'Samlout', 'KH0209', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Mean Chey', 'KH031405', NULL, NULL, 
    NULL, 11, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Mean Chey', 'KH050506', NULL, NULL, 
    NULL, 32, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Mean Chey', 'KH060605', NULL, NULL, 
    NULL, 146, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Mean Chey', 'KH070310', NULL, NULL, 
    NULL, 15, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Mean Chey', 'KH170907', NULL, NULL, 
    NULL, 17, 'Prasat Bakong', 'KH1709', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Mean Rith', 'KH060604', NULL, NULL, 
    NULL, 835, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Mean Ritth', 'KH070505', NULL, NULL, 
    NULL, 40, 'Dang Tong', 'KH0705', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Melum', 'KH040106', NULL, NULL, NULL, 
    52, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Memang', 'KH110102', NULL, NULL, NULL, 
    379, 'Kaev Seima', 'KH1101', 'Mondul Kiri', 
    'KH11', 'Cambodia', 'KH'
  ), 
  (
    'Memong', 'KH250308', NULL, NULL, NULL, 
    69, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Memot', 'KH250309', NULL, NULL, NULL, 
    46, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Mesar Prachan', 'KH140805', NULL, 
    NULL, NULL, 31, 'Pea Reang', 'KH1408', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Meun Chey', 'KH200306', NULL, NULL, 
    NULL, 25, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Mien', 'KH031308', NULL, NULL, NULL, 
    47, 'Prey Chhor', 'KH0313', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Mien', 'KH250405', NULL, NULL, NULL, 
    47, 'Ou Reang Ov', 'KH2504', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Mittapheap', 'KH120306', NULL, NULL, 
    NULL, 1, 'Prampir Meakkakra', 'KH1203', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Mkak', 'KH010604', NULL, NULL, NULL, 
    72, 'Serei Saophoan', 'KH0106', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Mkak', 'KH080809', NULL, NULL, NULL, 
    30, 'Angk Snuol', 'KH0808', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Mlu Prey Muoy', 'KH130205', NULL, 
    NULL, NULL, 333, 'Chhaeb', 'KH1302', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Mlu Prey Pir', 'KH130206', NULL, 
    NULL, NULL, 90, 'Chhaeb', 'KH1302', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Moha Khnhoung', 'KH030805', NULL, 
    NULL, NULL, 24, 'Kaoh Soutin', 'KH0308', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Moha Leaph', 'KH030804', NULL, NULL, 
    NULL, 15, 'Kaoh Soutin', 'KH0308', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Moha Ruessei', 'KH050303', NULL, 
    NULL, NULL, 20, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Moha Sang', 'KH050606', NULL, NULL, 
    NULL, 51, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Mong Riev', 'KH250709', NULL, NULL, 
    NULL, 32, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Monourom', 'KH050802', NULL, NULL, 
    NULL, 23, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Monourom', 'KH110501', NULL, NULL, 
    NULL, 79, 'Saen Monourom', 'KH1105', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Monourom', 'KH120305', NULL, NULL, 
    NULL, 0, 'Prampir Meakkakra', 'KH1203', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Monourom', 'KH200704', NULL, NULL, 
    NULL, 17, 'Svay Teab', 'KH2007', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Morokot', 'KH130308', NULL, NULL, 
    NULL, 462, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Moung', 'KH020601', NULL, NULL, NULL, 
    51, 'Moung Ruessei', 'KH0206', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Moung', 'KH171204', NULL, NULL, NULL, 
    86, 'Srei Snam', 'KH1712', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Mream', 'KH200412', NULL, NULL, NULL, 
    58, 'Romeas Haek', 'KH2004', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Mroum', 'KH070107', NULL, NULL, NULL, 
    18, 'Angkor Chey', 'KH0701', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Msa Krang', 'KH060806', NULL, NULL, 
    NULL, 183, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Mukh Da', 'KH200411', NULL, NULL, 
    NULL, 29, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Mukh Paen', 'KH170708', NULL, NULL, 
    NULL, 137, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Mukh Reah', 'KH021403', NULL, NULL, 
    NULL, 83, 'Rukh Kiri', 'KH0214', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Nam Tau', 'KH010301', NULL, NULL, 
    NULL, 186, 'Phnum Srok', 'KH0103', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Nang Khi Lik', 'KH110201', NULL, 
    NULL, NULL, 431, 'Kaoh Nheaek', 'KH1102', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Neak Loeang', 'KH140703', NULL, NULL, 
    NULL, 18, 'Peam Ro', 'KH1407', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Neang Teut', 'KH250104', NULL, NULL, 
    NULL, 21, 'Dambae', 'KH2501', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Neareay', 'KH070311', NULL, NULL, 
    NULL, 18, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Ngan', 'KH060606', NULL, NULL, NULL, 
    136, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Nhaeng Nhang', 'KH210905', NULL, 
    NULL, NULL, 26, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Nhang', 'KH160103', NULL, NULL, NULL, 
    505, 'Andoung Meas', 'KH1601', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Nhor', 'KH200202', NULL, NULL, NULL, 
    26, 'Kampong Rou', 'KH2002', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Nimitt', 'KH011001', NULL, NULL, NULL, 
    169, 'Paoy Paet', 'KH0110', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Nipech', 'KH060205', NULL, NULL, NULL, 
    88, 'Kampong Svay', 'KH0602', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Nirouth', 'KH121203', NULL, NULL, 
    NULL, 10, 'Chbar Ampov', 'KH1212', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Nitean', 'KH050103', NULL, NULL, NULL, 
    30, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Nokor Pheas', 'KH170105', NULL, NULL, 
    NULL, 54, 'Angkor Chum', 'KH1701', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Nokor Thum', 'KH171005', NULL, NULL, 
    NULL, 55, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Norea', 'KH020802', NULL, NULL, NULL, 
    7, 'Sangkae', 'KH0208', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Olympic', 'KH120105', NULL, NULL, 
    NULL, 0, 'Chamkar Mon', 'KH1201', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Omal', 'KH020307', NULL, NULL, NULL, 
    38, 'Battambang', 'KH0203', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Otdam Soriya', 'KH210908', NULL, 
    NULL, NULL, 28, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Ou', 'KH050607', NULL, NULL, NULL, 
    49, 'Phnum Sruoch', 'KH0506', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Ou Ambel', 'KH010605', NULL, NULL, 
    NULL, 33, 'Serei Saophoan', 'KH0106', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Andoung', 'KH240204', NULL, NULL, 
    NULL, 181, 'Sala Krau', 'KH2402', 
    'Pailin', 'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Ou Bak Roteh', 'KH180403', NULL, 
    NULL, NULL, 457, 'Kampong Seila', 
    'KH1804', 'Preah Sihanouk', 'KH18', 
    'Cambodia', 'KH'
  ), 
  (
    'Ou Beichoan', 'KH010509', NULL, NULL, 
    NULL, 91, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ou Char', 'KH020309', NULL, NULL, 
    NULL, 12, 'Battambang', 'KH0203', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Chrov', 'KH180205', NULL, NULL, 
    NULL, 20, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Ou Chum', 'KH160605', NULL, NULL, 
    NULL, 119, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Ou Da', 'KH021203', NULL, NULL, NULL, 
    112, 'Kamrieng', 'KH0212', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ou Dambang Muoy', 'KH020808', NULL, 
    NULL, NULL, 25, 'Sangkae', 'KH0208', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Dambang Pir', 'KH020809', NULL, 
    NULL, NULL, 31, 'Sangkae', 'KH0208', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Kanthor', 'KH060304', NULL, NULL, 
    NULL, 47, 'Stueng Saen', 'KH0603', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Krasar', 'KH230203', NULL, NULL, 
    NULL, 15, 'Kaeb', 'KH2302', 'Kep', 
    'KH23', 'Cambodia', 'KH'
  ), 
  (
    'Ou Krieng', 'KH100405', NULL, NULL, 
    NULL, 1014, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Ou Mlu', 'KH031506', NULL, NULL, NULL, 
    144, 'Stueng Trang', 'KH0315', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Ou Mreah', 'KH190204', NULL, NULL, 
    NULL, 100, 'Siem Bouk', 'KH1902', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Oknha Heng', 'KH180206', NULL, 
    NULL, NULL, 71, 'Prey Nob', 'KH1802', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Prasat', 'KH010206', NULL, NULL, 
    NULL, 39, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Rai', 'KH190506', NULL, NULL, NULL, 
    147, 'Thala Barivat', 'KH1905', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Ou Ruessei', 'KH040506', NULL, NULL, 
    NULL, 20, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Ruessei', 'KH100210', NULL, NULL, 
    NULL, 32, 'Kracheh', 'KH1002', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Ou Ruessei Kandal', 'KH190205', 
    NULL, NULL, NULL, 32, 'Siem Bouk', 
    'KH1902', 'Stung Treng', 'KH19', 
    'Cambodia', 'KH'
  ), 
  (
    'Ou Ruessei Ti Bei', 'KH120303', 
    NULL, NULL, NULL, 0, 'Prampir Meakkakra', 
    'KH1203', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Ruessei Ti Buon', 'KH120304', 
    NULL, NULL, NULL, 0, 'Prampir Meakkakra', 
    'KH1203', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Ruessei Ti Muoy', 'KH120301', 
    NULL, NULL, NULL, 0, 'Prampir Meakkakra', 
    'KH1203', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Ruessei Ti Pir', 'KH120302', 
    NULL, NULL, NULL, 0, 'Prampir Meakkakra', 
    'KH1203', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Rumduol', 'KH021105', NULL, NULL, 
    NULL, 221, 'Phnum Proek', 'KH0211', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Sampoar', 'KH010903', NULL, NULL, 
    NULL, 89, 'Malai', 'KH0109', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ou Samril', 'KH020903', NULL, NULL, 
    NULL, 139, 'Samlout', 'KH0209', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ou Sandan', 'KH150308', NULL, NULL, 
    NULL, 85, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ou Saom', 'KH150601', NULL, NULL, 
    NULL, 1328, 'Veal Veaeng', 'KH1506', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ou Saray', 'KH210906', NULL, NULL, 
    NULL, 61, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Ou Smach', 'KH220405', NULL, NULL, 
    NULL, 20, 'Samraong', 'KH2204', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Ou Sralau', 'KH010904', NULL, NULL, 
    NULL, 53, 'Malai', 'KH0109', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ou Svay', 'KH030610', NULL, NULL, 
    NULL, 30, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Svay', 'KH190507', NULL, NULL, 
    NULL, 117, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Svay', 'KH220503', NULL, NULL, 
    NULL, 162, 'Trapeang Prasat', 'KH2205', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Ta Ki', 'KH020203', NULL, NULL, 
    NULL, 102, 'Thma Koul', 'KH0202', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ou Ta Paong', 'KH150105', NULL, NULL, 
    NULL, 292, 'Bakan', 'KH1501', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ou Ta Vau', 'KH240102', NULL, NULL, 
    NULL, 202, 'Pailin', 'KH2401', 'Pailin', 
    'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Ou Treh', 'KH180302', NULL, NULL, 
    NULL, 77, 'Stueng Hav', 'KH1803', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Ovlaok', 'KH120911', NULL, NULL, NULL, 
    16, 'Pur SenChey', 'KH1209', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Pa Kalan', 'KH160908', NULL, NULL, 
    NULL, 190, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Pa Te', 'KH160704', NULL, NULL, NULL, 
    476, 'Ou Ya Dav', 'KH1607', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Pailin', 'KH240101', NULL, NULL, NULL, 
    136, 'Pailin', 'KH2401', 'Pailin', 
    'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Pak Khlang', 'KH090501', NULL, NULL, 
    NULL, 1365, 'Mondol Seima', 'KH0905', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Pak Nhai', 'KH160703', NULL, NULL, 
    NULL, 206, 'Ou Ya Dav', 'KH1607', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Pal Hal', 'KH130802', NULL, NULL, 
    NULL, 264, 'Preah Vihear', 'KH1308', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Paoy Paet', 'KH011002', NULL, NULL, 
    NULL, 22, 'Paoy Paet', 'KH0110', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Pdau Chum', 'KH030303', NULL, NULL, 
    NULL, 39, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Pea Ream', 'KH210209', NULL, NULL, 
    NULL, 20, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Peak Snaeng', 'KH170203', NULL, NULL, 
    NULL, 132, 'Angkor Thum', 'KH1702', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Peam', 'KH040704', NULL, NULL, NULL, 
    101, 'Sameakki Mean Chey', 'KH0407', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Aek', 'KH020505', NULL, NULL, 
    NULL, 95, 'Aek Phnum', 'KH0205', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Peam Bang', 'KH060807', NULL, NULL, 
    NULL, 244, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Peam Chhkaok', 'KH040204', NULL, 
    NULL, NULL, 96, 'Chol Kiri', 'KH0402', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Chi Kang', 'KH030704', NULL, 
    NULL, NULL, 21, 'Kang Meas', 'KH0307', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Chileang', 'KH250710', NULL, 
    NULL, NULL, 55, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Kaoh Snar', 'KH031507', NULL, 
    NULL, NULL, 46, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Krasaob', 'KH090502', NULL, 
    NULL, NULL, 46, 'Mondol Seima', 'KH0905', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Peam Mean Chey', 'KH140704', NULL, 
    NULL, NULL, 34, 'Peam Ro', 'KH1407', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Montear', 'KH140308', NULL, 
    NULL, NULL, 71, 'Kampong Trabaek', 
    'KH1403', 'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Oknha Ong', 'KH080607', NULL, 
    NULL, NULL, 15, 'Lvea Aem', 'KH0806', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Peam Prathnuoh', 'KH030806', NULL, 
    NULL, NULL, 20, 'Kaoh Soutin', 'KH0308', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Peam Reang', 'KH080504', NULL, NULL, 
    NULL, 51, 'Leuk Daek', 'KH0805', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Peam Ro', 'KH140705', NULL, NULL, 
    NULL, 17, 'Peam Ro', 'KH1407', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Pean Roung', 'KH141306', NULL, NULL, 
    NULL, 61, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Peang Lvea', 'KH050514', NULL, NULL, 
    NULL, 33, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Peani', 'KH040507', NULL, NULL, NULL, 
    22, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Pech Changvar', 'KH040108', NULL, 
    NULL, NULL, 56, 'Baribour', 'KH0401', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Pech Chenda', 'KH021102', NULL, NULL, 
    NULL, 138, 'Phnum Proek', 'KH0211', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Pech Sar', 'KH210502', NULL, NULL, 
    NULL, 56, 'Kaoh Andaet', 'KH2105', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Pechr Muni', 'KH050304', NULL, NULL, 
    NULL, 16, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Peuk', 'KH080811', NULL, NULL, NULL, 
    14, 'Angk Snuol', 'KH0808', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Peus Muoy', 'KH250206', NULL, NULL, 
    NULL, 27, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Peus Pir', 'KH250207', NULL, NULL, 
    NULL, 35, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Ph\'av', 'KH030106', 'Phav', NULL, 
    NULL, 16, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Ph\'av', 'KH220502', 'Phav', NULL, 
    NULL, 471, 'Trapeang Prasat', 'KH2205', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Phan Nheum', 'KH060403', NULL, NULL, 
    NULL, 111, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Phat Sanday', 'KH060206', NULL, NULL, 
    NULL, 226, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Pheakdei', 'KH050104', NULL, NULL, 
    NULL, 40, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Pheari Mean Chey', 'KH050105', NULL, 
    NULL, NULL, 21, 'Basedth', 'KH0501', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Phkoam', 'KH010801', NULL, NULL, NULL, 
    89, 'Svay Chek', 'KH0108', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Phleung Chheh Roteh', 'KH120903', 
    NULL, NULL, NULL, 10, 'Pur SenChey', 
    'KH1209', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phlov Meas', 'KH020703', NULL, NULL, 
    NULL, 117, 'Rotonak Mondol', 'KH0207', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Phlov Tuk', 'KH040404', NULL, NULL, 
    NULL, 193, 'Kampong Leaeng', 'KH0404', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Phluk', 'KH190103', NULL, NULL, NULL, 
    356, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Phnhi Meas', 'KH090202', NULL, NULL, 
    NULL, 216, 'Kiri Sakor', 'KH0902', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Phniet', 'KH010606', NULL, NULL, NULL, 
    41, 'Serei Saophoan', 'KH0106', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Phnom Penh Thmei', 'KH120801', NULL, 
    NULL, NULL, 21, 'Saensokh', 'KH1208', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phnom Prasat', 'KH070608', NULL, 
    NULL, NULL, 19, 'Kampong Trach', 'KH0706', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Phnom Touch', 'KH050515', NULL, NULL, 
    NULL, 44, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Phnum Bat', 'KH080906', NULL, NULL, 
    NULL, 33, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Phnum Dei', 'KH010306', NULL, NULL, 
    NULL, 60, 'Phnum Srok', 'KH0103', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Phnum Den', 'KH210407', NULL, NULL, 
    NULL, 20, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Phnum Kok', 'KH160909', NULL, NULL, 
    NULL, 189, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Phnum Kong', 'KH070108', NULL, NULL, 
    NULL, 35, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Phnum Lieb', 'KH010403', NULL, NULL, 
    NULL, 248, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Phnum Penh', 'KH130404', NULL, NULL, 
    NULL, 97, 'Kuleaen', 'KH1304', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Phnum Proek', 'KH021101', NULL, NULL, 
    NULL, 173, 'Phnum Proek', 'KH0211', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Phnum Sampov', 'KH020106', NULL, 
    NULL, NULL, 64, 'Banan', 'KH0201', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Phnum Tbaeng Muoy', 'KH130603', 
    NULL, NULL, NULL, 144, 'Sangkum Thmei', 
    'KH1306', 'Preah Vihear', 'KH13', 
    'Cambodia', 'KH'
  ), 
  (
    'Phnum Tbaeng Pir', 'KH130405', NULL, 
    NULL, NULL, 285, 'Kuleaen', 'KH1304', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Phnum Touch', 'KH010207', NULL, NULL, 
    NULL, 48, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Phong', 'KH050106', NULL, NULL, NULL, 
    23, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Phsar', 'KH040107', NULL, NULL, NULL, 
    36, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Phsar Chas', 'KH120209', NULL, NULL, 
    NULL, 0, 'Doun Penh', 'KH1202', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Phsar Chhnang', 'KH040301', NULL, 
    NULL, NULL, 11, 'Kampong Chhnang', 
    'KH0403', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Phsar Daek', 'KH080911', NULL, NULL, 
    NULL, 15, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Phsar Daeum Kor', 'KH120409', NULL, 
    NULL, NULL, 1, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Daeum Thkov', 'KH120112', 
    NULL, NULL, NULL, 1, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Depou Ti Bei', 'KH120403', 
    NULL, NULL, NULL, 0, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Depou Ti Muoy', 'KH120401', 
    NULL, NULL, NULL, 0, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Depou Ti Pir', 'KH120402', 
    NULL, NULL, NULL, 0, 'Tuol Kouk', 'KH1204', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Kandal', 'KH011003', NULL, 
    NULL, NULL, 74, 'Paoy Paet', 'KH0110', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Kandal Ti Muoy', 'KH120205', 
    NULL, NULL, NULL, 0, 'Doun Penh', 'KH1202', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Kandal Ti Pir', 'KH120206', 
    NULL, NULL, NULL, 0, 'Doun Penh', 'KH1202', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Thmei Ti Bei', 'KH120203', 
    NULL, NULL, NULL, 0, 'Doun Penh', 'KH1202', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Thmei Ti Muoy', 'KH120201', 
    NULL, NULL, NULL, 0, 'Doun Penh', 'KH1202', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phsar Thmei Ti Pir', 'KH120202', 
    NULL, NULL, NULL, 0, 'Doun Penh', 'KH1202', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Phteah Kandal', 'KH031406', NULL, 
    NULL, NULL, 25, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Phteah Prey', 'KH150504', NULL, NULL, 
    NULL, 13, 'Pursat', 'KH1505', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Phteah Rung', 'KH150403', NULL, NULL, 
    NULL, 156, 'Phnum Kravanh', 'KH1504', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Phum Thmei', 'KH010703', NULL, NULL, 
    NULL, 66, 'Thma Puok', 'KH0107', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Phum Thum', 'KH080208', NULL, NULL, 
    NULL, 16, 'Kien Svay', 'KH0802', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Phum Thum', 'KH080608', NULL, NULL, 
    NULL, 25, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Pir', 'KH180102', NULL, NULL, NULL, 
    2, 'Preah Sihanouk', 'KH1801', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Pir Thnu', 'KH100502', NULL, NULL, 
    NULL, 588, 'Snuol', 'KH1005', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Pneay', 'KH050705', NULL, NULL, NULL, 
    30, 'Samraong Tong', 'KH0507', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Pnov', 'KH060706', NULL, NULL, NULL, 
    108, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Pnov Ti Muoy', 'KH141204', NULL, 
    NULL, NULL, 36, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Pnov Ti Pir', 'KH141205', NULL, NULL, 
    NULL, 31, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Pong', 'KH160901', NULL, NULL, NULL, 
    67, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Pong Tuek', 'KH120507', NULL, NULL, 
    NULL, 11, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Pong Tuek', 'KH200307', NULL, NULL, 
    NULL, 38, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Pong Tuek', 'KH230103', NULL, NULL, 
    NULL, 34, 'Damnak Chang\'aeur', 'KH2301', 
    'Kep', 'KH23', 'Cambodia', 'KH'
  ), 
  (
    'Pongro', 'KH030807', NULL, NULL, NULL, 
    8, 'Kaoh Soutin', 'KH0308', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Pongro', 'KH040607', NULL, NULL, NULL, 
    28, 'Rolea B\'ier', 'KH0406', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Pongro', 'KH060113', NULL, NULL, NULL, 
    53, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Pongro', 'KH100107', NULL, NULL, NULL, 
    22, 'Chhloung', 'KH1001', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Pongro', 'KH220304', NULL, NULL, NULL, 
    293, 'Chong Kal', 'KH2203', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Pongro Kraom', 'KH170408', NULL, 
    NULL, NULL, 124, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Pongro Leu', 'KH170409', NULL, NULL, 
    NULL, 384, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ponhea Lueu', 'KH080907', NULL, NULL, 
    NULL, 10, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ponhea Pon', 'KH121102', NULL, NULL, 
    NULL, 19, 'Praek Pnov', 'KH1211', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Ponley', 'KH010303', NULL, NULL, NULL, 
    120, 'Phnum Srok', 'KH0103', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ponley', 'KH040110', NULL, NULL, NULL, 
    6, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Ponley', 'KH210104', NULL, NULL, NULL, 
    54, 'Angkor Borei', 'KH2101', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Ponsang', 'KH121105', NULL, NULL, 
    NULL, 38, 'Praek Pnov', 'KH1211', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Popeaet', 'KH200705', NULL, NULL, 
    NULL, 42, 'Svay Teab', 'KH2007', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Popel', 'KH040109', NULL, NULL, NULL, 
    28, 'Baribour', 'KH0401', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Popel', 'KH171108', NULL, NULL, NULL, 
    75, 'Soutr Nikom', 'KH1711', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Popel', 'KH210909', NULL, NULL, NULL, 
    23, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Popel', 'KH250506', NULL, NULL, NULL, 
    36, 'Ponhea Kraek', 'KH2505', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Popok', 'KH060808', NULL, NULL, NULL, 
    314, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Popueus', 'KH141307', NULL, NULL, 
    NULL, 24, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Pot Sar', 'KH210210', NULL, NULL, 
    NULL, 38, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Pou', 'KH040405', NULL, NULL, NULL, 
    91, 'Kampong Leaeng', 'KH0404', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Pou', 'KH130704', NULL, NULL, NULL, 
    124, 'Tbaeng Mean Chey', 'KH1307', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Pou Angkrang', 'KH050107', NULL, 
    NULL, NULL, 33, 'Basedth', 'KH0501', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Pou Chamraeun', 'KH050108', NULL, 
    NULL, NULL, 28, 'Basedth', 'KH0501', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Pou Mreal', 'KH050109', NULL, NULL, 
    NULL, 49, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Pou Rieng', 'KH141101', NULL, NULL, 
    NULL, 61, 'Pur Rieng', 'KH1411', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Pou Rumchak', 'KH210608', NULL, NULL, 
    NULL, 26, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Pou Ta Hao', 'KH200604', NULL, NULL, 
    NULL, 2, 'Svay Rieng', 'KH2006', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Pou Ti', 'KH141206', NULL, NULL, NULL, 
    17, 'Sithor Kandal', 'KH1412', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Pou Treay', 'KH170709', NULL, NULL, 
    NULL, 75, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Pouthi Ban', 'KH080408', NULL, NULL, 
    NULL, 69, 'Kaoh Thum', 'KH0804', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Pouthi Reach', 'KH200512', NULL, 
    NULL, NULL, 22, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Pouy', 'KH160602', NULL, NULL, NULL, 
    107, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Poy Char', 'KH010302', NULL, NULL, 
    NULL, 246, 'Phnum Srok', 'KH0103', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Pralay', 'KH060809', NULL, NULL, NULL, 
    220, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Pralay', 'KH090702', NULL, NULL, NULL, 
    764, 'Thma Bang', 'KH0907', 'Koh Kong', 
    'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Pralay Meas', 'KH040406', NULL, NULL, 
    NULL, 102, 'Kampong Leaeng', 'KH0404', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Pram Yam', 'KH031407', NULL, NULL, 
    NULL, 37, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Pramaoy', 'KH150604', NULL, NULL, 
    NULL, 862, 'Veal Veaeng', 'KH1506', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Prambei Mum', 'KH050804', NULL, NULL, 
    NULL, 140, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Prambei Mum', 'KH211005', NULL, NULL, 
    NULL, 22, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prame', 'KH130705', NULL, NULL, NULL, 
    257, 'Tbaeng Mean Chey', 'KH1307', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Praphnum', 'KH070109', NULL, NULL, 
    NULL, 26, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Prasat', 'KH010404', NULL, NULL, NULL, 
    194, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Prasat', 'KH060707', NULL, NULL, NULL, 
    50, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Prasat', 'KH081006', NULL, NULL, NULL, 
    85, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Prasat', 'KH140309', NULL, NULL, NULL, 
    32, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prasat', 'KH171401', NULL, NULL, NULL, 
    168, 'Varin', 'KH1714', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Prasat', 'KH200804', NULL, NULL, NULL, 
    27, 'Bavet', 'KH2008', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Prasat Phnom Khyang', 'KH070607', 
    NULL, NULL, NULL, 9, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Prasnoeb', 'KH040608', NULL, NULL, 
    NULL, 126, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Prasoutr', 'KH200707', NULL, NULL, 
    NULL, 35, 'Svay Teab', 'KH2007', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Prateah Lang', 'KH120513', NULL, 
    NULL, NULL, 9, 'Dangkao', 'KH1205', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Pratheat', 'KH140310', NULL, NULL, 
    NULL, 28, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek A Chi', 'KH250208', NULL, 
    NULL, NULL, 44, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Aeng', 'KH121206', NULL, NULL, 
    NULL, 8, 'Chbar Ampov', 'KH1212', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Ambel', 'KH081007', NULL, 
    NULL, NULL, 51, 'S\'ang', 'KH0810', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Ampil', 'KH080307', NULL, 
    NULL, NULL, 30, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Anhchanh', 'KH080703', NULL, 
    NULL, NULL, 43, 'Mukh Kampul', 'KH0807', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Anteah', 'KH141102', NULL, 
    NULL, NULL, 27, 'Pur Rieng', 'KH1411', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Bak', 'KH031509', NULL, NULL, 
    NULL, 23, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Changkran', 'KH141207', NULL, 
    NULL, NULL, 8, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Chik', 'KH021401', NULL, NULL, 
    NULL, 101, 'Rukh Kiri', 'KH0214', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Chrey', 'KH141103', NULL, 
    NULL, NULL, 32, 'Pur Rieng', 'KH1411', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Dach', 'KH080505', NULL, NULL, 
    NULL, 62, 'Leuk Daek', 'KH0805', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Dambang', 'KH080704', NULL, 
    NULL, NULL, 18, 'Mukh Kampul', 'KH0807', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Dambouk', 'KH031408', NULL, 
    NULL, NULL, 26, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Kampues', 'KH120517', NULL, 
    NULL, NULL, 11, 'Dangkao', 'KH1205', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Khpob', 'KH020503', NULL, 
    NULL, NULL, 27, 'Aek Phnum', 'KH0205', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Khsach', 'KH090203', NULL, 
    NULL, NULL, 290, 'Kiri Sakor', 'KH0902', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Khsay Ka', 'KH140706', NULL, 
    NULL, NULL, 6, 'Peam Ro', 'KH1407', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Khsay Kha', 'KH140707', NULL, 
    NULL, NULL, 4, 'Peam Ro', 'KH1407', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Kmeng', 'KH080609', NULL, 
    NULL, NULL, 20, 'Lvea Aem', 'KH0806', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Koy', 'KH030705', NULL, NULL, 
    NULL, 44, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Koy', 'KH081008', NULL, NULL, 
    NULL, 15, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Krabau', 'KH030706', NULL, 
    NULL, NULL, 45, 'Kang Meas', 'KH0307', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Krabau', 'KH140607', NULL, 
    NULL, NULL, 16, 'Peam Chor', 'KH1406', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Kroes', 'KH070612', NULL, 
    NULL, NULL, 33, 'Kampong Trach', 'KH0706', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Lieb', 'KH121002', NULL, NULL, 
    NULL, 14, 'Chraoy Chongvar', 'KH1210', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Luong', 'KH020504', NULL, 
    NULL, NULL, 64, 'Aek Phnum', 'KH0205', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Luong', 'KH080308', NULL, 
    NULL, NULL, 14, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Meas', 'KH190301', NULL, NULL, 
    NULL, 749, 'Siem Pang', 'KH1903', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Norint', 'KH020501', NULL, 
    NULL, NULL, 91, 'Aek Phnum', 'KH0205', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Phnov', 'KH121101', NULL, 
    NULL, NULL, 7, 'Praek Pnov', 'KH1211', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Phtoul', 'KH210105', NULL, 
    NULL, NULL, 43, 'Angkor Borei', 'KH2101', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Pou', 'KH031409', NULL, NULL, 
    NULL, 27, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Pra', 'KH121204', NULL, NULL, 
    NULL, 6, 'Chbar Ampov', 'KH1212', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Prasab', 'KH100305', NULL, 
    NULL, NULL, 188, 'Prek Prasab', 'KH1003', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Rey', 'KH080610', NULL, NULL, 
    NULL, 15, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Roka', 'KH080115', NULL, NULL, 
    NULL, 11, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Ruessei', 'KH080611', NULL, 
    NULL, NULL, 23, 'Lvea Aem', 'KH0806', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Rumdeng', 'KH031410', NULL, 
    NULL, NULL, 45, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Saman', 'KH100108', NULL, 
    NULL, NULL, 92, 'Chhloung', 'KH1001', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Sambuor', 'KH140608', NULL, 
    NULL, NULL, 24, 'Peam Chor', 'KH1406', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Sdei', 'KH080410', NULL, NULL, 
    NULL, 53, 'Kaoh Thum', 'KH0804', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Slaeng', 'KH080116', NULL, 
    NULL, NULL, 11, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Ta Kov', 'KH080309', NULL, 
    NULL, NULL, 20, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Ta Meak', 'KH080310', NULL, 
    NULL, NULL, 23, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Ta Nong', 'KH030808', NULL, 
    NULL, NULL, 38, 'Kaoh Soutin', 'KH0308', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Ta Sar', 'KH141107', NULL, 
    NULL, NULL, 39, 'Pur Rieng', 'KH1411', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Ta Sek', 'KH121003', NULL, 
    NULL, NULL, 15, 'Chraoy Chongvar', 
    'KH1210', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Ta Teaen', 'KH080910', NULL, 
    NULL, NULL, 10, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Thmei', 'KH080411', NULL, 
    NULL, NULL, 32, 'Kaoh Thum', 'KH0804', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Thmei', 'KH121208', NULL, 
    NULL, NULL, 20, 'Chbar Ampov', 'KH1212', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Preaek Tnoat', 'KH070711', NULL, 
    NULL, NULL, 70, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Preaek Tonloab', 'KH080506', NULL, 
    NULL, NULL, 79, 'Leuk Daek', 'KH0805', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preah Andoung', 'KH031508', NULL, 
    NULL, NULL, 6, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Bat', 'KH190403', NULL, NULL, 
    NULL, 55, 'Stueng Traeng', 'KH1904', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Bat Choan Chum', 'KH210402', 
    NULL, NULL, NULL, 52, 'Kiri Vong', 
    'KH2104', 'Takeo', 'KH21', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Dak', 'KH170303', NULL, NULL, 
    NULL, 49, 'Banteay Srei', 'KH1703', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Preah Damrei', 'KH060810', NULL, 
    NULL, NULL, 14, 'Stoung', 'KH0608', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Khae', 'KH050115', NULL, NULL, 
    NULL, 39, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Preah Khleang', 'KH130706', NULL, 
    NULL, NULL, 122, 'Tbaeng Mean Chey', 
    'KH1307', 'Preah Vihear', 'KH13', 
    'Cambodia', 'KH'
  ), 
  (
    'Preah Nipean', 'KH050305', NULL, 
    NULL, NULL, 31, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Phos', 'KH021304', NULL, NULL, 
    NULL, 141, 'Koas Krala', 'KH0213', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Ponlea', 'KH010607', NULL, 
    NULL, NULL, 14, 'Serei Saophoan', 
    'KH0106', 'Banteay Meanchey', 'KH01', 
    'Cambodia', 'KH'
  ), 
  (
    'Preah Ponlea', 'KH200204', NULL, 
    NULL, NULL, 28, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Pralay', 'KH220504', NULL, 
    NULL, NULL, 68, 'Trapeang Prasat', 
    'KH2205', 'Oddar Meanchey', 'KH22', 
    'Cambodia', 'KH'
  ), 
  (
    'Preah Prasab', 'KH080306', NULL, 
    NULL, NULL, 12, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preah Putth', 'KH080113', NULL, NULL, 
    NULL, 10, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Preah Rumkel', 'KH190508', NULL, 
    NULL, NULL, 357, 'Thala Barivat', 
    'KH1905', 'Stung Treng', 'KH19', 
    'Cambodia', 'KH'
  ), 
  (
    'Preah Sdach', 'KH140908', NULL, NULL, 
    NULL, 55, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Preah Srae', 'KH050507', NULL, NULL, 
    NULL, 35, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Preah Theat', 'KH250406', NULL, NULL, 
    NULL, 81, 'Ou Reang Ov', 'KH2504', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Preak Kak', 'KH031510', NULL, NULL, 
    NULL, 175, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Preak Netr Preah', 'KH010405', NULL, 
    NULL, NULL, 118, 'Preah Netr Preah', 
    'KH0104', 'Banteay Meanchey', 'KH01', 
    'Cambodia', 'KH'
  ), 
  (
    'Preal', 'KH140406', NULL, NULL, NULL, 
    67, 'Kanhchriech', 'KH1404', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'PreaΓÇïek Chrey', 'KH080409', 
    'PreaCiek Chrey', NULL, NULL, 59, 
    'Kaoh Thum', 'KH0804', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Prei', 'KH171205', NULL, NULL, NULL, 
    46, 'Srei Snam', 'KH1712', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Prek Ho', 'KH081105', NULL, NULL, 
    NULL, 10, 'Ta Khmau', 'KH0811', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Prek Preah Sdach', 'KH020302', NULL, 
    NULL, NULL, 3, 'Battambang', 'KH0203', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Prek Ruessey', 'KH081102', NULL, 
    NULL, NULL, 2, 'Ta Khmau', 'KH0811', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Prey Ampok', 'KH210408', NULL, NULL, 
    NULL, 48, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Angkunh', 'KH200805', NULL, 
    NULL, NULL, 21, 'Bavet', 'KH2008', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Char', 'KH030304', NULL, NULL, 
    NULL, 24, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Chas', 'KH020506', NULL, NULL, 
    NULL, 324, 'Aek Phnum', 'KH0205', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Chhlak', 'KH200602', NULL, NULL, 
    NULL, 5, 'Svay Rieng', 'KH2006', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Prey Chhor', 'KH031309', NULL, NULL, 
    NULL, 10, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Chhor', 'KH140311', NULL, NULL, 
    NULL, 28, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Chruk', 'KH170711', NULL, NULL, 
    NULL, 120, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Prey Daeum Thnoeng', 'KH141208', 
    NULL, NULL, NULL, 22, 'Sithor Kandal', 
    'KH1412', 'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Kabbas', 'KH210609', NULL, NULL, 
    NULL, 22, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Kandieng', 'KH140708', NULL, 
    NULL, NULL, 45, 'Peam Ro', 'KH1407', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Kanlaong', 'KH141104', NULL, 
    NULL, NULL, 39, 'Pur Rieng', 'KH1411', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Khla', 'KH141308', NULL, NULL, 
    NULL, 44, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Khla', 'KH210503', NULL, NULL, 
    NULL, 72, 'Kaoh Andaet', 'KH2105', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Khmum', 'KH070712', NULL, NULL, 
    NULL, 23, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Prey Khnes', 'KH140504', NULL, NULL, 
    NULL, 55, 'Me Sang', 'KH1405', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Prey Khpos', 'KH020404', NULL, NULL, 
    NULL, 139, 'Bavel', 'KH0204', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Prey Kmeng', 'KH050609', NULL, NULL, 
    NULL, 54, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Kokir', 'KH200108', NULL, NULL, 
    NULL, 41, 'Chantrea', 'KH2001', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Prey Krasang', 'KH050508', NULL, 
    NULL, NULL, 32, 'Odongk', 'KH0505', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Kri', 'KH040205', NULL, NULL, 
    NULL, 43, 'Chol Kiri', 'KH0402', 'Kampong Chhnang', 
    'KH04', 'Cambodia', 'KH'
  ), 
  (
    'Prey Kuy', 'KH060211', NULL, NULL, 
    NULL, 30, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Lvea', 'KH210610', NULL, NULL, 
    NULL, 21, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Mul', 'KH040609', NULL, NULL, 
    NULL, 45, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Nheat', 'KH050306', NULL, NULL, 
    NULL, 33, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Nhi', 'KH150505', NULL, NULL, 
    NULL, 8, 'Pursat', 'KH1505', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Prey Nob', 'KH180207', NULL, NULL, 
    NULL, 37, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Prey Phdau', 'KH210611', NULL, NULL, 
    NULL, 21, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Phkoam', 'KH210106', NULL, NULL, 
    NULL, 48, 'Angkor Borei', 'KH2101', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Pnov', 'KH140807', NULL, NULL, 
    NULL, 103, 'Pea Reang', 'KH1408', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Poun', 'KH140312', NULL, NULL, 
    NULL, 20, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Puoch', 'KH080813', NULL, NULL, 
    NULL, 16, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Prey Rumdeng', 'KH140505', NULL, 
    NULL, NULL, 31, 'Me Sang', 'KH1405', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Rumdeng', 'KH210409', NULL, 
    NULL, NULL, 84, 'Kiri Vong', 'KH2104', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Rumduol', 'KH050608', NULL, 
    NULL, NULL, 43, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Sa', 'KH120510', NULL, NULL, 
    NULL, 13, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Prey Sloek', 'KH211007', NULL, NULL, 
    NULL, 36, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Prey Sniet', 'KH140808', NULL, NULL, 
    NULL, 42, 'Pea Reang', 'KH1408', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Prey Sralet', 'KH140809', NULL, NULL, 
    NULL, 72, 'Pea Reang', 'KH1408', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Prey Svay', 'KH020603', NULL, NULL, 
    NULL, 144, 'Moung Ruessei', 'KH0206', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Ta Ei', 'KH200706', NULL, NULL, 
    NULL, 40, 'Svay Teab', 'KH2007', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Prey Ta Hu', 'KH060308', NULL, NULL, 
    NULL, 7, 'Stueng Saen', 'KH0603', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Thnang', 'KH070713', NULL, NULL, 
    NULL, 78, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Prey Thum', 'KH200205', NULL, NULL, 
    NULL, 20, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Thum', 'KH230202', NULL, NULL, 
    NULL, 42, 'Kaeb', 'KH2302', 'Kep', 
    'KH23', 'Cambodia', 'KH'
  ), 
  (
    'Prey Tonle', 'KH070203', NULL, NULL, 
    NULL, 38, 'Banteay Meas', 'KH0702', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Prey Totueng', 'KH140506', NULL, 
    NULL, NULL, 56, 'Me Sang', 'KH1405', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Touch', 'KH020608', NULL, NULL, 
    NULL, 116, 'Moung Ruessei', 'KH0206', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Tralach', 'KH021402', NULL, 
    NULL, NULL, 72, 'Rukh Kiri', 'KH0214', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Tueng', 'KH141209', NULL, NULL, 
    NULL, 33, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Veaeng', 'KH120508', NULL, NULL, 
    NULL, 9, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Prey Vihear', 'KH050307', NULL, NULL, 
    NULL, 27, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Prey Yuthka', 'KH210504', NULL, NULL, 
    NULL, 47, 'Kaoh Andaet', 'KH2105', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Pring Chrum', 'KH030305', NULL, NULL, 
    NULL, 50, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Pring Thum', 'KH130303', NULL, NULL, 
    NULL, 794, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Prongil', 'KH150404', NULL, NULL, 
    NULL, 1132, 'Phnum Kravanh', 'KH1504', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Pu Chrey', 'KH110402', NULL, NULL, 
    NULL, 2253, 'Pech Chreada', 'KH1104', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Puk Ruessei', 'KH080311', NULL, NULL, 
    NULL, 30, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Puok', 'KH170710', NULL, NULL, NULL, 
    59, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Putrea', 'KH130106', NULL, NULL, NULL, 
    172, 'Chey Saen', 'KH1301', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Reab', 'KH140810', NULL, NULL, NULL, 
    46, 'Pea Reang', 'KH1408', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Reach Montir', 'KH200206', NULL, 
    NULL, NULL, 28, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Reaks Chey', 'KH140104', NULL, NULL, 
    NULL, 43, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Reaksa', 'KH130509', NULL, NULL, NULL, 
    167, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Reaksmei', 'KH130502', NULL, NULL, 
    NULL, 8, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Reaksmei Sameakki', 'KH050402', 
    NULL, NULL, NULL, 260, 'Aoral', 'KH0504', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Reaksmei Songha', 'KH020705', NULL, 
    NULL, NULL, 155, 'Rotonak Mondol', 
    'KH0207', 'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ream', 'KH180208', NULL, NULL, NULL, 
    211, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Ream Andaeuk', 'KH210410', NULL, 
    NULL, NULL, 41, 'Kiri Vong', 'KH2104', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Reang Kesei', 'KH020807', NULL, NULL, 
    NULL, 96, 'Sangkae', 'KH0208', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Reang Til', 'KH150205', NULL, NULL, 
    NULL, 79, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Reathor', 'KH140909', NULL, NULL, 
    NULL, 32, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Reay Pay', 'KH030707', NULL, NULL, 
    NULL, 79, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Reul', 'KH170712', NULL, NULL, NULL, 
    76, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Rieb Roy', 'KH130508', NULL, NULL, 
    NULL, 343, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Rik Reay', 'KH130505', NULL, NULL, 
    NULL, 98, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Ro\'ang', 'KH030611', 'Roang', NULL, 
    NULL, 33, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Ro\'ang', 'KH130602', 'Roang', NULL, 
    NULL, 115, 'Sangkum Thmei', 'KH1306', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Robas Mongkol', 'KH020609', NULL, 
    NULL, NULL, 128, 'Moung Ruessei', 
    'KH0206', 'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Robieb', 'KH130501', NULL, NULL, NULL, 
    71, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Rohal', 'KH010406', NULL, NULL, NULL, 
    151, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Rohas', 'KH130503', NULL, NULL, NULL, 
    29, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Rohat Tuek', 'KH010208', NULL, NULL, 
    NULL, 62, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Roka', 'KH020804', NULL, NULL, NULL, 
    152, 'Sangkae', 'KH0208', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Roka', 'KH080117', NULL, NULL, NULL, 
    6, 'Kandal Stueng', 'KH0801', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Roka', 'KH140811', NULL, NULL, NULL, 
    64, 'Pea Reang', 'KH1408', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Roka Ar', 'KH030708', NULL, NULL, 
    NULL, 28, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Roka Chonlueng', 'KH080312', NULL, 
    NULL, NULL, 21, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Roka Kandal', 'KH100211', NULL, NULL, 
    NULL, 24, 'Kracheh', 'KH1002', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Roka Kaoh', 'KH050308', NULL, NULL, 
    NULL, 30, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Roka Khnor', 'KH250209', NULL, NULL, 
    NULL, 27, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Roka Khpos', 'KH081009', NULL, NULL, 
    NULL, 35, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Roka Knong', 'KH210802', NULL, NULL, 
    NULL, 19, 'Doun Kaev', 'KH2108', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Roka Kong Ti Muoy', 'KH080707', 
    NULL, NULL, NULL, 9, 'Mukh Kampul', 
    'KH0807', 'Kandal', 'KH08', 'Cambodia', 
    'KH'
  ), 
  (
    'Roka Kong Ti Pir', 'KH080708', NULL, 
    NULL, NULL, 6, 'Mukh Kampul', 'KH0807', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Roka Koy', 'KH030709', NULL, NULL, 
    NULL, 38, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Roka Krau', 'KH210803', NULL, NULL, 
    NULL, 34, 'Doun Kaev', 'KH2108', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Roka Po Pram', 'KH250711', NULL, 
    NULL, NULL, 201, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Rokar Thum', 'KH050203', NULL, NULL, 
    NULL, 16, 'Chbar Mon', 'KH0502', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Rokat', 'KH150405', NULL, NULL, NULL, 
    853, 'Phnum Kravanh', 'KH1504', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Rolea B\'ier', 'KH040610', 'Rolea Bier', 
    NULL, NULL, 32, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Roleab', 'KH150506', NULL, NULL, NULL, 
    205, 'Pursat', 'KH1505', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Roleang Chak', 'KH050701', NULL, 
    NULL, NULL, 24, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Roleang Kaen', 'KH080118', NULL, 
    NULL, NULL, 13, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Roleang Kreul', 'KH050706', NULL, 
    NULL, NULL, 36, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Roluos', 'KH010808', NULL, NULL, NULL, 
    28, 'Svay Chek', 'KH0108', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Roluos', 'KH120518', NULL, NULL, NULL, 
    5, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Roluos', 'KH170908', NULL, NULL, NULL, 
    21, 'Prasat Bakong', 'KH1709', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Roluos Mean Chey', 'KH100406', NULL, 
    NULL, NULL, 827, 'Sambour', 'KH1004', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Romeang Thkaol', 'KH200708', NULL, 
    NULL, NULL, 40, 'Svay Teab', 'KH2007', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Romenh', 'KH210505', NULL, NULL, NULL, 
    70, 'Kaoh Andaet', 'KH2105', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Romonea', 'KH110504', NULL, NULL, 
    NULL, 183, 'Saen Monourom', 'KH1105', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Romoneiy', 'KH130512', NULL, NULL, 
    NULL, 593, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Romtum', 'KH130511', NULL, NULL, NULL, 
    355, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Ronak Ser', 'KH130605', NULL, NULL, 
    NULL, 540, 'Sangkum Thmei', 'KH1306', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Roneam', 'KH211008', NULL, NULL, NULL, 
    31, 'Treang', 'KH2110', 'Takeo', 'KH21', 
    'Cambodia', 'KH'
  ), 
  (
    'Rotanak', 'KH130507', NULL, NULL, 
    NULL, 94, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Rottanak', 'KH020303', NULL, NULL, 
    NULL, 7, 'Battambang', 'KH0203', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Roung Damrei', 'KH140105', NULL, 
    NULL, NULL, 47, 'Ba Phnum', 'KH1401', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Roung Kou', 'KH170605', NULL, NULL, 
    NULL, 16, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Rovieng', 'KH210707', NULL, NULL, 
    NULL, 36, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Roya', 'KH110203', NULL, NULL, NULL, 
    2219, 'Kaoh Nheaek', 'KH1102', 'Mondul Kiri', 
    'KH11', 'Cambodia', 'KH'
  ), 
  (
    'Ruessei Chrouy', 'KH080709', NULL, 
    NULL, NULL, 24, 'Mukh Kampul', 'KH0807', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ruessei Chrum', 'KH090704', NULL, 
    NULL, NULL, 580, 'Thma Bang', 'KH0907', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Ruessei Kaev', 'KH120706', NULL, 
    NULL, NULL, 5, 'Russey Keo', 'KH1207', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Krang', 'KH020604', NULL, 
    NULL, NULL, 164, 'Moung Ruessei', 
    'KH0206', 'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Kraok', 'KH010209', NULL, 
    NULL, NULL, 40, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Lok', 'KH170410', NULL, NULL, 
    NULL, 115, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ruessei Sanh', 'KH141211', NULL, 
    NULL, NULL, 44, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Srok', 'KH031411', NULL, 
    NULL, NULL, 16, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Srok', 'KH140609', NULL, 
    NULL, NULL, 49, 'Peam Chor', 'KH1406', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Srok Khang Kaeut', 'KH070613', 
    NULL, NULL, NULL, 23, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Ruessei Srok Khang Lech', 'KH070614', 
    NULL, NULL, NULL, 30, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Rumchek', 'KH030612', NULL, NULL, 
    NULL, 15, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Rumchek', 'KH140910', NULL, NULL, 
    NULL, 42, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Rumchek', 'KH170304', NULL, NULL, 
    NULL, 19, 'Banteay Srei', 'KH1703', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Rumchek', 'KH250310', NULL, NULL, 
    NULL, 226, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Rumdaoh', 'KH130510', NULL, NULL, 
    NULL, 202, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Rumdaoh Srae', 'KH130304', NULL, 
    NULL, NULL, 319, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Rumlech', 'KH141210', NULL, NULL, 
    NULL, 31, 'Sithor Kandal', 'KH1412', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Rumlech', 'KH150106', NULL, NULL, 
    NULL, 53, 'Bakan', 'KH1501', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Run Ta Aek', 'KH170305', NULL, NULL, 
    NULL, 100, 'Banteay Srei', 'KH1703', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Rung', 'KH250311', NULL, NULL, NULL, 
    34, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Rung Chrey', 'KH020210', NULL, NULL, 
    NULL, 81, 'Thma Koul', 'KH0202', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Rung Roeang', 'KH050805', NULL, NULL, 
    NULL, 40, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Rung Roeang', 'KH060811', NULL, NULL, 
    NULL, 14, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Rung Roeang', 'KH130504', NULL, NULL, 
    NULL, 191, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Ruos Roan', 'KH130506', NULL, NULL, 
    NULL, 36, 'Rovieng', 'KH1305', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Russey Keo', 'KH100306', NULL, NULL, 
    NULL, 106, 'Prek Prasab', 'KH1003', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'S\'ang', 'KH130101', 'Sang', NULL, 
    NULL, 36, 'Chey Saen', 'KH1301', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'S\'ang Phnum', 'KH081010', 'Sang Phnum', 
    NULL, NULL, 42, 'S\'ang', 'KH0810', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Saeb', 'KH040508', NULL, NULL, NULL, 
    34, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Saen Dei', 'KH050709', NULL, NULL, 
    NULL, 48, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Saen Monourom', 'KH110302', NULL, 
    NULL, NULL, 787, 'Ou Reang', 'KH1103', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Saen Sokh', 'KH170607', NULL, NULL, 
    NULL, 63, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Saeung', 'KH160305', NULL, NULL, NULL, 
    46, 'Bar Kaev', 'KH1603', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Sak Sampov', 'KH120514', NULL, NULL, 
    NULL, 6, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Sakream', 'KH060404', NULL, NULL, 
    NULL, 345, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Sala Kamreuk', 'KH171004', NULL, 
    NULL, NULL, 9, 'Siem Reap', 'KH1710', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Sala Krau', 'KH240201', NULL, NULL, 
    NULL, 59, 'Sala Krau', 'KH2402', 'Pailin', 
    'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Sala Visai', 'KH060405', NULL, NULL, 
    NULL, 397, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Sam Ang', 'KH190509', NULL, NULL, 
    NULL, 372, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambatt Mean Chey', 'KH200414', 
    NULL, NULL, NULL, 39, 'Romeas Haek', 
    'KH2004', 'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambok', 'KH100607', NULL, NULL, NULL, 
    271, 'Chetr Borei', 'KH1006', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Sambour', 'KH030107', NULL, NULL, 
    NULL, 95, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Sambour', 'KH050708', NULL, NULL, 
    NULL, 30, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambour', 'KH060503', NULL, NULL, 
    NULL, 209, 'Prasat Sambour', 'KH0605', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambour', 'KH100407', NULL, NULL, 
    NULL, 96, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Sambuor', 'KH010210', NULL, NULL, 
    NULL, 77, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambuor', 'KH080612', NULL, NULL, 
    NULL, 19, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Sambuor', 'KH170606', NULL, NULL, 
    NULL, 150, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Sambuor', 'KH200413', NULL, NULL, 
    NULL, 28, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambuor', 'KH200709', NULL, NULL, 
    NULL, 44, 'Svay Teab', 'KH2007', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Sambuor', 'KH211009', NULL, NULL, 
    NULL, 55, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Sambuor Meas', 'KH030503', NULL, 
    NULL, NULL, 14, 'Kampong Cham', 'KH0305', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Sambuor Meas', 'KH080710', NULL, 
    NULL, NULL, 79, 'Mukh Kampul', 'KH0807', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Sameakki', 'KH060406', NULL, NULL, 
    NULL, 78, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Sameakki', 'KH160606', NULL, NULL, 
    NULL, 70, 'Ou Chum', 'KH1606', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Sameakki', 'KH180209', NULL, NULL, 
    NULL, 216, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Sameakki', 'KH190404', NULL, NULL, 
    NULL, 513, 'Stueng Traeng', 'KH1904', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Samkhuoy', 'KH190104', NULL, NULL, 
    NULL, 204, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Samlanh', 'KH070110', NULL, NULL, 
    NULL, 24, 'Angkor Chey', 'KH0701', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Samlei', 'KH200207', NULL, NULL, NULL, 
    52, 'Kampong Rou', 'KH2002', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Samlout', 'KH020905', NULL, NULL, 
    NULL, 197, 'Samlout', 'KH0209', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Sampeou Poun', 'KH080412', NULL, 
    NULL, NULL, 64, 'Kaoh Thum', 'KH0804', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Sampong Chey', 'KH030306', NULL, 
    NULL, NULL, 56, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Sampov Lun', 'KH021001', NULL, NULL, 
    NULL, 123, 'Sampov Lun', 'KH0210', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Samprouch', 'KH060812', NULL, NULL, 
    NULL, 224, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH010505', NULL, NULL, 
    NULL, 96, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH031311', NULL, NULL, 
    NULL, 23, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Samraong', 'KH121103', NULL, NULL, 
    NULL, 19, 'Praek Pnov', 'KH1211', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Samraong', 'KH141309', NULL, NULL, 
    NULL, 66, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Samraong', 'KH150407', NULL, NULL, 
    NULL, 547, 'Phnum Kravanh', 'KH1504', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH171109', NULL, NULL, 
    NULL, 24, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH200109', NULL, NULL, 
    NULL, 22, 'Chantrea', 'KH2001', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH210708', NULL, NULL, 
    NULL, 16, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH210910', NULL, NULL, 
    NULL, 26, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Samraong', 'KH220404', NULL, NULL, 
    NULL, 95, 'Samraong', 'KH2204', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Samraong Knong', 'KH020502', NULL, 
    NULL, NULL, 21, 'Aek Phnum', 'KH0205', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Samraong Kraom', 'KH070204', NULL, 
    NULL, NULL, 23, 'Banteay Meas', 'KH0702', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Samraong Kraom', 'KH120906', NULL, 
    NULL, NULL, 12, 'Pur SenChey', 'KH1209', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Samraong Leu', 'KH070205', NULL, 
    NULL, NULL, 17, 'Banteay Meas', 'KH0702', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Samraong Leu', 'KH080814', NULL, 
    NULL, NULL, 31, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Samraong Saen', 'KH040407', NULL, 
    NULL, NULL, 46, 'Kampong Leaeng', 
    'KH0404', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Samraong Thum', 'KH080211', NULL, 
    NULL, NULL, 95, 'Kien Svay', 'KH0802', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Samraong Yea', 'KH170713', NULL, 
    NULL, NULL, 46, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Samrong', 'KH180210', NULL, NULL, 
    NULL, 73, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Samrong Tong', 'KH050707', NULL, 
    NULL, NULL, 30, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Samyaong', 'KH200208', NULL, NULL, 
    NULL, 24, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'San Kor', 'KH060207', NULL, NULL, 
    NULL, 223, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Sandaek', 'KH030108', NULL, NULL, 
    NULL, 59, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Sandan', 'KH060607', NULL, NULL, NULL, 
    257, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Sandan', 'KH100408', NULL, NULL, NULL, 
    97, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Sandar', 'KH080507', NULL, NULL, NULL, 
    36, 'Leuk Daek', 'KH0805', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Sangkae', 'KH200308', NULL, NULL, 
    NULL, 26, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Sangkae Muoy', 'KH130203', NULL, 
    NULL, NULL, 329, 'Chhaeb', 'KH1302', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Sangkae Pir', 'KH130204', NULL, NULL, 
    NULL, 62, 'Chhaeb', 'KH1302', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Sangkae Satob', 'KH050404', NULL, 
    NULL, NULL, 217, 'Aoral', 'KH0504', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Sangkhoar', 'KH200607', NULL, NULL, 
    NULL, 30, 'Svay Rieng', 'KH2006', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Sangvaeuy', 'KH170411', NULL, NULL, 
    NULL, 88, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Sanlung', 'KH080313', NULL, NULL, 
    NULL, 26, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Sanlung', 'KH211010', NULL, NULL, 
    NULL, 36, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Santepheap', 'KH021004', NULL, NULL, 
    NULL, 61, 'Sampov Lun', 'KH0210', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Santepheap', 'KH190303', NULL, NULL, 
    NULL, 1962, 'Siem Pang', 'KH1903', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Santreae', 'KH150406', NULL, NULL, 
    NULL, 668, 'Phnum Kravanh', 'KH1504', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Saob', 'KH100307', NULL, NULL, NULL, 
    270, 'Prek Prasab', 'KH1003', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Saom', 'KH210411', NULL, NULL, NULL, 
    59, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Saom Thum', 'KH160706', NULL, NULL, 
    NULL, 103, 'Ou Ya Dav', 'KH1607', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Sarikakaev', 'KH080613', NULL, NULL, 
    NULL, 20, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Sarongk', 'KH010802', NULL, NULL, 
    NULL, 47, 'Svay Chek', 'KH0108', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Sasar Sdam', 'KH170701', NULL, NULL, 
    NULL, 55, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Satv Pong', 'KH070312', NULL, NULL, 
    NULL, 17, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Sdach Kong Khang Cheung', 'KH070206', 
    NULL, NULL, NULL, 22, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Sdach Kong Khang Lech', 'KH070207', 
    NULL, NULL, NULL, 24, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Sdach Kong Khang Tboung', 'KH070208', 
    NULL, NULL, NULL, 27, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Sdaeung Chey', 'KH030307', NULL, 
    NULL, NULL, 59, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Sdau', 'KH020701', NULL, NULL, NULL, 
    56, 'Rotonak Mondol', 'KH0207', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Sdau', 'KH030710', NULL, NULL, NULL, 
    15, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Sdau', 'KH130604', NULL, NULL, NULL, 
    385, 'Sangkum Thmei', 'KH1306', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Sdau', 'KH190105', NULL, NULL, NULL, 
    305, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Sdau Kaong', 'KH140106', NULL, NULL, 
    NULL, 46, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Sdok', 'KH050309', NULL, NULL, NULL, 
    27, 'Kong Pisei', 'KH0503', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Sdok Pravoek', 'KH021404', NULL, 
    NULL, NULL, 118, 'Rukh Kiri', 'KH0214', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Seang Khveang', 'KH140205', NULL, 
    NULL, NULL, 40, 'Kamchay Mear', 'KH1402', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Seda', 'KH160506', NULL, NULL, NULL, 
    449, 'Lumphat', 'KH1605', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Seda', 'KH250105', NULL, NULL, NULL, 
    193, 'Dambae', 'KH2501', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Sedthei', 'KH040705', NULL, NULL, 
    NULL, 50, 'Sameakki Mean Chey', 'KH0407', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Sekong', 'KH190302', NULL, NULL, NULL, 
    774, 'Siem Pang', 'KH1903', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Sena Reach Otdam', 'KH140911', NULL, 
    NULL, NULL, 49, 'Preah Sdach', 'KH1409', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Serei Mean Chey', 'KH021005', NULL, 
    NULL, NULL, 64, 'Sampov Lun', 'KH0210', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Serei Mongkol', 'KH160401', NULL, 
    NULL, NULL, 546, 'Koun Mom', 'KH1604', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Sesan', 'KH160705', NULL, NULL, NULL, 
    44, 'Ou Ya Dav', 'KH1607', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Setbou', 'KH081011', NULL, NULL, NULL, 
    17, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Siem Bouk', 'KH190206', NULL, NULL, 
    NULL, 1039, 'Siem Bouk', 'KH1902', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Siem Reab', 'KH080122', NULL, NULL, 
    NULL, 5, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Siem Reab', 'KH171009', NULL, NULL, 
    NULL, 27, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Sithor', 'KH080314', NULL, NULL, NULL, 
    26, 'Khsach Kandal', 'KH0803', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Skuh', 'KH050710', NULL, NULL, NULL, 
    43, 'Samraong Tong', 'KH0507', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Sla', 'KH210710', NULL, NULL, NULL, 
    20, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Sla Ket', 'KH020305', NULL, NULL, 
    NULL, 8, 'Battambang', 'KH0203', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Sla Kram', 'KH010803', NULL, NULL, 
    NULL, 169, 'Svay Chek', 'KH0108', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Sla Kram', 'KH171001', NULL, NULL, 
    NULL, 13, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Slaeng Spean', 'KH171206', NULL, 
    NULL, NULL, 226, 'Srei Snam', 'KH1712', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Smach Mean Chey', 'KH090401', NULL, 
    NULL, NULL, 57, 'Khemara Phoumin', 
    'KH0904', 'Koh Kong', 'KH09', 'Cambodia', 
    'KH'
  ), 
  (
    'Smaong', 'KH211011', NULL, NULL, NULL, 
    15, 'Treang', 'KH2110', 'Takeo', 'KH21', 
    'Cambodia', 'KH'
  ), 
  (
    'Smaong Khang Cheung', 'KH140206', 
    NULL, NULL, NULL, 76, 'Kamchay Mear', 
    'KH1402', 'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Smaong Khang Tboung', 'KH140207', 
    NULL, NULL, NULL, 70, 'Kamchay Mear', 
    'KH1402', 'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Sna Ansa', 'KH150309', NULL, NULL, 
    NULL, 88, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Snam Krapeu', 'KH050310', NULL, NULL, 
    NULL, 31, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Snam Preah', 'KH150107', NULL, NULL, 
    NULL, 209, 'Bakan', 'KH1501', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Snao', 'KH210612', NULL, NULL, NULL, 
    24, 'Prey Kabbas', 'KH2106', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Snaor', 'KH120913', NULL, NULL, NULL, 
    14, 'Pur SenChey', 'KH1209', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Snay Anhchit', 'KH070403', NULL, 
    NULL, NULL, 59, 'Chum Kiri', 'KH0704', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Sngkat Sambuor', 'KH171008', NULL, 
    NULL, NULL, 27, 'Siem Reap', 'KH1710', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Snoeng', 'KH020107', NULL, NULL, NULL, 
    268, 'Banan', 'KH0201', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Snuol', 'KH100503', NULL, NULL, NULL, 
    182, 'Snuol', 'KH1005', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Snuol', 'KH170608', NULL, NULL, NULL, 
    74, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Sochet', 'KH060608', NULL, NULL, NULL, 
    486, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Soea', 'KH010211', NULL, NULL, NULL, 
    189, 'Mongkol Borei', 'KH0102', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Soengh', 'KH010507', NULL, NULL, NULL, 
    90, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Soengh', 'KH210709', NULL, NULL, NULL, 
    31, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Sokh Dom', 'KH110502', NULL, NULL, 
    NULL, 186, 'Saen Monourom', 'KH1105', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Sokh Sant', 'KH110204', NULL, NULL, 
    NULL, 714, 'Kaoh Nheaek', 'KH1102', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Sopoar Tep', 'KH050204', NULL, NULL, 
    NULL, 8, 'Chbar Mon', 'KH0502', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Sou Young', 'KH060114', NULL, NULL, 
    NULL, 20, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Soupheas', 'KH031512', NULL, NULL, 
    NULL, 62, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Souphi', 'KH010506', NULL, NULL, NULL, 
    78, 'Ou Chrov', 'KH0105', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Sour Kong', 'KH030711', NULL, NULL, 
    NULL, 43, 'Kang Meas', 'KH0307', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Sour Phi', 'KH210211', NULL, NULL, 
    NULL, 11, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Sour Saen', 'KH031310', NULL, NULL, 
    NULL, 18, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Soutib', 'KH030308', NULL, NULL, NULL, 
    26, 'Cheung Prey', 'KH0303', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Spean Mean Chey', 'KH110503', NULL, 
    NULL, NULL, 94, 'Saen Monourom', 'KH1105', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Spean Sraeng', 'KH010304', NULL, 
    NULL, NULL, 64, 'Phnum Srok', 'KH0103', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Spean Thma', 'KH120519', NULL, NULL, 
    NULL, 8, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Spean Tnaot', 'KH170412', NULL, NULL, 
    NULL, 193, 'Chi Kraeng', 'KH1704', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Spueu', 'KH030205', NULL, NULL, NULL, 
    31, 'Chamkar Leu', 'KH0302', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Spueu Ka', 'KH140107', NULL, NULL, 
    NULL, 23, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Spueu Kha', 'KH140108', NULL, NULL, 
    NULL, 29, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Srae Ambel', 'KH090606', NULL, NULL, 
    NULL, 56, 'Srae Ambel', 'KH0906', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Srae Ampum', 'KH110403', NULL, NULL, 
    NULL, 178, 'Pech Chreada', 'KH1104', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Angkrorng', 'KH160402', NULL, 
    NULL, NULL, 369, 'Koun Mom', 'KH1604', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Chaeng', 'KH070404', NULL, NULL, 
    NULL, 178, 'Chum Kiri', 'KH0704', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Srae Char', 'KH100504', NULL, NULL, 
    NULL, 298, 'Snuol', 'KH1005', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Srae Chea Khang Cheung', 'KH070506', 
    NULL, NULL, NULL, 24, 'Dang Tong', 
    'KH0705', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Chea Khang Tboung', 'KH070507', 
    NULL, NULL, NULL, 38, 'Dang Tong', 
    'KH0705', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Chhuk', 'KH110103', NULL, NULL, 
    NULL, 515, 'Kaev Seima', 'KH1101', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Chis', 'KH100409', NULL, NULL, 
    NULL, 451, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Srae Huy', 'KH110205', NULL, NULL, 
    NULL, 560, 'Kaoh Nheaek', 'KH1102', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Khtum', 'KH110104', NULL, NULL, 
    NULL, 325, 'Kaev Seima', 'KH1101', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Khvav', 'KH170106', NULL, NULL, 
    NULL, 105, 'Angkor Chum', 'KH1701', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Srae Knong', 'KH070405', NULL, NULL, 
    NULL, 63, 'Chum Kiri', 'KH0704', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Srae Kor', 'KH190106', NULL, NULL, 
    NULL, 399, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Srae Krasang', 'KH190207', NULL, 
    NULL, NULL, 108, 'Siem Bouk', 'KH1902', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Nouy', 'KH171403', NULL, NULL, 
    NULL, 508, 'Varin', 'KH1714', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Srae Preah', 'KH110105', NULL, NULL, 
    NULL, 441, 'Kaev Seima', 'KH1101', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Ronoung', 'KH210911', NULL, 
    NULL, NULL, 36, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Srae Ruessei', 'KH190510', NULL, 
    NULL, NULL, 145, 'Thala Barivat', 
    'KH1905', 'Stung Treng', 'KH19', 
    'Cambodia', 'KH'
  ), 
  (
    'Srae Sambour', 'KH190304', NULL, 
    NULL, NULL, 701, 'Siem Pang', 'KH1903', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Samraong', 'KH070406', NULL, 
    NULL, NULL, 39, 'Chum Kiri', 'KH0704', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Srae Sangkum', 'KH110206', NULL, 
    NULL, NULL, 702, 'Kaoh Nheaek', 'KH1102', 
    'Mondul Kiri', 'KH11', 'Cambodia', 
    'KH'
  ), 
  (
    'Srae Sdok', 'KH150206', NULL, NULL, 
    NULL, 193, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Srae Thmei', 'KH040611', NULL, NULL, 
    NULL, 29, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Sraeung', 'KH060504', NULL, NULL, 
    NULL, 193, 'Prasat Sambour', 'KH0605', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Sragnae', 'KH031312', NULL, NULL, 
    NULL, 14, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Srah Chak', 'KH120210', NULL, NULL, 
    NULL, 3, 'Doun Penh', 'KH1202', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Srah Chik', 'KH010305', NULL, NULL, 
    NULL, 86, 'Phnum Srok', 'KH0103', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Srah Reang', 'KH010212', NULL, NULL, 
    NULL, 33, 'Mongkol Borei', 'KH0102', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Srah Ruessei', 'KH190402', NULL, 
    NULL, NULL, 48, 'Stueng Traeng', 'KH1904', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Srak', 'KH030613', NULL, NULL, NULL, 
    68, 'Kampong Siem', 'KH0306', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Sralab', 'KH250712', NULL, NULL, NULL, 
    81, 'Tboung Khmum', 'KH2507', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Sralau', 'KH060115', NULL, NULL, NULL, 
    160, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Sramar', 'KH030309', NULL, NULL, NULL, 
    25, 'Cheung Prey', 'KH0303', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Sranal', 'KH170609', NULL, NULL, NULL, 
    101, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Srang', 'KH050311', NULL, NULL, NULL, 
    74, 'Kong Pisei', 'KH0503', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Srangae', 'KH171010', NULL, NULL, 
    NULL, 37, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Srangae', 'KH211012', NULL, NULL, 
    NULL, 27, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Srayang', 'KH130406', NULL, NULL, 
    NULL, 1113, 'Kuleaen', 'KH1304', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Srayov', 'KH060310', NULL, NULL, NULL, 
    283, 'Stueng Saen', 'KH0603', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Sror Aem', 'KH130307', NULL, NULL, 
    NULL, 629, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Stueng Chhay', 'KH180404', NULL, 
    NULL, NULL, 87, 'Kampong Seila', 'KH1804', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Stueng Kach', 'KH240203', NULL, NULL, 
    NULL, 112, 'Sala Krau', 'KH2402', 
    'Pailin', 'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Stueng Kaev', 'KH070715', NULL, NULL, 
    NULL, 102, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Stueng Mean Chey', 'KH120601', NULL, 
    NULL, NULL, 11, 'Mean Chey', 'KH1206', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Stueng Traeng', 'KH190401', NULL, 
    NULL, NULL, 74, 'Stueng Traeng', 'KH1904', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Stueng Trang', 'KH240202', NULL, 
    NULL, NULL, 149, 'Sala Krau', 'KH2402', 
    'Pailin', 'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Stueng Veaeng', 'KH090403', NULL, 
    NULL, NULL, 41, 'Khemara Phoumin', 
    'KH0904', 'Koh Kong', 'KH09', 'Cambodia', 
    'KH'
  ), 
  (
    'Sung', 'KH020904', NULL, NULL, NULL, 
    128, 'Samlout', 'KH0209', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Suong', 'KH250601', NULL, NULL, NULL, 
    38, 'Suong', 'KH2506', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Svay', 'KH040706', NULL, NULL, NULL, 
    39, 'Sameakki Mean Chey', 'KH0407', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Ampear', 'KH080711', NULL, NULL, 
    NULL, 20, 'Mukh Kampul', 'KH0807', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Svay Angk', 'KH200513', NULL, NULL, 
    NULL, 22, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Antor', 'KH141310', NULL, NULL, 
    NULL, 33, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay At', 'KH150507', NULL, NULL, 
    NULL, 11, 'Pursat', 'KH1505', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Svay Chacheb', 'KH050110', NULL, 
    NULL, NULL, 63, 'Basedth', 'KH0501', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Chek', 'KH010804', NULL, NULL, 
    NULL, 210, 'Svay Chek', 'KH0108', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Chek', 'KH170204', NULL, NULL, 
    NULL, 43, 'Angkor Thum', 'KH1702', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Svay Chek', 'KH200309', NULL, NULL, 
    NULL, 31, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Svay Chreah', 'KH100505', NULL, NULL, 
    NULL, 749, 'Snuol', 'KH1005', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Svay Chrum', 'KH040612', NULL, NULL, 
    NULL, 85, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Chrum', 'KH080315', NULL, NULL, 
    NULL, 19, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Svay Chrum', 'KH140507', NULL, NULL, 
    NULL, 86, 'Me Sang', 'KH1405', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Svay Chrum', 'KH200514', NULL, NULL, 
    NULL, 13, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Chuk', 'KH040707', NULL, NULL, 
    NULL, 116, 'Sameakki Mean Chey', 
    'KH0407', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Svay Dankum', 'KH171002', NULL, NULL, 
    NULL, 40, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Svay Doun Kaev', 'KH150108', NULL, 
    NULL, NULL, 30, 'Bakan', 'KH1501', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Svay Khleang', 'KH250210', NULL, 
    NULL, NULL, 45, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Khsach Phnum', 'KH031413', 
    NULL, NULL, NULL, 14, 'Srei Santhor', 
    'KH0314', 'Kampong Cham', 'KH03', 
    'Cambodia', 'KH'
  ), 
  (
    'Svay Kravan', 'KH050205', NULL, NULL, 
    NULL, 15, 'Chbar Mon', 'KH0502', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Svay Leu', 'KH171304', NULL, NULL, 
    NULL, 279, 'Svay Leu', 'KH1713', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Svay Luong', 'KH150207', NULL, NULL, 
    NULL, 25, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Svay Pak', 'KH120703', NULL, NULL, 
    NULL, 4, 'Russey Keo', 'KH1207', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Svay Phleung', 'KH060116', NULL, 
    NULL, NULL, 27, 'Baray', 'KH0601', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Phluoh', 'KH140610', NULL, NULL, 
    NULL, 35, 'Peam Chor', 'KH1406', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Svay Por', 'KH020310', NULL, NULL, 
    NULL, 2, 'Battambang', 'KH0203', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Svay Pou', 'KH031412', NULL, NULL, 
    NULL, 23, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Prateal', 'KH081012', NULL, 
    NULL, NULL, 34, 'S\'ang', 'KH0810', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Svay Rieng', 'KH200601', NULL, NULL, 
    NULL, 5, 'Svay Rieng', 'KH2006', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Svay Rolum', 'KH081013', NULL, NULL, 
    NULL, 18, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Svay Romiet', 'KH080316', NULL, NULL, 
    NULL, 14, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Svay Rumpear', 'KH040408', NULL, 
    NULL, NULL, 77, 'Kampong Leaeng', 
    'KH0404', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Svay Rumpear', 'KH050114', NULL, 
    NULL, NULL, 24, 'Basedth', 'KH0501', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Rumpear', 'KH200711', NULL, 
    NULL, NULL, 26, 'Svay Teab', 'KH2007', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Sa', 'KH150310', NULL, NULL, 
    NULL, 196, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Svay Sa', 'KH171404', NULL, NULL, 
    NULL, 89, 'Varin', 'KH1714', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Svay Ta Yean', 'KH200209', NULL, 
    NULL, NULL, 44, 'Kampong Rou', 'KH2002', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Teab', 'KH030206', NULL, NULL, 
    NULL, 86, 'Chamkar Leu', 'KH0302', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Thum', 'KH200515', NULL, NULL, 
    NULL, 42, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Toea', 'KH200606', NULL, NULL, 
    NULL, 22, 'Svay Rieng', 'KH2006', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Tong Khang Cheung', 'KH070615', 
    NULL, NULL, NULL, 18, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Tong Khang Tboung', 'KH070616', 
    NULL, NULL, NULL, 14, 'Kampong Trach', 
    'KH0706', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Svay Yea', 'KH200516', NULL, NULL, 
    NULL, 38, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Sya', 'KH150208', NULL, NULL, NULL, 
    107, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ta Aek', 'KH080317', NULL, NULL, NULL, 
    14, 'Khsach Kandal', 'KH0803', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ta An', 'KH170610', NULL, NULL, NULL, 
    24, 'Kralanh', 'KH1706', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ta Ang', 'KH160403', NULL, NULL, NULL, 
    162, 'Koun Mom', 'KH1604', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Ta Baen', 'KH010805', NULL, NULL, 
    NULL, 27, 'Svay Chek', 'KH0108', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ta Ches', 'KH040509', NULL, NULL, 
    NULL, 53, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Kao', 'KH141105', NULL, NULL, NULL, 
    34, 'Pur Rieng', 'KH1411', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Ta Kdol', 'KH081101', NULL, NULL, 
    NULL, 2, 'Ta Khmau', 'KH0811', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ta Khmao', 'KH081104', NULL, NULL, 
    NULL, 10, 'Ta Khmau', 'KH0811', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ta Kong', 'KH010906', NULL, NULL, 
    NULL, 134, 'Malai', 'KH0109', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ta Kream', 'KH020108', NULL, NULL, 
    NULL, 229, 'Banan', 'KH0201', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Krei', 'KH021206', NULL, NULL, 
    NULL, 172, 'Kamrieng', 'KH0212', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Lam', 'KH010213', NULL, NULL, NULL, 
    37, 'Mongkol Borei', 'KH0102', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ta Lat', 'KH190107', NULL, NULL, NULL, 
    523, 'Sesan', 'KH1901', 'Stung Treng', 
    'KH19', 'Cambodia', 'KH'
  ), 
  (
    'Ta Lav', 'KH160104', NULL, NULL, NULL, 
    201, 'Andoung Meas', 'KH1601', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Ta Loas', 'KH020606', NULL, NULL, 
    NULL, 136, 'Moung Ruessei', 'KH0206', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Lon', 'KH081014', NULL, NULL, NULL, 
    31, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Ta Lou', 'KH150109', NULL, NULL, NULL, 
    305, 'Bakan', 'KH1501', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Ta Mao', 'KH100308', NULL, NULL, NULL, 
    123, 'Prek Prasab', 'KH1003', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Ta Meun', 'KH020202', NULL, NULL, 
    NULL, 119, 'Thma Koul', 'KH0202', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Noun', 'KH090103', NULL, NULL, 
    NULL, 267, 'Botum Sakor', 'KH0901', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Ta Ong', 'KH030207', NULL, NULL, NULL, 
    136, 'Chamkar Leu', 'KH0302', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Ta Ou', 'KH210412', NULL, NULL, NULL, 
    47, 'Kiri Vong', 'KH2104', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Ta Phem', 'KH210912', NULL, NULL, 
    NULL, 31, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Ta Phou', 'KH010806', NULL, NULL, 
    NULL, 80, 'Svay Chek', 'KH0108', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Ta Pon', 'KH020803', NULL, NULL, NULL, 
    191, 'Sangkae', 'KH0208', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Prok', 'KH030208', NULL, NULL, 
    NULL, 18, 'Chamkar Leu', 'KH0302', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Pung', 'KH020201', NULL, NULL, 
    NULL, 108, 'Thma Koul', 'KH0202', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Saen', 'KH021205', NULL, NULL, 
    NULL, 84, 'Kamrieng', 'KH0212', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Sal', 'KH050405', NULL, NULL, NULL, 
    1297, 'Aoral', 'KH0504', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Ta Sanh', 'KH020907', NULL, NULL, 
    NULL, 218, 'Samlout', 'KH0209', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Saom', 'KH170107', NULL, NULL, 
    NULL, 48, 'Angkor Chum', 'KH1701', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ta Sda', 'KH021003', NULL, NULL, NULL, 
    71, 'Sampov Lun', 'KH0210', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Siem', 'KH171305', NULL, NULL, 
    NULL, 397, 'Svay Leu', 'KH1713', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Ta Suos', 'KH200505', NULL, NULL, 
    NULL, 41, 'Svay Chrum', 'KH2005', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Tai Kraom', 'KH090303', NULL, 
    NULL, NULL, 201, 'Kaoh Kong', 'KH0903', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Ta Taok', 'KH020901', NULL, NULL, 
    NULL, 179, 'Samlout', 'KH0209', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Ta Tey Leu', 'KH090701', NULL, NULL, 
    NULL, 1781, 'Thma Bang', 'KH0907', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Ta Veaeng Kraom', 'KH160802', NULL, 
    NULL, NULL, 558, 'Ta Veaeng', 'KH1608', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Veaeng Leu', 'KH160801', NULL, 
    NULL, NULL, 1713, 'Ta Veaeng', 'KH1608', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Ta Yaek', 'KH171110', NULL, NULL, 
    NULL, 83, 'Soutr Nikom', 'KH1711', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Takaen', 'KH070302', NULL, NULL, NULL, 
    377, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Tang Doung', 'KH210212', NULL, NULL, 
    NULL, 20, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Tang Krang', 'KH030109', NULL, NULL, 
    NULL, 38, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Tang Krasang', 'KH030110', NULL, 
    NULL, NULL, 43, 'Batheay', 'KH0301', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Krasang', 'KH040807', NULL, 
    NULL, NULL, 131, 'Tuek Phos', 'KH0408', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Krasang', 'KH060708', NULL, 
    NULL, NULL, 52, 'Santuk', 'KH0607', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Krasau', 'KH060505', NULL, NULL, 
    NULL, 144, 'Prasat Sambour', 'KH0605', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Krouch', 'KH050711', NULL, NULL, 
    NULL, 40, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Samraong', 'KH050610', NULL, 
    NULL, NULL, 134, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Sya', 'KH050611', NULL, NULL, 
    NULL, 56, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Tang Yab', 'KH210613', NULL, NULL, 
    NULL, 18, 'Prey Kabbas', 'KH2106', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Tani', 'KH070111', NULL, NULL, NULL, 
    40, 'Angkor Chey', 'KH0701', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Tasu', 'KH130102', NULL, NULL, NULL, 
    143, 'Chey Saen', 'KH1301', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Tbaeng', 'KH060208', NULL, NULL, NULL, 
    142, 'Kampong Svay', 'KH0602', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Tbaeng', 'KH080125', NULL, NULL, NULL, 
    23, 'Kandal Stueng', 'KH0801', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tbaeng', 'KH170306', NULL, NULL, NULL, 
    143, 'Banteay Srei', 'KH1703', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Tbaeng Khpos', 'KH040708', NULL, 
    NULL, NULL, 70, 'Sameakki Mean Chey', 
    'KH0407', 'Kampong Chhnang', 'KH04', 
    'Cambodia', 'KH'
  ), 
  (
    'Tboung Krapeu', 'KH060710', NULL, 
    NULL, NULL, 36, 'Santuk', 'KH0607', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Tean Kam', 'KH010407', NULL, NULL, 
    NULL, 60, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Teun', 'KH160404', NULL, NULL, NULL, 
    302, 'Koun Mom', 'KH1604', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Thala Barivat', 'KH190511', NULL, 
    NULL, NULL, 89, 'Thala Barivat', 'KH1905', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Theay', 'KH140109', NULL, NULL, NULL, 
    39, 'Ba Phnum', 'KH1401', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Thipakdei', 'KH021301', NULL, NULL, 
    NULL, 132, 'Koas Krala', 'KH0213', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Thkov', 'KH140313', NULL, NULL, NULL, 
    30, 'Kampong Trabaek', 'KH1403', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Thlat', 'KH220105', NULL, NULL, NULL, 
    211, 'Anlong Veaeng', 'KH2201', 'Oddar Meanchey', 
    'KH22', 'Cambodia', 'KH'
  ), 
  (
    'Thlea Prachum', 'KH210506', NULL, 
    NULL, NULL, 34, 'Kaoh Andaet', 'KH2105', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Thlok', 'KH200517', NULL, NULL, NULL, 
    20, 'Svay Chrum', 'KH2005', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Thlok', 'KH211013', NULL, NULL, NULL, 
    48, 'Treang', 'KH2110', 'Takeo', 'KH21', 
    'Cambodia', 'KH'
  ), 
  (
    'Thlok Vien', 'KH040709', NULL, NULL, 
    NULL, 40, 'Sameakki Mean Chey', 'KH0407', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Thma Andaeuk', 'KH100608', NULL, 
    NULL, NULL, 58, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Thma Da', 'KH150605', NULL, NULL, 
    NULL, 806, 'Veal Veaeng', 'KH1506', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Thma Doun Pov', 'KH090706', NULL, 
    NULL, NULL, 507, 'Thma Bang', 'KH0907', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Thma Edth', 'KH040510', NULL, NULL, 
    NULL, 34, 'Kampong Tralach', 'KH0405', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Thma Kor', 'KH080614', NULL, NULL, 
    NULL, 11, 'Lvea Aem', 'KH0806', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Thma Kreae', 'KH100609', NULL, NULL, 
    NULL, 19, 'Chetr Borei', 'KH1006', 
    'Kratie', 'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Thma Pech', 'KH250713', NULL, NULL, 
    NULL, 83, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Thma Pun', 'KH031313', NULL, NULL, 
    NULL, 32, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Thma Pun', 'KH140407', NULL, NULL, 
    NULL, 36, 'Kanhchriech', 'KH1404', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Thma Puok', 'KH010704', NULL, NULL, 
    NULL, 133, 'Thma Puok', 'KH0107', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Thma Sa', 'KH090104', NULL, NULL, 
    NULL, 243, 'Botum Sakor', 'KH0901', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Thmea', 'KH130105', NULL, NULL, NULL, 
    353, 'Chey Saen', 'KH1301', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Thmea', 'KH200302', NULL, NULL, NULL, 
    20, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Thmei', 'KH070716', NULL, NULL, NULL, 
    68, 'Tuek Chhou', 'KH0707', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Thmei', 'KH080108', NULL, NULL, NULL, 
    6, 'Kandal Stueng', 'KH0801', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Thmei', 'KH100610', NULL, NULL, NULL, 
    454, 'Chetr Borei', 'KH1006', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Thmei', 'KH130403', NULL, NULL, NULL, 
    279, 'Kuleaen', 'KH1304', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Thmei', 'KH200211', NULL, NULL, NULL, 
    40, 'Kampong Rou', 'KH2002', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Thna Thnong', 'KH200310', NULL, NULL, 
    NULL, 30, 'Rumduol', 'KH2003', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Thummoda Ar', 'KH050712', NULL, NULL, 
    NULL, 53, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Ti Pou', 'KH060709', NULL, NULL, NULL, 
    352, 'Santuk', 'KH0607', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Tien', 'KH120520', NULL, NULL, NULL, 
    5, 'Dangkao', 'KH1205', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Ting Chak', 'KH160306', NULL, NULL, 
    NULL, 47, 'Bar Kaev', 'KH1603', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Tma Kaev', 'KH190305', NULL, NULL, 
    NULL, 376, 'Siem Pang', 'KH1903', 
    'Stung Treng', 'KH19', 'Cambodia', 
    'KH'
  ), 
  (
    'Tnaot', 'KH140408', NULL, NULL, NULL, 
    25, 'Kanhchriech', 'KH1404', 'Prey Veng', 
    'KH14', 'Cambodia', 'KH'
  ), 
  (
    'Tnaot', 'KH200212', NULL, NULL, NULL, 
    43, 'Kampong Rou', 'KH2002', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Tnaot', 'KH210213', NULL, NULL, NULL, 
    20, 'Bati', 'KH2102', 'Takeo', 'KH21', 
    'Cambodia', 'KH'
  ), 
  (
    'Tnaot Chum', 'KH060117', NULL, NULL, 
    NULL, 61, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Tnaot Chum', 'KH150311', NULL, NULL, 
    NULL, 169, 'Krakor', 'KH1503', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Tnoat Chong Srang', 'KH070209', 
    NULL, NULL, NULL, 48, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Toap Mean', 'KH050806', NULL, NULL, 
    NULL, 83, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Tong Rong', 'KH031314', NULL, NULL, 
    NULL, 18, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Tong Tralach', 'KH031414', NULL, 
    NULL, NULL, 20, 'Srei Santhor', 'KH0314', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Tonle Basak', 'KH120101', NULL, NULL, 
    NULL, 5, 'Chamkar Mon', 'KH1201', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Tonle Bet', 'KH250714', NULL, NULL, 
    NULL, 51, 'Tboung Khmum', 'KH2507', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Tonlung', 'KH250312', NULL, NULL, 
    NULL, 256, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Totung', 'KH070508', NULL, NULL, NULL, 
    28, 'Dang Tong', 'KH0705', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trab', 'KH030111', NULL, NULL, NULL, 
    160, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Trabaek', 'KH140208', NULL, NULL, 
    NULL, 42, 'Kamchay Mear', 'KH1402', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Trach Tong', 'KH050509', NULL, NULL, 
    NULL, 46, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Traeng', 'KH020704', NULL, NULL, NULL, 
    344, 'Rotonak Mondol', 'KH0207', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Traeng Trayueng', 'KH050613', NULL, 
    NULL, NULL, 601, 'Phnum Sruoch', 'KH0506', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Traeuy Kaoh', 'KH070805', NULL, NULL, 
    NULL, 22, 'Kampot', 'KH0708', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Traeuy Sla', 'KH081015', NULL, NULL, 
    NULL, 49, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tralach', 'KH211014', NULL, NULL, 
    NULL, 18, 'Treang', 'KH2110', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Tram Kak', 'KH210913', NULL, NULL, 
    NULL, 48, 'Tram Kak', 'KH2109', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Tram Sasar', 'KH171203', NULL, NULL, 
    NULL, 89, 'Srei Snam', 'KH1712', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Tramaeng', 'KH070314', NULL, NULL, 
    NULL, 17, 'Chhuk', 'KH0703', 'Kampot', 
    'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Tramung', 'KH250313', NULL, NULL, 
    NULL, 82, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Trang', 'KH021204', NULL, NULL, NULL, 
    51, 'Kamrieng', 'KH0212', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Trangel', 'KH040409', NULL, NULL, 
    NULL, 36, 'Kampong Leaeng', 'KH0404', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Bei', 'KH070313', NULL, 
    NULL, NULL, 13, 'Chhuk', 'KH0703', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Chan', 'KH040111', NULL, 
    NULL, NULL, 39, 'Baribour', 'KH0401', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Chorng', 'KH150110', NULL, 
    NULL, NULL, 83, 'Bakan', 'KH1501', 
    'Pursat', 'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Chour', 'KH050403', NULL, 
    NULL, NULL, 510, 'Aoral', 'KH0504', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Chres', 'KH160405', NULL, 
    NULL, NULL, 256, 'Koun Mom', 'KH1604', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Kong', 'KH050713', NULL, 
    NULL, NULL, 33, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Kor', 'KH030310', NULL, 
    NULL, NULL, 27, 'Cheung Prey', 'KH0303', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Kraham', 'KH160406', NULL, 
    NULL, NULL, 465, 'Koun Mom', 'KH1604', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Kranhoung', 'KH210907', 
    NULL, NULL, NULL, 47, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Krasang', 'KH120901', NULL, 
    NULL, NULL, 9, 'Pur SenChey', 'KH1209', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Krasang', 'KH210214', NULL, 
    NULL, NULL, 18, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Phleang', 'KH070309', NULL, 
    NULL, NULL, 327, 'Chhuk', 'KH0703', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Phlong', 'KH250507', NULL, 
    NULL, NULL, 139, 'Ponhea Kraek', 'KH2505', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Prasat', 'KH220506', NULL, 
    NULL, NULL, 502, 'Trapeang Prasat', 
    'KH2205', 'Oddar Meanchey', 'KH22', 
    'Cambodia', 'KH'
  ), 
  (
    'Trapeang Preah', 'KH031315', NULL, 
    NULL, NULL, 73, 'Prey Chhor', 'KH0313', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Prei', 'KH220104', NULL, 
    NULL, NULL, 113, 'Anlong Veaeng', 
    'KH2201', 'Oddar Meanchey', 'KH22', 
    'Cambodia', 'KH'
  ), 
  (
    'Trapeang Pring', 'KH070717', NULL, 
    NULL, NULL, 44, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Pring', 'KH250106', NULL, 
    NULL, NULL, 203, 'Dambae', 'KH2501', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Reang', 'KH070407', NULL, 
    NULL, NULL, 29, 'Chum Kiri', 'KH0704', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Ruessei', 'KH060209', NULL, 
    NULL, NULL, 144, 'Kampong Svay', 'KH0602', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Rung', 'KH090304', NULL, 
    NULL, NULL, 906, 'Kaoh Kong', 'KH0903', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Sab', 'KH210215', NULL, 
    NULL, NULL, 37, 'Bati', 'KH2102', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Sala Khang Kaeut', 'KH070210', 
    NULL, NULL, NULL, 22, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Sala Khang Lech', 'KH070211', 
    NULL, NULL, NULL, 17, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Sangkae', 'KH070718', NULL, 
    NULL, NULL, 13, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Sdau', 'KH200415', NULL, 
    NULL, NULL, 56, 'Romeas Haek', 'KH2004', 
    'Svay Rieng', 'KH20', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Srae', 'KH140508', NULL, 
    NULL, NULL, 43, 'Me Sang', 'KH1405', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Trapeang Tav', 'KH220103', NULL, 
    NULL, NULL, 340, 'Anlong Veaeng', 
    'KH2201', 'Oddar Meanchey', 'KH22', 
    'Cambodia', 'KH'
  ), 
  (
    'Trapeang Thum', 'KH070719', NULL, 
    NULL, NULL, 3, 'Tuek Chhou', 'KH0707', 
    'Kampot', 'KH07', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Thum', 'KH170909', NULL, 
    NULL, NULL, 28, 'Prasat Bakong', 'KH1709', 
    'Siemreap', 'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Thum Khang Cheung', 'KH210914', 
    NULL, NULL, NULL, 27, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Thum Khang Tboung', 'KH210915', 
    NULL, NULL, NULL, 33, 'Tram Kak', 'KH2109', 
    'Takeo', 'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Trapeang Veaeng', 'KH080127', NULL, 
    NULL, NULL, 12, 'Kandal Stueng', 'KH0801', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tras', 'KH200416', NULL, NULL, NULL, 
    122, 'Romeas Haek', 'KH2004', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Trea', 'KH060813', NULL, NULL, NULL, 
    119, 'Stoung', 'KH0608', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Trea', 'KH080128', NULL, NULL, NULL, 
    20, 'Kandal Stueng', 'KH0801', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Trea', 'KH210711', NULL, NULL, NULL, 
    27, 'Samraong', 'KH2107', 'Takeo', 
    'KH21', 'Cambodia', 'KH'
  ), 
  (
    'Trea', 'KH250211', NULL, NULL, NULL, 
    37, 'Krouch Chhmar', 'KH2502', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Trean', 'KH030614', NULL, NULL, NULL, 
    43, 'Kampong Siem', 'KH0306', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Treas', 'KH010807', NULL, NULL, NULL, 
    163, 'Svay Chek', 'KH0108', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Trei Nhoar', 'KH170715', NULL, NULL, 
    NULL, 55, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Triek', 'KH250314', NULL, NULL, NULL, 
    37, 'Memot', 'KH2503', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Triel', 'KH060118', NULL, NULL, NULL, 
    160, 'Baray', 'KH0601', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Chour', 'KH010408', NULL, NULL, 
    NULL, 77, 'Preah Netr Preah', 'KH0104', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek Chrov', 'KH250107', NULL, NULL, 
    NULL, 83, 'Dambae', 'KH2501', 'Tboung Khmum', 
    'KH25', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Hout', 'KH040613', NULL, NULL, 
    NULL, 48, 'Rolea B\'ier', 'KH0406', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek Khleang', 'KH080615', NULL, 
    NULL, NULL, 12, 'Lvea Aem', 'KH0806', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Kraham', 'KH130302', NULL, NULL, 
    NULL, 204, 'Choam Ksant', 'KH1303', 
    'Preah Vihear', 'KH13', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek L\'ak', 'KH050312', 'Tuek Lak', 
    NULL, NULL, 16, 'Kong Pisei', 'KH0503', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek L\'ak', 'KH180211', 'Tuek Lak', 
    NULL, NULL, 35, 'Prey Nob', 'KH1802', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek L\'ak Ti Bei', 'KH120406', 
    'Tuek Lak Ti Bei', NULL, NULL, 1, 
    'Tuol Kouk', 'KH1204', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Tuek L\'ak Ti Muoy', 'KH120404', 
    'Tuek Lak Ti Muoy', NULL, NULL, 1, 
    'Tuol Kouk', 'KH1204', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Tuek L\'ak Ti Pir', 'KH120405', 
    'Tuek Lak Ti Pir', NULL, NULL, 0, 
    'Tuol Kouk', 'KH1204', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Thla', 'KH010608', NULL, NULL, 
    NULL, 51, 'Serei Saophoan', 'KH0106', 
    'Banteay Meanchey', 'KH01', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek Thla', 'KH120802', NULL, NULL, 
    NULL, 7, 'Saensokh', 'KH1208', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Thla', 'KH141311', NULL, NULL, 
    NULL, 37, 'Svay Antor', 'KH1413', 
    'Prey Veng', 'KH14', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuek Thla', 'KH180212', NULL, NULL, 
    NULL, 72, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Vil', 'KH081016', NULL, NULL, 
    NULL, 21, 'S\'ang', 'KH0810', 'Kandal', 
    'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tuek Vil', 'KH171013', NULL, NULL, 
    NULL, 45, 'Siem Reap', 'KH1710', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Tuk Meas Khang Kaeut', 'KH070212', 
    NULL, NULL, NULL, 28, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuk Meas Khang Lech', 'KH070213', 
    NULL, NULL, NULL, 35, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Tum Ring', 'KH060609', NULL, NULL, 
    NULL, 448, 'Sandan', 'KH0606', 'Kampong Thom', 
    'KH06', 'Cambodia', 'KH'
  ), 
  (
    'Tumnob', 'KH030112', NULL, NULL, NULL, 
    19, 'Batheay', 'KH0301', 'Kampong Cham', 
    'KH03', 'Cambodia', 'KH'
  ), 
  (
    'Tumnob Dach', 'KH220505', NULL, NULL, 
    NULL, 147, 'Trapeang Prasat', 'KH2205', 
    'Oddar Meanchey', 'KH22', 'Cambodia', 
    'KH'
  ), 
  (
    'Tumnob Rolok', 'KH180303', NULL, 
    NULL, NULL, 52, 'Stueng Hav', 'KH1803', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Tumnob Thum', 'KH080913', NULL, NULL, 
    NULL, 27, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tumnob Tuek', 'KH120108', NULL, NULL, 
    NULL, 1, 'Chamkar Mon', 'KH1201', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Tumpoar Meas', 'KH050714', NULL, 
    NULL, NULL, 174, 'Samraong Tong', 
    'KH0507', 'Kampong Speu', 'KH05', 
    'Cambodia', 'KH'
  ), 
  (
    'Tuol Ampil', 'KH050111', NULL, NULL, 
    NULL, 25, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Khpos', 'KH040808', NULL, NULL, 
    NULL, 135, 'Tuek Phos', 'KH0408', 
    'Kampong Chhnang', 'KH04', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Kokir', 'KH090503', NULL, NULL, 
    NULL, 71, 'Mondol Seima', 'KH0905', 
    'Koh Kong', 'KH09', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Kreul', 'KH060407', NULL, NULL, 
    NULL, 179, 'Prasat Ballangk', 'KH0604', 
    'Kampong Thom', 'KH06', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Lvea', 'KH240103', NULL, NULL, 
    NULL, 100, 'Pailin', 'KH2401', 'Pailin', 
    'KH24', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Pongro', 'KH010905', NULL, NULL, 
    NULL, 160, 'Malai', 'KH0109', 'Banteay Meanchey', 
    'KH01', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Preah Khleang', 'KH031513', 
    NULL, NULL, NULL, 78, 'Stueng Trang', 
    'KH0315', 'Kampong Cham', 'KH03', 
    'Cambodia', 'KH'
  ), 
  (
    'Tuol Prech', 'KH080816', NULL, NULL, 
    NULL, 33, 'Angk Snuol', 'KH0808', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Sala', 'KH050112', NULL, NULL, 
    NULL, 28, 'Basedth', 'KH0501', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Sambuor', 'KH031514', NULL, 
    NULL, NULL, 182, 'Stueng Trang', 'KH0315', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Sangke', 'KH120702', NULL, NULL, 
    NULL, 3, 'Russey Keo', 'KH1207', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Sdei', 'KH200110', NULL, NULL, 
    NULL, 73, 'Chantrea', 'KH2001', 'Svay Rieng', 
    'KH20', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Snuol', 'KH250212', NULL, NULL, 
    NULL, 123, 'Krouch Chhmar', 'KH2502', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Souphi', 'KH250407', NULL, NULL, 
    NULL, 47, 'Ou Reang Ov', 'KH2504', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Svay Prey Ti Muoy', 'KH120106', 
    NULL, NULL, NULL, 1, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Svay Prey Ti Pir', 'KH120107', 
    NULL, NULL, NULL, 0, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Ta Ek', 'KH020301', NULL, NULL, 
    NULL, 4, 'Battambang', 'KH0203', 'Battambang', 
    'KH02', 'Cambodia', 'KH'
  ), 
  (
    'Tuol Totueng', 'KH180213', NULL, 
    NULL, NULL, 52, 'Prey Nob', 'KH1802', 
    'Preah Sihanouk', 'KH18', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Tumpung Ti Muoy', 'KH120110', 
    NULL, NULL, NULL, 1, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Tuol Tumpung Ti Pir', 'KH120109', 
    NULL, NULL, NULL, 0, 'Chamkar Mon', 
    'KH1201', 'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Vaot Ta Muem', 'KH020810', NULL, 
    NULL, NULL, 41, 'Sangkae', 'KH0208', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Varin', 'KH171405', NULL, NULL, NULL, 
    201, 'Varin', 'KH1714', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Veal', 'KH050313', NULL, NULL, NULL, 
    27, 'Kong Pisei', 'KH0503', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Veal', 'KH150209', NULL, NULL, NULL, 
    5, 'Kandieng', 'KH1502', 'Pursat', 
    'KH15', 'Cambodia', 'KH'
  ), 
  (
    'Veal Mlu', 'KH250508', NULL, NULL, 
    NULL, 34, 'Ponhea Kraek', 'KH2505', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Veal Pon', 'KH050807', NULL, NULL, 
    NULL, 31, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Veal Pong', 'KH050510', NULL, NULL, 
    NULL, 53, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Veal Renh', 'KH180214', NULL, NULL, 
    NULL, 16, 'Prey Nob', 'KH1802', 'Preah Sihanouk', 
    'KH18', 'Cambodia', 'KH'
  ), 
  (
    'Veal Sbov', 'KH121205', NULL, NULL, 
    NULL, 8, 'Chbar Ampov', 'KH1212', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Veal Vong', 'KH030504', NULL, NULL, 
    NULL, 3, 'Kampong Cham', 'KH0305', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Veal Vong', 'KH120307', NULL, NULL, 
    NULL, 1, 'Prampir Meakkakra', 'KH1203', 
    'Phnom Penh', 'KH12', 'Cambodia', 
    'KH'
  ), 
  (
    'Veang Chas', 'KH050511', NULL, NULL, 
    NULL, 7, 'Odongk', 'KH0505', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Veun Sai', 'KH160910', NULL, NULL, 
    NULL, 355, 'Veun Sai', 'KH1609', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Vihear Luong', 'KH080914', NULL, 
    NULL, NULL, 8, 'Ponhea Lueu', 'KH0809', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Vihear Luong', 'KH250602', NULL, 
    NULL, NULL, 72, 'Suong', 'KH2506', 
    'Tboung Khmum', 'KH25', 'Cambodia', 
    'KH'
  ), 
  (
    'Vihear Suork', 'KH080318', NULL, 
    NULL, NULL, 43, 'Khsach Kandal', 'KH0803', 
    'Kandal', 'KH08', 'Cambodia', 'KH'
  ), 
  (
    'Vihear Thum', 'KH030615', NULL, NULL, 
    NULL, 35, 'Kampong Siem', 'KH0306', 
    'Kampong Cham', 'KH03', 'Cambodia', 
    'KH'
  ), 
  (
    'Voa Sar', 'KH050715', NULL, NULL, 
    NULL, 29, 'Samraong Tong', 'KH0507', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  ), 
  (
    'Voadthonak', 'KH100410', NULL, NULL, 
    NULL, 239, 'Sambour', 'KH1004', 'Kratie', 
    'KH10', 'Cambodia', 'KH'
  ), 
  (
    'Voat Angk Khang Cheung', 'KH070214', 
    NULL, NULL, NULL, 13, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Voat Angk Khang Tboung', 'KH070215', 
    NULL, NULL, NULL, 20, 'Banteay Meas', 
    'KH0702', 'Kampot', 'KH07', 'Cambodia', 
    'KH'
  ), 
  (
    'Voat Phnum', 'KH120211', NULL, NULL, 
    NULL, 1, 'Doun Penh', 'KH1202', 'Phnom Penh', 
    'KH12', 'Cambodia', 'KH'
  ), 
  (
    'Wat Kor', 'KH020308', NULL, NULL, 
    NULL, 25, 'Battambang', 'KH0203', 
    'Battambang', 'KH02', 'Cambodia', 
    'KH'
  ), 
  (
    'Ya Tung', 'KH160707', NULL, NULL, 
    NULL, 441, 'Ou Ya Dav', 'KH1607', 
    'Ratanak Kiri', 'KH16', 'Cambodia', 
    'KH'
  ), 
  (
    'Yea Angk', 'KH050808', NULL, NULL, 
    NULL, 151, 'Thpong', 'KH0508', 'Kampong Speu', 
    'KH05', 'Cambodia', 'KH'
  ), 
  (
    'Yeak Laom', 'KH160203', NULL, NULL, 
    NULL, 57, 'Ban Lung', 'KH1602', 'Ratanak Kiri', 
    'KH16', 'Cambodia', 'KH'
  ), 
  (
    'Yeang', 'KH130305', NULL, NULL, NULL, 
    679, 'Choam Ksant', 'KH1303', 'Preah Vihear', 
    'KH13', 'Cambodia', 'KH'
  ), 
  (
    'Yeang', 'KH170716', NULL, NULL, NULL, 
    44, 'Puok', 'KH1707', 'Siemreap', 
    'KH17', 'Cambodia', 'KH'
  ), 
  (
    'Yutth Sameakki', 'KH050512', NULL, 
    NULL, NULL, 36, 'Odongk', 'KH0505', 
    'Kampong Speu', 'KH05', 'Cambodia', 
    'KH'
  );  
  
  
  
  
  
  
  
  
  
  
