class Main {

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