package _2test;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain8.GoodsType8;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * Created by Administrator on 2017/7/20 0020-20.<br/>
 */
public class SaveGoodsType implements SessionBasic,
          ShopBaseSupport
{
    @Test
    public void saveAllParent()
    {
        GoodsType8 parent = new GoodsType8("手机", "mobile", 0);
        GoodsType8 g1 = new GoodsType8("手机通讯", "mobileCall", 0);
        GoodsType8 g2 = new GoodsType8("手机配件", "mobileConfig", 0);

        parent.getChildrenSet().add(g1);
        g1.getChildrenSet().add(g2);

        g1.setParentType(parent);
        g2.setParentType(parent);

        session.save(parent);
        session.save(g1);
        session.save(g2);

        transaction.commit();
    }


}