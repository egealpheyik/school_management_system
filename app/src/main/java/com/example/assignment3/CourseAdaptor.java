package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CourseAdaptor extends ArrayAdapter<Course> {

    LayoutInflater mLayoutInflater;
    private ArrayList<Course> courseArrayList;

    public CourseAdaptor(Context context, int resource, ArrayList<Course> courseArrayList) {
        super(context, resource, courseArrayList);
        this.mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.courseArrayList = courseArrayList;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public Course getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mLayoutInflater.inflate(R.layout.custom_listview, null);
        TextView courseId =  convertView.findViewById(R.id.CourseId);
        TextView courseName = convertView.findViewById(R.id.CourseName);
        TextView courseDate = convertView.findViewById(R.id.CourseDate);
        Button editButton = convertView.findViewById(R.id.buttonEdit);
        Button deleteButton = convertView.findViewById(R.id.buttonDelete);
        Course course = courseArrayList.get(position);
        courseId.setText(course.getCourseId());
        courseName.setText(course.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String formattedDate = sdf.format( course.getDate());
        courseDate.setText(formattedDate);

        return convertView;
    }
}
