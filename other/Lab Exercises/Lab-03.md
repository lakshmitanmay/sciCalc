# Lab-03
### Write a Java program to Implement the concept of array of objects with constructor and function overloading
```java
import java.util.Scanner;

class BasicCalc {
    private double num1;
    private double num2;
    private double result;
    private char operator;

    public BasicCalc(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = 0.0;
        this.operator = ' ';
    }

    public BasicCalc() {
        this(0.0, 0.0);
    }

    public void add(double num1, double num2) {
        this.result = num1 + num2;
        this.operator = '+';
    }

    public void add() {
        this.result = this.num1 + this.num2;
        this.operator = '+';
    }

    public void subtract(double num1, double num2) {
        this.result = num1 - num2;
        this.operator = '-';
    }

    public void subtract() {
        this.result = this.num1 - this.num2;
        this.operator = '-';
    }

    public void multiply(double num1, double num2) {
        this.result = num1 * num2;
        this.operator = '*';
    }

    public void multiply() {
        this.result = this.num1 * this.num2;
        this.operator = '*';
    }

    public void divide(double num1, double num2) {
        if (num2 != 0) {
            this.result = num1 / num2;
        } else {
            System.out.println("Error: Division by zero is not allowed.");
            this.result = Double.NaN;
        }
        this.operator = '/';
    }

    public void divide() {
        if (this.num2 != 0) {
            this.result = this.num1 / this.num2;
        } else {
            System.out.println("Error: Division by zero is not allowed.");
            this.result = Double.NaN;
        }
        this.operator = '/';
    }

    public double getNum1() {
        return num1;
    }

    public double getNum2() {
        return num2;
    }

    public double getResult() {
        return result;
    }

    public char getOperator() {
        return operator;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BasicCalc[] calculations = new BasicCalc[100];
        int calcCount = 0;

        int choice;
        do {
            System.out.print("\nEnter first number: ");
            double num1 = scanner.nextDouble();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            BasicCalc calc = new BasicCalc(num1, num2);

            System.out.print("\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. View History\n6. Clear History\n7. Cancel\n8. Exit\nChoose an operation: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    calc.add();
                    System.out.println("Result: " + calc.getResult());
                    break;
                case 2:
                    calc.subtract();
                    System.out.println("Result: " + calc.getResult());
                    break;
                case 3:
                    calc.multiply();
                    System.out.println("Result: " + calc.getResult());
                    break;
                case 4:
                    calc.divide();
                    System.out.println("Result: " + calc.getResult());
                    break;
                case 5:
                    System.out.println("\nHistory\n");
                    for (int i = 0; i < calcCount; i++) {
                        System.out.println((i + 1) + ". " + calculations[i].getNum1() + " " + calculations[i].getOperator() + " " + calculations[i].getNum2() + " = " + calculations[i].getResult());
                    }
                    break;
                case 6:
                    for (int i = 0; i < calcCount; i++) {
                        calculations[i] = null;
                    }
                    calcCount = 0;
                    System.out.println("History cleared.");
                    break;
                case 7:
                    continue;
                case 8:
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            if (choice >= 1 && choice <= 4 && calcCount < calculations.length) {
                calculations[calcCount++] = calc;
            }

        } while (choice != 8);

        scanner.close();
    }
}

```