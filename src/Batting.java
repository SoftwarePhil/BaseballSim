
public class Batting {

private CurrentBatting currentBatting;
private Player player;
private Pitcher pitcher;
private int outcome;
private int strikes;
private int hit;

public void startBatting (CurrentBatting cb){
	currentBatting = cb;
	pitcher = cb.getPitcher();
	player = cb.getPlayer();
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
	hit = (int)(Math.random() *100);
	if(hit <= player.getChanceOfSingle()){
		currentBatting.setResult(1 + "");
		return 1;
	}
	if(hit <= player.getChanceOfDouble()){
		currentBatting.setResult(2 + "");
		return 2;
	}
	if (hit <= player.getChanceOfTriple()){
		currentBatting.setResult(3 + "");
		return 3;
	}
	else return 4;
}

public Player getBatter(){
	return currentBatting.getPlayer();
}
}
