class Vechile {
    String color;
    String engineType;
    int modelNumber;
    static int numberOfVechiles = 0;

    public void pressHonk(){
        System.out.println("Ppppppp");
    }

    private Vechile(String color){
        this.color = color;
        System.out.println("Constructor with color is called");
    }

    public Vechile(String color, String engineType){
        this(color);
        this.engineType = engineType;
        System.out.println("Constructor with color and engineType is called");
    }

    public Vechile(String color, String engineType, int modelNumber){
        this(color,engineType);
        this.modelNumber = modelNumber;
        System.out.println("Constructor with color, engineType and modelNumber is called");
    }
}


class ContructorChaining {
    public static void main(String[] args){
        Vechile v1 = new Vechile("Red","V4",124);
        Vechile v2 = new Vechile("Blue","Vf4",12434);
    }
}