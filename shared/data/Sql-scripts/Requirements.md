**LMS System Requirements:**

1. **Department, Specialization, and Group Management**:
    - Students must be assigned to **departments**, **specializations**, and **student groups**.
    - Each **group** should be tied to a specific **generation** and **specialization**, with the ability to assign multiple students to a group.
    - The system should allow for **dynamic assignment** of students to groups based on changing administrative needs.

2. **Student Enrollment and Registration**:
    - The system should allow **admins** to **register students, teachers and admins**.
    - The enrollment process should capture the student's **registration date**, and **chosen department and specialization**.
    - Admins have the ability to create the entire structure of the university.

3. **User Management**:
    - **Admins** should have the ability to **add, deactivate, and update** user profiles (students and teachers).
    - Admins will also manage **departments**, **courses**, and **specializations**.
    - **Student and Teacher Profiles** will store basic information such as name, gender, contact details, status (active/inactive), and assigned department/specialization.
    - Admins can filter and search users based on various criteria for efficient management.

4. **Login and Auto-Login**:
    - The system should support **automatic login** using stored session data to enhance user convenience.
    - **Login history** should be recorded, allowing admins to track login/logout times and activities for monitoring user engagement.
    - The system should ensure **secure login** practices, including data encryption using **SHA-256**.

5. **Classroom and Course Management**:
    - **Teachers** will be able to assign materials, quizzes, and assignments to specific **classrooms**.
    - The system must link **classrooms** with **courses**, **teachers**, and **student groups** for streamlined management.
    - **Students** will access and complete assignments, quizzes, and materials tied to their **classrooms**.

6. **Progress Tracking**:
    - The system should track and display **student progress** related to **assignments**, **quizzes**, and other **learning materials**.
    - Each student's progress will be linked to a specific **classroom**, making it easier to track course completion and assessment scores.
    - **Scores** and **completion status** for **assignments** and **quizzes** should be recorded and easily accessible for both students and admins.

7. **System Status and Activity**:
    - Every entity (users, courses, classrooms, etc.) should have an **active/inactive status** field to monitor and control visibility within the system.
    - The system should use **soft deletes** for data removal, ensuring that records are only marked as inactive rather than permanently deleted.
    - **Audit trails** should be maintained for key actions like data changes or deletions, allowing admins to track activities.