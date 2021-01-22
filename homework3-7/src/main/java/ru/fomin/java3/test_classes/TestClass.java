package ru.fomin.java3.test_classes;

import ru.fomin.java3.testing_framework.annonetions.AfterSuite;
import ru.fomin.java3.testing_framework.annonetions.BeforeSuite;
import ru.fomin.java3.testing_framework.annonetions.Test;

public class TestClass {
    @Test(priority = Integer.MAX_VALUE)
    public void testA2(){
        System.out.println("test A2 with priority "+Integer.MAX_VALUE);
    }
    @BeforeSuite
    public void init(){
        System.out.println("BeforeSuite");
    }
    @Test(priority = Integer.MAX_VALUE)
    public void testA1(){
        System.out.println("test A1 with priority "+Integer.MAX_VALUE);
    }
    @Test(priority = 1)
    public void testA(){
        System.out.println("test with priority 1");
    }

    @Test(priority = 10)
    public void testB(){
        System.out.println("test with priority 10");
    }

    @Test(priority = 7)
    public void testC(){
        System.out.println("test with priority 7");
    }

    @Test
    public void testDefault(){
        System.out.println("test with default priority");
    }
    @Test(priority = Integer.MIN_VALUE)
    public void testD1(){
        System.out.println("test D1 with priority "+Integer.MIN_VALUE);
    }

    @AfterSuite
    public void clear(){
        System.out.println("AfterSuite");
    }
    public void notTest(){
        System.out.println("It is not the test");
    }
    @Test(priority = Integer.MIN_VALUE)
    public void testD2(){
        System.out.println("test D2 with priority "+Integer.MIN_VALUE);
    }
}

