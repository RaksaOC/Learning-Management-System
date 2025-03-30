# 📚 Learning Management System (LMS)

## Overview

The **Learning Management System (LMS)** is a **feature-rich, JavaFX-based** educational platform designed for efficient administration and seamless interaction between **students, teachers, and administrators**. Built with **Object-Oriented Programming (OOP) principles**, **MVC architecture**, and a **modular system design**, this application ensures scalability, maintainability, and ease of use.

The system consists of two primary applications:

- **LMS-Admin**: A tool for managing university entities, users, and academic administration.
- **LMS-User**: An interactive platform for students and teachers, offering academic functionalities such as assignments, quizzes, and classroom interactions.

With a **MySQL-powered backend**, a **modern JavaFX user interface**, and an **MVC-based structure**, the LMS is designed for efficiency and smooth user experience.

---

## 🚀 Key Features

- ✅ **JavaFX-based UI with modern design**
- ✅ **MySQL database for scalable, persistent storage**
- ✅ **Modular architecture** for ease of maintenance
- ✅ **Automated session handling** for quick user automatic login
- ✅ **Seamless student-teacher interactions**
- ✅ **Real-time data retrieval & updates using JDBC & a cloud database**

---

## 🏡 LMS-Admin Application

### 1️⃣ User Management

- **Students**: Add, edit, remove students, and assign them to batches.
- **Teachers**: Assign courses, track assignments, and remove/edit teachers.
- **Admins**: Manage admin accounts with role-based access control.

### 2️⃣ Academic Structure Management

- **Departments & Specializations**: Define academic departments and available specializations.
- **Generations & Groups**: Organize students into academic batches and study groups.
- **Classrooms**: Assign students and teachers to virtual classrooms for structured learning.

### 3️⃣ Dashboard & Insights

- **User Statistics**: Monitor user count, assignments, and course activity.
- **Logging History**: View students and teachers who log in to use the app.

---

## 🎓 LMS-User Application

### 🔑 Authentication & Role Selection

- Users can **log in as a student or teacher**.
- **Auto-login system** remembers last session.
- **Role-based functionalities/UI** for teachers and students.

### 📌 Main Menu

- **View Classrooms** – Displays assigned classrooms.
- **View Profile** – Shows user details and assigned courses.
- **View Assignments, Material & Quizzes** – Access classroom content and view all assigned tasks globally.
- **Logout** – Ends the current session.
- **Switch User** – Allows users to seamlessly switch between accounts.

### 🏢 Classroom Interaction

- **Students**:
    - View and submit assignments with URL uploads.
    - Access learning materials.
    - Participate in quizzes with automated grading.
- **Teachers**:
    - Create assignments.
    - Upload learning resources.
    - Design quizzes with customizable question sets.
    - Grade students.

---

## 🖼️ Screenshots



## 🛠 Technical Aspects

### 🔮 Design Principles

- **Object-Oriented Programming (OOP)** – Efficient class structures, inheritance, encapsulation, polymorphism, and abstraction.
- **MVC Architecture** – Separates business logic (controllers), data management (managers), and UI (views).
- **MySQL Database** – Persistent data storage with JDBC integration.
- **JavaFX UI** – Interactive and responsive GUI.
- **Real-time Data Handling** – Efficient CRUD operations with prepared statements to prevent SQL injection.

### 🔍 UML Class Diagram

