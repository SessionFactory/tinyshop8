package test2017;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/8/12 0012-12.<br/>
 *
 * @author qinzhengying
 * @since 1.8 2017/8/
 */
public class DeleteGoods implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void doDelete()
    {
        GoodsType8JPA goodsType = session
                  .get(GoodsType8JPA.class, new Long(2));
        session.delete(goodsType);
        transaction.commit();
    }
}