package com.mavconfig.testpackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass
{
   @Test
   public void addTwoNum()
   {
       System.out.println("Performing Addition Operation");
       int a = 25;
       int b = 26;
       Assert.assertEquals(51,a+b);

   }

   @Test
    public void subTwoNum()
    {
        System.out.println("Performing Subtraction Operation");
        int a = 25;
        int b = 26;
        Assert.assertEquals(1,b-a);

    }

    @Test
    public void multTwoNum()
    {
        System.out.println("Performing multiplication Operation");
        int a = 25;
        int b = 26;
        Assert.assertEquals(650,a*b);

    }

    @Test
    public void divTwoNum()
    {
        System.out.println("Performing Division Operation");
        int a = 25;
        int b = 26;
        Assert.assertEquals(1,b/a);

    }

}
