import java.util.ArrayList;
import java.util.List;


// create arraylist
public class SalesSlip {
    private List<SalesItem> items;
//arraylist will be the list of items
    public SalesSlip() {
        items = new ArrayList<>();
    }
//add item, I wont need a remove function
    public void addItem(SalesItem item) {
        items.add(item);
    }
//for loop 
    public double computeTotal() {
        double total = 0;
        for (SalesItem item : items) {
            total += item.totalPrice();
        }
        //will add all the costs
        return total;
    }
//if there is no items in the slip
    public String slipWritten() {
        if (items.isEmpty()) {
            return "No items in the sales slip.";
        }
        
        StringBuilder stringB = new StringBuilder();
        for (SalesItem item : items) {
            stringB.append(item.ItemDescribed()).append("\n");
        }
        // No total 
        return stringB.toString();
    }
}