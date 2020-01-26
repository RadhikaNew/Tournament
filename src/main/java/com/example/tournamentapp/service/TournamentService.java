package com.example.tournamentapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tournamentapp.Exceptions.PlayerNotFoundException;
import com.example.tournamentapp.dao.MatchRepo;
import com.example.tournamentapp.dao.PlayerMatchRepo;
import com.example.tournamentapp.dao.PlayerRepo;
import com.example.tournamentapp.dto.MatchDTO;
import com.example.tournamentapp.dto.PlayerDTO;
import com.example.tournamentapp.model.Match;
import com.example.tournamentapp.model.Player;
import com.example.tournamentapp.model.PlayerMatch;

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

	public PlayerDTO getPlayers(Integer playerid) {
		PlayerDTO playerDTO=null;
		Player player = playerrepo.findById(playerid).orElse(null);
		
		if (player==null)
		{
			throw new PlayerNotFoundException("id "+ playerid+" is not correct!!Please enter valid id");
		}
		else if (player!=null)
		{
		playerDTO = converterservice.convert(player);
		playerDTO.setTotal(playermatchrepo.sumscore(playerDTO.getId()));
		List<Integer> matchidlist = playermatchrepo.matchids(playerDTO.getId());
		List<MatchDTO> matchdtolist = playerDTO.getMatch();
		for (Integer mid : matchidlist) {
			MatchDTO matchDTO= converterservice.convert(matchrepo.findById(mid).orElse(null));
			matchDTO.setScore(playermatchrepo.matchscore(mid,playerDTO.getId()));
			matchdtolist.add(matchDTO);
		}
		}
			
		return playerDTO;
	}

	
	  public List<PlayerDTO> update(String name) {
	  
	  
	  Player p=new Player(); p.setName(name); p.setCricketteam("Australia");
	  
	  Match m =new Match(); m.setLocation("India"); m.setSeriesname("ICC World Cup");
	  PlayerMatch pm=new PlayerMatch(); pm.setMatch(m); pm.setPlayer(p);
	  pm.setScore(100);
	  
	  
	  p.setPlayermatch(Arrays.asList(pm)); m.setPlayermatch(Arrays.asList(pm));
	  playermatchrepo.save(pm);
	  
	  List<Player> playerlist=playerrepo.findAll(); 
	  List<PlayerDTO> matchlist=playerlist.stream().map(converterservice::convert).collect(
	  Collectors.toList()); 
	  /*for (PlayerDTO playerDTO : matchlist) {
	  playerDTO.setTotal(playermatchrepo.sumscore(playerDTO.getId()));
	  List<Integer> matchidlist=playermatchrepo.matchids(playerDTO.getId());
	  List<MatchDTO> matchdtolist=playerDTO.getMatch(); for (Integer mid :
	 matchidlist) {
	  matchdtolist.add(converterservice.convert(matchrepo.getOne(mid))); } }*/ 
	  return
	  matchlist;}
	 

}
