package com.example.assignment3;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class CreateCourse extends AppCompatActivity {

    private EditText editTextCourseName;
    private EditText editTextCourseDate;
    private Button buttonCreateCourse;
    private Calendar calendar;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_course);

        editTextCourseName = findViewById(R.id.editTextCourseName);
        editTextCourseDate = findViewById(R.id.editTextCourseDate);
        buttonCreateCourse = findViewById(R.id.buttonCreateCourse);

        calendar = Calendar.getInstance();

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateDate();
            }
        };

        editTextCourseDate.setInputType(InputType.TYPE_NULL); // Disable direct text input

        editTextCourseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(CreateCourse.this, dateSetListener,
                        calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        buttonCreateCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseName = editTextCourseName.getText().toString().trim();

                String courseDate = editTextCourseDate.getText().toString().trim();

                // Validate course name and date
                if (courseName.isEmpty() || courseDate.isEmpty()) {
                    Toast.makeText(CreateCourse.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(CreateCourse.this, "Course created successfully", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    // Method to update the EditText with selected date
    private void updateDate() {
        String myFormat = "MM/dd/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        editTextCourseDate.setText(sdf.format(calendar.getTime()));
    }
}
