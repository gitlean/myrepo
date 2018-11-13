package com.isoft.generics;

//一个最简单的泛型类和方法定义：
public class GenericTest2 {

	public static void main(String[] args) {

		call2();

	}

	public static void call1() {

		Box<String> name = new Box<String>("corn");
		System.out.println("name:" + name.getData());
	}

	public static void call2() {

		Box<String> name = new Box<String>("corn");
		Box<Integer> age = new Box<Integer>(712);

		System.out.println("name class:" + name.getClass()); // com.qqyumidi.Box
		System.out.println("age class:" + age.getClass()); // com.qqyumidi.Box
		
		
		//那么对于不同传入的类型实参，生成的相应对象实例的类型是不是一样的呢？
		System.out.println(name.getClass() == age.getClass()); // true
		
		//由此，我们发现，在使用泛型类时，虽然传入了不同的泛型实参，但并没有真正意义上生成不同的类型，
		//传入不同泛型实参的泛型类在内存上只有一个，即还是原来的最基本的类型（本实例中为Box）
		
	}

}

