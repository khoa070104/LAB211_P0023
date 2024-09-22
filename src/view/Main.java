package view;

import controller.ShoppingManager;
import model.Fruit;

import java.util.Scanner;

public class Main {
    public static void printMenu(){
        System.out.println("FRUIT SHOP SYSTEM\n" +
                "1.\tCreate Fruit\n" +
                "2.\tView orders\n" +
                "3.\tShopping (for buyer)\n" +
                "4.\tExit\n");
    }
    public static void main(String[] args) {
        printMenu();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        ShoppingManager s = new ShoppingManager(sc);
        do{
            System.out.print("Enter your choice:");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    System.out.println("Enter id: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter name: ");
                    String name  = sc.nextLine();
                    System.out.println("Enter price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter origin: ");
                    String origin = sc.nextLine();
                    System.out.println("Enter quantity: ");
                    int quantity = Integer.parseInt(sc.nextLine());
                    s.addFruit(new Fruit(id,name,price,quantity,origin));
                    break;
                case 2:
                    s.viewOrder();
                    break;
                case 3:
                    s.shopping();
                    break;
                case 4:
                    System.out.println("Good bye!!");
                    break;
                default:
                    System.out.println("Invalid Choice!!");
                    break;
            }

        }while (choice != 4);
    }
}