package com.boot.demo.controller;


import com.boot.demo.entity.User;
import com.boot.demo.exception.handler.EntityNotFoundException;
import com.boot.demo.exception.handler.InvalidRequestException;
import com.boot.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/user/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> create(@RequestBody User user) {
		
		userService.create(user);
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/fetch/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getByUsername(@Valid @PathVariable("id") Long id) {
		User user = userService.findById(id);
		if(user == null){
			throw new EntityNotFoundException(id);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/api/update/{id}",
			method = RequestMethod.PUT, 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> updateUser(@RequestBody @Valid User user,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			throw new InvalidRequestException("Invalid user, ha! ha! ha!, :-)", bindingResult);
		}
		try {
			user = userService.update(user);
		} catch (Exception ex) {
			return new ResponseEntity<User>(user, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/api/delete/{id}",
			method = RequestMethod.DELETE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<List<User>> delete(@PathVariable("id") Long id) {
		userService.delete(id);
		List<User> users = userService.findAll();
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
