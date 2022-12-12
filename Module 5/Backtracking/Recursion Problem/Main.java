public class Main {
    public static int maxSum(int i, int j, int[][] matrix, int n, int m){
        if(i>=n || j>=m || i<0 || j<0){
            return 0;
        }

        if(i==n-1 && j==m-1){
            return matrix[i][j];
        }

        // right direction
        int a = maxSum(i, j+1, matrix, n, m);

        // downwards direction
        int b = maxSum(i+1, j, matrix, n, m);

        int ans = Math.max(a,b) + matrix[i][j];
        
        return ans;
    }

    public static void floodFill(int i, int j, int[][] mat, int n, int m, String psf,boolean[][] visited){
        if(i<0 || j<0 || i>=n || j>=m || mat[i][j]==1 || visited[i][j] == true){
            return;
        }

        if(i==n-1 && j==m-1){
            System.out.println(psf);
            return;
        }

        visited[i][j] = true;
        floodFill(i-1, j, mat, n, m, psf+"t",visited);
        floodFill(i, j-1, mat, n, m, psf+"l",visited);
        floodFill(i+1, j, mat, n, m, psf+"d",visited);
        floodFill(i, j+1, mat, n, m, psf+"r",visited);
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,0,1,1,1},{0,1,0,1,1,0},{0,1,0,0,0,0},{0,0,0,1,1,0},{0,1,0,1,1,0},{0,0,0,1,1,0}};
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m];
        // System.out.println(maxSum(0, 0, matrix, matrix.length, matrix[0].length));
        floodFill(0,0,matrix,n,m,"",visited);
    }
}
