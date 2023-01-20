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

    public static void removeFirst(){
        if(head==null){
            System.out.println("LinkedList is empty, not possible to remove first");
        } else if(head == tail){
                   
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
        for(int i=0; i<=3; i++){
            removeFirst();
            printLinkedList();
        }
    }    
}
