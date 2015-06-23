import java.util.Arrays;


public class CurrentField {

private int score = 0;
private int outs = 0;

private Team fieldingTeam;

protected Base home = new Base();
protected Base one = new Base();
protected Base two = new Base();
protected Base three = new Base();

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
	
	// FieldSquare(boolean ball, int size, String position)	
	for(int x = 0; x < rows; x++){
		for(int y = 0; y < columns; y++){
			gridFieldArray[x][y] = new FieldSquare(false, null);
		}
	}
	
	gridFieldArray[0][0].setKey("LF");
	gridFieldArray[0][2].setKey("CF");
	gridFieldArray[0][4].setKey("RF");
	gridFieldArray[2][1].setKey("SS");
	gridFieldArray[2][2].setKey("P");
	gridFieldArray[2][3].setKey("2B");
	gridFieldArray[3][0].setKey("3B");
	gridFieldArray[3][2].setKey("C");
	gridFieldArray[3][4].setKey("1B");
}

public void reset(){
	score = 0;
	outs = 0;
	home.removePlayerFromBase();
	one.removePlayerFromBase();
	two.removePlayerFromBase();
	three.removePlayerFromBase();
}

public void start(Team fieldingTeam){
	this.fieldingTeam = fieldingTeam;
	
	
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
public void addOuts() {
	outs = outs + 1;
}
public String toString(){
	return "base 1 " +one.toString() + "\n" + "base 2 " +two.toString() + "\n"
			+ "base 3 " +three.toString() + "\n";
}
}
