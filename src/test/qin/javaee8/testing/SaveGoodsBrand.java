package qin.javaee8.testing;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain.GoodsBrand;
import qin.tinyshop8.utils.ShopBaseSupport;

public class SaveGoodsBrand implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void save()
    {
        GoodsBrand g1 = new GoodsBrand("联想", "http://www.lenovo.com.cn/", 1);
        GoodsBrand g2 = new GoodsBrand("小米", "http://www.mi.com/", 1);
        GoodsBrand g3 = new GoodsBrand("苹果", "http://www.apple.com/", 1);
        GoodsBrand g4 = new GoodsBrand("三星", "http://www.samsung.com/", 1);

        session.save(g1);
        session.save(g2);
        session.save(g3);
        session.save(g4);

        transaction.commit();
    }
}