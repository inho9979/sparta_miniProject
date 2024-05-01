package sparta_Report.reStart;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성합니다. */
        /* 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언 */
        int[] resultArray= new int[10];
        int arrayIndex = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int number1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int number2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            char oper = sc.next().charAt(0);

            int result = 0;
            /* 제어문을 활용하여 위 요구사항을 만족할 수 있게 구현합니다.*/
            switch (String.valueOf(oper)) {
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> {
                    if (number2 == 0) {
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다");
                        break;
                    }
                    result = number1 / number2;
                }
            }
            System.out.println("결과: " + result);
            /* 연산의 결과를 배열에 저장합니다. */
            /* index를 증가 시킵니다. */
            resultArray[arrayIndex] = result;
            arrayIndex++;

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            if(sc.next().equals("exit"))
                break;
        }
    }
}
