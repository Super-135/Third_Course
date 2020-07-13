package com.Super135.Lesson7;

public class Tests {
    @BeforeSuite
    public static void testStart(){
        System.out.println("Тест начали");
    }

    @Test(level = 4)
    public static void testSumm(){
        System.out.println(7+5);
    }
    @Test(level = 2)
    public static void testDifference(){
        System.out.println(7-5);
    }
    @Test(level = 3)
    public static void testMultiplicatiion(){
        System.out.println(7*5);
    }
    @Test(level = 1)
    public static void testDevision(){
        System.out.println((double) 7/5);
    }
    @AfterSuite
    public static void testEnd(){
        System.out.println("Тестирование закончили");
    }
}
