
public class Field {

private Player[] playersOnBase;

private Base home = new Base();
private Base one = new Base();
private Base two = new Base();
private Base three = new Base();

public Field(){
	home.setNextBase(one);
	one.setNextBase(two);
	two.setNextBase(three);
	three.setNextBase(home);
}
}
