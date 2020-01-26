package com.example.tournamentapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MatchDTO {
	
	@JsonProperty(value="id")
	private Integer id;
	@JsonProperty(value="seriesname")
	private String seriesname;
	@JsonProperty(value="location")
	private String location;
	@JsonProperty(value="score")
	private Integer score;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSeriesname() {
		return seriesname;
	}
	public void setSeriesname(String seriesname) {
		this.seriesname = seriesname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

	
}
