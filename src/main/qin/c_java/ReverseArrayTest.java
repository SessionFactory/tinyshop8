package qin.c_java;

import org.junit.Test;
import qin.tinyshop8.utils.ShopBaseSupport;

public class ReverseArrayTest implements ShopBaseSupport
{
    @Test
    public void doReverse() throws Exception
    {
        int[] a = {1, 2, 3, 4, 5};

        int n = a.length;

        for (int i = 0; i < a.length; i++)
        {
            int t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }

        for (int i = 0; i < a.length; i++)
        {
            System.out.println(a[i]);
        }
    }
}