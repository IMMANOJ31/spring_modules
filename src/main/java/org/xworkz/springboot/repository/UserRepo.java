package org.xworkz.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.xworkz.springboot.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity,Integer> {
}
