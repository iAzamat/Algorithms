package Homework2;

public class Solution {

    /**
     * Метод разворота односвязного списка
     *
     * @param head
     * @return
     */
    public Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * Метод печати списка
     *
     * @param node
     */
    public void printList(Node node) {
        StringBuilder s = new StringBuilder();
        while (node != null) {
            s.append(node.value + " => ");
            node = node.next;
        }
        System.out.println(s.substring(0, s.length() - 4));
    }

    /**
     * Метод добавления Node в список
     *
     * @param head
     * @param node
     * @return
     */
    public Node addNode(Node head, Node node) {
        return head.next = node;
    }

    /**
     * Метод генерации Node
     *
     * @param node  передается Node
     * @param count указывается количество Node, которые нужно сгенерировать
     */
    public void genList(Node node, int count) {
        int a = 0;
        int b = 100;
        int x = 0;
        Node tempNode = new Node(0);

        for (int i = 0; i < count; i++) {
            x = (int) (Math.random() * ((b - a) + 1)) + a;
            if (i == 0) {
                tempNode = addNode(node, new Node(x));
            } else {
                tempNode = addNode(tempNode, new Node(x));
            }
        }
    }
}
