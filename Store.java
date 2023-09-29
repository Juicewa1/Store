import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    private List<Bike> inventory = new ArrayList<>();
    private double totalPrice = 0;

    public Store() {
        // Hardcode products into the inventory
        inventory.add(new Bike("Kid's Bike", BikeCategory.MOUNTAIN_BIKE, 149.99));
        inventory.add(new Bike("Kid's Bike", BikeCategory.ROAD_BIKE, 129.99));
        inventory.add(new Bike("Kid's Bike", BikeCategory.BMX_BIKE, 89.99));
        inventory.add(new Bike("Kid's Bike", BikeCategory.CRUISER_BIKE, 109.99));
    }

    public void welcome() {
        System.out.println("Welcome to the Used Bikes for Kids Store!");
    }

    public void displayInventory() {
        System.out.println("Available Bikes:");
        for (int i = 0; i < inventory.size(); i++) {
            System.out.println((i + 1) + ". " + inventory.get(i));
        }
    }

    public void shop() {
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        while (continueShopping) {
            displayInventory();
            System.out.print("Enter the number of the bike you want to purchase (0 to finish shopping): ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= inventory.size()) {
                Bike selectedBike = inventory.get(choice - 1);
                totalPrice += selectedBike.getPrice();
                System.out.println("You've added " + selectedBike.getName() + " to your cart.");
            } else if (choice == 0) {
                continueShopping = false;
            } else {
                System.out.println("Invalid input. Please select a valid bike number.");
            }
        }

        System.out.println("Thank you for shopping with us!");
        System.out.println("Total Price: $" + totalPrice);

        // Handle payment and change (assuming cash payment)
        System.out.print("Enter the amount of cash you're paying with: $");
        double payment = scanner.nextDouble();
        double change = payment - totalPrice;
        if (change >= 0) {
            System.out.println("Change: $" + change);
        } else {
            System.out.println("Insufficient payment. Please pay the full amount.");
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.welcome();
        store.shop();
    }
}

