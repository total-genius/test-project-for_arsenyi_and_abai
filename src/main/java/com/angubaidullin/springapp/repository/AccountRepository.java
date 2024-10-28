package com.angubaidullin.springapp.repository;

import com.angubaidullin.springapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query("SELECT a FROM Account a WHERE a.name = :name")
    public List<Account> findByName(@Param("name") String name);
}
