package com.ecifics.jzoffer.chapter3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ecifics
 * @Description 递归解法测试
 * @date 5/31/2022-12:03 PM
 */
class Print1ToMaxOfDigitsRecursivelyTest {

    private Print1ToMaxOfDigitsRecursively print1ToMaxOfDigitsRecursively = new Print1ToMaxOfDigitsRecursively();

    @Test
    void testPrint1ToMaxOfDigits() {
        print1ToMaxOfDigitsRecursively.print1ToMaxOfDigits(2);
    }
}