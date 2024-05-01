package sparta_Report.calcul_Lv2;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ArithmeticCalculator extends Calculator{

    public ArithmeticCalculator(ArrayList<Double> list){
        super(list);
    }

    @Override
    public double calculate(double radius) throws CalculatorInputException {
        return 0;
    }

    @Override
    public double calculate(double number1, double number2, char operator) throws CalculatorInputException {
        double result = 0;
        String oper = Character.toString(operator);

        if(!oper.matches(REG_Operator)){
            System.out.println("연산자오류");
            throw new CalculatorInputException();
        }
        else if(!Double.toString(number1).matches(REG_Number) || !Double.toString(number2).matches(REG_Number)){
            System.out.println("숫자오류");
            throw new CalculatorInputException();
        }
        else if(oper.matches(REG_ZeroErrorCheck)){
            if(number2 == 0 ) {
                System.out.println("제로오류");
                throw new CalculatorInputException();
            }
        }

        Operator operClass = null;
        switch (oper){
            case "+" -> {
                operClass = new AddOperator();
            }
            case "-" -> {
                operClass = new SubTractOperator();
            }
            case "*" -> {
                operClass = new MultiplyOperator();
            }
            case "/" -> {
                operClass = new DivideOperator();
            }
            case "%" -> {
                operClass = new ModOperator();
            }
        }
        result = operClass.operator(number1, number2);

        return result;
    }
}

// Operator 클래스로 분할 전 코드..

//public class ArithmeticCalculator extends Calculator{
//
//    public ArithmeticCalculator(ArrayList<Double> list){
//        super(list);
//    }
//    @Override
//    public double calculate(double radius) {
//        return 0;
//    }
//    @Override
//    public double calculate(double number1, double number2, char operator) throws CalculatorInputException {
//        double result = 0;
//
//        String oper = Character.toString(operator);
//
//        if(!oper.matches(REG_Operator)){
//            System.out.println("연산자오류");
//            throw new CalculatorInputException();
//        }
//        else if(!Double.toString(number1).matches(REG_Number) && !Double.toString(number2).matches(REG_Number)){
//            System.out.println("숫자오류");
//            throw new CalculatorInputException();
//        }
//        else if(oper.matches(REG_ZeroErrorCheck)){
//            if(number2 == 0) {
//                System.out.println("제로오류");
//                throw new CalculatorInputException();
//            }
//        }
//
//        switch (oper){
//            case "+" -> result = number1 + number2;
//            case "-" -> result = number1 - number2;
//            case "*" -> result = number1 * number2;
//            case "/" -> result = number1 / number2;
//            case "%" -> result = number1 % number2;
//        }
//
//        return result;
//    }
//}
//
//
//public class ArithmeticCalculator extends Calculator{
//
//    public ArithmeticCalculator(ArrayList<Double> list){
//        super(list);
//    }
//    @Override
//    public double calculate(double radius) {
//        return 0;
//    }
//    @Override
//    public double calculate(double number1, double number2, char operator) throws CalculatorInputException {
//        double result = 0;
//
//        String oper = Character.toString(operator);
//
//        if(!oper.matches(REG_Operator)){
//            System.out.println("연산자오류");
//            throw new CalculatorInputException();
//        }
//        else if(!Double.toString(number1).matches(REG_Number) && !Double.toString(number2).matches(REG_Number)){
//            System.out.println("숫자오류");
//            throw new CalculatorInputException();
//        }
//        else if(oper.matches(REG_ZeroErrorCheck)){
//            if(number2 == 0) {
//                System.out.println("제로오류");
//                throw new CalculatorInputException();
//            }
//        }
//
//        switch (oper){
//            case "+" -> result = number1 + number2;
//            case "-" -> result = number1 - number2;
//            case "*" -> result = number1 * number2;
//            case "/" -> result = number1 / number2;
//            case "%" -> result = number1 % number2;
//        }
//
//        return result;
//    }
//}
