// 🌟 Inner Classes & Nested Classes in Java

// In Java, a class defined inside another class is called a nested class.

// 👉 Nested classes can be static or non-static (inner classes).
// 👉 Inner classes (non-static) are associated with an instance of the outer class.
// 👉 Static nested classes are like normal top-level classes, just scoped inside another class.

// 🔹 1. Types of Nested Classes

// Java has four main types:
// Static Nested Class (declared with static keyword)
// Inner Class (non-static member class)
// Local Inner Class (defined inside a method or block)
// Anonymous Inner Class (class without a name, usually used for single-use implementation)

// 🔹 2. Static Nested Classes

// Declared as a static member of an outer class.
// Can access only static members of the outer class directly.
// Acts like a normal top-level class, but namespaced inside the outer class.

// Example

// class Outer {
//     static int outerStatic = 10;
//     int outerInstance = 20;

//     // static nested class
//     static class Nested {
//         void show() {
//             System.out.println("Static member: " + outerStatic);
//             // System.out.println(outerInstance); ❌ Not allowed
//         }
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Outer.Nested nested = new Outer.Nested(); // no Outer object needed
//         nested.show();
//     }
// }
// ✅ Key point: You don’t need an instance of Outer to create Nested.

// 🔹 3. Non-Static Inner Classes

// Also called member inner classes.

// Associated with an instance of the outer class.

// Can access both static and instance members of the outer class directly.

// Example 

// class Outer {
//     int outerInstance = 100;
//     static int outerStatic = 200;

//     class Inner {
//         void display() {
//             System.out.println("Outer instance: " + outerInstance);
//             System.out.println("Outer static: " + outerStatic);
//         }
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Outer outer = new Outer();
//         Outer.Inner inner = outer.new Inner(); // need outer object
//         inner.display();
//     }
// }
// ✅ Key point: Must create via outer.new Inner().

// 🔹 4. Local Inner Classes

// Declared inside a method, constructor, or block.

// Can access local variables of the method only if they are final or effectively final.

// Mostly used for helper logic that should not escape the method.

// Example
 
// class Outer {
//     void method() {
//         int localVar = 50; // must be final or effectively final

//         class LocalInner {
//             void print() {
//                 System.out.println("Local variable: " + localVar);
//             }
//         }

//         LocalInner li = new LocalInner();
//         li.print();
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         new Outer().method();
//     }
// }

// 🔹 5. Anonymous Inner Classes

// Class without a name, used for creating objects with short, single-use implementations.

// Commonly used with interfaces or abstract classes.

// Example: with interface

// interface Greeting {
//     void sayHello();
// }

// public class Main {
//     public static void main(String[] args) {
//         Greeting g = new Greeting() {  // anonymous inner class
//             @Override
//             public void sayHello() {
//                 System.out.println("Hello from Anonymous Inner Class!");
//             }
//         };
//         g.sayHello();
//     }
// }

// Example: with abstract class

// abstract class Animal {
//     abstract void sound();
// }

// public class Main {
//     public static void main(String[] args) {
//         Animal dog = new Animal() {
//             void sound() {
//                 System.out.println("Woof Woof!");
//             }
//         };
//         dog.sound();
//     }
// }

// 🔹 6. Why use Inner/Nested classes?

// Encapsulation — group classes logically together.
// Example: A Map class has an inner class Entry<K,V>.

// Code clarity — if a class is useful only for one other class, nest it.

// Avoid namespace pollution — keep related helper classes private inside the outer class.

// Access convenience — inner classes can directly access outer class members.

// 🔹 7. Advanced Notes & Edge Cases

// Shadowing: Inner classes can have fields/methods with the same name as the outer class. Use Outer.this.var to access the outer variable.

// class Outer {
//     int x = 10;
//     class Inner {
//         int x = 20;
//         void print() {
//             System.out.println("Inner x = " + x);
//             System.out.println("Outer x = " + Outer.this.x);
//         }
//     }
// }
// Modifiers: Inner classes can be public, private, protected, or package-private.

// Static members inside inner classes: Not allowed unless they are final static constants.

// Performance: Compiled into Outer$Inner.class, Outer$1.class (for anonymous). Slightly bigger bytecode, but runtime performance is almost same as top-level classes.

// Serialization: Be careful with non-static inner classes — they hold a reference to the outer instance.


// 🔹 8. Real-life Examples

// Java Collections Framework

// HashMap.Entry<K,V> is a static nested interface.

// Event Handling in Swing

// Anonymous inner classes for button listeners:

// button.addActionListener(new ActionListener() {
//     public void actionPerformed(ActionEvent e) {
//         System.out.println("Button clicked!");
//     }
// });


// | Type                  | Static? | Access to outer instance? | Use case                     |
// | --------------------- | ------- | ------------------------- | ---------------------------- |
// | Static Nested Class   | Yes     | ❌ No                     | Helper classes tied to outer |
// | Inner Class           | No      | ✅ Yes                    | Tight coupling with outer    |
// | Local Inner Class     | No      | ✅ Yes (final vars only)  | Helper logic inside methods  |
// | Anonymous Inner Class | No      | ✅ Yes                    | One-time implementations     |