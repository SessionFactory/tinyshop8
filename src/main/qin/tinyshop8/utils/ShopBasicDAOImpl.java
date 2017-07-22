package qin.tinyshop8.utils;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import qin.javaee8.core.dao.impl.DAOSupport8Impl;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.javaee8.core.support.SuperEntity8;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * tinyshop顶级数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/7/22
 */
@Repository(value = "tinyshopDAOImpl")
public class ShopBasicDAOImpl<T extends SuperEntity8, ID extends Serializable>
          extends DAOSupport8Impl<T, ID>
{
    private static final long serialVersionUID = 6593422323500756371L;

    //region 提供构造函数
    public ShopBasicDAOImpl() throws Exception
    {
        superLogInfo("正在初始化tinyshop顶级数据访问层类");
    }
    //endregion

    //region 注入数据访问层

    @Resource
    @Override
    public void setSessionFactory(SessionFactory sessionFactory)
    {
        super.setSessionFactory(sessionFactory);
    }

    //endregion

    /**
     * 根据批量主键查询记录, 这个需要子类去实现
     *
     * @param ids 批量主键
     * @return 返回查询结果
     * @author qinzhengying
     * @since 1.8 2017/6/30
     */
    @Override
    public FrameWorkDSCResult findByIds(Serializable[] ids)
    {
        return null;
    }

    /**
     * 获取实体类 类 类型
     *
     * @return 返回获取到的实体类型
     */
    @Override
    public Class<T> getEntityClass()
    {
        return (Class<T>) SuperEntity.class;
    }
}