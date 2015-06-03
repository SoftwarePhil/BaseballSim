//test
public class CurrentBatting {

Pitcher pitcher;
Player player;

private int strikes;
private int balls;
private int fouls;

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


}
