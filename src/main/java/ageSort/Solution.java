package ageSort;

/**
 * 剑指offer 年龄排序
 */
public class Solution {

    public static void sort(int[] ages) {
        if(ages == null)
            return;

        //年龄分布
        int[] ageDist = new int[100];
        for(int i=0; i<ageDist.length; i++)
            ageDist[i] = 0;
        for(int i=0; i<ages.length; i++) {
            int age = ages[i];
            ageDist[age]++;
        }

        int index=0;
        for(int i=0; i<ageDist.length; i++) {
            for(int j=0; j<ageDist[i]; j++) {
                ages[index++] = i;
            }
        }
    }
}
