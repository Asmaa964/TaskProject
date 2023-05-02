package com.bookstores.bookstores.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "RoleTbl")
@Setter
@Getter

public class RoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String roleName;

	@ManyToMany(mappedBy = "roleEntityList")
	private List<UserEntity> userEntityList = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	private List<AuthorityEntity> authorityEntityList = new ArrayList<>();
}