- **LMS-Admin**
  ![UML](https://github.com/RaksaOC/Learning-Management-System/blob/ca1d549bf0e753b104d24ecf46be0b293f0747c5/doc/images/LMS-Admin-UML.drawio.png)

- **LMS-User**

(Coming Soon...)

### 📂 Database Schema / ER Diagram

**ER Diagram**

![ER Diagram](https://github.com/RaksaOC/Learning-Management-System/blob/6bb113f21b0d55f6e15d8bf1ec0138a1254612be/doc/images/ERD.png)

**Relational Schema**

![Schema](https://github.com/RaksaOC/Learning-Management-System/blob/abcc62779cfed1423e73e7d9db188cf5906f704d/doc/images/Schema.svg)


### 🌍 Project Structure

```
.
├── LMS
│   ├── LMS.iml
│   ├── assets
│   └── src
│       ├── main
│       │   ├── Main.java
│       │   └── MainController.java
│       └── utils
│           ├── controller
│           │   ├── AuthenticationController.java
│           │   ├── ClassroomController.java
│           │   ├── StudentController.java
│           │   └── TeacherController.java
│           ├── manager
│           │   ├── AuthenticationManager.java
│           │   ├── ClassroomManager.java
│           │   ├── StudentManager.java
│           │   └── TeacherManager.java
│           └── menu
│               └── Menu.java
├── LMS-Admin
│   ├── LMS-Admin.iml
│   └── src
│       ├── main
│       │   ├── Main.java
│       │   └── MainController.java
│       └── utils
│           ├── controller
│           │   ├── authentication_controller
│           │   │   └── AuthenticationController.java
│           │   ├── edit_entity_controller
│           │   │   ├── EditAdminController.java
│           │   │   ├── EditClassroomController.java
│           │   │   ├── EditDepartmentController.java
│           │   │   ├── EditEntityController.java
│           │   │   ├── EditGenerationController.java
│           │   │   ├── EditGroupController.java
│           │   │   ├── EditSpecializationController.java
│           │   │   ├── EditStudentController.java
│           │   │   └── EditTeacherController.java
│           │   └── manage_entity_controller
│           │       ├── ManageAdminController.java
│           │       ├── ManageClassroomController.java
│           │       ├── ManageDepartmentController.java
│           │       ├── ManageEntityController.java
│           │       ├── ManageGenerationController.java
│           │       ├── ManageGroupController.java
│           │       ├── ManageSpecializationController.java
│           │       ├── ManageStudentController.java
│           │       └── ManageTeacherController.java
│           ├── manager
│           │   ├── authentication_manager
│           │   │   └── AuthManager.java
│           │   ├── edit_entity_manager
│           │   │   ├── EditAdminManager.java
│           │   │   ├── EditClassroomManager.java
│           │   │   ├── EditDepartmentManager.java
│           │   │   ├── EditEntityManager.java
│           │   │   ├── EditGenerationManager.java
│           │   │   ├── EditGroupManager.java
│           │   │   ├── EditSpecializationManager.java
│           │   │   ├── EditStudentManager.java
│           │   │   └── EditTeacherManager.java
│           │   └── manage_entity_manager
│           │       ├── ManageAdminManager.java
│           │       ├── ManageClassroomManager.java
│           │       ├── ManageDepartmentManager.java
│           │       ├── ManageEntityManager.java
│           │       ├── ManageGenerationManager.java
│           │       ├── ManageGroupManager.java
│           │       ├── ManageSpecializationManager.java
│           │       ├── ManageStudentManager.java
│           │       └── ManageTeacherManager.java
│           └── menu
│               ├── Menu.java
│               └── MenuManager.java
├── LMS-Admin-GUI
│   ├── LMS-Admin-GUI.iml
│   └── src
│       └── main
│           ├── DatabaseConnection.java
│           ├── Main.java
│           ├── SceneManager.java
│           ├── java
│           │   └── com
│           │       └── lmsAdmin
│           │           ├── controllers
│           │           │   ├── layer0
│           │           │   │   ├── LogInController.java
│           │           │   │   └── MainFrameController.java
│           │           │   ├── layer1
│           │           │   │   ├── DashboardController.java
│           │           │   │   ├── ManageAdminController.java
│           │           │   │   ├── ManageClassroomController.java
│           │           │   │   ├── ManageCourseController.java
│           │           │   │   ├── ManageDepartmentController.java
│           │           │   │   ├── ManageGenerationController.java
│           │           │   │   ├── ManageGroupController.java
│           │           │   │   ├── ManageSpecializationController.java
│           │           │   │   ├── ManageStudentController.java
│           │           │   │   └── ManageTeacherController.java
│           │           │   ├── layer2
│           │           │   │   ├── adminActionController
│           │           │   │   │   ├── AddAdminController.java
│           │           │   │   │   ├── DeleteAdminController.java
│           │           │   │   │   ├── EditAdminController.java
│           │           │   │   │   └── ViewAdminController.java
│           │           │   │   ├── classroomActionController
│           │           │   │   │   ├── AddClassroomController.java
│           │           │   │   │   ├── DeleteClassroomController.java
│           │           │   │   │   ├── EditClassroomController.java
│           │           │   │   │   └── ViewClassroomController.java
│           │           │   │   ├── courseActionController
│           │           │   │   │   ├── AddCourseController.java
│           │           │   │   │   ├── DeleteCourseController.java
│           │           │   │   │   ├── EditCourseController.java
│           │           │   │   │   └── ViewCourseController.java
│           │           │   │   ├── departmentActionController
│           │           │   │   │   ├── AddDepartmentController.java
│           │           │   │   │   ├── DeleteDepartmentController.java
│           │           │   │   │   ├── EditDepartmentController.java
│           │           │   │   │   └── ViewDepartmentController.java
│           │           │   │   ├── generationActionController
│           │           │   │   │   ├── AddGenerationController.java
│           │           │   │   │   ├── DeleteGenerationController.java
│           │           │   │   │   ├── EditGenerationController.java
│           │           │   │   │   └── ViewGenerationController.java
│           │           │   │   ├── groupActionController
│           │           │   │   │   ├── AddGroupController.java
│           │           │   │   │   ├── AddStudentToGroupController.java
│           │           │   │   │   ├── DeleteGroupController.java
│           │           │   │   │   ├── EditGroupController.java
│           │           │   │   │   └── ViewGroupController.java
│           │           │   │   ├── specializationActionController
│           │           │   │   │   ├── AddSpecializationController.java
│           │           │   │   │   ├── DeleteSpecializationController.java
│           │           │   │   │   ├── EditSpecializationController.java
│           │           │   │   │   └── ViewSpecializationController.java
│           │           │   │   ├── studentActionController
│           │           │   │   │   ├── AddStudentController.java
│           │           │   │   │   ├── DeleteStudentController.java
│           │           │   │   │   ├── EditStudentController.java
│           │           │   │   │   └── ViewStudentController.java
│           │           │   │   └── teacherActionController
│           │           │   │       ├── AddTeacherController.java
│           │           │   │       ├── DeleteTeacherController.java
│           │           │   │       ├── EditTeacherController.java
│           │           │   │       └── ViewTeacherController.java
│           │           │   └── layer3
│           │           │       ├── adminEditControllers
│           │           │       │   ├── EditAdminDOBController.java
│           │           │       │   ├── EditAdminEmailController.java
│           │           │       │   ├── EditAdminGenderController.java
│           │           │       │   ├── EditAdminNameController.java
│           │           │       │   ├── EditAdminPasswordController.java
│           │           │       │   └── EditAdminPhoneController.java
│           │           │       ├── classroomEditControllers
│           │           │       │   └── EditClassroomIDController.java
│           │           │       ├── courseEditControllers
│           │           │       │   ├── EditCourseIDController.java
│           │           │       │   └── EditCourseNameController.java
│           │           │       ├── departmentEditControllers
│           │           │       │   ├── EditDepartmentIDController.java
│           │           │       │   └── EditDepartmentNameController.java
│           │           │       ├── generationEditController
│           │           │       │   ├── EditGenerationIDController.java
│           │           │       │   └── EditGenerationNameController.java
│           │           │       ├── groupEditControllers
│           │           │       │   └── EditGroupIDController.java
│           │           │       ├── specializationEditControllers
│           │           │       │   ├── EditSpecializationIDController.java
│           │           │       │   └── EditSpecializationNameController.java
│           │           │       ├── studentEditControllers
│           │           │       │   ├── EditStudentAddressController.java
│           │           │       │   ├── EditStudentDOBController.java
│           │           │       │   ├── EditStudentDepartmentController.java
│           │           │       │   ├── EditStudentEmailController.java
│           │           │       │   ├── EditStudentGenderController.java
│           │           │       │   ├── EditStudentGuardianController.java
│           │           │       │   ├── EditStudentNameController.java
│           │           │       │   ├── EditStudentPasswordController.java
│           │           │       │   ├── EditStudentPhoneNumberController.java
│           │           │       │   └── EditStudentSpecializationController.java
│           │           │       └── teacherEditControllers
│           │           │           ├── EditTeacherDOBController.java
│           │           │           ├── EditTeacherEmailController.java
│           │           │           ├── EditTeacherGenderController.java
│           │           │           ├── EditTeacherNameController.java
│           │           │           ├── EditTeacherPasswordController.java
│           │           │           └── EditTeacherPhoneController.java
│           │           └── managers
│           │               ├── layer0
│           │               │   └── authentication_manager
│           │               │       └── AuthManager.java
│           │               ├── layer1
│           │               │   └── DashboardManager.java
│           │               ├── layer2
│           │               │   └── manage_entity_manager
│           │               │       ├── ManageAdminManager.java
│           │               │       ├── ManageClassroomManager.java
│           │               │       ├── ManageCourseManager.java
│           │               │       ├── ManageDepartmentManager.java
│           │               │       ├── ManageEntityManager.java
│           │               │       ├── ManageGenerationManager.java
│           │               │       ├── ManageGroupManager.java
│           │               │       ├── ManageSpecializationManager.java
│           │               │       ├── ManageStudentManager.java
│           │               │       └── ManageTeacherManager.java
│           │               └── layer3
│           │                   └── edit_entity_manager
│           │                       ├── EditAdminManager.java
│           │                       ├── EditClassroomManager.java
│           │                       ├── EditCourseManager.java
│           │                       ├── EditDepartmentManager.java
│           │                       ├── EditEntityManager.java
│           │                       ├── EditGenerationManager.java
│           │                       ├── EditGroupManager.java
│           │                       ├── EditSpecializationManager.java
│           │                       ├── EditStudentManager.java
│           │                       ├── EditTeacherManager.java
│           │                       └── utils
│           │                           └── CambodiaAdministrative.java
│           └── resources
│               └── com
│                   └── lmsAdmin
│                       ├── images
│                       │   ├── Home-icon.png
│                       │   ├── avatar.png
│                       │   ├── banner.png
│                       │   ├── banner2.jpg
│                       │   ├── classroom-icon.png
│                       │   ├── course-icon.png
│                       │   ├── img.png
│                       │   ├── loading.png
│                       │   ├── logo.png
│                       │   ├── logout.png
│                       │   ├── menu.png
│                       │   ├── student-icon.png
│                       │   ├── success.png
│                       │   └── teacher-icon.png
│                       ├── styles
│                       │   ├── logIn.css
│                       │   └── mainFrame.css
│                       └── views
│                           ├── layer0
│                           │   ├── authenticationView
│                           │   │   ├── LogInView.fxml
│                           │   │   └── LogInView2.fxml
│                           │   ├── homeView
│                           │   │   └── HomeView.fxml
│                           │   └── layer0.md
│                           ├── layer1
│                           │   ├── DashboardView.fxml
│                           │   ├── ManageAdminView.fxml
│                           │   ├── ManageClassroomView.fxml
│                           │   ├── ManageCourseView.fxml
│                           │   ├── ManageDepartmentView.fxml
│                           │   ├── ManageGenerationView.fxml
│                           │   ├── ManageGroupView.fxml
│                           │   ├── ManageSpecializationView.fxml
│                           │   ├── ManageStudentView.fxml
│                           │   ├── ManageTeacherView.fxml
│                           │   └── layer1.md
│                           ├── layer2
│                           │   ├── AdminActionView
│                           │   │   ├── AddAdminView.fxml
│                           │   │   ├── DeleteAdminView.fxml
│                           │   │   ├── EditAdminView.fxml
│                           │   │   └── ViewAdminView.fxml
│                           │   ├── ClassroomActionView
│                           │   │   ├── AddClassroomView.fxml
│                           │   │   ├── DeleteClassroomView.fxml
│                           │   │   ├── EditClassroomView.fxml
│                           │   │   └── ViewClassroomView.fxml
│                           │   ├── CourseActionView
│                           │   │   ├── AddCourseView.fxml
│                           │   │   ├── DeleteCourseView.fxml
│                           │   │   ├── EditCourseView.fxml
│                           │   │   └── ViewCourseView.fxml
│                           │   ├── DepartmentActionView
│                           │   │   ├── AddDepartmentView.fxml
│                           │   │   ├── DeleteDepartmentView.fxml
│                           │   │   ├── EditDepartmentView.fxml
│                           │   │   └── ViewDepartmentView.fxml
│                           │   ├── GenerationActionView
│                           │   │   ├── AddGenerationView.fxml
│                           │   │   ├── DeleteGenerationView.fxml
│                           │   │   ├── EditGenerationView.fxml
│                           │   │   └── ViewGenerationView.fxml
│                           │   ├── GroupActionView
│                           │   │   ├── AddGroupView.fxml
│                           │   │   ├── AddStudentToGroupView.fxml
│                           │   │   ├── DeleteGroupView.fxml
│                           │   │   ├── EditGroupView.fxml
│                           │   │   └── ViewGroupView.fxml
│                           │   ├── SpecializationActionView
│                           │   │   ├── AddSpecializationView.fxml
│                           │   │   ├── DeleteSpecializationView.fxml
│                           │   │   ├── EditSpecializationView.fxml
│                           │   │   └── ViewSpecializationView.fxml
│                           │   ├── StudentActionView
│                           │   │   ├── AddStudentView.fxml
│                           │   │   ├── DeleteStudentView.fxml
│                           │   │   ├── EditStudentView.fxml
│                           │   │   └── ViewStudentView.fxml
│                           │   └── TeacherActionView
│                           │       ├── AddTeacherView.fxml
│                           │       ├── DeleteTeacherView.fxml
│                           │       ├── EditTeacherView.fxml
│                           │       └── ViewTeacherView.fxml
│                           ├── layer3
│                           │   ├── AdminEditView
│                           │   │   ├── EditAdminDOB.fxml
│                           │   │   ├── EditAdminEmail.fxml
│                           │   │   ├── EditAdminGender.fxml
│                           │   │   ├── EditAdminName.fxml
│                           │   │   ├── EditAdminPassword.fxml
│                           │   │   └── EditAdminPhoneNumber.fxml
│                           │   ├── ClassroomEditView
│                           │   │   └── EditClassroomID.fxml
│                           │   ├── CourseEditView
│                           │   │   ├── EditCourseID.fxml
│                           │   │   ├── EditCourseName.fxml
│                           │   │   └── note.md
│                           │   ├── DepartmentEditView
│                           │   │   ├── EditDepartmentID.fxml
│                           │   │   └── EditDepartmentName.fxml
│                           │   ├── GenerationEditView
│                           │   │   ├── EditGenerationID.fxml
│                           │   │   └── EditGenerationName.fxml
│                           │   ├── GroupEditView
│                           │   │   └── EditGroupID.fxml
│                           │   ├── SpecializationEditView
│                           │   │   ├── EditSpecializationID.fxml
│                           │   │   └── EditSpecializationName.fxml
│                           │   ├── StudentEditView
│                           │   │   ├── EditStudentAddress.fxml
│                           │   │   ├── EditStudentDOB.fxml
│                           │   │   ├── EditStudentDepartment.fxml
│                           │   │   ├── EditStudentEmail.fxml
│                           │   │   ├── EditStudentGender.fxml
│                           │   │   ├── EditStudentGuardian.fxml
│                           │   │   ├── EditStudentName.fxml
│                           │   │   ├── EditStudentPassword.fxml
│                           │   │   ├── EditStudentPhoneNumber.fxml
│                           │   │   └── EditStudentSpecialization.fxml
│                           │   └── TeacherEditView
│                           │       ├── EditTeacherDOB.fxml
│                           │       ├── EditTeacherEmail.fxml
│                           │       ├── EditTeacherGender.fxml
│                           │       ├── EditTeacherName.fxml
│                           │       ├── EditTeacherPassword.fxml
│                           │       └── EditTeacherPhoneNumber.fxml
│                           └── misc
│                               ├── LoadingScene.fxml
│                               └── SuccessView.fxml
├── LMS-GUI
│   ├── LMS-GUI.iml
│   └── src
│       └── main
│           ├── AppSession.java
│           ├── DatabaseConnection.java
│           ├── Main.java
│           ├── SceneManager.java
│           ├── java
│           │   └── com
│           │       └── lms
│           │           ├── controllers
│           │           │   ├── StudentMainFrameController.java
│           │           │   ├── TeacherMainFrameController.java
│           │           │   ├── UserTypeController.java
│           │           │   ├── studentSide
│           │           │   │   ├── AssignmentSubmissionController.java
│           │           │   │   ├── ClassroomContentsController.java
│           │           │   │   ├── DashboardController.java
│           │           │   │   ├── DoQuizController.java
│           │           │   │   ├── ResourceSubmissionController.java
│           │           │   │   ├── StudentClassroomsController.java
│           │           │   │   ├── StudentLogInController.java
│           │           │   │   ├── StudentProfileSettingsController.java
│           │           │   │   └── componentsController
│           │           │   │       ├── AssignmentCardsWrapperController.java
│           │           │   │       ├── ClassroomCardsWrapperController.java
│           │           │   │       ├── QuizCardsWrapperController.java
│           │           │   │       └── ResourceCardsWrapperController.java
│           │           │   └── teacherSide
│           │           │       ├── AddAssignmentController.java
│           │           │       ├── AddQuizController.java
│           │           │       ├── AddResourceController.java
│           │           │       ├── AssignmentViewController.java
│           │           │       ├── ClassroomContentsController.java
│           │           │       ├── ClassroomsController.java
│           │           │       ├── DashboardController.java
│           │           │       ├── EditAssignmentController.java
│           │           │       ├── EditQuizController.java
│           │           │       ├── EditResourceController.java
│           │           │       ├── GradeAssignmentController.java
│           │           │       ├── QuizViewController.java
│           │           │       ├── ResourceViewController.java
│           │           │       ├── TeacherLogInController.java
│           │           │       └── TeacherProfileSettingsController.java
│           │           └── managers
│           │               ├── AuthenticationManager.java
│           │               ├── studentSide
│           │               │   ├── AssignmentsManager.java
│           │               │   ├── ClassroomsManger.java
│           │               │   ├── DashboardManager.java
│           │               │   ├── QuizzesManager.java
│           │               │   └── ResourcesManager.java
│           │               └── teacherSide
│           │                   ├── AssignmentManager.java
│           │                   ├── ClassroomContentManager.java
│           │                   ├── ClassroomsManger.java
│           │                   ├── DashboardManager.java
│           │                   ├── ResourceManager.java
│           │                   └── TeacherQuizManager.java
│           └── resources
│               └── com
│                   └── lms
│                       ├── images
│                       │   ├── Home-icon.png
│                       │   ├── assignments-icon.png
│                       │   ├── avatar.png
│                       │   ├── back-icon.png
│                       │   ├── banner.png
│                       │   ├── banner2.jpg
│                       │   ├── classroom-icon.png
│                       │   ├── course-icon.png
│                       │   ├── dashboard-icon.png
│                       │   ├── grade-report-icon.png
│                       │   ├── img.png
│                       │   ├── logo.png
│                       │   ├── logout.png
│                       │   ├── menu.png
│                       │   ├── quizzes-icon.png
│                       │   ├── resources-icon.png
│                       │   ├── settings-icon.png
│                       │   ├── student-icon.png
│                       │   ├── success.png
│                       │   ├── switch-user.png
│                       │   └── teacher-icon.png
│                       └── views
│                           ├── StudentMainFrame.fxml
│                           ├── TeacherMainFrame.fxml
│                           ├── UserType.fxml
│                           ├── studentSide
│                           │   ├── AssignmentSubmission.fxml
│                           │   ├── Assignments.fxml
│                           │   ├── ClassroomContents.fxml
│                           │   ├── Classrooms.fxml
│                           │   ├── Dashboard.fxml
│                           │   ├── DoQuiz.fxml
│                           │   ├── GradeReport.fxml
│                           │   ├── LogIn.fxml
│                           │   ├── Profile-Settings.fxml
│                           │   ├── Quizzes.fxml
│                           │   ├── ResourceSubmission.fxml
│                           │   ├── Resources.fxml
│                           │   ├── Test.fxml
│                           │   └── components
│                           │       ├── AssignmentCardsWrapper.fxml
│                           │       ├── ClassroomCardsWrapper.fxml
│                           │       ├── QuizCardsWrapper.fxml
│                           │       └── ResourceCardsWrapper.fxml
│                           └── teacherSide
│                               ├── AddAssignment.fxml
│                               ├── AddQuiz.fxml
│                               ├── AddResource.fxml
│                               ├── AssignmentView.fxml
│                               ├── ClassroomContents.fxml
│                               ├── Classrooms.fxml
│                               ├── Dashboard.fxml
│                               ├── EditAssignment.fxml
│                               ├── EditQuiz.fxml
│                               ├── EditResource.fxml
│                               ├── GradeAssignment.fxml
│                               ├── LogIn.fxml
│                               ├── Profile-Settings.fxml
│                               ├── QuizResult.fxml
│                               ├── QuizView.fxml
│                               └── ResourceView.fxml
├── README.md
├── README2.md
├── doc
│   ├── images
│   │   ├── ERD.png
│   │   ├── LMS-Admin-UML.drawio.png
│   │   └── Untitled Diagram.drawio
│   ├── log
│   │   ├── General-log.md
│   │   ├── LMS-admin-log.md
│   │   └── LMS-log.md
│   └── reources
│       ├── How-to-Database.md
│       ├── How-to-org-json.md
│       ├── How-to-org-jsonV2.md
│       └── Structure-and-tips.md


```

### 📺 Dependencies

- **JavaFX** – GUI framework for interactive UIs.
- **MySQL Connector/J** – JDBC driver for database interaction.
- **org.json** – JSON parsing library.
- **SHA-256 Library** – Secure hashing for password encryption.

### ▶️ How to Compile & Run

#### **LMS-Admin**

1. Install **Java JDK 17+**.
2. Clone the repository:
   ```sh
   git clone https://github.com/RaksaOC/Learning-Management-System.git
   ```
3. **Using IntelliJ IDEA:**
    - Navigate to `shared/lib/openjfx-23.0.2_windows-x64_bin-sdk/javafx-sdk-23.0.2/lib/`.
    - Copy the absolute path.
    - Go to **Run Configuration** of `LMS-Admin-GUI`.
    - Paste the absolute path in **VM options**:
      ```
      --module-path "<absolute path>" --add-modules javafx.controls,javafx.fxml
      ```
    - Click **Run**.
4. **Using the terminal:**
   ```sh
   java --module-path "path/to/javafx" --add-modules javafx.controls,javafx.fxml -jar LMS-Admin.jar
   ```

#### **LMS-User**

1. Navigate to `LMS-User` and run:
   ```sh
   java --module-path "path/to/javafx" --add-modules javafx.controls,javafx.fxml -jar LMS-User.jar
   ```

---

## 🖥️ CLI Versions

There are also two **CLI-based** versions of this project that use **JSON** for data storage.

### **LMS-Admin (CLI)**
- Open IntelliJ IDEA.
- Click **Run** to start the application.

### **LMS-User (CLI)**
- Open IntelliJ IDEA.
- Click **Run** to start the application.

---

## 👥 Contributors

- **Ory Chanraksa**
- **Hong Layeang**
- **Kong Visal**
- **Sao Visal**

## 🎓 Supervisor

- **Mr. Lay Vathna**, Lecturer and Researcher at CADT
- **Mr. Korat Natt**, Lecturer and Assistant Researcher at CADT

## 🙏 Acknowledgements

Thank you for visiting this GitHub repository. If you encounter any issues or have questions, feel free to contact us at [ocraksa@gmail.com](mailto:ocraksa@gmail.com).

---

*This document serves as a comprehensive overview of the LMS project, ensuring clarity and structured development.*

