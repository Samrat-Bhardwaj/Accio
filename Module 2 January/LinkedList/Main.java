import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node(){

    }

    public Node(int data){
        this.data = data;
    }
}

public class Main {
    static Node head = null;
    static Node tail = null;

    // O(N)
    public static void reversePointerIteratively(){
        Node prev = null;
        Node curr = head;

        while(curr!=null){
            // save next
            Node nextOfCurr = curr.next;

            // reverse connection
            curr.next = prev;

            // move forward
            prev = curr;
            curr = nextOfCurr;
        }

        // shift head and tail
        tail = head;
        head = prev;
    }
    // O(N2) ===============
    public static void reverseDataIteratively(){
        int length = size();

        int i = 0;
        int j = length - 1;

        while(i<j){
            Node nodeAti = getAt(i);
            Node nodeAtj = getAt(j);

            int valueAti = nodeAti.data;
            int valueAtj = nodeAtj.data;

            nodeAti.data = valueAtj;
            nodeAtj.data = valueAti;

            i++;
            j--;
        }
    }
    public static void removeAt(int idx){
        int length = size();
        if(idx < 0 || idx>=length){
            System.out.println("There is no such index");
            return;
        }

        if(idx == 0){
            removeFirst();
        } else if(idx == length - 1){
            removeLast();
        } else {
            Node prev = getAt(idx-1);
            // prev.next = prev.next.next; 

            Node toDelete = prev.next;
            Node nextNode = toDelete.next;

            prev.next = null;
            toDelete.next = null;
            prev.next = nextNode;
        }
    }

    public static void removeLast(){
        if(head==null){
            System.out.println("LinkedList is empty, not possible to remove last");
        } else if(head == tail){
            head = null;
            tail = null;
        } else {
            int length = size();
            Node prev = getAt(length - 2);

            prev.next = null;
            tail = prev;
        }
    }

    public static void addAt(int idx, int value){
        int length = size();
        if(idx < 0 || idx > length){
            System.out.println("No such index exists");
            return;
        }

        if(idx==0){
            addFirst(value);
        } else if(idx == length){
            addLast(value);
        } else {
            Node nn = new Node(value);

            Node prev = getAt(idx-1);
            Node nextNode = prev.next;

            prev.next = nn;
            nn.next = nextNode;
        }
    }

    public static Node getAt(int idx){
        int length = size();
        if(idx < 0 || idx >= length){
            System.out.println("No such index exists!!");
            return null;
        }

        Node curr = head;
        for(int i=0; i<idx; i++){
            Node nextOfCurr = curr.next;
            curr = nextOfCurr;
        }        

        return curr;
    }

    public static int size(){
        int ans = 0;
        Node curr = head;

        while(curr!=null){
            ans++;
            Node nextOfCurr = curr.next;
            curr = nextOfCurr;
        }

        return ans;
    }

    public static void addFirst(int value){
        Node nn = new Node(value);

        if(head == null){
            head = nn;
            tail = nn;
        } else {
            nn.next = head;
            head = nn;
        }
    }

    public static void removeFirst(){
        if(head==null){ // 0 nodes in LL
            System.out.println("LinkedList is empty, not possible to remove first");
        } else if(head == tail){ // only one node in linkedlist
            head = null;
            tail = null;
        } else {
            Node nextOfHead = head.next;
            head = nextOfHead;
        }
    }

    public static void addLast(int value){
        Node nn = new Node(value);

        if(head == null){
            head = nn;
            tail = nn;
        } else {
            tail.next = nn;
            tail = nn;
        }
    }

    public static void printLinkedList(){
        Node curr = head;

        while(curr!=null){
            System.out.print(curr.data+" ");
            
            Node nextNode = curr.next;
            curr = nextNode;
        }

        System.out.println();
    }
    public static void main(String[] args) {
       
        addLast(5);
        addLast(7);
        addLast(11);

        printLinkedList();
        for(int i=10; i<=13; i++){
            addFirst(i);
            printLinkedList();
        }

        // System.out.println("Adding at particular idx");
        // addAt(4, 99);
        // printLinkedList();

        // removeAt(4);
        // removeAt(0);
        // printLinkedList();

        System.out.println("After Reversing");
        reversePointerIteratively();
        printLinkedList();
        // System.out.println(size());
        // Node ans = getAt(-2);

        // if(ans!=null)
        //     System.out.println(ans.data);


        // Scanner scn = new Scanner(System.in);
        // int n = scn.nextInt();
        // for(int i=0; i<n; i++){
        //     int value = scn.nextInt();

        //     addLast(value);
        // }
    }    
}
