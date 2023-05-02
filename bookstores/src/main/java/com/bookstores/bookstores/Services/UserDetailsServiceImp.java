package com.bookstores.bookstores.Services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookstores.bookstores.entity.RoleEntity;
import com.bookstores.bookstores.entity.UserEntity;
import com.bookstores.bookstores.repository.UserRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserEntity> user = Optional.ofNullable(this.userRepository.findByusername(username));

		if (user.isPresent()) {
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(),
					user.get().getPassword(), getAuthorities(user.get().getRoleEntityList()));
		} else {
			throw new UsernameNotFoundException("User not Exsist");
		}
	}

	private Collection<? extends GrantedAuthority> getAuthorities(List<RoleEntity> roleEntityList) {
		List<GrantedAuthority> authoritiesList = new ArrayList<>();
		for (RoleEntity role : roleEntityList) {
			if (role.getRoleName() != null) {
				authoritiesList.add(new SimpleGrantedAuthority(role.getRoleName()));
			}

		}
		return authoritiesList;

	}

}
