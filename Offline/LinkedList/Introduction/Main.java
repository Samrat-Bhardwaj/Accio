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

    public void addNext(int val){
        
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
        ll.addNext(15);
        ll.addNext(20);
        ll.addNext(14);
        ll.addNext(34);
    }
}