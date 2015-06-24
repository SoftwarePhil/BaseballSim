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
private String team_name_home = "";
private String team_name_away = "";
private int teamCounter = 0;
private int pitcherCount = 1;
private int battingLineup = 9;

public Team[] createTeams(String team_name_home, String team_name_away){
	
	this.team_name_home = team_name_home;
	this.team_name_away = team_name_away;
	
	home = createTeam(this.team_name_home);
	away = createTeam(this.team_name_away);
		
	Team[] teams = {home, away};
	
	return teams;
	
}

public Team createTeam(String team_name) {
	// batting_players.append(([row["Name"].replace(" ", ""), row["Position"], float(row["H"]), float(row["IPR"]), float(row["O-Swing%"]), float(row["Z-Swing%"]), float(row["O-Contact%"]), float(row["Z-Contact%"]), float(row["1B%"]), float(row["2B%"]), float(row["3B%"]), float(row["HR%"]), float(row["FP"])]))

	Team team = new Team();
	team.setTeamName(team_name);
	int temp2 = 0;
	
	
	try {
		BufferedReader reader = new BufferedReader(
		        new FileReader(("team.txt")));
		
		BufferedReader reader_2 = new BufferedReader(
		        new FileReader(("pitchers.txt")));
		
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
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return team;
}
}
