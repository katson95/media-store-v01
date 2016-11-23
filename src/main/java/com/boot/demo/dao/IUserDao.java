package com.boot.demo.dao;

import com.boot.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface IUserDao extends BaseDao<User, Long> {

	@Query("select u from User u left join fetch u.roles r where u.username=:username")
	Optional<User> findByUsername(@Param("username") String username);

}
