import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    int roomNumber;
    boolean isBooked;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }
}

class Reservation {
    String guestName;
    int roomNumber;

    public Reservation(String guestName, int roomNumber) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName + ", Room Number: " + roomNumber;
    }
}

public class HotelReservationSystem {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelReservationSystem(int numberOfRooms) {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();

        for (int i = 1; i <= numberOfRooms; i++) {
            rooms.add(new Room(i));
        }
    }

    public void viewAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked) {
                System.out.println("Room Number: " + room.roomNumber);
            }
        }
    }

    public boolean reserveRoom(String guestName, int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && !room.isBooked) {
                room.isBooked = true;
                reservations.add(new Reservation(guestName, roomNumber));
                System.out.println("Room " + roomNumber + " reserved for " + guestName + ".");
                return true;
            }
        }
        System.out.println("Room " + roomNumber + " is already booked or does not exist.");
        return false;
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No current reservations.");
            return;
        }

        System.out.println("Current Reservations:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }

    public static void main(String[] args) {
        HotelReservationSystem system = new HotelReservationSystem(10); // Initialize with 10 rooms
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHotel Reservation System");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Reserve Room");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    system.viewAvailableRooms();
                    break;

                case 2:
                    System.out.print("Enter guest name: ");
                    String guestName = scanner.nextLine();
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    system.reserveRoom(guestName, roomNumber);
                    break;

                case 3:
                    system.viewReservations();
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


