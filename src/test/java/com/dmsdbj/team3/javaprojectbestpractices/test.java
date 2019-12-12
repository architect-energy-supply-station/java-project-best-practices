package com.dmsdbj.team3.javaprojectbestpractices;

import org.junit.Test;

/**
 * @ClassName java-project-best-practices
 * @Author cookr
 * @Date 2019/12/9 1:57 下午
 * @Version 1.0
 * @Description
 **/


public class test {
    @Test
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println((s1 == s2));
        System.out.println(s1 == s3);
        System.out.println(s1 == s2.intern());

        test d = new test();
        String str = "BEA";
        d.change(str);
        System.out.println(str);
    }

    void change(String s) {
        s = s.replace("A", "E");
        s = s.toLowerCase();
    }
}
