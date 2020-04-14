package effective.chapter06.item33;

/**
 * 使用序号进行序号二次的数组的数组
 *
 * @author WangChao
 * @create 2018/4/16 1:08
 */
public enum B_Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;
        private static final Transition[][] TRANSITIONS = {
                {null, MELT, SUBLIME},
                {FREEZE, null, BOIL},
                {DEPOSIT, CONDENSE, null}
        };

        public static Transition from(B_Phase src, B_Phase dst) {
            return TRANSITIONS[src.ordinal()][dst.ordinal()];
        }
    }
    }
