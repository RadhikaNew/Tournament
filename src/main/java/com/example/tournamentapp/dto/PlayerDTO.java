package com.example.tournamentapp.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDTO {
	
	@JsonProperty(value="id")
	private Integer id;
	@JsonProperty(value="name")
	private String name;
	@JsonProperty(value="cricketteam")
	private String cricketteam;
	@JsonProperty(value="Total")
	private Integer total;
	@JsonProperty("Matches")
	private List<MatchDTO> match=new ArrayList<>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCricketteam() {
		return cricketteam;
	}
	public void setCricketteam(String cricketteam) {
		this.cricketteam = cricketteam;
	}

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<MatchDTO> getMatch() {
		return match;
	}
	public void setMatch(List<MatchDTO> match) {
		this.match = match;
	}
	

	
	
}
