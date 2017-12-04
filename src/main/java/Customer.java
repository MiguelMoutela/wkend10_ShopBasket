public class Customer {
    private Shoppable[]cart;
    private float funds;
    private boolean loyaltyCard;
    private float discount;

    public Customer(float funds, boolean loyaltyCard) {
        this.cart = new Shoppable[1];
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
    public float getTotal() {
        return cart[0].getTotal();
    }
    public void pay() {
        float amountOwed = getTotal();
        if (hasLoyaltyCard() && (this.funds > (amountOwed * (1 - this.discount)))) {
            this.funds -= amountOwed;
        }
        else if (!hasLoyaltyCard() && (this.funds > amountOwed)) {
            this.funds -= amountOwed;
        }
    }
}
