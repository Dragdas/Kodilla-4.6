package com.kodilla.kodillahibernate.manytomany.facade;


import com.kodilla.kodillahibernate.manytomany.Employee;
import com.kodilla.kodillahibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeFacade {

    private final EmployeeDao employeeDb;

    @Autowired
    public EmployeeFacade(EmployeeDao employeeDb) {
        this.employeeDb = employeeDb;
    }

    public List<Employee> findEmployeeBy(String nameFragment){
        String searchFragment = "%" + nameFragment + "%";
        return employeeDb.findEmployeesByNameFragment(searchFragment);
    }

}
