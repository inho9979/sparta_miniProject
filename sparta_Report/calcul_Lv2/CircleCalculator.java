package sparta_Report.calcul_Lv2;

import java.util.ArrayList;

public class CircleCalculator extends Calculator{

    public CircleCalculator(ArrayList<Double> list) {
        super(list);
    }

    @Override
    public double calculate(double radius) throws CalculatorInputException {
        return radius*radius*3.14;
    }

    @Override
    public double calculate(double number1, double number2, char operator) throws CalculatorInputException {
        return 0;
    }
}
