 class Student {
        String name;
        static int count=0;
        
        public Student(String n){
            name=n;
            count=count+1;
        }
        
        public static void Bunk(){
            System.out.println("Bunking the classes");
        }
    }
public class CounterExample {
        public static void main(String[] args) {
            Student Pratik=new Student("Pratik");
            System.out.println(Pratik.count);
            
            Student a=new Student("a");
            System.out.println(Pratik.count);
            
            Student b=new Student("b");
            System.out.println(Pratik.count);
            
            Student c=new Student("c");
            System.out.println(c.count);
        }
    }
    
}
