public class Main {
    // leetcode 200 (Number of islands) =================================================================
    public void dfs(int i, int j, char[][] grid){
        grid[i][j] = '0'; // changing land to water

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i+dir[0];
            int y =j + dir[1];

            if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='1'){
                dfs(x,y,grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }

        return count;
    }

    // surrounded regions (leetcode 130 )====================================================
    public void convert(int i, int j, char[][] board){
        board[i][j]='#';

        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        for(int[] dir:dirs){
            int x = i+dir[0];
            int y = j+dir[1];

            if(x>=0 && y>=0 && x<board.length && y<board[0].length && board[x][y]=='O'){
                convert(x,y,board);
            }
        }
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0 || i==n-1 || j==0 || j==m-1){
                    if(board[i][j]=='O')
                        convert(i,j,board);
                }
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                } else if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
    public static void main(String[] args) {
        
    }    
}
