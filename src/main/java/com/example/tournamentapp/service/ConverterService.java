package com.example.tournamentapp.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.tournamentapp.dto.MatchDTO;
import com.example.tournamentapp.dto.PlayerDTO;
import com.example.tournamentapp.model.Match;
import com.example.tournamentapp.model.Player;

@Component
public class ConverterService {

	@Autowired
	private ModelMapper modelmapper;
	
	public PlayerDTO convert(Player player)
	{
		return modelmapper.map(player,PlayerDTO.class );
	}
	
	public MatchDTO convert(Match match)
	{
		return modelmapper.map(match,MatchDTO.class );
	}
}
