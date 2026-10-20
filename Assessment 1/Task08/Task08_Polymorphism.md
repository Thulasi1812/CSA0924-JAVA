# Task 8 – Polymorphism and Method Overloading

## 1. Polymorphism

Polymorphism means “one name, many forms.” In Java, it allows the same method to behave differently depending on the object.

There are two types:

* **Compile-time polymorphism:** Achieved through method overloading.
* **Runtime polymorphism:** Achieved through method overriding.

## 2. Method Overloading

Method overloading means defining multiple methods with the same name but different parameter lists.

Example:

```java
double calculateFee(int hours) {
    return hours * 30.0;
}

double calculateFee(int hours, double rate) {
    return hours * rate;
}
```

The compiler selects the appropriate method based on the arguments.

## 3. Runtime Polymorphism

Runtime polymorphism occurs when an overridden method is called using a parent-class reference. The method belonging to the actual object is executed.

Example:

```java
Vehicle v = new Car("TN02B2");
System.out.println(v.calculateFee(3));
```

If `Car` overrides `calculateFee()`, Java executes the `Car` implementation.

## 4. Upcasting and Dynamic Method Dispatch

Upcasting means storing a child-class object in a parent-class reference.

```java
Vehicle[] vehicles = {
    new TwoWheeler("TN01A1"),
    new Car("TN02B2"),
    new ElectricCar("TN03C3")
};
```

Each object can provide its own fee calculation. A loop can call the same method on every object without checking its type manually.

## 5. Expected Output for the Given FeeDemo Program

```text
TwoWheeler TN01A1 -> Rs 30.0
Car TN02B2 -> Rs 90.0
ElectricCar TN03C3 -> Rs 210.0
true
```

The final `true` indicates that the equality comparison in the provided program evaluates to true.

## 6. Alternative Approach and Complexity

An alternative is to use `instanceof` and conditional statements to identify each vehicle type and calculate its fee.

However, this approach requires additional conditions when new vehicle categories are introduced. Polymorphism is more flexible because each subclass implements its own fee calculation.

For a single fee calculation, the time complexity is **O(1)**. Processing `n` vehicles takes **O(n)** time, with **O(n)** space for storing the vehicle references.
