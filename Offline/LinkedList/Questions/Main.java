class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Main {
    public static int getLength(Node head){
        Node temp = head;
        int size = 0;

        while(temp != null){
            Node tempKaNext = temp.next;

            temp = tempKaNext;
            size++;
        }

        return size;
    }

    public static Node getAt(Node head, int idx){
        int curr = 0;
        Node temp = head;

        while(curr < idx){
            Node tempKaNext = temp.next;

            temp = tempKaNext;
            // temp = temp.next;
            curr++;
        }

        return temp;
    }

    public static Node midpointOfLinkedList(Node head){
        int size = getLength(head);

        Node midNode = getAt(head, size/2);

        return midNode;
    }

    // for portal (second middle)
    public static Node midpointOfLinkedList(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null &&fast .next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args){
        
    }
}