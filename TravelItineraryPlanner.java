import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class ItineraryItem {
    String destination;
    String activity;
    String date;

    public ItineraryItem(String destination, String activity, String date) {
        this.destination = destination;
        this.activity = activity;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Destination: " + destination + ", Activity: " + activity + ", Date: " + date;
    }
}

public class TravelItineraryPlanner {
    private List<ItineraryItem> itinerary;

    public TravelItineraryPlanner() {
        itinerary = new ArrayList<>();
    }

    public void addItem(String destination, String activity, String date) {
        itinerary.add(new ItineraryItem(destination, activity, date));
    }

    public void viewItinerary() {
        if (itinerary.isEmpty()) {
            System.out.println("Your itinerary is empty.");
            return;
        }

        System.out.println("Your Travel Itinerary:");
        for (int i = 0; i < itinerary.size(); i++) {
            System.out.println((i + 1) + ". " + itinerary.get(i));
        }
    }

    public static void main(String[] args) {
        TravelItineraryPlanner planner = new TravelItineraryPlanner();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTravel Itinerary Planner");
            System.out.println("1. Add Itinerary Item");
            System.out.println("2. View Itinerary");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();
                    System.out.print("Enter activity: ");
                    String activity = scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String date = scanner.nextLine();
                    planner.addItem(destination, activity, date);
                    System.out.println("Item added to itinerary.");
                    break;

                case 2:
                    planner.viewItinerary();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

