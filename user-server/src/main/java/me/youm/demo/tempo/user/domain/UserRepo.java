package me.youm.demo.tempo.user.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
* 用户表 Repo
*
* @author youta
*/
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}