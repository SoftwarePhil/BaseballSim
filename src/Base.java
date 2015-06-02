
public class Base {
private boolean isFull = false;
private Base nextBase;
private Player playerOnBase;

public void addPlayerToBase(Player p){
	playerOnBase = p;
	isFull = true;
}

public void movePlayerOneBase(Player p){
	playerOnBase = null;
	nextBase.addPlayerToBase(p);
}

public void removePlayerFromBase(){
	playerOnBase = null;
	isFull = false;
}

public Player getPlayerOnBase(){
	return playerOnBase;
}
//This is a test change
public boolean getIsFull(){
	return isFull;
}

public Base nextBase(){
	return nextBase;
}

public void setNextBase(Base b){
	nextBase = b;
}

}
