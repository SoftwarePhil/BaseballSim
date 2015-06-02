
public class Player {
	
private float battingAverage =.5f;
private String name = "test Player";
 
private PlayerState atBat;
private PlayerState running;

public Player(float battingAvg, String n){
	battingAverage = battingAvg;
	name = n;
	atBat = new AtBat(battingAverage);
	running = new Running();
}

public void upAtBat(){
	atBat.start();
}

public int pitch(Ball b){
	return atBat.action(b);
}

public void startRunning(){
	
}

public String toString(){
	return name;
}

}
