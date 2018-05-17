package cn.tyrone.java.designpattern.dynamicproxy.jdk;

public class JDKProxyTest {
	public static void main(String[] args) {
		IPCBrand pcBrand = new LenevoPCBrand();
		
		JDKProxy jdkProxy = new JDKProxy();
		// 绑定真实对象
		IPCBrand pcBrandProxy = (IPCBrand)jdkProxy.bind(pcBrand);
		
		String pcModel = "G470-New";
		pcBrandProxy.makePC(pcModel);
		pcBrandProxy.sellPC(pcModel);
	}
}
