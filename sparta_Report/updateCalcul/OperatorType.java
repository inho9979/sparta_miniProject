package sparta_Report.updateCalcul;

public enum OperatorType {
    ADD('+'),
    SUB('-'),
    MULTI('*'),
    DIVIDE('/'),
    MOD('%');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromOperatorSymbol(char symbol)
    {
        for(OperatorType type : OperatorType.values()){
            if(type.symbol == symbol){
                return type;
            }
        }
        throw new UnsupportedOperationException("잘못된 연산자 입력입니다!");
    }
}
