# Task 7 – Override and Specialise Behaviour

## 1. Method Overriding

Method overriding occurs when a subclass provides its own implementation of a method inherited from its superclass.

In the Campus Smart-Parking System, different vehicle types may have different parking fees. Therefore, each subclass can override the `calculateFee()` method.

## 2. Example of Method Overriding

```java
class Vehicle {
    double calculateFee() {
        return 0.0;
    }
}

class TwoWheeler extends Vehicle {
    @Override
    double calculateFee() {
        return 30.0;
    }
}

class Car extends Vehicle {
    @Override
    double calculateFee() {
        return 90.0;
    }
}
```

Here, `TwoWheeler` and `Car` provide their own implementations of `calculateFee()`.

## 3. Rules of Method Overriding

* The subclass method must have the same method name and parameter list.
* The return type must be the same or a permitted covariant return type.
* The overriding method cannot have more restrictive access than the inherited method.
* A `final` method cannot be overridden.
* The `@Override` annotation helps the compiler detect incorrect overriding.

## 4. Use of the `final` Keyword

The `final` keyword can be used in different ways:

* **Final variable:** Its value cannot be reassigned after initialization.
* **Final method:** It cannot be overridden by a subclass.
* **Final class:** It cannot be extended.

For example, a fixed parking-rate constant can be declared as:

```java
static final double CAR_RATE = 90.0;
```

## 5. Overriding `toString()`, `equals()` and `hashCode()`

* **`toString()`:** Returns a readable description of a vehicle.
* **`equals()`:** Compares two vehicles using their registration numbers.
* **`hashCode()`:** Generates a hash value consistent with `equals()`.

If two vehicles have the same registration number and are considered equal, their `hashCode()` values must also be equal.

These methods help the system display vehicle details and identify duplicate registrations.

## 6. Alternative Concept: Using a `switch` Statement

An alternative design uses a single `calculateFee()` method with a vehicle-type field and a `switch` statement.

**Method overriding:**

* Each vehicle subclass contains its own fee calculation.
* A new vehicle category can be added as a subclass.
* Existing fee methods can remain unchanged when the design is extensible.

**Switch statement:**

* All vehicle rates are handled in one method.
* Adding a new type usually requires modifying the central method.
* The method becomes harder to maintain as the number of categories grows.

Both approaches can calculate a fee in \(O(1)\) time when the vehicle type and rate are already known. However, overriding generally offers better extensibility for an object-oriented design.

## Conclusion

Method overriding allows each vehicle subclass to calculate its fee according to its own rules. The `@Override` annotation improves reliability, while `toString()`, `equals()` and `hashCode()` support readable output and consistent vehicle identification.
