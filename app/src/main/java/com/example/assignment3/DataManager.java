package com.example.assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String FILE_NAME_STUDENTS = "students.dat";
    private static final String FILE_NAME_INSTRUCTORS = "instructors.dat";
    private static final String FILE_NAME_COURSES = "courses.dat";
    private static final String FILE_NAME_COURSE_GROUPS = "courseGroups.dat";

    // Function to save object to file
    private static void saveObjectToFile(Object object, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to read object from file
    private static Object readObjectFromFile(String fileName) {
        Object object = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
            object = ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    // Function to save a student to file
    public static void saveStudent(Student student) {
        List<Student> students = readStudents();
        students.add(student);
        saveObjectToFile(students, FILE_NAME_STUDENTS);
    }

    // Function to check if a student exists by email and password
    public static boolean studentExists(String email, String password) {
        List<Student> students = readStudents();
        for (Student student : students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Function to get a student by email
    public static Student getStudent(String email) {
        List<Student> students = readStudents();
        for (Student student : students) {
            if (student.getEmail().equals(email)) {
                return student;
            }
        }
        return null;
    }

    // Function to read students from file
    private static List<Student> readStudents() {
        List<Student> students = (List<Student>) readObjectFromFile(FILE_NAME_STUDENTS);
        if (students == null) {
            students = new ArrayList<>();
        }
        return students;
    }

    // Function to save an instructor to file
    public static void saveInstructor(Instructor instructor) {
        List<Instructor> instructors = readInstructors();
        instructors.add(instructor);
        saveObjectToFile(instructors, FILE_NAME_INSTRUCTORS);
    }

    // Function to check if an instructor exists by email and password
    public static boolean instructorExists(String email, String password) {
        List<Instructor> instructors = readInstructors();
        for (Instructor instructor : instructors) {
            if (instructor.getEmail().equals(email) && instructor.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    // Function to get an instructor by email
    public static Instructor getInstructor(String email) {
        List<Instructor> instructors = readInstructors();
        for (Instructor instructor : instructors) {
            if (instructor.getEmail().equals(email)) {
                return instructor;
            }
        }
        return null;
    }

    // Function to read instructors from file
    private static List<Instructor> readInstructors() {
        List<Instructor> instructors = (List<Instructor>) readObjectFromFile(FILE_NAME_INSTRUCTORS);
        if (instructors == null) {
            instructors = new ArrayList<>();
        }
        return instructors;
    }

    // Function to save a course to file
    public static void saveCourse(Course course) {
        List<Course> courses = readCourses();
        courses.add(course);
        saveObjectToFile(courses, FILE_NAME_COURSES);
    }

    // Function to check if a course exists by ID
    public static boolean courseExists(String courseId) {
        List<Course> courses = readCourses();
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    // Function to get a course by ID
    public static Course getCourse(String courseId) {
        List<Course> courses = readCourses();
        for (Course course : courses) {
            if (course.getCourseId().equals(courseId)) {
                return course;
            }
        }
        return null;
    }

    // Function to read courses from file
    private static List<Course> readCourses() {
        List<Course> courses = (List<Course>) readObjectFromFile(FILE_NAME_COURSES);
        if (courses == null) {
            courses = new ArrayList<>();
        }
        return courses;
    }

    // Function to save a course group to file
    public static void saveCourseGroup(CourseGroup courseGroup) {
        List<CourseGroup> courseGroups = readCourseGroups();
        courseGroups.add(courseGroup);
        saveObjectToFile(courseGroups, FILE_NAME_COURSE_GROUPS);
    }

    // Function to check if a course group exists by ID
    public static boolean courseGroupExists(String id) {
        List<CourseGroup> courseGroups = readCourseGroups();
        for (CourseGroup courseGroup : courseGroups) {
            if (courseGroup.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    // Function to get a course group by ID
    public static CourseGroup getCourseGroup(String id) {
        List<CourseGroup> courseGroups = readCourseGroups();
        for (CourseGroup courseGroup : courseGroups) {
            if (courseGroup.getId().equals(id)) {
                return courseGroup;
            }
        }
        return null;
    }

    // Function to read course groups from file
    private static List<CourseGroup> readCourseGroups() {
        List<CourseGroup> courseGroups = (List<CourseGroup>) readObjectFromFile(FILE_NAME_COURSE_GROUPS);
        if (courseGroups == null) {
            courseGroups = new ArrayList<>();
        }
        return courseGroups;
    }
}
