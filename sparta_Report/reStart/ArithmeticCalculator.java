package sparta_Report.reStart;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator extends Calculator {

    AddOperator addOperator;
    SubtractOperator subtractOperator;
    MultiplyOperator multiplyOperator;
    DivideOperator divideOperator;

    public ArithmeticCalculator() {
    }

    public ArithmeticCalculator(List<Double> list, AddOperator addOperator, SubtractOperator subtractOperator, MultiplyOperator multiplyOperator, DivideOperator divideOperator) {
        super(list);
        this.addOperator = addOperator;
        this.subtractOperator = subtractOperator;
        this.multiplyOperator = multiplyOperator;
        this.divideOperator = divideOperator;
    }

    public double calculate(double num1, double num2, char oper) {
        /* 위 요구사항에 맞게 구현 */
        /* return 연산 결과 */
        double result = 0;
        if (!(oper == '+' || oper == '-' || oper == '*' || oper == '/')) {
            throw new UnsupportedOperationException("잘못된 연산자 입력입니다");
        }

        switch (oper) {
            case '+' -> result = addOperator.operate(num1, num2);
            case '-' -> result = subtractOperator.operate(num1, num2);
            case '*' -> result = multiplyOperator.operate(num1, num2);
            case '/' -> result = divideOperator.operate(num1, num2);
        }

        // 계산메소드에서 결과값을 바로 array에 담도록
        super.addResultArray(result);
        return result;
    }

    @Override
    public void inquiryResultArray() {
        int count = 1;
        for (double e : super.getResultArray()) {
            System.out.println(count + "번째 결과: " + e);
            count++;
        }
    }
}
