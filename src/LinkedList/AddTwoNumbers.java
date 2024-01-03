package LinkedList;

public class AddTwoNumbers {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        int carry = 0;
        int sum = 0;
        while (temp1 != null || temp2 != null) {
            sum = carry;
            if (temp1 != null) sum = sum + temp1.val;
            if (temp2 != null) sum = sum + temp2.val;
            ListNode newNode = new ListNode(sum % 10);
            curr.next = newNode;
            curr = curr.next;
            carry = sum / 10;
            if (temp1 != null) temp1 = temp1.next;
            if (temp2 != null) temp2 = temp2.next;
        }
        if (carry > 0) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
        }
        return dummyNode.next;
    }
}
