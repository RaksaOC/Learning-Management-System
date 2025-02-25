# 📌 Using org.json in the LMS Project

## 🔹 Introduction

Since we're using **org.json** to handle data in our LMS project, this guide will cover the basics, from reading and writing JSON files to iterating through objects and arrays.

---

## 🔹 Quick JSON Recap

JSON (JavaScript Object Notation) is just a structured way to store and exchange data. It's built on **key-value pairs**, arrays, and nested objects.

Example JSON:

```json
{
  "name": "John Doe",
  "role": "Student",
  "courses": ["Math", "Physics"],
  "status": "active"
}
```

- Ex: ```"name": "John Doe"``` is a key-value pair. It means that **"name"** is the **key** to access the value **"John Doe"**.
- The value can be of any types including **string, int, boolean, JSONObject and JSONArray**. However, most of our data is mostly string for easy access.
- Stuff in `{}` is called a `JSONObject`, and stuff in `[]` are called `JSONArray`.

### **JSONObject**

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

For this file, it would be an **object** history (similar to one above).

### **JSONArray**

```json
[
  {
    "createdAt": "2025-01-25T12:00:00Z",
    "lastLogin": "2025-02-07 20:33:32",
    "password": "2744ccd10c7533bd736ad890f9dd5cab2adb27b07d500b9493f29cdc420cb2e0",
    "phoneNumber": "+1234567890",
    "name": {
      "firstName": "Chanraksa",
      "lastName": "Ory"
    },
    "id": "A001",
    "email": "me",
    "status": "active"
  },
  {
    "createdAt": "2025-01-28T15:45:10Z",
    "lastLogin": "2025-02-05 10:22:18",
    "password": "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd63a3d9f20c7d47f0d",
    "phoneNumber": "+1987654321",
    "name": {
      "firstName": "Sophia",
      "lastName": "Nguyen"
    },
    "id": "A002",
    "email": "sophia.nguyen@example.com",
    "status": "active"
  },
  {
    "createdAt": "2025-02-01T08:30:45Z",
    "lastLogin": "2025-02-08 14:12:50",
    "password": "f7c3bc1d808e04732adf679965ccc34ca7ae3441a1f2a98a83090adcb8c82d7d",
    "phoneNumber": "+1122334455",
    "name": {
      "firstName": "David",
      "lastName": "Martinez"
    },
    "id": "A003",
    "email": "david.martinez@example.com",
    "status": "inactive"
  }
]
```

For this table/entity, it would be an **array** of all admins.

---

## 🔹 Parsing JSON in Java

### **Reading JSON from a File**

We store data in JSON files, so let's first learn how to read them:

```java
String content = new String(Files.readAllBytes(Paths.get("path/to/file.json")));
JSONObject jsonObject = new JSONObject(content);
```

At this point, `jsonObject` holds all the data from the file. It means that **jsonObject** is now an object that we view, access, modify with its methods like getString().

---

## 🔹 Accessing Data

Example JSON:

```json
[
  {
    "generation": "GEN10",
    "lastLogin": "2025-02-07 15:38:21",
    "address": {
      "province": "Phnom Penh",
      "district": "Chbar Ampov"
    },
    "gender": "Male",
    "createdAt": "2025-02-04 21:53:36",
    "password": "a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3",
    "phoneNumber": "012540494",
    "dob": "03042006",
    "name": {
      "firstName": "Chan",
      "lastName": "Raksa"
    },
    "specialization": "Software Engineering",
    "progress": {
      "GEN10-CS-SE-G1-OOP": "P000001",
      "GEN10-CS-SE-G1-DBMS": "P000002",
      "GEN10-CS-SE-G1-DSA": "P000003",
      "GEN10-CS-SE-G1-NETWORKS": "P000004",
      "GEN10-CS-SE-G1-AI": "P000005"
    },
    "id": "S000001",
    "guardian": {
      "guardianGender": "Female",
      "guardianName": "Mom",
      "guardianPhoneNumber": "0123423432"
    },
    "department": "Computer Science",
    "email": "ocraksa@gmail.com",
    "status": "active"
  }
]
```
### **Get a Simple Value**

