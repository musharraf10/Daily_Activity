//  🧠 1. Try–Catch, Checked vs Unchecked, and Custom Exceptions

//  🔹 What are Exceptions?

//  Exception = an unexpected event at runtime that disrupts normal program flow.
//  In Java, all exceptions are objects derived from `Throwable`.

//    `Throwable`

//      `Error` (serious system-level issues, e.g., OutOfMemoryError → don’t handle)
//      `Exception`

//        Checked exceptions → must handle (compile-time check).
//        Unchecked exceptions (RuntimeException) → optional to handle.


//  🔹 Try–Catch Block

// The mechanism to handle exceptions gracefully.

// ```java
// try {
//     // risky code (may throw)
// } catch (SpecificException e) {
//     // handle exception
// } finally {
//     // always executed (resource cleanup)
// }
// ```

//  Flow:

//   1. Enter `try`
//   2. If no exception → `catch` skipped → `finally` executed
//   3. If exception occurs → control jumps to matching `catch`
//   4. `finally` still executes (even if return inside try/catch, unless `System.exit()`)

// ✅ Example:

// ```java
// try {
//     int result = 10 / 0; // ArithmeticException
// } catch (ArithmeticException e) {
//     System.out.println("Cannot divide by zero!");
// } finally {
//     System.out.println("Cleanup done.");
// }
// ```

// ---

//  🔹 Checked vs Unchecked

//  Checked Exceptions

//    Checked at compile-time.
//    Must either handle (`try-catch`) or declare (`throws`).
//    Example: `IOException`, `SQLException`.

//   ```java
//   void readFile() throws IOException {
//       FileReader fr = new FileReader("abc.txt");
//   }
//   ```

//  Unchecked Exceptions

//    Subclasses of `RuntimeException`.
//    Not forced by compiler.
//    Usually caused by programming bugs.
//    Example: `NullPointerException`, `IndexOutOfBoundsException`.

//   ```java
//   String s = null;
//   System.out.println(s.length()); // NPE
//   ```

// ---

//  🔹 Custom Exceptions

// We can define application-specific exceptions.

//  Checked custom exception → extend `Exception`.
//  Unchecked custom exception → extend `RuntimeException`.

// ✅ Example:

// ```java
// // Custom checked exception
// class InvalidAgeException extends Exception {
//     public InvalidAgeException(String msg) {
//         super(msg);
//     }
// }

// class Voting {
//     void checkAge(int age) throws InvalidAgeException {
//         if (age < 18) throw new InvalidAgeException("Not eligible to vote");
//         System.out.println("Eligible!");
//     }
// }
// ```

// 🔹 2. Unchecked Custom Exception

// 👉 No need to declare with throws.
// Extend from RuntimeException.

// // Custom unchecked exception
// class InsufficientBalanceException extends RuntimeException {
//     public InsufficientBalanceException(String message) {
//         super(message);
//     }
// }

// class BankAccount {
//     private double balance = 1000;

//     void withdraw(double amount) {
//         if (amount > balance) {
//             throw new InsufficientBalanceException("Balance too low! Available: " + balance);
//         }
//         balance -= amount;
//         System.out.println("Withdraw successful. Remaining balance: " + balance);
//     }
// }

// public class UncheckedCustomDemo {
//     public static void main(String[] args) {
//         BankAccount account = new BankAccount();
//         account.withdraw(1500); // throws unchecked exception
//     }
// }


// 🔑 Key Notes:

// Compiler does not force handling.

// Used for programming mistakes (like null, invalid states, business rule violations).

// Why useful?

//  Adds semantic meaning to errors.
//  Separates business logic errors from system errors.

