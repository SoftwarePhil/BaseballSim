package fieldingPackage;
import java.util.Arrays;

import teamPackage.Team;


public class CurrentField {

private int score = 0;
private int outs = 0;

private Team fieldingTeam;

protected Base home = new Base();
protected Base one = new Base();
protected Base two = new Base();
protected Base three = new Base();

public Ball ball = new Ball();

/* Fielding Array (x marks plate, P is pitcher square)
 * ________________
 * | 0 | 1 |  2   |
 * ________________
 * | 3 | 4x | 5   |
 * ________________
 * | 6x | 7P | 8x |
 * ________________
 * |   | 9x |     |
 * ----------------
 */

private int rows = 4;
private int columns = 5;

FieldSquare[][] gridFieldArray = new FieldSquare[rows][columns];

public CurrentField(){
	one.setNextBase(two);
	two.setNextBase(three);
	three.setNextBase(home);
	
	for(int x = 0; x < rows; x++){
		for(int y = 0; y < columns; y++){
			gridFieldArray[x][y] = new FieldSquare(false, null);
		}
	}
	
	gridFieldArray[0][0].setKey("LF", 15);
	gridFieldArray[0][2].setKey("CF", 15);
	gridFieldArray[0][4].setKey("RF", 15);
	gridFieldArray[2][1].setKey("SS", 8);
	gridFieldArray[2][2].setKey("P", 8);
	gridFieldArray[2][3].setKey("2B", 8);
	gridFieldArray[3][0].setKey("3B", 8);
	gridFieldArray[3][2].setKey("C", 8);
	gridFieldArray[3][4].setKey("1B", 5);
}

public void reset(){
	score = 0;
	resetOuts();
	home.removePlayerFromBase();
	one.removePlayerFromBase();
	two.removePlayerFromBase();
	three.removePlayerFromBase();
}

public void resetOuts(){
	outs = 0;
}

public void start(Team fieldingTeam){
	score = 0;
	outs = 0;
	home.removePlayerFromBase();
	one.removePlayerFromBase();
	two.removePlayerFromBase();
	three.removePlayerFromBase();
	this.fieldingTeam = fieldingTeam;
	
	gridFieldArray[0][0].setFielder(fieldingTeam.getPlayerInFieldingPostion("LF"));
	gridFieldArray[0][2].setFielder(fieldingTeam.getPlayerInFieldingPostion("CF"));
	gridFieldArray[0][4].setFielder(fieldingTeam.getPlayerInFieldingPostion("RF"));
	gridFieldArray[2][1].setFielder(fieldingTeam.getPlayerInFieldingPostion("SS"));
	gridFieldArray[2][2].setFielder(fieldingTeam.getPlayerInFieldingPostion("P"));
	gridFieldArray[2][3].setFielder(fieldingTeam.getPlayerInFieldingPostion("2B"));
	gridFieldArray[3][0].setFielder(fieldingTeam.getPlayerInFieldingPostion("3B"));
	gridFieldArray[3][2].setFielder(fieldingTeam.getPlayerInFieldingPostion("C"));
	gridFieldArray[3][4].setFielder(fieldingTeam.getPlayerInFieldingPostion("1B"));
}

public void putBallIntoRandomSquare(){
	ball.setPostion((int)(Math.random()*4), (int)(Math.random()*5));
	//ball.setPostion(0, 0);
}

public void putBallIntoRandomInFieldSquare(){
	ball.setPostion((int)(Math.random()*2 + 2), (int)(Math.random()*4));
}

public boolean wasBallCaught(int x, int y){
	return gridFieldArray[x][y].wasBallCaught();
}

public int getScore() {
	return score;
}
public void addScore() {
	score = score +1;
}
public int getOuts() {
	return outs;
}
public void addOneToOuts() {
	outs = outs + 1;
}
public String toString(){
	return "base 1 " +one.toString() + "\n" + "base 2 " +two.toString() + "\n"
			+ "base 3 " +three.toString() + "\n";
}
}
