package com.application.users.repository;

import com.application.users.entity.User;
import org.springframework.stereotype.Repository;
import repositories.IGenericRepository;

@Repository
public interface UserRepository extends IGenericRepository<User> {
    User getUserByUsername(String username);
}
