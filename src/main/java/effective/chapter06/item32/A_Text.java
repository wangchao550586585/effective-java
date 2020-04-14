package effective.chapter06.item32;

/**
 * 位域以数字形式打印时,翻译位域难,没法遍历
 * 解决办法:枚举代替位域
 * @author WangChao
 * @create 2018/4/15 13:18
 */
public class A_Text {
    public static final int STYLE_BOLD = 1 << 0;
    public static final int STYLE_ITALIC = 1 << 1;
    public static final int STYLE_UNDERLINE = 1 << 2;
    public static final int STYLE_STRIKETHROUGH = 1 << 3;

    public void applyStyles(int styles) {

    }
    public static void main(String[] args) {
        //位域:用OR位运算符将几个常量合并到一个集合中
        new A_Text().applyStyles(STYLE_BOLD | STYLE_ITALIC);

    }
}
