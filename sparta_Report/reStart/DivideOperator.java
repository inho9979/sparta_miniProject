package sparta_Report.reStart;

public class DivideOperator implements Operator{

    @Override
    public double operate(double num1, double num2) {
        if (num2 == 0)
            throw new ArithmeticException("나눗셈 연산에서 분모에 0이 입력될 수 없습니다");
        return num1 / num2;
    }
}
