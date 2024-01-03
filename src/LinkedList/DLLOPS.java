package LinkedList;

public class DLLOPS {

    static class Node {
        int data;
        Node next;
        Node back;

        Node(int data1, Node next1, Node back1){
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
//        head = deleteDLLHead(head);
//        head = deleteDLLTail(head);
        //head = deleteKthNode(head,7);
//        deleteNode(head.next.next.back);
        //head=insertBeforeDLLHead(head,99);
        //head=insertBeforeDLLTail(head,98);
        //head = insertBeforeKthDLLElement(head,7,89);
        insertBeforeDLLNode(head.next.next.back,94);
        printLL(head);
    }

    public static Node insertBeforeDLLTail(Node head,int val){
        if(head.next==null){
            return insertBeforeDLLHead(head,val);
        }
        Node tail = head;
        while(tail.next!=null){
            tail=tail.next;
        }
        Node prev = tail.back;
        Node newNode = new Node(val,tail,prev);
        prev.next=newNode;
        tail.back=null;
        return head;
    }
    public static void insertBeforeDLLNode(Node node,int val){
        Node prev=node.back;
        Node newNode= new Node(val,node,prev);
        prev.next=node.back=newNode;
    }
    public static Node insertBeforeDLLHead(Node head,int val){
        Node newhead = new Node(val,head,null);
        head.back=newhead;
        return newhead;
    }

    public static Node insertBeforeKthDLLElement(Node head,int k,int val){
        if(k==1){
            return insertBeforeDLLHead(head,val);
        }
        Node temp=head;
        int cnt=0;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                break;
            }
            temp=temp.next;
        }
        Node prev = temp.back;
        Node newNode = new Node(val,temp,prev);
        prev.next=temp.back=newNode;
        return head;
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
    public static Node deleteTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next.back=null;
        temp.next = null;
        return head;
    }
    public static Node deleteKthNode(Node head,int k){
        if(head==null){
            return null;
        }
        Node temp = head;
        int cnt = 0;
        while(temp!=null){
            cnt++;
            if(cnt==k){
                break;
            }
            temp=temp.next;
        }
        Node prev = temp.back;
        Node front = temp.next;
        if(prev==null && front ==null){
            return null;
        }
        else if(prev==null){
            return deleteDLLHead(head);
        } else if (front==null) {
            return deleteDLLTail(head);
        }
        prev.next=front;
        front.back=prev;
        temp.back=null;
        temp.next=null;
        return head;
    }

    public static Node deleteDLLTail(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node tail = head;
        while (tail.next !=null){
            tail=tail.next;
        }
        Node prev = tail.back;
        prev.next=null;
        tail.back=null;
        return head;
    }

    public static void deleteNode(Node temp){
        Node prev = temp.back;
        Node front = temp.next;

        if(front==null){
            prev.next=null;
            temp.back=null;
            return;
        }
        prev.next=front;
        front.back=prev;
        temp.next=temp.back=null;
    }

    public static void printLL(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    public static Node deleteDLLHead(Node head){
        if(head==null || head.next==null){
            return null;
        }
        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next=null;
        return head;
    }
}
