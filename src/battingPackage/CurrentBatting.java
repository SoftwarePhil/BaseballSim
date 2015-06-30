package battingPackage;
import teamPackage.Pitcher;
import teamPackage.Player;

public class CurrentBatting {

private Pitcher pitcher;
private Player player;

private int strikes = 0;
private int balls = 0;
private int fouls = 0;
private String homerunOrWalk = "";

public CurrentBatting(Pitcher p, Player py){
	pitcher = p;
	player = py;
}


public void addStrike() {
	strikes = strikes + 1;
}

public void addBall(){
	balls = balls + 1;
}

public void addFoul(){
	fouls = fouls + 1;
}

public int getStrikes(){
	return strikes;
}

public int getBalls() {
	return balls;
}

public void setBalls(int balls) {
	this.balls = balls;
}

public int getFouls() {
	return fouls;
}

public void setFouls(int fouls) {
	this.fouls = fouls;
}

public Player getPlayer() {
	return player;
}

public Pitcher getPitcher() {
	return pitcher;
}

public String getHomerunOrWalk() {
	return homerunOrWalk;
}


public void setHomerunOrWalk(String homerunOrWalk) {
	this.homerunOrWalk = homerunOrWalk;
}
}
