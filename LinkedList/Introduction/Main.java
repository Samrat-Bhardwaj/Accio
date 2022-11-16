class Node {
    int data;
    Node next;

    public Node(int d){
        this.data = d;
    }
}

public class Main {
    static Node head;
    static Node tail;

    public static void addLast(int data){
        Node nn = new Node(data);
        tail.next = nn;

        tail = nn;
    }

    public static void main(String[] args) {
        Node f = new Node(7); 
        Node s = new Node(0);

        Node t = new Node(1);

        // connecting first and second
        f.next = s;
        s.next = t;

        head = f;
        tail = t;

        addLast(10);
        addLast(59);
        System.out.println(f.next.next.next.next.data); //59
    }
}
