package Homework3;

public class DLList {
    Node start;
    Node end;

    public DLList() {
        start = null;
        end = null;
    }

    public void print() {
        Node temp = start;
        StringBuilder s = new StringBuilder();
        while (temp != null) {
            s.append(temp.value).append(" <=> ");
            temp = temp.next;
        }
        System.out.println(s.substring(0, s.length() - 5));

    }

    public void push_front(int value) {
        Node t = new Node(value);
        if (start == null) {
            start = t;
            end = t;
            return;
        }
        t.next = start;
        start.prev = t;
        start = t;
    }

    public void insert(Node v, int value) {
        Node t = new Node(value);
        Node next = v.next;
        if (next == null) {
            t.next = null;
            v.next = t;
            t.prev = v;
            end = t;
            return;
        }
        next.prev = t;
        t.next = next;
        v.next = t;
        t.prev = v;
    }

    public void push_back(int value) {
        if (end == null) {
            Node t = new Node(value);
            start = t;
            end = t;
            return;
        }
        insert(end, value);
    }

    public void delete(Node v) {
        Node prev = v.prev;
        Node next = v.next;
        if (prev != null) {
            prev.next = next;
        }
        if (next != null) {
            next.prev = prev;
        }
        v.next = null;
        v.prev = null;
        if (v == start) {
            start = next;
        }
        if (v == end) {
            end = prev;
        }
    }

    public void pop_front() {
        delete(start);
    }

    public void pop_back() {
        delete(end);
    }

    public void revert() {
        if (start == null) {
            return;
        }
        Node a = start;
        Node b = start.next;
        a.next = null;
        if (b == null) {
            return;
        }
        Node c = b.next;
        while (b != null) {
            b.next = a;
            a.prev = b;
            a = b;
            b = c;
            if (c != null) {
                c = c.next;
            }
        }
        a.prev = null;
        Node t = start;
        start = end;
        end = t;
    }

    public void genList(int count) {
        int a = 0;
        int b = 100;
        int value = 0;
        for (int i = 0; i < count; i++) {
            value = (int) (Math.random() * ((b - a) + 1)) + a;
            push_back(value);
        }
    }

}
