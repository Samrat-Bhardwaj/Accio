class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
        }
    }

    Node head;
    Node tail;
    int size;

    public LinkedList(){
        this.size = 0;
    }

    public void addLast(int val){
        Node nn = new Node(val);

        if(this.head == null){
            this.head = nn;
            this.tail = nn;
        } else {
            this.tail.next = nn;
            this.tail = nn;
        }
        
        this.size++;
    }

    public void addFirst(int val){
        
    }

    public void removeFirst(){

    }

    public int getAt(int idx){
        
    }

    public void removeLast(){

    }

    // display 
    public void addAt(int idx, int val){

    }

    public void removeAt(int idx){

    }

    public int size(){
        return this.size();
    }

    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.println(temp.data + ", ");
            temp = temp.next;
        }
    }
}
class Main {
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.addLast(15);
        ll.addLast(20);
        ll.addLast(14);
        ll.addLast(34);

        ll.display();
    }
}