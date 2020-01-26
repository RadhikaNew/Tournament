package com.example.tournamentapp.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="matches")
public class Match {
	
@Id
@Column(name="mid")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String seriesname;
private String location;
@OneToMany(mappedBy="match")
private List<PlayerMatch> playermatch;

public Match()
{
}
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
public List<PlayerMatch> getPlayermatch() {
	return playermatch;
}
public void setPlayermatch(List<PlayerMatch> playermatch) {
	this.playermatch = playermatch;
}
}
