package com.example.ems_backend.repository;

import java.util.List;

import com.example.ems_backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository
        extends JpaRepository<Employee,Long>{

    List<Employee>
    findByFirstNameContainingIgnoreCase(
            String keyword);

    List<Employee>
    findByDepartment(String department);
}


