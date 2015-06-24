package baseballGamePackage;
import fieldingPackage.CurrentField;
import fieldingPackage.Field;
import battingPackage.Batting;
import battingPackage.CurrentBatting;
import teamPackage.CreateTeam;
import teamPackage.Team;


public class PlayBall {


public static void main(String[] args){
	
	Game g = new Game();
	g.playGame();

/*
	Team[] t = new Team[2];
	
	CreateTeam cr = new CreateTeam();
	

	
	t = cr.createTeams("Mets", "Yankees");
	
	t[0].configFieldingRoster();
	
	Batting b = new Batting();
	t[0].getNextPlayerAtBat();
	CurrentBatting cb = new CurrentBatting(t[1].getPitcher(), t[0].getNextPlayerAtBat());
	b.startBatting(cb);
	System.out.println(b);
*/
	/*
	Team[] t = new Team[2];
	CreateTeam cr = new CreateTeam();	
	t = cr.createTeams("Mets", "Yankees");
	
	CurrentField cf = new CurrentField();
	Field f = new Field(cf);
	
	cf.start(t[0]);
	*/
}

}
