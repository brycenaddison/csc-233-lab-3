import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinkedList<T> implements Iterable<T> {
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        private T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node selected;

        LinkedListIterator() {
            selected = head;
        }

        @Override
        public boolean hasNext() {
            return selected.next != tail;
        }

        @Override
        public T next() {
            selected = selected.next;
            return selected.value;
        }
    }

    public LinkedList() {
        this.tail = new Node(null, null);
        this.head = new Node(null, this.tail);
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        this.head.next = this.tail;
    }

    public boolean contains(Object o) {
        for (T obj: this) {
            if (obj.equals(o)) return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public void addToFront(T element) {
        Node temp = this.head.next;
        this.head.next = new Node(element, temp);
    }

    private Node previous(T target) {

    }

}
