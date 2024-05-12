package com.example.assignment3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Date;


public class InstructorMenu extends AppCompatActivity {

    // Dummy student data for demonstration


    private Button createCourse;
    private Button filterCourses;
    private ListView listView;

    private Instructor instructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructor_menu);

        createCourse = findViewById(R.id.buttonCreateCourse);
        filterCourses = findViewById(R.id.buttonFilterCourses);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("1", "bbg", new Date(1683807487), null));
        courses.add(new Course("2", "bbg", new Date(1683807487), null));
        courses.add(new Course("3", "bbg", new Date(1683807487), null));
        courses.add(new Course("4", "bbg", new Date(1683807487), null));
        courses.add(new Course("5", "bbg", new Date(1683807487), null));
        courses.add(new Course("6", "bbg", new Date(1683807487), null));



        listView = findViewById(R.id.listViewCourses);
        CourseAdaptor courseAdaptor = new CourseAdaptor(this, 0, courses);
        listView.setAdapter(courseAdaptor);

        createCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the CreateCourseActivity
                Intent createCourseIntent = new Intent(InstructorMenu.this, CreateCourse.class);

                // Start the CreateCourseActivity
                startActivity(createCourseIntent);
            }
        });



    }


}
