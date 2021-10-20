package cn.tyrone.java.datastructure.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HeapSortTest {

    @Test
    void buildMaxHeap() {

        int[] arrays = {4, 2, 7, 9, 5, 3};

        System.out.println(Arrays.toString(arrays));
        HeapSort.buildMaxHeap(arrays);

    }

    @Test
    void heapSortMax(){
        int[] arrays = {4, 2, 7, 9, 5, 3};
        HeapSort.heapSortMax(arrays);
        System.out.println(Arrays.toString(arrays));
    }

}