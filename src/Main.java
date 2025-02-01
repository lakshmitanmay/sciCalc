import java.util.Scanner;
import java.util.InputMismatchException;

import calc.basic.BasicCalc;
import calc.advanced.AdvancedCalc;
import Styling.format;

public class Main {
    public static void main(String[] args) {
        double num1 = 0.0, num2 = 0.0;
        int choice = 0;
        int calcCount = 0;

        Scanner scanner = new Scanner(System.in);
        BasicCalc[] calculations = new BasicCalc[100];

        do {
            try {
                StringBuffer menu = new StringBuffer();
                menu.append("\n\n").append(format.cyanBackground).append(format.blackBold)
                        .append("MAIN MENU").append(format.reset).append(format.cyanBold)
                        .append("\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Power\n6. Square Root")
                        .append("\n7. View History\n8. Clear History\n9. Exit\nChoose an operation: ")
                        .append(format.reset);
                System.out.print(menu);

                if (!scanner.hasNextInt()) {
                    scanner.next(); // Consume invalid input
                    throw new IllegalArgumentException("Invalid choice! Please enter a number between 1 and 9.");
                }
                choice = scanner.nextInt();

                if (choice >= 1 && choice < 6) {
                    System.out.println();
                    num1 = getValidNumber(scanner, "Enter first number: ");
                    num2 = getValidNumber(scanner, "Enter second number: ");
                    System.out.println();
                } else if (choice == 6) {
                    num1 = getValidNumber(scanner, "Enter the number: ");
                }

                AdvancedCalc calc = new AdvancedCalc(num1, num2);

                switch (choice) {
                    case 1:
                        calc.add();
                        printResult(calc);
                        break;
                    case 2:
                        calc.subtract();
                        printResult(calc);
                        break;
                    case 3:
                        calc.multiply();
                        printResult(calc);
                        break;
                    case 4:
                        calc.divide();
                        printResult(calc);
                        break;
                    case 5:
                        calc.power();
                        printResult(calc);
                        break;
                    case 6:
                        calc.sqrt();
                        printResult(calc);
                        break;
                    case 7:
                        viewHistory(calculations, calcCount);
                        break;
                    case 8:
                        calcCount = clearHistory(calculations, calcCount);
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("\n" + format.redBackground + format.blackBold + "Invalid choice!" + format.reset);
                }

                if (choice >= 1 && choice <= 6 && calcCount < calculations.length) {
                    calculations[calcCount++] = calc;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("\n" + format.redBackground + format.blackBold + "Error: " + e.getMessage() + format.reset);
            } catch (InputMismatchException e) {
                System.out.println("\n" + format.redBackground + format.blackBold + "Invalid input! Please enter a valid number." + format.reset);
                scanner.next(); // Consume invalid input
            }
        } while (choice != 9);

        scanner.close();
    }

    private static double getValidNumber(Scanner scanner, String prompt) {
        double num;
        while (true) {
            System.out.print(format.greenBold + prompt + format.reset);
            if (scanner.hasNextDouble()) {
                num = scanner.nextDouble();
                break;
            } else {
                System.out.println("\n" + format.redBackground + format.blackBold + "Invalid input! Please enter a valid number." + format.reset);
                scanner.next();
            }
        }
        return num;
    }

    private static void printResult(AdvancedCalc calc) {
        StringBuffer result = new StringBuffer();
        result.append("Result: ").append(calc.getResult());

        System.out.println(format.whiteBackground + format.blackBold + result + format.reset);
        result.reverse();
        int removeLength = 8;
        if (result.length() >= removeLength) {
            result.setLength(result.length() - removeLength);
        }
        System.out.println("Reversed Result: " + result);
    }

    private static void viewHistory(BasicCalc[] calculations, int calcCount) {
        if (calcCount == 0) {
            System.out.println("\n" + format.redBackground + format.blackBold + "History is empty. Perform some calculations first." + format.reset);
        } else {
            StringBuffer history = new StringBuffer("\n" + format.purpleBackground + format.blackBold + "History" + format.reset + "\n");
            for (int i = 0; i < calcCount; i++) {
                BasicCalc calc = calculations[i];
                history.append(format.purpleBold).append(i + 1).append(". ")
                        .append(calc.getNum1()).append(" ").append(calc.getOperator()).append(" ")
                        .append(calc.getNum2()).append(" = ").append(calc.getResult()).append("\n")
                        .append(format.reset);
            }

            System.out.println(history);

            System.out.println("First occurrence of '=': " + history.indexOf("="));
            System.out.println("Last occurrence of '=': " + history.lastIndexOf("="));
        }
    }

    private static int clearHistory(BasicCalc[] calculations, int calcCount) {
        if (calcCount != 0) {
            for (int i = 0; i < calcCount; i++) {
                calculations[i] = null;
            }
            calcCount = 0;
            System.out.println("\n" + format.yellowBackground + format.blackBold + "History cleared" + format.reset);
        } else {
            System.out.println("\n" + format.redBackground + format.blackBold + "History is already empty" + format.reset);
        }
        return calcCount;
    }
}