package sparta_Report.reStart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Calculator 인스턴스 생성 */
        Calculator calculator = new Calculator();

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
            /* 위 요구사항에 맞게 소스 코드 수정 */
            try{
                calculator.calculate(number1,number2,oper);
            }catch (Exception e)
            {
               System.out.println(e.getMessage());
            }
            System.out.println("결과: " + result);
            /* 배열에서 컬렉션으로 변경됨으로써 변경해야하는 부분 구현 */
            calculator.resultArray.add(result);
            /* 요구사항에 맞게 구현 remove”라는 문자열을 입력받으면 가장 먼저 저장된 결과가 삭제될 수 있도록 구현 */
            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove"))
                calculator.resultArray.removeFirst();

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            int count = 1;
            if(sc.next().equals("inquiry")){
                for(int e : calculator.resultArray){
                    System.out.println(count + "번째 결과: " + e);
                }
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            if(sc.next().equals("exit"))
                break;
        }
    }
}