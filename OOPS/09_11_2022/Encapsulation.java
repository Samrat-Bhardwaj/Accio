final class Employee {
    String name;
    private int salary = 100000;
    
    public Employee(String n){
        this.name=n;
    }
    
    // setters 
    public void setSalary(int new_salary){
        if(new_salary > 3000){
            this.salary = 0;
        } else {
            this.salary = new_salary;
        }
    }
    
    // getters 
    public int getSalary(){
        return this.salary;
    }
}


public class Main {
    public static void main(String[] args) {
        Employee Pratik = new Employee("Pratik");
        
        Pratik.setSalary(10000000);
        System.out.println(Pratik.getSalary());
    }
}
