package qin.tinyshop8_page.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.jpa.dao.GoodsTypeDAO;
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
        return (List<GoodsType8JPA>) goodsTypeDAO.findAll().getSearchList();
    }
    //endregion
}