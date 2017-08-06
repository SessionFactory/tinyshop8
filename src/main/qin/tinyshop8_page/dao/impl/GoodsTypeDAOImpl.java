package qin.tinyshop8_page.dao.impl;

import org.springframework.stereotype.Repository;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.javaee8.core.exceptions.dao.EmptyResultDataAccessException;
import qin.javaee8.core.support.FrameWorkDSCResult;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8_page.dao.GoodsTypeDAO;
import qin.tinyshop8.utils.ShopBasicDAOImpl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/22 0022-22.<br/>
 * 商品类型数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/7/22
 */
@Repository(value = "_GoodsTypeDAOImpl")
@SuppressWarnings("all")
public class GoodsTypeDAOImpl
          extends ShopBasicDAOImpl<GoodsType8JPA, Long>
          implements GoodsTypeDAO
{
    private static final long serialVersionUID = 7289673154080611413L;

    //region 提供构造函数
    public GoodsTypeDAOImpl() throws Exception
    {
        superLogInfo("正在初始化商品类型数据访问层");
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GoodsTypeDAOImpl{");
        sb.append('}');
        return sb.toString();
    }

    //endregion

    //region 一期功能 7-22

    //region 重写findAll方法

    /**
     * 查询表中全部记录
     *
     * @return 返回所有的查询结果
     * @author qinzhengying
     * @since 1.8 2017/7/23
     */
    @Override
    public FrameWorkDSCResult findAll()
    {
        FrameWorkDSCResult result = new FrameWorkDSCResult();

        //根据表中的排序字段进行排序
        List<GoodsType8JPA> goodsType8JPAList = getSession()
                  .createQuery("from GoodsType8JPA order by typeSort asc ")
                  .list();

        //设置查询结果集合
        result.setSearchList(goodsType8JPAList);

        return result;
    }

    //endregion

    //region 以html字符串形式将所有的商品类型数据返回(finished)

    /**
     * 以html字符串形式将所有的商品类型数据返回
     *
     * @return 返回html代码
     * @throws DataAccessException 如果查询记录失败就抛出大异常
     */
    @Override
    public String showAllType() throws DataAccessException
    {
        StringBuilder sb = new StringBuilder();

        //头字符串
        sb
                  .append("            <table class=\"table table-striped\">\n")
                  .append("                <thead>\n")
                  .append("                <tr>\n")
                  .append("                    <th>选择</th>\n")
                  .append("                    <th>操作</th>\n")
                  .append("                    <th>分类名称</th>\n")
                  .append("                    <th>上级分类</th>\n")
                  .append("                    <th>别名</th>\n")
                  .append("                    <th>排序</th>\n")
                  .append("                </tr>\n")
                  .append("                </thead>\n")
                  .append("                <tbody>");

        String[] tableCSS = {"active", "success", "danger", "warning"};

        //查询全部记录
        List<GoodsType8JPA> goodsType8JPAList = (List<GoodsType8JPA>)
                  findAll().getSearchList();

        for (int i = 0; i < goodsType8JPAList.size(); i++)
        {
            GoodsType8JPA goodsType8JPA = goodsType8JPAList.get(i);

            String td_parent = "";
            GoodsType8JPA parent = goodsType8JPA.getParentType();

            if (parent == null)
            {
                td_parent = "对应上级类型为空!";
            }
            else
            {
                td_parent = parent.toString();
            }

            sb.append("                <tr class=\"");
            if (i == 1) sb.append(tableCSS[0]);
            if (i == 2) sb.append(tableCSS[1]);
            if (i == 3)
            {
                sb.append(tableCSS[2]);
            }
            else
            {
                sb.append(tableCSS[3]);
            }
            sb
                      .append("\">\n")
                      .append("                    <td>1</td>\n")
                      .append("                    <td>1</td>\n")
                      .append("                    <td>")
                      .append(goodsType8JPA.getTypeName())
                      .append("</td>\n")
                      .append("                    <td>")
                      .append(td_parent)
                      .append("</td>\n")
                      .append("                    <td>")
                      .append(goodsType8JPA.getTypeAlias())
                      .append("</td>\n")
                      .append("                    <td>")
                      .append(goodsType8JPA.getTypeSort())
                      .append("</td>\n")
                      .append("                </tr>");
        }

        sb.append("                </tbody>\n").append("            </table>");

        return sb.toString();
    }
    //endregion

    //region 根据接收的商品类型实体类进行更新(finished)

    /**
     * 根据接收的商品类型实体类进行更新<br>
     * 是在没有上级和下级的情况下进行更新的
     *
     * @param goodsType8JPA
     */
    @Override
    public void update(GoodsType8JPA goodsType8JPA)
    {
        try
        {
            //设置提示信息
            StringBuilder sb = new StringBuilder()
                      .append(daoStart)
                      .append("in public void update(GoodsType8JPA ")
                      .append(goodsType8JPA)
                      .append(")")
                      .append(daoEnd);

            superLogInfo(sb.toString());

            getSession().update(goodsType8JPA);
            getTransaction().commit();

            superLogInfo("更新商品类型实体类成功!");
        }
        catch (Exception ex)
        {
            printStackTrace(ex);

            try
            {
                superLogInfo(new StringBuilder()
                                       .append("in void update(GoodsType8JPA ")
                                       .append(goodsType8JPA).append(")更新实体失败!").toString());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //endregion

    //region 根据商品类型实体类以及上下级进行更新(finished)

    /**
     * 根据商品类型实体类以及上下级进行更新
     *
     * @param updateGoodsType   需要更新的商品类型实体类(并没有设置上下级)
     * @param parentGoodsTypeId 上级商品类型主键(根据主键查找记录)
     * @param childrenSet       下级商品类型set集合
     */
    @Override
    public void update(GoodsType8JPA updateGoodsType,
                       Long parentGoodsTypeId, Set<GoodsType8JPA> childrenSet)
    {
        try
        {
            //设置提示信息
            StringBuilder sb = new StringBuilder();

            //判断接收的上级以及下级是否为空, 如果为空就直接调用更新方法进行更新
            if (parentGoodsTypeId == null && childrenSet == null)
            {
                update(updateGoodsType);
            }

            //获取上级分类
            GoodsType8JPA parent = getById(parentGoodsTypeId);

            //那么就是不为空
            sb.append(daoStart)
                      .append("in public void update(GoodsType8JPA ")
                      .append(updateGoodsType);

            //这里做判断的原因是保证有上级但不一定有下级
            //有下级不一定有上级

            //判断是否有上级
            if (parent != null)
            {
                sb.append(" 上级分类主键:")
                          .append(parentGoodsTypeId)
                          .append(" 上级分类实体信息:")
                          .append(parent);
                updateGoodsType.setParentType(parent);
                parent.getChildrenSet().add(updateGoodsType);
            }
            //判断是否有下级
            if (childrenSet != null)
            {
                if (childrenSet.size() > 0)
                {
                    sb.append("  Set<GoodsType8JPA> childrenSet=");
                    //updateGoodsType的下级分类是childrenSet
                    updateGoodsType.setChildrenSet(childrenSet);

                    //还要设置上级信息
                    for (Iterator<GoodsType8JPA> it = childrenSet.iterator(); it.hasNext(); )
                    {
                        GoodsType8JPA children = it.next();
                        children.setParentType(updateGoodsType);
                        sb.append(children);
                    }
                }
            }

            sb.append(")").append(daoEnd);

            //执行更新
            getSession().update(updateGoodsType);
            getSession().update(parent);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);

            try
            {
                superLogInfo("根据上下级更新商品类型实体类失败!");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //endregion

    //region 查找商品主键(根据名称查找)(finished)

    /**
     * 查找商品主键(根据名称查找)
     *
     * @param goodsTypeName 商品名称
     * @return 返回主键
     */
    @Override
    public Long getIdByTypeName(String goodsTypeName)
    {
        Long id = 0l;

        try
        {
            //首先判断
            if (!(goodsTypeName.length() > 0))
            {
                throw new DataAccessException("商品类型名称不能为空!");
            }

            //设置提示信息
            StringBuilder sb = new StringBuilder()
                      .append(daoStart)
                      .append("inpublic Long getIdByTypeName(String ")
                      .append(goodsTypeName)
                      .append(")")
                      .append(daoEnd);

            superLogInfo(sb.toString());

            List<Long> goodsType8JPAList = getSession()
                      .createQuery("select id from GoodsType8JPA where typeName=:typeName")
                      .setParameter("typeName", goodsTypeName)
                      .list();

            //判断是否查找成功
            if (goodsType8JPAList.size() == 1)
            {
                id = goodsType8JPAList.get(0);
            }
            else
            {
                throw new
                          EmptyResultDataAccessException("商品类型查询失败!");
            }

        }
        catch (Exception ex)
        {
            printStackTrace(ex);

            superLogInfo("根据商品类型名称查询失败!");

            id = null;
        }
        finally
        {
            return id;
        }
    }
    //endregion

    //region 根据主键查找商品类型信息(finished)

    /**
     * 根据主键查找商品类型信息
     *
     * @param id 主键信息
     * @return 返回商品类型实体类
     * @throws DataAccessException 如果主键为空或者查找失败抛出大异常
     */
    @Override
    public GoodsType8JPA getById(Long id) throws DataAccessException
    {
        GoodsType8JPA goodsType8JPA = null;

        try
        {

            //做判断
            if (id == null)
            {
                throw new DataAccessException("商品类型主键为空, 无法查找!");
            }

            //做提示信息
            StringBuilder msg = new StringBuilder()
                      .append(daoStart)
                      .append("public GoodsType8JPA getById(Long ")
                      .append(id)
                      .append(")")
                      .append(daoEnd);

            superLogInfo(msg);

            goodsType8JPA = getSession().get(getEntityClass(), id);
        }
        catch (Exception ex)
        {
            printStackTrace(ex);
            superLogInfo("根据主键查询商品类型记录失败!");
        }
        finally
        {
            return goodsType8JPA;
        }
    }
    //endregion

    //region 新增商品类型(finished)

    /**
     * 新增商品类型<br>
     * 接收上级类型以及下级类型
     *
     * @param goodsType8  实体类
     * @param parent      上级
     * @param childrenSet 下级
     * @throws DataAccessException 如果发生重复记录就直接抛出大异常
     */
    @Override
    public void add(GoodsType8JPA goodsType8,
                    GoodsType8JPA parent, Set<GoodsType8JPA> childrenSet)
              throws DataAccessException
    {
        try
        {

            //判断是否有上下级
            if (parent.getTypeName() == null && childrenSet.size() == 0)
            {
                getSession().save(goodsType8);
            }

            //设置提示消息
            StringBuilder msg = new StringBuilder()
                      .append(daoStart)
                      .append("in public void add(GoodsType8JPA ")
                      .append(goodsType8);

            //如果有上级
            if (parent.getTypeName() != null)
            {
                msg.append(" GoodsType8JPA ")
                          .append(parent);
                goodsType8.setParentType(parent);
                parent.getChildrenSet().add(goodsType8);
            }

            //有下级
            if (childrenSet != null)
            {
                if (childrenSet.size() > 0)
                {
                    msg.append(" Set<GoodsType8JPA> ");
                    goodsType8.setChildrenSet(childrenSet);

                    for (Iterator<GoodsType8JPA> it = childrenSet.iterator(); it.hasNext(); )
                    {
                        GoodsType8JPA children = it.next();
                        children.setParentType(goodsType8);
                        msg.append(children);
                    }
                }
            }

            msg.append(")").append(daoEnd);

            getSession().save(goodsType8);
            if (parent.getTypeName() != null) getSession().update(parent);
            /*
            String s = "goodsType8.setTypeAlias(\"" + goodsType8.getTypeAlias() + "\");\n" +
                      "            goodsType8.setTypeSort(" + goodsType8.getTypeSort() + ");\n" +
                      "            goodsType8.setTypeName(\"" + goodsType8.getTypeName() + "\");";
            System.out.println(s);
            */
            getTransaction().commit();

            superLogInfo("添加商品类型记录成功!");
        }
        catch (Exception ex)
        {
            printStackTrace(ex);

            try
            {
                superLogInfo("新增商品类型失败!");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    //endregion

    //region 根据批量主键查询记录, 这个需要子类去实现

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
    //endregion

    //region 返回商品实体类 类 类型

    /**
     * 返回商品实体类 类 类型
     *
     * @return 返回获取到的实体类型
     */
    @Override
    public Class<GoodsType8JPA> getEntityClass()
    {
        return GoodsType8JPA.class;
    }
    //endregion


    //endregion
}