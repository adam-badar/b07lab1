public class Polynomial {
	double arr [];
	
	public Polynomial() {
		arr = new double[1];
		this.arr[0] = 0;
	}
	
	public Polynomial(double []a) {
		arr = new double[a.length];
		for(int i=0;i<a.length;i++) {
			this.arr[i] = a[i];
		}
	}
	
	public Polynomial add(Polynomial other) {
		int len = Math.min(this.arr.length, other.arr.length);
		int len2 = Math.max(this.arr.length, other.arr.length);
		double []naya = new double[len2];
		Polynomial temp = new Polynomial(naya);
		for(int i=0;i<len;i++) {
			temp.arr[i] = other.arr[i] + this.arr[i];
		}
		if(other.arr.length > this.arr.length) {
			for(int i=len;i < len2;i++) {
				temp.arr[i] = temp.arr[i] + other.arr[i];
			}
		}
		else if (other.arr.length < this.arr.length) {
			for(int i=len;i < len2;i++) {
				temp.arr[i] = temp.arr[i] + this.arr[i];
			}
		}

		return temp;
	}
	
	public double evaluate(double a) {
		double ret = 0;
		for(int i=0;i<this.arr.length;i++) {
			ret = this.arr[i]*Math.pow(a, i) + ret;	
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
