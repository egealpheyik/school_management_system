package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // Dummy student data for demonstration

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button studentLoginButton;
    private DataManager dataManager;

    private Button instructorLoginButton;
    private ArrayList<Student> students;
    private ArrayList<Instructor> instructors;
    private Intent instructorIntent;
    private Instructor instructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        studentLoginButton = findViewById(R.id.studentLoginButton);
        instructorLoginButton = findViewById(R.id.instructorLoginButton);


        students = new ArrayList<>();
        instructors = new ArrayList<>();
        //students = dataGenerator.generateStudents();
        //instructors = dataGenerator.generateInstructors(instructors);
        instructors.add(new Instructor("1","Instructor1", "1", "1"));
        instructors.add(new Instructor("2","Instructor2", "instructor2@example.com", "password2"));

        students.add(new Student("ID1", "student1@example.com", "password1"));
        students.add(new Student("ID2", "student2@example.com", "password2"));



        // Set click listener for the login button
        studentLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered email and password
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validate email and password
                boolean isValid = validateCredentialsStudent(email, password);

                // If valid, proceed to next screen (in this example, display a toast message)
                if (isValid) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                    // Replace this with code to navigate to the next screen
                } else {
                    // If invalid, display an error message (in this example, display a toast message)
                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
        instructorLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get entered email and password
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validate email and password
                boolean isValid = validateCredentialsInstructor(email, password);

                // If valid, proceed to next screen (in this example, display a toast message)
                if (isValid) {
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();


                    instructorIntent = new Intent(getApplicationContext(), InstructorMenu.class);
                    instructorIntent.putExtra("INSTRUCTOR_ID", instructor.getInstructorId());
                    startActivity(instructorIntent);

                } else {
                    // If invalid, display an error message (in this example, display a toast message)
                    Toast.makeText(MainActivity.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    // Method to validate email and password against stored student data
    private boolean validateCredentialsStudent(String email, String password) {
        for (Student student : students) {
            if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                return true; // Login successful
            }
        }
        return false; // Login failed
    }
    private boolean validateCredentialsInstructor(String email, String password) {
        for (Instructor inst : instructors) {
            if (inst.getEmail().equals(email) && inst.getPassword().equals(password)) {
                this.instructor = inst;
                return true; // Login successful
            }
        }
        return false; // Login failed
    }
}
