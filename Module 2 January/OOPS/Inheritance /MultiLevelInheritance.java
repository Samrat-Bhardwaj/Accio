class GrandParent {
    int radio;

    public GrandParent(){
        System.out.println("GrandParent constructor");
    }
}

class Parent extends GrandParent {
    int TV;

    public Parent(){
        System.out.println("Parent constructor");
    }
}

class Child extends Parent {
    int smartPhone;

    public Child(){
        System.out.println("Child constructor");
    }
}
public class MultiLevelInheritance {
    public static void main(String[] args) {
        Child c1 = new Child();
    }
}
