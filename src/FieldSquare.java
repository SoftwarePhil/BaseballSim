
public class FieldSquare {
	
private boolean hasBall;
private String key;
private float[] playerSpace;
private Player fielder;

public FieldSquare(){
	setHasBall(false);
}

public FieldSquare(boolean ball, String position){
	setHasBall(ball);
	setKey(position);
}

public void setSize(int size){
	playerSpace = new float[size];
}

public boolean getHasBall() {
	return hasBall;
}

public void setHasBall(boolean hasBall) {
	this.hasBall = hasBall;
}

public String getKey() {
	return key;
}

public void setKey(String key) {
	this.key = key;
}

public Player getFielder() {
	return fielder;
}

public void setFielder(Player fielder) {
	this.fielder = fielder;
}

}
