class Main {
    // 
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