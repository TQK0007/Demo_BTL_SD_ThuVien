package com.example.code_sd_thuvien.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.code_sd_thuvien.entity.Account;

import java.util.List;

@Dao
public interface AccountDAO extends DAO<Account> {

    @Override
    @Query(value = "select * from Account")
    public List<Account> getAll();

    @Override
    @Query(value = "Select * from Account where account_Id = :id")
    Account getById(int id);
}
