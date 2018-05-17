package cn.tyrone.java.designpattern.staticproxy;

/**
 * 静态代理测试
 * 
 * @author shanglishuai
 *
 */
public class StaticProxyTest {
	
	public static void main(String[] args) {
		IPCBrand lenevoPCBrand = new LenevoPCBrand();
		
		IPCBrand lenevoPCBrandProxy = new LenevoPCBrandProxy(lenevoPCBrand);
		
		String pcModel = "G470-New";
		
		lenevoPCBrand.makePC(pcModel);
		lenevoPCBrand.makePC(pcModel);
		System.out.println("\n");
		lenevoPCBrandProxy.makePC(pcModel);
		lenevoPCBrandProxy.makePC(pcModel);
		
	}
	
}
