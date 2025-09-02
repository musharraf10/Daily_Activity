// 🧠 SOLID Principles in Depth

// S – Single Responsibility Principle (SRP)

//  Definition: A class should have only one reason to change, i.e., it should do only one thing.
//  Goal: Keep classes focused, small, and easier to test.
//  Bad Example ❌:

//   ```java
//   class Report {
//       void generateReport() { ... }
//       void saveToFile(String filename) { ... }
//       void sendEmail(String email) { ... }
//   }
//   ```

//   (Here the class handles report generation, file saving, and emailing → 3 reasons to change.)
//  Good Example ✅:

//   ```java
//   class ReportGenerator { void generateReport() { ... } }
//   class ReportSaver { void saveToFile(String filename) { ... } }
//   class ReportSender { void sendEmail(String email) { ... } }
//   ```

// ---

// O – Open/Closed Principle (OCP)

//  Definition: Software entities (classes, methods, modules) should be open for extension but closed for modification.
//  Goal: You should add new behavior without changing existing code.
//  Bad Example ❌:

//   ```java
//   class Discount {
//       double calculate(String type, double price) {
//           if (type.equals("Christmas")) return price  0.9;
//           else if (type.equals("NewYear")) return price  0.8;
//           return price;
//       }
//   }
//   ```

//   (Every time a new discount type is added, we modify the class.)
//  Good Example ✅: Use polymorphism.

//   ```java
//   interface Discount {
//       double apply(double price);
//   }
//   class ChristmasDiscount implements Discount {
//       public double apply(double price) { return price  0.9; }
//   }
//   class NewYearDiscount implements Discount {
//       public double apply(double price) { return price  0.8; }
//   }
//   ```

//   (Now we extend with new classes, without modifying existing code.)

// ---

// L – Liskov Substitution Principle (LSP)

//  Definition: Objects of a superclass should be replaceable with objects of a subclass without breaking the program.
//  Goal: Subclasses must honor the contract of the parent.
//  Bad Example ❌:

//   ```java
//   class Bird {
//       void fly() { ... }
//   }
//   class Ostrich extends Bird {
//       @Override void fly() { throw new UnsupportedOperationException(); }
//   }
//   ```

//   (Ostrich is a Bird but can’t fly → violates LSP.)
//  Good Example ✅:

//   ```java
//   interface Bird { }
//   interface Flyable { void fly(); }

//   class Sparrow implements Bird, Flyable {
//       public void fly() { ... }
//   }
//   class Ostrich implements Bird {
//       // No fly method, no violation
//   }
//   ```

// ---

// I – Interface Segregation Principle (ISP)

//  Definition: Clients should not be forced to depend on methods they don’t use.
//  Goal: Split big interfaces into smaller, role-specific ones.
//  Bad Example ❌:

//   ```java
//   interface Machine {
//       void print();
//       void scan();
//       void fax();
//   }

//   class OldPrinter implements Machine {
//       public void print() { ... }
//       public void scan() { throw new UnsupportedOperationException(); }
//       public void fax() { throw new UnsupportedOperationException(); }
//   }
//   ```
//  Good Example ✅:

//   ```java
//   interface Printer { void print(); }
//   interface Scanner { void scan(); }
//   interface Fax { void fax(); }

//   class OldPrinter implements Printer {
//       public void print() { ... }
//   }
//   ```

// ---

// D – Dependency Inversion Principle (DIP)

//  Definition: High-level modules should not depend on low-level modules. Both should depend on abstractions.
//  Goal: Reduce coupling, increase flexibility.
//  Bad Example ❌:

//   ```java
//   class MySQLDatabase {
//       void connect() { ... }
//   }

//   class UserService {
//       MySQLDatabase db = new MySQLDatabase();
//       void getUser() { db.connect(); ... }
//   }
//   ```

//   (Direct dependency → switching DB is painful.)
//  Good Example ✅:

//   ```java
//   interface Database { void connect(); }

//   class MySQLDatabase implements Database {
//       public void connect() { ... }
//   }

//   class MongoDatabase implements Database {
//       public void connect() { ... }
//   }

//   class UserService {
//       private Database db;
//       UserService(Database db) { this.db = db; }
//       void getUser() { db.connect(); ... }
//   }
//   ```

//   (Now UserService depends on abstraction, not a specific DB.)

// ---

//  🔑 Summary Table

// | Principle | Definition                                  | Benefit                                  |
// | --------- | ------------------------------------------- | ---------------------------------------- |
// | S         | One class → one reason to change            | Simplicity, easier testing               |
// | O         | Open for extension, closed for modification | Flexible to add features                 |
// | L         | Subclass must be substitutable for parent   | Reliable inheritance                     |
// | I         | Split large interfaces                      | Focused contracts, avoids unused methods |
// | D         | Depend on abstractions, not concretions     | Loose coupling, testability              |

