package reorderArray;

/**
 * 面试题21 调整数组的顺序，使得奇数在偶数的前方
 */
public class Solution {

    public void reorder(int[] array, ReorderMethod reorderMethod) {
        if(array == null)
            return;

        int start=0, end=array.length-1;
        while(start < end) {
            while(start<array.length && reorderMethod.func(array[start]))
                start++;
            while(end>-1 && !reorderMethod.func(array[end]))
                end--;
            if(start < end) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        OddEvenRecorderMethod recorderMethod = new OddEvenRecorderMethod();

        // 测试用例
        int[] array1 = {0, 2, 4, 6, 1, 3, 5, 7};
        int[] array2 = {1, 3, 5, 7, 0, 2, 4, 6};
        int[] array3 = {1, 2, 3, 4, 5, 6};
        int[] array4 = {-1, -2, -3, -4, -5, -6};
        int[] array5 = {9, 8, 5, 3, 2, -5};
        int[] array6 = {};
        int[] array7 = {1};
        solution.reorder(array1, recorderMethod);
        solution.reorder(array2, recorderMethod);
        solution.reorder(array3, recorderMethod);
        solution.reorder(array4, recorderMethod);
        solution.reorder(array5, recorderMethod);
        solution.reorder(array6, recorderMethod);
        solution.reorder(array7, recorderMethod);
    }
}

interface ReorderMethod {
    boolean func(int num);
}

class OddEvenRecorderMethod implements ReorderMethod {
    public boolean func(int num) {
        if((num&0x1) == 1)
            return true;
        return false;
    }
}