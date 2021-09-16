package cn.tyrone.java.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法
 */
public class BubbleSort {

    public static void bubbleSoft(int[] arr){
        int length = arr.length - 1;
        // 登记比较过程中，最后一次交换的索引号
        int lastSwapIndex = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            // 是否继续排序
            boolean ifContinue = false;

            for (int j = 0; j < length; j++) {

                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    ifContinue = true;
                    lastSwapIndex = j;
                }
                System.out.println("第" + (i + 1) + "次排序，第" + (j + 1) + "几次比较:" + Arrays.toString(arr));
            }

            System.out.println("第" + (i + 1) + "次排序结果:" + Arrays.toString(arr));
            System.out.println();
            length = lastSwapIndex;

            if (!ifContinue) {
                break;
            }

        }
    }

}
