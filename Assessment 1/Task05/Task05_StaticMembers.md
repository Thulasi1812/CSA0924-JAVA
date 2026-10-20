# Task 5 – Apply Static Members and the Object Life Cycle

## 1. Static Variables

A static variable belongs to the class rather than to an individual object. It is shared by all objects of that class.

In the Campus Smart-Parking System, a static variable can maintain a unique ticket counter.

```java
static int ticketCounter = 0;
```

Whenever a new ticket is created, the counter can be incremented to generate a unique ticket number. An instance variable would maintain a separate counter for every ticket object and could produce duplicate numbers.

## 2. Static Methods and Static Blocks

A static method can be used to generate ticket numbers or perform operations that do not depend on a particular object.

A static block executes once when the class is initialized. It can be used to initialize shared configuration data when required.

## 3. Object Life Cycle

A `ParkingTicket` object is created when a vehicle enters the parking facility. The ticket stores information such as the ticket number, vehicle registration number, entry time and allocated slot.

When the vehicle leaves, the parking slot is released and the ticket is no longer needed for active parking.

An object becomes eligible for garbage collection when it is no longer reachable through active references. Java's garbage collector may reclaim its memory later; garbage collection is not guaranteed to happen immediately.

## 4. Passing and Returning Objects

Java passes object references by value. A method can receive a reference to a `ParkingTicket` object and access that object's fields and methods.

A method can also return a `ParkingTicket` object to provide the newly created ticket to the calling code.

## 5. Alternative Concept and Complexity Analysis

If the ticket counter is an instance variable of `ParkingFacility`, each facility maintains its own counter.

For example, the north-gate facility and south-gate facility could both generate ticket number `1`. This is acceptable only if ticket numbers are unique within each facility, not across the entire campus.

* **Static counter:** One shared counter is maintained for the class, using \(O(1)\) space for the counter.
* **Instance counter:** Each of \(k\) facility objects maintains its own counter, requiring \(O(k)\) total counter space.
* **Ticket storage:** Storing \(n\) ticket objects requires \(O(n)\) space.

If ticket numbers must be unique across all gates, a shared counter or a centralized ticket-number generator is appropriate.

## Conclusion

Static members are useful for shared information such as ticket numbering. Understanding the object life cycle helps the system manage ticket records and memory efficiently after vehicles leave the facility.
