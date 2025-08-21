class Patterns {
    public static void main(String[] args) {
        int n = 5; // height of pyramid
        for (int i = 1; i <= n; i++) {
            // print leading spaces
            for (int t = 1; t <= n; t++) {
                System.out.print("  ");  // just ONE space
            }
            // print stars
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
