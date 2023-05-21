package ru.skypro.homework2_8_1_libraries.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.skypro.homework2_8_1_libraries.model.Employee;
@ResponseStatus(code= HttpStatus.BAD_REQUEST)
public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException (Employee employee){
        super("Уже добавлено "+employee.toString());
    }
}
