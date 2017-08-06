package qin.tinyshop8_page.dao;

import qin.javaee8.core.dao.DAOSupport8;
import qin.tinyshop8.domain8.jpa.GoodsBrand8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

/**
 * 商品品牌jpa数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/7/22
 */
public interface GoodsBrandDAO extends DAOSupport8<GoodsBrand8JPA, Long>,
          ShopBaseSupport
{
}