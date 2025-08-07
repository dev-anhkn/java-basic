package org.example.application;


import org.example.utils.HtmlUtil;

/**
 * Đây là class chính của ứng dụng
 */
public class Main {
    public static void main(String[] args) {

        int max = Math.max(5, 10);
        System.out.println(max);

//        int max = com.example.utils.NumberUtil.max(5, 10);
//        System.out.println(max);

        HtmlUtil.printSampleCode();
    }
}
