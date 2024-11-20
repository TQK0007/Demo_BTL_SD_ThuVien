package com.example.code_sd_thuvien.entity;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(foreignKeys = @ForeignKey(
        entity = Account.class,
        parentColumns = "account_Id",
        childColumns = "account_Id",
        onDelete = ForeignKey.CASCADE
))
public class Student {
    @PrimaryKey(autoGenerate = true)

    private int student_Id;
    private String student_Name;
    private int account_Id;

    public Student(String student_Name, int account_Id) {
        this.student_Name = student_Name;
        this.account_Id = account_Id;
    }
}
