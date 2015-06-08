
public class CurrentField {

private int score = 0;
private int outs = 0;

protected Base home = new Base();
protected Base one = new Base();
protected Base two = new Base();
protected Base three = new Base();

public CurrentField(){
	one.setNextBase(two);
	two.setNextBase(three);
	three.setNextBase(home);
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
