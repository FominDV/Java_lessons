package ru.fomin.java3.test_classes;

import ru.fomin.java3.testing_framework.annonetions.AfterSuite;
import ru.fomin.java3.testing_framework.annonetions.Test;

<<<<<<< HEAD
public class TestClass2 {
    
=======
import java.util.List;

public class TestClass2 {
    private String name;
    private int id;
    private boolean isRight;
    private float aFloat;
    private List list;
    private byte aByte;
    private int[] intArr;
    public TestClass2(String name, int id, boolean isRight, float aFloat, List list, byte aByte, int[] intArr){
        this.name=name;
        this.id=id;
        this.isRight=isRight;
        this.aFloat=aFloat;
        this.list=list;
        this.aByte=aByte;
        this.intArr=intArr;
    }
>>>>>>> homework3-7
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



