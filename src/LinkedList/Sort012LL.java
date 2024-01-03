package LinkedList;

public class Sort012LL {

    static class Node {
        public int data;
        public Node next;

        Node()
        {
            this.data = 0;
            this.next = null;
        }

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next)
        {
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {

    }

    public static Node sortList(Node head) {
        // Write your code here
        if (head == null || head.next == null) {
            return head;
        }
        Node temp = head;
        Node zero = new Node(0);
        Node zeroHead = zero;
        Node one = new Node(1);
        Node oneHead = one;
        Node two = new Node(2);
        Node twoHead = two;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? (oneHead.next) : (twoHead.next);
        one.next = twoHead.next;
        two.next = null;
        Node newhead = zeroHead.next;

        zeroHead.next = null;
        oneHead.next = null;
        twoHead.next = null;

        return newhead;
    }
}
