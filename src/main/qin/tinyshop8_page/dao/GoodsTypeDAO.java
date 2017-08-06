package qin.tinyshop8_page.dao;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import qin.javaee8.core.dao.DAOSupport8;
import qin.javaee8.core.exceptions.dao.DataAccessException;
import qin.tinyshop8.domain8.jpa.GoodsType8JPA;
import qin.tinyshop8.utils.ShopBaseSupport;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * 商品类型jpa数据访问层
 *
 * @author qinzhengying
 * @since 1.8 2017/7/22
 */
public interface GoodsTypeDAO extends DAOSupport8<GoodsType8JPA, Long>,
          ShopBaseSupport
{
    //region 一期 7-22功能

    //region 以html字符串形式将所有的商品类型数据返回

    /**
     * 以html字符串形式将所有的商品类型数据返回
     *
     * @return 返回html代码
     * @throws DataAccessException 如果查询记录失败就抛出大异常
     */
    String showAllType() throws DataAccessException;
    //endregion

    //region 编辑职位

    /**
     * 根据接收的商品类型实体类进行更新
     *
     * @param goodsType8JPA
     */
    void update(GoodsType8JPA goodsType8JPA);

    /**
     * 根据商品类型实体类以及上下级进行更新
     *
     * @param updateGoodsType   需要更新的商品类型实体类(并没有设置上下级)
     * @param parentGoodsTypeId 上级商品类型主键(根据主键查找记录)
     * @param childrenSet       下级商品类型set集合
     */
    void update(GoodsType8JPA updateGoodsType,
                Long parentGoodsTypeId, Set<GoodsType8JPA> childrenSet);

    //endregion

    //region 查找商品主键(根据名称查找)

    /**
     * 查找商品主键(根据名称查找)
     *
     * @param goodsTypeName 商品名称
     * @return 返回主键
     */
    Long getIdByTypeName(String goodsTypeName);
    //endregion

    //region 根据主键查找商品类型信息

    /**
     * 根据主键查找商品类型信息
     *
     * @param id 主键信息
     * @return 返回商品类型实体类
     * @throws DataAccessException 如果主键为空或者查找失败抛出大异常
     */
    GoodsType8JPA getById(Long id) throws DataAccessException;
    //endregion

    //region 重写删除方法, 实现删除失败, 一期不提供删除功能

    //region 封装抛出运行时异常方法

    /**
     * 抛出删除失败异常
     *
     * @return 返回运行时异常
     */
    default RuntimeException throwDeleteException()
    {
        return new RuntimeException("删除失败!");
    }
    //endregion

    /**
     * Delete the given persistent instance.
     * <p>Obtains the specified lock mode if the instance exists, implicitly
     * checking whether the corresponding database entry still exists.
     *
     * @param entity   the persistent instance to delete
     * @param lockMode the lock mode to obtain
     * @throws ObjectOptimisticLockingFailureException if not found
     * @throws DataAccessException                     in case of Hibernate errors
     * @see Session#delete(Object)
     */
    @Override
    default void delete(Object entity, LockMode lockMode) throws org.springframework.dao.DataAccessException
    {
        throwDeleteException();
    }

    /**
     * Delete the given persistent instance.
     *
     * @param entityName the name of the persistent entity
     * @param entity     the persistent instance to delete
     * @throws DataAccessException in case of Hibernate errors
     * @see Session#delete(Object)
     */
    @Override
    default void delete(String entityName, Object entity) throws org.springframework.dao.DataAccessException
    {
        throwDeleteException();
    }

    /**
     * Delete the given persistent instance.
     * <p>Obtains the specified lock mode if the instance exists, implicitly
     * checking whether the corresponding database entry still exists.
     *
     * @param entityName the name of the persistent entity
     * @param entity     the persistent instance to delete
     * @param lockMode   the lock mode to obtain
     * @throws ObjectOptimisticLockingFailureException if not found
     * @throws DataAccessException                     in case of Hibernate errors
     * @see Session#delete(Object)
     */
    @Override
    default void delete(String entityName, Object entity, LockMode lockMode) throws org.springframework.dao.DataAccessException
    {
        throwDeleteException();
    }

    /**
     * Delete all given persistent instances.
     * <p>This can be combined with any of the find methods to delete by query
     * in two lines of code.
     *
     * @param entities the persistent instances to delete
     * @throws DataAccessException in case of Hibernate errors
     * @see Session#delete(Object)
     */
    @Override
    default void deleteAll(Collection<?> entities) throws org.springframework.dao.DataAccessException
    {
        throwDeleteException();
    }

    /**
     * Delete the given persistent instance.<br>
     * 删除实体类
     *
     * @param entity the persistent instance to delete
     * @throws DataAccessException in case of Hibernate errors
     * @see Session#delete(Object)
     */
    @Override
    default void delete(Object entity) throws org.springframework.dao.DataAccessException
    {
        throwDeleteException();
    }

    //endregion

    //region 新增商品类型

    /**
     * 新增商品类型<br>
     * 接收上级类型以及下级类型
     *
     * @param goodsType8  实体类
     * @param parent      上级
     * @param childrenSet 下级
     * @throws DataAccessException 如果发生重复记录就直接抛出大异常
     */
    void add(GoodsType8JPA goodsType8, GoodsType8JPA parent,
             Set<GoodsType8JPA> childrenSet) throws DataAccessException;

    /**
     * Persist the given transient instance.<br>
     * 保存商品类型实体类<br>
     * 在保存之前先要判断此实体类是否是
     * <code>{@link GoodsType8JPA}</code>实体类,
     * 否则就要在catch中进行捕获
     *
     * @param entity the transient instance to persist
     * @return the generated identifier
     * @throws DataAccessException in case of Hibernate errors
     * @see Session#save(Object)
     */
    @Override
    Serializable save(Object entity) throws org.springframework.dao.DataAccessException;

    //endregion

    //endregion


}