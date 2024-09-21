import java.util.ArrayList;
import java.util.Scanner;

class Assignment {
    String title;
    String type;
    int maxPoints;
    int pointsEarned;

    public Assignment(String title, String type, int maxPoints, int pointsEarned) {
        this.title = title;
        this.type = type;
        this.maxPoints = maxPoints;
        this.pointsEarned = pointsEarned;
    }

    public double getPercentage() {
        return (double) pointsEarned / maxPoints * 100;
    }
}

public class GradeTracker {
    private ArrayList<Assignment> assignments;

    public GradeTracker() {
        assignments = new ArrayList<>();
    }

    public void addAssignment(String title, String type, int maxPoints, int pointsEarned) {
        assignments.add(new Assignment(title, type, maxPoints, pointsEarned));
    }

    public double calculateAverage() {
        int totalPointsEarned = 0;
        int totalMaxPoints = 0;

        for (Assignment assignment : assignments) {
            totalPointsEarned += assignment.pointsEarned;
            totalMaxPoints += assignment.maxPoints;
        }

        return (double) totalPointsEarned / totalMaxPoints * 100;
    }

    public void displayAssignments() {
        System.out.println("Assignments:");
        for (Assignment assignment : assignments) {
            System.out.println("Title: " + assignment.title + ", Type: " + assignment.type +
                    ", Max Points: " + assignment.maxPoints + ", Points Earned: " + assignment.pointsEarned +
                    ", Percentage: " + assignment.getPercentage() + "%");
        }
    }

    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Assignment");
            System.out.println("2. View Assignments");
            System.out.println("3. Calculate Average Percentage");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter assignment title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter assignment type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter max points: ");
                    int maxPoints = scanner.nextInt();
                    System.out.print("Enter points earned: ");
                    int pointsEarned = scanner.nextInt();
                    tracker.addAssignment(title, type, maxPoints, pointsEarned);
                    break;

                case 2:
                    tracker.displayAssignments();
                    break;

                case 3:
                    double average = tracker.calculateAverage();
                    System.out.println("Average Percentage: " + average + "%");
                    break;

                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

