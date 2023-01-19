public class Pizza {
    private boolean isVeg; // if its a veg pizza (isVeg = true) else if non veg (isVeg=false)

    private String bill="";
    private int price=0;
    private boolean isCheeseAddedOnce = false;
    private boolean isToppingsAddedOnce = false;
    private boolean isTakeAwayAdded = false;

    // given prices that we can change
    private int vegPizzaBasePrice = 300;
    private int NonvegPizzaBasePrice = 400;
    private int extraCheesePrice = 80;
    private int extraToppingsVegPrice = 70;
    private int extraToppingsNonVegPrice = 120;
    private int TakeAwayPrice = 20;


    public Pizza(boolean isVeg){
        this.isVeg = isVeg;

        if(isVeg == true){
            price += vegPizzaBasePrice;
            bill = bill + "Base Price Of The Pizza: " + vegPizzaBasePrice + "\n";
        } else {
            price += NonvegPizzaBasePrice;
            bill = bill + "Base Price Of The Pizza: " + NonvegPizzaBasePrice + "\n";
        }
    }

    public int getPrice(){
        return this.price;
    }

    public void addExtraCheese(){
        if(isCheeseAddedOnce == false){
            price = price + extraCheesePrice;

            isCheeseAddedOnce = true;
        }
    }

    public void addExtraToppings(){
        if(isToppingsAddedOnce == false){
            if(isVeg == true){
                this.price += extraToppingsVegPrice;
            } else {
                this.price += extraToppingsNonVegPrice;                
            }

            isToppingsAddedOnce = true;
        }
    }

    public void addTakeaway(){
        isTakeAwayAdded = true;
        this.price += TakeAwayPrice;
    }

    public String getBill(){
        if(isCheeseAddedOnce==true){
            this.bill = this.bill + "Extra Cheese Added: " + extraCheesePrice + "\n";
        } 
        
        if(isToppingsAddedOnce){
            if(isVeg == true){
                this.bill = this.bill + "Extra Toppings Added: " + extraToppingsVegPrice +"\n";
            } else {
                this.bill = this.bill + "Extra Toppings Added: " + extraToppingsNonVegPrice +"\n";
            }
        }

        if(isTakeAwayAdded){
            this.bill = this.bill + "Paperbag Added: " + TakeAwayPrice +"\n";
        }

        this.bill = this.bill + "Total price: " + this.price;

        return this.bill;
    }
}
