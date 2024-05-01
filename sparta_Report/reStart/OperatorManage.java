package sparta_Report.reStart;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class OperatorManage {

    public enum OperatorType{
        ADD,
        SUB,
        MULTI,
        DIVIDE,
        MOD
    }

    OperatorType type;

    Map<OperatorType, Operator> operatorMap;

    public OperatorManage(){
        // 이중괄호 초기화 : 익명 클래스를 통해 초기화하는 방식, 가독성은 좋지만 메모리 사용량이 크다고 한다
//        operatorMap = new HashMap<>(){
//            {
//                put(OperatorType.ADD, new AddOperator());
//                put(OperatorType.SUB, new SubtractOperator());
//                put(OperatorType.MULTI, new MultiplyOperator());
//                put(OperatorType.DIVIDE, new DivideOperator());
//                put(OperatorType.MOD, new ModOperator());
//            }
//        };
        // Stream API를 통한 초기화... 따라는 했는데 벌써부터 어지럽다
        operatorMap = Stream.of(new Object[][]{
                {OperatorType.ADD, new AddOperator()},
                {OperatorType.SUB, new SubtractOperator()},
                {OperatorType.MULTI, new MultiplyOperator()},
                {OperatorType.DIVIDE, new DivideOperator()},
                {OperatorType.MOD, new ModOperator()}
        }).collect(toMap(data -> (OperatorType)data[0], data -> (Operator) data[1]));
    }

    public void setOperator(char operator){

        if (!(operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%')) {
            throw new UnsupportedOperationException("잘못된 연산자 입력입니다");
        }
        else{
            switch(operator) {
                case '+' -> type = OperatorType.ADD;
                case '-' -> type = OperatorType.SUB;
                case '*' -> type = OperatorType.MULTI;
                case '/' -> type = OperatorType.DIVIDE;
                case '%' -> type = OperatorType.MOD;
            }
        }


//        if (operatorMap.containsKey(type)) {
//            return;
//        }
//        else{
//            switch (type) {
//                case ADD -> operatorMap.put(type, new AddOperator());
//                case SUB -> operatorMap.put(type, new SubtractOperator());
//                case MULTI -> operatorMap.put(type, new MultiplyOperator());
//                case DIVIDE -> operatorMap.put(type, new DivideOperator());
//                case MOD -> operatorMap.put(type, new ModOperator());
//            }
//        }
    }

    public Operator getOperator(){
//        if(operatorMap.containsKey(operator)) {
//            return operatorMap.get(operator);
//        }
//        else{
//            return null;
//        }
        return operatorMap.get(type);
    }
}
