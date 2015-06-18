import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class CreateTeam {

private Team home = new Team();
private Team away = new Team();
private Team[] teams;
private String team_name_home = "";
private String team_name_away = "";
private int teamCounter = 0;

public Team[] createTeams(String team_name_home, String team_name_away){
	
	this.team_name_home = team_name_home;
	this.team_name_away = team_name_away;
		
	//Team[] teams = {createTeam(team_name_home), createTeam(team_name_away)};
	
	return teams;
	
}

public void createTeam(String team_name) {
	// batting_players.append(([row["Name"].replace(" ", ""), row["Position"], float(row["H"]), float(row["IPR"]), float(row["O-Swing%"]), float(row["Z-Swing%"]), float(row["O-Contact%"]), float(row["Z-Contact%"]), float(row["1B%"]), float(row["2B%"]), float(row["3B%"]), float(row["HR%"]), float(row["FP"])]))

	Team team = new Team();
	team.setTeamName(team_name);
	
	try {
		BufferedReader reader = new BufferedReader(
		        new FileReader(("team.txt")));
		
		Scanner scanner = new Scanner(reader);
		
		while (scanner.hasNext()){
			
			String[] playerData = new String[13];
			
			for(int x = 0; x < 12; x++){
				playerData[x] = scanner.next();
				System.out.println(playerData[x]);
			}
			
			Player player = new Player(playerData);
			
		}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
