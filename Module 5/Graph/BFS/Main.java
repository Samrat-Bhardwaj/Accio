import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public String toString(){
            return "Edge is from " + this.u + " to " + this.v + " with a weight of " + this.w;  
        }
    }

    static int N = 9; // number of vertex 
    @SuppressWarnings("unchecked")
    static ArrayList<Edge>[] graph = new ArrayList[N];
    
    public static void constructGraph(){
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(0,1,10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 4, 10);
        addEdge(5, 4, 2);
        addEdge(4, 6, 5);
        addEdge(6, 7, 3);
        addEdge(6, 8, 3);
        // cycle
        addEdge(2, 3, 3);
        addEdge(1, 4, 3);
    }

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));    
    }

    // BFS ============================================================
    public static void BFS(int src){
        boolean[] vis = new boolean[N];

        LinkedList<Integer> que = new LinkedList<>();

        que.add(src);
        int level = 0;

        while(que.size()>0){
            int s = que.size();
            System.out.print("This is level " + level+ " -> ");
            while(s-->0){
                int vtx = que.removeFirst();

                if(vis[vtx]==true){
                    System.out.println("There is a cycle" + vtx);
                    continue;
                }

                vis[vtx] = true;
                System.out.print(vtx+" ");
                for(Edge e:graph[vtx]){
                    int nbr = e.v;
                    if(!vis[nbr]){
                        que.addLast(nbr);
                    }
                }
            }
            level++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        constructGraph();
        BFS(0);
    }    
}
