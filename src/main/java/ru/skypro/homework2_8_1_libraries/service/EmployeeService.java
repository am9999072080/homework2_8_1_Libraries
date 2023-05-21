package ru.skypro.homework2_8_1_libraries.service;

import ru.skypro.homework2_8_1_libraries.model.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName);
    Employee remove(String firstName, String lastName);
    Employee find(String firstName, String lastName);
    Collection <Employee> findAll();
}
