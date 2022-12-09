import java.rmi.ConnectIOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
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

    // leetcode 692 =========================================================================================================
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map = new HashMap<>();

        for(String s : words){
            map.put(s,map.getOrDefault(s, 0)+1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((String t, String o)->{
            if(map.get(t) == map.get(o)){
                return o.compareTo(t);
            }
            return map.get(t) - map.get(o);
        });

        for(String key:map.keySet()){
            pq.add(key);

            if(pq.size()>k){
                pq.remove();
            }
        }

        List<String> ans = new ArrayList<>();

        while(pq.size()>0){
            ans.add(pq.remove());
        }

        Collections.reverse(ans);
        return ans;
    }

    // leet 1642 ===================================================================
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1; i<heights.length; i++){
            int diff = heights[i] - heights[i-1];

            if(diff<=0) continue;
            pq.add(diff);

            if(pq.size()>ladders){
                int min = pq.remove();
                bricks -= min;
            }

            if(bricks < 0) return i-1;
        }

        return heights.length - 1;
    }

    // leet 295 ================================================================================== 
    class MedianFinder {
        PriorityQueue<Integer> left;
        PriorityQueue<Integer> right;
    
        public MedianFinder() {
            left = new PriorityQueue<>(Collections.reverseOrder());
            right = new PriorityQueue<>();
        }
        
        public void addNum(int num) { // log(n)
            if(left.size()==0 || num<=left.peek()){
                left.add(num);
            } else {
                right.add(num);
            }
    
            int ls = left.size();
            int rs = right.size();
    
            if(ls - rs == 2){
                right.add(left.remove());
            } else if(rs > ls){
                left.add(right.remove());
            }
        }
        
        public double findMedian() { // O(1)
            if(left.size() == right.size()){
                return (1.0*left.peek() + right.peek()*1.0 )/(2.0);
            } else {
                return left.peek()*1.0;
            }
        }
    }
    public static void main(String[] args) {
        
    }
}
