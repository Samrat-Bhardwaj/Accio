import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class Questions {
    // https://course.acciojob.com/idle?question=adf548b4-b1e3-48ab-a427-579fa50c0571
    void swap(int[] data, int i, int j){
		int temp = data[i];

		data[i] = data[j];
		data[j] = temp;
	}
	
	void upHeapify(int[] data, int ci){
		int pi = (ci-1)/2;

		if(pi>=0 && data[pi] > data[ci]){
			swap(data,pi,ci);
			upHeapify(data,pi);
		}
	}
	
    void buildHeap(int arr[]) {
        for(int i=0; i<arr.length; i++){
			upHeapify(arr,i);
		}
    }

    // HOMEWORK =================================================================================================

    // https://course.acciojob.com/idle?question=d7e7dad4-e898-4180-99cc-501baea38794

    // https://course.acciojob.com/idle?question=9833d7ee-1b1d-4a42-b9a8-22c55c9f6da8


    // https://course.acciojob.com/idle?question=432f7ce4-a080-40bc-a2da-b7b2bbea21a0
    public static int findKthLargest(int[] arr, int n, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i=0; i<n; i++){
			pq.add(arr[i]);

			if(pq.size() > k){
				pq.remove();
			}
		}

		return pq.peek();
	}

	public static int findKthSmallest(int[] arr, int n, int k){
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<n; i++){
			pq.add(arr[i]);

			if(pq.size() > k){
				pq.remove();
			}
		}

		return pq.peek();
	}
	
    public static void kSmallLarge( int arr [], int n, int k){
       int a = findKthLargest(arr,n,k);
		int b = findKthSmallest(arr,n,k);
		
		System.out.println(b);
		System.out.println(a);
		
    }

    // leetcode 451 =============================================
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch, 0)+1);
            // if(map.containsKey(ch)){
            //     map.put(ch,map.get(ch)+1);
            // } else {
            //     map.put(ch,1);
            // }
        }

        ArrayList<Character> keys = new ArrayList<>(map.keySet());

        PriorityQueue<Character> pq = new PriorityQueue<>((Character t, Character o) -> {
            return map.get(o) - map.get(t);
        });

        for(char ch : keys){
            pq.add(ch);
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size()>0){
            char ch = pq.remove();
            int fre = map.get(ch);

            while(fre >0){
                sb.append(ch);
                fre--;
            }
        }

        return sb.toString();
    }

    // https://course.acciojob.com/idle?question=00fef3df-22c8-4980-a6eb-4f6712dc8eab
    static int solve(int a[],int n,int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int e:a){
            pq.add(e);
        }

        int steps = 0;
        while(pq.size()>1){
            if(pq.peek()>=k) return steps;

            int t1 = pq.remove();
            int t2 = pq.remove();

            int newSweetness = 1*t1 + 2*t2;
            pq.add(newSweetness);

            steps++;
        }

        if(pq.peek()<k) return -1;
        return steps;        
    }

    // leetcode 658 (O(nlogn))============================================================================== 

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer t, Integer o) -> {
            if(Math.abs(t-x) == Math.abs(o-x)){
                return t - o;
            }

            return Math.abs(t-x) - Math.abs(o-x);
        });

        for(int e:arr){
            pq.add(e);
        }

        List<Integer> ans = new ArrayList<>();
        while(ans.size()<k){
            ans.add(pq.remove());
        }

        Collections.sort(ans);
        return ans;
    }

    // leetcode 658 with o(nlogk) ========================================================
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((Integer t, Integer o) -> {
            if(Math.abs(t-x) == Math.abs(o-x)){
                return o - t;
            }

            return Math.abs(o-x) - Math.abs(t-x);
        });

        for(int e:arr){
            pq.add(e);
            if(pq.size()>k){
                pq.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(pq.size()>0){
            ans.add(pq.remove());
        }

        Collections.sort(ans);
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
