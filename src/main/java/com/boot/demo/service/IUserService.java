package com.boot.demo.service;


import com.boot.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

	 User create(User user);

	 User findById(Long userId);

	 Optional<User> getByUsername(String username);

	 List<User> findAll();

	 void delete(Long id);

	 User update(User user);

}
