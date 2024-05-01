package sparta_Report.reStart;

import java.util.List;

public class ArithmeticCalculator extends Calculator{
    private double num1;
    private double num2;
    private char oper;

    public ArithmeticCalculator(List<Double> list){
        super(list);
    }

    public void arithmeticInit(double num1, double num2, char oper){
        this.num1 = num1;
        this.num2 = num2;
        this.oper = oper;
    }

    @Override
    public double calculate() throws CalculatorInputException{
        /* 위 요구사항에 맞게 구현 */
        /* return 연산 결과 */
        double result = 0;
        if (!(oper == '+' || oper == '-' || oper == '*' || oper == '/')) {
            System.out.println("잘못된 연산자 입력입니다");
            throw new CalculatorInputException();
        }

        switch (String.valueOf(oper)) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> {
                if (num2 == 0) {
                    System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다");
                    throw new CalculatorInputException();
                }
                result = num1 / num2;
            }
        }
        // 계산메소드에서 결과값을 바로 array에 담도록
        addResultArray(result);
        return result;
    }
}
