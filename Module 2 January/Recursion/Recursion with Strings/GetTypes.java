public class GetTypes {
    // number of maze Paths ============================================
    public static int mazePaths(int i, int j, int n, int m){
        if(i>=n || j>=m){
            return 0;
        }
        if(i==n-1 && j==m-1){
            return 1;
        }
        int hpaths = mazePaths(i, j+1, n, m);
        int vpaths = mazePaths(i+1, j, n, m);

        int allPaths = hpaths + vpaths;
        return allPaths;
    }

    // number of stair paths ==========================================
    public static int numberOfPaths(int n){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }

        int numberOfPathsAfterOneStep = numberOfPaths(n-1);
        int numberOfPathsAfterTwoStep = numberOfPaths(n-2);
        int numberOfPathsAfterOneThreeStep = numberOfPaths(n-3);

        int numberOfPaths = numberOfPathsAfterOneStep + numberOfPathsAfterTwoStep + numberOfPathsAfterOneThreeStep;

        return numberOfPaths;
    }
    public static void main(String[] args) {
        System.out.println(numberOfPaths(4));
    }
}
