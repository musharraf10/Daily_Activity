// Polymorphism means "one thing, many forms."

// Poly → many

// Morph → forms

// In OOP, polymorphism allows an object to behave differently depending on the situation, even though it looks the same.

// Compile-Time Polymorphism (Static Binding / Early Binding)

// Happens at compile time (decided before running).

// Example: Method Overloading

//--> Run-Time Polymorphism (Dynamic Binding / Late Binding)

// Happens at runtime (decided when program runs).

// Example: Method Overriding


class Calculator {
    int add(int a, int b) {
        return a + b;
    }
    double add(double a, double b) {
        return a + b;
    }
    int add(int a, int b, int c) {
        return a + b + c;
    }
}
// add(2,3) → calls first method

// add(2.9,3.2) → calls second method


// Same method name (add) but different forms based on arguments.

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal {
    void sound() {
        System.out.println("Dog barks");
    }
}
class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

class Polymorphism{
    public static void main(String[] args) {

        //Compile-Time Polymorphism (Static Binding / Early Binding)

        Calculator c = new Calculator();
        System.out.println(c.add(2.9,3.2));
        System.out.println(c.add(2,3));

        // Run-Time Polymorphism (Dynamic Binding / Late Binding)
        Animal a;  
        a = new Dog();  
        a.sound();  // Dog barks  

        a = new Cat();  
        a.sound();  // Cat meows  
    }

}


// Why Polymorphism is Important?

// Flexibility → Same code works with different types of objects.

// Reusability → You don’t need to write separate code for every type.

// Extensibility → Easy to add new classes without breaking old code.

// Loose Coupling → Code becomes more maintainable.


// Interfaces & Abstract Classes

// Used to achieve polymorphism at design level.

// Example: List interface in Java can be ArrayList or LinkedList.

// List<Integer> list = new ArrayList<>();
// list = new LinkedList<>();

// Software Design Patterns → Strategy, Factory, etc.

// Database Systems → executeQuery() returns different results.

// UI Frameworks → draw() method for Circle, Rectangle, Triangle.

// Games → A character’s attack() behaves differently for Warrior, Archer, Mage.

// APIs & Libraries → One function name, multiple usages.



// Q1. Can constructors be polymorphic?

// No. Constructors cannot be overridden, but they can be overloaded.

// Q2. Can static methods be polymorphic?

// Overloading → Yes (compile-time).

// Overriding → No (they belong to class, not object).

// Q3. Why is method overriding called Runtime Polymorphism?

// Because actual method call depends on object created at runtime, not reference type.

// Q4. What happens if we make a method final?

// It cannot be overridden, so no runtime polymorphism.

// Q5. Polymorphism vs Inheritance?

// Inheritance → relationship between classes.

// Polymorphism → behavior change using inheritance/interfaces.


// Summary (Deep Dive)

// ✅ Polymorphism = One interface, many implementations
// ✅ Compile-time (Overloading) → Resolved by compiler
// ✅ Runtime (Overriding) → Resolved by JVM (vtable + dynamic dispatch)
// ✅ Memory → Reference on stack, object on heap, resolved dynamically
// ✅ Design Patterns → Strategy, Factory, Template heavily use polymorphism
// ✅ JVM Internals → vtable method lookup
// ✅ Interview Hotspots → final, static, constructor rules

abstract class Payment {
    abstract void pay(int amount);
}

class CreditCard extends Payment {
    void pay(int amount) {
        System.out.println("Paid " + amount + " via Credit Card");
    }
}

class PayPal extends Payment {
    void pay(int amount) {
        System.out.println("Paid " + amount + " via PayPal");
    }
}

class Test {
    public static void main(String[] args) {
        Payment p; 
        p = new CreditCard();
        p.pay(500); // Paid via Credit Card

        p = new PayPal();
        p.pay(1000); // Paid via PayPal
    }
}
