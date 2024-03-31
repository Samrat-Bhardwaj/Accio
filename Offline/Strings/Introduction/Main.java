class Main {
    public static void main(String[] args){
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        

        if(s1.equals(s2) == true){ // first address comparison, then character by character
            // s1 == s2 || char-by-char
            System.out.println("Strings are equal");
        } else {
            System.out.println("Strings are not equal");
        }
    }
}