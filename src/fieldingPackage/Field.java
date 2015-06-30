package fieldingPackage;
import java.util.Random;
import teamPackage.Player;


public class Field {

CurrentField currentField;
Random random = new Random();
int[] temp;
int currentAmountOfOuts = 0;

public Field(CurrentField cf){
	currentField = cf;
}


public int newPlayerOnBases(int n, Player p, int numOfOuts, String walkOrHomeRun){
currentField.resetOuts();
currentAmountOfOuts = numOfOuts;
if(walkOrHomeRun.equals("walk")){
	newPlayerOnBasesWalk(p);
	return 0;
}

else if(walkOrHomeRun.equals("homerun")){
	newPlayerOnBasesHomerun(p);
	return currentField.getScore();
}

else{
currentField.putBallIntoRandomSquare();
if(!(checkIfBallIsCaught())){
	try{
	System.out.println("amount of bases to move " + n);
	if (n > 0){	
		if(!(currentField.three.getPlayerOnBase() == null)){
			playerOnThrid();
		}
		
		if(!(currentField.two.getPlayerOnBase() == null)){
			currentField.two.movePlayerOneBase();
			isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3));
			if(n >= 2){
				playerOnThrid();
				}
		}
		
		if(!(currentField.one.getPlayerOnBase() == null)){
			switch (n){
				case 1: {
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
					
					moveOneBase(p);
					break;
				}
				
				case 2: {
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3));
	
					moveTwoBases(p);
					break;
				}
				
				case 3: {
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3));
					playerOnThrid();
	
					movePlayerThreeBases(p);
					break;
				}
				
				/*case 4:{
					currentField.one.movePlayerOneBase();
					isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
					currentField.two.movePlayerOneBase();
					isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3));
					playerOnThrid();
					
					movePlayerFourBases(p);
					break;
				}*/
			}
		}
		else {
			switch(n){
			case 1: {
				moveOneBase(p);
				break;
			}
			case 2: {
				moveTwoBases(p);
				break;
			}
			case 3: {
				movePlayerThreeBases(p);
				break;
			}
			/*case 4: {
				movePlayerFourBases(p);
				break;
			}*/
			}
		};
	}
}
catch(Exception e){
	System.out.println("three outs have happened! ending fielding");
	}
}

else {
		currentField.addOneToOuts();
	}
return currentField.getOuts();
}
}

private void moveOneBase(Player p) throws Exception{
	currentField.one.addPlayerToBase(p);
	isPlayerOutOnBase(1, checkIfPlayerIsOnSameBaseAsBall(1));
}

private void moveTwoBases(Player p) throws Exception{
	currentField.one.addPlayerToBase(p);
	boolean b = isPlayerOutOnBase(1, checkIfPlayerIsOnSameBaseAsBall(1));
	
	if(!b){
		currentField.one.movePlayerOneBase();
		isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
		}
}

private void movePlayerThreeBases(Player p) throws Exception{
	currentField.one.addPlayerToBase(p);
	boolean b = isPlayerOutOnBase(1, checkIfPlayerIsOnSameBaseAsBall(1));
	
	if(!b){
		currentField.one.movePlayerOneBase();
		b = isPlayerOutOnBase(2, checkIfPlayerIsOnSameBaseAsBall(2));
		}
	
	if(!b){
		currentField.two.movePlayerOneBase();
		isPlayerOutOnBase(3, checkIfPlayerIsOnSameBaseAsBall(3));
	}
}

private void movePlayerFourBases(Player p){
	currentField.one.addPlayerToBase(p);
	currentField.two.movePlayerOneBase();
		
	if(currentField.three.getPlayerOnBase() == null){
	}
	else{
	currentField.three.movePlayerOneBase();
	currentField.addScore();
	System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	}
}

private boolean checkIfBallIsCaught(){
	//gridFieldArray[0][0].setKey("LF", 15);
	//gridFieldArray[0][2].setKey("CF", 15);
	//gridFieldArray[0][4].setKey("RF", 15);
	temp = currentField.ball.getPostion(); 
	System.out.println("Ball hit into field at " + " Ball pos " + temp[0] +" :" + temp[1]);

	if((temp[0] == 0 && temp[1] == 0) || (temp[0] == 0 && temp[1] == 2) || (temp[0] == 0 && temp[1] == 4)){
		System.out.println("...checking if ball was caught");
		return isBallCaught(temp[0], temp[1]);
	}
	else return false;
}

