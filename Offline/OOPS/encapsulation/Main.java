package encapsulation;
class Employee {
    private int salary;
    private int joiningYear;

    public void setJoiningYear(int joiningYear){
        this.joiningYear = joiningYear;
    }

    public int setJoiningYear(){
        return this.joiningYear;
    }

    public void setSalary(int newSalary){ // setters
        if(newSalary > 300){
            this.salary = 0;
        } else {
            this.salary = newSalary;
        }
    }

    public int getSalary(String password){ // getters 
        if(password == "ABCD"){
            return this.salary;
        } else {
            System.out.println("Thieffffff");
            return -1;
        }
    }
}


class Main {
    public static void main(String[] args){
        Employee e = new Employee();

        e.setSalary(1000000);
        System.out.println(e.getSalary("1234"));
    }
}