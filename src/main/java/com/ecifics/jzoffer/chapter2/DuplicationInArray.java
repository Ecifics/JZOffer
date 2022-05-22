package com.ecifics.jzoffer.chapter2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Ecifics
 * @Description 数组中重复元素
 * @date 5/22/2022-10:11 AM
 */
public class DuplicationInArray {

    /**
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public int duplicate1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 1; i < n; ++i) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    public int duplicate2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();

        int n = nums.length;
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }

        return -1;
    }

    public int duplicate3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                // 必须先将nums[nums[i]]位置的元素换成nums[i]
                // 否则如果先交换nums[i]的值，会导致nums[nums[i]]定位的元素发生改变
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }

        return -1;
    }
}
