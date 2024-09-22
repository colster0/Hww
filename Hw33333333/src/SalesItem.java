public class SalesItem {
    private String name;
    private double price;
    private int quantity;
// name, price, quantity for list
    public SalesItem(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
//will get you the total price for an item and its quantities
    public double totalPrice() {
        return price * quantity;
    }
// Will display the items in the list with spaces
    public String ItemDescribed() {
        return name + "               $" + price + "                  " + quantity;
    }    

    
}