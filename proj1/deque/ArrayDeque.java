package deque;

public class ArrayDeque<Glorp> {

    private Glorp[] items;
    private int begin, end;
    private int sum, len;

    //THINGS TO DO
    public ArrayDeque() {
        items = (Glorp []) new Object[8];
        sum = 8;
        len = 0;
        begin = 7;
        end = 0;
    }

    private void changeSize() {
        int length;
        double rate = (double) sum / len;

        if (rate < 0.25) {
            length = sum * 2;
        } else if (len == sum) {
            length = len * 2;
        } else {
            return;
        }

        Glorp[] a = (Glorp []) new Object[length];
        System.arraycopy(items, 0, a, 0, sum);
        items = a;
        len = length;
    }
    private int nextP(int dir, int pos) {
        return (pos + dir + sum) % sum;
    }


    public void addFirst(Glorp item) {
        if (sum == len) {
            changeSize();
        }

        begin = nextP(-1, begin);
        items[begin] = item;
        ++sum;
    }

    public void addLast(Glorp item) {
        if (sum == len) {
            changeSize();
        }

        end = nextP(1, end);
        items[end] = item;
        ++sum;
    }


    public boolean isEmpty() {
        return sum == 0;
    }

    public int size() {
        return sum;
    }

    public void printDeque() {
        int temp = begin;
        while (temp != end) {
            System.out.print(items[temp] + " ");
            temp = nextP(temp, end);
        }
        System.out.println(items[end] + " ");
    }

    public Glorp removeFirst() {
        if (sum == 0) {
            return null;
        }

        Glorp p = items[begin];
        items[begin] = null;
        begin = nextP(1, begin);
        return p;
    }

    public Glorp removeLast() {
        if (sum == 0) {
            return null;
        }

        Glorp p = items[end];
        items[end] = null;
        end = nextP(-1, end);
        return p;
    }

    public Glorp get(int index) {
        return items[(index + begin) % len];
    }
/*
    public Iterator<T> iterator() {}
    public boolean equals(Object o) {}

*/

}
