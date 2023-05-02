package com.bookstores.bookstores.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "BookTbl")
@Data
public class BookEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String bookName;

	private String bookAuthor;

	@ManyToMany
	@JoinTable(name = "book_store", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "store_id"))
	@JsonIgnore
	private List<StoresEntity> stores = new ArrayList<>();

}
