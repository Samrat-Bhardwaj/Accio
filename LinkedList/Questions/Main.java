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
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    public static void main(String[] args) {
        
    }
}
