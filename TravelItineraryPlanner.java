import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String preferences;
    double budget;

    Destination(String name, String date, String preferences, double budget) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\nDate: " + date + "\nPreferences: " + preferences + "\nBudget: $" + budget;
    }
}

public class TravelItineraryPlanner {
    private static ArrayList<Destination> destinations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDestination(scanner);
                    break;
                case 2:
                    viewItinerary();
                    break;
                case 3:
                    calculateTotalBudget();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using Travel Itinerary Planner. Safe travels!");
                    break;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        scanner.close();
    }

    private static void addDestination(Scanner scanner) {
        System.out.print("Enter destination name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter travel date (e.g., 2023-07-15): ");
        String date = scanner.nextLine();
        
        System.out.print("Enter your preferences (e.g., sightseeing, relaxation): ");
        String preferences = scanner.nextLine();
        
        System.out.print("Enter budget for this destination: $");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        destinations.add(new Destination(name, date, preferences, budget));
        System.out.println("Destination added successfully.");
    }

    private static void viewItinerary() {
        if (destinations.isEmpty()) {
            System.out.println("No destinations added yet.");
        } else {
            for (Destination destination : destinations) {
                System.out.println(destination);
                System.out.println();
            }
        }
    }

    private static void calculateTotalBudget() {
        double totalBudget = 0.0;
        for (Destination destination : destinations) {
            totalBudget += destination.budget;
        }
        System.out.println("Total budget for the trip: $" + totalBudget);
    }
}

}
