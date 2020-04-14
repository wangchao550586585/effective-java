// Enum type with constant-specific class bodies and data - Page 153
package effective.chapter06.item30;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    PLUS("+") {
        double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        double apply(double x, double y) {
            return x / y;
        }
    };
    private final String symbol;

    Operation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    abstract double apply(double x, double y);

    // Implementing a fromString method on an enum type - Page 154
    //每个常量都从自己的构造器中将自身放入map中,会导致编译错误,因为在构造器运行时,静态域还没有初始化
    private static final Map<String, Operation> stringToEnum = new HashMap<String, Operation>();

    static { // Initialize map from constant name to enum constant
        for (Operation op : values())
            stringToEnum.put(op.toString(), op);
    }

    // Returns Operation for string, or null if string is invalid
    public static Operation fromString(String symbol) {
        return stringToEnum.get(symbol);
    }

    // Test program to perform all operations on given operands
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        for (Operation op : Operation.values())
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }

    /**
     * switch适合给外部的枚举类型增加特定于常量的行为
     *  返回每个运算的反运算
     * @param op
     * @return
     */
    public static Operation inverse(Operation op) {
        switch (op) {
            case PLUS:
                return Operation.MINUS;
            case MINUS:
                return Operation.PLUS;
            case TIMES:
                return Operation.DIVIDE;
            case DIVIDE:
                return Operation.TIMES;
            default:
                throw new AssertionError("");
        }
    }
}
