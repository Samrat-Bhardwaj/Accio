class Node {
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

class Main {
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