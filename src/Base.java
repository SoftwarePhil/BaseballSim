
public class Base {
private boolean isFull = false;
private Base nextBase;
private Player playerOnBase;

public void addPlayerToBase(Player p){
	playerOnBase = p;
	isFull = true;
}

public void removePlayerFromBase(){
	playerOnBase = null;
	isFull = false;
}

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
