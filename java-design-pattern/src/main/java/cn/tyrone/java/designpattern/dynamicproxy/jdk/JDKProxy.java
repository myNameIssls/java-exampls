package cn.tyrone.java.designpattern.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 使用jdk实现动态代理方法
 * @author shanglishuai
 *
 */
public class JDKProxy implements InvocationHandler {

	// 真实对象
	private Object target = null;
	
	/**
	 * 建立代理对象与真实对象的代理关系，并返回代理对象
	 * @param target 真实对象
	 * @return 代理对象
	 */
	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

	/**
	 * 代理方法逻辑
	 * @param proxy 代理对象
	 * @param method 当前调度方法
	 * @param args 当前方法参数
	 * @return 代理结果返回
	 * @throws Throwable 异常
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用真实对象的业务方法之前的业务逻辑");
		Object obj = method.invoke(target, args); // 调用真实对象的业务处理方法
		System.out.println("调用真实对象的业务方法之后的业务逻辑");
		System.out.println("\n");
		return obj;
	}

}
