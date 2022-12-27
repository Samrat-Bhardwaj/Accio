import java.util.ArrayList;

public class Graph {
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

    static int N = 7; // number of vertex 
    @SuppressWarnings("unchecked")
    static ArrayList<Edge>[] graph = new ArrayList[N];
    
    public static void constructGraph(){
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        addEdge(0,1,2);
        addEdge(0, 2, 3);
        addEdge(1, 3, 1);
        addEdge(2, 3, 4);
        addEdge(3, 4, 7);
        addEdge(4, 5, 3);
        addEdge(5, 6, 9);
    }

    public static void addEdge(int u, int v, int w){
        graph[u].add(new Edge(u, v, w));
        graph[v].add(new Edge(v, u, w));    
    }

    public static void printGraph(){
        for(int i=0; i<N; i++){
            ArrayList<Edge> al = graph[i];

            for(Edge e: al){
                System.out.println(e);
            }
        }
    }

    public static boolean hasPath(int src, int des, boolean[] vis){
        if(src==des){
            return true;
        }

        vis[src] = true;
        boolean ans = false;

        for(Edge e: graph[src]){
            int nbr = e.v;
            if(vis[nbr]==false){
                ans = ans || hasPath(nbr, des, vis);
            }
        }

        return ans;
    }

    public static void allPaths(int src, int des, boolean[] vis, String psf, int wsf){
        if(src==des){
            System.out.println(psf+ des +"@"+wsf);
            return;
        }

        vis[src] = true;
        for(Edge e: graph[src]){
            int nbr = e.v;
            if(!vis[nbr]){
                allPaths(nbr, des, vis, psf+src, wsf+e.w);
            }
        }

        vis[src] = false;
    }

    // homework ===========================
    // https://course.acciojob.com/idle?question=ad1abf35-aa2c-4f0f-8fa3-46b85e164e4c

    public static void main(String[] args) {
        constructGraph();
        // printGraph();
        // System.out.println(hasPath(0, 6, new boolean[N]));
        allPaths(0, 6,new boolean[N], "", 0);
    }    
}
