public class robHouse {
    public static int robHouse(int idx, int end, int[] arr){
        if(idx>end){
            return 0;
        }

        // rob current idx
        int rob = robHouse(idx+2,end,arr) + arr[idx];
        
        // skip current idx
        int skip = robHouse(idx+1, end, arr);

        int ans = Math.max(rob,skip);
        return ans;
    }
    
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();

        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i] = scn.nextInt();
        }

        int startFrom0 = robHouse(0,n-2,arr);
        int startFrom1 = robHouse(1,n-1,arr);

        int ans=Math.max(startFrom0,startFrom1);
        System.out.println(ans);
	}
}
