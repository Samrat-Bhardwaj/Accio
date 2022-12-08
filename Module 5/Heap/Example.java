import java.util.ArrayList;
import java.util.PriorityQueue;

public class Example {
    public static void main(String[] args) {
        int[][] matrix={{3,2,3},{1,4,5},{2,7,8}};

        PriorityQueue<int[]> pq = new PriorityQueue<>((int[] t, int[] o) ->{
            // return t[0] - o[0]; // min pq
            return o[1] - t[1]; 
        });

        for(int i=0; i<matrix.length; i++){
            pq.add(matrix[i]);
        }

        int[] top=pq.remove();
        for(int i=0; i<top.length; i++){
            System.out.print(top[i]+" ");
        }
        // System.out.println(pq.peek()[0]);
    }
}
