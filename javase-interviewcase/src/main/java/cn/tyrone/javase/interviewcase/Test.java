package cn.tyrone.javase.interviewcase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

public class Test {
	public static void main(String[] args) {
		String a = new String("a");
		String b = new String("a");
		
		System.out.println("a.hashCode():"+a.hashCode());
		System.out.println("b.hashCode():"+b.hashCode());
		
		
		List<String> list = new ArrayList<String>();
		list.add(a);
		list.add(b);
		
		System.out.println(list.size());
		
		Set<String> set = new HashSet<String>();
		set.add(a);
		set.add(b);
		System.out.println(set.size());
		
		
	}
}
