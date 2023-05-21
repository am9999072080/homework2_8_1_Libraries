package ru.skypro.homework2_8_1_libraries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skypro.homework2_8_1_libraries.model.Employee;
@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException (Employee employee){
        super("Сотрудник не найден "+employee.toString());
    }
}
