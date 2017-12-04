import java.util.ArrayList;

    public class ItemStock implements Stockable {
        private ArrayList<Sellable> stockList;

        public ItemStock() {
            this.stockList = new ArrayList();
        }
        public void addToStock(Sellable item) {
            stockList.add(item);
        }
        public void removeFromStock(Sellable item) {
            stockList.remove(item);
        }
        public ArrayList<Sellable> getStockList() {
            return new ArrayList(stockList);
        }
}
