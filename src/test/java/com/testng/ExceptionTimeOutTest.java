package com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest
{
    @Test(timeOut = 2000, expectedExceptions = NumberFormatException.class)
    public void sum()
    {
        int a = 1;
        while (a == 1)
        {
            System.out.println(a);
        }
    }

    @Test(expectedExceptions = NumberFormatException.class)
    public void test()
    {
        String x = "100A";
        Integer.parseInt(x);
    }
}
