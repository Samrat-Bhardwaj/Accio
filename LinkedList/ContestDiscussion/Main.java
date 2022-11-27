public class Main {
    class Node{
        int data;
        Node next;
        
        Node(int x){
            data = x;
            next = null;
        }
        
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

    // contest question 3 (https://course.acciojob.com/idle?question=5a341a6c-8fcb-4945-bf2f-ded75cc6402a) ========================
    public static void main(String[] args) {
        
    }
}