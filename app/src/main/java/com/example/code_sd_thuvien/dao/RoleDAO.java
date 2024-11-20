package com.example.code_sd_thuvien.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.code_sd_thuvien.entity.Role;

import java.util.List;

@Dao
public interface RoleDAO extends DAO<Role> {

    @Override
    @Query(value = "select * from Role")
    public List<Role> getAll();

    @Override
    @Query(value = "select * from Role where role_Id = :id")
    Role getById(int id);
}
