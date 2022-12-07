import java.util.ArrayList;

public class Implementation {

    static class Heap {
        private ArrayList<Integer> data;

        public Heap(){
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

            if(pi>=0 && data.get(pi) > data.get(ci)){
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

            int mini = pi;

            if(lci < data.size() &&  data.get(lci) < data.get(mini)){
                mini = lci;
            }

            if(rci < data.size() && data.get(rci) < data.get(mini)){
                mini = rci;
            }

            if(mini != pi){
                swap(pi,mini);
                downHeapify(mini);
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
        Heap minPq = new Heap();
        minPq.add(23);
        minPq.add(19);
        minPq.add(24);
        minPq.add(43);
        minPq.add(13);
        minPq.add(3);

        while(minPq.size()>0){
            int ele = minPq.remove();
            System.out.println(ele);
        }
    }
}