private boolean isBallCaught(int x, int y){
	return currentField.wasBallCaught(x, y);
}

private boolean checkIfPlayerIsOnSameBaseAsBall(int baseNum){
	//gridFieldArray[2][3].setKey("2B", 8);
	//gridFieldArray[3][0].setKey("3B", 8);
	//gridFieldArray[3][4].setKey("1B", 5);
	//gridFieldArray[3][2].setKey("C", 8);
int rand = (int)(Math.random()*100);
if(rand > 60){
	return true;
}
else return false;
	/*
	currentField.putBallIntoRandomInFieldSquare();
	
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
	
	return false;*/
}

private boolean isPlayerOutOnBase(int baseNum, boolean b) throws Exception{
try{
	if(currentAmountOfOuts + currentField.getOuts() >= 3){
		throw new Exception("3 outs have happened");
	}
	if((b)){
	System.out.println("Player may get out on base");
	switch (baseNum){
		case 1: {
		//	if(!checkIfPlayerIsOnSameBaseAsBall(1)){
				currentField.addOneToOuts();
				System.out.println("Player got out on 1st base!");
				currentField.one.removePlayerFromBase();
				return true;
			//}
			//else return false;
		}
		case 2: {
			//if(!checkIfPlayerIsOnSameBaseAsBall(2)){
				currentField.addOneToOuts();
				System.out.println("Player got out on 2nd base!");
				currentField.two.removePlayerFromBase();
				return true;
		//	}
			//else return false;
		}
		case 3: {
			//if(!checkIfPlayerIsOnSameBaseAsBall(3)){
				currentField.addOneToOuts();
				System.out.println("Player got out on 3rd base!");
				currentField.three.removePlayerFromBase();
				return true;
		//	}
			//else return false;
		}
		case 4: {
			//if(!checkIfPlayerIsOnSameBaseAsBall(4)){
				currentField.addOneToOuts();
				System.out.println("Player got out on home plate!");
			return true;
		//	}
			//else return false;
		}
		default: {
			System.out.println("SOMETHING WENT WRONG");
		}
	}
	
	}
	System.out.println("Player made it to base safely!" + b);
	return false;
}
	finally{
	}
}

private void playerOnThrid(){
	if(currentField.three.getPlayerOnBase() == null){
	}
	else{
		try{
		boolean test = isPlayerOutOnBase(4, checkIfPlayerIsOnSameBaseAsBall(4));
		
		if(!test){
		currentField.three.movePlayerOneBase();
		currentField.addScore();
		System.out.println(currentField.home.getPlayerOnBase() + " has scored");
		}
		}
		catch(Exception e){
			System.out.println("3 outs have happened on the field");
		}
	}
}

private void newPlayerOnBasesWalk(Player p){	
System.out.println("amount of bases to move is 1, walk ");
		if(!(currentField.three.getPlayerOnBase() == null)){
			if(currentField.three.getPlayerOnBase() == null){
			}
			else{
				currentField.three.movePlayerOneBase();
				currentField.addScore();
				System.out.println(currentField.home.getPlayerOnBase() + " has scored");
				}
			}
		if(!(currentField.two.getPlayerOnBase() == null)){
			currentField.two.movePlayerOneBase();
		}
		
		if(!(currentField.one.getPlayerOnBase() == null)){			
			currentField.one.movePlayerOneBase();
		}
		
		else {
			currentField.one.addPlayerToBase(p);
		}
}

private void newPlayerOnBasesHomerun(Player p){
	System.out.println("Homerun!!");
	
	if(!(currentField.three.getPlayerOnBase() == null)){
		currentField.three.movePlayerOneBase();
		currentField.addScore();
		System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	}
	
	if(!(currentField.two.getPlayerOnBase() == null)){
		currentField.two.movePlayerOneBase();
		currentField.three.movePlayerOneBase();
		currentField.addScore();
		System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	}
	
	if(!(currentField.one.getPlayerOnBase() == null)){
		currentField.one.movePlayerOneBase();
		currentField.two.movePlayerOneBase();
		currentField.three.movePlayerOneBase();
		currentField.addScore();
		System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	}
	
	currentField.one.addPlayerToBase(p);
	currentField.one.movePlayerOneBase();
	currentField.two.movePlayerOneBase();
	currentField.three.movePlayerOneBase();
	currentField.addScore();
	System.out.println(currentField.home.getPlayerOnBase() + " has scored");
	System.out.println("amount of outs " + currentField.getOuts());
}
	

}

