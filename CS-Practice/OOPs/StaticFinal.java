// StaticFinalVariables.java

// Meaning of static

// 👉 Belongs to the class, not to objects.
// Shared among all objects.
// Loaded into memory only once per class.

// Static Variables
// ->Declared with static keyword inside class.

// ->Same copy shared across all objects.

// class Counter {
//     static int count = 0;
//     Counter() {
//         count++;
//     }
// }
// public class StaticFinalVariables {
//     public static void main(String[] args) {
//         new Counter();
//         new Counter();
//         System.out.println(Counter.count); // 2 (shared by all objects)
//     }
// }

// 💡 Use case → when data should be common across all instances (e.g., count of objects, constants).
// class MathUtil {
//     static int square(int x) {
//         return x * x;
//     }
// }
// public class StaticFinal {
    
//     public static void main(String[] args) {
//         System.out.println(MathUtil.square(5)); // 25
//     }
// }

// 3.Static Blocks

// Runs once when class is loaded.

// Used for initializing static variables.

// class Config {
//     static String dbUrl;
//     static {
//         dbUrl = "jdbc:mysql://localhost:3306/mydb";
//         System.out.println("Static block executed");
//     }
// }


// 4.Static Nested Class

// Inner class declared as static.

// Can be created without outer object.

// class Outer {
//     static class Inner {
//         void msg() { System.out.println("Hello from static inner class"); }
//     }
// }
// public class Test {
//     public static void main(String[] args) {
//         Outer.Inner obj = new Outer.Inner();
//         obj.msg();
//     }
// }

//24/08/2025 Sunday