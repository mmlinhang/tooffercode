package merge2SortedMatrix;

/**
 * 面试题5变体
 * 合并两个有序数组 A B 到 A 数组中，形成新的有序数组
 * A 数组有足够多的剩余空间来存储 B 数组
 */
public class Solution {

    public void merge(int[] m1, int[] m2, int len1, int len2) {
        if(m1 == null || m2 == null || m1.length < len1 || m2.length < len2 ||
                m1.length < len1+len2)
            return;

        int p1 = len1-1, p2 = len2-1;
        int pMerge = len1+len2-1;

        while(p1>=0 && p2>=0) {
            if(m1[p1] > m2[p2]) {
                m1[pMerge--] = m1[p1--];
            }
            else {
                m1[pMerge--] = m2[p2--];
            }
        }
        while(p1>=0) {
            m1[pMerge--] = m1[p1--];
        }
        while(p2>=0) {
            m1[pMerge--] = m2[p2--];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] m1 = {1, 3, 5, 6, 9, 11, 18, 20, -1, -1, -1, -1};
        int[] m2 = {2, 7, 19};

        solution.merge(m1, m2, 8, 3);
    }
}
