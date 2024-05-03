package sparta_Report.updateCalcul;

import java.util.List;

public class ArithmeticCalculator extends Calculator {

    private OperatorManage operatorManage;

    public ArithmeticCalculator() {
    }

    public ArithmeticCalculator(List<Double> list) {
        super(list);
        operatorManage = new OperatorManage();
    }

    /*4. Throws 하는 예외 회피는 해당 메소드를 호출하는 상위 객체로
    예외를 전달하기 때문에 실제 발생하지 않는 예외를 처리해야 하는 오류를 발생할 수 있어요. 신중히 사용해 보세요.*/
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
