
public class Batting {

private CurrentBatting currentBatting;
private float bA;

public Batting (CurrentBatting cb){
	currentBatting = cb;
	bA = currentBatting.getPlayer().getBattingAverage();
}

public void pitch(){

if(currentBatting.getStrikes() > 3){
	
}
} 

public void batterDone(){
	
}
}
