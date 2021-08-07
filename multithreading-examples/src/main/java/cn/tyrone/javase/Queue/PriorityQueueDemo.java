package cn.tyrone.javase.Queue;

import java.util.*;

public class PriorityQueueDemo {
    public static void main(String[] args) {

        /**
         * 第一个示例：
         * 随机生成10个0-（i+10）之间的随机数据，并按照优先级排序（从小到大）
         */
        System.out.println("第一个示例");
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random rand = new Random(47);
        for (int i = 0 ; i < 10 ; i++)
            priorityQueue.offer(rand.nextInt(i + 10));
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        /**
         * 第二个示例：
         * 自定义一个整数型数据，采用PriorityQueue构造器实例化一个优先级队列
         * 并使用Collections.reverseOrder()方法按照优先级等级反向排序
         */
        System.out.println("第二个示例");
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<Integer>();
//        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);
        System.out.println();

        /**
         * 第三个示例：
         * 示例同第二个示例
         */
        System.out.println("第三个示例");
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<String>();
//        QueueDemo.printQ(stringPQ);
        stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);
        System.out.println();

        /**
         * 第四个示例：
         * 使用HashSet对数据去重，并将数据进行优先级排序
         */
        System.out.println("第四个示例");
        Set<Character> charSet = new HashSet<Character>();
        for(char c : fact.toCharArray())
            charSet.add(c);
        PriorityQueue<Character> characterPQ = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(characterPQ);

    }
}
