package com.bookstores.bookstores.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bookstores.bookstores.entity.StoresEntity;
import com.bookstores.bookstores.repository.StoresRepository;

@Service
public class StoresService {

	@Autowired
	private StoresRepository storesRepository;

	public List<StoresEntity> getAllStores() {
		List<StoresEntity> stores = this.storesRepository.findAll();
		return stores;

	}

	public ResponseEntity<Object> getStoreById(int storeId) {
		Optional<StoresEntity> store = this.storesRepository.findById(storeId);
		if (store.isPresent()) {
			return new ResponseEntity<>(store, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Store Not found", HttpStatus.NOT_FOUND);
		}
	}

}
