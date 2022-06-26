package com.kodilla.kodillahibernate.manytomany.dao;

import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
           //do nothing
        }
    }

    @Test
    void testCompanyNamedQuery(){
        //Given
        Company softwareMachine = new Company("Software Machine");
        Company dataMasters = new Company("Data Maesters");
        Company ibmcorp = new Company("IBM corp");

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMasters);
        int dataMastersId = dataMasters.getId();
        companyDao.save(ibmcorp);
        int ibmId = ibmcorp.getId();

        //When
        int querySize = companyDao.retrieveCompaniesWhichName("IBM").size();

        //Then
        assertEquals(1, querySize);

        //Cleanup
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMastersId);
            companyDao.deleteById(ibmId);
        } catch (Exception e) {
            //do nothing
        }

    }

    @Test
    void testEmployeeNamedQuery(){
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");

        employeeDao.save(johnSmith);
        int johnId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int stephanieId = stephanieClarckson.getId();

        //when
        int querySize = employeeDao.retrieveEmployeesByName("Smith").size();

        //Then
        assertEquals(1, querySize);

        //Cleanup
        try {
            employeeDao.deleteById(johnId);
            employeeDao.deleteById(stephanieId);
        } catch (Exception e) {
            //do nothing
        }


    }




}
