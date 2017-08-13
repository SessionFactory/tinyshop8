package qin.tinyshop8_page.service;

import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;
import qin.tinyshop8_page.controller.TinyShop8Controller.InnerGoods;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 商品服务层
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
public interface GoodsService extends ShopBaseSupport
{
    //region 查询所有商品信息

    /**
     * 查询所有商品信息
     *
     * @return 返回查询集合
     * @throws DataAccessException 抛出数据访问层大异常
     */
    List<Goods8JPA> findAll() throws DataAccessException;
    //endregion

    //region 根据用户查询商品信息

    /**
     * 根据用户查询商品信息
     *
     * @param username 用户名
     * @return 返回查询集合
     * @throws DataAccessException 如果查询失败抛出大异常
     */
    List<Goods8JPA> findGoodsByUser(String username)
              throws DataAccessException;
    //endregion

    //region 新增商品信息

    /**
     * 新增商品信息
     *
     * @param goods8     商品实体类
     * @param goodsType8 商品类型实体类
     * @return 返回新增具体类
     */
    FrameWorkDSCResult addGoods(Goods8JPA goods8,
                                GoodsType8JPA goodsType8);
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
    FrameWorkDSCResult addGoods(InnerGoods goods);
    //endregion
}
