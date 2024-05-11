class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Main {
    public static Node removeInBetweenNodes2(Node head){
        Node dummy = new Node(-1);
        Node curr = head;

        Node curr2 = dummy;

        while(curr != null && curr.next != null){
            Node currKaNext = curr.next;

            // extract list 2
            curr2.next = currKaNext;
            
            // thik kiya list 1
            curr.next = curr.next.next;

            // move
            curr = curr.next;
            curr2 = curr2.next;
        }

        curr2.next = null;

        return dummy.next;
    }

    public static Node reverse(Node head){
        Node curr = head;
        Node prev = null;

        while(curr != null){
            Node currKaNext = curr.next;

            curr.next = prev;

            prev = curr;
            curr = currKaNext;
        }

        head = prev;
        return head;
    }

    public static Node findTail(Node head){
        Node curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        return curr;
    }
    public static void display(Node head){
        Node curr = head;

        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }

        System.out.println();
    }
    public static void unfold(Node head){
        // Removes nodes from in between
        Node head2 = removeInBetweenNodes2(head);
        // reverse second half
        head2 = reverse(head2);

        // attach both halves
        Node tailHead1 = findTail(head);

        tailHead1.next = head2;
        display(head);
    }

    // leetcode 138 
    public void copyAndInsert(Node head){
        Node curr = head;

        while(curr != null){
            Node currCopy = new Node(curr.val);

            Node currKaNext = curr.next;

            curr.next = currCopy;
            currCopy.next = currKaNext;

            curr = currKaNext;
        }
    }
    
    public void assignRandomPointers(Node head){
        Node curr = head;

        while(curr != null){
            if(curr.random != null){
                // Node currKaCopy = curr.next;

                // Node currKaRandom = curr.random;
                // Node currKaRandomKaCopy = currKaRandom.next;

                // currKaCopy.random = currKaRandomKaCopy;
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }
    }

    public Node removeInBetweenNodes(Node head){
        Node dummy = new Node(-1);

        Node curr = head;
        Node copyCurr = dummy;

        while(curr != null){
            Node currKaCopy = curr.next;
            Node actualCurrNext = curr.next.next;

            // actual list ko thik krdo 
            curr.next = actualCurrNext;

            // copy list ko bahar nikal lo
            copyCurr.next = currKaCopy;

            // move to next
            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return dummy.next;
    }

    public Node copyRandomList(Node head) {
        // copy and insert in between
        copyAndInsert(head);

        // assign random pointers   
        assignRandomPointers(head);

        // remove in between nodes
        Node copyHead = removeInBetweenNodes(head);

        return copyHead;
    }

    public static Node merge(Node head1, Node head2){
        Node dummy = new Node(-1);
        Node temp1 = head1;
        Node temp2 = head2;
        Node curr = dummy;

        while(temp1!=null && temp2!=null){
            if(temp1.data < temp2.data){
                Node t1KaNext = temp1.next;
                temp1.next = null;

                curr.next = temp1;
                temp1 = t1KaNext;
            } else {
                Node t2KaNext = temp2.next;
                temp2.next = null;

                curr.next = temp2;
                temp2 = t2KaNext;
            }

            curr = curr.next;
        }

        if(temp1 != null){
            curr.next = temp1;
        }

        if(temp2 != null){
            curr.next = temp2;
        }

        return dummy.next;
    }

    public static Node reverseLinkedList(Node head){
        Node curr = head;
        Node prev = null;

        while(curr != null){
            // saving next Node
            Node currKaNext = curr.next;

            // changing connections
            curr.next = prev;

            // move to next nodes
            prev = curr;
            curr = currKaNext;
        }

        head = prev;
        return head;
    }

    public static ListNode findMid2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            // saving next Node
            ListNode currKaNext = curr.next;

            // changing connections
            curr.next = prev;

            // move to next nodes
            prev = curr;
            curr = currKaNext;
        }

        head = prev;
        return head;
    }

    public ListNode merge(ListNode h1, ListNode h2){
        ListNode t1 = h1;
        ListNode t2 = h2;
        ListNode dummy = new Node(-1);
        ListNode curr = dummy;

        int counter = 1;

        while(t1!=null && t2!=null){
            if(counter%2 == 1){
                Node t1KaNext = t1.next;
                t1.next = null;

                curr.next = t1;
                t1 = t1KaNext;
            } else {
                Node t2KaNext = t2.next;
                t2.next = null;

                curr.next = t2;
                t2 = t2KaNext;
            }

            counter++;
            curr = curr.next;
        }

        if(t1 != null){
            curr.next = t1;
        }

        if(t2 != null){
            curr.next = t2;
        }

        return dummy.next;
    }

    public void reorderList(ListNode head) {
        ListNode mid =  findMid2(head);

        Node head2 = mid.next;
        mid.next = null;

        head2 = reverseList(head2);

        merge(head, head2);
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(slow != fast){
            return null;
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode temp = headA;

        while(temp.next != null){
            temp = temp.next;
        }

        ListNode tail = temp;

        // creating cycle
        tail.next = headA;

        ListNode intersectionPoint = detectCycle(headB);

        // removing cycle 
        tail.next = null;

        return intersectionPoint;
    }


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