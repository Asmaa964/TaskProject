package com.bookstores.bookstores.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "StoresTbl")
@Data
public class StoresEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String storesName;

	private String storesLocation;

	@ManyToMany(targetEntity = StoresEntity.class)
	@JsonIgnore
	private List<BookEntity> books = new ArrayList<>();
}
