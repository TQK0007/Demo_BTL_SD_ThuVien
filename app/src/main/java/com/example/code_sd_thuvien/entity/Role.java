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
        entity = Student.class,
        parentColumns = "student_Id",
        childColumns = "student_Id",
        onDelete = ForeignKey.CASCADE
))
public class Role {
    @PrimaryKey(autoGenerate = true)

    private int role_Id;
    private String role_Name;
    private int student_Id;

    public Role(String role_Name, int student_Id) {
        this.role_Name = role_Name;
        this.student_Id = student_Id;
    }
}
