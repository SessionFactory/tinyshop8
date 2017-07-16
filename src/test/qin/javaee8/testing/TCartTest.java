package qin.javaee8.testing;

import org.junit.Test;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TCartTest implements ShopBaseSupport
{
    @Test
    public void cart() throws Exception
    {
        List<TCart> cartList = new ArrayList<>();
        cartList.add(new TCart("vivo"));
        cartList.add(new TCart("oppo"));

        cartList.forEach
                  (
                            e ->
                            {
                                try
                                {
                                    superLogInfo(e.getName());
                                }
                                catch (Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                  );

        cartList = deleteCart(cartList);

        superLogInfo("删除后");

        cartList.forEach
                  (
                            e ->
                            {
                                try
                                {
                                    superLogInfo(e.getName());
                                }
                                catch (Exception ex)
                                {
                                    ex.printStackTrace();
                                }
                            }
                  );
    }

    List<TCart> deleteCart(List<TCart> cartList)
    {
        return Collections.emptyList();
    }
}