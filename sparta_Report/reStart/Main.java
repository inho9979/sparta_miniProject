package sparta_Report.reStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* 요구사항에 맞게 Calculator 인스턴스 생성 부분 수정 */
        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator(new ArrayList<>(),new AddOperator()
                , new SubtractOperator(), new MultiplyOperator(), new DivideOperator());
        
        CircleCalculator circleCalculator = new CircleCalculator(new ArrayList<>());

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("사칙연산 계산을 원하면 1, 원 넓이 계산을 원하면 2를 눌러주세요 :");
            int flag = sc.nextInt();

            if (flag == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                double number1 = sc.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
                double number2 = sc.nextInt();
                System.out.print("사칙연산 기호를 입력하세요: ");
                // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
                char oper = sc.next().charAt(0);

                double result = 0;

                try {
                    result = arithmeticCalculator.calculate(number1,number2,oper);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                System.out.println("결과: " + result);

                /* 요구사항에 맞게 구현 remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현 */
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if (sc.next().equals("remove"))
                    arithmeticCalculator.removeResult();

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                /* 위 요구사항에 맞게 소스 코드 수정  클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현 */
                if (sc.next().equals("inquiry")) {
                    arithmeticCalculator.inquiryResultArray();
                }
            } else if (flag == 2) {
                System.out.print("반지름을 입력하세요: ");
                double radius = sc.nextDouble();
                double resultRadius = 0;

                try{
                    resultRadius = circleCalculator.calculate(radius);
                }catch (Exception e) {}

                System.out.println("결과: " + resultRadius);

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                /* 위 요구사항에 맞게 소스 코드 수정  클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현 */
                if (sc.next().equals("inquiry")) {
                    circleCalculator.inquiryResultArray();
                }
            } else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
                sc.nextLine();
                continue;
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            if (sc.next().equals("exit"))
                break;
        }
    }
}