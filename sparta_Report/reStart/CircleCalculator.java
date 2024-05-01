package sparta_Report.reStart;

import java.util.List;

public class CircleCalculator extends Calculator {
    private double radius;

    public CircleCalculator(List<Double> list){
        super(list);
    }

    public void circleInit(double radius){
        this.radius = radius;
    }

    @Override
    public double calculate() throws CalculatorInputException {
        double result = 0;
        result = radius * radius * PI;
        addResultArray(result);
        return result;
    }

}
