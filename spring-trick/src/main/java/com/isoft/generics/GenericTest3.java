package com.isoft.generics;

public class GenericTest3 {
	public static void main(String[] args) {

		Box<String> name = new Box<String>("corn");
		Box<Integer> age = new Box<Integer>(712);
		Box<Number> number = new Box<Number>(314);

		getData(name);
		getData(age);
		getData(number); // 2
		
		
		
		//getUpperNumberData(name); // 1    调用将出现错误提示
        getUpperNumberData(age);    // 2
        getUpperNumberData(number); // 3

	}

	//我们需要一个在逻辑上可以用来表示同时是Box<Integer>和Box<Number>的父类的一个引用类型，由此，类型通配符应运而生。
	
	//类型通配符一般是使用 ?代替具体的类型实参。
	//注意了，此处是类型实参(String,Number)，而不是类型形参(T)！
	//且Box<?>在逻辑上是Box<Integer>、Box<Number>...等所有Box<具体类型实参>的父类。由此，我们依然可以定义泛型方法，来完成此类需求。
	 
	public static void getData(Box<?> data) {
		System.out.println("data :" + data.getData());
	}
	
	
	//有时候，我们还可能听到类型通配符上限和类型通配符下限。具体有是怎么样的呢？
	//在上面的例子中，如果需要定义一个功能类似于getData()的方法，
	//但对类型实参又有进一步的限制：只能是Number类及其子类。此时，需要用到类型通配符上限。
	
    public static void getUpperNumberData(Box<? extends Number> data){
        System.out.println("data :" + data.getData());
    }
	
	//类型通配符上限通过形如Box<? extends Number>形式定义，
    //相对应的，类型通配符下限为Box<? super Number>形式，其含义与类型通配符上限正好相反，在此不作过多阐述了。
	
}
