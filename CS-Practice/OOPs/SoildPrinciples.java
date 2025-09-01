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


