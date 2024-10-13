public class Fermat {
    public static void main(String[] args) {
        int a = 2;
        int b = 5;
        int c= 3;    
        int n = 6;
        // line that calculates the value of x from the values of a, b and c with the power of n
        // According to fermat, x = (a^n) + (b^n) = (c^n) cant be true inless n is smaller than or equal to 2
        int x = (int) Math.pow(a, n) + (int) Math.pow(b, n);

        System.out.println(x);
        System.out.println((int) Math.pow(c, n));

        // if statement that checks if the value of x is equal to the value of c^n
        // if not, the statement will print that fermat was wrong

        if (x == (int) Math.pow(c, n)) {
            System.out.println("Fermat was wrong!");
        } else {
            System.out.println("Fermat was right!");
        }
    }
}
