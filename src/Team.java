import java.util.ArrayList;


public class Team {
	
private int playerAtBat = -1;
private ArrayList<Player> players = new ArrayList<Player>();
private String teamName = "temp";

public void addPlayer(Player p){
	players.add(p);
}

public Player getPlayer(int index){
	return players.get(index);
}

public Player getNextPlayerAtBat(){
	playerAtBat++;
	return players.get(playerAtBat % 9);
}

}
