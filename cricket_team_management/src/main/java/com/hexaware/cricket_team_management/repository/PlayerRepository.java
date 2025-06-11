package com.hexaware.cricket_team_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hexaware.cricket_team_management.dto.ProductSummary;
import com.hexaware.cricket_team_management.entity.Player;

import jakarta.transaction.Transactional;

public interface PlayerRepository extends JpaRepository<Player,Integer> {
	
	@Modifying
	@Transactional
	@Query("UPDATE Player p SET p.role = :role WHERE p.playerName = :playerName")
	int updateByPlayerName(@Param("role") String role, @Param("playerName") String playerName);

	
	

//	@Query("Select p.teamName,sum(totalMatches) from Players where p.teamName=?1")
//	public int getSumOfTotalMatchesByTeamName()
	
	@Query("SELECT new com.hexaware.cricket_team_management.dto.ProductSummary(m.teamName, SUM(m.totalMatches)) " +
	           "FROM Match m GROUP BY m.teamName")
	    List<ProductSummary> getTotalMatchesGroupedByTeam();
	
	
	
	

}
