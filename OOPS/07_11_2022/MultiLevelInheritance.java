class GrandParent {
    public GrandParent(){
        System.out.println("GrandParent constructor");
    }
}

class Parent extends GrandParent {
    public Parent(){
        System.out.println("Parent constructor is called");    
    }
}

class Child extends Parent {
    public Child(){
        System.out.println("Child constructor is called");
    }
}

public class MultiLevelInheritance
{
	public static void main(String[] args) {
	   Child c1 = new Child();
	}
}
