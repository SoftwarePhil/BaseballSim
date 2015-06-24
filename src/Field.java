import java.util.Arrays;
import java.util.Random;


public class Field {

CurrentField currentField;
Random random = new Random();

public Field(CurrentField cf){
	currentField = cf;
}


public void newPlayerOnBases(int n, Player p){
System.out.println("amount of bases to move " + n);

currentField.putBallIntoRandomSquare();

if (n > 0){	
	if(!(currentField.three.getPlayerOnBase() == null)){
		playerOnThrid();
	}
	
	if(!(currentField.two.getPlayerOnBase() == null)){
		currentField.two.movePlayerOneBase();
		if(n >= 2){
			playerOnThrid();
			}
	}
	
	if(!(currentField.one.getPlayerOnBase() == null)){
		switch (n){
			case 1: {
				currentField.one.movePlayerOneBase();
				currentField.one.addPlayerToBase(p);
				break;
			}
			
			case 2: {
				currentField.one.movePlayerOneBase();
				currentField.two.movePlayerOneBase();

				currentField.one.addPlayerToBase(p);
				currentField.one.movePlayerOneBase();
				break;
			}
			
			case 3: {
				currentField.one.movePlayerOneBase();
				currentField.two.movePlayerOneBase();
				playerOnThrid();

				currentField.one.addPlayerToBase(p);
				currentField.one.movePlayerOneBase();
				currentField.two.movePlayerOneBase();
				break;
			}
			
			case 4:{
				currentField.one.movePlayerOneBase();
				currentField.two.movePlayerOneBase();
				playerOnThrid();
				
				currentField.one.addPlayerToBase(p);
				currentField.one.movePlayerOneBase();
				currentField.two.movePlayerOneBase();
				playerOnThrid();
				break;
			}
		}
	
	}
	else {
		switch(n){
		case 1: {
			currentField.one.addPlayerToBase(p);
			break;
		}
		case 2: {
			currentField.one.addPlayerToBase(p);
			currentField.one.movePlayerOneBase();
			break;
		}
		case 3: {
			currentField.one.addPlayerToBase(p);
			currentField.one.movePlayerOneBase();
			currentField.two.movePlayerOneBase();
			break;
		}
		case 4: {
			currentField.one.addPlayerToBase(p);
			currentField.one.movePlayerOneBase();
			currentField.two.movePlayerOneBase();
			playerOnThrid();
			break;
		}
		}
	};
}
}

public void checkIfPlayerIsOut(){
	
}

private void playerOnThrid(){
	currentField.three.movePlayerOneBase();
	currentField.addScore();
	System.out.println(currentField.home.getPlayerOnBase() + " has scored");
}
}
