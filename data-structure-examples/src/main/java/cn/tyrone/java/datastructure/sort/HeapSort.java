package cn.tyrone.java.datastructure.sort;

import java.util.Arrays;

/**
 * 堆排序
 */
public class HeapSort {

    /**
     * 构建大顶堆算法
     * @param arrays
     * @param length
     * @param index
     */
    private static void buildMaxHeapAlgorithm(int[] arrays, int length, int index){

        int leftNodeIndex = 2 * index + 1;
        int rightNodeIndex = 2 * index + 2;
        int maxIndex = index;

        // 如果左结点的值大于像结点的值，就把最大值的索引值替换成左结点的索引值
        if (leftNodeIndex < length && arrays[leftNodeIndex] > arrays[maxIndex]) {
            maxIndex = leftNodeIndex;
        }
        // 如果右结点的值大于像结点的值，就把最大值的索引值替换成右结点的索引值
        if (rightNodeIndex < length && arrays[rightNodeIndex] > arrays[maxIndex]) {
            maxIndex = rightNodeIndex;
        }

        // 交换位置
        if (maxIndex != index) {
            int temp = arrays[index];
            arrays[index] = arrays[maxIndex];
            arrays[maxIndex] = temp;

            System.out.println(Arrays.toString(arrays));

            // 交换位置后，可能会破坏之前排好序的堆，所以，以当前位置开始重新排序
            buildMaxHeapAlgorithm(arrays, length, maxIndex);

        }
    }

    /**
     * 构建大顶堆
     * @param arrays
     */
    public static void buildMaxHeap(int[] arrays) {

        // 开始位置从最后一个非叶子结点，即最后一个节点的父结点
        int start = (arrays.length - 1) / 2;
        int length = arrays.length;
        int j = 1;
        for (int i = start; i >= 0; i--) {
            System.out.println("每" + j + "次构建");
            buildMaxHeapAlgorithm(arrays, length, i);
            j++;
            System.out.println();
        }

    }

    /**
     * 大顶堆排序
     * @param arrays
     */
    public static void heapSortMax(int[] arrays) {

        // 开始位置从最后一个非叶子结点，即最后一个节点的父结点
        int start = (arrays.length - 1) / 2;
        int length = arrays.length;
        for (int i = start; i >= 0; i--) {
            buildMaxHeapAlgorithm(arrays, length, i);
        }

        for (int i = arrays.length - 1; i >= 0; i--) {
            int temp = arrays[0];
            arrays[0] = arrays[i];
            arrays[i] = temp;

            buildMaxHeapAlgorithm(arrays, i, 0);

        }


    }


}
