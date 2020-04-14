package effective.chapter06.item32;

import java.util.EnumSet;
import java.util.Set;

/**
 * 使用EnumSet代替位域
 * @author WangChao
 * @create 2018/4/15 13:26
 */
public class B_Text {
    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH;
    }

    public void applyStyles(Set<Style> styles) {
    }

    public static void main(String[] args) {
        new B_Text().applyStyles(EnumSet.of(Style.BOLD,Style.ITALIC));
    }
}
