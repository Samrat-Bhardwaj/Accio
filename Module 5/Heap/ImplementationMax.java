import java.util.ArrayList;

public class ImplementationMax {
    static class MaxHeap{
        private ArrayList<Integer> data;

        public MaxHeap(){
            data = new ArrayList<>();
        }

        private void swap(int i, int j){
            int valAtI = data.get(i);
            int valAtJ = data.get(j);
            
            data.set(i,valAtJ);
            data.set(j,valAtI);
        }

        private void upHeapify(int ci){
            int pi = (ci-1)/2;

            if(pi>=0 && data.get(pi) < data.get(ci)){
                swap(ci,pi);
                upHeapify(pi);
            }
        }
        // add
        public void add(int val){
            data.add(val);

            upHeapify(data.size()-1);
        }

        private void downHeapify(int pi){
            int lci = 2*pi + 1;
            int rci = 2*pi + 2;

            int maxi = pi;

            if(lci < data.size() &&  data.get(lci) > data.get(maxi)){
                maxi = lci;
            }

            if(rci < data.size() && data.get(rci) > data.get(maxi)){
                maxi = rci;
            }

            if(maxi != pi){
                swap(pi,maxi);
                downHeapify(maxi);
            }
        }
        // remove
        public int remove(){
            if(data.size()==0){
                System.out.println("There is no element in heap");
                return -1;
            }

            swap(0,data.size()-1);
            int rv = data.remove(data.size()-1);

            downHeapify(0);

            return rv;
        }

        // peek
        public int peek(){
            if(data.size()==0){
                System.out.println("There is no element in heap");
                return -1;
            }

            return data.get(0);
        }

        // size
        public int size(){
            return data.size();
        }
    }

    public static void main(String[] args) {
        MaxHeap pq = new MaxHeap();
        pq.add(23);
        pq.add(19);
        pq.add(24);
        pq.add(43);
        pq.add(13);
        pq.add(3);

        while(pq.size()>0){
            int ele = pq.remove();
            System.out.println(ele);
        }
    }
}
