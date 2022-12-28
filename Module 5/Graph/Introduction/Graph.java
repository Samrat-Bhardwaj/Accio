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

        addEdge(0,1,10);
        addEdge(0, 3, 40);
        addEdge(1, 2, 10);
        addEdge(2, 3, 10);
        addEdge(3, 4, 2);
        addEdge(2, 5, 5);
        addEdge(5, 4, 3);
        addEdge(5, 6, 3);
        addEdge(4, 6, 3);
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

    // number of components ====================================================== 
    public static void dfs(int src, boolean[] vis){
        vis[src]= true;

        for(Edge e: graph[src]){
            int nbr = e.v;
            if(!vis[nbr]){
                dfs(nbr, vis);
            }
        }
    }

    public static int numberOfComponents(){
        boolean[] visited = new boolean[N];
        int count=0;

        for(int i=0; i<N; i++){
            if(visited[i]==false){
                dfs(i,visited);
                count++;
            }
        }

        return count;
    }

    // hamiltonian path and hamiltonian cycle ==============================================================

    public static void hamiltonianPathCycle(int osrc, int src, boolean[] vis, int edgeCount, String psf){
        if(edgeCount == N-1){
            if(checkifEdgeExist(src,osrc)){
                System.out.println("This is a hamiltonian cycle "+psf);
            } else {
                System.out.println("This is a hamiltonian path "+psf);
            }
            return;
        }

        vis[src] = true;

        for(Edge e: graph[src]){
            int nbr = e.v;
            if(!vis[nbr]){
                hamiltonianPathCycle(osrc, nbr, vis, edgeCount + 1, psf+nbr);
            }
        }

        vis[src] = false;
    }

    public static boolean checkifEdgeExist(int u, int v){
        for(Edge e:graph[u]){
            if(e.v == v){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        constructGraph();
        // printGraph();
        // System.out.println(hasPath(0, 6, new boolean[N]));
        // allPaths(0, 6,new boolean[N], "", 0);
        hamiltonianPathCycle(0, 0,new boolean[N], 0, "0");
    }    
}
