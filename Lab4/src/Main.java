import java.util.Arrays;
import java.util.Collections;
public class Main {
	static Student group[] = new Student[3];
	static String arraystr[] = new String[group.length];
	
	static void sortname(Student arr[]) {
		for(int i = 0;i<arr.length;i++) {
			arraystr[i] = arr[i].getname();
		}
		Arrays.sort(arraystr);
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arraystr[i]);
		}
		
	}
	
	static void sortname_reverse(Student arr[]) {
		for(int i = 0;i<arr.length;i++) {
			arraystr[i] = arr[i].getname();
		}
		Arrays.sort(arraystr,Collections.reverseOrder());
		for(int i = 0;i<arr.length;i++) {
			System.out.println(arraystr[i]);
		}
	}
	
	public static void main(String args[]) {
		group[0] = new Student("Anton","Podkur",'m',18,"Ukraine");
		group[1] = new Student("Hans","Potatenko",'m',18,"Germany");
		group[2] = new Student("Bread","Pit",'m',16,"SAR");
		
		sortname(group);
		System.out.println();
		sortname_reverse(group);
	}
}
