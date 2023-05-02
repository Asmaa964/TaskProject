package com.bookstores.bookstores.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookstores.bookstores.entity.BookEntity;
import com.bookstores.bookstores.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<BookEntity> getAllbooks() {
		List<BookEntity> books = this.bookRepository.findAll();
		return books;

	}

	public ResponseEntity<List<BookEntity>> getStoreBooks(int storeId) {
		List<BookEntity> store = this.bookRepository.findByStores_id(storeId);
		return new ResponseEntity<>(store, HttpStatus.OK);
	}
}
