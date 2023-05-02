package com.bookstores.bookstores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookstores.bookstores.Services.BookService;
import com.bookstores.bookstores.entity.BookEntity;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllbooks() {
		List<BookEntity> books = this.bookService.getAllbooks();
		return new ResponseEntity<>(books, HttpStatus.OK);

	}

	@GetMapping("/stores/{storeId}/books")
	public ResponseEntity<Object> getStoreBooks(@PathVariable int storeId) {
		ResponseEntity<List<BookEntity>> store = this.bookService.getStoreBooks(storeId);
		return new ResponseEntity<>(store.getBody(), HttpStatus.OK);
	}

}
