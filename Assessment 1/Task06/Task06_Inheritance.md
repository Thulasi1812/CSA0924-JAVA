# Task 6 – Design the Inheritance Hierarchy

## 1. Inheritance in Java

Inheritance allows one class to acquire the fields and methods of another class. It supports code reuse and helps organize related vehicle types.

For the Campus Smart-Parking System, `Vehicle` can be the superclass, with `TwoWheeler`, `Car` and `ElectricCar` as subclasses.

## 2. Class Hierarchy

```text
             Vehicle
            /   |    \
           /    |     \
 TwoWheeler    Car    ElectricCar
```

This is an example of hierarchical inheritance because multiple subclasses inherit from one superclass.

## 3. Inherited and Specialized Members

**Vehicle**

* Registration number
* Constructor to initialize common vehicle details
* `calculateFee()` method

**TwoWheeler**

* Inherits common vehicle details
* Provides two-wheeler-specific fee calculation

**Car**

* Inherits common vehicle details
* Provides car-specific fee calculation

**ElectricCar**

* Inherits vehicle details through the `Car` class if the design models an electric car as a specialized car
* Adds charging-related behaviour and charging fees

## 4. Use of `super`

The `super` keyword refers to the immediate superclass. It can call a superclass constructor or access an inherited method.

Example:

```java
class Vehicle {
    String registrationNo;

    Vehicle(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}

class Car extends Vehicle {
    Car(String registrationNo) {
        super(registrationNo);
    }
}
```

Here, `super(registrationNo)` calls the `Vehicle` constructor to initialize the registration number.

## 5. Constructor Execution Trace

When an `ElectricCar` object is created, constructors execute from the superclass to the subclass.

For the hierarchy `Vehicle → Car → ElectricCar`, the order is:

1. `Vehicle` constructor executes.
2. `Car` constructor executes.
3. `ElectricCar` constructor executes.

This ensures that common vehicle information is initialized before specialized electric-car information.

## 6. Alternative Concept: Composition

Instead of inheritance, the system could use a single `Vehicle` class containing a `VehicleType` object that stores the vehicle category and rate.

**Inheritance:**

* Each vehicle type has its own subclass.
* New categories can be represented by adding subclasses.
* Common fields and methods are inherited.

**Composition:**

* A `Vehicle` object contains a separate type or pricing object.
* Vehicle categories and pricing rules can be changed more flexibly.
* The design may require additional objects and configuration.

Both approaches can calculate fees in constant time, \(O(1)\), when the required rate is already available. Inheritance is suitable for the current vehicle hierarchy, while composition can be more flexible when categories and pricing rules change frequently.

## Conclusion

Inheritance organizes vehicles into a clear hierarchy and avoids repeating common fields and methods. The `super` keyword supports constructor chaining, and subclasses can specialize behaviour such as parking-fee calculation.
