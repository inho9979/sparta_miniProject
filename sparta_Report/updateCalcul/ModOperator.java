package sparta_Report.updateCalcul;

public class ModOperator implements Operator{
    @Override
    public double operate(double num1, double num2) {
        if(num2 == 0)
            throw new ArithmeticException("분모가 0이되면 안됩니다");
        return num1 / num2;
    }
}
