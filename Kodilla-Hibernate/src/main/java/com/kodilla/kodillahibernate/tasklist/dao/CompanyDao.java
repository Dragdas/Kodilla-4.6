package com.kodilla.kodillahibernate.tasklist.dao;

import com.kodilla.kodillahibernate.manytomany.Company;
import org.springframework.data.relational.core.sql.In;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {
}
