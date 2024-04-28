class Node {
    int data;
    Node next; // addresses of type Node 

    public Node(int data){
        this.data = data;
    }
}

class LinkedList {
    Node head; // data,next
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
        Node nn = new Node(val);

        if(this.head == null){
            this.head = nn;
            this.tail = nn;
        } else {
            nn.next = head;
            head = nn;
        }

        this.size++;
    }

    public void removeFirst(){
        if(this.size == 0){
            System.out.println("Empty Linkedlist, not possible to remove first");
            return;
        } else if(this.size == 1){
            head = null;
            tail = null;
        } else {
            Node headKaNext = head.next; // 4k
            head = headKaNext;
        }

        this.size--;
    }

    public Node getAt(int idx){
        if(idx < 0 || idx >=size){
            System.out.println("Invalid index!!!");
            return null;
        }

        int curr = 0;
        Node temp = head;

        while(curr < idx){
            Node tempKaNext = temp.next;

            temp = tempKaNext;
            curr++;
        }

        return temp;
    }

    public void removeLast(){
        if(size == 0){
            System.out.println("Not possible to remove last, linkedlist empty");
            return;
        } else if(size==1){
            head = null;
            tail = null;
        } else {
            Node tailKaPrev = getAt(size-2);

            tailKaPrev.next = null;
            tail = tailKaPrev;
        }
        this.size--;
    }

    public void removeLast2(){
        if(size == 0){
            System.out.println("Not possible to remove last, linkedlist empty");
            return;
        } else if(size==1){
            head = null;
            tail = null;
        } else {
            Node curr = head;
            Node prev = null;

            while(curr != tail){
                Node currKaNext = curr.next;

                prev = curr;
                curr = currKaNext;
            }

            Node tailKaPrev = prev;

            tailKaPrev.next = null;
            tail = tailKaPrev;
        }
        this.size--;
    }

    // display 
    public void display(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.data+" ");

            Node tempKaNext = temp.next;
            temp = tempKaNext;
        }

        System.out.println();
    }

    // homework
    public void addAt(int idx, int val){

    }


    public void removeAt(int idx){
        if(idx == 0){
            removeFirst();
        } else if(idx == size - 1){
            removeLast();
        } else {
            Node idxKaPrev = getAt(idx - 1);
            Node idxKaNext = getAt(idx + 1);

            idxKaPrev.next = idxKaNext;

            size--;
        }
    }

    public int size(){
        return this.size();
    }   
}

class Main {
    
    public static void main(String[] args){
        LinkedList ll = new LinkedList(); // head, tail, size
        
        ll.addLast(15);
        ll.addLast(20);
        ll.addLast(14);
        ll.addLast(34);

        ll.display();

        Node valueAtIdx = ll.getAt(435);

        if(valueAtIdx != null){
            System.out.println(valueAtIdx.data);
        }
    }
}