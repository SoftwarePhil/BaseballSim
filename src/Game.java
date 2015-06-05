
public class Game {
	
public static void main(String[] args){

Team a = new Team();
Team b = new Team();

//Player and team creation needs to be handled by another class linked to database
Player p = new Player(.3f, "Bob");
Player p2 = new Player(.3f, "Bob2");
Pitcher p3 = new Pitcher(.3f, "pitcher", 1);
a.addPlayer(p);
a.addPlayer(p2);
b.addPlayer(p3);

Batting bat = new Batting();

//Every time a team switches from batting to fielding a new current batting needs
//to be made
CurrentBatting cb = new CurrentBatting(p3,p);

bat.startBatting(cb);
System.out.println(bat.atBat() + " final number of runs " + cb.getPlayer());

}
}
