
public class FieldSquare {
	
	private boolean hasBall;
	private String key;
	private float[] playerSpace;
	
	public FieldSquare(){
		setHasBall(false);
	}
	
	public FieldSquare(boolean ball, int size, String position){
		setHasBall(ball);
		playerSpace = new float[size];
		setKey(position);
		
	}

	public boolean getHasBall() {
		return hasBall;
	}

	public void setHasBall(boolean hasBall) {
		this.hasBall = hasBall;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
