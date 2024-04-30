package sparta_Report.calcul_Lv2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;

public class App {
    public static void main(String[] args){

        double result = 0;
        /* Calculator 인스턴스 생성 */
        //Calculator calculator = new Calculator(new ArrayList<>(), new ArrayList<>());

        String exitStr = "";
        Scanner sc = new Scanner(System.in);

        //클래스 분할후
        Calculator arithmeticCalculator = new ArithmeticCalculator(new ArrayList<>());
        Calculator circleCalculator = new CircleCalculator(new ArrayList<>());


        /* 반복문 시작 */
        while(!exitStr.equals("exit")) {

            System.out.print("사칙연산 계산을 원하면 1, 원 넓이 계산을 원하면 2를 눌러주세요 :");
            int flag = sc.nextInt();

            if(flag == 1) {
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();
                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();
                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                sc.nextLine(); // 버퍼비우기

                // 예외처리
                try{
                    result = arithmeticCalculator.calculate(num1, num2, operator);
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }

                System.out.println("결과: " + result);
                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if(sc.nextLine().equals("remove")){
                    arithmeticCalculator.removeArray();
                }

                // setter 사용
                arithmeticCalculator.setResultArray(result);

                // getter 사용
                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if(sc.nextLine().equals("inquiry")){
                    arithmeticCalculator.inquiryResults();
                }
            }
            else if(flag == 2) {
                System.out.print("반지름을 입력하세요: ");
                double radius = sc.nextDouble();
                double resultRadius;
                sc.nextLine(); // 버퍼비우기

                try {
                    resultRadius = circleCalculator.calculate(radius);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                    continue;
                }
                System.out.println("결과: " + resultRadius);

                circleCalculator.setResultArray(resultRadius);

                for(double e : circleCalculator.getResultArray()){
                    System.out.println("원 넓이 결과: " + e);
                }

            }
            else {
                System.out.println("잘못된 입력입니다 다시 입력해주세요");
                sc.nextLine();
                continue;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            exitStr = sc.nextLine();
        }
        /* 반복문 종료 */
    }
}


abstract class Calculator {

    //실수표현 정규식.. [0-9]뒤에 * 와 . 뒤에 ?를 안붙였어서 숫자 체크에 오류발생
    final String REG_Number = "^[0-9]*\\.?[0-9]*$";
    final String REG_Operator = "[+\\-*/%]";
    final String REG_ZeroErrorCheck = "[/%]";
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* 원 넓이 계산 필드, 결과값을 저장하는 컬렉션 필드는 수정이 필요하지 않으므로 final */
    private final List<Double> resultArray;

    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    public Calculator(ArrayList<Double> list){
            resultArray = list;
    }

    public abstract double calculate(double radius) throws CalculatorInputException;
    public abstract double calculate(double number1, double number2, char operator) throws CalculatorInputException;

    /* Setter 메서드 구현 */
    public void setResultArray(double result){
        resultArray.add(result);
    }

    /* Getter 메서드 구현 */
    public List<Double> getResultArray(){
        return new ArrayList<>(resultArray);
    }
    /* Remove 메서드 구현 */
    public void removeArray() {
        resultArray.removeFirst();
    }

