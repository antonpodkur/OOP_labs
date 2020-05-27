public class Main {
    public static void main(String args[]){

        Candy present[] = new Candy[3];

        present[0] = new Lion(20, 30,3);
        present[1] = new Twix(30, 20, 2);
        present[2] = new Roshen(100, 99, true);

        System.out.println("First constructor");
        DoublyLinkedListImpl<Candy> test = new DoublyLinkedListImpl<Candy>();
        test.addFirst(present[0]);
        test.addLast(present[1]);
        test.iterateForward();
        test.removeLast();
        test.iterateBackward();
        System.out.println();

        System.out.println("Second constructor");
        DoublyLinkedListImpl<Candy> test2 = new DoublyLinkedListImpl<Candy>(present[0]);
        test2.iterateForward();
        System.out.println();

        System.out.println("Third constructor");
        DoublyLinkedListImpl<Candy> test3 = new DoublyLinkedListImpl<Candy>(present);
        test3.iterateForward();
    }
}