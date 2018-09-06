package ind.sw.j2se.enumdemo;

/**
 * 
 * @author john
 * @date 2017年12月15日
 * @time 下午4:06:18
 * @description 直接在枚举类里面定义一个字段name，然后定义一个构造函数，这样我们就可以定义我们想要的很多功能了
 *              enum修饰的类不能被其他类继承，也不能继承其他类。原因在于，enum默认继承了Enum类，所以不能多重继承，而被enum修饰的类默认为final的，所以也不能衍生出子类。但是，它可以实现其他接口。为了可以达到子类扩展的效果，我们可以考虑利用interface来组织enum元素，即在interface内部定义enum块，通过继承接口，达到组合enum元素的目的。
 *
 */
// enum修饰的代码块就看做是一个普通的类
// 所以我们可以在enum类中，写自己的构造方法，写成员方法，定义成员变量等等

public enum Hello2 {
	// 每个enum元素都是其类的static final实例
	// enum类中的元素定义必须写在所有其他部分（例如定义成员变量，定义构造方法，定义成员方法）前面，否则编译器会报错。
	A("Jenny"), B("Tom"), C("Antia"), D("Crite");

	private String name;

	// enum类里面的构造函数只能使用private来修饰，或者是默认的修饰符。
	Hello2(String name) {

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
