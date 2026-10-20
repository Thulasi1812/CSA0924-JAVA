# Task 2 – Data Types and Data Structures

## 1. Selection of Data Types

The Campus Smart-Parking System uses suitable Java data types to store parking information.

* `int` – stores floor numbers, slot numbers and parking duration in minutes.
* `String` – stores vehicle registration numbers, vehicle types and ticket numbers.
* `double` – stores parking fees and EV charging fees.
* `boolean` – indicates whether a parking slot is occupied or free.
* `Vehicle` objects – store the details of each vehicle.

Using suitable data types improves readability and reduces errors.

## 2. Data Structure for Parking Slots

A two-dimensional or jagged array can represent parking slots on different floors.

Example:

```java
boolean[][] slots = {
    new boolean[20],
    new boolean[30],
    new boolean[50]
};
```

Here, `false` represents a free slot and `true` represents an occupied slot. A jagged array allows each floor to have a different number of parking slots.

## 3. Type Conversion and Precision

Java supports automatic type conversion and explicit type casting. For example, an integer can be converted to a double automatically.

```java
int minutes = 90;
double hours = minutes / 60.0;
System.out.println(hours);
```

Output:

```text
1.5
```

Using `60.0` avoids integer division. For financial calculations, `BigDecimal` can be used when accurate decimal arithmetic is required.

## 4. Scanner vs Command-Line Arguments

**Scanner:** Reads input from the keyboard while the program is running.

```java
Scanner sc = new Scanner(System.in);
int floor = sc.nextInt();
```

**Command-line arguments:** Accept input when the program starts. The arguments are received as strings and may need conversion.

```java
int floor = Integer.parseInt(args[0]);
```

Scanner is suitable for interactive parking-system input, while command-line arguments are useful for automated testing.

## 5. Alternative Data Structures

### One-Dimensional Array

A one-dimensional array can store all slots using a single index. The floor and slot number must be calculated from that index.

* Access time: O(1)
* Searching for a free slot: O(n)
* Limitation: Floor-wise management is less convenient.

### Jagged Array

A jagged array stores a separate array for each floor.

* Access time: O(1)
* Searching all slots: O(n)
* Advantage: Different floors can have different capacities.

### ArrayList

An `ArrayList` can store parking-slot objects and can grow dynamically.

* Access by index: O(1)
* Searching for a free slot: O(n)
* Advantage: Easier to add or remove slot objects dynamically.

## Conclusion

For the Campus Smart-Parking System, a jagged array is suitable because each floor can have a different capacity. An `ArrayList` is an alternative when the system needs more flexible slot management.
ss