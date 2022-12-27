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
    public static void main(String[] args) {
        
    }    
}
