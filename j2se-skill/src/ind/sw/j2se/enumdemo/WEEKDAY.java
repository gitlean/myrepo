package ind.sw.j2se.enumdemo;

public enum WEEKDAY {
	MONDAY("This is the First Day of the week") {
		@Override
		boolean test() {
			return false;
		}
	},
	TUESDAY("This is the Second Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	WEDNSDAY("This is the Third Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	THURSDAY("This is the Forth Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	FRIDAY("This is the Fifth Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	SATURDAY("This is the Sixth Day") {
		@Override
		boolean test() {
			return false;
		}
	},
	SUNDAY("this is the Seventh Day") {
		@Override
		boolean test() {
			return false;
		}
	};

	private String description; // 自定义成员变量

	private WEEKDAY(String des) {
		this.description = des;
	} // 自定义构造方法

	public String getDescripiton() {
		return this.description;
	} // 自定义成员方法

	abstract boolean test();// 由实例去实现的抽象方法
}