package sparta_Report.reStart;


import java.util.HashMap;
import java.util.Map;

public class OperatorManage {

    Map<Character, Operator> operatorMap;

    public OperatorManage(){
        operatorMap = new HashMap<>();
    }

    public void setOperator(char operator){
        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%')) {
            throw new UnsupportedOperationException("잘못된 연산자 입력입니다");
        }
        else if (operatorMap.containsKey(operator)) {
            return;
        }
        else{
            switch (operator) {
                case '+' -> operatorMap.put(operator, new AddOperator());
                case '-' -> operatorMap.put(operator, new SubtractOperator());
                case '*' -> operatorMap.put(operator, new MultiplyOperator());
                case '/' -> operatorMap.put(operator, new DivideOperator());
                case '%' -> operatorMap.put(operator, new ModOperator());
            }
        }
    }

    public Operator getOperator(char operator){
        if(operatorMap.containsKey(operator)) {
            return operatorMap.get(operator);
        }
        else{
            return null;
        }
    }
}
