package com.kodilla.kodillahibernate.manytomany.dao;

import com.kodilla.kodillahibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query
    List<Employee> retrieveEmployeesByName(@Param("NAME") String name);

    @Query("SELECT e FROM Employee e WHERE e.firstName LIKE ?1 OR e.lastName LIKE ?1")
    List<Employee> findEmployeesByNameFragment(String nameFragment);

}
