
public class Polynomial {
	double arr [];
	
	public Polynomial() {
		arr[0] = 0;
	}
	
	public Polynomial(double []a) {
		for(int i=0;i<a.length;i++) {
			arr[i] = a[i];
		}
	}
	
	public Polynomial add(Polynomial other) {
		
		for(int i=0;i<other.arr.length;i++) {
			other.arr[i] = other.arr[i] + arr[i];
		}
		return other;
	}
	
	public double evaluate(double a) {
		double temp = 0;
		double ret = 0;
		for(int i=0;i<arr.length;i++) {
			ret = arr[i]*Math.pow(a, temp);
			temp++;
		}	
		return ret;
	}
	
	public boolean hasRoot(double a) {
		if(evaluate(a) == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
