
public class Lab2 {
	public static void main(String args[]) {
//		System.out.println(9220%5);
//		System.out.println(9220%7);
//		System.out.println(9220%11);
		
		Matrix mymat = new Matrix(3,3);
	
		mymat.print_matrix();
		mymat.multiply_matrix(2);
		mymat.print_matrix();
		mymat.sum_of_biggest();

	}
}
