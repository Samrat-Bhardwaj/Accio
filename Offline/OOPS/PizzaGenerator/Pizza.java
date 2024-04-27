public class Pizza {

    private int price;
    private Boolean isVeg;
    private String bill;
    private boolean isExtraCheeseAdded;
    private boolean isExtraToppingsAdded;
    private boolean isPaperbagAdded;

    public Pizza(Boolean isVeg){
        this.isVeg = isVeg;
        // your code goes here
        if(this.isVeg == true){
            bill = "Base Price Of The Pizza: 300\n";
            this.price += 300;
        } else {
            bill = "Base Price Of The Pizza: 400\n";
            this.price += 400;
        }
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if(this.isExtraCheeseAdded == false){
            this.price += 80;
            this.bill += "Extra Cheese Added: 80\n";
            this.isExtraCheeseAdded = true;
        }
    }

    public void addExtraToppings(){
        if(this.isExtraToppingsAdded == false){
            if(this.isVeg){
                this.price += 70;
                this.bill += "Extra Toppings Added: 70\n";
            } else {
                this.price += 120;
                this.bill += "Extra Toppings Added: 120\n";
            }

            this.isExtraToppingsAdded = true;
        }
    }

    public void addTakeaway(){
        if(this.isPaperbagAdded == false){
            this.price += 20;
            this.bill += "Paperbag Added: 20\n";
            
            this.isPaperbagAdded = true;
        }
    }

    public String getBill(){
        this.bill += "Total Price: " + this.price;
        return this.bill;
    }
}