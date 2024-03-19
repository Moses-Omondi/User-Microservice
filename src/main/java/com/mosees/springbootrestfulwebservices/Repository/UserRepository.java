package com.mosees.springbootrestfulwebservices.Repository;

import com.mosees.springbootrestfulwebservices.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
