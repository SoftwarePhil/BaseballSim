
public class Player {
	
 private float battingAverage =.5f;
 private String name = "test Player";
 
 private PlayerState atBat;

public Player(float battingAvg, String n){
	battingAverage = battingAvg;
	name = n;
	atBat = new AtBat(battingAverage);
}

}