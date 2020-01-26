package com.example.tournamentapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tournamentapp.dao.MatchRepo;
import com.example.tournamentapp.dao.PlayerMatchRepo;
import com.example.tournamentapp.dao.PlayerRepo;
import com.example.tournamentapp.dto.MatchDTO;
import com.example.tournamentapp.dto.PlayerDTO;
import com.example.tournamentapp.exceptions.PlayerNotFoundException;
import com.example.tournamentapp.model.Player;


@Service
public class TournamentService {
	@Autowired
	PlayerRepo playerrepo;
	@Autowired
	PlayerMatchRepo playermatchrepo;
	@Autowired
	MatchRepo matchrepo;
	@Autowired
	ConverterService converterservice;
	
	private static Logger logger=LoggerFactory.getLogger(TournamentService.class);

	public PlayerDTO getPlayers(Integer playerid) {
		PlayerDTO playerDTO=null;
		Player player = playerrepo.findById(playerid).orElse(null);
		logger.debug("Player data {}",player);
		if (player==null)
		{
			throw new PlayerNotFoundException("id "+ playerid+" is not correct!!Please enter valid id");
		}
		else if (player!=null)
		{
		playerDTO = converterservice.convert(player);
		logger.info("PlayerDTO created");
		Integer total=playermatchrepo.sumscore(playerDTO.getId());
		logger.debug("Total score {}",total);
		if(total!=null)
			playerDTO.setTotal(total);
		else 
			playerDTO.setTotal(0);	
		List<Integer> matchidlist = playermatchrepo.matchids(playerDTO.getId());
		logger.debug("Fetch macth list {}",matchidlist);
		List<MatchDTO> matchdtolist = playerDTO.getMatch();
		for (Integer mid : matchidlist) {
			MatchDTO matchDTO= converterservice.convert(matchrepo.findById(mid).orElse(null));
			matchDTO.setScore(playermatchrepo.matchscore(mid,playerDTO.getId()));
			matchdtolist.add(matchDTO);
		}
		}
			
		return playerDTO;
	}

}
