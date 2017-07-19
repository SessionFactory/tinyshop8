package qin.javaee8.testing;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.utils.ShopBaseSupport;

public class Save1 implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void save() throws Exception
    {
        System.out.println(session);

        Object object =
                  session.createNativeQuery("SELECT *\n" +
                                                      "FROM goods_category\n" +
                                                      "WHERE\n" +
                                                      "  NAME = '笔记本'");

        System.out.println(object);
    }


}

















