package sparta_Report.updateCalcul;

import java.util.List;

public class CircleCalculator extends Calculator {

    public CircleCalculator() {
    }

    public CircleCalculator(List<Double> list) {
        super(list);
    }

    /*4. Throws 하는 예외 회피는 해당 메소드를 호출하는 상위 객체로
     예외를 전달하기 때문에 실제 발생하지 않는 예외를 처리해야 하는 오류를 발생할 수 있어요. 신중히 사용해 보세요.*/
    public double calculate(double radius) {
        double result;
        /*5. radius*radius*3.14에 사용된 것과 같은 상숫값들은 변경에 용이하고 재사용할 수 있으니선언하여 사용하는 것이 더 좋아요.*/
        result = radius * radius * PI;

        super.addResultArray(result);
        return result;
    }

    @Override
    public void inquiryResultArray() {
        int count = 1;
        for (double e : super.getResultArray()) {
            System.out.println(count + "번째 원의 넓이: " + e);
        }
    }
}
