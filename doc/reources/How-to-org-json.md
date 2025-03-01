# 📌 Using org.json in the LMS Project

## 🔹 Introduction

Since we're using **org.json** to handle data in our LMS project, this guide covers the basics: reading and writing JSON files, accessing nested data, iterating through objects and arrays, and real-world use cases.

---

## 🔹 Quick JSON Recap

JSON (JavaScript Object Notation) is a structured format for storing and exchanging data. It consists of **key-value pairs**, arrays, and nested objects.

### **Example JSON**

```json
{
  "nameText": "John Doe",
  "role": "Student",
  "courses": ["Math", "Physics"],
  "status": "active"
}
```

- **Key-Value Pair:** `"nameText": "John Doe"` means **"nameText"** is the **key** to access **"John Doe"**.
- **Data Types:** Values can be **strings, integers, booleans, JSONObjects, or JSONArrays**.
- **Objects (`{}`)** contain key-value pairs.
- **Arrays (`[]`)** store multiple values in an ordered list.

### **JSONObject Example**

```json
{
  "teacher": [
    {
      "lastAction": "logIn",
      "id": "T0001",
      "time": "2025-01-03 10:35:30"
    }
  ],
  "student": [
    {
      "lastAction": "logIn",
      "id": "S000001",
      "time": "2025-02-03 10:35:30"
    }
  ]
}
```

### **JSONArray Example**

```json
[
  {
    "id": "A001",
    "email": "me",
    "status": "active"
  },
  {
    "id": "A002",
    "email": "sophia.nguyen@example.com",
    "status": "active"
  }
]
```

A JSON array contains multiple objects, like a list of admins.

---

## 🔹 Parsing JSON in Java

### **Reading JSON from a File**

```java
String content = new String(Files.readAllBytes(Paths.get("path/to/file.json")));
JSONObject jsonObject = new JSONObject(content);
```

Now, `jsonObject` contains all the data from the file and can be accessed or modified.

---

## 🔹 Accessing Data

### **Getting Simple Values**

```java
String id = jsonObject.getString("id");
String email = jsonObject.getString("email");
JSONObject progress = jsonObject.getJSONObject("progress");
```

### **Accessing Nested Data**

```java
JSONObject nameText = jsonObject.getJSONObject("nameText");
String firstName = nameText.getString("firstName");
```

---

## 🔹 Iterating Over Data

### **Looping Through a JSONArray**

```json
{
  "classrooms": [
    "GEN10-CS-SE-G1-OOP",
    "GEN10-CS-SE-G1-DBMS"
  ]
}
```

```java
JSONArray classrooms = jsonObject.getJSONArray("classrooms");
for (int i = 0; i < classrooms.length(); i++) {
    System.out.println(classrooms.getString(i));
}
```

### **Iterating Over JSONObject Keys**

```json
{
  "progress": {
    "GEN10-CS-SE-G1-OOP": "P000001",
    "GEN10-CS-SE-G1-DBMS": "P000002"
  }
}
```

```java
JSONObject progress = jsonObject.getJSONObject("progress");
for (String key : progress.keySet()) {
    System.out.println(key);
}
```

---

## 🔹 Adding & Modifying Data

### **Adding Data to an Array**

```java
JSONArray classrooms = jsonObject.getJSONArray("classrooms");
classrooms.put("GEN10-CS-SE-G1-NEW");
```

### **Updating Existing Data**

```java
jsonObject.put("status", "inactive");
```

---

## 🔹 Writing Back to a File

```java
Files.write(Paths.get("path/to/file.json"), jsonObject.toString(4).getBytes(StandardCharsets.UTF_8));
```

The `4` in `toString(4)` formats the output for readability.

---

## 🔹 Real-World Example: Managing Assignments

### **Scenario:** Assigning Homework in a Classroom

Each classroom has an `"assignments"` array. When a teacher adds a new assignment, it should be stored in this array.

#### **Classroom Data Before**

```json
{
  "id": "GEN10-CS-SE-G1-OOP",
  "assignments": [
    {
      "id": "HW001",
      "title": "OOP Basics",
      "dueDate": "2025-02-15"
    }
  ]
}
```

#### **Adding a New Assignment in Java**

```java
JSONObject newAssignment = new JSONObject();
newAssignment.put("id", "HW002");
newAssignment.put("title", "Encapsulation");
newAssignment.put("dueDate", "2025-02-20");

JSONArray assignments = jsonObject.getJSONArray("assignments");
assignments.put(newAssignment);
```

#### **Classroom Data After**

```json
{
  "id": "GEN10-CS-SE-G1-OOP",
  "assignments": [
    {
      "id": "HW001",
      "title": "OOP Basics",
      "dueDate": "2025-02-15"
    },
    {
      "id": "HW002",
      "title": "Encapsulation",
      "dueDate": "2025-02-20"
    }
  ]
}
```

---

## 🔹 Summary

- ✅ **Read JSON from a file** using `Files.readAllBytes()`.
- ✅ **Parse JSON** using `JSONObject` and `JSONArray`.
- ✅ **Access and modify data dynamically**.
- ✅ **Iterate over JSON keys and arrays**.
- ✅ **Write JSON back to a file** after making changes.
- ✅ **Real-world usage: Handling assignments dynamically**.

With this, you should be ready to work with JSON in the LMS project efficiently! 🚀