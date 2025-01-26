## General Log

**25/01/25**
- Possible relationsips:

- Relationship:

  University → Has Many → Departments
  Department → Has Many → Specializations
  Specialization → Has Many → Study Groups
  Specialization → Has Many → Courses (Per Term)
  Study Group → Has Many → Students
  Study Group → Has Many → Courses with Teachers (Mapping)
  Course → Belongs to → Specialization

- Worked on LMS-admin. (see log).

**26/01/2025**
- Finished one part of the Manage admin functionalities.
- Defined the design architect of the system.
- Design Architecture: menu (presents choices and return the choice) -> controller (takes the choice, do minimal input and validation) -> manager (has methods corresponding to the cotroller methods but work with file writing, reading).

