package qin.tinyshop8_page.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8.jpa.dao.GoodsDAO;
import qin.tinyshop8_page.service.GoodsService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 商品服务层实现
 *
 * @author qinzhengying
 * @since 1.8 2017/8/
 */
@Service(value = "_GoodsServiceImpl")
@Transactional
@SuppressWarnings("all")
public class GoodsServiceImpl implements GoodsService
{
    private static final long serialVersionUID = -3591349531029956218L;

    //region 注入数据访问层
    private GoodsDAO goodsDAO;

    @Resource
    public void setGoodsDAO(GoodsDAO goodsDAO)
    {
        this.goodsDAO = goodsDAO;
    }
    //endregion

    //region 查询所有商品信息

    /**
     * 查询所有商品信息
     *
     * @return 返回查询集合
     * @throws DataAccessException 抛出数据访问层大异常
     */
    @Override
    public List<Goods8JPA> findAll() throws DataAccessException
    {
        return (List<Goods8JPA>) goodsDAO.findAll().getSearchList();
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
        return goodsDAO.findGoodsByUser(username);
    }

    //endregion
}