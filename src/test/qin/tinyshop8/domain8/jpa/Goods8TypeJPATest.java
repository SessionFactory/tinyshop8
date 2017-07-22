package qin.tinyshop8.domain8.jpa;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8.utils.SuperEntity;

public class Goods8TypeJPATest implements SessionBasic,
          ShopBaseSupport
{
    @Test
    public void save()
    {
        GoodsType8JPA parent = new GoodsType8JPA("手机", "mobile", 0);
        GoodsType8JPA mobile = new GoodsType8JPA("手机", "mobile_goods", 1);
        mobile.setParentType(parent);

        GoodsType8JPA tongxin = new GoodsType8JPA("手机通讯", "mobileCall", 0);
        tongxin.setParentType(parent);
        GoodsType8JPA peijian = new GoodsType8JPA("手机配件", "mobileConfig", 0);
        peijian.setParentType(parent);

        GoodsType8JPA huawei = new GoodsType8JPA("华为", "HuaWei", 0);
        huawei.setParentType(mobile);
        GoodsType8JPA oppo = new GoodsType8JPA("oppo", "oppo", 0);
        oppo.setParentType(mobile);

        //充电宝
        GoodsType8JPA cdb = new GoodsType8JPA("充电宝", "battery", 0);
        cdb.setParentType(peijian);

        parent.getChildrenSet().add(mobile);
        parent.getChildrenSet().add(tongxin);
        parent.getChildrenSet().add(peijian);
        peijian.getChildrenSet().add(cdb);
        mobile.getChildrenSet().add(huawei);
        mobile.getChildrenSet().add(oppo);

        doSave(parent, mobile, tongxin, peijian, huawei, oppo, cdb);
        transaction.commit();
    }

    void doSave(SuperEntity... objects)
    {
        for (int i = 0; i < objects.length; i++)
        {
            session.save(objects[i]);
        }
    }


}