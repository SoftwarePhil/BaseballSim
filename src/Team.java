import java.util.ArrayList;


public class Team {

private ArrayList<Player> players = new ArrayList<Player>();
private String teamName = "temp";

public void addPlayer(Player p){
	players.add(p);
}

public Player getPlayer(int index){
	return players.get(index);
}


}
