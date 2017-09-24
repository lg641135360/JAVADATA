package ch09;

/**
 * 快速排序
 */
public class QuickSort {
    /**
     * 划分数组
     */
    public static int partion(long arr[], int left, int right, long point) {
        int leftPtr = left - 1;
        int rightPtr = right;
        while (true) {
            //循環,將比關鍵字小的留在左端
            while (leftPtr < rightPtr && arr[++leftPtr] < point);
            //循環，將比關鍵字大的留在右端
            while (rightPtr > leftPtr && arr[--rightPtr] > point);
            if (leftPtr >= rightPtr) {
                break;
            } else {
                long tmp = arr[leftPtr];
                arr[leftPtr] = arr[rightPtr];
                arr[rightPtr] = tmp;
            }
        }
        //將關鍵字和當前所指的這個進行交換
        long tmp = arr[leftPtr];
        arr[leftPtr] = arr[right];
        arr[right] = tmp;
        return leftPtr;
    }

    public static void sort(long[] arr, int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            //設置關鍵字
            long point = arr[right];
            //獲得切入點，同時對數組進行劃分
            int partion = partion(arr, left, right, point);
            //對左邊的子數組進行快速排序
            sort(arr, left, partion - 1);
            //對右邊的子數組進行快速排序
            sort(arr, partion + 1, right);
        }
    }

    public static void displayArr(long[] arr) {
        System.out.print("[");
        for (long num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("]");
        System.out.println();
    }
}
