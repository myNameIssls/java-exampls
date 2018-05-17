package cn.tyrone.java.designpattern.dynamicproxy.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * Cglib实现动态代理
 * 使用Cglib实现动态代理需要实现MethodInterceptor接口
 * @author shanglishuai
 *
 */
public class CglibProxy implements MethodInterceptor {
	
	/**
	 * 生成Cglib代理对象
	 * @param cls 代理类
	 * @return 代理类的代理对象
	 */
	public Object getProxy(Class cls) {
		
		// Cglib enhancer 增加类对象
		Enhancer enhancer = new Enhancer();
		// 设置增强类型
		enhancer.setSuperclass(cls);
		// 定义代理逻辑对象为当前对象，要求当前对象实现MethodInterceptor接口
		enhancer.setCallback(this);
		// 创建并返回代理对象
		return enhancer.create();
	}
	
	/**
	 * @param proxy 代理对象
	 * @param method 方法
	 * @param args 方法参数
	 * @param methodProxy 方法代理
	 * @return result 代理逻辑返回
	 * @throws Throwable 异常
	 */
	@Override
	public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
		System.out.println("执行真实对象方法之前可以添加的业务逻辑");
		Object result = methodProxy.invokeSuper(proxy, args);
		System.out.println("执行真实对象方法之后可以添加的业务逻辑\n");
		return result;
	}

}
