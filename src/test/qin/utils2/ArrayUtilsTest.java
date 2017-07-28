package qin.utils2;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2017/7/27 0027-27.<br/>
 *
 * @author qinzhengying
 */
public class ArrayUtilsTest implements ArrayUtils
{
    @Test
    public void reverseArrayTest() throws Exception
    {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] b = reverseArray(a);
        for (int i = 0; i < b.length; i++)
        {
            System.out.println(b[i]);
        }
        Arrays arrays;
    }

}