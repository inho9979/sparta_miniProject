package sparta_Report.reStart;


import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class OperatorManage {
    Map<OperatorType, Operator> operatorMap;

    public OperatorManage() {
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
        }).collect(toMap(data -> (OperatorType) data[0], data -> (Operator) data[1]));
    }

    public Operator getOperator(char operatorSymbol) {
        OperatorType type = OperatorType.fromOperatorSymbol(operatorSymbol);
        return operatorMap.get(type);
    }
}
