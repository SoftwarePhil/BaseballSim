import java.util.ArrayList;


public class Team {
	
private int playerAtBat = -1;

private ArrayList<Player> fullTeam = new ArrayList<Player>();
private ArrayList<Player> players = new ArrayList<Player>();
private ArrayList<Player> fieldingRoster = new ArrayList<Player>();

private ArrayList<String> missingPositions = new ArrayList<String>();

private String teamName = "temp";

private int score = 0;
private int outs = 0;
private boolean found = false;
private int count = 0;

public void configFieldingRoster(){
	
	fieldingRoster.add(getPlayerFromArray("LF"));
	fieldingRoster.add(getPlayerFromArray("CF"));
	fieldingRoster.add(getPlayerFromArray("RF"));
	fieldingRoster.add(getPlayerFromArray("3B"));
	fieldingRoster.add(getPlayerFromArray("SS"));
	fieldingRoster.add(getPlayerFromArray("2B"));
	fieldingRoster.add(getPlayerFromArray("1B"));
	fieldingRoster.add(getPlayerFromArray("C"));
	fieldingRoster.add(getPlayerFromArray("P"));

	for(int x = 0; x < fieldingRoster.size(); x++){
		if(fieldingRoster.get(x) == null){
			Player temp = fillPlayerSpot();
			Player temp2 = temp.duplicatePlayer(temp);
			fieldingRoster.set(x, temp2);
			fieldingRoster.get(x).setPosition(missingPositions.get(0));
			missingPositions.remove(0);
		}
	}
	
	for(int h = 0; h < fieldingRoster.size(); h++){
		System.out.println(fieldingRoster.get(h));
	}
}

public Player fillPlayerSpot(){
	
	boolean playerOnList = false;
	
	for(int x = 0; x < fullTeam.size(); x++){
		for(int y = 0; y < fieldingRoster.size(); y++){
			if(fieldingRoster.get(y) != null){
				if(fullTeam.get(x).toString().equals(fieldingRoster.get(y).toString()) == true){
					playerOnList = true;
					
				} 
			}
			if(!playerOnList){
				return fullTeam.get(x);
			}
		}
	}
	
	return null;
}

public Player getPlayerFromArray(String position){
	count = 0;
	found = false;
	
	while((!found) && (count < fullTeam.size())){
		
		if(fullTeam.get(count).getPosition().equals(position)){
			return fullTeam.get(count);
		} else {
			count++;
		}
	}
	
	missingPositions.add(position);
	return null;
}

public void configBattingRoster(){
	// Batting Linup by Most Games
	for(int x = 0; x < 8; x++){
		players.add(fullTeam.get(x));
	}
	// Pitcher
	players.add(fullTeam.get(fullTeam.size()-1));
}

public void addOneToScore(){
	score++;
}

public void addNumToScore(int n){
	score = score + n;
}

public void addOneToOuts(){
	outs++;
}

public void setOutsToZero(){
	outs = 0;
}

public int getOuts(){
	return outs;
}

public int getScore(){
	return score;
}

public void addPlayer(Player p){
	fullTeam.add(p);
}

public Player getPlayer(int index){
	return players.get(index);
}

public Player getNextPlayerAtBat(){
	playerAtBat++;
	return players.get(playerAtBat % 7);
}

public Pitcher getPitcher(){
	return (Pitcher) players.get(8);
}

public String getTeamName() {
	return teamName;
}

public void setTeamName(String teamName) {
	this.teamName = teamName;
}

}
