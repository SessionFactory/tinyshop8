package qin.tinyshop8_page.dao.impl;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import qin.javaee8.core.SessionBasic;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.domain8.jpa.User8JPA;
import qin.tinyshop8.utils.ShopBasicDAOImpl;
import qin.tinyshop8_page.controller.TinyShop8Controller.InnerGoods;
import qin.tinyshop8_page.dao.GoodsDAO;

import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 商品数据访问层实现类
 *
 * @author qinzhengying
 * @since 1.8 2017/8/8
 */
@Repository(value = "_GoodsDAOImpl")
@SuppressWarnings("all")
public class GoodsDAOImpl
          extends ShopBasicDAOImpl<Goods8JPA, Long>
          implements GoodsDAO
{
    private static final long serialVersionUID = 3007875779956017781L;

    //region 重写构造函数
    public GoodsDAOImpl() throws Exception
    {
        superLogInfo("正在初始化商品数据访问层");
    }
    //endregion

    //region 获取实体类

    /**
     * 获取商品信息实体类
     *
     * @return 返回获取到的实体类型
     */
    @Override
    public Class<Goods8JPA> getEntityClass()
    {
        return Goods8JPA.class;
    }

    //endregion

    //region 根据用户查询商品信息

    /**
     * 根据用户查询商品信息
     *
     * @param username 用户名
     * @return 返回查询集合
     * @throws DataAccessException 如果查询失败抛出大异常
     */
    @Override
    public List<Goods8JPA> findGoodsByUser(String username)
              throws DataAccessException
    {
        List<Goods8JPA> searchList = getSession()
                  .createQuery("from Goods8JPA where " +
                                         " user8JPA.username=:username")
                  .setParameter("username", username)
                  .list();

        if (searchList.size() == 0)
        {
            return Collections.emptyList();
        }

        return searchList;
    }
    //endregion

    //region 新增商品信息

    /**
     * 新增商品信息
     *
     * @param goods8     商品实体类
     * @param goodsType8 商品类型实体类
     * @return 返回新增具体类
     */
    @Override
    public FrameWorkDSCResult addGoods(final Goods8JPA goods8,
                                       final GoodsType8JPA goodsType8)
    {
        FrameWorkDSCResult result = new FrameWorkDSCResult();

        try
        {
            setSession(null);
            Session session = SessionBasic.session;

            //User8JPA user = goods8.getUser8JPA();
            //user.getGoods8JPASet().add(goods8);
            //goods8.setUser8JPA(user);
            //goods8.setGoodsType(goodsType8);
            //goodsType8.getGoods8JPASet().add(goods8);

            session.merge(goods8);
            //更新商品类型信息
            session.refresh(goodsType8);
            //session.refresh(user);

            getTransaction().commit();
            result.setDaoFlag(true);
        }
        catch (Exception ex)
        {
            result.setDaoFlag(false);
            printStackTrace(ex);
            result.setDaoException(ex);
        }
        finally
        {
            return result;
        }
    }

    //endregion

    //region 改进新增商品信息功能

    /**
     * 改进新增商品信息功能
     *
     * @param goods 商品html类
     * @return 返回具体的类
     * @author qinzhengying
     * @since 1.8 2017/8/13
     */
    @Override
    public FrameWorkDSCResult addGoods(InnerGoods _goods)
    {
        FrameWorkDSCResult result = new FrameWorkDSCResult();

        try
        {
            Goods8JPA goods = new Goods8JPA(
                      _goods.getGoodsAddDate(), _goods.getGoodsName(),
                      _goods.getGoodsSubTitle(), _goods.getGoodsProNo(),
                      _goods.getGoodsNo(), Integer.valueOf(_goods.getGoodsStoreNums()),
                      _goods.getGoodsWeight(), Double.valueOf(_goods.getGoodsSellPrice()),
                      Double.valueOf(_goods.getGoodsMarketPrice()),
                      Double.valueOf(_goods.getGoodsCostPrice())
            );
            goods.setGoodsImgs(_goods.getImagesList());

            //用户的保存
            User8JPA user = (User8JPA) getSession()
                      .createQuery("from User8JPA where username=:username")
                      .setParameter("username", _goods.getUsername())
                      .list().get(0);
            //类型
            GoodsType8JPA goodsType = (GoodsType8JPA) getSession()
                      .createQuery("from GoodsType8JPA where typeName=:typeName")
                      .setParameter("typeName", _goods.getGoodsType())
                      .list().get(0);

            goods.setUser8JPA(user);
            goods.setGoodsType(goodsType);

            user.getGoods8JPASet().add(goods);
            goodsType.getGoods8JPASet().add(goods);

            getSession().save(goods);
            getSession().update(user);
            getSession().update(goodsType);
            getTransaction().commit();

            result.setDaoFlag(true);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
            result.setDaoFlag(false);
            result.setDaoException(ex);
        }
        finally
        {
            return result;
        }
    }

    //endregion

}