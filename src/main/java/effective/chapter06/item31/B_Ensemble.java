// Enum with integer data stored in an instance field
package effective.chapter06.item31;

/**
 * 永远不要根据枚举的序数导出与它关联的值,而是要将它保存在一个实例域中
 */
public enum B_Ensemble {
	SOLO(1), DUET(2), TRIO(3), QUARTET(4), QUINTET(5), SEXTET(6), SEPTET(7), OCTET(
			8), DOUBLE_QUARTET(8), NONET(9), DECTET(10), TRIPLE_QUARTET(12);

	private final int numberOfMusicians;

	B_Ensemble(int size) {
		this.numberOfMusicians = size;
	}

	public int numberOfMusicians() {
		return numberOfMusicians;
	}
}
