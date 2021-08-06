package cn.tyrone.java.designpattern.staticproxy;

/**
 * 联想电脑厂商代理商
 * @author shanglishuai
 *
 */
public class LenevoPCBrandProxy implements IPCBrand {
	
	// 
	private IPCBrand pcBrand;
	
	public LenevoPCBrandProxy(IPCBrand pcBrand) {
		this.pcBrand = pcBrand;
	}
	
	/**
	 * 代理联想电脑厂商生产电脑
	 */
	@Override
	public void makePC(String pcModel) {
		System.out.println("我是联想电脑厂商的代理商");
		pcBrand.makePC(pcModel);
	}

	/**
	 * 代理联想电脑厂商出售电脑
	 */
	@Override
	public void sellPC(String pcModel) {
		System.out.println("我是联想电脑厂商的代理商");
		pcBrand.sellPC(pcModel);
	}

}
