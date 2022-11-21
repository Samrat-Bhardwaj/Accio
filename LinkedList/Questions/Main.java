class ListNode {
    int val; // data
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode reverseList(ListNode head) {
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
    public static void main(String[] args) {
        
    }
}