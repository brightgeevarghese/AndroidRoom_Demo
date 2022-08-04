package com.example.roomdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertData(Student student);

    @Delete
    public void deleteStudents(Student... students);

    @Query("delete from student_table")
    public void deleteAll();

    @Update
    public void updateStudents(Student... students);

    @Query("select * from student_table order by regNo asc")
    public List<Student> getAllStudents();

}
