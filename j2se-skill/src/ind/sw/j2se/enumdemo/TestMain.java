package ind.sw.j2se.enumdemo;

import java.util.Random;

public class TestMain {
	public static void main(String[] args) {
		for (WEEKDAY w : WEEKDAY.values()) {
			System.out.println(w + " --> " + w.ordinal() + " : " + w.getDeclaringClass());
		}

		for (WEEKDAY w : WEEKDAY.values()) {
			System.out.println(w.getDescripiton());
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(randomEnum(WEEKDAY.class));
		}
	}

	// 随机选择enum元素
	public static <T extends Enum<T>> T randomEnum(Class<T> ec) {
		Random random = new Random();
		T[] enums = ec.getEnumConstants();
		return enums[random.nextInt(enums.length)];
	}

}
