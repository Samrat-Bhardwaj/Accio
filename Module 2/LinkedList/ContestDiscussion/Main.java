public class Main {
    class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
        
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // https://course.acciojob.com/idle?question=0e70b77f-c4b9-4500-b160-5b1c36fe5d9d
    Node deleteMid(Node head){
		if(head==null){
			return null;
		}

		if(head.next==null){
			return new Node(-1);
		}

		Node prev = null;
		Node slow = head;
		Node fast = head;

		while(fast!=null && fast.next!=null){
			prev=slow;

			slow=slow.next;
			fast=fast.next.next;
		}

		// prev.next = prev.next.next;
        Node nextOfMid = slow.next;
        prev.next = nextOfMid;
		return head;
	}

    // https://practice.geeksforgeeks.org/problems/segregate-even-and-odd-nodes-in-a-linked-list5035/1
    Node divide(int N, Node head){
        if(head == null || head.next==null){
			return head;
		}

		Node dummy1 = new Node(-1);
		Node dummy2 = new Node(-1);

		Node odd = dummy1;
		Node even = dummy2;
		Node curr = head;

		while(curr!=null){
			Node nextOfCurr = curr.next;
			curr.next=null;
			
			if(curr.data % 2==1){
				// connect odd
				odd.next = curr;
				curr = nextOfCurr;
				odd = odd.next;
			} else {
				even.next = curr;
				curr = nextOfCurr;
				even = even.next;
			}
		}

		Node oddHead = dummy1.next;
		Node evenHead = dummy2.next;

        if(evenHead == null){
            return oddHead;
        }
		// connect odd to even
		even.next = oddHead;

		return evenHead;
    }

    // contest question 2 ( https://course.acciojob.com/idle?question=2db30fbb-cf07-47e9-b361-7928be2c9635) ================= 
    public Node segregateList(Node head) {
		if(head == null || head.next==null){
			return head;
		}

		Node dummy1 = new Node(-1);
		Node dummy2 = new Node(-1);

		Node odd = dummy1;
		Node even = dummy2;
		Node curr = head;
		int count = 1;

		while(curr!=null){
			Node nextOfCurr = curr.next;
			curr.next=null;
			
			if(count%2==1){
				// connect odd
				odd.next = curr;
				curr = nextOfCurr;
				odd = odd.next;
			} else {
				even.next = curr;
				curr = nextOfCurr;
				even = even.next;
			}

			count++;
		}

		Node oddHead = dummy1.next;
		Node evenHead = dummy2.next;

		// connect odd to even
		odd.next = evenHead;

		return oddHead;
	}

    // leetcode 25 ==========================================================
    class Solution {
        ListNode oh;
        ListNode ot;
        
        ListNode th;
        ListNode tt;
        
        void addFirst(ListNode nn){
            if(th == null){
                th = nn;
                tt = nn;
            } else {
                nn.next = th;
                th = nn;
            }
        }
        
        int getSize(ListNode head){
            ListNode curr = head;
            
            int ans = 0;
            while(curr!=null){
                ans++;
                curr=curr.next;
            }
            
            return ans;
        }
        
        
        public ListNode reverseKGroup(ListNode head, int k) {
            oh = null;
            ot = null;
            
            th = null;
            tt = null;
            
            int size = getSize(head);
            ListNode curr = head;
            // base case ()
            if(size < k){
                return head;
            }
            
            while(size>=k){
                // reverse in pair of k
                int K=k;
                while(K-- > 0){
                    ListNode nextOfCurr = curr.next;
                    curr.next = null;
                    
                    addFirst(curr);
                    curr = nextOfCurr;
                    
                    size--;
                }
                
                // add th,tt to my original
                if(oh==null){
                    oh = th;
                    ot = tt;
                } else {
                    ot.next = th;
                    ot = tt;
                }
                
                th = null;
                tt = null;
            }
            
            ot.next = curr;
            
            return oh;
        }
    }
    // contest question 3 (https://course.acciojob.com/idle?question=5a341a6c-8fcb-4945-bf2f-ded75cc6402a) ========================
    class Solution2 {
        Node oh;
        Node ot;
        
        Node th;
        Node tt;
        
        void addFirst(Node nn){
            if(th == null){
                th = nn;
                tt = nn;
            } else {
                nn.next = th;
                th = nn;
            }
        }
        
        int getSize(Node head){
            Node curr = head;
            
            int ans = 0;
            while(curr!=null){
                ans++;
                curr=curr.next;
            }
            
            return ans;
        }
        
        
        public Node reverseKGroup(Node head, int k) {
            oh = null;
            ot = null;
            
            th = null;
            tt = null;
            
            int size = getSize(head);
            Node curr = head;
            // base case ()
            if(size < k){
                return head;
            }
            
            while(size>=k){
                // reverse in pair of k
                int K=k;
                while(K-- > 0){
                    Node nextOfCurr = curr.next;
                    curr.next = null;
                    
                    addFirst(curr);
                    curr = nextOfCurr;
                    
                    size--;
                }
                
                // add th,tt to my original
                if(oh==null){
                    oh = th;
                    ot = tt;
                } else {
                    ot.next = th;
                    ot = tt;
                }
                
                th = null;
                tt = null;
            }
            
            ot.next = curr;
            
            return oh;
        }

        public Node swapNode(Node head)
        {
            return reverseKGroup(head, 2);
        }
    }
    public static void main(String[] args) {
        
    }
}
