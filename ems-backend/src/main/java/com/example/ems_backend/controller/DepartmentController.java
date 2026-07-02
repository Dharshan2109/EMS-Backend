package com.example.ems_backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.ems_backend.entity.Department;
import com.example.ems_backend.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin("*")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @PostMapping
    public Department save(
            @RequestBody Department d){

        return service.save(d);
    }

    @GetMapping
    public List<Department> getAll(){

        return service.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(
            @PathVariable Long id){

        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Department update(
            @PathVariable Long id,
            @RequestBody Department d){

        return service.update(id,d);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        service.delete(id);

        return "Department Deleted";
    }
}
