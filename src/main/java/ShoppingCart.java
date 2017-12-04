import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class ShoppingCart implements Shoppable{
    HashMap<String, Integer>cart;
    float discount;

    public ShoppingCart() {
        this.cart = new HashMap();
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    public boolean IsItemInCart(String item) {
        boolean ItemIsInCart = true;
        if (cart.get(item) != null) {
            return ItemIsInCart;
        }
        else return !ItemIsInCart;
    }
    public void add1ToStockByName(String item) {
        if (IsItemInCart(item)) {
            cart.put(item, cart.get(item) + 1);
        }
        else {
            cart.put(item, 1);
        }
    }
    public int checkAmount(String item) {
        if (IsItemInCart(item)) {
            return cart.get(item);
        }
        else {
            return 0;
        }
    }
    public void Remove1FromStockByName(String item) {
        if (IsItemInCart(item) && checkAmount(item) > 0) {
            cart.put(item, cart.get(item) - 1);
        }
    }
    public ArrayList<String> getShoppingList() {
        ArrayList<String>itemNamesInCart = new ArrayList<>();
        Set<String>itemsInBasket = cart.keySet();
        for (String item : itemsInBasket) {
            itemNamesInCart.add(item);
        }
        return itemNamesInCart;
    }
    public int getSizeOfCart(Set itemsInBasket){
        return itemsInBasket.size();
    }
    public HashMap getCart() {
        return cart = new HashMap<>(cart);
    }
    public void emptyCart(HashMap cart) {
        cart.clear();
    }
    public float getTotalWith2For1Considered(ItemStock stock) {
        float Total = 0;
        ArrayList<String>shoppingList = getShoppingList();
        ArrayList<Sellable>stockList = (ArrayList<Sellable>) stock.getStockList();
        for (String item : shoppingList)
            for (Sellable itemInStock : stockList)
                if (item.equals(itemInStock.getName())) {
                    if (checkAmount(item) == 1) {
                        Total += (checkAmount(item) * itemInStock.getPrice());
                    }
                    else if (checkAmount(item) > 1 && checkAmount(item) % 2 == 0) {
                        Total += ((checkAmount(item) / 2) * itemInStock.getPrice());
                    }
                    else if (checkAmount(item) > 1 && checkAmount(item) % 2 != 0) {
                        Total += ((((checkAmount(item) - 1) / 2) + 1) * itemInStock.getPrice());
                    }
                }
        return Total;
    }
    public float getFinalTotalForCartWithOver£20Check(ItemStock item) {
        float Total = getTotalWith2For1Considered(item);
        if (Total <= 20) {
            return Total;
        }
        else {
            return (Total * (1 - this.discount));
        }
    }
    public float getTotal(ItemStock item) {
        return getFinalTotalForCartWithOver£20Check(item);
    }
    public void setAmount(String name, int amount){
        if (IsItemInCart(name)) {
            cart.put(name, amount);
        }
    }
}
