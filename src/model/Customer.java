package model;

import java.util.List;

public class Customer {
    private String name;
    private List<Order> listOrder;

    public Customer(String name, List<Order> listOrder) {
        this.name = name;
        this.listOrder = listOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }
    public double total(){
        double total = 0;
        for (Order order : listOrder) {
            total += order.getTotal();
        }
        return total;
    }
}
