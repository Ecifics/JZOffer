package com.ecifics.jzoffer.chapter3;

/**
 * @author Ecifics
 * @Description 面试题17：打印从1到最大的n位数，字符串模拟数字加减法
 * @date 5/31/2022-10:05 AM
 */
public class Print1ToMaxOfDigits {

    public void print1ToMaxOfDigits(int n) {
        if (n <= 0) {
            return ;
        }

        char[] number = new char[n];
        // 对char数组清零
        for (int i = 0; i < n; ++i) {
            number[i] = '0';
        }
        // 将原来的数字加一，如果超出了范围返回false退出while循环
        while (!increment(number)) {
            // 从第一个不是0的数字开始打印
            printNumber(number);
        }
    }

    private boolean increment(char[] number) {
        int n = number.length;

        // 进位
        int takeOver = 0;
        boolean isOverFlow = false;
        for (int i = n - 1; i >= 0; i--) {
            int sum = (number[i] - '0') + takeOver;
            // 最低位加一
            if (i == n - 1) {
                sum++;
            }

            // 进位
            if (sum >= 10) {
                // 最高位进位，表示已经达到最大数字
                if (i == 0) {
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;
                    number[i] = (char) ('0' + sum);
                }
            } else {
                number[i] = (char) ('0' + sum);
                break;
            }
        }

        return isOverFlow;
    }

    private void printNumber(char[] number) {
        int n = number.length - 1;

        while (number[n] == '0') {
            n--;
        }

        for (int i = n; i >= 0; i--) {
            System.out.print(number[i]);
        }
        System.out.println();
    }
}
