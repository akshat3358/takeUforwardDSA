package LinkedList;

class Node {
    int data;
    Node next;

    Node(int data1,Node next1){
        this.data = data1;
        this.next = next1;
    }
    Node(int data1){
        this.data = data1;
        this.next = null;
    }
}
public class LLTraversal {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5};
//        Node y = new Node(arr[3]);
        Node head = convertArr2LL(arr);
//        printLL(head);
        System.out.println(checkIfPresent(head,7));
    }

    private static  void printLL(Node head){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    private static int lengthOfLL(Node head){
        int cnt=0;
        Node temp=head;
        while(temp!=null){
            temp = temp.next;
            cnt++;
        }
        return cnt;
    }
    private static Node convertArr2LL(int[] arr){
        Node head = new Node(arr[0]);
        Node mover = head;
        for(int i=1;i<arr.length;i++){
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    private static int checkIfPresent(Node head,int val){
        if(head==null){
            return 0;
        }
        Node temp = head;
        while(temp!=null){
            if(temp.data == val){
                return 1;
            }
            temp = temp.next;
        }
        return 0;
    }
}
