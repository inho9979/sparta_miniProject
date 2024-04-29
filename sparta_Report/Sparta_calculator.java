package sparta_Report;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sparta_calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = 0, number2 = 0;
        int result = 0;
        String operator = "";
        String exitStr = "";
        List<Integer> numberArray =  new ArrayList<Integer>();
        int count = 0;

        while(!exitStr.equals("exit")) {

            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            number1 = sc.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            number2 = sc.nextInt();
            System.out.print("사칙연산 기호를 입력하세요: ");
            sc.nextLine();
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            operator = sc.nextLine();
            switch(operator){
                case "+" -> result = number1 + number2;
                case "-" -> result = number1 - number2;
                case "*" -> result = number1 * number2;
                case "/" -> result = number1 / number2;
                default -> System.out.println(operator + "는 잘못된 연산자입니다");
            }
            System.out.println("결과: " + result);

            numberArray.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.nextLine().equals("remove")){
                numberArray.removeFirst();
            }
            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if(sc.nextLine().equals("inquiry")){
                for(int e : numberArray){
                    count++;
                    System.out.println(count + "번째 결과:" + e);
                }
                count = 0;
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitStr = sc.nextLine();
        }
    }
}

