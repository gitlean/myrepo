package ind.sw.j2se.enumdemo;

public class Test2 {
	public static void main(String[] args) {
		Hello2.A.setName("good");
		String hello = Hello2.A.getName();
		System.out.println(hello);
		
		String name = Hello2.B.getName();
		System.out.println(name);
	}
}
