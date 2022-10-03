//package geometry;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Collection;
public class Polynomial {
	double coeff [];
	int expo [];
	
	public Polynomial() {
		coeff = new double[1];
		this.coeff[0] = 0;
		expo = new int[1];
		this.expo[0] = 0;
	}
	
	public Polynomial(double []a, int []b) {
		coeff = new double[a.length];
		expo = new int[b.length];
		for(int i=0;i<a.length;i++) {
			this.coeff[i] = a[i];
			this.expo[i] = b[i];
		}
	}
	
	public Polynomial(File file) throws FileNotFoundException {
		
		Scanner line = new Scanner(file);
		String ok = line.nextLine();
		int len = 1;
		for(int i = 0; i < ok.length(); i++) {//gets the number of terms of the polynomial
			if(ok.charAt(i) == '-' || ok.charAt(i) == '+') 
				len++;
		}
		coeff = new double[len];
		expo = new int[len];
		
		int temp1 = 0;
		int temp2 = 0;
		for(int i = 0; i < ok.length(); i++) {
			//check the first character
			while(i+1 < ok.length() && (ok.charAt(i+1) != '+' || ok.charAt(i+1) != '-' || ok.charAt(i) != 'x')) {
				String no = "";
				if(ok.charAt(0) == '-') {
					no = no + "-";
				}
				for(int j = i+1; j != 'x'; j++) {
					no = no + ok.charAt(j);
				}
				coeff[temp1] = Double.parseDouble(no);
				temp1++;
			}
			if(ok.charAt(i) == '+' || ok.charAt(i) == '-') {//seperate the terms
				String tem = "";
				if(ok.charAt(i) == '-') {
					tem = tem + "-";
				}
				for(int j = i+1; j != 'x'; j++) {//get the coeff
					tem = tem + ok.charAt(j);
				}
				coeff[temp1] = Double.parseDouble(tem);
				temp1++;
			}
			if(ok.charAt(i) == 'x') {//get the exponents
				String tem = "";
				for(int j = i+1; j != '+' || j != '-' || j != ok.length(); j++) {
					tem = tem + ok.charAt(j);
				}
				expo[temp2] = Integer.parseInt(tem);
				temp2++;
			}
		}
		line.close();
	}
	
	public void saveToFile(String filename) throws FileNotFoundException {
		
		String string = "";
		for(int i = 0; i < coeff.length; i++) {
			string = string + String.valueOf(coeff[i]);//add the coeffs
			
			if(expo[i] != 0) {
				string = string + 'x';//add the varaible if nonzero expo
				string = string + String.valueOf(expo[i]);//add the expo
			}
			if(i+1 < coeff.length && coeff[i+1] > 0) {
				string = string + '+';//add the plus sign if positive
			}
		}
		System.out.println(string);
		
		PrintStream aight = new PrintStream(filename);
		aight.println(string);
		aight.close();
	}
	
	public Polynomial add(Polynomial other) {
		HashMap<Integer, Double> lst = new HashMap<Integer, Double>();
		for (int index = 0; index < expo.length; index++) {//add the existing arguments into a hashmap
			lst.put(expo[index], coeff[index]);
		}
		for (int i = 0; i < other.expo.length; i++) {
			if (!lst.containsKey(other.expo[i])) {//if hashmap does not contain the key, add new pair
				lst.put(other.expo[i], other.coeff[i]);
			}
			else{
				Double doubl = lst.get(other.expo[i]) + other.coeff[i];//update the values for the key
				lst.replace(other.expo[i], doubl);
			}
		}
		Collection<Double> coeff2 = lst.values();
		Object[] a = coeff2.toArray();
		double [] d = new double [a.length];
		for (int i = 0; i < a.length; i++) {//convert hashmap values (coeff) to array
			d[i] = (Double)a[i];
		}
		Collection<Integer> expo2 = lst.keySet();
		a = expo2.toArray();
		int [] b = new int [a.length];
		for (int i = 0; i < a.length; i++) {//convert hashmap keys (exponents) to array
			b[i] = (Integer)a[i];
		}
		return new Polynomial(d, b);
	}
	
	public double evaluate(double a) {
		double ret = 0;
		for(int i=0;i<coeff.length;i++) {
			ret = coeff[i]*Math.pow(a, expo[i]) + ret;	
		}	
		return ret;
	}
	
	public boolean hasRoot(double a) {
		if(evaluate(a) == 0) 
			return true;
		return false;
	}
	
	public Polynomial multiply(Polynomial other) {
		HashMap<Integer, Double> lst = new HashMap<Integer, Double>();
		//multiplies the exponents while adding the coeffs
		for (int i = 0; i < other.expo.length; i++) { 
			//iterate through each expo in other
			for(int j = 0; j < expo.length; j++) {
				//iterate through each expo in the hashmap
				int k = other.expo[i] + expo[j];//add the exponents together
				double val = other.coeff[i] * coeff[j];
				
				if(!lst.containsKey(k)) { //if the map doesn't contain the expo, insert it
					lst.put(k, val);//add the new expo, multiply the coeffs
				}
				else {//if the expo alraedy exists, update the previous one by adding the new one
					Double d = val + lst.get(k);
					lst.replace(k, d);
				}
			}
		}
		Collection<Double> coeff2 = lst.values();
		Object[] a = coeff2.toArray();
		double [] d = new double [a.length];
		for (int i = 0; i < a.length; i++) {
			d[i] = (Double)a[i];
		}
		Collection<Integer> expo2 = lst.keySet();
		a = expo2.toArray();
		int [] b = new int [a.length];
		for (int i = 0; i < a.length; i++) {
			b[i] = (Integer)a[i];
		}
		return new Polynomial(d, b);
	}
}
