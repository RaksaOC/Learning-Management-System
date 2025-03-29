# 📚 Learning Management System (LMS)

## Overview
The **Learning Management System (LMS)** is a **feature-rich, CLI-based** educational platform designed for efficient administration and seamless interaction between **students, teachers, and administrators**. Built with **Object-Oriented Programming (OOP) principles** and structured using a **modular system design**, this application ensures scalability, maintainability, and ease of use.

It consists of two primary applications:
- **LMS-Admin**: Manages university entities, user roles, and administrative functions.
- **LMS-User**: Provides an interactive experience for students and teachers, featuring automated login, classroom interactions, and academic functionalities.

The system boasts over **60 functionalities**, meticulously designed to enhance academic management, streamline user interactions, and provide a seamless CLI-based experience.

---

## 🚀 Key Features
- ✅ **CLI-based UI with enhanced visuals** (ASCII banners, color-coded text).
- ✅ **60+ core functionalities** for efficient academic management.
- ✅ **Persistent storage using JSON files** for structured data.
- ✅ **Scalable OOP design** for future feature integration.
- ✅ **Automated session handling** for faster access.
- ✅ **Seamless classroom interactions** with role-specific capabilities.

---

## 🏡 LMS-Admin Application

### 1️⃣ Manage Users
- **Manage Students**: Add, edit, remove students, and assign them to batches.
- **Manage Teachers**: Assign courses, track assignments, and remove/edit teachers.

### 2️⃣ Manage University Structure
- **Departments & Specializations**: Define academic departments and available specializations.
- **Generations & Groups**: Organize students into academic batches and study groups.
- **Classrooms**: Assign students and teachers to virtual classrooms for structured learning.

### 3️⃣ Manage Admins
- **Admin Role Management**: Add, remove, or modify admin accounts.

### 4️⃣ Dashboard & Analytics
- **User Statistics**: Monitor total users, assignments, and course activity.
- **Classroom Insights**: View student distribution and engagement metrics.

---

## 🎓 LMS-User Application

### 🔑 Authentication & Role Selection
- Users can **log in as a student or teacher**.
- **Auto-login system** remembers last session and allows quick access.
- Option to **log out and switch accounts** if needed.

### 📌 Main Menu
- 1️⃣ **View Classrooms** – Displays assigned classrooms.
- 2️⃣ **View Profile** – Shows user details and assigned courses.
- 3️⃣ **Log Out** – Ends the current session.

### 🏢 Classroom Interaction
- **Students**:
  - View and submit assignments (link-based submissions).
  - Access learning resources (no submission needed).
  - Participate in quizzes through an interactive system.
- **Teachers**:
  - Create and assign homework.
  - Upload learning resources.
  - Design and manage quizzes with customized question sets.

---

## 🛠 Technical Aspects

### 🎯 Design Principles
- **Object-Oriented Programming (OOP)** – Efficient class structures, inheritance, encapsulation, polymorphism and abstraction.
- **MVC-Inspired Layering** – Controllers handle logic, managers perform data operations, and entities represent real-world objects.
- **Persistent Data Storage** – JSON-based data management for offline accessibility.
- **Modular and Scalable** – Each module is independently designed to ensure future enhancements.
- **Enhanced CLI Experience** – ASCII banners, color-coded text, and intuitive navigation.

### 📌 UML Class Diagram

- **LMS-Admin**

![UML](https://github.com/RaksaOC/Learning-Management-System/blob/ca1d549bf0e753b104d24ecf46be0b293f0747c5/doc/images/LMS-Admin-UML.drawio.png)

- **LMS**

- Coming Soon...

### 📂 Database Design / ERD Schema

**ER Diagram**

![ER Diagram](https://github.com/RaksaOC/Learning-Management-System/blob/6bb113f21b0d55f6e15d8bf1ec0138a1254612be/doc/images/ERD.png)

**Relational Schema**

![Schema](https://github.com/RaksaOC/Learning-Management-System/blob/abcc62779cfed1423e73e7d9db188cf5906f704d/doc/images/Schema.svg)

### 🏗 Project Structure
As of 08/02/2025

```
  .
├── LMS
│   ├── assets
│   └── src
│       ├── main
│       │   ├── Main.java
│       │   └── MainController.java
│       └── utils
│           ├── controller
│           │   ├── AuthenticationController.java
│           │   ├── StudentController.java
│           │   └── TeacherController.java
│           ├── manager
│           │   ├── AuthenticationManager.java
│           │   ├── StudentManager.java
│           │   └── TeacherManager.java
│           └── menu
│               └── Menu.java
├── LMS-Admin
│   ├── assets
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
├── README.md
├── doc
│   ├── images
│   │   └── ERD.png
│   └── log
│       ├── General-log.md
│       ├── LMS-admin-log.md
│       └── LMS-log.md
└── shared
    ├── data
    │   ├── admin.json
    │   ├── classroom.json
    │   ├── history.json
    │   ├── progress.json
    │   ├── student.json
    │   ├── teacher.json
    │   └── university.json
    ├── entities
    │   ├── Student.java
    │   ├── Teacher.java
    │   └── User.java
    ├── lib
    │   ├── Hasher.java
    │   └── json-20230227.jar
    └── ui
        └── UI.java

```

### 📦 Dependencies

- `org.json`: A library for working with JSON data in Java.
- Custom SHA-256 Library: A custom implementation of the SHA-256 hashing algorithm.

### ▶️ How to Compile & Run

- *(Step-by-step guide for setup and execution will be added shortly.)*

### 👥 Contributors

- **Ory Chanraksa**
- **Hong Layeang**
- **Kong Visal**
- **Sao Visal**

### 🎓 Supervisor

- **Mr. Lay Vathna**, Lecturer and Researcher at CADT
- **Mr. Korat Natt**, Lecturer and Assistant Researcher at CADT

### 🙏 Acknowledgements

- Thank you for visiting this GitHub repository. If you encounter any issues or have questions, feel free to contact us at [ocraksa@gmail.com](mailto:ocraksa@gmail.com).

---

*This document serves as a comprehensive overview of the LMS project, ensuring clarity and structured development.*




