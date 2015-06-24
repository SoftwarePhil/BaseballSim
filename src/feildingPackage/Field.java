package feildingPackage;
import java.util.Arrays;
import java.util.Random;

import teamPackage.Player;


public class Field {

CurrentField currentField;
Random random = new Random();

public Field(CurrentField cf){
	currentField = cf;
}


public int newPlayerOnBases(int n, Player p, int numOfOuts){
System.out.println("amount of bases to move " + n);

currentField.putBallIntoRandomSquare();
if(!(checkIfBallIsCaught())){
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
	else {
		currentField.addOneToOuts();
	}
}

return currentField.getOuts() + numOfOuts;

}

public boolean checkIfBallIsCaught(){
	//gridFieldArray[0][0].setKey("LF", 15);
	//gridFieldArray[0][2].setKey("CF", 15);
	//gridFieldArray[0][4].setKey("RF", 15);
	int[] temp = currentField.ball.getPostion(); 

	if((temp[0] == 0 && temp[1] == 0) || (temp[0] == 0 && temp[1] == 2) || (temp[0] == 0 && temp[1] == 4)){
		return isBallCaught(temp[0], temp[1]);
	}
	else return false;
}

private boolean isBallCaught(int x, int y){
	return currentField.wasBallCaught(x, y);
}

private void playerOnThrid(){
	currentField.three.movePlayerOneBase();
	currentField.addScore();
	System.out.println(currentField.home.getPlayerOnBase() + " has scored");
}
}
