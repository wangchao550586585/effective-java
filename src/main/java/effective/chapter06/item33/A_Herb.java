package effective.chapter06.item33;

import java.util.*;

/**
 * 使用序号进行索引一次的数组
 * @author WangChao
 * @create 2018/4/15 13:31
 */
public class A_Herb {
    public enum Type {ANNUAL, PERENNIAL, BIENNIAL}

    private final String name;
    private final Type type;

    public A_Herb(String name, Type type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    public static void main(String[] args) {
        A_Herb[] garden = {new A_Herb("a", Type.ANNUAL), new A_Herb("b", Type.PERENNIAL), new A_Herb("c", Type.BIENNIAL)};
        Set<A_Herb>[] herbsByType = new Set[Type.values().length];
        for (int i = 0; i < herbsByType.length; i++) {
            herbsByType[i] = new HashSet<A_Herb>();
        }
        for (A_Herb herb : garden) {
            herbsByType[herb.type.ordinal()].add(herb);
        }
        for (int i = 0; i < herbsByType.length; i++) {
            System.out.printf("%s:%s%n", A_Herb.Type.values()[i], herbsByType[i]);
        }

        //方法2
        EnumMap<Type, Set<A_Herb>> herbsByType2 = new EnumMap<Type, Set<A_Herb>>(Type.class);
        for (Type type : Type.values()) {
            herbsByType2.put(type, new HashSet<A_Herb>());
        }
        for (A_Herb h : garden) {
            herbsByType2.get(h.type).add(h);
        }
        System.out.println(herbsByType2);
    }
}
