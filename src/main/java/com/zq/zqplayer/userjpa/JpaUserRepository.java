package com.zq.zqplayer.userjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.zq.zqplayer.model.User;

@Repository
public interface JpaUserRepository extends JpaRepository<User,Long> {
}
