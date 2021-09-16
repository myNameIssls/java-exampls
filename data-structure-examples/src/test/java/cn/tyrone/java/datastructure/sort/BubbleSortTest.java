package cn.tyrone.java.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void bubbleSoft() {

        int[] arr = new int[]{5, 7, 3, 6, 10, 11};
        System.out.println(arr.length);
        System.out.println("排序前：" + Arrays.toString(arr));

        BubbleSort.bubbleSoft(arr);

        System.out.println("排序后：" + Arrays.toString(arr));

    }
}