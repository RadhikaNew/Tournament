package com.example.tournamentapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.tournamentapp.model.PlayerMatch;

public interface PlayerMatchRepo extends JpaRepository<PlayerMatch, Integer> {

	@Query(value="select sum(score) from player_match where player_pid=?1", nativeQuery=true)
	public Integer sumscore( Integer id);
	
	@Query(value="select match_mid from player_match where player_pid=?1", nativeQuery=true)
	public List<Integer> matchids(Integer id);
	
	@Query(value="select score from player_match where match_mid=?1 and player_pid=?2", nativeQuery=true)
	public Integer matchscore(Integer mid, Integer pid);
}
