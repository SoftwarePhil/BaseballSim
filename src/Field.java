
public class Field {

private Base home = new Base();
private Base one = new Base();
private Base two = new Base();
private Base three = new Base();
private Base end = new Base();
private Player tempPlayer;

public Field(){
	home.setNextBase(one);
	one.setNextBase(two);
	two.setNextBase(three);
	three.setNextBase(end);
}

public void someoneIsRunning(int amountBases, Player p){
	switch (amountBases){
	case 1:{
		if(one.getPlayerOnBase() == null){
		one.addPlayerToBase(p);
		System.out.println(p + " is on first base!");
		}
		else {
		tempPlayer = one.getPlayerOnBase();
		one.movePlayerOneBase(tempPlayer);	
		System.out.println(tempPlayer + " is on second base!");
		one.addPlayerToBase(p);
		System.out.println(p + " is on first base!");
		}
	break;
	}
	
	default: {
		System.out.println("No players moved to a base");
	}
	}
}
}
