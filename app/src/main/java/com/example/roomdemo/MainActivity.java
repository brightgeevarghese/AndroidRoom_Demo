package com.example.roomdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roomdemo.databinding.ActivityMainBinding;

import java.util.List;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextRegNo;
    Button buttonSave;
    ActivityMainBinding activityMainBinding;
    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        editTextName = activityMainBinding.nameId;
        editTextRegNo = activityMainBinding.registerNumberId;
        buttonSave = activityMainBinding.saveId;
        appDatabase = AppDatabase.getDatabase(this);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextName.getText().toString();
                String regNo = editTextRegNo.getText().toString();
                Executors.newSingleThreadExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        //to save a record
//                        appDatabase.studentDao().insertData(new Student(name, regNo));
                        //to delete a record
//                        List<Student> students = appDatabase.studentDao().getAllStudents();
//                        for (Student student : students){
//                            if (student.getRegisterNumber().equals("101")){
//                                appDatabase.studentDao().deleteStudents(student);
//                            }
//                        }
                        //update a record
                        List<Student> students = appDatabase.studentDao().getAllStudents();
                        for (Student student : students){
                            if (student.getRegisterNumber().equals("102")){
                                student.setName("Blessed");
                                appDatabase.studentDao().updateStudents(student);
                            }
                        }
                    }
                });

            }
        });
    }
}