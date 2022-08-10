package com.kodilla.kodillahibernate.manytomany.facade;

import com.kodilla.kodillahibernate.manytomany.Employee;
import com.kodilla.kodillahibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeFacadeTest {

    @Autowired
    private EmployeeFacade employeeFacade;

    @Autowired
    private EmployeeDao employeeDb;


    @Test
    void findEmployeeByNameFragment() {
        //given
        Employee employee = new Employee("Wojtek", "Kurtyka");
        employeeDb.save(employee);


        //When
        int searchByFirstNameFragment   = employeeFacade.findEmployeeBy("ojt").size();
        int searchByLastNameFragment    = employeeFacade.findEmployeeBy("rtyk").size();


        //Then
        assertEquals(1, searchByFirstNameFragment);
        assertEquals(1, searchByLastNameFragment);




        employeeDb.deleteById(employee.getId());

    }
}