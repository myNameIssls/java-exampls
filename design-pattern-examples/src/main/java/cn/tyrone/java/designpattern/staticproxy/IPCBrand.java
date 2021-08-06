package cn.tyrone.java.designpattern.staticproxy;

/**
 * 电脑厂商接口
 * @author shanglishuai
 *
 */
public interface IPCBrand {
	
	/**
	 * 生产电脑
	 * @param pcModel 电脑型号
	 */
	public void makePC(String pcModel);
	
	/**
	 * 出售电脑
	 * @param pcModel 电脑型号
	 */
	public void sellPC(String pcModel);
}
