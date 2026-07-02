package com.example.ems_backend.service;

import java.util.List;

import com.example.ems_backend.entity.Employee;
import org.springframework.data.domain.Page;



public interface EmployeeService {

    Employee save(Employee employee);

    Employee update(
            Long id,
            Employee employee);

    void delete(Long id);

    Employee getById(Long id);

    List<Employee> getAll();

    List<Employee> search(
            String keyword);

    List<Employee> department(
            String department);

    Page<Employee> pagination(
            int page,
            int size,
            String sort);
}

