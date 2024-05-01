package sparta_Report.reStart;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    /* static, final 활용 */
    /* final은 생성후 수정이 필요없는 결과값 배열에 적용, static + final 은 수정하지도 않고, 어떤 한 클래스
      내부에서만 사용하지도 않는 PI 값에 적용 */
    private final List<Double> resultArray;
    /* 원의 넓이 결과를 저장하는 컬렉션 타입의 필드 선언 및 생성 */

    public static final double PI = 3.14;
    /* 연산 결과를 저장하는 컬렉션 타입 필드가 생성자를 통해 초기화 되도록 변경 */
    /* 생성자 구현 */
    public Calculator(List<Double> list){
        resultArray = list;
    }

    public abstract double calculate() throws CalculatorInputException;

    // getter setter 메서드 모두 깊은복사
    public List<Double> getResultArray(){
        List<Double> tempList = new ArrayList<>(resultArray);
        return tempList;
    }

    public void setResultArray(List<Double> list){
        resultArray.addAll(list);
    }

    public void removeResult(){
        resultArray.removeFirst();
    }

    public void addResultArray(double value){
        resultArray.add(value);
    }

    public void inquiryResultArray(){
        int count = 1;
        for(double e : resultArray){
            System.out.println(count + "번째 결과: " + e);
            count++;
        }
    }

    /* 원 관련 */
//    public double calculateCircleArea(double radius) {
//        double result = radius * radius * PI;
//        circleResultArray.add(result);
//        return result;
//    }

//    public List<Double> getCircleResultArray(){
//        List<Double> tempList = new ArrayList<>(circleResultArray);
//        return tempList;
//    }

//    public void setCircleResultArray(List<Double> list){
//        circleResultArray.addAll(list);
//    }

//    public void inquiryCircleResultArray(){
//        int count = 1;
//        for(Double e : circleResultArray){
//            System.out.println(count + "번째 결과: " + e);
//            count++;
//        }
//    }
}
