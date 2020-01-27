package com.example.tournamentapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tournamentapp.dto.PlayerDTO;
import com.example.tournamentapp.service.TournamentService;

@RestController
@RequestMapping("/player")
public class TournamentController {
	
	@Autowired
	private TournamentService tournamentservice;

	@GetMapping("/getplayers/{id}")
public PlayerDTO getplayers(@PathVariable("id")Integer playerid)
{
	return tournamentservice.getPlayers(playerid);
}
	}
