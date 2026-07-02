package com.example.ems_backend.exception;

public class EmployeeNotFoundException
        extends RuntimeException{

    public EmployeeNotFoundException(
            String message){

        super(message);
    }
}

