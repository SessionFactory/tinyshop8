package qin.javaee8.testing;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain.GoodsCategory;
import qin.tinyshop8.utils.ShopBaseSupport;

public class SaveGoodsCategory implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void save() throws Exception
    {
        GoodsCategory goodsCategory0 = new GoodsCategory();
        goodsCategory0.setCategoryAlias("pc_phone");
        goodsCategory0.setCategoryName("电脑、手机");
        goodsCategory0.setCategorySort(2);
        GoodsCategory goodsCategory1 = new GoodsCategory();
        goodsCategory1.setCategoryAlias("computer");
        goodsCategory1.setCategoryName("笔记本");
        goodsCategory1.setCategorySort(2);
        GoodsCategory goodsCategory2 = new GoodsCategory();
        goodsCategory2.setCategoryAlias("phone");
        goodsCategory2.setCategoryName("手机");
        goodsCategory2.setCategorySort(2);
        GoodsCategory goodsCategory3 = new GoodsCategory();
        goodsCategory3.setCategoryAlias("tache");
        goodsCategory3.setCategoryName("平板");
        goodsCategory3.setCategorySort(1);
        GoodsCategory goodsCategory4 = new GoodsCategory();
        goodsCategory4.setCategoryAlias("apparel");
        goodsCategory4.setCategoryName("服饰");
        goodsCategory4.setCategorySort(3);
        GoodsCategory goodsCategory5 = new GoodsCategory();
        goodsCategory5.setCategoryAlias("women");
        goodsCategory5.setCategoryName("女装");
        goodsCategory5.setCategorySort(1);
        GoodsCategory goodsCategory6 = new GoodsCategory();
        goodsCategory6.setCategoryAlias("shrit");
        goodsCategory6.setCategoryName("衬衫");
        goodsCategory6.setCategorySort(1);
        GoodsCategory goodsCategory7 = new GoodsCategory();
        goodsCategory7.setCategoryAlias("men");
        goodsCategory7.setCategoryName("男式");
        goodsCategory7.setCategorySort(1);
        GoodsCategory goodsCategory8 = new GoodsCategory();
        goodsCategory8.setCategoryAlias("men_shrit");
        goodsCategory8.setCategoryName("衬衫");
        goodsCategory8.setCategorySort(1);
        session.save(goodsCategory0);
        session.save(goodsCategory1);
        session.save(goodsCategory2);
        session.save(goodsCategory3);
        session.save(goodsCategory4);
        session.save(goodsCategory5);
        session.save(goodsCategory6);
        session.save(goodsCategory7);
        session.save(goodsCategory8);
        transaction.commit();
    }
}