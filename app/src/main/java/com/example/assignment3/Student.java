package com.example.assignment3;

// Student.java
public class Student {
    private String studentId;
    private String email;
    private String password;

    // Constructor
    public Student(String studentId, String email, String password) {
        this.studentId = studentId;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

