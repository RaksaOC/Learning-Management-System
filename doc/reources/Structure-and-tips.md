# LMS Project: Structure & Best Practices 🚀

This document outlines the structure, best practices, and coding conventions for our LMS project. The goal is to keep everything **consistent, maintainable, and well-organized**.

---

## 1. Project Structure 🏗️
Our LMS system follows a **Controller-Manager pattern**:
- **Controllers** handle input, process logic, and call the right managers.
- **Managers** handle file operations and data manipulation.

### **Example Flow:**
1️⃣ **Menu** gets the user’s choice.  
2️⃣ **Controller** processes the choice and calls the correct manager.  
3️⃣ **Manager** interacts with data files (JSON) and returns results.

This keeps the code **modular** and prevents cluttering controllers with file operations.

---

## 2. Enforcing OOP Principles 💡
We apply **Encapsulation, Abstraction, Inheritance, and Polymorphism** effectively:

- **Encapsulation:** Keep fields private, expose via methods.
- **Abstraction:** UI and Menus simplify complexity for users.
- **Inheritance:** Common attributes (e.g., `User`) extend into `Student` and `Teacher`.
- **Polymorphism:** Methods adapt based on which entity calls them.

---

## 3. UI Library Usage 🎨
### **Banner System:**
We use `UI.Banner` for section headers.
```java
System.out.println(UI.TextColor.addColor(UI.Banner.manageTeacher, UI.TextColor.PURPLE_BOLD));
```
This keeps menus **consistent and readable**.

### **Text Coloring:**
```java
String coloredText = UI.TextColor.addColor("Hello", UI.TextColor.BLUE_BOLD);
System.out.println(coloredText);
```

### **Loading Bar Effect:**
```java
UI.showLoadingBar(10);
```
This adds a **smooth loading effect** when fetching data.

---

## 4. Menu System Usage 📜
Menus follow a **loop-check-return** pattern:  
1️⃣ Show the banner.  
2️⃣ Display choices.  
3️⃣ Validate input.  
4️⃣ Return the choice.

### **Example:**
```java
Menu menu = new Menu();
String userType = menu.showUserTypeMenu();
```
This keeps menu navigation **consistent across the app**.

---

## 5. JSON Handling Best Practices 📂
### **Efficient Data Viewing:**

- For viewing data: fetch data once per loop `getJSONObject()`:

```java
public boolean isGenerationIdExist(String genID) {
    JSONArray departments = entityData_Obj.getJSONArray("departments");
    for (int i = 0; i < departments.length(); i++) {
        JSONArray specializations = departments.getJSONObject(i).getJSONArray("specializations");
        for (int j = 0; j < specializations.length(); j++) {
            JSONArray generations = specializations.getJSONObject(j).getJSONArray("generations");
            for (int k = 0; k < generations.length(); k++) {
                if (generations.getJSONObject(k).getString("id").equals(genID)) {
                    return true;
                }
            }
        }
    }
    return false;
}
```
### **Efficient Data Modification:**

- For modifying data: (for deeply nested data) Recommend using long continuous calls or conditions to directly modify the data instead of copying which can lead to loss of data.

```java
public void manageAddEntity(String specID, String genID, JSONObject newObj) {
    JSONArray departments = entityData_Obj.getJSONArray("departments");
    newObj.put("students", new JSONArray());
    newObj.put("status", "active");
    newObj.put("classrooms", new JSONArray());
    beginLoop:
    for (int i = 0; i < departments.length(); i++) {
        for (int j = 0; i < departments.getJSONObject(i).getJSONArray("specializations").length(); i++) {
            if (specID.equals(departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getString("id"))) {
                for (int k = 0; k < departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").length(); k++) {
                    if (departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getString("id").equals(genID)) {
                        departments.getJSONObject(i).getJSONArray("specializations").getJSONObject(j).getJSONArray("generations").getJSONObject(k).getJSONArray("groups").put(newObj);
                        break beginLoop;
                    }
                }
            }
        }
    }
    entityData_Obj.put("departments", departments);
    saveEntity();
}
```

**Bad Approach**

A "bad" approach would be fetching and modifying the JSON object at every loop level, then reconstructing the entire structure from the modified parts instead of modifying it in place. This leads to unnecessary object creation and deep nesting, making the code inefficient and harder to read.

Here’s how it would look:

