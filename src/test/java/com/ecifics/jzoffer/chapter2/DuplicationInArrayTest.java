package com.ecifics.jzoffer.chapter2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ecifics
 * @Description 数组中重复元素测试类
 * @date 5/22/2022-10:24 AM
 */
class DuplicationInArrayTest {

    private final DuplicationInArray duplicationInArray = new DuplicationInArray();

    @Test
    void duplicate1() {
        int[] nums = {3, 4, 2, 0, 0, 1};
        int result = duplicationInArray.duplicate1(nums);
        System.out.println(result);
    }

    @Test
    void duplicate2() {
        int[] nums = {3, 4, 2, 0, 0, 1};
        int result = duplicationInArray.duplicate2(nums);
        System.out.println(result);
    }

    @Test
    void duplicate3() {
        int[] nums = {3, 4, 2, 0, 0, 1};
        int result = duplicationInArray.duplicate3(nums);
        System.out.println(result);
    }
}