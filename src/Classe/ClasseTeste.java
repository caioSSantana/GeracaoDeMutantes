package Classe;

public class ClasseTeste {

	public ClasseTeste() {
		super();
	}
	
	private Object teste(double x, double y){
		double i = 0,j = 0;
		i++;
		j--;
		if(x == 0 || y == 0)
			return null;
		if(x >= y)
			return (x/y) - (i-j);
		if(y > x)
			return (y/x) + (i-j);
		return null;
	}
	
}


