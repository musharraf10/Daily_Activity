class Patterns<T> {
    T data;

    Patterns(T d) {
        data = d;
    }

    void show(){
        System.out.println("This is "+data);
    }
    

    public static void main(String[] args) {

        Patterns<Integer> i = new Patterns<>(12);
        Patterns<String> s = new Patterns<>("String");

        i.show();
        s.show();

        // int n = 5; // height of pyramid
        // for (int i = 1; i <= n; i++) {
        //     // print leading spaces
        //     for (int t = 1; t <= n; t++) {
        //         System.out.print("  ");  // just ONE space
        //     }
        //     // print stars
        //     for (int j = 1; j <= 2 * i - 1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        
    }
}
