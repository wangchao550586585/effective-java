// Simple immutable two-dimensional integer point class - Page 37
package effective.chapter03.item08;

public class Point {
	private final int x;
	private final int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Point))
			return false;
		Point p = (Point) o;
		return p.x == x && p.y == y;
	}

	/**
	 * 保证每个独立的类进行比较
	 * 违反里氏替换原则,一个类型的任何重要属性也适用子类
	 * @return
	 */
	// Broken - violates Liskov substitution principle - Pages 39-40
	// @Override public boolean equals(Object o) {
	// if (o == null || o.getClass() != getClass())
	// return false;
	// Point p = (Point) o;
	// return p.x == x && p.y == y;
	// }

	// See Item 9
	@Override
	public int hashCode() {
		return 31 * x + y;
	}
}
