## LMS-Admin Log

**25/01/2025**

- began building the initial stage.
- finished setting up the UI and its interation to controller and manager class.
- Controller and Manager to be defined.
- Core functionalities of LMS-Admin has been defined:

-----------------**Level1**---------------------

  + Main Menu:
    + Manage Users
    + Manage University
    + Manage Admins

-----------------**Level 2**---------------------

  + Manage Users:
    + Manage Students
    + Manage Teachers
  + Manage University:
    + Manage Generations
    + Manage Departments & Specializations
  + Manage Admin:
    + Add Admin
    + Edit Admin
    + Delete Admin
    + View All Admins

-----------------**Level3**----------------------

  + Manage Students:
    + Add Student
    + Edit Student
    + Delete Student
  + Manage Teachers:
    + Add Teacher
    + Edit Teacher
    + Delete Teacher
  + Manage Generations:
    + Add Generation
    + Edit Generation
    + Delete Generation
  + Manage Departments:
    + Add Department
    + Edit Department
    + Delete Department
    + View Department
    + Manage Specialization
  + Manage Specializations
    + Add Specialization
    + View Specialization
    + Delete Specialization

**26/01/2025**

- Finished with the "Manage admin functionalities"
- Discovered that the "Edit admin" and Edit "[Entity]" in general contains another layer, hence the creation of Edit controllers and Edit Managers.
- Formatted packages
- Added superclass to ManageEntityController/Manager and EditEntityController/Manager with interfaces to enforce modularity and OOP principles.
- Starting to work on the management of other entities
- Proposal: treat each entity as separate json files and going to start defining their relationships.

**01/02/2025

- Finsihed with all the LMS-Admin app funtionaloties.
- Added manage classroom and manage group into manage university.
- Added validations to all id inputs speciffically old ids to change bur havent tested. 