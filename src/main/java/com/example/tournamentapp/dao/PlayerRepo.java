package com.example.tournamentapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tournamentapp.model.Player;


public interface PlayerRepo extends JpaRepository<Player,Integer> {

}
