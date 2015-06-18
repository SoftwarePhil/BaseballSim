
public class Pitcher extends Player{ 	

private String name;
private int games;
private float zonePer;
private String pos;
private float fb;
private float sl;
private float ct;
private float cb;
private float ch;
private float sf;
private float kn;

private float fbV;
private float slV;
private float ctV;
private float cbV;
private float chV;
private float sfV;
private float knV;


//row["Name"].replace(" ", ""), float(row["G"]), "P", (float(row["Zone%"])), (float(row["FB%"])), (float(row["FBv"])), (float(row["SL%"])), (float(row["SLv"])), (float(row["CT%"])), (float(row["CTv"])), (float(row["CB%"])), (float(row["CBv"])), (float(row["CH%"])), (float(row["CHv"])), (float(row["SF%"])), (float(row["SFv"])), (float(row["KN%"])), (float(row["KNv"])))

public Pitcher(String[] playerData, String[] pitcherData) {
	super(playerData);
	setName(pitcherData[0]);
	setGames((Integer.parseInt(pitcherData[1])));
	pos = "P";
	zonePer = (Float.parseFloat(pitcherData[3]));
	fb = (Float.parseFloat(pitcherData[4]));
	fbV = (Float.parseFloat(pitcherData[5]));
	sl = (Float.parseFloat(pitcherData[6]));
	slV = (Float.parseFloat(pitcherData[7]));
	ct = (Float.parseFloat(pitcherData[8]));
	ctV = (Float.parseFloat(pitcherData[9]));
	cb = (Float.parseFloat(pitcherData[10]));
	cbV = (Float.parseFloat(pitcherData[11]));
	ch = (Float.parseFloat(pitcherData[12]));
	chV = (Float.parseFloat(pitcherData[13]));
	sf = (Float.parseFloat(pitcherData[14]));
	sfV = (Float.parseFloat(pitcherData[15]));
	kn = (Float.parseFloat(pitcherData[16]));
	knV = (Float.parseFloat(pitcherData[17]));
}

public float getZonePer() {
	return zonePer;
}

public float getFb() {
	return fb;
}

public float getSl() {
	return sl;
}

public float getCt() {
	return ct;
}

public float getCb() {
	return cb;
}

public float getCh() {
	return ch;
}

public float getSf() {
	return sf;
}

public float getKn() {
	return kn;
}

public float getFbV() {
	return fbV;
}

public float getSlV() {
	return slV;
}

public float getCtV() {
	return ctV;
}

public float getCbV() {
	return cbV;
}

public float getChV() {
	return chV;
}

public float getSfV() {
	return sfV;
}

public float getKnV() {
	return knV;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getGames() {
	return games;
}

public void setGames(int games) {
	this.games = games;
}

}
