// Broken! - What does this program print?
package effective.chapter07.item41;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class A_CollectionClassifier {
    /*public static String classify(Set<?> s) {
		return "Set";
	}

	public static String classify(List<?> lst) {
		return "List";
	}

	public static String classify(Collection<?> c) {
		return "Unknown Collection";
	}*/

    /**
     * 重载时,参数编译类型决定运行时类型
     * 如何避免:
     *  1:方法名区分
     *  2:参数类型以及个数区分
     *  3:构造器之间的重载可以用静态工厂区分
     *  4:让更具体的重载方法把调用转发给更一般化得重载方法
     * @param c
     * @return169
     */
    public static String classify(Collection<?> c) {
        return c instanceof Set ? "Set" : (c instanceof List ? "List" : "Unknown Collection");
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<String>(),
                new ArrayList<BigInteger>(),
                new HashMap<String, String>().values()};

        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}