### ❌ **Inefficient, "Bad" Approach**
```java
public void manageAddEntity(String specID, String genID, JSONObject newObj) {
    JSONArray departments = entityData_Obj.getJSONArray("departments");
    newObj.put("students", new JSONArray());
    newObj.put("status", "active");
    newObj.put("classrooms", new JSONArray());

    JSONArray newDepartments = new JSONArray(); // Will rebuild departments from scratch

    for (int i = 0; i < departments.length(); i++) {
        JSONObject department = departments.getJSONObject(i);
        JSONArray specializations = department.getJSONArray("specializations");

        JSONArray newSpecializations = new JSONArray(); // Rebuild specializations

        for (int j = 0; j < specializations.length(); j++) {
            JSONObject specialization = specializations.getJSONObject(j);
            JSONArray generations = specialization.getJSONArray("generations");

            JSONArray newGenerations = new JSONArray(); // Rebuild generations

            for (int k = 0; k < generations.length(); k++) {
                JSONObject generation = generations.getJSONObject(k);
                JSONArray groups = generation.getJSONArray("groups");

                JSONArray newGroups = new JSONArray(); // Rebuild groups

                if (specialization.getString("id").equals(specID) && generation.getString("id").equals(genID)) {
                    // Add the new entity to the copied groups array
                    newGroups.put(newObj);
                }

                // Copy existing groups into the newGroups array
                for (int g = 0; g < groups.length(); g++) {
                    newGroups.put(groups.getJSONObject(g));
                }

                // Rebuild generation object with updated groups
                JSONObject newGeneration = new JSONObject(generation.toString());
                newGeneration.put("groups", newGroups);
                newGenerations.put(newGeneration);
            }

            // Rebuild specialization object with updated generations
            JSONObject newSpecialization = new JSONObject(specialization.toString());
            newSpecialization.put("generations", newGenerations);
            newSpecializations.put(newSpecialization);
        }

        // Rebuild department object with updated specializations
        JSONObject newDepartment = new JSONObject(department.toString());
        newDepartment.put("specializations", newSpecializations);
        newDepartments.put(newDepartment);
    }

    // Completely replace the departments array
    entityData_Obj.put("departments", newDepartments);
    saveEntity();
}
```

---

### 🚨 **Why is this bad?**
1. **Unnecessary deep copying** – Instead of modifying `departments` in place, it reconstructs `departments`, `specializations`, `generations`, and `groups` at every level.
2. **Extra memory usage** – Each loop creates new JSONArrays (`newDepartments`, `newSpecializations`, `newGenerations`, etc.), consuming extra memory.
3. **Less readable** – The logic gets buried under deep nesting and redundant copying.
4. **Performance overhead** – Instead of modifying only the needed part, it rewrites the entire structure, making it significantly slower for large datasets.

The original approach (directly modifying the nested object and using `break`) is **much more efficient** because it avoids unnecessary copying and directly updates the data.

---

## 6. General Coding Tips 🛠️

### ✅ **Code Structure & Organization**
- **Keep controllers thin, managers thick.** Controllers should only **process logic** and call managers for data operations.
- **Group related files together.** Keep entities, controllers, and managers in their respective folders for clarity.
- **Follow consistent naming conventions.**
    - **PascalCase** for class names (`StudentManager`).
    - **camelCase** for variables/methods (`fetchStudentData`).

### ✅ **File Organization Best Practices**
- **Separate concerns properly.** Avoid placing unrelated logic in the same file.
- **Avoid bloated files.** If a class grows too large, split it into helper classes where appropriate.
- **Method type placement.** declare public private methods in its own block of methods and helper methods in its own block. 

### ✅ **Code Formatting & Readability**
- **Use IntelliJ’s built-in formatter:**
    - Windows/Linux: **`Shift + Alt + F`**
    - macOS: **`Shift + Command + F`**
- **Auto-format on save** (enable in **Preferences → Editor → Code Style**).
- **Consistent indentation (4 spaces for Java).**
- **Limit line length** (keep lines under **100 characters** where possible).
- **Surround blocks with `{}` even for one-liners.**
- **Blank lines between logical sections** for better readability.

### ✅ **Comments & Documentation 📄**
- **Use comments wisely**—explain *why*, not *what*. Don't describe obvious logic.
  ```java
  // ✅ Good: Explains the purpose
  // Fetching student data based on the ID and returning a JSONObject
  JSONObject student = fetchStudentData(studentId);
  
  // ❌ Bad: Redundant comment
  // This line prints the student nameText
  System.out.println(student.getString("nameText"));
  ```

### ✅ **File Naming & Organization**
- **Class names should be nouns, method names should be verbs.**
  ```java
  // ✅ Good
  class StudentManager { ... }
  void fetchStudentData() { ... }
  
  // ❌ Bad
  class ManageStudents { ... }
  void studentFetcher() { ... }
  ```
- **Filename matches class nameText.** (`StudentManager.java` should contain `class StudentManager`).
- **Avoid unnecessary prefixes/suffixes.** Instead of `StudentClass.java`, just use `Student.java`.
- **Keep related files close together.** Example project structure:
  ```
  ├── utils/
  │   ├── FileHelper.java
  │   ├── JSONParser.java
  ├── entities/
  │   ├── Student.java
  │   ├── Teacher.java
  ├── controllers/
  │   ├── StudentController.java
  │   ├── AdminController.java
  ├── managers/
  │   ├── StudentManager.java
  │   ├── CourseManager.java
  ```

---

Following these guidelines will keep our code **clean, structured, and easy to maintain**! 🚀


