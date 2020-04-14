package effective.chapter04.item21;


import java.util.Comparator;

/**
 *
 * @author WangChao
 * @create 2018/1/17 21:05
 */
//3:此策略参数固定了,导致客户端无法传递其他策略,所以使用接口
public class StringLengthComparator implements Comparator<String> {
    //2:StringLengthComparator无状态,且没有域,所以这个类的所有实例功能是相互等价的,单例即可
    private StringLengthComparator() {
    }
    public static final StringLengthComparator INSTANCE=new StringLengthComparator();

    //1:
    public int compare(String s1,String s2){
        return s1.length()- s2.length();
    }
}
