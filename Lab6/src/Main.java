import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        //System.out.println(9218%13);


        Candy present_arr[] = new Candy[3];
        present_arr[0] = new Lion(20, 30,3);
        present_arr[1] = new Twix(30, 20, 2);
        present_arr[2] = new Roshen(100, 99, true);

        Present present = new Present(present_arr);

        present.getWeight();
        present.SortByChocolate();
        present.SetRange();


        // float weight_of_present=0;
        // for(int i = 0; i<present.length; i++){
        //     weight_of_present += present[i].getWeight();
        // }
        // System.out.println("Presents weight: "+ weight_of_present);
        // System.out.println();


        // System.out.println("Before sorting: ");
        // for(Candy candy: present){
        //     System.out.println(candy.getAmount_of_choc()+ " - "+ candy.getName());
        // }

        // System.out.println();

        // System.out.println("After sorting: ");
        // Arrays.sort(present, Comparator.comparing(Candy::getAmount_of_choc));
        // for(Candy candy: present){
        //     System.out.println(candy.getAmount_of_choc()+ " - " + candy.getName());
        // }

        // System.out.println();

        // System.out.println("Lets set the range of amount of chocolate :P");
        // System.out.println("Enter the beginning of the range(min 0, max 100): ");
        // int start = sc.nextInt();
        // if((start<0) || (start >100)){
        //     System.out.println("out of range!");
        //     return;
        // }
        // System.out.println("Enter the ending of the range(min 0, max 100): ");
        // int end = sc.nextInt();
        // if((end<0) || (end >100)){
        //     System.out.println("out of range!");
        //     return;
        // }

        // for(Candy candy: present){
        //     if((candy.getAmount_of_choc()>=start) && (candy.getAmount_of_choc() <= end)){
        //         System.out.println(candy.getName()+" is for you)");
        //     }
        // }

    }
}
