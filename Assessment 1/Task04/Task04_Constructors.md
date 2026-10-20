# Task 4 – Design Classes, Objects and Constructors

## 1. Classes and Objects

A class is a blueprint for creating objects. An object is an instance of a class.

In the Campus Smart-Parking System, the main classes are:

* **Vehicle:** Stores registration number and vehicle details.
* **ParkingTicket:** Stores ticket number, vehicle details, entry time and parking slot.
* **ParkingFacility:** Manages floors, slots, vehicle allocation and release.
* **ParkingPass:** Represents a valid monthly pass for eligible students and staff.

Each class has a specific responsibility, which makes the system easier to maintain.

## 2. Constructors in Java

A constructor initializes an object when it is created.

**Default constructor:** Initializes an object with default values when a suitable constructor is provided or Java supplies the implicit default constructor.

**Parameterized constructor:** Accepts values to initialize an object.

```java
class ParkingTicket {
    String ticketNo;
    String vehicleNo;

    ParkingTicket(String ticketNo, String vehicleNo) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
    }
}
```

**Overloaded constructors:** A class can have multiple constructors with different parameter lists. This allows objects to be created in different ways.

## 3. Use of `this` and Constructor Chaining

The `this` keyword refers to the current object. It distinguishes instance variables from parameters with the same name.

Constructor chaining uses `this()` to call another constructor in the same class. It avoids repeated initialization code.

Example:

```java
class ParkingTicket {
    String ticketNo;
    String vehicleNo;

    ParkingTicket(String ticketNo) {
        this(ticketNo, "UNKNOWN");
    }

    ParkingTicket(String ticketNo, String vehicleNo) {
        this.ticketNo = ticketNo;
        this.vehicleNo = vehicleNo;
    }
}
```

## 4. Copy Constructor

A copy constructor creates a new object using the values of an existing object. Java does not automatically provide a copy constructor; the programmer must define one.

It may be useful when creating a duplicate ticket record. However, the new ticket should receive a unique ticket number to prevent duplication in the parking system.

## 5. Stack and Heap Memory

Local reference variables are generally stored in a method's stack frame, while objects created using `new` are stored on the heap.

For example:

```java
ParkingTicket ticket = new ParkingTicket("T101", "TN01AB1111");
```

Here, `ticket` is a reference variable and the `ParkingTicket` object is created on the heap.

## 6. Alternative Concept and Complexity Analysis

**Default constructor followed by setters:** The object is created first and its values are assigned later. This is flexible, but an object may temporarily contain invalid or incomplete data.

**Static factory method:** A static method creates and returns an object. It can validate input before creating the object and can use a meaningful method name.

For creating \(n\) tickets, both approaches generally require \(O(n)\) total time and \(O(n)\) space if all ticket objects are retained. Each individual object requires constant-time initialization, assuming a fixed number of fields.

Parameterized constructors provide a simple way to initialize valid objects immediately. Static factory methods are useful when object creation requires additional validation or different creation options.

## Conclusion

Classes organize the parking system into manageable components. Constructors initialize objects, `this` avoids naming conflicts, constructor chaining reduces repeated code, and proper object creation helps maintain valid parking records.
