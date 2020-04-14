package effective.chapter06.item36;

import java.util.HashSet;
import java.util.Set;

/**
 * 坚持使用Override注解
 *
 * @author WangChao
 * @create 2018/4/16 14:12
 */
public class A_Bigram {
    private final char first;
    private final char second;

    public A_Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(A_Bigram b) {
        return b.first == first && b.second == second;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof A_Bigram)) return false;
        A_Bigram b = (A_Bigram) obj;
        return b.first == first && b.second == second;
    }

    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
        Set<A_Bigram> s = new HashSet<A_Bigram>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                s.add(new A_Bigram(ch, ch));
            }
        }
        System.out.println(s.size());
    }
}
