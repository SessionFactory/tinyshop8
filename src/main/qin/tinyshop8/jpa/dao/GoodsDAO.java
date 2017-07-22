package qin.tinyshop8.jpa.dao;

import qin.javaee8.core.dao.DAOSupport8;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * 商品jpa数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/7/22
 */
public interface GoodsDAO extends DAOSupport8<Goods8JPA, Long>,
          ShopBaseSupport
{
}