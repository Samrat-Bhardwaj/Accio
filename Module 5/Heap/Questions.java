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
    public static void main(String[] args) {
        
    }
}
