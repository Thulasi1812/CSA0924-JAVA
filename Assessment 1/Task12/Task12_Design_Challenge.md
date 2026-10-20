# Task 12 – Design Challenge: Extending the Campus Smart-Parking System

## A. Impact Analysis

The new requirements introduce e-bikes, delivery vans, visitor one-day passes, and different parking capacities on five floors.

The existing system must be flexible enough to support these changes without rewriting the entire program.

* **E-bikes:** Require a fixed parking fee.
* **Delivery vans:** Pay twice the normal car rate between 9:00 AM and 5:00 PM.
* **Visitor one-day pass:** Allows a visitor to park under the conditions defined by the pass.
* **Five floors:** Each floor can have a different number of parking slots.

These changes affect vehicle classification, pricing, pass validation, and parking-slot management.

## B. Evaluation of the Original Design

A design that uses a single vehicle class with many `if-else` statements can become difficult to maintain when new vehicle categories are added.

Similarly, fixed-size arrays may not be suitable when different floors have different capacities.

A better design separates vehicle information, pricing rules, passes, and slot allocation. This makes the system easier to extend and test.

## C. Proposed Redesigned System

### 1. Vehicle Hierarchy

Use an abstract `Vehicle` class for common information such as registration number and entry time.

Subclasses can include:

* `TwoWheeler`
* `Car`
* `ElectricCar`
* `EBike`
* `DeliveryVan`

Each subclass can implement the appropriate behavior when necessary.

### 2. Different Floor Capacities

Use a jagged array to store different numbers of slots on each floor.

```java
boolean[][] slots = {
    new boolean[20],
    new boolean[30],
    new boolean[50],
    new boolean[40],
    new boolean[60]
};
```

Here, `false` indicates a free slot and `true` indicates an occupied slot. Each floor can have a different capacity.

### 3. Pass Interface

Define a `Pass` interface to represent parking-pass validation.

```java
interface Pass {
    boolean isValid();
}
```

A `OneDayPass` class can implement this interface and check whether the visitor's pass is valid for the parking date.

### 4. PricingRule Interface

Use a separate interface for fee calculation.

```java
interface PricingRule {
    double calculateFee(Vehicle vehicle, int minutes);
}
```

Different pricing classes can implement this interface for cars, e-bikes, electric vehicles, and delivery vans.

The delivery-van pricing rule should check whether the parking time falls within the specified 9:00 AM–5:00 PM period and apply twice the normal car rate as required.

The e-bike pricing rule should apply a fixed fee. The exact amount should be defined in the system's pricing configuration.

## D. Justification and Trade-Offs

The redesigned system follows object-oriented principles.

* **Encapsulation:** Protects vehicle, ticket, and slot data.
* **Inheritance:** Shares common vehicle properties.
* **Polymorphism:** Allows different vehicle types to use different pricing behavior.
* **Abstraction:** Hides implementation details behind interfaces.
* **Extensibility:** New vehicle categories and pricing rules can be added with fewer changes to existing code.

### Trade-Offs

The redesigned system requires more classes and interfaces, which increases initial development effort. However, it improves maintainability and makes future changes easier.

The jagged array supports different floor capacities, but the system must validate floor and slot indexes carefully.

## Conclusion

The proposed design supports new vehicle categories, flexible pricing rules, visitor passes, and different floor capacities. Separating pricing from vehicle classes makes the campus smart-parking system more modular, reusable, and easier to maintain.
