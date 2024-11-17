# Book Management System

## Overview
This system manages various types of books, including `Book`, `EBook`, and `AudioBook`. It allows for updating the status of these books (e.g., from `Available` to `CheckedOut`) while enforcing specific rules and behaviors for each type of book.

## Requirements

### General Requirements
- The system must be capable of updating the status of different book types while ensuring that specific conditions are met before applying the changes.
- The solution should demonstrate object-oriented principles, including:
    - **Generic Programming**: Reusable logic for different book types.
    - **Interface-Driven Design**: Leveraging interfaces to ensure consistent behaviors.
    - **Strategy Pattern Usage**: Handling specific behaviors for different book types.

### Specific Requirements for Each Book Type
1. **Book**
    - When a `Book` changes its status from `Available` to `CheckedOut`:
        - If the `Book` is in a `Reserved` state, the status change should be denied.
    - Example:
        - A `Book` with the status `Reserved` cannot be changed to `CheckedOut`.

2. **EBook**
    - When an `EBook` changes its status from `Available` to `CheckedOut`:
        - The system must verify if the user has sufficient access rights.
        - If the user's access level is insufficient, the status change should be denied.
    - Example:
        - An `EBook` with `accessLevel < 1` cannot be changed to `CheckedOut`.

3. **AudioBook**
    - When an `AudioBook` changes its status from `Available` to `CheckedOut`:
        - The system must ensure that the listener has a valid subscription.
        - If the listener does not have a valid subscription, the status change should be denied.
    - Example:
        - An `AudioBook` can only be checked out if the listener has a valid subscription (`hasValidSubscription = true`).

## Implementation Details
- Utilize a **generic class** to handle common logic for status updates across all book types.
- Leverage the **Strategy Pattern** to handle specific behaviors and validations for each book type.
- Ensure that each book type implements an `Updatable` interface to standardize the status update behavior.

## Follow SOLID Principles
1. **Single Responsibility Principle (SRP)**
   - Each class in the system has a single, well-defined responsibility:
   The `Book`, `EBook`, and `AudioBook` classes manage the state and data for individual books.
   `GenericBookStatusUpdater` handles the common logic for updating book status.
   Specific updater classes (e.g., `BookUpdater`, `EBookUpdater`, `AudioBookUpdater`) handle the unique validation rules for each type of book.
   The `BookRepository` interface abstracts data access, while its implementations handle the retrieval of books by status.
2. **Open/Closed Principle (OCP)**
   - The system is open for extension but closed for modification:
   New book types can be added by creating new classes and corresponding updater classes without modifying existing code.
   Validation rules can be extended by overriding the `validateStatusChange` method in the updater subclasses.
3. **Liskov Substitution Principle (LSP)**
   - Objects of subclasses (e.g., `EBook`, `AudioBook`) can be substituted for objects of the parent class (`Updatable`) without affecting the correctness of the program.
   The `GenericBookStatusUpdater` can operate on any type that implements the `Updatable` interface.
4. **Interface Segregation Principle (ISP)**
   - The `Updatable` interface is simple and focused, containing only the methods necessary for updating book status (`setStatus` and `getStatus`).
   Additional interfaces and abstractions can be introduced without forcing classes to implement methods they do not need.
5. **Dependency Inversion Principle (DIP)**
   - High-level modules, such as the updater classes, depend on abstractions (e.g., `BookRepository`) rather than concrete implementations.

## Example Usage
The system should include a `Main` class that demonstrates:
1. Updating the status of `Book`, `EBook`, and `AudioBook` instances.
2. Handling validation failures (e.g., trying to check out a reserved `Book` or an `EBook` with insufficient access).
3. Logging status changes for `AudioBook`.

## How to Run
1. Compile all classes.
2. Run the `Main` class to see the behavior and validation in action.

---

This `README.md` file serves as a guide for understanding and working with the Book Management System's requirements and features.
