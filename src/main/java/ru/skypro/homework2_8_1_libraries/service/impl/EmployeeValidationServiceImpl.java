package ru.skypro.homework2_8_1_libraries.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.skypro.homework2_8_1_libraries.exceptions.InvalidEmployeeDataException;
import ru.skypro.homework2_8_1_libraries.service.EmployeeValidationService;

import static org.apache.commons.lang3.StringUtils.isAlpha;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class EmployeeValidationServiceImpl implements EmployeeValidationService {

    @Override
    public void validate(String firstName, String lastName) {
        validateName(firstName);
        validateName(lastName);
    }
    private void  validateName(String name){
       if(isBlank(name) || !isAlpha(name)){//с импортом статитического метода: isBlank && isAlpha из lang3.StringUtils

//     if(StringUtils.isBlank(name) || !StringUtils.isAlpha(name)){//с имортом класса: org.apache.commons.lang3.StringUtils
           throw new InvalidEmployeeDataException("Некорректное значение имени։ "+name);
        }
    }
}
