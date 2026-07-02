package com.example.ems_backend.controller;

import java.util.List;

import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public Employee save(
            @RequestBody Employee e){

        return service.save(e);
    }

    @PutMapping("/{id}")
    public Employee update(
            @PathVariable Long id,
            @RequestBody Employee e){

        return service.update(id,e);
    }

    @DeleteMapping("/{id}")
    public String delete(
            @PathVariable Long id){

        service.delete(id);

        return "Employee Deleted";
    }

    @GetMapping("/{id}")
    public Employee getById(
            @PathVariable Long id){

        return service.getById(id);
    }

    @GetMapping
    public List<Employee> getAll(){

        return service.getAll();
    }

    @GetMapping("/search")
    public List<Employee> search(
            @RequestParam String keyword){

        return service.search(keyword);
    }

    @GetMapping("/department/{dept}")
    public List<Employee> department(
            @PathVariable String dept){

        return service.department(dept);
    }

    @GetMapping("/page")
    public Page<Employee> page(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue="id")
            String sort){

        return service.pagination(
                page,
                size,
                sort);
    }
}

