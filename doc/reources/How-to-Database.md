

# **SQL in Java (With a Singleton Database Connection) 🚀**

## **Intro**
This guide will show you how to **use SQL in Java properly** without creating unnecessary database connections. We’ll cover:
- **The Singleton pattern** (to manage database connections efficiently).
- **PreparedStatements** (to prevent SQL injection).
- **Common SQL operations** (SELECT, INSERT, UPDATE, DELETE).

Let’s get started! 🎯

---

## **The Singleton Database Connection**
We use the **Singleton pattern** to make sure we **only create one database connection** and reuse it everywhere.

### **Example: Singleton Database Connection**
```java
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/your_database", "root", "password"
            );
        } catch (SQLException e) {
            throw new RuntimeException("Database connection failed!", e);
        }
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
```
✅ **Now, every time you need a connection, just call:**
```java
Connection conn = DatabaseConnection.getInstance().getConnection();
```

---

## **Common SQL Operations**

### **1. SELECT (Get Data from Database)**
```java
public void getStudents() {
    String query = "SELECT id, name, email FROM students";

    try (PreparedStatement stmt = conn.prepareStatement(query);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + 
                               ", Name: " + rs.getString("name") + 
                               ", Email: " + rs.getString("email"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```
🔍 **Call `getStudents()` to fetch all students.**

---

### **2. INSERT (Add Data)**
```java
public void addStudent(String name, String email) {
    String query = "INSERT INTO students (name, email) VALUES (?, ?)";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.executeUpdate();
        System.out.println("✅ Student added!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```
✍ **Example Usage:**
```java
addStudent("Alice", "alice@email.com");
```

---

### **3. UPDATE (Modify Data)**
```java
public void updateStudentEmail(int id, String newEmail) {
    String query = "UPDATE students SET email = ? WHERE id = ?";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, newEmail);
        stmt.setInt(2, id);
        int rowsAffected = stmt.executeUpdate();
        System.out.println("✅ " + rowsAffected + " student(s) updated!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```
🔄 **Example Usage:**
```java
updateStudentEmail(1, "new@email.com");
```

---

### **4. DELETE (Remove Data)**
```java
public void deleteStudent(int id) {
    String query = "DELETE FROM students WHERE id = ?";

    try (PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id);
        int rowsAffected = stmt.executeUpdate();
        System.out.println("🗑️ " + rowsAffected + " student(s) deleted!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```
🚀 **Example Usage:**
```java
deleteStudent(3);
```

---

## **Common JDBC Methods**

| Method                     | What It Does  |
|----------------------------|--------------|
| `getConnection()`          | Gets a database connection |
| `prepareStatement(query)`  | Prepares an SQL query |
| `executeQuery()`           | Runs a `SELECT` and returns results |
| `executeUpdate()`          | Runs `INSERT`, `UPDATE`, `DELETE` |
| `setString(index, value)`  | Sets a `String` parameter |
| `setInt(index, value)`     | Sets an `int` parameter |
| `getString(column)`        | Retrieves a `String` from the result |
| `getInt(column)`           | Retrieves an `int` from the result |

---

## **Final Thoughts**
That’s it! With this setup, you can easily **connect Java to MySQL**, run queries safely, and avoid connection leaks.