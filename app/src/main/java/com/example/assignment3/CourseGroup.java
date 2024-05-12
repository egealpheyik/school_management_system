package com.example.assignment3;

import java.util.List;

public class CourseGroup {
    private String id;
    private Instructor instructor;
    private List<Student> students;

    public CourseGroup(String id, Instructor instructor, List<Student> students) {
        this.id = id;
        this.instructor = instructor;
        this.students = students;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
