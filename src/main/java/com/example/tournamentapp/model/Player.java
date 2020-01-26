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
@Table(name="Players")
public class Player {
	
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
@Column(name="pid")
private Integer id;
@Column(name="pname")
private String name;
private String cricketteam;
@OneToMany(mappedBy="player")
private List<PlayerMatch> playermatch;
public Player() {
	
}
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
public List<PlayerMatch> getPlayermatch() {
	return playermatch;
}
public void setPlayermatch(List<PlayerMatch> playermatch) {
	this.playermatch = playermatch;
}
}