```java
// assume jsonObject is declared

String id = jsonObject.getString("id");
String email = jsonObject.getString("email");
JSONObject progress = jsonObject.getJSONObject("progress");
// for JSONArray: JSONArray friends = jsonObject.getJSONArray("friends"); // just example
```

### **Accessing Nested Data**

Example we want the firstName of the student but its stuck in the "name" object, We can access it like this:

```java
JSONObject name = jsonObject.getJSONObject("name"); // this would get the object 
String firstName = name.getString("firstName"); // get the firstname of the name object
```

---

## 🔹 Iterating Over Arrays

### **Looping Through a JSONArray**

Example: In the `teacher.json` file we would store the classrooms that the teacher teach in an array like:

```json
{
  //otherStuff
  "classrooms": [
    "GEN10-CS-SE-G1-OOP",
    "GEN10-CS-SE-G1-DBMS",
    "GEN10-CS-SE-G1-DSA",
    "GEN10-CS-SE-G1-NETWORKS",
    "GEN10-CS-SE-G1-AI"
  ]
  //otherStuff
}
```

We can iterate over them:

```java
JSONArray classrooms = jsonObject.getJSONArray("classrooms");
for (int i = 0; i < classrooms.length(); i++) {
    System.out.println(classrooms.getString(i));
}
```

---

## 🔹 Iterating Over Keys

## 🔄 Iterating Over Keys in a JSONObject

In our LMS system, we often store data as key-value pairs in a **JSONObject**. Sometimes, we don’t know the exact keys in advance and need to iterate over them dynamically.

### 🎯 Scenario: Listing a Student's Enrolled Courses

Consider this `progress` object inside a student's record:

```json
{
  "progress": {
    "GEN10-CS-SE-G1-OOP": "P000001",
    "GEN10-CS-SE-G1-DBMS": "P000002",
    "GEN10-CS-SE-G1-DSA": "P000003",
    "GEN10-CS-SE-G1-NETWORKS": "P000004",
    "GEN10-CS-SE-G1-AI": "P000005"
  }
}
```

If we need to **list all classrooms a student is studying in**, we loop through the keys:

```java
// assume jsonObject = "progess"

for (String key : jsonObject.keySet()) {
    System.out.println(key);
}

// note: we can also the the jsonObject.keys() which returns an iterator which gives more control over the objects such as when deleting but most of the time forEach should be fine

```

This helps when we don’t have a fixed list of keys but need to dynamically fetch all classroom names.

---

## 🔹 Adding Data to an Array

If we want to add a new classroom to the teacher's `"classrooms" or adding a new assignment here’s how:

```java
// assume jsonObject is the teachers data

JSONArray classrooms = jsonObject.getJSONArray("classrooms");
assignments.put(newClassroomID); // this would add a new id to the array
```

```java
// assume jsonObject is the classroom data

JSONArray assignments = jsonObject.getJSONArray("assignments");
// logic to form the newAssignment object
assignments.put(newAssignment); // this would add a new id to the array
```

---

## 🔹 Modifying Existing Data

Updating values is simple. If a student’s status changes:

```java
jsonObject.put("status", "inactive");
```

This works whether or not the key already exists. Basically an overwrite.

---

## 🔹 Writing Back to a File

After making changes, we need to save them:

```java
Files.write(Paths.get("path/to/file.json"), jsonObject.toString(4).getBytes(StandardCharsets.UTF_8));
```

The `4` in `toString(4)` makes the output nicely formatted. Note: make sure you are writing the entire data with its changed subpart already put in.

---

## 🔹 Summary

- **Read JSON from a file** using `Files.readAllBytes()`.
- **Parse JSON data** using `JSONObject` and `JSONArray`.
- **Access and modify data dynamically**.
- **Iterate over JSON keys and arrays** for flexible data handling.
- **Write JSON back to a file** after making changes.

This should cover most of what we need in the LMS project. If something breaks, check the JSON structure first and if the key you are accessing actually exists.