package duplicationInArray;

/**
 * 剑指offer 面试题三
 */
public class Solution {
    //排序法：先排序，再找到重复数字。略

    /**
     * 哈希法
     * 时间复杂度 O(n), 空间复杂度 O(n)
     */
    public int duplicate1(int[] nums) {
        if(nums == null)
            return -1;

        int len = nums.length;
        int[] set = new int[len];
        //初始化
        for(int i=0; i<len; i++) {
            // -1 表示没有值
            set[i] = -1;
        }

        for(int num:nums) {
            if(set[num] == -1)
                set[num] = num;
            else
                return num;
        }

        // -1 表示不存在重复值
        return -1;
    }

    /**
     * 哈希法变形：利用输入数组的空间来进行各个数字的归位
     * 时间复杂度O(n), 空间复杂度O(1)
     */
    public int duplicate2(int[] nums) {
        if(nums == null)
            return -1;

        //遍历数组中的每个数字，使其归位。
        //当归位时发现相同数字，则返回
        int index = 0;
        int len = nums.length;
        while(index < len) {
            int num = nums[index];
            if(num != index) {
                if(num == nums[num])
                    return num;
                else {
                    nums[index] = nums[num];
                    nums[num] = num;
                }
            }
            else
                index++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = {1, 2, 5, 5, 8, 5, 4, 2};
        int[] nums2 = {};
        int[] nums3 = {3, 2, 1, 0, 4, 8, 7, 6, 5};
        int[] nums4 = {1, 4, 2, 3, 5, 6, 2};

        System.out.println("哈希表法，测试用例一："+solution.duplicate1(nums1));
        System.out.println("哈希表法，测试用例二："+solution.duplicate1(nums2));
        System.out.println("哈希表法，测试用例三："+solution.duplicate1(nums3));
        System.out.println("哈希表法，测试用例四："+solution.duplicate1(nums4));
        System.out.println("哈希表法，测试用例四："+solution.duplicate1(null));

        System.out.println("哈希法变形，测试用例一："+solution.duplicate2(nums1));
        System.out.println("哈希法变形，测试用例二："+solution.duplicate2(nums2));
        System.out.println("哈希法变形，测试用例三："+solution.duplicate2(nums3));
        System.out.println("哈希法变形，测试用例四："+solution.duplicate2(nums4));
        System.out.println("哈希法变形，测试用例四："+solution.duplicate2(null));
    }
}
