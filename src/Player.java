
public class Player {
	
private float battingAverage =.5f;
private String name = "test Player";
private int chanceOfSingle = 70;
private int chanceOfDouble = 95;
private int chanceOfTriple = 99;
private int chanceOfHomeRun = 100;

 

public Player(float battingAvg, String n){
	battingAverage = battingAvg;
	name = n;
}


public String toString(){
	return name;
}

public float getBattingAverage(){
	return battingAverage;
}


public int getChanceOfSingle() {
	return chanceOfSingle;
}


public void setChanceOfSingle(int chanceOfSingle) {
	this.chanceOfSingle = chanceOfSingle;
}


public int getChanceOfDouble() {
	return chanceOfDouble;
}


public void setChanceOfDouble(int chanceOfDouble) {
	this.chanceOfDouble = chanceOfDouble;
}


public int getChanceOfTriple() {
	return chanceOfTriple;
}


public void setChanceOfTriple(int chanceOfTriple) {
	this.chanceOfTriple = chanceOfTriple;
}


public int getChanceOfHomeRun() {
	return chanceOfHomeRun;
}


public void setChanceOfHomeRun(int chanceOfHomeRun) {
	this.chanceOfHomeRun = chanceOfHomeRun;
}

}
