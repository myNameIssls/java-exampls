package cn.tyrone.java.datastructure.sort;

/**
 * 插入排序
 */
public class InsertSort {

    public static void insertSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < arr[i - 1]) {

                int temp = arr[i];
                int j;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j + 1] = arr[j];
                }

                arr[j + 1] = temp;

            }

        }

    }

}
