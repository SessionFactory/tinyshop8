package qin.tinyshop8_page.service;

import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.util.List;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 商品类型服务层接口
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
public interface GoodsTypeService extends ShopBaseSupport
{
    //region 查询所有商品类型信息

    /**
     * 查询所有商品类型信息
     *
     * @return 返回查询集合
     * @throws DataAccessException 抛出数据访问层大异常
     */
    List<GoodsType8JPA> findAll() throws DataAccessException;
    //endregion
}
