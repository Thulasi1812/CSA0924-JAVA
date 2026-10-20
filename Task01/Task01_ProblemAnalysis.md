# Task 1: Problem Analysis – Campus Smart-Parking System

## 1. Aim

To analyse the Campus Smart-Parking System, identify the main classes, define business rules and assumptions, and compare alternative object-oriented designs.

## 2. Problem Description

The campus requires a smart-parking system to manage parking slots for two-wheelers, cars and electric vehicles. The system should allocate available slots, record vehicle entry times, generate unique parking tickets and calculate parking fees. Electric vehicles use designated charging slots and pay additional charging fees. Students and staff with valid monthly passes can park without paying parking fees, while visitors must pay.

## 3. Candidate Classes

| Class           | Responsibilities                                     |
| --------------- | ---------------------------------------------------- |
| Vehicle         | Stores registration number and vehicle details       |
| TwoWheeler      | Represents a two-wheeler                             |
| Car             | Represents a car                                     |
| ElectricCar     | Represents an electric car and charging requirements |
| ParkingSlot     | Stores slot number, floor and availability           |
| ParkingFloor    | Manages parking slots on a floor                     |
| ParkingTicket   | Stores ticket number, vehicle and entry time         |
| ParkingFacility | Allocates and releases slots and manages occupancy   |
| User            | Stores user details                                  |
| MonthlyPass     | Represents a valid monthly parking pass              |

## 4. Business Rules

1. Every vehicle must have a unique registration number.
2. Each occupied parking slot can contain only one vehicle.
3. A vehicle must be assigned an available slot suitable for its type.
4. Every parking session must have a unique ticket and entry time.
5. Parking fees depend on vehicle type and parking duration.
6. Electric vehicles must use designated charging slots when charging is required.
7. Charging fees are calculated separately from parking fees.
8. Valid monthly passes allow eligible students and staff to park without parking fees.
9. Visitors without a valid pass must pay the applicable parking fee.
10. A slot becomes available after the vehicle exits.

## 5. Assumptions

* Vehicle registration numbers are entered correctly.
* Parking duration is calculated from entry and exit times.
* Parking rates are configurable.
* The system validates slot availability before allocation.
* Monthly passes are checked for validity.
* Charging costs are recorded separately.
* Invalid registrations, occupied slots and unavailable slots are handled appropriately.

## 6. Alternative Design Approaches

### Approach A: Parallel String Arrays

Vehicle registration numbers and other details are stored in separate arrays.

**Advantages:**

* Simple to implement.
* Suitable for small amounts of data.

**Disadvantages:**

* Data can become inconsistent when array positions do not match.
* Adding new vehicle attributes requires modifying multiple arrays.
* Vehicle-specific behaviour is difficult to manage.

### Approach B: Vehicle Objects

Each vehicle is represented by an object containing its attributes and related methods.

**Advantages:**

* Data and behaviour are organised together.
* New vehicle types can be added through inheritance.
* The design supports encapsulation and polymorphism.
* The system is easier to maintain and extend.

**Disadvantages:**

* Requires more initial class design.
* Object relationships must be managed carefully.

## 7. Complexity Analysis

Let `n` represent the number of registered vehicles.

| Operation                     | Parallel Arrays                        | Vehicle Objects                     |
| ----------------------------- | -------------------------------------- | ----------------------------------- |
| Search by registration number | O(n)                                   | O(n) using a linear search          |
| Add a vehicle                 | O(1) if an array position is available | O(1) amortized with a dynamic list  |
| Access vehicle attributes     | O(1) by index                          | O(1) using object fields or getters |
| Space complexity              | O(n)                                   | O(n)                                |

Both designs require O(n) space for storing n vehicles. A HashMap indexed by registration number can improve average search time to O(1), although the basic object-list design uses O(n) search.

## 8. Conclusion

The object-oriented approach is more suitable for the Campus Smart-Parking System because it supports encapsulation, inheritance and polymorphism. It allows the system to manage different vehicle types and extend its features with fewer changes to existing code.
