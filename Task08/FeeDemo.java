
interface Chargeable {
    double chargingFee(int kWh);
}

abstract class Vehicle {
    String regNo;
    double ratePerHour;

    Vehicle(String regNo, double ratePerHour) {
        this.regNo = regNo;
        this.ratePerHour = ratePerHour;
    }

    double calculateFee(int minutes) {
        int hours = (minutes + 59) / 60;
        return hours * ratePerHour;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle v = (Vehicle) obj;
            return regNo.equals(v.regNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) {
        super(regNo, 10);
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo, 30);
    }
}

class ElectricCar extends Car implements Chargeable {
    ElectricCar(String regNo) {
        super(regNo);
    }

    @Override
    public double chargingFee(int kWh) {
        return kWh * 12;
    }
}

public class FeeDemo {
    public static void main(String[] args) {
        Vehicle[] vehicles = {
            new TwoWheeler("TN01A1"),
            new Car("TN02B2"),
            new ElectricCar("TN03C3")
        };

        for (Vehicle v : vehicles) {
            double fee = v.calculateFee(130);

            if (v instanceof Chargeable) {
                fee += ((Chargeable) v).chargingFee(10);
            }

            System.out.println(
                v.getClass().getSimpleName() + " "
                + v.regNo + " -> Rs " + fee
            );
        }

        System.out.println(
            new Car("TN02B2").equals(
                new ElectricCar("TN02B2")
            )
        );
    }
}