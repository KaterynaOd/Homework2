import javax.xml.transform.Result;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        double num1;
        double num2;
        double ans;
        char op;
        Scanner reader = new Scanner(System.in);
        System.out.print("Input two numbers: ");
        num1 = reader.nextDouble();
        num2 = reader.nextDouble();
        System.out.print("\nEnter the operator(+, -, *, /): ");
        op = reader.next().charAt(0);
        switch(op) {
            case '+': ans = num1 + num2;
                break;
            case '-': ans = num1 - num2;
                break;
            case '*': ans = num1 * num2;
                break;
            case '/': ans = num1 / num2;
                break;
            default:  System.out.print("Error! Enter correct operator");
                return;
        }
        if (num1<=20 && num1>=-20 && num2<=20 && num2>=-20) {
            System.out.print("\nResult:\n");
            System.out.printf(num1 + " " + op + " " + num2 + " = " + ans);

            try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("Results.txt", true));
            writer.write("\n"+String.valueOf(date) + ": ");
            writer.write(num1 + " " + op + " " + num2 + " = " + ans );
            writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else {
            System.out.print("\nYou need input correct numbers from -20 to 20\n");
        }
    }
}
