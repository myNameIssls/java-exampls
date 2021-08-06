package cn.tyrone.java.designpattern.dynamicproxy.jdk;

/**
 * 联想电脑厂商
 * @author shanglishuai
 *
 */
public class LenevoPCBrand implements IPCBrand {
	
	
	@Override
	public void makePC(String pcModel) {
		System.out.println("新研发的的电脑型号:" + pcModel);
	}

	@Override
	public void sellPC(String pcModel) {
		System.out.println("出售最新的电脑型号：" + pcModel);
	}

}
