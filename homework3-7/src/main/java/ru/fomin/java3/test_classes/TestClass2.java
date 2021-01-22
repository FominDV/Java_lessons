package ru.fomin.java3.test_classes;

import ru.fomin.java3.testing_framework.annonetions.AfterSuite;
import ru.fomin.java3.testing_framework.annonetions.Test;

public class TestClass2 {
    
    @Test(priority = -13320)
    public void testAAA(){
        System.out.println("test with priority -13320");
    }
        @Test(priority = -1)
        public void testAA(){
            System.out.println("test with priority -1");
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
        public void testD(){
            System.out.println("test with default priority");
        }
    @Test(priority=20001)
    public void testE(){
        System.out.println("test with priority 20001");
    }

        @AfterSuite
        public void clear(){
            System.out.println("AfterSuite");
        }
        public void notTest(){
            System.out.println("It is not the test");
        }
    }



