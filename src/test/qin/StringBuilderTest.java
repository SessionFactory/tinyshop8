package qin;

import org.junit.Test;
import qin.tinyshop8.utils.ShopBaseSupport;

public class StringBuilderTest implements ShopBaseSupport
{
    @Test
    public void sbTest()
    {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.length());
    }
}