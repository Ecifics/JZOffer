package com.ecifics.jzoffer.chapter2;

/**
 * @author Ecifics
 * @Description 不修改数组找出重复的数字
 * @date 5/22/2022-12:15 PM
 */
public class DuplicationInArrayNoEdit {
    public int findRepeatNumberByBinarySearch(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 1;
        int end = nums.length - 1;
        while (end >= start) {
            int middle = (end - start) / 2 + start;

            int count = countRange(nums, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                }

                break;
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }

        return -1;
    }

    private int countRange(int[] nums, int start, int end) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] >= start && nums[i] <= end) {
                ++count;
            }
        }

        return count;
    }

    public int findRepeatNumberByNewArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; ++i) {
            if (newArray[nums[i]] != 0) {
                return nums[i];
            }

            newArray[nums[i]] = nums[i];
        }

        return -1;
    }
}
