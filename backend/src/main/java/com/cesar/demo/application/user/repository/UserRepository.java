package com.cesar.demo.application.user.repository;

import com.cesar.demo.application.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
}
