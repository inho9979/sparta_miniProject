package sparta_Report.reStart;

import java.util.List;

public class CircleCalculator extends Calculator {

    public CircleCalculator() {
    }

    public CircleCalculator(List<Double> list) {
        super(list);
    }

    public double calculate(double radius) {
        double result;
        result = radius * radius * PI;

        super.addResultArray(result);
        return result;
    }

    @Override
    public void inquiryResultArray() {
        int count = 1;
        for (double e : super.getResultArray()) {
            System.out.println(count + "번째 원의 넓이: " + e);
        }
    }
}
