class Main {
    public static long ways(int n, int start_coin){
        if(n==0){
            return 1;
        }

        if(start_coin > n){
            return 0;
        }

        long waysAfterIncludingCurrentCoin = ways(n - start_coin, start_coin + 1);
        long waysAfterNotIncludingCurrentCoin = ways(n, start_coin + 1);

        long totalWays = waysAfterIncludingCurrentCoin + waysAfterNotIncludingCurrentCoin;

        return totalWays;
    }


    public static long ways2(int n, int start_coin){ // combinations
        if(n==0){
            return 1;
        }
        
        if(start_coin > n){
            return 0;
        }
        long totalWays = 0;

        for(int coin = start_coin; coin <=n; coin++){
            long rec_ways = ways2(n-coin, coin+1);
            totalWays += rec_ways;
        }
        return totalWays;
    }

    public static void main(String[] args){
        
    }
}