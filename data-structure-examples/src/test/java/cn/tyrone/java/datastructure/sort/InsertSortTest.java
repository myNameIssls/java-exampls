package cn.tyrone.java.datastructure.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {


    @Test
    void insertSort() {

        int[] arr = {4, 2, 7, 9, 5, 3, 0};

        System.out.println("排序前：" + Arrays.toString(arr));

        InsertSort.insertSort(arr);

        System.out.println("排序后：" + Arrays.toString(arr));

    }
}