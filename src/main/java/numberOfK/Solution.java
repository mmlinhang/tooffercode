package numberOfK;

/**
 * 面试题53 在排序数组中查找数字 k 的个数
 */
public class Solution {

    public int getNumberOfK(int[] nums, int k) {
        if(nums==null || nums.length==0)
            return 0;

        int start=0, end=nums.length-1;
        int startK=-1, endK=-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid] > k)
                end = mid-1;
            else if(nums[mid] < k)
                start = mid+1;
            else {
                if(mid-1>=start && nums[mid-1]==k)
                    end = mid-1;
                else {
                    startK = mid;
                    break;
                }
            }
        }
        start=0;
        end=nums.length-1;
        while(start <= end) {
            int mid = (start+end)/2;
            if(nums[mid]>k)
                end = mid-1;
            else if(nums[mid] < k)
                start = mid+1;
            else {
                if(mid+1<=end && nums[mid+1]==k)
                    start = mid+1;
                else {
                    endK = mid;
                    break;
                }
            }
        }

        if(startK == -1)
            return 0;

        return endK-startK+1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 测试用例
        int[] nums1 = null;
        int[] nums2 = {1};
        int[] nums3 = {1, 2, 3, 3, 3, 3, 4, 5};
        int[] nums4 = {1, 2, 3, 4, 5, 6};
        System.out.println("测试用例1："+solution.getNumberOfK(nums1, 3));
        System.out.println("测试用例2："+solution.getNumberOfK(nums2, 1));
        System.out.println("测试用例3："+solution.getNumberOfK(nums2, 2));
        System.out.println("测试用例4："+solution.getNumberOfK(nums3, 3));
        System.out.println("测试用例5："+solution.getNumberOfK(nums3, 5));
        System.out.println("测试用例6："+solution.getNumberOfK(nums3, 6));
        System.out.println("测试用例7："+solution.getNumberOfK(nums4, 2));
        System.out.println("测试用例8："+solution.getNumberOfK(nums4, 7));
    }
}
