package model;

public class Order {
    private int quantity;
    private Fruit fruit;
    private double price, total;

    public Order(int quantity, Fruit fruit) {
        this.quantity = quantity;
        this.fruit = fruit;
        this.price = fruit.getPrice();
        this.total = price * quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
