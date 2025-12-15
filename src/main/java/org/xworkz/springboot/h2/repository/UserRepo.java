package org.xworkz.springboot.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.xworkz.springboot.entity.UserEntity;


@Repository
public interface UserRepo extends JpaRepository<UserEntity,Integer> {
}
