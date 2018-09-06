package ind.sw.j2se.thread.singleton;

/**
 * volatile
 * 作用1：有序性                   状态检查
 * 作用2：可见性                   双重校验锁
 * 
 * @author john
 * @date   2017年12月15日
 * @time   下午3:21:39
 * @description double check http://www.importnew.com/18126.html
 */
public class Singleton {
	private volatile static Singleton instance = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null)
					instance = new Singleton();
			}
		}
		return instance;
	}
}
