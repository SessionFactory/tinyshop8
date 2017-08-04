package qin.tinyshop8.utils.ini;

import org.springframework.stereotype.Controller;
import qin.javaee8.core.SessionBasic;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.User8JPA;

/**
 * Created by Administrator on 2017/8/1 0001-1.<br/>
 * jpa版的恢复商品类型里的所有信息<br>
 * 恢复账户为Adminstarator
 * 超级管理员的商品类型(包含全部商品类型)
 *
 * @author qinzhengying
 * @since 1.8 2017/8/1
 */
@Controller(value = "ini_administrator_goodsType")
@SuppressWarnings("all")
public class GoodsTypeJPA_Adminstarator implements
          SuperPrintException, SessionBasic
{
    private static final long serialVersionUID = -1431123565799633671L;

    //region  实现初始化数据

    /**
     * 初始化商品类型信息
     */
    @Override
    public void ini()
    {
        try
        {
            //首先查找超级管理员账户
            User8JPA administrator = (User8JPA) session
                      .createQuery("from User8JPA where username='administrator'")
                      .list().get(0);
            if (administrator != null)
            {
                //恢复
                Goods8JPA rongyao = new Goods8JPA();
                rongyao.setGoodsAddDate(getDate(2017, 8, 1).toString());
                rongyao.setGoodsCostPrice(4000d);
                rongyao.setGoodsKeyWords("华为");
                rongyao.setGoodsMarketPrice(4500d);
                rongyao.setGoodsName("荣耀 NOTE 8 4GB+64GB 通4G手机 冰河银 冰河银 4G 128GB");
                rongyao.setGoodsProNo("1989377885");
                rongyao.setGoodsNo("1989377885");
                rongyao.setGoodsSellPrice(3499d);
                rongyao.setGoodsStoreNums(1000);
                rongyao.setGoodsSubTitle("华为手机");
                rongyao.setGoodsWeight("2公斤");
                rongyao.setUser8JPA(administrator);
                administrator.getGoods8JPASet().add(rongyao);

                session.save(rongyao);
                session.update(administrator);
                transaction.commit();

                superLogInfo("商品类型数据恢复成功!");
            }
            else
            {
                throw new DataAccessException("超级管理员为空, 恢复商品类型信息失败!");
            }
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
        }
    }
    //endregion


}