    public void inquiryResults() {
        int count = 0;
        for(double e : resultArray) {
            count++;
            System.out.println(count + "번째 결과: " + e);
        }
    }
}

// 클래스로 구현
//abstract class Calculator {
//
//    final String REG_Number = "^[0-9]\\.[0-9]*$";
//    final String REG_Operator = "[+\\-*/%]";
//    final String REG_ZeroErrorCheck = "[/%]";
//    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
//    /* 원 넓이 계산 필드, 결과값을 저장하는 컬렉션 필드는 수정이 필요하지 않으므로 final */
//    private final List<Double> resultArray;
//
//    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
//    public Calculator(ArrayList<Double> list){
//        resultArray = list;
//    }
//
//    public abstract double calculate(double radius) throws CalculatorInputException;
//    public abstract double calculate(double number1, double number2, char operator) throws CalculatorInputException;
//
//    /* Setter 메서드 구현 */
//    public void setResultArray(double result){
//        this.resultArray.add(result);
//    }
//
//    /* Getter 메서드 구현 */
//    public List<Double> getResultArray(){
//        return new ArrayList<>(resultArray);
//    }
//    /* Remove 메서드 구현 */
//    public void removeArray() {
//        this.resultArray.removeFirst();
//    }
//
//    public void inquiryResults() {
//        int count = 0;
//        for(double e : this.resultArray) {
//            count++;
//            System.out.println(count + "번째 결과: " + e);
//        }
//    }
//}

// Lv2 초기 요구사항 코드
//public class App {
//    public static void main(String[] args){
//
//        int result = 0;
//        /* Calculator 인스턴스 생성 */
//        Calculator calculator = new Calculator(new ArrayList<>(), new ArrayList<>());
//
//        String exitStr = "";
//        Scanner sc = new Scanner(System.in);
//
//        /* 반복문 시작 */
//        while(!exitStr.equals("exit")) {
//
//            System.out.print("사칙연산 계산을 원하면 1, 원 넓이 계산을 원하면 2를 눌러주세요 :");
//            int flag = sc.nextInt();
//
//            if(flag == 1) {
//                System.out.print("첫 번째 숫자를 입력하세요: ");
//                int num1 = sc.nextInt();
//                System.out.print("두 번째 숫자를 입력하세요: ");
//                int num2 = sc.nextInt();
//                System.out.print("사칙연산 기호를 입력하세요: ");
//                char operator = sc.next().charAt(0);
//
//                sc.nextLine(); // 버퍼비우기
//
//                // 예외처리
//                try{
//                    result = calculator.calculate(num1, num2, operator);
//                }catch (Exception e) {
//                    System.out.println(e.getMessage());
//                    continue;
//                }
//
//                System.out.println("결과: " + result);
//                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
//                if(sc.nextLine().equals("remove")){
//                    calculator.removeArray();
//                }
//
//                // setter 사용
//                calculator.resultArraySetter(result);
//
//                // getter 사용
//                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
//                if(sc.nextLine().equals("inquiry")){
//                    calculator.inquiryResults();
//                }
//            }
//            else if(flag == 2) {
//                System.out.print("반지름을 입력하세요: ");
//                double radius = sc.nextDouble();
//                double resultRadius;
//                sc.nextLine(); // 버퍼비우기
//
//                resultRadius = calculator.calculateCircleArea(radius);
//                System.out.println("결과: " + resultRadius);
//
//                calculator.setResultCircleArray(resultRadius);
//
//                for(double e : calculator.resultArrayGetter()){
//                    System.out.println("원 넓이 결과: " + e);
//                }
//
//            }
//            else {
//                System.out.println("잘못된 입력입니다 다시 입력해주세요");
//                sc.nextLine();
//                continue;
//            }
//
//            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
//            exitStr = sc.nextLine();
//        }
//        /* 반복문 종료 */
//    }
//}
//
//
//class Calculator {
//
//    final String REG_Number = "^[0-9]*$";
//    final String REG_Operator = "[+\\-*/%]";
//    final String REG_ZeroErrorCheck = "[/%]";
//    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
//    private final List<Integer> resultArray;
//
//    /* 원 넓이 계산 필드, 결과값을 저장하는 컬렉션 필드는 수정이 필요하지 않으므로 final */
//    private final List<Double> resultCircleArray;
//
//
//    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
//    public Calculator(ArrayList<Integer> list, ArrayList<Double> list2){
//        resultArray = list;
//        resultCircleArray = list2;
//    }
//
//    public int calculate(int number1, int number2, char oper) throws CalculatorInputException{
//        int result = 0;
//        String operator = Character.toString(oper);
//
//        if(!operator.matches(REG_Operator)){
//            System.out.println("연산자오류");
//            throw new CalculatorInputException();
//        }
//        else if(!Integer.toString(number1).matches(REG_Number) && !Integer.toString(number2).matches(REG_Number)){
//            System.out.println("숫자오류");
//            throw new CalculatorInputException();
//        }
//        else if(operator.matches(REG_ZeroErrorCheck)){
//            if(number2 == 0) {
//                System.out.println("제로오류");
//                throw new CalculatorInputException();
//            }
//        }
//
//        switch (operator){
//            case "+" -> result = number1 + number2;
//            case "-" -> result = number1 - number2;
//            case "*" -> result = number1 * number2;
//            case "/" -> result = number1 / number2;
//            case "%" -> result = number1 % number2;
//        }
//        return result;
//    }
//
//    /* Setter 메서드 구현 */
//    public void resultArraySetter(int result){
//        this.resultArray.add(result);
//    }
//
//    /* Getter 메서드 구현 */
//    public List<Integer> resultArrayGetter(){
//
//        return new ArrayList<>(resultArray);
//    }
//    /* Remove 메서드 구현 */
//    public void removeArray() {
//        this.resultArray.removeFirst();
//    }
//
//    public void inquiryResults() {
//        int count = 0;
//        for(int e : this.resultArray) {
//            count++;
//            System.out.println(count + "번째 결과: " + e);
//        }
//    }
//
//    /* 원 넓이 관련 메서드 구현 */
//
//    public Double calculateCircleArea(double radius) {
//        return radius*radius*3.14;
//    }
//
//    public void setResultCircleArray(double result){
//        resultCircleArray.add(result);
//    }
