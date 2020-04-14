package effective.chapter04.item14;

import org.omg.CORBA.PRIVATE_MEMBER;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author WangChao
 * @create 2018/1/4 22:49
 */
public class Demo {
    //这样还是可以修改对象的内容
    public static final Object[] VALUES = {};

    //方法1:公有数组变私有,增加公有的不可变列表
    private static final Object[] PRIVATE_VALUES = {};
    public static final List<Object> VALUE = Collections.unmodifiableList(Arrays.asList(PRIVATE_VALUES));

    //方法2:数组变私有,返回数组备份
    private static final Object[] PRIVATE_VALUES2 = {};
    /*public static final Object[] values() {
        return PRIVATE_MEMBER.clone();

    }*/
}
