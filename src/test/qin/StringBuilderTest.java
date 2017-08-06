package qin;

import org.junit.Test;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.text.SimpleDateFormat;

public class StringBuilderTest implements ShopBaseSupport
{
    @Test
    public void sbTest()
    {
        //StringBuilder sb = new StringBuilder();
        //System.out.println(sb.length());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = sdf.format(getDate(2018, 3, 3));
        System.out.println(s);
    }
}