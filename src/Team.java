import java.util.ArrayList;


public class Team {
	
private int playerAtBat = -1;
private ArrayList<Player> players = new ArrayList<Player>();
private String teamName = "temp";

private int score = 0;
private int outs = 0;

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
	players.add(p);
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

}
