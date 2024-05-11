import java.util.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String homepage = sc.nextLine();
        int n = sc.nextInt();
        sc.nextLine();
        BrowserHistory browserHistory = new BrowserHistory(homepage);
        for(int i = 0; i < n; i++) {
            String q = sc.nextLine();
            String[] query = q.split("\\s+");
            if(query[0].equals("visit")){
                browserHistory.visit(query[1]);
            } else if(query[0].equals("back")){
                browserHistory.back(Integer.parseInt(query[1]));
            } else if(query[0].equals("forward")){
                browserHistory.forward(Integer.parseInt(query[1]));
            }
        }
    }
}
class Node {
    String data;
    Node next;
    Node prev;

    public Node(String data){
        this.data = data;
    }
}

class BrowserHistory {
    Node curr;
    // Node head;
    public BrowserHistory(String homepage) {
        // your code here
        Node nn = new Node(homepage);
        // head = nn;
        curr = nn; 
    }

    public void visit(String url) {
        Node nn = new Node(url);

        curr.next = nn;
        nn.prev = curr;

        curr = nn;
    }

    public void back(int steps) {
        while(steps > 0 && curr.prev != null){ // while(steps > 0 && curr != head){ 
            curr = curr.prev;
            steps--;
        }
        System.out.println(curr.data);
    }

    public void forward(int steps) {
        while(steps > 0 && curr.next != null){
            curr = curr.next;
            steps--;
        }

        System.out.println(curr.data);
    }
}