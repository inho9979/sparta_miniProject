package sparta_Report.calcul_Lv2;

public class MultiplyOperator extends Operator{

    public MultiplyOperator(double number1, double number2){
        super(number1,number2);
    }
    @Override
    public double operator() {
        double number1 = getNumber1();
        double number2 = getNumber2();
        return number1 * number2;
    }
}
