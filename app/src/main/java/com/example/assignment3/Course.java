package com.example.assignment3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course {
    private String courseId;
    private String name;
    private Date date;
    private ArrayList<CourseGroup> courseGroups;

    public Course(String courseId, String name, Date date, ArrayList<CourseGroup> courseGroups) {
        this.courseId = courseId;
        this.name = name;
        this.date = date;
        this.courseGroups = courseGroups;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseGroup> getCourseGroups() {
        return courseGroups;
    }

    public void setCourseGroups(ArrayList<CourseGroup> courseGroups) {
        this.courseGroups = courseGroups;
    }
}
