package sparta_Report.updateCalcul;

public class AddOperator implements Operator{

//    public final Class<T> type;
//
//    AddOperator(Class<T> type){
//        this.type = type;
//    }

    @Override
    public double operate(double num1, double num2){
        return num1 + num2;
    }
}
