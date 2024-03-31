class Main {

public static void spiralMatrix2(int[][] mat, int n, int m) {
    int sr = 0;
    int sc = 0;
    int er = n-1;
    int ec = m-1;

    int row = -1; 
    int col = -1;

    while(sr<=er && sc<=ec){
        // start col
        col = sc;
        for(row=sr; row<=er && sc<=ec; row++){
            System.out.print(mat[row][col]+" ");
        }
        sc++;

        // end row
        row = er;
        for(col=sc; col<=ec && sr<=er; col++){
            System.out.print(mat[row][col]+" ");
        }
        er--;

        // end col
        col = ec;
        for(row=er; row>=sr && sc<=ec; row--){
            System.out.print(mat[row][col]+" ");
        }
        ec--;

        // start row
        row = sr;
        for(col=ec; col>=sc && sr<=er; col--){
            System.out.print(mat[row][col]+" ");
        }
        sr++;
    }
}

public static boolean special(int matrix[][], int n){
    for(int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            if(i==j || i+j == n-1){ // non-zero, diagonal ele
                if(matrix[i][j] == 0) return false;
            } else { // zero, non- diagonal
                if(matrix[i][j] != 0) return false;
            }
        }
    }
    return true;
}

// Maxima Minima
public static boolean checkIfLargest(int[][] mat, int min_col, int min){
    int max = Integer.MIN_VALUE;
    for(int i=0; i<mat.length; i++){
        if(mat[i][min_col] > max){
            max = mat[i][min_col];
        }
    }

    return max == min;
}

public static int maximaMinima(int[][] mat) {
    int n = mat.length;
    int m = mat[0].length;

    for(int i=0; i<n; i++){
        int min = Integer.MAX_VALUE;
        int min_col = -1;

        for(int j=0; j<m; j++){
            if(mat[i][j] < min){
                min = mat[i][j];
                min_col = j;
            }
        }

        if(checkIfLargest(mat,min_col,min) == true){
            return min;
        }
    }

    return -1;
}

// leetcode 74 =====================================
public boolean searchMatrix(int[][] matrix, int target) {
    int n = matrix.length;
    int m = matrix[0].length;

    int row = 0;
    int col = m-1;

    while(row<n && col>=0){
        if(matrix[row][col] < target){
            row++;
        } else if(matrix[row][col] > target){
            col--;
        } else {
            return true;
        }
    }

    return false;
}

// find the way =============== 
public static int[] findTheWay(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int row = 0;
    int col = 0;
    int dir = 0;
    
    while(row>=0 && col>=0 && row<n && col<m){
        if(matrix[row][col] == 1){ // dir change
            dir = (dir + 1) % 4;
        }

        if(dir == 0){ // right
            col++;
        } else if(dir == 1){ // down
            row++;
        } else if(dir == 2){ // left
            col--;
        } else { // up
            row--;
        }
    }

    if(row == -1) row++;
    if(col == -1) col++;
    if(row == n) row--;
    if(col == m) col--;

    return new int[]{row,col};
}



public void reverseArray(int[] smallArray){
    int si = 0;
    int ei = smallArray.length - 1;

    while(si <= ei){
        int temp = smallArray[si];
        smallArray[si] = smallArray[ei];
        smallArray[ei] = temp;

        si++;
        ei--;
    }
}

public void rotateBy90(int [][] arr) {
    int n = arr.length;
    // transpose 
    transpose(arr,n);

    // reverse every row (every 1D array)
    for(int i=0; i<n; i++){
        int[] b = arr[i];
        reverseArray(b);
    }
}

public void transpose(int[][] arr, int n) {
    for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }    
}

// transpose of a matrix
public int[][] matrixTranspose(int[][] arr, int n) {
    for(int i=0; i<n; i++){
        for(int j=i; j<n; j++){
            int temp = arr[i][j];
            arr[i][j] = arr[j][i];
            arr[j][i] = temp;
        }
    }
    return arr;
}

public void printElementsAlternately(int[][] arr,int m,int n) {
    for(int i=0; i<arr.length; i++){
        if(i%2 == 0){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
        } else {
            for(int j=arr[i].length-1; j>=0; j--){
                System.out.print(arr[i][j]+" ");
            }
        }
    }
}
// https://course.acciojob.com/idle?question=7251cda0-018c-4e39-92dc-9340e8aabcbb
    public void printMatrixColumnwise(int[][] arr, int n, int m) {
        for(int j=0; j<m; j++){
            for(int i=0; i<n; i++){
                System.out.print(arr[i][j]+" ");
            }
        }
    }


    public void printElements(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args){
        int[][] arr = {{1,2,3},{3,45,45},{123,2,3}};
        int [] b = {3,4,5};
    }
}