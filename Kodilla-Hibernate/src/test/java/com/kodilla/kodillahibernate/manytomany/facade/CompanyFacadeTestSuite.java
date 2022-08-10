package com.kodilla.kodillahibernate.manytomany.facade;


import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.dao.CompanyDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;

    @Autowired
    private CompanyDao companyDB;

    @Test
    void shouldRetrieveCompanyByNameFragment(){
        //given
        Company ibm = new Company("IBM corp ltd");
        companyDB.save(ibm);

        //when
        int check = companyDB.retrieveCompaniesWhichName("IBM").size();
        int sizeOfTestedList = companyFacade.getCompaniesBy("corp").size();

        //then
        assertEquals(1,sizeOfTestedList);
        assertEquals(1,check);

        //cleanup
        companyDB.deleteById(ibm.getId());

    }

}
