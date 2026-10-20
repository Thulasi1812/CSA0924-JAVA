# Task 10 – Packages, Access Modifiers and Encapsulation

## 1. Packages in Java

A package is used to group related classes and interfaces. It helps organize the Java program and avoid naming conflicts.

Example:

```java
package parking;
```

The `parking` package can contain classes such as `Vehicle`, `Car`, `ParkingTicket`, and `ParkingFacility`.

## 2. Access Modifiers

Java provides four access levels:

* **public:** Accessible from anywhere.
* **private:** Accessible only within the same class.
* **protected:** Accessible within the same package and by subclasses.
* **default:** Accessible within the same package.

These modifiers help control access to the data and methods of a class.

## 3. Encapsulation

Encapsulation means keeping data private and providing controlled access through public methods.

Example:

```java
class ParkingTicket {
    private String ticketNumber;
    private double fee;

    public ParkingTicket(String ticketNumber, double fee) {
        this.ticketNumber = ticketNumber;
        setFee(fee);
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        if (fee >= 0) {
            this.fee = fee;
        }
    }
}
```

The `private` fields prevent direct access from outside the class. The setter validates the fee and prevents negative values from being stored.

## 4. Autoboxing and Unboxing

Autoboxing converts a primitive value into its corresponding wrapper object. Unboxing converts a wrapper object into a primitive value.

Example:

```java
int count = 10;
Integer boxedCount = count;
int value = boxedCount;
```

Java also provides the `equals()` method to compare wrapper values. Using `==` on `Integer` objects can compare references rather than numerical values, so `equals()` is generally preferable for value comparison.

## 5. Importance in the Parking System

* Packages organize the parking system classes.
* Access modifiers protect important data.
* Encapsulation ensures that ticket fees and registration details are controlled.
* Validation prevents invalid values.
* Wrapper classes allow primitive values to be used where objects are required.

## 6. Alternative Approach and Complexity

An alternative is to declare fields as public and access them directly. However, this reduces data protection and allows invalid values to be assigned.

Encapsulation is safer and easier to maintain. Reading or updating a field through a simple getter or setter takes **O(1)** time.
