package com.smart.smile.annotation;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * spring框架会使用cglib字节码技术实现该抽象类的具体实现类
 */
@Component
public abstract class CommandManager {

	public Object process(int id) {
		Command command = createCommand();
		command.setId(id);
		return command.execute();
	}

	/**
	 * 问题： 单例bean依赖原型bean，在每次调用时，创建一个新的原型bean
	 * 结果： 创建单例bean时，已经创建了一个原型bean，在每次调用时使用的都是同一个原型bean
	 * 解决方法： 使用lookup注解，同时原型bean设置为原型
	 *
	 * 该注解主要解决在单例中引用原型bean时，只创建一次原型bean的问题。
	 * Command 的scope为原型
	 * cglib实现该类
	 * @return
	 */
	@Lookup
	public abstract Command createCommand();
}
