
public class PlayBall {

public static void main(String[] args){
	
//	Game g = new Game();
//	g.playGame();
//	
//	
	Team[] t = new Team[2];
	
	CreateTeam cr = new CreateTeam();
	
	t = cr.createTeams("Mets", "Yankees");
	
	System.out.println(t[0].getPlayer(0) +" " + t[0].getPlayer(9));
	
	Batting b = new Batting();
	t[0].getNextPlayerAtBat();
	CurrentBatting cb = new CurrentBatting(t[1].getPitcher(), t[0].getNextPlayerAtBat());
	b.startBatting(cb);
	System.out.println(b);
	
}

}
