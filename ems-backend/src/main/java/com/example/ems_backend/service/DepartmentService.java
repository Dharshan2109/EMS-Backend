package com.example.ems_backend.service;



import java.util.List;
import com.example.ems_backend.entity.Department;

public interface DepartmentService {

    Department save(
            Department d);

    Department update(
            Long id,
            Department d);

    void delete(
            Long id);

    Department getById(
            Long id);

    List<Department> getAll();
}
