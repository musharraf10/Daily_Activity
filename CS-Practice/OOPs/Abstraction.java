// => Abstraction = Hiding implementation details, showing only essential features.
// You don’t need to know how something works, only what it does.
// Focus on "what to do" instead of "how to do it".

// => Real-World Analogy

// Car driver: You only see the steering, brakes, accelerator.
// You don’t care how the engine, fuel injection, sensors work.

// ATM: You only see Withdraw / Deposit / Balance Inquiry.
// You don’t know the internal banking logic.

// 💡 That’s abstraction: exposing what, hiding how.

// => Java achieves abstraction in two ways:

// 1. Abstract Classes

// 2. Interfaces

// 1️⃣ Abstract Classes

// Rules:

// Declared using abstract keyword.

// Can have abstract methods (without body) and concrete methods (with body).

// Cannot be instantiated directly.

// Used for "is-a" relationships with shared base behavior. (is-a whenever we see extend that has is-a relation)


//Here Code: For Banking

abstract class ATM{

    abstract double balance();
    abstract void withdrawal(int amount);
    abstract void deposit(int amount);

    void atmStatus(){
        System.out.println("ATM Is Active Use Our Services");
    }

}

class SBI extends ATM{
    double balance;

    
    SBI(double b){
        balance = b;
    }

    public void greetings(){
        System.out.println("Welcome To SBI ATM");
    }

    double balance(){
        return balance;
    }

    void withdrawal(int amount){
        if(amount < 500){
            System.out.println("Amount Should be Greater than 500");
        }else if(amount % 100 != 0){
            System.out.println("Enter Amount multiples of 100 (ex., 100, 400, 800)");
        }else if(amount > balance){
            System.out.println("You Don't have sufficient balance in your account");
        }else{
            balance -= amount;
            System.out.println("--- Your Transcation Completed. ----");
            System.out.println("You received: "+amount);
            System.out.println("Available Balance is: "+balance);
        }
    }

    void deposit(int amount){
        if(amount <100){
            System.out.println("Not valid Amount to Deposit");
        }else if(amount % 100 != 0){
            System.out.println("Deposit Amount multiples of 100 (ex., 100, 400, 800)");
        }else{
            balance += amount;

            System.out.println("Your Amount "+amount+" Deposited Successfully.");
            System.out.println("Available Balance is: "+balance);
        }
    }
}

public class Abstraction {
    public static void main(String[] args) {
        ATM sbi = new SBI(1300.0);
        sbi.atmStatus();
        ((SBI)sbi).greetings(); //down grading
        System.out.println("Current Balance is: "+sbi.balance());
        sbi.deposit(3200);
        sbi.withdrawal(300);
        sbi.withdrawal(500);
        sbi.withdrawal(700);

    }
}



// 2️⃣ Interfaces
// Rules:

// Declared using interface keyword.

// All methods are abstract by default (Java 7).

// From Java 8 → default & static methods allowed.

// From Java 9 → private methods allowed.

// A class can implement multiple interfaces (supports multiple inheritance).

interface Animal {
    void sound();  // abstract method
}

interface Pet {
    void play(); // abstract method
}

class Dog implements Animal, Pet {
    public void sound() {
        System.out.println("Dog barks");
    }
    public void play() {
        System.out.println("Dog plays fetch");
    }
}

// public class Ab {
//     public static void main(String[] args) {
//         Animal a = new Dog();
//         a.sound();   // Dog barks

//         Pet p = new Dog();
//         p.play();    // Dog plays fetch
//     }
// }


// | Feature              | Abstract Class                                                    | Interface                                                               |
// | -------------------- | ----------------------------------------------------------------- | ----------------------------------------------------------------------- |
// |   Methods            | Can have abstract + concrete                                      | Only abstract (till Java 7), can have `default` & `static` after Java 8 |
// |   Variables          | Instance + static                                                 | Only `public static final` (constants)                                  |
// |   Access Modifiers   | Any                                                               | All methods are `public` by default                                     |
// |   Inheritance        | Single inheritance (one class can extend only one abstract class) | Multiple inheritance (class can implement many interfaces)              |
// |   Use Case           | "is-a" relationship with common base logic                        | Contracts / capabilities (e.g., Comparable, Runnable)                   |


// Industry Applications

// Spring Framework → Uses interfaces (ApplicationContext, BeanFactory).

// Java Collections → List, Set, Map are interfaces; ArrayList, HashSet, HashMap are implementations.

// Design Patterns →

// Strategy Pattern uses interfaces to switch algorithms.

// Template Method Pattern uses abstract classes.

// Abstract Classes (partial abstraction)

// Interfaces (full abstraction, multiple inheritance of type)


// Functional Interfaces (Java 8)

// Interfaces with exactly one abstract method.

// Example: Runnable, Callable, Comparator.

// Used in lambda expressions.

// @FunctionalInterface
// interface Calculator {
//     int add(int a, int b);
// }
// Calculator c = (x, y) -> x + y;
