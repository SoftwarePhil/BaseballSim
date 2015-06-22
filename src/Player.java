
public class Player {
	
private String name = "";

private float chanceSingle = 0;
private float chanceDouble = 0;
private float chanceTriple = 0;
private float chanceHomerun = 0;

private float IPR = 0;
private int hits = 0;
private float oSwing = 0;
private float zSwing = 0;
private float oContact = 0;
private float zContact = 0;
private float FP = 0;
private String position = "";

public Player(String[] playerData){
	
	//batting_players.append(([row["Name"].replace(" ", ""), row["Position"], float(row["H"]), float(row["IPR"]), float(row["O-Swing%"]), float(row["Z-Swing%"]), float(row["O-Contact%"]), float(row["Z-Contact%"]), float(row["1B%"]), float(row["2B%"]), float(row["3B%"]), float(row["HR%"]), float(row["FP"])]))
	
	name = playerData[0];
	setPosition(playerData[1]);
	setHits(Integer.parseInt(playerData[2]));
	setIPR(Float.parseFloat(playerData[3]));
	setoSwing(Float.parseFloat(playerData[4]));
	setzSwing(Float.parseFloat(playerData[5]));
	setoContact(Float.parseFloat(playerData[6]));
	setzContact(Float.parseFloat(playerData[7]));
	setChanceSingle(Float.parseFloat(playerData[8]));
	setChanceDouble(Float.parseFloat(playerData[9]));
	setChanceTriple(Float.parseFloat(playerData[10]));
	setChanceHomerun(Float.parseFloat(playerData[11]));
	setFP(Float.parseFloat(playerData[12]));
}


public String toString(){
	return name + " O swing " + oSwing + "  ::  Ocontact " + oContact ;
}


public float getChanceSingle() {
	return chanceSingle;
}


public void setChanceSingle(float chanceSingle) {
	this.chanceSingle = chanceSingle;
}


public float getChanceDouble() {
	return chanceDouble;
}


public void setChanceDouble(float chanceDouble) {
	this.chanceDouble = chanceDouble;
}


public float getChanceTriple() {
	return chanceTriple;
}


public void setChanceTriple(float chanceTriple) {
	this.chanceTriple = chanceTriple;
}


public float getChanceHomerun() {
	return chanceHomerun;
}


public void setChanceHomerun(float chanceHomerun) {
	this.chanceHomerun = chanceHomerun;
}


public float getIPR() {
	return IPR;
}


public void setIPR(float iPR) {
	IPR = iPR;
}


public int getHits() {
	return hits;
}


public void setHits(int hits) {
	this.hits = hits;
}


public float getoSwing() {
	return oSwing;
}


public void setoSwing(float oSwing) {
	this.oSwing = oSwing;
}


public float getzSwing() {
	return zSwing;
}


public void setzSwing(float zSwing) {
	this.zSwing = zSwing;
}


public float getoContact() {
	return oContact;
}


public void setoContact(float oContact) {
	this.oContact = oContact;
}


public float getzContact() {
	return zContact;
}


public void setzContact(float zContact) {
	this.zContact = zContact;
}


public float getFP() {
	return FP;
}


public void setFP(float fP) {
	FP = fP;
}


public String getPosition() {
	return position;
}


public void setPosition(String position) {
	this.position = position;
}


}
