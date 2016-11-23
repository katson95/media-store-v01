package com.boot.demo.service.impl;


import com.boot.demo.dao.IUserDao;
import com.boot.demo.entity.User;
import com.boot.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDAO;

	@Override
	public User create(User user) {
		return userDAO.save(user);
	}

	@Override
	public User findById(Long userId) {
		return userDAO.findOne(userId);
	}

	@Override
	public Optional<User> getByUsername(String username) {
		return this.userDAO.findByUsername(username);
	}

	@Override
	public User update(User user) {
		User persistedGreeting = userDAO.findOne(user.getId());
		if (persistedGreeting == null) {
			return null;
		}
		User updatedUser = userDAO.save(user);
		return updatedUser;
	}

	@Override
	public List<User> findAll() {
		return (List<User>) userDAO.findAll();
	}

	@Override
	public void delete(Long id) {
		User u = userDAO.findOne(id);
		userDAO.delete(u);
	}
}
