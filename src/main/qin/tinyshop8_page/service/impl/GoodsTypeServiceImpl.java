package qin.tinyshop8_page.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.exceptions.dao.EmptyResultDataAccessException;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8_page.dao.GoodsTypeDAO;
import qin.tinyshop8_page.service.GoodsTypeService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/8/5 0005-5.<br/>
 * 商品乐行服务层实现
 *
 * @author qinzhengying
 * @since 1.8 2017/8/5
 */
@Service(value = "_GoodsTypeServiceImpl")
@Transactional
@SuppressWarnings("all")
public class GoodsTypeServiceImpl implements GoodsTypeService
{
    private static final long serialVersionUID = -411428028718188216L;

    //region 注入数据访问层
    private GoodsTypeDAO goodsTypeDAO;

    @Resource
    public void setGoodsTypeDAO(GoodsTypeDAO goodsTypeDAO)
    {
        this.goodsTypeDAO = goodsTypeDAO;
    }
    //endregion

    //region 查询所有商品类型信息

    /**
     * 查询所有商品类型信息
     *
     * @return 返回查询集合
     * @throws DataAccessException 抛出数据访问层大异常
     */
    @Override
    public List<GoodsType8JPA> findAll() throws DataAccessException
    {
        return (List<GoodsType8JPA>) goodsTypeDAO
                  .findAll().getSearchList();
    }
    //endregion

    //region 根据商品类型名称查找商品类型

    /**
     * 根据商品类型名称查找商品类型
     *
     * @param goodsType 商品类型名称
     * @return 返回查询的实体记录
     * @throws DataAccessException 如果没有查询成功就要抛出数据访问层异常
     */
    @Override
    public GoodsType8JPA findGoodsTypeByName(String goodsType)
              throws DataAccessException
    {
        //language=hql
        String queryString = "from GoodsType8JPA where typeName=:goodsType";
        String paramName = "goodsType";
        Object value = goodsType;

        List<GoodsType8JPA> goodsType8JPAList = (List<GoodsType8JPA>)
                  goodsTypeDAO
                            .findByNamedParam(queryString, paramName, value);

        if (goodsType8JPAList.size() != 1)
        {
            throw new
                      EmptyResultDataAccessException("查询商品类型信息失败!");
        }

        return goodsType8JPAList.get(0);
    }

    //endregion

}