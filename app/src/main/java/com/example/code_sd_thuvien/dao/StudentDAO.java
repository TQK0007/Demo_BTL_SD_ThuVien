package com.example.code_sd_thuvien.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.code_sd_thuvien.entity.Student;

import java.util.List;

@Dao
public interface StudentDAO extends DAO<Student>{

    @Override
    @Query(value = "select * from Student")
    public List<Student> getAll();

    @Override
    @Query(value = "select * from Student where student_Id = :id")
    Student getById(int id);
}
