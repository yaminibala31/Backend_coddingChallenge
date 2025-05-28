package com.hexaware.Employer_rest_api.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hexaware.Employer_rest_api.entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
