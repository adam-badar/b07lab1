import java.io.File;
import java.io.FileNotFoundException;

//package geometry;

public class Driver { 
	 public static void main(String [] args) throws FileNotFoundException { 
	  //Polynomial p = new Polynomial(); 
	  //System.out.println(p.evaluate(3)); 
	  double [] c1 = {2,-2, -2, 2};
	  int [] e1 = {3, 2, 1, 0};  
	  Polynomial p1 = new Polynomial(c1, e1); 
	  double [] c2 = {-1, 1, 1, -1};
	  int [] e2 = {3, 2, 1, 0};  
	  Polynomial p2 = new Polynomial(c2, e2); 
	  Polynomial s = p1.add(p2); 
	  System.out.println("s(-1) = " + s.evaluate(1)); 
	  if(s.hasRoot(1)) 
		  System.out.println("1 is a root of s"); 
	   else 
		  System.out.println("1 is not a root of s");
	  double [] c3 = {1, -2, 1};
	  int [] e3 = {2, 1,0};
 	  Polynomial p3 = new Polynomial(c3, e3);
 	 double c4[] = {-1,-1234,-453,56,34,90};
     int e4[] = {0,1,8,2,3,2};
     Polynomial n = new Polynomial(c4,e4);
     Polynomial k = p3.multiply(p2);
//     File file = new File("C:\\Users\\badar\\OneDrive\\Desktop\\Java\\geometry\\random.txt");
//     Polynomial f = new Polynomial(file);
//     System.out.println("*******************");
//     for(int i=0; i<f.coeff.length;i++)
//     {
//         System.out.println(f.coeff[i]+"\t"+f.expo[i]);
//         //System.out.println(f.ex[i]);
//     }
//     f.saveToFile("do.txt");
  
     n.saveToFile("test.txt");
	 } 
	} 
