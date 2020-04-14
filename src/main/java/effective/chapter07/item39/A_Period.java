package effective.chapter07.item39;

import java.util.Date;

/**
 * @author WangChao
 * @create 2018/4/17 22:18
 */
public final class A_Period {
    private final Date start;
    private final Date end;

 /*   public A_Period(Date start, Date end) {
        if (start.compareTo(end) > 0) throw new IllegalArgumentException(start + " after " + end);
        this.start = start;
        this.end = end;
    }*/

    /**
     * 为了保护start&end的内部信息不被修改,对构造器可变参数进行保护性拷贝
     * 有效性检查是针对拷贝之后的对象,而不是针对原始对象。这样可以避免检查通过后,数据被改,导致拷贝的是错误数据
     * 没有用Date的clone,是因为Date是final的,不能保证clone返回的是Date的对象
     * @param start
     * @param end
     */
    public A_Period(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        if (this.start.compareTo(this.end) > 0) throw new IllegalArgumentException(start + " after " + end);
    }

/*    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }*/

    /**
     * 方式start和end被修改,使它返回可变内部域的保护性拷贝
     * @return
     */
    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return  new Date(end.getTime());
    }
}
