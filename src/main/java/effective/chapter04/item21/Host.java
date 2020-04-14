package effective.chapter04.item21;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author WangChao
 * @create 2018/1/17 21:05
 */
public class Host {

    private static class StrLenCmp implements Comparator<String>, Serializable {
        public int compare(String s1, String s2) {
            return s1.length()- s2.length();
        }
    }
    public static final Comparator<String> INSTANCE=new StrLenCmp();

    public static void main(String[] args) {
        /*
        1:策略只用一次时,用匿名内部类即可
        2:当被重复利用时,就需要实现为私有的静态成员变量,并通过公有的静态final域导出,其实现策略接口
        因为策略接口被用作所有具体策略实例的类型,所以并不需要为了导出具体策略,而把具体策略类做成pubic。
           宿主类导出公有的静态域或者静态工厂方法,其类型为策略接口即可
         */
        Arrays.sort(new String[2], new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
    }
}
