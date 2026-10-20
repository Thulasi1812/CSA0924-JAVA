
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] vehicles = new String[3];
        int[] entryTime = new int[3];

        System.out.println("Campus Smart Parking System");

        for (int i = 0; i < vehicles.length; i++) {
            System.out.print("Enter vehicle number (or STOP): ");
            String regNo = sc.nextLine();

            if (regNo.equalsIgnoreCase("STOP")) {
                break;
            }

            System.out.print("Enter parking duration in minutes: ");
            int minutes = sc.nextInt();
            sc.nextLine();

            if (minutes < 0) {
                System.out.println("Invalid duration");
                i--;
                continue;
            }

            vehicles[i] = regNo;
            entryTime[i] = minutes;

            int hours = (minutes + 59) / 60;
            int fee = hours * 30;

            System.out.println("Vehicle: " + vehicles[i]);
            System.out.println("Fee: Rs " + fee);
        }

        System.out.println("Parking session completed.");
        sc.close();
    }
}