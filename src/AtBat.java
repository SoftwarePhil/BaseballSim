
public class AtBat implements PlayerState {

private int trys; 
private boolean canBat = true;
private Ball ball;
private float battingAvg;
	
public AtBat(float bA){
	battingAvg = bA;
}

public void start(){

	trys = 3;
	System.out.println("Player is at bat");
}

public void action(Object o){
	if(trys == 0){ 
		canBat = false;
		}

	if(canBat){
		ball = (Ball) o;
		System.out.println("Player has swung");
		trys--;
		}
}
}
