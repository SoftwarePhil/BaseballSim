
public class Game {
	
public static void main(String[] args){

Team a = new Team();
Team b = new Team();

//Player and team creation needs to be handled by another class linked to database
Player p = new Player(.4f, "Bob");
Player p2 = new Player(.3f, "Phil");
Pitcher p3 = new Pitcher(.3f, "pitcher", 1);
Player p4 = new Player(.25f, "Mack");
a.addPlayer(p);
a.addPlayer(p2);
b.addPlayer(p3);
a.addPlayer(p4);

Batting bat = new Batting();

//Every time a team switches from batting to fielding a new current batting needs
//to be made
CurrentBatting cb = new CurrentBatting(p3,p);
CurrentBatting cb1 = new CurrentBatting(p3,p2);
CurrentBatting cb2 = new CurrentBatting(p3,p4);

CurrentField cf = new CurrentField();
Field f = new Field(cf);

bat.startBatting(cb);
f.newPlayerOnBases(bat.atBat(), bat.getBatter());
System.out.println(cf);

bat.startBatting(cb1);
f.newPlayerOnBases(bat.atBat(), bat.getBatter());
System.out.println(cf);

bat.startBatting(cb2);
f.newPlayerOnBases(bat.atBat(), bat.getBatter());
System.out.println(cf);

System.out.println("the three batters scored " + cf.getScore());

}
}
