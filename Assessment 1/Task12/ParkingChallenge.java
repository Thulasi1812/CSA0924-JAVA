
interface ParkingPass {
    boolean isValid();
}

class OneDayPass implements ParkingPass {
    public boolean isValid() {
        return true;
    }
}

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int minutes, int hour);
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    double calculateFee(int minutes, int hour) {
        int hours = (minutes + 59) / 60;
        return hours * 30;
    }
}

class EBike extends Vehicle {
    EBike(String regNo) {
        super(regNo);
    }

    double calculateFee(int minutes, int hour) {
        return 20;
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) {
        super(regNo);
    }

    double calculateFee(int minutes, int hour) {
        int hours = (minutes + 59) / 60;
        double rate = (hour >= 9 && hour < 17) ? 60 : 30;
        return hours * rate;
    }
}

public class ParkingChallenge {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new Car("TN01AB1234"),
            new EBike("TN02CD5678"),
            new DeliveryVan("TN03EF9012")
        };

        for (Vehicle v : vehicles) {
            System.out.println(v.regNo + " Fee: Rs "
                    + v.calculateFee(120, 10));
        }

        ParkingPass pass = new OneDayPass();
        System.out.println("One-day pass valid: " + pass.isValid());

        int[] slotsPerFloor = {20, 30, 50, 40, 60};
        System.out.println("Number of floors: " + slotsPerFloor.length);
    }
}