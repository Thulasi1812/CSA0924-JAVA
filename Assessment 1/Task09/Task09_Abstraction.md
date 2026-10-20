# Task 9 – Abstraction and Interfaces

## 1. Abstraction

Abstraction is an object-oriented programming concept that hides implementation details and shows only essential features.

In the campus smart-parking system, an abstract `Vehicle` class defines common properties and methods for all vehicles.

## 2. Abstract Class

An abstract class cannot be instantiated directly. It can contain abstract methods and concrete methods.

Example:

```java
abstract class Vehicle {
    String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    abstract double calculateFee(int hours);
}
```

Every subclass must implement the abstract `calculateFee()` method unless the subclass is also abstract.

## 3. Interfaces

An interface defines a contract that implementing classes must follow.

Example:

```java
interface Chargeable {
    void chargeBattery();
}

interface Payable {
    double calculatePayment();
}
```

The `Chargeable` interface can represent vehicles that support charging, while `Payable` can represent objects that calculate payments.

A class implements an interface using the `implements` keyword.

```java
class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String registrationNumber) {
        super(registrationNumber);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 70.0;
    }

    @Override
    public void chargeBattery() {
        System.out.println("Battery charging");
    }
}
```

## 4. Advantages in the Parking System

* Abstraction hides unnecessary implementation details.
* Abstract classes provide common properties and behavior.
* Interfaces allow unrelated classes to follow the same contract.
* New vehicle categories can be added more easily.
* The design becomes easier to maintain and test.

## 5. Alternative Approach

An alternative is to use one concrete `Vehicle` class with conditional statements to calculate fees for different vehicle types.

However, this approach becomes harder to maintain when new vehicle types are added. Abstract classes and interfaces provide a more flexible and extensible design.

For a single fee calculation, the time complexity is **O(1)**. Processing `n` vehicles takes **O(n)** time.
