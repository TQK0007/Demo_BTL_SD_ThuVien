package com.example.code_sd_thuvien.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

import java.util.List;

@Dao
public interface DAO <T>{
    @Insert
    public void add(T t);

    @Update
    public void update(T t);

    @Delete
    public void delete(T t);

    public List<T> getAll();

    public T getById(int id);
}
