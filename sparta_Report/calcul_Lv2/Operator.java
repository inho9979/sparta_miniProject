package sparta_Report.calcul_Lv2;

public abstract class Operator {
    double number1;
    double number2;

    public Operator(double num1, double num2){
        number1 = num1;
        number2 = num2;
    }

    public abstract double operator();

    public double getNumber1(){
        return number1;
    }

    public double getNumber2(){
        return number2;
    }
}
