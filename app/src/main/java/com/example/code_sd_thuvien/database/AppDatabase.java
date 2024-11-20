package com.example.code_sd_thuvien.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.code_sd_thuvien.dao.AccountDAO;
import com.example.code_sd_thuvien.dao.RoleDAO;
import com.example.code_sd_thuvien.dao.StudentDAO;
import com.example.code_sd_thuvien.entity.Account;
import com.example.code_sd_thuvien.entity.Role;
import com.example.code_sd_thuvien.entity.Student;

// cau hinh cac bang trong db ( moi class la mot bang )
@Database(entities = {Account.class, Student.class, Role.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static  AppDatabase appDatabase;
    private final static String DATABASE_NAME = "StudentManagerVersion2.db";
    public static AppDatabase getInstance(Context context)
    {
        if(appDatabase==null)
        {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return  appDatabase;
    }

    // các phương thức trả về lớp implement của interface
    public abstract AccountDAO accountDAO();
    public abstract StudentDAO studentDAO();
    public abstract RoleDAO roleDAO();
}
