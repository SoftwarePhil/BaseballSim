package fieldingPackage;
import java.util.Arrays;
import java.util.Random;

import teamPackage.Player;


public class Field {

CurrentField currentField;
Random random = new Random();
int[] temp;

public Field(CurrentField cf){
	currentField = cf;
}


public int newPlayerOnBases(int n, Player p, int numOfOuts){
currentField.resetOuts();
currentField.putBallIntoRandomSquare();
if(!(checkIfBallIsCaught())){
	System.out.println("amount of bases to move " + n);
	if (n > 0){	
		if(!(currentField.three.getPlayerOnBase() == null)){
			playerOnThrid();
		}
		
		if(!(currentField.two.getPlayerOnBase() == null)){
			currentField.two.movePlayerOneBase();
			isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
			if(n >= 2){
				playerOnThrid();
				}
		}
		
		if(!(currentField.one.getPlayerOnBase() == null)){
			switch (n){
				case 1: {
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					currentField.one.addPlayerToBase(p);
					isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
					break;
				}
				
				case 2: {
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
	
					currentField.one.addPlayerToBase(p);
					isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					break;
				}
				
				case 3: {
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
					playerOnThrid();
	
					currentField.one.addPlayerToBase(p);
					isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
					break;
				}
				
				case 4:{
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
					playerOnThrid();
					
					currentField.one.addPlayerToBase(p);
					isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
					playerOnThrid();
					break;
				}
			}
		
		}
		else {
			switch(n){
			case 1: {
				currentField.one.addPlayerToBase(p);
				isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
				break;
			}
			case 2: {
				currentField.one.addPlayerToBase(p);
				isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
				currentField.one.movePlayerOneBase();
				isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
				break;
			}
			case 3: {
				currentField.one.addPlayerToBase(p);
				isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
				currentField.one.movePlayerOneBase();
				isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
				currentField.two.movePlayerOneBase();
				isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
				break;
			}
			case 4: {
				currentField.one.addPlayerToBase(p);
				isPlayerOutOnBase(1, checkIfPlayerIsSafe(1));
				currentField.one.movePlayerOneBase();
				isPlayerOutOnBase(2, checkIfPlayerIsSafe(2));
				currentField.two.movePlayerOneBase();
				isPlayerOutOnBase(3, checkIfPlayerIsSafe(3));
				playerOnThrid();
				break;
			}
			}
		};
	}
}
else {
		currentField.addOneToOuts();
	}
return currentField.getOuts();

}

public boolean checkIfBallIsCaught(){
	//gridFieldArray[0][0].setKey("LF", 15);
	//gridFieldArray[0][2].setKey("CF", 15);
	//gridFieldArray[0][4].setKey("RF", 15);
	temp = currentField.ball.getPostion(); 
	//System.out.println("Ball hit into field at " + " Ball pos " + temp[0] +" :" + temp[1]);

	if((temp[0] == 0 && temp[1] == 0) || (temp[0] == 0 && temp[1] == 2) || (temp[0] == 0 && temp[1] == 4)){
		return isBallCaught(temp[0], temp[1]);
	}
	else return false;
}

private boolean isBallCaught(int x, int y){
	return currentField.wasBallCaught(x, y);
}

public boolean checkIfPlayerIsSafe(int baseNum){
	//gridFieldArray[2][3].setKey("2B", 8);
	//gridFieldArray[3][0].setKey("3B", 8);
	//gridFieldArray[3][4].setKey("1B", 5);
	//gridFieldArray[3][2].setKey("C", 8);
int rand = (int)(Math.random()*100);
if(rand > 60){
	return true;
}
else return false;
	
	/*	currentField.putBallIntoRandomSquare();
	int[] basePos = new int[2];
	switch (baseNum){
	case 1:{
		basePos[0] = 3;
		basePos[1] = 4;
		break;
	}
	case 2:{
		basePos[0] = 2;
		basePos[1] = 3;
		break;
	}
	case 3:{
		basePos[0] = 3;
		basePos[1] = 2;
		break;
	}
	case 4:{
		basePos[0] = 3;
		basePos[1] = 4;
		break;
	}
	}
	temp = currentField.ball.getPostion(); 
	System.out.println("Base num " + basePos[0] +" : "+ basePos[1] + " Ball pos " + temp[0] +" :" + temp[1]);
	if(temp[0] == basePos[0] && temp[1] == basePos[1] ){
		System.out.println("Ball and player are on same base");
		return isBallCaught(temp[0], temp[1]);
	}
	
	return false;
	*/
}

public boolean isPlayerOutOnBase(int baseNum, boolean b){
	boolean ballCaught = checkIfPlayerIsSafe(baseNum);
	if((ballCaught)){
	System.out.println("Player has may get out on base");
	switch (baseNum){
		case 1: {
			if(!checkIfPlayerIsSafe(1)){
				currentField.addOneToOuts();
				System.out.println("Player got out on 1st base!");
				currentField.one.removePlayerFromBase();
				return true;
			}
			else return false;
		}
		case 2: {
			if(!checkIfPlayerIsSafe(2)){
				currentField.addOneToOuts();
				System.out.println("Player got out on 2nd base!");
				currentField.two.removePlayerFromBase();
				return true;
			}
			else return false;
		}
		case 3: {
			if(!checkIfPlayerIsSafe(3)){
				currentField.addOneToOuts();
				System.out.println("Player got out on 3rd base!");
				currentField.three.removePlayerFromBase();
				return true;
			}
			else return false;
		}
		case 4: {
			if(!checkIfPlayerIsSafe(4)){
				currentField.addOneToOuts();
				System.out.println("Player got out on home plate!");
				return true;
			}
			else return false;
		}
		default: {
			System.out.println("SOMETHING WENT WRONG");
		}
	}
	
	}
	System.out.println("Player made it to base safely!" + ballCaught);
	return false;
}
private void playerOnThrid(){
	boolean test = isPlayerOutOnBase(4, checkIfPlayerIsSafe(4));
	if(!test){
	currentField.three.movePlayerOneBase();
	currentField.addScore();
	System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	}
}
}
