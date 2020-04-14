// Attempting to add a value component to Point - Pages 37 - 38
/**
 * 普通点和有色点比较忽略颜色信息
 * 有色点和普通点比较则类型不匹配
 * 无法再扩展可实例化的类的同时,既增加新值,有保留equals约定
 */
package effective.chapter03.item08;

public class ColorPoint extends Point {
	private final Color color;

	public ColorPoint(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	// Broken - violates symmetry!
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof ColorPoint))
			return false;
		return super.equals(o) && ((ColorPoint) o).color == color;
	}

	/**
	 * 比较时忽略颜色,确保了对称性(A=B,B=A),但牺牲了传递性(A=B,A=C,B!=C)
	 * @param args
	 */
	// Broken - violates transitivity!
	// @Override public boolean equals(Object o) {
	// if (!(o instanceof Point))
	// return false;
	//
	// // If o is a normal Point, do a color-blind comparison
	// if (!(o instanceof ColorPoint))
	// return o.equals(this);
	//
	// // o is a ColorPoint; do a full comparison
	// return super.equals(o) && ((ColorPoint)o).color == color;
	// }

	public static void main(String[] args) {
		// First equals function violates symmetry
		Point p = new Point(1, 2);
		ColorPoint cp = new ColorPoint(1, 2, Color.RED);
		System.out.println(p.equals(cp) + " " + cp.equals(p));

		// Second equals function violates transitivity
		ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
		Point p2 = new Point(1, 2);
		ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);
		System.out.printf("%s %s %s%n", p1.equals(p2), p2.equals(p3),
				p1.equals(p3));
	}
}
