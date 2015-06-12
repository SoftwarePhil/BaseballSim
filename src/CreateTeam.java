
public class CreateTeam {

private Team home = new Team();
private Team away = new Team();

public Team[] createTeams(){
	Player p1 = new Player(.4f, "Bob");
	Player p2 = new Player(.3f, "Phil");
	Player p3 = new Player(.25f, "Mack");
	Player p4 = new Player(.32f, "Tango Tom");
	Player p5 = new Player(.41f, "Joe");
	Player p6 = new Player(.2f, "Billy");
	Player p7 = new Player(.36f, "John");
	Player p8 = new Player(.29f, "Josh");
	Pitcher pitcherA = new Pitcher(.1f, "pitcherA", 1);
	home.addPlayer(p1);
	home.addPlayer(p2);
	home.addPlayer(p3);
	home.addPlayer(p4);
	home.addPlayer(p5);
	home.addPlayer(p6);
	home.addPlayer(p7);
	home.addPlayer(p8);
	home.addPlayer(pitcherA);

	Player p1b = new Player(.4f, "Bob");
	Player p2b = new Player(.3f, "Phil");
	Player p3b = new Player(.25f, "Mack");
	Player p4b = new Player(.32f, "Tango Tom");
	Player p5b = new Player(.41f, "Joe");
	Player p6b = new Player(.2f, "Billy");
	Player p7b = new Player(.36f, "John");
	Player p8b = new Player(.29f, "Josh");
	Pitcher pitcherB = new Pitcher(.1f, "pitcherA", 1);
	away.addPlayer(p1b);
	away.addPlayer(p2b);
	away.addPlayer(p3b);
	away.addPlayer(p4b);
	away.addPlayer(p5b);
	away.addPlayer(p6b);
	away.addPlayer(p7b);
	away.addPlayer(p8b);
	away.addPlayer(pitcherB);
	
	Team[] teams = {home, away};
	
	return teams;
	
}


}
