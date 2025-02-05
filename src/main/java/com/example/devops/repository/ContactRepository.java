package com.example.devops.repository;


import com.example.devops.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findByName(String name);

    @Modifying
    @Transactional
    @Query("DELETE FROM Contact c WHERE c.name = :name")
    void deleteByName(String name);
}
