package newlandframework.ruleengine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestMain {
	public static void main(String[] args) {
		// 创建一个默认的幸运用户对象
		// 在客户端中初始化一个属性（homeCity、msisdn、userId）都是空（null）的幸运用户对象LuckyUsers
		LuckUsers luck = new LuckUsers();

		// 业务规定的vpn产品对象
		UserProduct vpn = new UserProduct();
		vpn.setProductId(UserProduct.VPNPRODUCT);

		// 业务规定的家庭产品对象
		UserProduct family = new UserProduct();
		family.setProductId(UserProduct.FAIMILYPROUDCT);

		// --------------------------------------------------

		// 存放用户已经订购的产品列表
		List<UserProduct> listProduct = new ArrayList<UserProduct>();

		// 创建测试用户，用户号码119，用户归属地市591，用户标识1240
		Integer homeCity = new Integer(591);
		Integer userId = new Integer(1240);
		Integer msisdn = new Integer(119);
		// 假设用户还订购了其他的4G飞享套餐，产品编码是1000000003
		Integer otherProductId = new Integer(1000000003);

		UserProduct userProduct1 = new UserProduct();
		userProduct1.setHomeCity(homeCity);
		userProduct1.setProductId(otherProductId);
		userProduct1.setProductName("4G飞享套餐");
		userProduct1.setUserId(userId);
		listProduct.add(userProduct1);

		UserProduct userProduct2 = new UserProduct();
		userProduct2.setHomeCity(homeCity);
		userProduct2.setProductId(UserProduct.VPNPRODUCT);
		userProduct2.setProductName("VPN产品");
		userProduct2.setUserId(userId);
		listProduct.add(userProduct2);

		UserProduct userProduct3 = new UserProduct();
		userProduct3.setHomeCity(homeCity);
		userProduct3.setProductId(UserProduct.FAIMILYPROUDCT);
		userProduct3.setProductName("家庭产品");
		userProduct3.setUserId(userId);
		listProduct.add(userProduct3);

		// 传入一个用户刚好符合上述业务规则决策条件的“事实”用户
		Users user = new Users();
		user.setHomeCity(homeCity);
		user.setMsisdn(msisdn);
		user.setUserBrand(Users.MZONE); //用户品牌属性
		user.setUserId(userId);
		user.setUserProduct(listProduct);

		// 业务规则关注的事实对象
		ArrayList<Object> elements = new ArrayList<Object>();
		elements.add(vpn);
		elements.add(family);
		elements.add(userProduct1);
		elements.add(userProduct2);
		elements.add(userProduct3);
		elements.add(user);
		elements.add(luck);

		//drlContent是指业务规则的内容，   规则脚本可以从数据库获取，这里直接从外存读，
		String path = "D:/projects/git/myrepo/rule-engine/src/main/java/newlandframework/ruleengine/mypoint.drl";
		String drlContent = readFileContent(path);

		System.out.println("业务规则判断之前：" + luck);

		// 加入业务规则引擎中执行决策
		new BusinessRuleRunner().notify(drlContent, elements);

		// 可以继续加入业务规则引擎 执行决策
		// ...

		/**
		 * 后续如果业务部门又改变业务规则，我们只要重新编写或者修改一个规则配置，然后重新发布、刷新缓存，既可以符合要求，又省去了很多代码编译、发布、上线等等一系列繁琐的中间步骤。最关键的是我们的代码框架也会变得非常灵活。
		 */

		System.out.println("业务规则判断之后：" + luck);

		System.out.println("<<<<<<<>>>>>>>>>>>>>");
	}

	public static String readFileContent(String path) {
		String rdata = "";
		File file = new File(path);

		BufferedReader reader = null;
		try {
			String line = null;
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			while (null != (line = reader.readLine())) {
				rdata += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return rdata;
	}
}
