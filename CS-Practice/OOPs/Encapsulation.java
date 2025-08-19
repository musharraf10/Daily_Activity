public class Encapsulation {
    private double balance;
    private boolean login;
    private String userDetails;

    Encapsulation(double b, boolean l, String u){
        balance = b;
        login = l;
        userDetails = u;
    }

        public double deposit(double bal){
            if(login){
                if(balance < 0){
                System.out.print("Enter Valid Amount");
                return 0.0;
            }else{
                balance += bal;
                return balance;
            }
            }else{
                System.out.print("Please Login and Try agian");
                return 0.0;
            }
        }

        public void getBalance(){
            if(login){
            System.out.println("Your Current Balance is: "+balance);
            }else{
                System.out.print("Please Login and Try agian");
            }
        }

        public double withdraw(double amount){
            if(login){

            this.balance -= amount;
            return balance;
            }else{
                System.out.print("Please Login and Try agian");
                return 0.0;
            }

        }

     public static void main(String[] args) {
        Encapsulation user1 = new Encapsulation(1000.0, true, "Shaik Musharaf");
        user1.getBalance();
        System.out.println("Current Balance Available: "+ user1.withdraw(23.0));
        System.out.println("Current Updated balance: "+ user1.deposit(123.0));


    }
    }
