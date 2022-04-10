package SKU;

import java.util.List;

public class Order {
    private Customer customer;
    private List<Product> items;
    private int orderId;
    private boolean complete;
    public Order(Customer customer, List<Product> items, int orderId, boolean complete) {
        this.customer = customer;
        this.items = items;
        this.orderId = orderId;
        this.complete = complete;
    }
    public Order() {
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<Product> getItems() {
        return items;
    }
    public void setItems(List<Product> items) {
        this.items = items;
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public boolean isComplete() {
        return complete;
    }
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public double getTotalCost() {
        return 0;
    }
    @Override
    public String toString() {
        return "Order [customer=" + customer + ", items=" + items + ", orderId=" + orderId + ", complete=" + complete
                + "]";
    }


}
