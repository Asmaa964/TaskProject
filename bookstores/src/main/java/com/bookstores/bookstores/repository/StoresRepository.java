package com.bookstores.bookstores.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstores.bookstores.entity.StoresEntity;

@Repository
public interface StoresRepository extends JpaRepository<StoresEntity, Integer> {

}
