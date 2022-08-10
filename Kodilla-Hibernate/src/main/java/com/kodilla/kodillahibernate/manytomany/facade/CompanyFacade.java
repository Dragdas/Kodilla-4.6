package com.kodilla.kodillahibernate.manytomany.facade;

import com.kodilla.kodillahibernate.manytomany.Company;
import com.kodilla.kodillahibernate.manytomany.dao.CompanyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyFacade {

    private final CompanyDao companyDB;

    @Autowired
    public CompanyFacade(CompanyDao companyDB) {
        this.companyDB = companyDB;
    }

    public List<Company> getCompaniesBy(String nameFragment){
        String searchFragment = "%" + nameFragment + "%";
        return companyDB.findCompaniesByNameFragment(searchFragment);
    }





}
