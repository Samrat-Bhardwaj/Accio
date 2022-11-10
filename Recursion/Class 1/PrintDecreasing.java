public class PrintDecreasing {
    // print decreasing 
    public static void pd(int n){
        if(n==0){
            return;
        }
        
        System.out.println(n);
        pd(n-1);
    }

    // print increasing 
    public static void PI(int n){
        if(n==0){
            return;
        }

        PI(n-1);
        System.out.println(n);
    }
    
    // print decreasing then increasing 
    public static void PDI(int n){
        if(n==0){
            return;
        }

        System.out.println(n);
        PDI(n-1);
        System.out.println(n);
    }

    // factorial ===================================
    public static int fac(int n){
        if(n==1) return 1;

        int sAns = fac(n-1);
        int ans= n * sAns;

        return ans;
    }
    public static void main(String[] args) {
        // pd(5);
        PI(5);
    }
}
