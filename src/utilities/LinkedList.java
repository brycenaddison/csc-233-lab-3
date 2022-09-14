package utilities;

import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Singly linked list class.
 * @author brycenaddison
 * @version Wed Sep 14 2022
 */
public class LinkedList<T> implements Iterable<T> {
    protected int _size;
    protected Node _head;
    protected Node _tail;

    private class Node {
        private final T value;
        private Node next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node selected;

        LinkedListIterator() {
            selected = _head;
        }

        @Override
        public boolean hasNext() {
            return selected.next != _tail;
        }

        @Override
        public T next() {
            selected = selected.next;
            return selected.value;
        }
    }

    public LinkedList() {
        this._tail = new Node(null, null);
        this._head = new Node(null, this._tail);
        this._size = 0;
    }

    public int size() {
        return this._size;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void clear() {
        this._size = 0;
        this._head.next = this._tail;
    }

    public boolean contains(Object o) {
        for (T obj : this) {
            if (obj.equals(o)) return true;
        }
        return false;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    public void addToFront(T element) {
        this._size++;
        Node temp = this._head.next;
        this._head.next = new Node(element, temp);
    }

    private Node previous(T target) {
        Node selected = this._head;
        while (selected.next != _tail) {
            if (selected.next.value.equals(target)) return selected;
            selected = selected.next;
        }
        return null;
    }

    public boolean remove(T target) {
        this._size--;
        Node prev = this.previous(target);
        if (prev == null) return false;
        prev.next = prev.next.next;
        return true;
    }

    private Node last() {
        Node selected = _head;
        while (selected.next != _tail) {
            selected = selected.next;
        }
        return selected;
    }

    public void addToBack(T element) {
        this._size++;
        this.last().next = new Node(element, _tail);
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(", ", "[", "]");
        this.forEach(item -> sj.add((item == null) ? "null" : item.toString()));
        return sj.toString();
    }

    private Node reverse(Node n) {
        if (n == _tail) return n;

        Node head = reverse(n.next);

        n.next.next = n;
        n.next = _tail;

        return head;
    }

    public void reverse() {
        _head = this.reverse(_head.next);
    }

    public T popFront() {
        T item = this._head.next.value;
        this.remove(this._head.next.value);
        return item;
    }
}