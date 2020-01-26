package com.example.tournamentapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tournamentapp.model.Match;

public interface MatchRepo extends JpaRepository<Match, Integer> {

	
	
}
