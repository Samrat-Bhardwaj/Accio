class ListNode {
    int val; // data
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}

public class Main {
    public int getSize(ListNode head){
        int len =0;
        ListNode curr = head;

        while(curr!=null){
            curr = curr.next;
            len++;
        }

        return len;
    }

    public ListNode getAt(ListNode head, int idx){
        ListNode curr = head;

        for(int i=0; i<idx; i++){
            curr=curr.next;
        }

        return curr;
    }

    public ListNode middleNode(ListNode head) {
        int size = getSize(head);

        ListNode ans = getAt(head,size/2);
        return ans;
    }
    // approach 2
    public ListNode middleNode(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }


    // if first middle is required (in case of even size LL) ===================
    public ListNode middleNode_(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }

    // leetcode 141 =======================================================
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        
        return false;
    }

    // leetcode 142 ==============================
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next==null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(slow != fast){ // there is no cycle 
            return null;
        }

        // move slow back to head;
        slow=head;

        // keep moving at same pace
        while(slow!=fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow; 
    }

    // homework => https://practice.geeksforgeeks.org/problems/remove-loop-in-linked-list/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

    // leetcode 206 ================================
    public ListNode reverseList(ListNode head) {
        int n = getSize(head); 
        
        int i=0;
        int j=n-1;

        while(i<j){
            ListNode nodeAtI = getAt(head, i);
            ListNode nodeAtJ = getAt(head, j);

            int valAtI = nodeAtI.val;
            int valAtJ = nodeAtJ.val;

            nodeAtI.val = valAtJ;
            nodeAtJ.val = valAtI;

            i++;
            j--;
        }

        return head;
    }

    // reverse better =======================================================
    public ListNode reverseList_(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            // save next pointer 
            ListNode nextOfCurr = curr.next;
            
            // reverse pointer
            curr.next = prev;
            
            // move pointers to the next 2 nodes
            prev = curr;
            curr = nextOfCurr;
        }
        // head is now at prev
        head = prev;
        
        return head;
    }
    

    // merge 2 sorted list 
    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
       ListNode p1 = list1;
       ListNode p2 = list2;

       ListNode dummy = new ListNode(-1);
       ListNode curr = dummy;

       while(p1!=null && p2!=null){
        ListNode np1 = p1.next;
        ListNode np2 = p2.next;

        if(p1.val < p2.val){
            curr.next = p1;
            p1 = np1;
        } else {
            curr.next = p2;
            p2 = np2;
        }

        curr=curr.next;
       }

        if(p1==null){
            curr.next = p2;
        }

        if(p2==null){
            curr.next = p1;
        }    

        return dummy.next;
	}

    // leetcode 143 ==================================================== 
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode curr = dummy;

        while(p1!=null && p2!=null){
            ListNode nextOfP1=p1.next;
            p1.next = null;

            ListNode nextOfP2 = p2.next;
            p2.next=null;

            // first add p1
            curr.next=p1;
            p1 = nextOfP1;
            curr = curr.next;

            // then add p2
            curr.next = p2;
            p2 = nextOfP2;
            curr = curr.next;
        }

        // if(p1==null){
        //     curr.next = p2;
        // }

        // if(p2==null){
        //     curr.next = p1;
        // }
        curr.next = p1;

        return dummy.next;
    }

    // leetcode 143 (This was asked in google) ========================================================
    public void reorderList(ListNode head) {
        // find mid
        ListNode mid = middleNode_(head);

        // break into two
        ListNode head2 = mid.next;
        mid.next=null;

        // reverse the second ll
        head2 = reverseList_(head2);

        // merge two lists 
        head = merge(head,head2);
    }

    // leetcode 237 ========================================================
    public void deleteNode(ListNode node) {
        // node.val = node.next.val;
        // node.next = node.next.next;

        // copying data of the next node to myself
        ListNode nextOfNode = node.next;
        node.val = nextOfNode.val;
        
        // removing node.next
        ListNode nextOfNextOfNode = nextOfNode.next;
        node.next = nextOfNextOfNode;
    }

    // leetcode 160 approach 1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curr = headA;
        
        while(curr.next!=null){
            curr = curr.next;
        }
        
        curr.next = headA;
        ListNode ans = detectCycle(headB);
        
        curr.next=null;
        return ans;
    }

    // leetcode 160 approach 2
    public int getLength(ListNode head){
        int len=0;
        ListNode curr = head;
        
        while(curr!=null){
            curr=curr.next;
            len++;
        }
        
        return len;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int size1 = getLength(headA);
        int size2 = getLength(headB);
        
        ListNode p1 = headA;
        ListNode p2 = headB;
        
        if(size1 > size2){
            int diff = size1- size2;
            // shifting p1 
            while(diff>0 && p1!=null){
                p1=p1.next;
                diff--;
            }
        } else {
            int diff = size2 - size1;
             // shifting p2
            while(diff>0 && p2!=null){
                p2=p2.next;
                diff--;
            }
        }
        
        while(p1!=null && p2!=null){
            if(p1==p2) return p1;
            p1=p1.next;
            p2=p2.next;
        }
        
        return null;
    }

    // https://practice.geeksforgeeks.org/problems/given-a-linked-list-reverse-alternate-nodes-and-append-at-the-end/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
    public static Node reverseList_(Node head) {
        Node prev = null;
        Node curr = head;
        
        while(curr!=null){
            // save next pointer 
            Node nextOfCurr = curr.next;
            
            // reverse pointer
            curr.next = prev;
            
            // move pointers to the next 2 nodes
            prev = curr;
            curr = nextOfCurr;
        }
        // head is now at prev
        head = prev;
        
        return head;
    }
    
    public static void rearrange(Node head)
    {
        int count = 0;
        
        Node dummy1 = new Node(-1);
        Node c1 = dummy1;
        Node dummy2 = new Node(-1);
        Node c2 = dummy2;
        
        Node p = head;
        
        while(p!=null){
            Node nextOfP = p.next;
            p.next = null;
            
            if(count%2 == 0){
                c1.next=p;
                p=nextOfP;
                c1=c1.next;
            } else {
                c2.next=p;
                p=nextOfP;
                c2=c2.next;
            }
            count++;
        }
        
        Node head1 = dummy1.next;
        Node head2 = dummy2.next;
        
        head2 = reverseList_(head2);
        c1.next = head2;
        
        head=head1;
    }
    public static void main(String[] args) {
        
    }
}
