import java.util.Scanner;
public class Lab1 {
	public static void main(String args[]){
		Scanner myobj = new Scanner(System.in);
 		double S = 0;
 		double temp = 0;
  		short C=1;
  		System.out.println("Enter a: ");
 		short a=myobj.nextShort();
  		System.out.println("Enter b: ");
 		short b=myobj.nextShort();
  		System.out.println("Enter n: ");
 		short n=myobj.nextShort();
  		System.out.println("Enter m: ");
 		short m=myobj.nextShort();
 		if((a <= -C)&&(n>=-C)){
				System.out.println("Zero division error!");
				return;
 		}
 		if(a<=n && b<=m) {
 			for(short i=a;i<=n;i++){
 					for(short j = b;j<=m;j++){
 						temp = ((double)i*j)/(i+C);
 						System.out.println("I = "+ i);
 						System.out.println("J = "+ j);
 						System.out.println("S = "+ S);
 						S = S + temp; 
 						System.out.println("temp = "+ temp);
 					}
 				}	
 			System.out.println("S = "+ S);
 		}
 		else System.out.println("Out of limit!");
 	}
}
