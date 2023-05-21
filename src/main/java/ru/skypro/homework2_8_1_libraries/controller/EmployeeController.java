package ru.skypro.homework2_8_1_libraries.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework2_8_1_libraries.model.Employee;
import ru.skypro.homework2_8_1_libraries.service.EmployeeService;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @RequestMapping("/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName){
        return employeeService.add(firstName,lastName);
    }
    @RequestMapping("remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName){
        return  employeeService.remove(firstName, lastName);
    }
    @RequestMapping("/find")
    public Employee find(@RequestParam String firstName,
                     @RequestParam String lastName){
        return employeeService.find(firstName, lastName);
    }
    @RequestMapping
    public Collection<Employee> findAll(){
        return employeeService.findAll();
    }
}
