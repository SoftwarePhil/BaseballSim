package baseballGamePackage;



public class PlayBall {


public static void main(String[] args){
	
	Game g = new Game("Phillies", "Yankees");
	g.playGame();
	
	/*
	int[] avg = new int[2];
	
	int amountOfGames = 1000;
	
	
	for(int x = 0; x < amountOfGames - 1; x++){
		Game b = new Game("Red_Sox", "Yankees");
		b.playGame();
		avg[0] = avg[0] + b.playGame()[0];
		avg[1] = avg[1] + b.playGame()[1];
		
		System.out.println("\n" +amountOfGames + " game average is\n Home team : "
		+ ((double)(avg[0])/amountOfGames)
		+ "\n average of Away team : " + ((double)avg[1])/amountOfGames);
	}
	*/

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