// 👉 Pro Tip: SOLID isn’t a set of rules but guidelines. Sometimes breaking them is pragmatic, but knowing them ensures your design choices are conscious.


//  🛒 Example: E-Commerce Order System
//  1. Single Responsibility Principle (SRP)

//  Problem: One class doing too many things.
//  Example:

//   ```java
//   class OrderService {
//       void createOrder() { ... }
//       void calculateDiscount() { ... }
//       void sendEmailConfirmation() { ... }
//   }
//   ```

//   ❌ Violates SRP (order handling, discount, and email in one class).

// ✅ Fix (split responsibilities):

// ```java
// class OrderService {
//     void createOrder() { ... }
// }

// class DiscountService {
//     double applyDiscount(double price) { return price  0.9; }
// }

// class EmailService {
//     void sendConfirmation(String email) { ... }
// }
// ```

// ---
//  2. Open/Closed Principle (OCP)

//  Requirement: Add new payment types without changing existing code.
//  ❌ Bad:

//   ```java
//   class PaymentService {
//       void pay(String type) {
//           if(type.equals("CreditCard")) { ... }
//           else if(type.equals("UPI")) { ... }
//       }
//   }
//   ```

//   (Every new payment type requires modifying this class.)

// ✅ Good: Use polymorphism:

// ```java
// interface PaymentMethod {
//     void pay(double amount);
// }

// class CreditCardPayment implements PaymentMethod {
//     public void pay(double amount) { System.out.println("Paid by Credit Card: " + amount); }
// }

// class UpiPayment implements PaymentMethod {
//     public void pay(double amount) { System.out.println("Paid via UPI: " + amount); }
// }

// class PaymentProcessor {
//     private PaymentMethod method;
//     PaymentProcessor(PaymentMethod method) { this.method = method; }
//     void process(double amount) { method.pay(amount); }
// }
// ```

// ➡ Add PayPal, Wallet, etc. by creating new classes, no need to modify `PaymentProcessor`.

// ---
//  3. Liskov Substitution Principle (LSP)

//  ❌ Bad:

//   ```java
//   class Delivery {
//       void deliver() { ... }
//   }

//   class StorePickup extends Delivery {
//       @Override void deliver() {
//           throw new UnsupportedOperationException("Pickup has no delivery!");
//       }
//   }
//   ```

//   (Subclass breaks the parent contract → violates LSP.)

// ✅ Good: Separate concepts:

// ```java
// interface Delivery { void deliver(); }
// class HomeDelivery implements Delivery {
//     public void deliver() { System.out.println("Delivered to home"); }
// }

// class StorePickup { 
//     void pickup() { System.out.println("Pickup at store"); }
// }
// ```

// ---
//  4. Interface Segregation Principle (ISP)

//  ❌ Bad: One fat interface.

//   ```java
//   interface Notification {
//       void sendEmail();
//       void sendSMS();
//       void sendPush();
//   }

//   class EmailNotifier implements Notification {
//       public void sendEmail() { ... }
//       public void sendSMS() { throw new UnsupportedOperationException(); }
//       public void sendPush() { throw new UnsupportedOperationException(); }
//   }
//   ```
//  ✅ Good: Smaller, focused interfaces.

//   ```java
//   interface EmailNotification { void sendEmail(); }
//   interface SMSNotification { void sendSMS(); }
//   interface PushNotification { void sendPush(); }

//   class EmailNotifier implements EmailNotification {
//       public void sendEmail() { System.out.println("Email sent!"); }
//   }
//   ```

// ---
//  5. Dependency Inversion Principle (DIP)

//  ❌ Bad:

//   ```java
//   class OrderRepository {
//       MySQLDatabase db = new MySQLDatabase();
//       void saveOrder(Order o) { db.insert(o); }
//   }
//   ```

//   (Hard-coded to MySQL.)

//  ✅ Good: Depend on abstraction.

//   ```java
//   interface Database {
//       void insert(Order o);
//   }

//   class MySQLDatabase implements Database {
//       public void insert(Order o) { System.out.println("Saved in MySQL"); }
//   }

//   class MongoDatabase implements Database {
//       public void insert(Order o) { System.out.println("Saved in MongoDB"); }
//   }

//   class OrderRepository {
//       private Database db;
//       OrderRepository(Database db) { this.db = db; }
//       void saveOrder(Order o) { db.insert(o); }
//   }
//   ```

// ➡ Now you can switch databases easily (even for testing with an in-memory DB).

//  🔑 Takeaway

//  SRP → Each class does one thing.
//  OCP → Add new features via extension, not modification.
//  LSP → Subclasses must behave like their parents.
//  ISP → Small, specific interfaces.
//  DIP → Depend on abstractions, not concrete classes.
