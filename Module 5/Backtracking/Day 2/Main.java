import java.util.ArrayList;

public class Main {

    // target sum subsets 
    public static void solve(int[] arr, int tar, int idx, int csum,ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans){
		if(csum>tar) return;
		if(idx == arr.length){
			if(tar==csum){
				ans.add(new ArrayList<>(curr));
			}
			return;
		}

		// include 
		curr.add(arr[idx]);
		solve(arr,tar,idx+1,csum+arr[idx],curr,ans);
		curr.remove(curr.size()-1);
		
		// not include
		solve(arr,tar,idx+1,csum,curr,ans);
	}

    public static boolean canPlace(int row, int col, int num, char[][] board){
        // check row
        for(int i=row,j=0; j<9; j++){
            if(board[i][j]-'0'==num){
                return false;
            }
        }

        // check col
        for(int i=0, j=col; i<9; i++){
            if(board[i][j]-'0'==num){
                return false;
            }
        }

        int sr = (row/3)*3;
        int sc = (col/3)*3;
        // check subGrid
        for(int i=sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(board[i][j]-'0'==num){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean fillSudoku(ArrayList<int[]> points, int idx, char[][] board){
        if(idx == points.size()){
            return true;
        }

        int[] curr_points = points.get(idx);
        int row = curr_points[0];
        int col = curr_points[1];

        for(int num=1; num<=9; num++){
            if(canPlace(row,col,num,board)==true){
                board[row][col] = (char)(num+'0');
                boolean ans = fillSudoku(points, idx+1, board);
                if(ans==true){
                    return true;
                }

                board[row][col]='.';
            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board) {
        ArrayList<int[]> points = new ArrayList<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    points.add(new int[]{i,j});
                }
            }
        }

        fillSudoku(points,0,board);
    }
    public static void main(String[] args) {
        
    }
}
