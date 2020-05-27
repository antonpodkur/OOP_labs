import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
public class Main {
	static Student group[] = new Student[3];
	public static void main(String args[]) {
		group[0] = new Student("Anton","Podkur",'m',18,"Ukraine");
		group[1] = new Student("Hans","Potatenko",'m',18,"Germany");
		group[2] = new Student("Bread","Pit",'m',16,"SAR");
		
		Arrays.sort(group,Comparator.comparing(Student::getname));
		for (Student s: group)
		{
			System.out.println(s.getname());
		}	
		System.out.println();
		Arrays.sort(group,Comparator.comparing(Student::getname).reversed());
		for (Student s: group)
		{
			System.out.println(s.getname());
		}	
	}
}
