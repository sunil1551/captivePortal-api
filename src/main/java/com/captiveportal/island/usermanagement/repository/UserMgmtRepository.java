package com.captiveportal.island.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carnival.utility.model.IslandUser;

public interface UserMgmtRepository extends JpaRepository<IslandUser, Long> {
	IslandUser findByUserName(String username);
}
