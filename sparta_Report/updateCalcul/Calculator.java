package sparta_Report.updateCalcul;

import java.util.ArrayList;
import java.util.List;

/*1. App class 안에 Calculator class를 구현하는 것은 좋은 방법이 아니에요. 별도의 class로 외부에 노출하는 것이 좋겠어요.*/

public abstract class Calculator {

    private final List<Double> resultArray;
    public static final double PI = 3.14;

    public Calculator(){
        resultArray = new ArrayList<>();
    }

    public Calculator(List<Double> list){
        resultArray = list;
    }

    // getter setter 메서드 모두 깊은복사
    public List<Double> getResultArray(){
        List<Double> tempList = new ArrayList<>(resultArray);
        return tempList;
    }

    /*2. Calculator 클래스 내 calculate라는 이름에 다형성 abstract method가 존재하는데 이는 Calculator를 상속받은 자식은 반드시 재구현해야 하므로
     불필요한 메소드로 인한 혼란이 있을 수 있어요. abstract는 신중히 고민하여 상속이 필요한 경우에 사용하시면 좋겠어요.*/
//    public abstract double calculate(double radius) throws sparta_Report.calcul_Lv2.CalculatorInputException;
//    public abstract double calculate(double number1, double number2, char operator) throws CalculatorInputException;


    /*3. CircleCalculator에도 calculator에 공통 기능인 삭제, 조회 기능이 있으면 더 좋겠어요.*/
    public void setResultArray(List<Double> list){
        resultArray.addAll(list);
    }

    public void removeResult(){
        resultArray.removeFirst();
    }

    public void addResultArray(Double value){
        resultArray.add(value);
    }

    abstract public void inquiryResultArray();
}
