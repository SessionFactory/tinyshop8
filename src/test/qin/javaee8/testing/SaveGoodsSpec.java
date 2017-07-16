package qin.javaee8.testing;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain.GoodsSpec;
import qin.tinyshop8.utils.ShopBaseSupport;

public class SaveGoodsSpec implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void spec()
    {
        GoodsSpec goodsSpec1 = new GoodsSpec("系统", "文字", "");
        GoodsSpec goodsSpec2 = new GoodsSpec("颜色", "文字", "");
        GoodsSpec goodsSpec3 = new GoodsSpec("硬盘", "文字", "");
        GoodsSpec goodsSpec4 = new GoodsSpec("系统", "文字", "");
        GoodsSpec goodsSpec5 = new GoodsSpec("尺寸", "文字", "");
        GoodsSpec goodsSpec6 = new GoodsSpec("尺码", "文字", "");

        session.save(goodsSpec1);
        session.save(goodsSpec2);
        session.save(goodsSpec3);
        session.save(goodsSpec4);
        session.save(goodsSpec5);
        session.save(goodsSpec6);

        transaction.commit();
    }
}