package com.example.roomdemo;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student_table")
public class Student {
    @ColumnInfo(name= "studentName")
    private String name;
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "regNo")
    private String registerNumber;

    public Student(@NonNull String name, @NonNull String registerNumber) {
        this.name = name;
        this.registerNumber = registerNumber;
    }

    public String getName() {
        return name;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRegisterNumber(@NonNull String registerNumber) {
        this.registerNumber = registerNumber;
    }
}
