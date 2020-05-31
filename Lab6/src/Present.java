import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Present
{
    private Candy[] present;
    private float weight=0;

    public Present(Candy[] present)
    {
        this.present = present;
    }

    public void getWeight()
    {
            for(int i = 0; i<present.length; i++){
                weight += present[i].getWeight();
            }
            System.out.println("Presents weight: "+ weight);
            System.out.println();
    }

    public void SortByChocolate()
    {
        System.out.println("Before sorting: ");
        for(Candy candy: present){
            System.out.println(candy.getAmount_of_choc()+ " - "+ candy.getName());
        }

        System.out.println();

        System.out.println("After sorting: ");
        Arrays.sort(present, Comparator.comparing(Candy::getAmount_of_choc));
        for(Candy candy: present){
            System.out.println(candy.getAmount_of_choc()+ " - " + candy.getName());
        }

        System.out.println();    
    }

    public void SetRange()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Lets set the range of amount of chocolate :P");
        System.out.println("Enter the beginning of the range(min 0, max 100): ");
        int start = sc.nextInt();
        if((start<0) || (start >100)){
            System.out.println("out of range!");
            return;
        }
        System.out.println("Enter the ending of the range(min 0, max 100): ");
        int end = sc.nextInt();
        if((end<0) || (end >100)){
            System.out.println("out of range!");
            return;
        }

        for(Candy candy: present){
            if((candy.getAmount_of_choc()>=start) && (candy.getAmount_of_choc() <= end)){
                System.out.println(candy.getName()+" is for you)");
            }
        }
    }

}