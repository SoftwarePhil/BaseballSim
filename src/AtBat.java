
public class AtBat implements PlayerState {

private int trys; 
private boolean canBat = true;
private boolean canRun = false;
private Ball ball;
private float battingAvg;
int tempInt;
	
public AtBat(float bA){
	battingAvg = bA;
}

public void start(){

	trys = 3;
	System.out.println("Player is at bat");
}

public int action(Object o){
	if(trys == 0){ 
		canBat = false;
		System.out.println("This player can no longer bat");
		return 0;
		}

	if(canBat){
		ball = (Ball) o;
		System.out.println("Player has swung");
		trys--;
		if(batHit() > 10){
			System.out.println("There was a hit");
			canRun = true;
			return amountOfBases();
		}
		}
	return 0;
}

private int amountOfBases() {
	// This will return the amount of bases that a player will advance if
	// they successfully hit the ball
	return 1;
}

private int batHit(){
	tempInt =(int) (ball.getBallFloat() * isAHit());
	return tempInt; 
}

private int isAHit(){
	return (int) ((Math.random()*battingAvg)*100);
}
}
