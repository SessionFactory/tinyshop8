package qin.tinyshop8_page.dao;

import qin.javaee8.core.dao.DAOSupport8;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.util.List;

/**
 * 商品jpa数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/7/22
 */
public interface GoodsDAO extends DAOSupport8<Goods8JPA, Long>,
          ShopBaseSupport
{
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
}