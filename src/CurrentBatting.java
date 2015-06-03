//test
public class CurrentBatting {

private Pitcher pitcher;
private Player player;

private int strikes = 0;
private int balls = 0;
private int fouls = 0;

public CurrentBatting(Pitcher p, Player py){
	pitcher = p;
	player = py;
}

public int getStrikes() {
	return strikes;
}

public void setStrikes(int strikes) {
	this.strikes = strikes;
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
}
