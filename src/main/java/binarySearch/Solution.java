package binarySearch;

/**
 * 二分查找算法实现
 */
public class Solution {
    /**
     * 循环实现
     */
    public static int search(int[] array, int searchValue) {
        if(array == null)
            return -1;

        int start=0, end=array.length-1;
        int middle;
        while(start <= end) {
            middle = (start+end)/2;
            if(searchValue == array[middle])
                return middle;
            else if(searchValue > array[middle])
                start = middle+1;
            else
                end = middle-1;
        }

        return -1;
    }

    /**
     * 递归实现
     */
    public static int search2(int[] array, int searchValue) {
        if(array == null)
            return -1;

        return searchRecursive(array, searchValue, 0, array.length-1);
    }

    private static int searchRecursive(int[] array, int searchValue, int start, int end) {
        if(start <= end) {
            int middle = (start+end)/2;
            if(array[middle] == searchValue)
                return middle;
            else if(searchValue < array[middle])
                return searchRecursive(array, searchValue, start, middle-1);
            else
                return searchRecursive(array, searchValue, middle+1, end);
        }
        else
            return -1;
    }
}
