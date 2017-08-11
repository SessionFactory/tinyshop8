package test2._oracle.test_;

import org.junit.Test;
import qin.javaee8.core.SessionBasic;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.util.List;

//oracle查询数据测试
public class _1_OracleSearchData implements ShopBaseSupport,
          SessionBasic
{
    @Test
    public void searchTest() throws Exception
    {
        //searchUser();
        //searchGoods();
        searchGoodsType();
    }

    private void searchGoodsType() throws Exception
    {
        List<GoodsType8JPA> goodsTypeList = session
                  .createQuery("from GoodsType8JPA ")
                  .list();

        superLogInfo(forEachCollection(goodsTypeList));
    }

    private void searchGoods() throws Exception
    {
        List<Goods8JPA> goodsList = session
                  .createQuery("from Goods8JPA ")
                  .list();

        superLogInfo(forEachCollection(goodsList));
    }

    private void searchUser() throws Exception
    {
        List<User8JPA> userList = session
                  .createQuery("from User8JPA ")
                  .list();

        superLogInfo(forEachCollection(userList));
    }
}