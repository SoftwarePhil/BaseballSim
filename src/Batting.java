
public class Batting {

private CurrentBatting currentBatting;
private Player player;
private Pitcher pitcher;

private int outcome;
private int strikes;
private int balls;

private float aSingle;
private float aDouble;
private float aTriple;

private float chanceOfBall = 0;
private float chanceOfStrike = 0;
private float chanceOfHit = 0;
private float chanceOfFoul = 0;
private float z = 0;

private float avgIPR = 52.7f;
private float maxZ  = 144.0f;

private float FBPR = 0;

public int startBatting (CurrentBatting cb){
	balls = 0;
	strikes = 0;
	
	currentBatting = cb;
	pitcher = cb.getPitcher();
	player = cb.getPlayer();
	
	FBPR = generateFBPR();
	chanceOfBall = (1 - pitcher.getZonePer()) * (1 - player.getoSwing());
	chanceOfStrike = (pitcher.getZonePer() * player.getzSwing() * (1-player.getzContact())) +
			(pitcher.getZonePer() * (1-player.getzSwing())) + (((1-pitcher.getZonePer()) * player.getoSwing() * (1-player.getoContact())));
	chanceOfFoul = ((1-pitcher.getZonePer()) * player.getoSwing() * player.getoContact() * FBPR) + (pitcher.getZonePer() * player.getzSwing() * player.getzContact() * FBPR);
	chanceOfHit = ((1-pitcher.getZonePer()) * player.getoSwing() * player.getoContact() * (1 - FBPR)) + (pitcher.getZonePer() * player.getzSwing() * player.getzContact() * (1-FBPR));
	
	chanceOfBall = chanceOfBall * 1000;
	chanceOfStrike =chanceOfStrike * 1000;
	chanceOfHit = chanceOfHit * 1000;
	chanceOfFoul = chanceOfFoul * 1000;
	
	aSingle = player.getChanceSingle() * 100;
	aDouble = player.getChanceDouble() * 100;
	aTriple = player.getChanceTriple() * 100;
	
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

private void generateNewFBPR(){
	FBPR = generateFBPR();
	
	chanceOfFoul = ((1-pitcher.getZonePer()) * player.getoSwing() * player.getoContact() * FBPR) + (pitcher.getZonePer() * player.getzSwing() * player.getzContact() * FBPR);
	chanceOfHit = ((1-pitcher.getZonePer()) * player.getoSwing() * player.getoContact() * (1 - FBPR)) + (pitcher.getZonePer() * player.getzSwing() * player.getzContact() * (1-FBPR));
	
	chanceOfFoul = 1000 * chanceOfFoul;
	chanceOfHit = 1000 * chanceOfHit;
}

private float generatePitchSpeed(){
	
	return pitcher.getPitchSpeed();
}

public int atBat(){
	strikes = currentBatting.getStrikes();
	while(strikes <= 2 && balls <= 3){
		generateNewFBPR();
		outcome = pitch();
		
		if(outcome == 0){
			return hit();
		}
	}
	if(currentBatting.getBalls() == 4){
		return 1;
	}
	return 0;
} 

public int pitch(){
	int temp = (int)(Math.random() * 1000);
	//ball
	if(temp < chanceOfBall){
		currentBatting.addBall();
		balls = currentBatting.getBalls();
		System.out.println("Ball " + balls + " outcome " + temp);
		return 1;
	}
	//strike
	else if(temp < chanceOfBall + chanceOfStrike){
		currentBatting.addStrike();
		strikes = currentBatting.getStrikes();
		System.out.println("Strike " + currentBatting.getStrikes() + " outcome " + temp);
		return 1;
	}
	//foul
	else if (temp < chanceOfBall + chanceOfStrike + chanceOfFoul){
		if(currentBatting.getStrikes() < 2){
			currentBatting.addStrike();
			strikes = currentBatting.getStrikes();
			System.out.println("Foul that was strike " + currentBatting.getStrikes() + " outcome " + temp);
			return 1;
		}
		else {
			currentBatting.addFoul();
			System.out.println("foul " + currentBatting.getFouls() + " outcome " + temp);
			return 1;
		}
	}
	//hit
	else{
		System.out.println("Ball was hit by " + player + " outcome = " + temp);
		return 0;
	} 
}

public int hit(){
	int temp = (int)(Math.random() * 100);
	if(temp < aSingle){
		return 1;
	}
	else if (temp < aSingle + aDouble){
		return 2;
	}
	else if (temp < aSingle + aDouble + aTriple){
		return 3;
	}
	else {
		return 4;
	}
}

public Player getBatter(){
	return currentBatting.getPlayer();
}

public String toString(){
	return "Chance of ball: " + chanceOfBall + "\n" + "Chance of hit: " + chanceOfHit + "\n" +
			"Chance of foul: " + chanceOfFoul + "\n" + "Chance of strike: " + chanceOfStrike + "\n";
}
}
