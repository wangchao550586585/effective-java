// Test program that uses CounterPoint as Point
package effective.chapter03.item08;

import java.util.HashSet;
import java.util.Set;

/**
 * 按照里氏替换原则,一个类型的任何重要属性也将适用他的子类,因此为该类型编写的任何方法,在子类型上都应该运行好
 * 将CountPoint传递给onUnitCircle,会因为Point的equals采用了getClass,造成返回false
 *
 * */
public class CounterPointTest {
	// Initialize UnitCircle to contain all Points on the unit circle
	private static final Set<Point> unitCircle;
	static {
		unitCircle = new HashSet<Point>();
		unitCircle.add(new Point(1, 0));
		unitCircle.add(new Point(0, 1));
		unitCircle.add(new Point(-1, 0));
		unitCircle.add(new Point(0, -1));
	}

	public static boolean onUnitCircle(Point p) {
		return unitCircle.contains(p);
	}

	public static void main(String[] args) {
		Point p1 = new Point(1, 0);
		Point p2 = new CounterPoint(1, 0);

		// Prints true
		System.out.println(onUnitCircle(p1));

		// Should print true, but doesn't if Point uses getClass-based equals
		System.out.println(onUnitCircle(p2));
	}
}
