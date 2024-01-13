package LinkedList;

public class RemoveNthNodeFromLL {
    public class Node {
        public int data;
        public Node next;
        public Node prev;

        Node() {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = next;
        }
    }

    public static Node removeKthNode(Node head, int K) {
        Node fast = head;
        Node slow = head;
        for (int i = 0; i < K; i++) {
            fast = fast.next;
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node delNode = slow.next;
        slow.next = slow.next.next;
        return head;
    }
}
