class Main {
    public static int countAllPaths(int i, int j, int n, int m, int[][] matrix, boolean[][] visited){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] == true || matrix[i][j] == 1){
            return 0;
        }

        if(i==n-1 && j==m-1){
            System.out.println("Found one path!!");
            return 1;
        }   

        visited[i][j] = true; // stops you from going to a cell of current_path

        int totalWays = 0;
        totalWays += countAllPaths(i-1, j, n, m, matrix, visited); // top
        totalWays += countAllPaths(i, j-1, n, m, matrix, visited); // left
        totalWays += countAllPaths(i+1, j, n, m, matrix, visited); // down
        totalWays += countAllPaths(i, j+1, n, m, matrix, visited); // right

        visited[i][j] = false; // why? backtracking
        return totalWays;
    }

    public static void printAllPaths(int i, int j, int n, int m, int[][] matrix, boolean[][] visited, String psf){
        if(i<0 || j<0 || i>=n || j>=m || visited[i][j] == true || matrix[i][j] == 1){
            return;
        }

        if(i==n-1 && j==m-1){
            System.out.println(psf);
            return;
        }   

        visited[i][j] = true; // stops you from going to a cell of current_path

        printAllPaths(i-1, j, n, m, matrix, visited, psf + "t"); // top
        printAllPaths(i, j-1, n, m, matrix, visited, psf + "l"); // left
        printAllPaths(i+1, j, n, m, matrix, visited, psf + "d"); // down
        printAllPaths(i, j+1, n, m, matrix, visited, psf + "r"); // right

        visited[i][j] = false; // why? backtracking
    }

    public static void main(String[] args){
        int[][] matrix = {{0,1,0,0,0,0},{0,1,0,1,1,0},{0,0,0,0,0,0},{0,1,0,1,1,0},{0,1,0,1,1,0},{0,0,0,1,1,0}};

        int n = matrix.length;
        int m = matrix[0].length;
        printAllPaths(0,0,n,m,matrix,new boolean[n][m],"");
    }
}