package _2test;

import org.junit.Test;
import qin.tinyshop8.utils.ShopBaseSupport;

public class JavaTest implements ShopBaseSupport
{
    @Test public void listTest() {
        for (int i = 0; i < 40; i ++) {
            for (int j = 1; j < i; j ++) {
                System.out.print("/cy");
            }
            System.out.println();
        }

        System.out.println();
    }
}