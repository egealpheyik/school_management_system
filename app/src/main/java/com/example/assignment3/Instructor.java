package com.example.assignment3;

// Student.java
public class Instructor {
    private String instructorId;
    private String name;
    private String email;
    private String password;

    // Constructor
    public Instructor(String studentId, String name, String email, String password) {
        this.instructorId = studentId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    // Getters and setters
    public String getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(String studentId) {
        this.instructorId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
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

