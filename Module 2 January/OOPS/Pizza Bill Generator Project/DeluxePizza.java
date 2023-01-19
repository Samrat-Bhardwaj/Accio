public class DeluxePizza extends Pizza {

    public DeluxePizza(Boolean isVeg) {
        super(isVeg); // normal pizza
        addExtraCheese();
        addExtraToppings();
    }
}