import java.util.Scanner;

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

    public static boolean isQueenSafe(int row, int col, boolean[][] board){
        int n = board.length;

        int[][] dirs = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{-1,-1},{0,-1}};
        
        for(int rad=1; rad<n; rad++){
            for(int[] dir : dirs){
                int i = row + rad * dir[0];
                int j = col + rad * dir[1];

                if(i>=0 && j>=0 && i<n && j<n && board[i][j]==true) return false;
            }
        }

        return true;
    }

    public static void NQueens(int row, int n,boolean[][] board, String asf){
        if(row==n){
            System.out.println(asf);
            return;
        }

        for(int col=0; col<n; col++){
            if(isQueenSafe(row,col,board)==true){
                board[row][col] = true;
                NQueens(row+1, n, board, asf+"("+row+" , "+col+")");
                board[row][col] = false;
            }
        }
    }

    // nQueens better 
    public static void NQueens(int row, int n, boolean[] row_visited, boolean[] col_visited, String asf){
        if(row==n){
            System.out.println(asf);
            return;
        }

        for(int col=0; col<n; col++){
            if(row_visited[row] == false && col_visited[col] == false){
                row_visited[row] = true;
                col_visited[col] = true;
                NQueens(row+1, n, row_visited,col_visited, asf+"("+row+" , "+col+")");
                row_visited[row] = false;
                col_visited[col] = false;
            }
        }
    }

    public static void main(String[] args) {
        // int[][] matrix = {{0,1,0,1,1,1},{0,1,0,1,1,0},{0,1,0,0,0,0},{0,0,0,1,1,0},{0,1,0,1,1,0},{0,0,0,1,1,0}};
        // int n = matrix.length;
        // int m = matrix[0].length;

        // boolean[][] visited = new boolean[n][m];
        // // System.out.println(maxSum(0, 0, matrix, matrix.length, matrix[0].length));
        // floodFill(1,0,matrix,n,m,"",visited);
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        scn.close();

        NQueens(0, n, new boolean[n][n], "");
    }
}
