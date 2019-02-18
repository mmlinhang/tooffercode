package quickSort;

/**
 * 快速排序
 */
public class Solution {

    public static void sort(int[] array) {
        if(array == null)
            return;

        quickSort(array, 0, array.length-1);
    }

    private static void quickSort(int[] array, int start, int end) {
        if(start >= end)
            return;

        int index = partition(array, start, end);
        quickSort(array, start, index-1);
        quickSort(array, index+1, end);
    }

    private static int partition(int[] array, int start, int end) {
        int key = array[start];
        while(start < end) {
            while(start<end && array[end]>=key)
                end--;
            if(start < end)
                array[start++] = array[end];
            while(start<end && array[start]<=key)
                start++;
            if(start < end)
                array[end--] = array[start];
        }
        array[start] = key;

        return start;
    }
}
