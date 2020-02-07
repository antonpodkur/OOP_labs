import java.util.Random;
import java.util.Scanner;
public class Matrix {
	private int width = 0;
	private int length = 0;
	private int num=0;
	private byte[][] matrix;
	private byte a = 0;
	private byte sum = 0;
	private byte max  = 0;
	
	Matrix(int width ,int length)
	{
		this.width = width;
		this.length = length;
		matrix = new byte[width][length];
		Random r = new Random();
		for(int i=0;i<width;i++) 
		{
			for(int j=0;j<length;j++) 
			{
				num = r.nextInt(10);
				matrix[i][j]=(byte) num;
			}
		}
	}	
		void print_matrix() {
		for(int i=0;i<width;i++) {
			for(int j=0;j<length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.print("\n");
		}
	}
		
		void multiply_matrix(int a) {
			System.out.println("Enter number you want to multiply matrix on: ");
			Scanner s = new Scanner(System.in);
			a = s.nextInt();
			for(int i=0;i<width;i++) {
				for(int j=0;j<length;j++) {
					matrix[i][j]*=a;
				}
				System.out.print("\n");
			}
		}
		void sum_of_biggest() {
			for(int i=0;i<width;i++) {
				for(int j = 0;j<length;j++) {
					if(matrix[j][i]>max) max = matrix[j][i];
				}
				System.out.println("Max is : " + max);
				for(int j = 0;j<length;j++) {
					if(matrix[j][i]==max) sum+=max;
				}
				System.out.println("Sum of the biggest numbers in "+i+" column = "+sum);
				max =0;
				sum=0;
			}
		}
	}


