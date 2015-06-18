
public class Batting {

private CurrentBatting currentBatting;
private Player player;
private Pitcher pitcher;

private int outcome;
private int strikes;
private int hit;

private float chanceOfBall = 0;
private float chanceOfStrike = 0;
private float chanceOfHit = 0;
private float chanceOfFoul = 0;
private float pitchSpeed = 0;
private float z = 0;

private float avgIPR = 52.7f;
private float maxZ  = 144.0f;

private float FBPR = 0;

public int startBatting (CurrentBatting cb){
	currentBatting = cb;
	pitcher = cb.getPitcher();
	player = cb.getPlayer();
	
	FBPR = generateFBPR();
	chanceOfBall = (1 - pitcher.getZonePer()) * (1 - player.getoSwing());
	chanceOfStrike = (pitcher.getZonePer() * (1-player.getoSwing())) + ((1 - pitcher.getZonePer())* player.getzSwing()* player.getzContact())
				+ (pitcher.getZonePer() + player.getzSwing() * (1-player.getzContact()));
	chanceOfFoul = (1-pitcher.getZonePer() + player.getoSwing() + player.getoContact() * FBPR + (pitcher.getZonePer() + player.getzSwing() + player.getzContact() + FBPR));
	
	return atBat();
}

private float generateFBPR(){
	z = -66.7f +(generatePitchSpeed()/player.getIPR());
	
	if(z < avgIPR){
		z = (z/avgIPR)* 1/2;
	}
	else{
		z = 1/2f + (((z-avgIPR)/(maxZ - avgIPR))*(.5f));
	}
	
	return z;
}

private float generatePitchSpeed(){
	
	return 87.93f;
}

public int atBat(){
	strikes = currentBatting.getStrikes();
	while(strikes <= 2){
		outcome = pitch();
		if(outcome == 0){
			strikes = currentBatting.getStrikes();
		}
		else{
			return hit();
		}
	}
	return 0;
} 

public int pitch(){
	int temp = (int)(player.getBattingAverage() * Math.random() * 100);
	if(temp < 20){
		currentBatting.addStrike();
		System.out.println("Strikes " + currentBatting.getStrikes() + " outcome " + temp);
		return 0;
	}
	else return temp;
}

public int hit(){
	return 1;
}

public Player getBatter(){
	return currentBatting.getPlayer();
}
}
