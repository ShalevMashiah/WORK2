package com.example.work2;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.work2.fragments.AddEmployeeFragment;
import com.example.work2.fragments.AddManagerFragment;
import com.example.work2.fragments.AssignEmployeeToDepartmentFragment;
import com.example.work2.fragments.AssignManagerToDepartmentFragment;
import com.example.work2.fragments.CreateDepartmentFragment;
import com.example.work2.fragments.ViewEmployeesByDepartmentFragment;

public class MainActivity extends AppCompatActivity {

    Button btnEmployees, btnManagers, btnAssignEmployee, btnCreateDepartment, btnAssignManager, btnViewDepartmentEmployees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // אתחול כל הכפתורים
        btnEmployees = findViewById(R.id.btnEmployees);
        btnManagers = findViewById(R.id.btnManagers);
        btnAssignEmployee = findViewById(R.id.btnAssignEmployee);
        btnCreateDepartment = findViewById(R.id.btnCreateDepartment);
        btnAssignManager = findViewById(R.id.btnAssignManager);
        btnViewDepartmentEmployees = findViewById(R.id.btnViewDepartmentEmployees);

        // טעינת פרגמנט ברירת מחדל (לא חובה)
        loadFragment(new AddEmployeeFragment());

        // מאזינים לכפתורים
        btnEmployees.setOnClickListener(v -> loadFragment(new AddEmployeeFragment()));
        btnManagers.setOnClickListener(v -> loadFragment(new AddManagerFragment()));
        btnAssignEmployee.setOnClickListener(v -> loadFragment(new AssignEmployeeToDepartmentFragment()));
        btnCreateDepartment.setOnClickListener(v -> loadFragment(new CreateDepartmentFragment()));
        btnAssignManager.setOnClickListener(v -> loadFragment(new AssignManagerToDepartmentFragment()));
        btnViewDepartmentEmployees.setOnClickListener(v -> loadFragment(new ViewEmployeesByDepartmentFragment()));
    }

    // פונקציה לטעינת פרגמנט
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
