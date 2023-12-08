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
public class LLOPS {
    public static void main(String[] args) {

        int[] arr = {2,3,4,5};
//        Node y = new Node(arr[3]);
        Node head = convertArr2LL(arr);
//        printLL(head);
//        System.out.println(checkIfPresent(head,3));
//        head = removeHead(head);
        //head = removeTail(head);
        //head = deleteK(head,1);
        //head = deleteEle(head,6);
        //head = insertAtHead(head,111);
        //head = insertAtTail(head,101);
        //head  = insertAtK(head,101,1);
        head = insertBeforeValue(head,105,6);
        printLL(head);
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

    private static Node removeHead(Node head){
        if(head == null)    return  head;
        head = head.next;
        return head;
    }

    private static Node removeTail(Node head){
        if(head == null || head.next == null ){
            return null;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }

    private static Node deleteK(Node head,int k){
        if(head ==null){
            return head;
        }
        if(k==1){
            //Node temp = head;//not needed this line as such
            head = head.next;
            return head;
        }
        int cnt=0;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                prev.next = prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }

    private static Node deleteEle(Node head,int el){
        if(head ==null){
            return head;
        }
        if(head.data==el) {
            //Node temp = head;//not needed this line as such
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            if(temp.data==el){
                prev.next = prev.next.next;
                break;
            }
            prev=temp;
            temp=temp.next;
        }
        return head;
    }
    private static Node insertAtHead(Node head, int val){
        Node temp = new Node(val,head);
        return temp;
    }
    private static Node insertAtTail(Node head,int val){
        if(head==null){
            return new Node(val);
        }
        Node temp = head;
        while(temp.next != null){
            temp=temp.next;
        }
        temp.next = new Node(val);
        return head;
    }
    private static Node insertAtK(Node head,int el,int k){
        if(head == null){
            if(k==1){
                return new Node(el);
            }
            else return null;
        }
        if(k==1){
            Node temp = new Node(el,head);
            return temp;
        }
        int cnt=0;
        Node temp = head;
        while(temp!=null){
            cnt++;
            if(cnt==k-1){
                Node x = new Node(el);
                x.next = temp.next;
                temp.next=x;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head,int el,int val){
        if(head == null){
            return null;
        }
        if(head.data==val){
            Node temp = new Node(el,head);
            return temp;
        }
        Node temp = head;
        boolean found = false;
        while(temp.next!=null){
            if(temp.next.data==val){
                Node x = new Node(el,temp.next);
                temp.next=x;
                found=true;
                break;
            }
            temp = temp.next;
        }
        if(found==false){
            System.out.println("value isn't in the LL");
        }
        return head;
    }
}
