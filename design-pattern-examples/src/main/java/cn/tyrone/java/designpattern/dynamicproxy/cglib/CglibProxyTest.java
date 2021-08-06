package cn.tyrone.java.designpattern.dynamicproxy.cglib;

public class CglibProxyTest {
	public static void main(String[] args) {
		CglibProxy cglibProxy = new CglibProxy();
		LenevoPCBrand lenevoPCBrandProxy = (LenevoPCBrand)cglibProxy.getProxy(LenevoPCBrand.class);
		
		String pcModel = "G470-New";
		
		lenevoPCBrandProxy.makePC(pcModel);
		lenevoPCBrandProxy.sellPC(pcModel);
	}
}
