
public class Game {
	
private CreateTeam ct;
public Team[] teams;
private Batting bat;
private CurrentField cf;
private Field f;

private int amountOfBasesToMove;
private Player currentBattingPlayer;

private int battingTeam;
private int pitchingTeam;
private boolean initOrder;

private int innings;
	
public Game(){
	ct = new CreateTeam();
	teams = ct.createTeams("Mets", "Yankees");
	bat = new Batting();
	cf = new CurrentField();
	f = new Field(cf);

	amountOfBasesToMove = 0;
	currentBattingPlayer = null;
	
	battingTeam = 0;
	pitchingTeam = 1;
	initOrder = true;
	
	innings = 1;
}

public void switchTeams(){
	if(initOrder == true){
		battingTeam = 1;
		pitchingTeam = 0;
		initOrder = false;
	}
	else{
		battingTeam = 0;
		pitchingTeam = 1;
		initOrder = true;
	}
}

public void teamAtBat(){
while(teams[battingTeam].getOuts() < 3){
	currentBattingPlayer = teams[battingTeam].getNextPlayerAtBat();
	CurrentBatting cb = new CurrentBatting(teams[pitchingTeam].getPitcher(), currentBattingPlayer );
	amountOfBasesToMove = bat.startBatting(cb);
	
	if(amountOfBasesToMove > 0 ){
		f.newPlayerOnBases(amountOfBasesToMove, currentBattingPlayer);
		}
	
	else{
		teams[battingTeam].addOneToOuts();
		System.out.println("OUT HAS HAPPENED");
			}
	}
	teams[battingTeam].addNumToScore(cf.getScore());
	teams[battingTeam].setOutsToZero();
	cf.reset();
}

public void inning(){
	teamAtBat();
	System.out.println("NEW TEAM AT BAT");
	System.out.println();
	switchTeams();
	teamAtBat();
	switchTeams();
	System.out.println("NEW TEAM AT BAT");
	System.out.println();
	innings++;
}

public void playGame(){
while(innings < 9){
	inning();
	System.out.println("score at end of inning " + innings + " is: " +"\n"
	+"Home Team: "+ teams[0].getScore() +"\n"+ "Away Team: "+ teams[1].getScore());
}
while(teams[0].getScore() == teams[1].getScore()){
	inning();
	System.out.println("score at end of inning " + innings + " is: " +"\n"
	+"Home Team: "+ teams[0].getScore() +"\n" + "Away Team: "+ teams[1].getScore());
}

}
}
