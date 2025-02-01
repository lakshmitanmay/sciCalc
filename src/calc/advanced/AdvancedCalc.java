package calc.advanced;

import calc.basic.BasicCalc;

public class AdvancedCalc extends BasicCalc {
    public AdvancedCalc(double num1, double num2) {
        super(num1, num2);
    }

    public void power() {
        this.result = Math.pow(this.num1, this.num2);
        this.operator = '^';
    }

    public void sqrt() {
        this.result = Math.sqrt(this.num1);
        this.operator = '√';
    }
}