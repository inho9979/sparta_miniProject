package sparta_Report.reStart;

import java.util.ArrayList;
import java.util.List;

public abstract class Calculator {

    private final List<Double> resultArray;
    public static final double PI = 3.14;

    public Calculator(){
        resultArray = new ArrayList<>();
    }

    public Calculator(List<Double> list){
        resultArray = list;
    }

    // getter setter 메서드 모두 깊은복사
    public List<Double> getResultArray(){
        List<Double> tempList = new ArrayList<>(resultArray);
        return tempList;
    }

    public void setResultArray(List<Double> list){
        resultArray.addAll(list);
    }

    public void removeResult(){
        resultArray.removeFirst();
    }

    public void addResultArray(double value){
        resultArray.add(value);
    }

    abstract public void inquiryResultArray();
}
