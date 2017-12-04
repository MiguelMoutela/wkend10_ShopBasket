public class Item extends AbstractItem implements Sellable {

    public Item(String name, float price) {
        super(name, price);
    }

    public float getPrice() {
        return this.price;
    }

    public String getName() {
        return this.name;
    }
}