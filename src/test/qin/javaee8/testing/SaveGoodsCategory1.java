package qin.javaee8.testing;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain.GoodsCategory;
import qin.tinyshop8.utils.ShopBaseSupport;

public class SaveGoodsCategory1 implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void save() throws Exception
    {
        GoodsCategory goodsCategory = (GoodsCategory) session
                  .createQuery("from GoodsCategory where categoryName='笔记本'")
                  .list().get(0);

        GoodsCategory c1 = new GoodsCategory("游戏本电脑", "gameComputer", 0);
        GoodsCategory c2 = new GoodsCategory("微星游戏笔记本电脑", "weixingComputer", 0);

        goodsCategory.getChildrenSet().add(c1);
        goodsCategory.getChildrenSet().add(c2);

        c1.getChildrenSet().add(c2);

        c1.setCategoryParent(goodsCategory);
        c2.setCategoryParent(c1);

        session.update(goodsCategory);
        session.save(c1);
        session.save(c2);

        transaction.commit();
    }
}