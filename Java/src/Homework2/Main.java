package Homework2;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        Node head = new Node(15);
        s.genList(head, 5);

        s.printList(head);

        head = s.reverseList(head);

        s.printList(head);

    }
}
