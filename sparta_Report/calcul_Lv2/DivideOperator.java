package sparta_Report.calcul_Lv2;

public class DivideOperator extends Operator{
    char oper;
    public DivideOperator(char oper, double number1, double number2){
        super(number1,number2);
        this.oper = oper;
    }
    @Override
    public double operator() {
        double result = 0;
        if(oper=='/') {
            double number1 = getNumber1();
            double number2 = getNumber2();
            result = number1 / number2;
        }
        else{
            double number1 = getNumber1();
            double number2 = getNumber2();
            result = number1 % number2;
        }
        return result;
    }
}
