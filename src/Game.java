
public class Game {
	
public static void main(String[] args){

Field f = new Field(); 
Team a = new Team();
Team b = new Team();

Player p = new Player(.3f, "Bob");
Player p2 = new Player(.3f, "Bob2");


a.addPlayer(p);
a.addPlayer(p2);

}
}
