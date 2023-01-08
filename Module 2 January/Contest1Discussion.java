import java.util.ArrayList;

class Contest1Discussion {
    // Questions ==============================
    // https://course.acciojob.com/idle?question=c8f615fa-39c6-43e8-8b66-79bd84811e79
    // https://course.acciojob.com/idle?question=df08a8b0-60db-4bdb-9b0b-38b7755086e1
    // https://course.acciojob.com/idle?question=6d37d97f-e4d9-4d08-8bde-d3a971bc5cda
    public static int fourbinacci(int n) {
        if(n<=4){
            return 1;
        }

        int lt = fourbinacci(n-1);
        int lst = fourbinacci(n-2);
        int ltt = fourbinacci(n-3);
        int lft = fourbinacci(n-4);

        int ans = lt + lst + ltt + lft;
        return ans;
    }

    public static int deathGame(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int i=1; i<=n; i++){
            al.add(i);
        }

        // k--;
        int idx=0;
        while(al.size()>1){
            int personToKill = (idx+(k-1))%al.size(); // why k-1, because we are counting current idx as well
            al.remove(personToKill);

            idx = personToKill;
        }

        return al.get(0);
    }

    public static boolean isLuckyNumber(int num){
        if(num==1){
            return true;
        }
        if(num==89){
            return false;
        }

        int sumOfSquareDigits = 0;

        while(num>0){
            int rem = num%10;
            sumOfSquareDigits += rem*rem;

            num/=10;
        }

        boolean ans= isLuckyNumber(sumOfSquareDigits);
        return ans;
    }

    static int solve(int n) {
       for(int i=n+1; i<=10000; i++){
            boolean luckyNumber = isLuckyNumber(i);
            if(luckyNumber == true){
                return i;
            } 
       } 

       return -1;
    }

    public static void main(String[] args) {
        // int n = 20;
        // int ans = fourbinacci(n);
        // System.out.println(ans);

        // int n= 5, k=2;
        // int ans = deathGame(n, k);
        // System.out.println(ans);

        int n = 10;
        int nextLuckyNumber = solve(n);
        System.out.println(nextLuckyNumber);
    }
}