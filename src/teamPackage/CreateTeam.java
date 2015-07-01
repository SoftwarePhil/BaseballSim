package teamPackage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;


public class CreateTeam {

private Team home = new Team();
private Team away = new Team();
private Team[] teams;
private String teamNameHome = "";
private String teamNameAway = "";
private int teamCounter = 0;
private int pitcherCount = 1;
private int battingLineup = 9;

private String teamBatting;
private String teamPitching;

public Team[] createTeams(String teamNameHome, String teamNameAway){
	
	this.teamNameHome = teamNameHome;
	this.teamNameAway = teamNameAway;
	
	home = createTeam(this.teamNameHome);
	away = createTeam(this.teamNameAway);
		
	Team[] teams = {home, away};
	
	return teams;
	
}

public Team createTeam(String teamName) {
	// batting_players.append(([row["Name"].replace(" ", ""), row["Position"], float(row["H"]), float(row["IPR"]), float(row["O-Swing%"]), float(row["Z-Swing%"]), float(row["O-Contact%"]), float(row["Z-Contact%"]), float(row["1B%"]), float(row["2B%"]), float(row["3B%"]), float(row["HR%"]), float(row["FP"])]))

	Team team = new Team();
	team.setTeamName(teamName);
	int temp2 = 0;
	
	switch(teamName){
	case "Yankees":{
		teamBatting = "teams/Yankees_batting.txt";
		teamPitching = "teams/Yankees_pitchers.txt";
	}
	case "Phillies":{
		teamBatting = "teams/Phillies_batting.txt";
		teamPitching = "teams/Phillies_pitchers.txt";
	}
	case "Red_Sox":{
		teamBatting = "teams/Red_Sox_batting.txt";
		teamPitching = "teams/Red_Sox_pitchers.txt";
	}
	case "Angels":{
		teamBatting = "teams/Angels_batting.txt";
		teamPitching = "teams/Angels_pitchers.txt";
	}
	case "White_Sox":{
		teamBatting = "teams/White_Sox_batting.txt";
		teamPitching = "teams/White_Sox_pitchers.txt";
	}
	case "Cubs":{
		teamBatting = "teams/Cubs_batting.txt";
		teamPitching = "teams/Cubs_pitchers.txt";
	}
	case "Mets":{
		teamBatting = "teams/Mets_batting.txt";
		teamPitching = "teams/Mets_pitchers.txt";
	}
	case "Giants":{
		teamBatting = "teams/Giants_batting.txt";
		teamPitching = "teams/Giants_pitchers.txt";
	}
	case "Twins":{
		teamBatting = "teams/Twins_batting.txt";
		teamPitching = "teams/Twins_pitchers.txt";
	}
	case "Tigers":{
		teamBatting = "teams/Twins_batting.txt";
		teamPitching = "teams/Twins_pitchers.txt";
	}
	case "Cardinals":{
		teamBatting = "teams/Cardinals_batting.txt";
		teamPitching = "teams/Cardinals_pitchers.txt";
	}
	case "Dodgers":{
		teamBatting = "teams/Dodgers_batting.txt";
		teamPitching = "teams/Dodgers_pitchers.txt";
	}
	case "Rangers":{
		teamBatting = "teams/Rangers_batting.txt";
		teamPitching = "teams/Rangers_pitchers.txt";
	}
	case "Rockies":{
		teamBatting = "teams/Rockies_batting.txt";
		teamPitching = "teams/Rockies_pitchers.txt";
	}
	case "Braves":{
		teamBatting = "teams/Braves_batting.txt";
		teamPitching = "teams/Braves_pitchers.txt";
	}
	case "Mariners":{
		teamBatting = "teams/Mariners_batting.txt";
		teamPitching = "teams/Mariners_pitchers.txt";
	}
	case "Brewers":{
		teamBatting = "teams/Brewers_batting.txt";
		teamPitching = "teams/Brewers_pitchers.txt";
	}
	case "Orioles":{
		teamBatting = "teams/Orioles_batting.txt";
		teamPitching = "teams/Orioles_pitchers.txt";
	}
	case "Reds":{
		teamBatting = "teams/Reds_batting.txt";
		teamPitching = "teams/Reds_pitchers.txt";
	}
	case "Astros":{
		teamBatting = "teams/Astros_batting.txt";
		teamPitching = "teams/Astros_pitchers.txt";
	}
	case "Athletics":{
		teamBatting = "teams/Athletics_batting.txt";
		teamPitching = "teams/Athletics_pitchers.txt";
	}
	case "Nationals":{
		teamBatting = "teams/Nationals_batting.txt";
		teamPitching = "teams/Nationals_pitchers.txt";
	}
	case "Blue_Jays":{
		teamBatting = "teams/Blue_Jays_batting.txt";
		teamPitching = "teams/Blue_Jays_pitchers.txt";
	}
	case "Marlins":{
		teamBatting = "teams/Marlins_batting.txt";
		teamPitching = "teams/Marlins_pitchers.txt";
	}
	case "Diamondbacks":{
		teamBatting = "teams/Diamondbacks_batting.txt";
		teamPitching = "teams/Diamondbacks_pitchers.txt";
	}
	case "Indians":{
		teamBatting = "teams/Indians_batting.txt";
		teamPitching = "teams/Indians_pitchers.txt";
	}
	case "Padres":{
		teamBatting = "teams/Padres_batting.txt";
		teamPitching = "teams/Padres_pitchers.txt";
	}
	case "Pirates":{
		teamBatting = "teams/Pirates_batting.txt";
		teamPitching = "teams/Pirates_pitchers.txt";
	}
	case "Rays":{
		teamBatting = "teams/Rays_batting.txt";
		teamPitching = "teams/Rays_pitchers.txt";
	}
	case "Royals":{
		teamBatting = "teams/Royals_batting.txt";
		teamPitching = "teams/Royals_pitchers.txt";
	}
	default:{
		System.out.println("enter a valid team, capitalize");
	}
	}
	
	
	try {
		BufferedReader reader = new BufferedReader(
		        new FileReader((teamBatting)));
		
		BufferedReader reader_2 = new BufferedReader(
		        new FileReader((teamPitching)));
		
		Scanner scanner = new Scanner(reader);
		
		Scanner scanner2 = new Scanner(reader_2);
		
		while (scanner.hasNextLine()){
			
			String[] playerData = new String[13];
			
			for(int x = 0; x < 13; x++){
				playerData[x] = scanner.next();
			}
			Player player = new Player(playerData);
			team.addPlayer(player);
			
		}
		
		while (scanner2.hasNextLine() && temp2 < pitcherCount){
			
			String[] pitcherData = new String[18];
			
			// PlayerData for Pitchers is 0 across the board
			String[] playerData = new String[13];
			Arrays.fill(playerData, "0");
			
			for(int x = 0; x < 18; x++){
				pitcherData[x] = scanner2.next();
			}
			
			Pitcher pitcher = new Pitcher(playerData, pitcherData);
			team.addPlayer(pitcher);
			temp2++;
		}
		
		team.configBattingRoster();
		team.configFieldingRoster();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return team;
}
}
