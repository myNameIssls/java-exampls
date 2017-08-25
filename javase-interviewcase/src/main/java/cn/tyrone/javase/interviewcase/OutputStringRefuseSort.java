package cn.tyrone.javase.interviewcase;

/**
 * 需求描述： 
 * 假设有一个字符串abcdefg,请将这个字符串倒序输出，
 * 不允许使用Java自带的排序方法
 *
 */
public class OutputStringRefuseSort {
	public static void main(String[] args) {
		String str = "abcdefg";
		
		// 第一种方式
		int length = str.length();
		for (int i = length - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
	
		// 第二种方式
		String[] split = str.split("");
		int arrLength = split.length;
		for (int i = arrLength - 1; i >= 0; i--) {
			System.out.print(split[i]);
		}
		
	}
}
