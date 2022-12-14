public class CombinationPermutation {
    public static void combination_oneCoin(int[] arr, int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
        if(idx == arr.length){
            if(csum==tar){
                System.out.println(asf);
            }
            return;
        }

        // include
        combination_oneCoin(arr, idx+1, tar, csum+arr[idx], asf+arr[idx]+",");

        // not include
        combination_oneCoin(arr, idx+1, tar, csum, asf);
    }

    public static void combination_ManyCoins(int[] arr, int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
        if(idx == arr.length){
            if(csum==tar){
                System.out.println(asf);
            }
            return;
        }

        // include (I can include the same coin again, so next call is with the same idx)
        combination_ManyCoins(arr, idx, tar, csum+arr[idx], asf+arr[idx]+",");

        // not include
        combination_ManyCoins(arr, idx+1, tar, csum, asf);
    }

    public static void combination(int[] arr, int idx, int tar, int csum, String asf){
        if(csum>tar){
            return;
        }
        if(idx == arr.length){
            if(csum==tar){
                System.out.println(asf);
            }
            return;
        }

        for(int j=idx; j<arr.length; j++){
            combination(arr, j + 1, tar, csum+arr[j], asf+arr[j]+","); 
            // combination(arr, j , tar, csum+arr[j], asf+arr[j]+",");  // => you can use many coins in one go
        }
    }

    // https://course.acciojob.com/idle?question=00ef1a30-24e1-403f-a0b0-57d7b7d41cd9
    public static void getPermutations(int[] coins, int tar, int csum,boolean[] vis, String asf){
        if(csum > tar){
            return;
        }
        if(tar == csum){
            System.out.println(asf);
            return;
        }

        for(int j=0; j<coins.length; j++){
            if(vis[j]==false){
                vis[j] = true; // using this coin
                getPermutations(coins, tar, csum+coins[j], vis, asf+coins[j]+" ");
                vis[j] = false;
            }
        }
    }

    public static void coinChange(int[] coins, int amt){
        int n = coins.length;
        boolean[] vis = new boolean[n];

        getPermutations(coins,amt,0,vis,"");
    }

    // https://course.acciojob.com/idle?question=703a6a0d-2d07-45e3-9f1c-637c2209793d
    public static void getPermutationsManyCoins(int[] coins, int tar, int csum, String asf){
        if(tar==csum){
            System.out.println(asf);
            return;
        }
        if(tar<csum) return;

        for(int j=0; j<coins.length; j++){
            getPermutationsManyCoins(coins, tar, csum+coins[j], asf+coins[j]+" ");
        }
    }

    public static void coinChange2(int[] coins, int amt){
        getPermutationsManyCoins(coins, amt, 0, "");
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,7};
        combination_oneCoin(arr, 0, 12,0 , "");
        System.out.println("============================================");
        combination(arr, 0, 12, 0,"");
    }
}
