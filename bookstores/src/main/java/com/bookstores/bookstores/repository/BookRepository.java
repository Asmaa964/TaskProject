package com.bookstores.bookstores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstores.bookstores.entity.BookEntity;

@Repository

public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	List<BookEntity> findByStores_id(int storeId);

}
