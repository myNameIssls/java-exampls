package cn.tyrone.java.example.java8.lambda;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.Test;

/**
 * jdk 8 新特性：Lambda 表达式示例程序
 * @author shanglishuai
 *
 */
public class LambdaDemo {

	/**
	 * Lambda Runnable 示例
	 */
	@Test
	public void lambda_runnable_test() {
		
		// 匿名内部类实现runnable
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("使用匿名内部类实现Runnable");
			}
		};
		
		/*
		 *  使用Lambda形式实现Runnable
		 *  注意：如果主体只包含一个语句块，那么{}可以省略
		 */
//		Runnable r2 = () -> { System.out.println("使用Lambda形式实现Runnable") };
		Runnable r2 = () -> System.out.println("使用Lambda形式实现Runnable");
		
		r1.run();
		r2.run();
		
	}

	/**
	 * 集合比较器Comparator Lambda示例
	 */
	@Test
	public void comparator_lambda_test() {
		List<Person> personList = Person.createShortList();
		
		// 使用匿名内部类排序
		Collections.sort(personList, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				// TODO Auto-generated method stub
				return o1.getSurName().compareTo(o2.getSurName());
			}
			
		});
		
		System.out.println("=== 根据surName倒序排列:基于匿名内部类排序 ===");
		for (Person person : personList) {
			person.printName();
		}
		
		System.out.println("=== 根据surName升序排列:基于Lambda表达式排序 ===");
		Collections.sort(personList, (Person p1, Person p2) -> p1.getSurName().compareTo(p2.getSurName()));
		for (Person person : personList) {
			person.printName();
		}
		
		System.out.println("=== 根据surName倒序排列:基于Lambda表达式排序 ===");
		Collections.sort(personList, (Person p1, Person p2) -> p2.getSurName().compareTo(p1.getSurName()));
		for (Person person : personList) {
			person.printName();
		}
		
	}
	
	/**
	 * Listener 监听器 Lambda程序示例
	 */
	@Test
	public void listener_lambda_test() {
		
		JButton button = new JButton("Test Button");
		// 添加监听器
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("通过匿名内部类点击按扭");
			}
		});
		// 通过Lambda点击按扭
		button.addActionListener(e -> System.out.println("通过Lambda点击按扭"));
		
		// Swing stuff
		JFrame frame = new JFrame("Listener Test");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(button, BorderLayout.CENTER);
		frame.pack();
		frame.setVisible(true);
		
	}
	
	/**
	 * 集合迭代Lambda示例
	 */
	@Test
	public void foreach_lambda_test() {
		
		List<String> languages = Arrays.asList("SpringBoot","SpringCloud","SpringMVC","MyBatis");
		
		System.out.println("==== jdk 8 之前遍历 =====");
		// jdk 8 之前遍历
		for (String language : languages) {
			System.out.println(language + "\t");
		}
		
		System.out.println("==== 基于Lambda表达式迭代 =====");
		// 基于Lambda表达式迭代
		languages.forEach(language -> System.out.println(language + "\t"));
		
		System.out.println("==== 基于jdk8方法引用 =====");
		// 基于jdk8方法引用
		languages.forEach(System.out::println);
		
	}
	
	
}
