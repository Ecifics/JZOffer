package com.ecifics.jzoffer.chapter2;

import org.junit.jupiter.api.Test;

/**
 * @author Ecifics
 * @Description 数组中重复数字测试类
 * @date 5/22/2022-12:16 PM
 */
class DuplicationInArrayNoEditTest {

    private final DuplicationInArrayNoEdit duplicationInArrayNoEdit = new DuplicationInArrayNoEdit();

    @Test
    void findRepeatNumberByBinarySearch() {
        int[] nums = {2, 3, 3, 7, 8, 5, 4, 4, 2, 6, 7};
        int repeatNumber = duplicationInArrayNoEdit.findRepeatNumberByBinarySearch(nums);
        System.out.println(repeatNumber);
    }

    @Test
    void findRepeatNumberByNewArray() {
        int[] nums = {2, 2, 3, 3, 7, 8, 5, 4, 4, 2, 6, 7};
        int repeatNumber = duplicationInArrayNoEdit.findRepeatNumberByNewArray(nums);
        System.out.println(repeatNumber);
    }
}