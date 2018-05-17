package cn.tyrone.java.designpattern.dynamicproxy.cglib;

/**
 * 联想电脑厂商
 * @author shanglishuai
 *
 */
public class LenevoPCBrand  {
	
	public void makePC(String pcModel) {
		System.out.println("新研发的的电脑型号:" + pcModel);
	}

	public void sellPC(String pcModel) {
		System.out.println("出售最新的电脑型号：" + pcModel);
	}

}
