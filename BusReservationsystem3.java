import java.util.Scanner;

// base class
class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Abstract Ticket 
abstract class Ticket extends Person {
    protected int seatNumber;

    public Ticket(String name, int age, int seatNumber) {
        super(name, age);
        this.seatNumber = seatNumber;
    }

    public abstract void calculateFare();

    public void displayTicketInfo() {
        super.displayInfo();
        System.out.println("Seat Number: " + seatNumber);
    }
}


class BusTicket extends Ticket {
    private static final double BASE_FARE = 20.0;
    private static final double DISCOUNT_RATE = 0.1;

    public BusTicket(String name, int age, int seatNumber) {
        super(name, age, seatNumber);
    }

    @Override
    public void calculateFare() {
        double fare = BASE_FARE - (age < 12 ? BASE_FARE * DISCOUNT_RATE : 0);
        System.out.println("Total Fare: $" + fare);
    }
}


public final class BusReservationsystem3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passenger age: ");
        int age = scanner.nextInt();

        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();

        BusTicket busTicket = new BusTicket(name, age, seatNumber);
        busTicket.displayTicketInfo();
        busTicket.calculateFare();

        scanner.close();
    }
}
