package com.example.ems_backend.serviceimpl;

import java.util.List;

import com.example.ems_backend.entity.Employee;
import com.example.ems_backend.exception.EmployeeNotFoundException;
import com.example.ems_backend.repository.EmployeeRepository;
import com.example.ems_backend.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl
        implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee save(Employee employee) {

        return repository.save(employee);
    }

    @Override
    public Employee update(
            Long id,
            Employee employee) {

        Employee emp =
                repository.findById(id)
                        .orElseThrow(() ->
                                new EmployeeNotFoundException(
                                        "Employee Not Found"));

        emp.setEmployeeCode(
                employee.getEmployeeCode());

        emp.setFirstName(
                employee.getFirstName());

        emp.setLastName(
                employee.getLastName());

        emp.setEmail(
                employee.getEmail());

        emp.setPhone(
                employee.getPhone());

        emp.setGender(
                employee.getGender());

        emp.setDob(
                employee.getDob());

        emp.setDepartment(
                employee.getDepartment());

        emp.setDesignation(
                employee.getDesignation());

        emp.setSalary(
                employee.getSalary());

        emp.setJoiningDate(
                employee.getJoiningDate());

        emp.setStatus(
                employee.getStatus());

        return repository.save(emp);
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public Employee getById(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee Not Found"));
    }

    @Override
    public List<Employee> getAll() {

        return repository.findAll();
    }

    @Override
    public List<Employee> search(
            String keyword) {

        return repository
                .findByFirstNameContainingIgnoreCase(
                        keyword);
    }

    @Override
    public List<Employee> department(
            String department) {

        return repository
                .findByDepartment(
                        department);
    }

    @Override
    public Page<Employee> pagination(
            int page,
            int size,
            String sort) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sort));

        return repository.findAll(
                pageable);
    }
}

