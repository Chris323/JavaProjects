package divideAndConquer;

public class DivideAndConquer {
	static int powerMult(int x, int y) 
    { 
        if (y == 0) 
            return 1; 
        else if (y % 2 == 0) 
            return powerMult(x, y / 2) * powerMult(x, y / 2); 
        else
            return x * powerMult(x, y / 2) * powerMult(x, y / 2); 
    } 
}
