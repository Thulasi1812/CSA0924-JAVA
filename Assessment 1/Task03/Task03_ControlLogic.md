# Task 3 – Design the Control Logic

## 1. Slot Allocation Logic

The system searches each floor and each slot to find the first available parking slot. If a free slot is found, the vehicle number is stored and the floor and slot numbers are returned. If all slots are occupied, the method returns `null`.

### Pseudocode

**Algorithm: Allocate Slot**

1. START
2. Receive the vehicle registration number.
3. FOR each floor:

   * FOR each slot on that floor:

     * IF the slot is empty:

       * Store the vehicle registration number.
       * Return the floor number and slot number.
4. Return `null` if no slot is available.
5. STOP.

## 2. Parking Fee Calculation

The parking fee depends on the vehicle type and parking duration. The system calculates the number of chargeable hours and applies the appropriate fee rule.

### Pseudocode

**Algorithm: Calculate Parking Fee**

1. START
2. Read the vehicle type and parking duration in minutes.
3. IF the duration is invalid, reject the input.
4. Convert the duration into chargeable hours using ceiling division.
5. IF the vehicle is a two-wheeler, apply the two-wheeler rate.
6. ELSE IF the vehicle is a car, apply the car rate.
7. ELSE IF the vehicle is an electric vehicle, calculate the parking fee and applicable charging fee separately.
8. Apply any valid monthly-pass exemption.
9. Return the total fee.
10. STOP.

*Note: The exact fee rates and fee slabs must follow the rules implemented in the program.*

## 3. Use of Control Statements

* **for loop:** Searches the floors and slots.
* **if–else:** Checks whether a slot is free and selects the fee rule.
* **break:** Stops a loop when no further search is needed.
* **continue:** Skips an unsuitable or occupied slot.
* **return:** Returns the allocated slot, calculated fee or `null` when allocation fails.

If the parking facility is full, the system must not allocate an occupied slot. It should indicate that no slot is available.

## 4. Alternative Concept and Complexity Analysis

The current implementation scans the slots sequentially.

Let `F` be the number of floors and `S` be the maximum number of slots per floor.

* **Allocation:** Worst-case time complexity is \(O(F \times S)\), because the system may inspect every slot.
* **Release:** Time complexity is \(O(1)\), because the method checks the specified floor and slot directly.
* **Space complexity:** The parking array requires \(O(F \times S)\) space in the worst case.

An alternative is to maintain a stack of free slot positions for each floor. Allocation and release can then take \(O(1)\) time when a suitable free position is available and the stack is correctly maintained. The additional stack storage is proportional to the number of slots, \(O(F \times S)\).

## Conclusion

The control logic uses loops and conditional statements to allocate and release parking slots safely. Sequential searching is simple to implement, while a stack of free positions can improve allocation efficiency for larger parking facilities.
