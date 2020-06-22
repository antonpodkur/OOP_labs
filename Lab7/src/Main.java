import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String args[]){

        Candy present[] = new Candy[3];

        present[0] = new Lion(20, 30,3);
        present[1] = new Twix(30, 20, 2);
        present[2] = new Roshen(100, 99, true);

        System.out.println("First constructor");
        DoublyLinkedListImpl<Candy> test = new DoublyLinkedListImpl<Candy>();
        System.out.println("Is empty:" +test.isEmpty());
        test.addFirst(present[0]);
        test.addLast(present[1]);
        test.add(present[2]);
        test.iterateForward();
        test.remove(1);

        test.iterateForward();

        test.remove(present[0]);

        test.iterateForward();

        System.out.println();

        System.out.println("Second constructor");
        DoublyLinkedListImpl<Candy> test2 = new DoublyLinkedListImpl<Candy>(present[0]);
        test2.iterateForward();
        System.out.println(test2.contains(present[0]));
        System.out.println(test2.contains(present[1]));
        System.out.println();
        test2.add(present[2]);
        System.out.println(test2.get(0));


        System.out.println("Third constructor");
        DoublyLinkedListImpl<Candy> test3 = new DoublyLinkedListImpl<Candy>(present);
        test3.iterateForward();
        System.out.println();
        System.out.println("In array");
        Object[] test3_1 = test3.toArray();
        for(Object c : test3_1)
        {
            System.out.println(c);
        }
        test3.clear();
        test3.iterateForward();

        System.out.println();
        System.out.println("AddAll test");
        ArrayList<Candy> temp = new ArrayList<Candy>();
        temp.add(present[0]);
        temp.add(present[1]);
        temp.add(present[2]);
        DoublyLinkedListImpl<Candy> test4 = new DoublyLinkedListImpl<Candy>();
        test4.addAll(temp);
        System.out.println("Contains all: " + test4.containsAll(temp));
        test4.iterateForward();
        temp.remove(present[2]);
        ArrayList<Candy> temp2 = new ArrayList<Candy>();
        temp2.add(present[0]);
        temp2.add(present[1]);
        test4.removeAll(temp);
        test4.iterateForward();
        System.out.println("Contains all: " + test4.containsAll(temp2));

        System.out.println();
        System.out.println("Testing the iterator:");
        DoublyLinkedListImpl<Candy> test5 = new DoublyLinkedListImpl<Candy>(present);
        Iterator iterator = test5.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }
}