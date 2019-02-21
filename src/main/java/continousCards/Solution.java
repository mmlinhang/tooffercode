package continousCards;

import java.util.Arrays;

/**
 * 面试题61 扑克牌是否为顺子
 */
public class Solution {

    public boolean isContinous(int[] cards) {
        if(cards==null || cards.length!=5)
            return false;

        Arrays.sort(cards);
        int randomNum = 0;
        int index = 0;
        while(index<5 && cards[index]==-1) {
            randomNum++;
            index++;
        }
        int curNum = cards[index];
        while(index < 5) {
            if(cards[index] == curNum) {
                index++;
                curNum++;
            }
            else if(randomNum > 0) {
                curNum++;
                randomNum--;
            }
            else
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 3, 4, 5, 6};
        int[] nums3 = {2, 3, 4, 5, 7};
        int[] nums4 = {2, 3, 4, 6, 8};
        int[] nums5 = {3, 2, 1, 5, 4};
        int[] nums6 = {11, 13, 10, 12, -1};
        int[] nums7 = {6, 4, 5, -1, -1};
        int[] nums8 = {5, 7, 10, -1, -1};
        System.out.println("测试用例1："+solution.isContinous(nums1));
        System.out.println("测试用例2："+solution.isContinous(nums2));
        System.out.println("测试用例3："+solution.isContinous(nums3));
        System.out.println("测试用例4："+solution.isContinous(nums4));
        System.out.println("测试用例5："+solution.isContinous(nums5));
        System.out.println("测试用例6："+solution.isContinous(nums6));
        System.out.println("测试用例7："+solution.isContinous(nums7));
        System.out.println("测试用例8："+solution.isContinous(nums8));
    }
}
