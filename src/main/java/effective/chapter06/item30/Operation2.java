// Enum type with constant-specific class bodies and data - Page 153
package effective.chapter06.item30;

import java.util.HashMap;
import java.util.Map;

/**
 * 添加新的常量,需要给switch添加相应条件
 * 没有throw不能编译,而事实上无法运行到这里
 */
public enum Operation2 {
    PLUS,
    MINUS,
    TIMES,
    DIVIDE;

    double apply(double x, double y) {
        switch (this) {
            case PLUS:
                return x + y;
            case MINUS:
                return x - y;
            case TIMES:
                return x * y;
            case DIVIDE:
                return x / y;
        }
        throw new AssertionError("Unknown op:" + this);
    }

}
