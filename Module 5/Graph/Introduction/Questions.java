import java.util.ArrayList;
import java.util.PriorityQueue;

public class Questions {
    static class Edge {
        int src;
        int nbr;
        int wt;
  
        Edge(int src, int nbr, int wt) {
           this.src = src;
           this.nbr = nbr;
           this.wt = wt;
        }
     }
  
     static class Pair implements Comparable<Pair> {
        int wsf;
        String psf;
  
        Pair(int wsf, String psf){
           this.wsf = wsf;
           this.psf = psf;
        }
  
        public int compareTo(Pair o){
           return this.wsf - o.wsf;
        }
     }
     
    static String lpath; // longest path
   static Integer lpathwt = Integer.MIN_VALUE;
   static String fpath; // path just smaller than criteria 
   static Integer fpathwt = Integer.MIN_VALUE;
   static PriorityQueue<Pair> pq = new PriorityQueue<>(); // pq
   public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
      if(src==dest){
        pq.add(new Pair(wsf,psf));
        if(pq.size()>k){
            pq.remove();
        }

        if(wsf > lpathwt){
            lpath = psf;
            lpathwt = wsf;
        }

        if(wsf < criteria && wsf > fpathwt){
            fpathwt = wsf;
            fpath = psf ; 
        }
        return;
      }

      visited[src] = true;

      for(Edge e: graph[src]){
        int nbr = e.nbr;
        if(!visited[nbr]){
            multisolver(graph, nbr, dest, visited, criteria, k, psf+nbr, wsf+e.wt);
        }
      }

      visited[src] = false;
   }

   // homework ===========================
    // https://course.acciojob.com/idle?question=ad1abf35-aa2c-4f0f-8fa3-46b85e164e4c
    boolean hasPath(int src, int des, ArrayList<Integer>[] graph, boolean[] vis){
        if(src == des){
            return true;
        }

        boolean ans = false;
        vis[src]= true;
        for(int nbr: graph[src]){
            if(!vis[nbr]){
                ans = ans || hasPath(nbr, des, graph, vis);
            }
        }

        vis[src] = false;
        return ans;
    }

    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges,int U,int V) {
        // N vertices, M edges
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i=0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(ArrayList<Integer> edge:Edges){
            int u = edge.get(0);
            int v = edge.get(1);

            graph[u-1].add(v-1);
        }

        return hasPath(U-1, V-1, graph, new boolean[N]) || hasPath(V-1, U-1, graph,new boolean[N]);
    }

    public static int getSize(int src, boolean[] vis, ArrayList<Edge>[] graph){
        vis[src]= true;

        int ans = 0;
        for(Edge e: graph[src]){
            int nbr = e.nbr;
            if(vis[nbr]==false){
                int nbrSize = getSize(nbr, vis, graph);
                ans += nbrSize;
            }
        }

        return ans + 1;
    }
    public static int perfectStudents(int vtces,  ArrayList<Edge>[] graph){
        ArrayList<Integer> components = new ArrayList<>();

        boolean[] visited = new boolean[vtces];
        for(int i=0; i<vtces; i++){
            if(visited[i]==false){
                int size  = getSize(i,visited,graph);
                components.add(size);
            }
        }

        int pairs=0;
        for(int i=0; i<components.size(); i++){
            int s1 = components.get(i);
            for(int j=i+1; j<components.size(); j++){
                int s2 = components.get(j);
                pairs = pairs +(s1*s2);
            }
        }

        return pairs;
    }

    public static void main(String[] args) {
        
    }    
}
