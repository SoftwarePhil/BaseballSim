
public class Ball {

private int pos1 = 0;
private int pos2 = 0;

private int[] ballPostion = {pos1, pos2};

public void setPostion(int x, int y){
	ballPostion[0] = x;
	ballPostion[1] = y;
}

public int[] getPostion(){
	return ballPostion;
}

}
