package com.example.code_sd_thuvien;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.code_sd_thuvien.dao.AccountDAO;
import com.example.code_sd_thuvien.dao.DAO;
import com.example.code_sd_thuvien.dao.RoleDAO;
import com.example.code_sd_thuvien.dao.StudentDAO;
import com.example.code_sd_thuvien.database.AppDatabase;
import com.example.code_sd_thuvien.entity.Account;
import com.example.code_sd_thuvien.entity.Role;
import com.example.code_sd_thuvien.entity.Student;
import com.example.code_sd_thuvien.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;

    private AccountDAO accountDAO;
    private StudentDAO studentDAO;
    private RoleDAO roleDAO;

    private List<Account> accountList;
    private ArrayAdapter<Account> adapter;
    private Account accountModify=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        InitQuery();
        getWedget();
        createAdapterAccount();

        // btnAdd là id của button thêm đã được cấu hình ở view
        mainBinding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lấy thông tin được liên kết tu view -> khong phai dùng getText
                // phải gán đối tượng trước khi lấy nếu không sẽ null
                Account account = mainBinding.getAccount();

                // tránh trường hợp sửa bản ghi hiện có rồi thêm -> trùng id;
                accountDAO.add(new Account(account.getAccount_Code(),account.getAccount_Password()));
                createAdapterAccount();
            }
        });

        mainBinding.lvAccount.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                // lay ra account muốn chỉnh sửa có thể update hoặc delete
                accountModify = accountList.get(i);

                // cập nhật account trong giao diện
                mainBinding.setAccount(accountModify);
            }
        });

        mainBinding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // goi ham update
                accountDAO.update(accountModify);

                // tao lai danh sach
                createAdapterAccount();
            }
        });

        mainBinding.btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Tạo một AlertDialog để xác nhận hành động
                new AlertDialog.Builder(view.getContext())
                        .setTitle("Xác nhận xoá")
                        .setMessage("Bạn có chắc chắn muốn xoá tài khoản này?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Thực hiện xoá khi người dùng nhấn "OK"
                                accountDAO.delete(accountModify);
                                mainBinding.setAccount(new Account());
                                createAdapterAccount();  // Cập nhật lại danh sách sau khi xoá
                            }
                        })
                        .setNegativeButton("Hủy", null)  // Không làm gì khi người dùng nhấn "Hủy"
                        .show();
            }
        });

    }

    private void getWedget()
    {
//        kết nối layout với activity
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        // tạo 1 đối tượng mới và liên kết qua view
        Account newAccount = new Account();
        mainBinding.setAccount(newAccount);
    }

    private void InitQuery()
    {
        accountDAO = AppDatabase.getInstance(this).accountDAO();
        studentDAO = AppDatabase.getInstance(this).studentDAO();
        roleDAO = AppDatabase.getInstance(this).roleDAO();
    }

    private void createAdapterAccount()
    {
        accountList = accountDAO.getAll();
        adapter =  new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, accountList);
        mainBinding.lvAccount.setAdapter(adapter);
    }



    // tạo dữ liệu sẵn và hiện thì trên console
    private void fakeData()
    {
        List<Account> accountList = new ArrayList<>(Arrays.asList(
                new Account("AC01","Password1"),
                new Account("AC02","Password2")
        ));
        List<Student> studentList = new ArrayList<>(Arrays.asList(
           new Student("Student1",1),
           new Student("Student2",2)
        ));
        List<Role> roleList = new ArrayList<>(Arrays.asList(
           new Role("Role 1",1),
           new Role("Role 2",1),
           new Role("Role 3",2)
        ));

        accountList.forEach(accountDAO::add);
        studentList.forEach(studentDAO::add);
        roleList.forEach(roleDAO::add);
    }

    private void DisplayAccounts()
    {
        List<Account> accountList = accountDAO.getAll();
        System.out.println("List accout:\n ");
        accountList.forEach(System.out::println);
    }

    private void DisplayStudents()
    {
        List<Student> studentList = studentDAO.getAll();
        System.out.println("List student:\n ");
        studentList.forEach(System.out::println);

        int id =1;
        System.out.println("Detailt Student_id1: "+studentDAO.getById(id));
    }

    private void DisplayRoles()
    {
        List<Role> roleList = roleDAO.getAll();
        System.out.println("List Role:\n ");
        roleList.forEach(System.out::println);
    }


}