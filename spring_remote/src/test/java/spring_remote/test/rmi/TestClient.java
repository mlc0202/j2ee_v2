package spring_remote.test.rmi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_remote.api.entity.UserDO;
import spring_remote.api.service.IUserService;

/**
 * 2012年11月20日 17:16:08
 */
public class TestClient {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext-rmi-client.xml");

		// 获取到远程的remote对象
		IUserService userService = (IUserService) context
				.getBean("userService");

		System.out.println(userService.getInfo());

		System.out.println(userService.sayHello("nick"));

		// 测试获取一个自定义的结构
		UserDO user = userService.getUser();
		System.out.println("user.name:" + user.getName());
		System.out.println("user.score:" + user.getScore());
		
	}

}
