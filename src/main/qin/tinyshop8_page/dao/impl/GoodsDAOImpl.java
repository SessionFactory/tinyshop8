package qin.tinyshop8_page.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.Goods8JPA;
import qin.tinyshop8_page.dao.GoodsDAO;
import qin.tinyshop8.utils.ShopBasicDAOImpl;

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
}