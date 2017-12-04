public class Customer {
    private Shoppable cart;
    private float funds;
    private boolean loyaltyCard;
    private float discount;

    public Customer(float funds, boolean loyaltyCard, Shoppable cart) {
        this.cart = cart;
        this.funds = funds;
        this.loyaltyCard = loyaltyCard;
    }
    public void setDiscount(float discount) {
        this.discount = discount;
    }
    public float getFunds(){
        return this.funds;
    }
    public void setFunds(float amount){
        this.funds = amount;
    }
    public boolean hasLoyaltyCard(){
        return this.loyaltyCard;
    }
    public float getTotal(ItemStock item) {
        return cart.getTotal(item);
    }
    public void pay(ItemStock item) {
        float amountOwed = getTotal(item);
        if (hasLoyaltyCard() && (this.funds > (amountOwed * (1 - this.discount)))) {
            this.funds -= amountOwed;
        }
        else if (!hasLoyaltyCard() && (this.funds > amountOwed)) {
            this.funds -= amountOwed;
        }
    }
}
