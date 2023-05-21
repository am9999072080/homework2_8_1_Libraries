package ru.skypro.homework2_8_1_libraries.service.impl;

import org.springframework.stereotype.Service;
import ru.skypro.homework2_8_1_libraries.exceptions.EmployeeAlreadyAddedException;
import ru.skypro.homework2_8_1_libraries.exceptions.EmployeeNotFoundException;
import ru.skypro.homework2_8_1_libraries.model.Employee;
import ru.skypro.homework2_8_1_libraries.service.EmployeeService;
import ru.skypro.homework2_8_1_libraries.service.EmployeeValidationService;
import static org.apache.commons.lang3.StringUtils.capitalize;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeValidationService validationService;
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl(EmployeeValidationService validationService) {
        this.validationService = validationService;

        this.employees = new HashMap<>();
    }


    @Override
    public Employee add(String firstName, String lastName) {
        validationService.validate(firstName, lastName);
        Employee employee=new Employee(capitalize(firstName), capitalize(lastName));//С импорт метода capitalize из lang3.StringUtils
        if(employees.containsKey(employee.getFullName())){
            throw new EmployeeAlreadyAddedException(employee);
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if(!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException(employee);
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee=new Employee(firstName, lastName);
        if(!employees.containsKey(employee.getFullName())){
            throw new EmployeeNotFoundException(employee);
        }
        return employee;
    }

    @Override
    public Collection<Employee> findAll() {
        return employees.values();
    }
}
