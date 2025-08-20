class Bank{
    
    void account(){
        System.out.println("This is Parent Bank");
    }
}

class SBI extends Bank {
    void sbiAccount(){
        System.out.println("This is SBI bank Account Opened");
    }
}

class Union extends SBI{
    void unionAccount(){
        System.out.println("This is Union bank Account Opened");
    }
}


class Inheritance{
    public static void main(String[] args){
        Union user = new Union();
        user.account();
        user.sbiAccount();
        user.unionAccount();

        System.out.println("This User Opend Account in 3 banks ");
    }
}


// class Animal {
//     String type = "Animal";
//     Animal() {
//         System.out.println("Animal constructor");
//     }
//     void display() {
//         System.out.println("I am an Animal");
//     }
// }

// class Dog extends Animal {
//     Dog() {
//         super(); // Calls Animal constructor
//         System.out.println("Dog constructor");
//     }
//     void display() {
//         super.display(); // Call parent method
//         System.out.println("I am a Dog");
//     }
// }
