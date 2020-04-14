package effective.chapter06.item34;

import effective.chapter06.item30.Operation;

import java.util.Arrays;
import java.util.Collection;

/**
 * 用接口模拟可伸缩的枚举
 *
 * @author WangChao
 * @create 2018/4/16 12:30
 */
public enum A_BasicOperation implements A_Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    }, MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    }, TIMES("*") {
        public double apply(double x, double y) {
            return x * y;
        }
    }, DIVIDE("/") {
        public double apply(double x, double y) {
            return x / y;
        }
    }, EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    }, REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    };
    private final String symbol;

    A_BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public static void main(String[] args) {
        double x = Double.parseDouble("1.2");
        double y = Double.parseDouble("1.2");
        test(A_BasicOperation.class, x, y);
        test2(Arrays.asList(A_BasicOperation.values()), x, y);
    }

    /**
     * <T extends Enum<T> & A_Operation>：确保class表示枚举,有表示Operation的子类型
     *
     * @param opSet
     * @param x
     * @param y
     * @param <T>
     */
    private static <T extends Enum<T> & A_Operation> void test(Class<T> opSet, double x, double y) {
        for (A_Operation op : opSet.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }

    private static void test2(Collection<? extends A_Operation> opSet, double x, double y) {
        for (A_Operation op : opSet) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
