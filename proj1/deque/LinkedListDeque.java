package deque;

public class LinkedListDeque<T> {

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T i, Node p, Node n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    Node begin;
    Node end;
    int Size;

    public LinkedListDeque() {
        begin = end = null;
        Size = 0;
    }

    public void addFirst(T item) {
        Node node = new Node(item, null, begin);
        begin.prev = node;
        begin = node;
        ++Size;
    }

    public void addLast(T item) {
        Node node = new Node(item, end, null);
        end.next = node;
        end = node;
        ++Size;
    }

    public boolean isEmpty() {
        return Size == 0;
    }

    public int size() {
        return Size;
    }

    public void printDeque() {
        Node node = begin;
        while (node.next != null) {
            System.out.print(node.item);
            System.out.print(" ");
            node = node.next;
        }
    }

    public T removeFirst() {
        if (Size == 0) {
            return null;
        }
        T temp = begin.item;
        begin = begin.next;
        begin.prev = null;

        return temp;
    }

    public T removeLast() {
        if (Size == 0) {
            return null;
        }
        T temp = end.item;
        begin = begin.prev;
        end.next = null;

        return temp;
    }

    public T get(int index) {

    }

    public T getRecursive(int index) {

    }
}
