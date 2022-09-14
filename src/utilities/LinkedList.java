package utilities;

import java.util.Iterator;

//test test

public class LinkedList<T> implements Iterable<T> {
    protected int _size;
    protected Node _head;
    protected Node _tail;

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
        this._head.next = this._tail;
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
        Node temp = this._head.next;
        this._head.next = new Node(element, temp);
    }

    private Node previous(T target) {
        Node selected = this._head;
        while (selected.next != null && selected.next != _tail) {
            if (selected.next.value.equals(target)) return selected;
        }
        return null;
    }

    private boolean remove(T target) {
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
        this.last().next = new Node(element, _tail);
    }

    @Override
    public String toString() {
        return this.iterator().toString();
    }

    private Node reverse(Node n) {
        if (n == null) return n;
        if (n.next == null) return n;

        Node head = reverse(n.next);

        n.next.next = n;
        n.next = null;

        return head;
    }

    private void reverse() {
        this.reverse(_head);
    }
}