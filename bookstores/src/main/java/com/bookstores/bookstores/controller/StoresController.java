package com.bookstores.bookstores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookstores.bookstores.Services.StoresService;
import com.bookstores.bookstores.entity.StoresEntity;

@RestController
public class StoresController {

	@Autowired
	private StoresService storesService;

	@GetMapping("/stores")
	public ResponseEntity<List<StoresEntity>> getAllStores() {
		List<StoresEntity> stores = this.storesService.getAllStores();
		return new ResponseEntity<>(stores, HttpStatus.OK);

	}

	@GetMapping("/stores/{storeId}")
	public ResponseEntity<Object> getStoreById(@PathVariable int storeId) {
		ResponseEntity<Object> store = this.storesService.getStoreById(storeId);
		return new ResponseEntity<>(store.getBody(), HttpStatus.OK);

	}

}
