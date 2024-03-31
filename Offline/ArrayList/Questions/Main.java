import java.util.Scanner;
import java.util.ArrayList;

class Main {
    // distinct ====================
    public static int 3sum(int[] arr, int target){
        int n = arr.length;
        int ans = 0;

        for(int i=0; i<n; i++){
            if(i-1>=0 && arr[i-1] == arr[i]){
                continue;
            }
            int first_ele = arr[i];
            int target_left = target - arr[i];

            int twoSumPairs = twoSumBetweenIndices(arr, target_left, i+1, n-1);
            ans += twoSumPairs;
        }
        return ans;
    }

    public static int twoSumBetweenIndices(int[] arr, int target, int left, int right){
        int number_of_pairs = 0;
        
        while(left < right){
            int csum = arr[left] + arr[right];

            if(csum < target){
                left++;
            } else if(csum > target){
                right--;
            } else {
                number_of_pairs++;
                int curr_ele = arr[right];

                while(left<right && arr[right] == curr_ele){
                    right--;
                }
            }
        }

        return number_of_pairs;
    }

    // two sum ========================
    public static int twoSum(int[] arr, int target){
        int n = arr.length;
        int number_of_pairs = 0;
        
        int left = 0;
        int right = n-1;

        while(left < right){
            int csum = arr[left] + arr[right];

            if(csum < target){
                left++;
            } else if(csum > target){
                right--;
            } else {
                number_of_pairs++;
                right--;
            }
        }

        return number_of_pairs;
    }


    // pascal triangle ===================================
    public static ArrayList<ArrayList<Integer>> pascalTriangle(int numRows) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        ArrayList<Integer> past = new ArrayList<>();
        past.add(1);
        ans.add(past);

        int total_number_of_line = numRows - 1;

        while(total_number_of_line > 0){
            ArrayList<Integer> curr = new ArrayList<>();

            for(int i=1; i<past.size(); i++){
                int csum = past.get(i) + past.get(i-1);
                curr.add(csum);
            }

            curr.add(0,1);
            curr.add(1);

            System.out.println(curr);
            // ans.add(curr);
            past = curr;
            total_number_of_line--;
        }
        return ans;
    }

    public static ArrayList<Integer> pascalTriangleRow(int numRows) {
        ArrayList<Integer> past = new ArrayList<>();
        past.add(1);

        int total_number_of_line = numRows - 1;

        while(total_number_of_line > 0){
            ArrayList<Integer> curr = new ArrayList<>();

            for(int i=1; i<past.size(); i++){
                int csum = past.get(i) + past.get(i-1);
                curr.add(csum);
            }

            curr.add(0,1);
            curr.add(1);

            // System.out.println(curr);
            
            past = curr;
            total_number_of_line--;
        }
        
        return past;
    }

    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> ans = pascalTriangle(5);
        System.out.println(ans);
    }
}