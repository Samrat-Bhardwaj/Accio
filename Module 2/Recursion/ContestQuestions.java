public class ContestQuestions {
    // getKPC 

    static String[] sarr = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    
    public static ArrayList<String> getKPC(String ques){
        if(ques.length()==0){
            ArrayList<String> ba=new ArrayList<>();
            ba.add("");
            return ba;
        }
        
        char first_char = ques.charAt(0);
        String ss = ques.substring(1);
        ArrayList<String> sans = getKPC(ss);

        int idx = first_char - '0';

        String str = sarr[idx]; // tu

        ArrayList<String> ans = new ArrayList<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i); // t;

            // add character in front of every smallAns string
            for(int j=0; j<sans.size(); j++){
                String sansString = sans.get(j);
                String myAnsString = ch + sansString;

                ans.add(myAnsString);
            }
        }

        return ans;
    }
    
    public static void printKPC(String ques) {
        ArrayList<String> ans = getKPC(ques);

        for(int i=0; i<ans.size(); i++){
            String s=ans.get(i);
            System.out.println(s);
        }
    }

    // get nth odd fib number 
    public int getNthFib(int n){
        if(n==1){
            return 1;
        }    

        if(n==2){
            return 1;
        }

        int ans = getNthFib(n-2) + getNthFib(n-1);
        return ans;
    }
    
    public int helpBob(int n) {
        int fib = (3*n - 1)/2;

        return getNthFib(fib);
    }

    public static void main(String[] args) {
        
    }
}
