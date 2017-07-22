package qin.tinyshop8.domain8.jpa;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.utils.ShopBaseSupport;

public class Goods8JPATest implements SessionBasic,
          ShopBaseSupport
{
    @Test
    public void save() throws Exception
    {
        Goods8JPA huawei = new Goods8JPA();
        huawei.setGoodsName("荣耀9 全网通 移动联通电信4G手机 双卡双待 魅海蓝 6G+128G");
        huawei.setGoodsAddDate(getDate(2017, 7, 22).toString());
        huawei.setGoodsCostPrice(3499.00d);
        huawei.setGoodsKeyWords("华为");
        huawei.setGoodsMarketPrice(3500d);
        huawei.setGoodsNo("1989902027");
        huawei.setGoodsProNo("_1989902027");
        huawei.setGoodsSellPrice(3999.00d);
        huawei.setGoodsStoreNums(1000);
        huawei.setGoodsSubTitle("huawei");
        huawei.setGoodsWeight("500g");

        GoodsType8JPA type = (GoodsType8JPA) session
                  .get(GoodsType8JPA.class, new Long(2));
        huawei.setGoodsType(type);
        type.getGoods8JPASet().add(huawei);

        session.save(huawei);
        session.update(type);

        transaction.commit();
    }

}