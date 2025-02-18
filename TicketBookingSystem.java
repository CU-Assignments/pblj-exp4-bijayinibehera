import java.util.Scanner;

public class TicketBookingSystem {

    private boolean[] seats;  // Array to track seat availability

    public TicketBookingSystem(int numSeats) {
        seats = new boolean[numSeats];  // Initialize all seats as available (false)
    }

    // Book a seat (synchronized)
    public synchronized void bookSeat(int seatNumber) {
        // Check if the seat is available
        if (seatNumber >= 0 && seatNumber < seats.length) {
            if (!seats[seatNumber]) {
                seats[seatNumber] = true;  // Mark the seat as booked
                System.out.println("Seat " + seatNumber + " booked successfully.");
            } else {
                System.out.println("Seat " + seatNumber + " is already booked.");
            }
        } else {
            System.out.println("Invalid seat number: " + seatNumber);
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem(5);  // 5 seats available
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Available seats: 0, 1, 2, 3, 4");
            System.out.print("Enter the seat number to book (or -1 to exit): ");
            int seatNumber = scanner.nextInt();

            if (seatNumber == -1) {
                System.out.println("Exiting program.");
                break;  // Exit the program
            }

            bookingSystem.bookSeat(seatNumber);  // Book the selected seat
        }

        scanner.close();  // Close the scanner
    }
}

/*
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): 1
Seat 1 booked successfully.
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): 4
Seat 4 booked successfully.
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): 3
Seat 3 booked successfully.
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): 0
Seat 0 booked successfully.
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): 2
Seat 2 booked successfully.
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): 2
Seat 2 is already booked.
Available seats: 0, 1, 2, 3, 4
Enter the seat number to book (or -1 to exit): -1
Exiting program.
 */