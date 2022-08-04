package com.example.roomdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class}, version = 1, exportSchema = false)
abstract public class AppDatabase extends RoomDatabase {

    static AppDatabase appDatabase;
    abstract StudentDao studentDao();

    /***
     * Create the database the first time it's accessed,
     * using Room's database builder to create a RoomDatabase object
     * in the application context from the AppDatabase class and
     * names it "student_database".
     * @param context contains current context
     * @return appDatabase instance
     */
    static AppDatabase getDatabase(Context context){

        if (appDatabase == null){
            Builder<AppDatabase> appDatabaseBuilder = Room.databaseBuilder(context, AppDatabase.class, "student_database");
            appDatabase = appDatabaseBuilder.build();
        }
        return appDatabase;
    }
}
