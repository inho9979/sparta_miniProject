package sparta_Report.reStart;

import java.util.List;

public class ArithmeticCalculator extends Calculator {

    private OperatorManage operatorManage;

    public ArithmeticCalculator() {
    }

    public ArithmeticCalculator(List<Double> list) {
        super(list);
        operatorManage = new OperatorManage();
    }

    public double calculate(double num1, double num2, char oper) {
        /* 위 요구사항에 맞게 구현 */
        /* return 연산 결과 */
        double result = 0;

        Operator operator = operatorManage.getOperator(oper);
        result = operator.operate(num1, num2);

        // 계산메소드에서 결과값을 바로 array에 담도록
        super.addResultArray(result);
        return result;
    }

    @Override
    public void inquiryResultArray() {
        int count = 1;
        for (Object e : super.getResultArray()) {
            System.out.println(count + "번째 결과: " + e);
            count++;
        }
    }
}
