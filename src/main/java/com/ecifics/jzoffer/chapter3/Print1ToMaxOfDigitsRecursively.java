package com.ecifics.jzoffer.chapter3;

/**
 * @author Ecifics
 * @Description 面试题17打印从1到最大的n位数（递归）
 * @date 5/31/2022-11:53 AM
 */
public class Print1ToMaxOfDigitsRecursively {

    public void print1ToMaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            helper(number, 0);
        }
    }

    private void helper(char[] number, int index) {
        if (index == number.length - 1) {
            printNumber(number);
            return ;
        }

        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            helper(number, index + 1);
        }
    }

    private void printNumber(char[] number) {
        boolean isBeginningZero = true;
        int n = number.length;

        for (int i = 0; i < n; ++i) {
            if (isBeginningZero && number[i] != '0') {
                isBeginningZero = false;
            }

            if (!isBeginningZero) {
                System.out.print(number[i]);
            }
        }

        System.out.println();
    }
}
