package effective.chapter06.item31;

/**
 * @author WangChao
 * @create 2018/2/27 19:00
 */
public enum A_Ensemble {
    SOLO,DUET,TRIO,OCTET;
    //ordinal:返回每个枚举常量在类型中的数字位置
    public  int numberOfMusicians(){
        return ordinal()+1;
    }

    public static void main(String[] args) {
        System.out.println(SOLO.numberOfMusicians());
        System.out.println(DUET.numberOfMusicians());
        System.out.println(TRIO.numberOfMusicians());
        System.out.println(OCTET.numberOfMusicians());
    }
}
