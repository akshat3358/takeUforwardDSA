package LinkedList;
public class ReverseDLL {

    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data1, Node next1,Node back1){
            this.data = data1;
            this.next = next1;
            this.back = back1;
        }
        Node(int data1){
            this.data = data1;
            this.next = null;
            this.back = null;
        }

    }

    public static void main(String[] args) {
        int[] arr = {0,2,8,9,3,4,5};
        Node head = convertArr2DLL(arr);
        head=reverseDLL(head);
        printLL(head);
    }

    public static Node convertArr2DLL(int[] arr){
        Node head = new Node(arr[0]);
        Node prev = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i],null,prev);
            prev.next=temp;
            prev=temp;
        }
        return head;
    }
    public static Node reverseDLL(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node last = null;
        Node current = head;
        while(current!=null){
            last=current.back;
            current.back=current.next;
            current.next=last;
            current=current.back;
        }
        return last.back;
    }

    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
