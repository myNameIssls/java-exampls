package cn.tyrone.java.datastructure.sort;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     *
     * @param arr 待排序数组
     * @param start 待排序数组起始位置
     * @param end 待排序数组结束位置
     */
    public static void quickSort(int[] arr, int start, int end) {

        // 如果起始位置大于等于结束位置时，说明排序已经完成
        if (start >= end) {
            return;
        }

        // 比较基数
        int base = arr[start];
        int left = start;
        int right = end;

        while (left < right) {

            // 右边的数字比基数大
            while (left < right && arr[right] >= base) {
                right --;
            }
            arr[left] = arr[right];

            // 左边的数字比基数小
            while (left < right && arr[left] <= base) {
                left ++;
            }
            arr[right] = arr[left];

        }
        // 当left==right,将基数赋值给数组中索引=left的位置
        arr[left] = base;

        // 将小于基数的数字重新排序
        quickSort(arr, start, left);

        // 将大于基数的数字重新排序
        quickSort(arr, left + 1, end);

    }

}
