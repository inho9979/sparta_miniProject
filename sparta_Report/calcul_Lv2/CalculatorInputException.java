package sparta_Report.calcul_Lv2;

public class CalculatorInputException extends Exception{
    public CalculatorInputException(){
        super("잘못된 숫자 혹은 연산자가 입력되었습니다!");
    }
}
