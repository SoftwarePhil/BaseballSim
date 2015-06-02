import java.util.ArrayList;


public class Team {

private ArrayList<Player> players = new ArrayList<Player>();
private String teamName = "temp";
private int score = 0;
private int outs = 0;

public void addPlayer(Player p){
	players.add(p);
}

public Player getPlayer(int index){
	return players.get(index);
}

public void teamSwtich(){
	outs = 0;
}

}
