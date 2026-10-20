# Task 11 – Complete System Testing and Validation

## 1. Introduction

Testing and validation ensure that the campus smart-parking system works correctly for different vehicles, parking durations, and slot conditions. The system should calculate fees correctly, release slots, and handle invalid inputs.

## 2. Test Cases

| Test Case                 | Input or Condition                         | Expected Result                               |
| ------------------------- | ------------------------------------------ | --------------------------------------------- |
| 1. Normal entry           | Valid vehicle registration                 | Vehicle is accepted and a ticket is generated |
| 2. Normal exit            | Vehicle has a valid parking ticket         | Fee is calculated and the slot is released    |
| 3. Last available slot    | Only one slot is free                      | Vehicle is allocated that slot                |
| 4. Full parking           | No slots are available                     | Entry is rejected with an appropriate message |
| 5. Zero-minute parking    | Parking duration is 0 minutes              | Fee follows the defined zero-duration rule    |
| 6. Fee boundary           | Duration is exactly at a fee-slab boundary | Correct fee slab is applied                   |
| 7. Unknown vehicle type   | Unsupported vehicle category               | Input is rejected or handled safely           |
| 8. Duplicate registration | Same registration is entered twice         | Duplicate entry is prevented                  |
| 9. Invalid slot           | Slot index is outside the valid range      | Invalid slot is rejected safely               |

**Note:** These are proposed test cases. Actual results must be recorded after executing the program. The exact fee and boundary results depend on the implemented pricing rules.

## 3. Manual Fee Calculation

Assume the parking fee is Rs. 30 per hour or part thereof.

For a parking duration of 90 minutes:

Number of billable hours = ceiling(90 / 60) = 2

Total fee = 2 × Rs. 30 = **Rs. 60**

This manual calculation can be compared with the program output to validate the fee calculation.

## 4. Evaluation of Object-Oriented Principles

* **Encapsulation:** Protects vehicle and ticket data.
* **Inheritance:** Allows different vehicle categories to share common properties.
* **Polymorphism:** Allows each vehicle type to calculate its fee differently.
* **Abstraction:** Hides unnecessary implementation details.
* **Modularity:** Separates vehicle, ticket, pricing, and parking management responsibilities.

## 5. Alternative Data Structures

An array can represent a fixed number of parking slots. However, it is less flexible when capacity changes.

An `ArrayList` supports dynamic addition and removal of elements. A `HashMap` can provide efficient average-case lookup of vehicles using registration numbers.

| Data Structure | Advantage                      | Limitation                                    |
| -------------- | ------------------------------ | --------------------------------------------- |
| Array          | Simple and fast indexed access | Fixed size                                    |
| ArrayList      | Dynamic size                   | Searching by registration may take O(n)       |
| HashMap        | Average O(1) lookup by key     | Requires key management and additional memory |

## 6. Conclusion

Testing helps identify errors in slot allocation, fee calculation, vehicle entry, and exit. A reliable parking system should validate inputs, prevent duplicate entries, handle full capacity, and calculate fees according to the specified rules.

The actual test results should be documented based on the executed Java program.
