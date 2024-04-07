class Main {
    public static int convertToInt(String str){
        int convertedValue = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            
            int num = ch - '0';

            convertedValue = convertedValue*10 + num;
        }

        return convertedValue;
    }

    public static ArrayList<Integer> arrayGenerator(String str){ 
        String [] sarr = str.split(",");

        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<sarr.length; i++){
            String str_Value = sarr[i];

            int int_Value = convertToInt(str_Value);
            // int int_Value = Integer.parseInt(str_Value);
            res.add(int_Value);
        }
        return res;
    }

    public static void ptice(int n, String ansKey) {
        String adrian = "ABC";
        String bruno = "BABC";
        String gopal = "CCAABB";

        int adrianScore = 0;
        int brunoScore = 0;
        int gopalScore = 0;

        for(int i=0; i<ansKey.length(); i++){
            char currentAns = ansKey.charAt(i);

            if(currentAns == adrian.charAt(i%3)){
                adrianScore++;
            }

            if(currentAns == bruno.charAt(i%4)){
                brunoScore++;
            }

            if(currentAns == gopal.charAt(i%6)){
                gopalScore++;
            }
        }

        // int maxScore = Math.max(adrianScore, Math.max(brunoScore, gopalScore));
        int maxScore = 0;
        if(adrianScore > brunoScore && adrianScore > gopalScore){
            maxScore = adrianScore;
        } else if(brunoScore > gopalScore){ // adrianScore is not maximum
            maxScore = brunoScore;
        } else {
            maxScore = gopalScore;
        }

        System.out.println(maxScore);

        if(maxScore == adrianScore){
            System.out.println("Adrian");
        }
        if(maxScore == brunoScore){
            System.out.println("Bruno");
        } 
        if(maxScore == gopalScore){
            System.out.println("Goran");
        }
    }
    public static char MaximumFrequencyChar(String str) {
        int[] fre = new int[26];
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);

            int idx = ch - 'a';
            fre[idx] = fre[idx] + 1;
        }

        int maxFre = 0;
        char maxFreChar = '$';

        for(int i=0; i<26; i++){
            if(fre[i] > maxFre){
                maxFre = fre[i];
                maxFreChar = (char)(i + 'a');
            }
        }

        return maxFreChar;
    }
    public static String reverseWords(String str){ // how are you
        String[] sarr = str.split(" "); // {"how", "are", "you"}
        int n = sarr.length; // number of words

        String res = "";

        for(int i=n-1; i>=0; i--){
            res += sarr[i];
            res += " ";
        }

        return res;
    }

    // print all substrings  ================================== 
    public static String getSubstr(String str, int si, int ei){
        String ans = "";

        int i = si;
        while(i<=ei){
            char ch = str.charAt(i);
            ans += ch;
            i++;
        }

        return ans;
    }

    public static void SubString(String str) {
        int n = str.length();

        for(int i=0; i<n; i++){
            String substr = "";
            for(int j=i; j<n; j++){
                // get the substring starting at ith index and ending at jth index
                substr += str.charAt(j); // O(n)
                System.out.println(substr);
                // print the substing from i to j
            }
        }
    }

    public  static void isPangram(String s){
        boolean[] arr = new boolean[26];

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= 'a' && ch <= 'z'){ // isLowerCase
                int idx = ch-'a';
                arr[idx] = true;
            } else if(ch != ' '){ // upperCase letters;
                char newCh = Character.toLowerCase(ch);
                arr[newCh - 'a'] = true;
            }
        }

        boolean isPangram = true;

        for(int i=0; i<26; i++){
            if(arr[i] == false){
                isPangram = false;
                break;
            }
        }

        if(isPangram == true){
            System.out.println("pangram");
        } else {
            System.out.println("not pangram");
        }
    }


    public static void toggleCase(int n, String str) {
        for(int i=0; i<n; i++){ // 10^5
            char ch = str.charAt(i);
            char newCh = ch; //'$' , '9'

            if(ch >= 'a' && ch <= 'z'){ // isLowerCase
                newCh = Character.toUpperCase(ch);
            }
            if(Character.isUpperCase(ch) == true){ // isUpperCase
                newCh = Character.toLowerCase(ch);
            }

            System.out.print(newCh); // '$' , '9'
        }
    }
    // https://course.acciojob.com/idle?question=c790c265-0a43-418d-b16c-ea23cda5d42c
    public static int countWords(String s) {
        int n = s.length();
        int count = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);

            if(ch == ' '){
                continue;
            }
            count++;
            int j = i;

            while(j<n && s.charAt(j)!=' '){
                j++;
            }

            i = j;
        }
        return count;
    }

    // this won't work in our case
    public static int countWords2(String s) {
        String[] sarr = s.split(" ");

        for(String e: sarr){
            System.out.println(e);
        }
        return sarr.length;
    }

    public static void main(String[] args){
        // String s = "this is  a sample   string  ";

        // countWords2(s);
        // char ch1 = '*';
        // char ch2 = 'b';

        // int res = 97;
        // char ch = 'd'; // 100
        // // System.out.println(ch);

        // if(ch >= 'a' && ch <= 'z'){ // isLowerCase
        //     System.out.println("Character is lowercase");
            
        // }
        // if(ch >= 'A' && ch <= 'Z'){ // isUpperCase
        //     System.out.println("Character is lowercase");
        // }

        toggleCase(8,"helloHEY");
    }
}