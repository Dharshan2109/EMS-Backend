package com.example.ems_backend.serviceimpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ems_backend.entity.Department;
import com.example.ems_backend.repository.DepartmentRepository;
import com.example.ems_backend.service.DepartmentService;

@Service
public class DepartmentServiceImpl
        implements DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    @Override
    public Department save(
            Department d) {

        return repo.save(d);
    }

    @Override
    public Department update(
            Long id,
            Department d) {

        Department dept =
                repo.findById(id)
                        .orElseThrow();

        dept.setDepartmentName(
                d.getDepartmentName());

        dept.setDescription(
                d.getDescription());

        return repo.save(dept);
    }

    @Override
    public void delete(
            Long id) {

        repo.deleteById(id);
    }

    @Override
    public Department getById(
            Long id) {

        return repo.findById(id)
                .orElseThrow();
    }

    @Override
    public List<Department> getAll() {

        return repo.findAll();
    }
}
