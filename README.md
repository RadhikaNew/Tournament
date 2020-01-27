# Tournament
This is a SpringBoot application which helps to fetch details of a player.
Requirement
![](/Pictures/51.PNG)

How to fetch details of a player
Run the application and fire a url http://localhost:9090/player/getplayers/{id}
In place of id give the id of player(id starts with 101)
Refer below screenshots
Fire below url
![](/Pictures/1.PNG)
Result
![](/Pictures/2.PNG)

Not found id's handel like below
![](/Pictures/3.PNG)
![](/Pictures/4.PNG)

Used flyway to fire query of Mysql, here are the queries.
create table matches (
       mid integer not null auto_increment,
        location varchar(255),
        seriesname varchar(255),
        primary key (mid)
    )
	
 create table player_match (
   id integer not null auto_increment,
	score integer,
	match_mid integer,
	player_pid integer,
	primary key (id),
   foreign key (match_mid) 
   references matches (mid),
   foreign key (player_pid) 
   references players (pid)
)

create table players (
   pid integer not null auto_increment,
	cricketteam varchar(255),
	pname varchar(255),
	primary key (pid)
)

insert into matches(mid,location,seriesname) values (1,'Dubai','ICC World Cup');
insert into matches(location,seriesname) values ('India','ICC World Cup');
insert into matches(location,seriesname) values ('Pakistan','Asian World Cup');


insert into players(pid,cricketteam,pname) values(101,'Indiateam','Virat');
insert into players(cricketteam,pname) values('Indiateam','Dhoni');
insert into players(cricketteam,pname) values('Australiateam','Pointer');
insert into players(cricketteam,pname) values('NewZealandteam','David');

insert into player_match(id,score,match_mid,player_pid) values (1,100,1,101);
insert into player_match(score,match_mid,player_pid) values (50,1,102);
insert into player_match(score,match_mid,player_pid) values (150,1,103);
insert into player_match(score,match_mid,player_pid) values (50,2,101);
insert into player_match(score,match_mid,player_pid) values (150,2,102);
insert into player_match(score,match_mid,player_pid) values (60,2,103);
insert into player_match(score,match_mid,player_pid) values (50,3,102);

