package effective.chapter06.item33;

import java.util.EnumMap;
import java.util.Map;

/**
 * 使用序号进行序号二次的数组的数组
 *
 * @author WangChao
 * @create 2018/4/16 1:08
 */
public enum C_Phase {
    SOLID, LIQUID, GAS;

    public enum Transition {
        MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID), BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
        SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
        private final C_Phase src;
        private final C_Phase dst;

        Transition(C_Phase src, C_Phase dst) {
            this.src = src;
            this.dst = dst;
        }

        private static final Map<C_Phase, Map<C_Phase, Transition>> m = new EnumMap<C_Phase, Map<C_Phase, Transition>>(C_Phase.class);

        static {
            for (C_Phase c_phase : C_Phase.values()) {
                m.put(c_phase, new EnumMap<C_Phase, Transition>(C_Phase.class));
            }
            for (Transition transition : Transition.values()) {
                m.get(transition).put(transition.dst, transition);
            }
        }

        public static Transition from(C_Phase src, C_Phase dst) {
            return m.get(src).get(dst);
        }
    }
}
