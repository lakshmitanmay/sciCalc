package calc.basic;

public class BasicCalc {
    protected double num1;
    protected double num2;
    protected double result;
    protected char operator;

    public BasicCalc(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.result = 0.0;
        this.operator = ' ';
    }

    public BasicCalc() {
        this(0.0, 0.0);
    }

    public void add() {
        this.result = this.num1 + this.num2;
        this.operator = '+';
    }

    public void subtract() {
        this.result = this.num1 - this.num2;
        this.operator = '-';
    }

    public void multiply() {
        this.result = this.num1 * this.num2;
        this.operator = '*';
    }

    public void divide() {
        try {
            if (this.num2 == 0) {
                throw new IllegalArgumentException("Division by zero is not allowed.");
            }
            this.result = this.num1 / this.num2;
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
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
