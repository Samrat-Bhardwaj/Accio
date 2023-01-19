public class Main {
  public static void main(String[] args) {
    // Pizza rp = new Pizza(true); //  veg pizza
    // rp.addExtraToppings();
    // rp.addExtraCheese();
    // rp.addExtraCheese();
    // rp.addExtraCheese();
    // rp.addExtraToppings();
    // rp.addTakeaway();

    DeluxePizza dp = new DeluxePizza(false);
    dp.addExtraCheese();
    dp.addExtraCheese();
    dp.addExtraToppings();
    dp.addTakeaway();

    System.out.println(dp.getBill());
  }
}