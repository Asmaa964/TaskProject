package com.bookstores.bookstores.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AuthorityTbl")
@Setter
@Getter

public class AuthorityEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorityId;

	@Column(name = "authorityName")
	private String authorityName;

	@ManyToMany(mappedBy = "authorityEntityList")
	private List<RoleEntity> roleEntityList = new ArrayList<>();
}
