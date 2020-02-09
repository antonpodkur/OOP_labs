import java.util.Arrays;
import java.util.Collections;
import java.util.*;
public class Main {
	
	public static void main(String args[]) {
//		System.out.println(9220%3);
//		System.out.println(9220%17);
		String temp;
		
		String s = "This is a test sentence, you can change it if you want.";
		String arr[]= s.split(" ");
		int  alllist[] = new int[arr.length];
		
		for(int i = 0;i<arr.length;i++) {
			temp = arr[i];
			Word $temp = new Word(temp);
			alllist[i] = $temp.get_amount_of_loud_sounds();
		}
		int max=alllist[0];
		for(int i =0;i<alllist.length;i++) {
			if(alllist[i]>max) max = alllist[i];
		}
		for(int j = max;j>=1;j--) {
			for(int i =0;i<arr.length;i++) {
				temp = arr[i];
				Word $temp = new Word(temp);
				if($temp.get_amount_of_loud_sounds()==j) {
					System.out.println($temp.name + " has "+$temp.get_amount_of_loud_sounds()+" loud sounds.");
				}
			}
		}
}
}
