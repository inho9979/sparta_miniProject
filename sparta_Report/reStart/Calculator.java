package sparta_Report.reStart;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    List<Integer> resultArray = new ArrayList<>();

    public int calculate(int num1, int num2, char oper) throws CalculatorInputException {
        /* 위 요구사항에 맞게 구현 */
        /* return 연산 결과 */
        int result = 0;
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
        return result;
    }
}
