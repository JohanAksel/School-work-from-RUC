import java.util.Scanner;

//Class that calculates Celcius to Fahrenheit 
public class exc3 {
    public static void main(String[] args) {
        

Scanner in = new Scanner(System.in); // scanner for user input

//prompt to get user to input temperature in celcius
System.out.println("This is a program which calculculates celcius to fahrenheit");
System.out.print("What is the temperature in celcius?");
//variable that puts users input as a double value and stores it in C
double C=in.nextDouble();
//formula for celcius to fahrenheit
final double F = C*9.0/5.0+36.0;
// final output of celcius to fahrenheit
System.out.printf("when the temperature is %.1f C it is %.1f F \n", C, F);
    }

}
