package com.example.code_sd_thuvien.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // nếu muốn để tên class là tên bảng trong db
//@Entity(tableName = "new_Account") // thay đổi tên bảng trong db
public class Account {
    @PrimaryKey(autoGenerate = true)
    // thay đổi tên cột trong db nếu không sử dụng sẽ lấy tên thuộc tính là tên cột
//    @ColumnInfo(name = "new_column")
    private int account_Id;
    private String account_Code;
    private String account_Password;

    public Account(String account_Code, String account_Password) {
        this.account_Code = account_Code;
        this.account_Password = account_Password;
    }
}
