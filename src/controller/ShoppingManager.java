package controller;

import model.Customer;
import model.Fruit;
import model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingManager {
    List<Customer> listCus = new ArrayList<>();
    List<Fruit> listFruit = new ArrayList<>();
    Scanner sc ;

    public ShoppingManager(Scanner sc){
        this.sc = sc;
    }

    public Fruit getFruitById(int id) {
        for (Fruit fruit : listFruit) {
            if (fruit.getId() == id) {
                return fruit;
            }
        }
        return null;
    }
    public void addFruit(Fruit fruit) {
        if(getFruitById(fruit.getId()) != null) {
            System.out.println("Fruit is already existed!");
            return;
        }
        listFruit.add(fruit);
    }

    public void viewOrder(){
        for (Customer customer : listCus) {
            System.out.println("Customer: " + customer.getName());
            System.out.println("Product |   Quantity    |  Price    |   Total");
            for (int i = 0; i < customer.getListOrder().size(); i++) {
                String name = customer.getListOrder().get(i).getFruit().getName();
                int quantity = customer.getListOrder().get(i).getQuantity();
                double price = customer.getListOrder().get(i).getPrice();
                double total = customer.getListOrder().get(i).getTotal();
                System.out.printf("%s   |   %d          |   %f     |    %f  \n",name, quantity,price,total);
            }
            System.out.println("Total: " + customer.total());
        }
    }



    public void printListFruit(){
        System.out.println("List of Fruit:\n" +
                "| ++ Item ++ | ++ Fruit Name ++ | ++ Origin ++ | ++ Price ++ |  \n");
        for (Fruit f : listFruit){
            System.out.printf("|    %d      |   %s  |   %s  |   %f  |  \n",f.getId(),f.getName(),f.getOrigin(),f.getPrice());

        }
    }
    public void shopping(){
        String yesno = "n";
        List<Order> listOrder = new ArrayList<>();
        do {
            System.out.println("List of Fruit :");
            printListFruit();

            System.out.println("Please choose the fruit: ");
            int choice = Integer.parseInt(sc.nextLine());
            Fruit f = getFruitById(choice);
            if (f == null) {
                System.out.println("Fruit not exist !");
                return;
            }
            System.out.println("You selected:" + f.getName());
            System.out.print("Please input quantity: ");
            int quantity = Integer.parseInt(sc.nextLine());
            listOrder.add(new Order(quantity, f ));

            System.out.print("Do you want to order now (Y/N):");
            yesno = sc.nextLine();
        } while (yesno.equalsIgnoreCase("n"));
        System.out.println("Enter name:");
        String name = sc.nextLine();
        Customer c = new Customer(name , listOrder);
        listCus.add(c);
    }



}
