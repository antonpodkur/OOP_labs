import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.Arrays;

public class DoublyLinkedListImpl<E> implements List<E> {

    private Node head;
    private Node tail;
    private int size;


    public DoublyLinkedListImpl() {
        size = 0;
    }

    public DoublyLinkedListImpl(E value) {
        addLast(value);
    }

    public DoublyLinkedListImpl(E[] arr) {
        for (E value : arr) {
            addFirst(value);
        }
    }

    private class Node {
        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        Node tmp = new Node(element, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void addLast(E element) {

        Node tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("adding: " + element);
    }

    public void iterateForward() {

        System.out.println("iterating forward..");
        Node tmp = head;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public void iterateBackward() {
        System.out.println("iterating backward..");
        Node tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }
    }


    public E removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = head;
        head = head.next;
        head.prev = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }


    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("deleted: " + tmp.element);
        return tmp.element;
    }

    @Override
    public boolean contains(Object o) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.element.equals(o)) {
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node tmp = head;

            @Override
            public boolean hasNext() {
                return tmp != null;
            }

            @Override
            public E next() {
                if (tmp.element == null) {
                    throw new NoSuchElementException();
                } else {
                    E temp = tmp.element;
                    tmp = tmp.next;
                    return temp;
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            i++;
            tmp = tmp.next;
        }
        Object[] ans = new Object[i];
        i = 0;
        tmp = head;
        while (tmp != null) {
            ans[i] = tmp.element;
            tmp = tmp.next;
            i++;
        }
        return ans;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a == null){
            throw new NullPointerException();
        }

        if (!a.getClass().getComponentType().isAssignableFrom(head.element.getClass())){
            throw new ArrayStoreException();
        }

        if (a.length >= size){
            int count = 0;
            for (E e: this) {
                a[count] = (T) e;
                count++;
            }
        }else{
            a = (T[]) Array.newInstance(a.getClass().getComponentType(),size);
            System.out.println(a.getClass().getSimpleName());
            int count = 0;
            for (E e: this) {
                a[count] = (T) e;
                count++;
            }

        }

        return a;
    }

    @Override
    public boolean add(E element) {
        Node tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("adding: " + element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
//        Node tmp = head;
//        while (tmp != null) {
//            if(tmp==o)
//            {
//                if(tmp == head)
//                {
//                    removeFirst();
//                    return  true;
//                }
//                else if (tmp == tail)
//                {
//                    removeLast();
//                    return true;
//                }
//                else
//                {
//                    Node x = tmp.prev;
//                    Node y = tmp.next;
//                    x.next=y;
//                    y.prev =x;
//                    return true;
//                }
//            }
//            tmp = tmp.next;
//        }
//        return false;
        Node tmp = head;
        Node tmp2 = head;

        int i = 0;
        int index;
        index = 0;
        while (tmp != null) {
            if (tmp == o) {
                index = i;
            }
            tmp = tmp.next;
            i++;
        }

        i = 0;
        tmp = head;
        tmp2 = head;

        while (tmp != null) {
            if (i == index) {
                if (tmp == head) {
                    removeFirst();
                    return true;
                } else if (tmp == tail) {
                    tmp2 = tail;
                    removeLast();
                    return true;
                } else {
                    Node x = tmp.prev;
                    Node y = tmp.next;
                    x.next = y;
                    y.prev = x;
                    return true;
                }
            }
            tmp = tmp.next;
            i++;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] new_c = c.toArray();
        boolean tmp = false;

        for (Object p : new_c) {
            if (!contains(p)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean isChanged = false;
        Object[] new_arr = c.toArray();
        for (E p : c) {
            isChanged = add((E) p);
        }
        return isChanged;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
//        Object[] new_arr = c.toArray();
//        for (int i = index; i < new_arr.length; i++) {
//            add((E) new_arr[i]);
//        }
//        return true;
        for(E e: c)
        {
            add(index, e);
            index++;
        }
        return true;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        Objects.requireNonNull(operator);
        Node tmp = head;
        while (tmp != null) {
            tmp.element = operator.apply((E) tmp.element);
            tmp = tmp.next;
        }

//    final int expectedModCount = modCount;
//    final int size = this.size;
//    for (int i=0; modCount == expectedModCount && i < size; i++) {
//        elementData[i] = operator.apply((E) elementData[i]);
//    }
//    if (modCount != expectedModCount) {
//        throw new ConcurrentModificationException();
//    }
//    modCount++;
    }

    public void replacingAll(Object o) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.element == o) {
                if (tmp == head) {
                    removeFirst();
                } else if (tmp == tail) {
                    removeLast();
                } else {
                    Node x = tmp.prev;
                    Node y = tmp.next;
                    x.next = y;
                    y.prev = x;
                }
            }
            tmp = tmp.next;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] new_arr = c.toArray();
        for (Object p : new_arr) {
            replacingAll(p);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        Object[] new_arr = c.toArray();
        for (Object p : new_arr) {
            if (!contains(p))
                replacingAll(p);
        }
        return true;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Object[] a = toArray();
//        Arrays.sort(((T[])a),0,a.length-1,c);
//        Arrays.sort(((a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    public Spliterator<E> spliterator() {
        Object[] elements = toArray();
        return new MySpliterator<>(elements, 0, elements.length);
    }

    static class MySpliterator<E> implements Spliterator<E> {
        private final Object[] array;
        private int origin; // current index, advanced on split or traversal
        private final int fence; // one past the greatest index

        MySpliterator(Object[] array, int origin, int fence) {
            this.array = array;
            this.origin = origin;
            this.fence = fence;
        }

        public void forEachRemaining(Consumer<? super E> action) {
            for (; origin < fence; origin += 2)
                action.accept((E) array[origin]);
        }

        public boolean tryAdvance(Consumer<? super E> action) {
            if (origin < fence) {
                action.accept((E) array[origin]);
                origin += 2;
                return true;
            } else // cannot advance
                return false;
        }

        public Spliterator<E> trySplit() {
            int lo = origin; // divide range in half
            int mid = ((lo + fence) >>> 1) & ~1; // force midpoint to be even
            if (lo < mid) { // split out left half
                origin = mid; // reset this Spliterator's origin
                return new MySpliterator<>(array, lo, mid);
            } else       // too small to split
                return null;
        }

        public long estimateSize() {
            return (long) ((fence - origin) / 2);
        }

        public int characteristics() {
            return ORDERED | SIZED | IMMUTABLE | SUBSIZED;
        }
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                return tmp.element;
            }
            tmp = tmp.next;
            i++;
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                tmp.element = element;
            }
            tmp = tmp.next;
            i++;
        }
        return null;
    }

    @Override
    public void add(int index, E element) {
        Node tmp = head;
        Node new_node = new Node(element, null, null);
        new_node.element = element;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                if (tmp == head) {
                    addFirst(element);
                } else if (tmp == tail) {
                    addLast(element);
                } else {
                    Node x = tmp.next;
                    x.prev = new_node;
                    tmp.next = new_node;
                }
            }
            tmp = tmp.next;
            i++;
        }
    }

    @Override
    public E remove(int index) {
        Node tmp = head;
        Node tmp2 = head;
        int i = 0;
        while (tmp != null) {
            if (i == index) {
                if (tmp == head) {
                    removeFirst();
                    return tmp2.element;
                } else if (tmp == tail) {
                    tmp2 = tail;
                    removeLast();
                    return tmp2.element;
                } else {
                    Node x = tmp.prev;
                    Node y = tmp.next;
                    x.next = y;
                    y.prev = x;
                    return tmp.element;
                }
            }
            tmp = tmp.next;
            i++;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node tmp = head;
        int i = 0;
        while (tmp != null) {
            if (tmp.element == o) {
                return i;
            }
            tmp = tmp.next;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node tmp = head;
        int i = 0;
        int res = -1;
        while (tmp != null) {
            if (tmp.element == o) {
                res = i;
            }
            tmp = tmp.next;
            i++;
        }
        return res;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {

            private Node tmp = head;
            private int index = -1;
            private int tmp_index;

            @Override
            public boolean hasNext() {
                return tmp != null;
            }

            @Override
            public E next() {
                if (tmp.element == null) {
                    throw new NoSuchElementException();
                } else {
                    E temp = tmp.element;
                    tmp = tmp.next;
                    index++;
                    return temp;
                }
            }

            @Override
            public boolean hasPrevious() {
                return tmp.prev != null;
            }

            @Override
            public E previous() {
                if (tmp.prev == null) throw new NoSuchElementException();
                else {
                    tmp = tmp.prev;
                    index--;
                    return tmp.element;
                }
            }

            @Override
            public int nextIndex() {
                tmp_index = index + 1;
                return tmp_index;
            }

            @Override
            public int previousIndex() {
                tmp_index = index - 1;
                return tmp_index;
            }

            @Override
            public void remove() {
                Node x = tmp.next;
                Node y = tmp.prev;

                x.prev = y;
                y.next = x;

            }

            @Override
            public void set(E e) {
                tmp.element = e;
            }

            @Override
            public void add(E e) {
                Node x = new Node(e, tmp, tmp.next);
            }
        };
    }

    class MyListIterator implements ListIterator<E> {

        private Node tmp;
        private int this_index;
        private int tmp_index;
        int i = 0;

        public MyListIterator(int index) {
            Node temp_node = head;
            while (i <= index) {
                temp_node = temp_node.next;
                i++;
            }
            this.tmp = temp_node;
            this_index = index - 1;
        }

        @Override
        public boolean hasNext() {
            return tmp != null;
        }

        @Override
        public E next() {
            if (tmp.element == null) {
                throw new NoSuchElementException();
            } else {
                E temp = tmp.element;
                tmp = tmp.next;
                this_index++;
                return temp;
            }
        }

        @Override
        public boolean hasPrevious() {
            return tmp.prev != null;
        }

        @Override
        public E previous() {
            if (tmp.prev == null) throw new NoSuchElementException();
            else {
                tmp = tmp.prev;
                this_index--;
                return tmp.element;
            }
        }

        @Override
        public int nextIndex() {
            tmp_index = this_index + 1;
            return tmp_index;
        }

        @Override
        public int previousIndex() {
            tmp_index = this_index - 1;
            return tmp_index;
        }

        @Override
        public void remove() {
            if (tmp.next == null || tmp.prev == null) throw new NoSuchElementException();
            else {
                Node x = tmp.next;
                Node y = tmp.prev;

                x.prev = y;
                y.next = x;
            }
        }

        @Override
        public void set(E e) {
            tmp.element = e;
        }

        @Override
        public void add(E e) {
            Node x = new Node(e, tmp, tmp.next);
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyListIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        DoublyLinkedListImpl<E> inner = new DoublyLinkedListImpl<E>();

        Node tmp = tail;
        int i = 0;
        while (tmp != null) {
            if ((i >= fromIndex) && (i <= toIndex)) {
                inner.addLast(tmp.element);
            }
            tmp = tmp.prev;
            i++;
        }
        return inner;
    }
}